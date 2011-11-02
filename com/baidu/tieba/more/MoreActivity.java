package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.write.WriteActivity;
/* loaded from: classes.dex */
public class MoreActivity extends BaseActivity {
    private AlertDialog mFrequencyDialog;
    private AlertDialog mRemindInfoDialog;
    private LinearLayout mAccountManager = null;
    private LinearLayout mFrequency = null;
    private LinearLayout mRemindInfo = null;
    private LinearLayout mClearCash = null;
    private LinearLayout mAbout = null;
    private LinearLayout mPositionPaper = null;
    private TextView mFrequencyTime = null;
    private View.OnClickListener mClickListener = null;
    private String[] mFrequencyMenu = null;
    private ClearAsyncTask mClearTaks = null;
    private String[] mMsgInfoMenu = null;
    private boolean[] mMsgInfoMenuState = {TiebaApplication.app.isMsgReplymeOn(), TiebaApplication.app.isMsgAtmeOn(), TiebaApplication.app.isMsgFansOn()};

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_activity);
        InitData();
        InitUI();
    }

    private void InitData() {
        this.mFrequencyMenu = new String[4];
        this.mFrequencyMenu[0] = getString(R.string.half_minute);
        this.mFrequencyMenu[1] = getString(R.string.tow_minute);
        this.mFrequencyMenu[2] = getString(R.string.five_minute);
        this.mFrequencyMenu[3] = getString(R.string.close_remind);
        this.mMsgInfoMenu = new String[3];
        this.mMsgInfoMenu[0] = getString(R.string.mention_replyme);
        this.mMsgInfoMenu[1] = getString(R.string.mention_atme);
        this.mMsgInfoMenu[2] = getString(R.string.new_fans);
    }

    private void InitUI() {
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != MoreActivity.this.mAccountManager) {
                    if (view != MoreActivity.this.mFrequency) {
                        if (view != MoreActivity.this.mRemindInfo) {
                            if (view == MoreActivity.this.mClearCash) {
                                if (MoreActivity.this.mClearTaks == null) {
                                    MoreActivity.this.mClearTaks = new ClearAsyncTask();
                                    MoreActivity.this.mClearTaks.execute(new String[0]);
                                    return;
                                }
                                return;
                            } else if (view != MoreActivity.this.mAbout) {
                                if (view == MoreActivity.this.mPositionPaper) {
                                    AntiData anti = new AntiData();
                                    anti.setIfpost(1);
                                    WriteActivity.startActivityFeedBack(MoreActivity.this, Config.POSITION_PAGER_ID, Config.POSITION_PAGER_NAME, anti);
                                    return;
                                }
                                return;
                            } else {
                                AboutActivity.startActivity(MoreActivity.this);
                                return;
                            }
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(MoreActivity.this);
                        builder.setTitle(R.string.remind_info);
                        builder.setMultiChoiceItems(MoreActivity.this.mMsgInfoMenu, MoreActivity.this.mMsgInfoMenuState, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.baidu.tieba.more.MoreActivity.1.2
                            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                switch (which) {
                                    case 0:
                                        if (isChecked) {
                                            TiebaApplication.app.setMsgReplymeOn(true);
                                            return;
                                        } else {
                                            TiebaApplication.app.setMsgReplymeOn(false);
                                            return;
                                        }
                                    case 1:
                                        if (isChecked) {
                                            TiebaApplication.app.setMsgAtmeOn(true);
                                            return;
                                        } else {
                                            TiebaApplication.app.setMsgAtmeOn(false);
                                            return;
                                        }
                                    case 2:
                                        if (isChecked) {
                                            TiebaApplication.app.setMsgFansOn(true);
                                            return;
                                        } else {
                                            TiebaApplication.app.setMsgFansOn(false);
                                            return;
                                        }
                                    default:
                                        return;
                                }
                            }
                        });
                        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.more.MoreActivity.1.3
                            @Override // android.content.DialogInterface.OnCancelListener
                            public void onCancel(DialogInterface dialog) {
                                DatabaseService.saveSettingData();
                            }
                        });
                        MoreActivity.this.mRemindInfoDialog = builder.create();
                        MoreActivity.this.mRemindInfoDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mRemindInfoDialog.show();
                        return;
                    }
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(MoreActivity.this);
                    builder2.setTitle(R.string.remind_frequency);
                    builder2.setItems(MoreActivity.this.mFrequencyMenu, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0:
                                    TiebaApplication.app.setMsgFrequency(30);
                                    MoreActivity.this.mRemindInfo.setVisibility(0);
                                    MoreActivity.this.mFrequency.setBackgroundResource(R.drawable.more_up);
                                    break;
                                case 1:
                                    TiebaApplication.app.setMsgFrequency(120);
                                    MoreActivity.this.mRemindInfo.setVisibility(0);
                                    MoreActivity.this.mFrequency.setBackgroundResource(R.drawable.more_up);
                                    break;
                                case 2:
                                    TiebaApplication.app.setMsgFrequency(Config.PHOTO_DELAY_TIME);
                                    MoreActivity.this.mRemindInfo.setVisibility(0);
                                    MoreActivity.this.mFrequency.setBackgroundResource(R.drawable.more_up);
                                    break;
                                case 3:
                                    TiebaApplication.app.setMsgFrequency(0);
                                    MoreActivity.this.mRemindInfo.setVisibility(8);
                                    MoreActivity.this.mFrequency.setBackgroundResource(R.drawable.more_all);
                                    break;
                            }
                            DatabaseService.saveSettingData();
                            MoreActivity.this.updateFrequencyTime();
                        }
                    });
                    MoreActivity.this.mFrequencyDialog = builder2.create();
                    MoreActivity.this.mFrequencyDialog.show();
                    return;
                }
                AccountActivity.startActivity(MoreActivity.this);
            }
        };
        this.mAccountManager = (LinearLayout) findViewById(R.id.account_manager);
        this.mAccountManager.setOnClickListener(this.mClickListener);
        this.mFrequency = (LinearLayout) findViewById(R.id.frequency);
        this.mFrequency.setOnClickListener(this.mClickListener);
        this.mRemindInfo = (LinearLayout) findViewById(R.id.remind_info);
        this.mRemindInfo.setOnClickListener(this.mClickListener);
        this.mClearCash = (LinearLayout) findViewById(R.id.clear_cash);
        this.mClearCash.setOnClickListener(this.mClickListener);
        this.mAbout = (LinearLayout) findViewById(R.id.about_bieta);
        this.mAbout.setOnClickListener(this.mClickListener);
        this.mPositionPaper = (LinearLayout) findViewById(R.id.position_paper);
        this.mPositionPaper.setOnClickListener(this.mClickListener);
        this.mFrequencyTime = (TextView) findViewById(R.id.frequency_time);
        updateFrequencyTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFrequencyTime() {
        if (TiebaApplication.app.getMsgFrequency() <= 0) {
            this.mFrequencyTime.setText(R.string.close);
            this.mRemindInfo.setVisibility(8);
            this.mFrequency.setBackgroundResource(R.drawable.more_all);
        } else if (TiebaApplication.app.getMsgFrequency() == 30) {
            this.mFrequencyTime.setText(R.string.half_minute);
        } else if (TiebaApplication.app.getMsgFrequency() == 120) {
            this.mFrequencyTime.setText(R.string.tow_minute);
        } else {
            this.mFrequencyTime.setText(R.string.five_minute);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            quitDialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /* loaded from: classes.dex */
    private class ClearAsyncTask extends AsyncTask<String, Integer, String> {
        private ClearAsyncTask() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((ClearAsyncTask) result);
            MoreActivity.this.mClearTaks = null;
            MoreActivity.this.closeLoadingDialog();
            MoreActivity.this.showToast(MoreActivity.this.getString(R.string.image_cash_del_suc));
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            MoreActivity.this.showLoadingDialog(MoreActivity.this.getString(R.string.deleting));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... arg0) {
            DatabaseService.deletSdDatebase();
            return null;
        }
    }

    public void closeMenuDialog() {
        if (this.mFrequencyDialog != null) {
            this.mFrequencyDialog.dismiss();
        }
        if (this.mRemindInfoDialog != null) {
            this.mRemindInfoDialog.dismiss();
        }
    }
}
