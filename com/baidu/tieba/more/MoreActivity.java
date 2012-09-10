package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.write.WriteActivity;
import java.io.File;
/* loaded from: classes.dex */
public class MoreActivity extends BaseActivity {
    private AlertDialog mFontSizeDialog;
    private AlertDialog mFrequencyDialog;
    private AlertDialog mImageQualityDialog;
    private AlertDialog mRemindInfoDialog;
    private AlertDialog mRemindToneDialog;
    private AlertDialog mViewImageQualityDialog;
    private AlertDialog mViewImagesDialog;
    private LinearLayout mAccountManager = null;
    private LinearLayout mFrequency = null;
    private LinearLayout mRemindInfo = null;
    private LinearLayout mClearCash = null;
    private LinearLayout mImageQuality = null;
    private LinearLayout mViewImageQuality = null;
    private LinearLayout mViewImages = null;
    private LinearLayout mFontSize = null;
    private LinearLayout mAbout = null;
    private LinearLayout mPositionPaper = null;
    private LinearLayout mRemindTone = null;
    private TextView mFrequencyTime = null;
    private TextView mRemindToneInfo = null;
    private TextView mImageQualityInfo = null;
    private TextView mViewImageQualityInfo = null;
    private TextView mFontSizeInfo = null;
    private TextView mViewImagesInfo = null;
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
                switch (view.getId()) {
                    case R.id.account_manager /* 2131362003 */:
                        AccountActivity.startActivity(MoreActivity.this);
                        return;
                    case R.id.account_name /* 2131362004 */:
                    case R.id.arrow /* 2131362005 */:
                    case R.id.frequency_time /* 2131362007 */:
                    case R.id.text_remind_tone /* 2131362010 */:
                    case R.id.text_upload_image_quality /* 2131362012 */:
                    case R.id.text_view_images /* 2131362014 */:
                    case R.id.text_view_images_quality /* 2131362016 */:
                    case R.id.text_font_size /* 2131362018 */:
                    default:
                        return;
                    case R.id.frequency /* 2131362006 */:
                        AlertDialog.Builder builder = new AlertDialog.Builder(MoreActivity.this);
                        builder.setTitle(R.string.remind_frequency);
                        builder.setItems(MoreActivity.this.mFrequencyMenu, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        TiebaApplication.app.setMsgFrequency(30);
                                        MoreActivity.this.mRemindInfo.setVisibility(0);
                                        MoreActivity.this.mRemindTone.setVisibility(0);
                                        MoreActivity.this.mFrequency.setBackgroundResource(R.drawable.more_up);
                                        break;
                                    case 1:
                                        TiebaApplication.app.setMsgFrequency(Config.PB_IMAGE_MAX_HEIGHT);
                                        MoreActivity.this.mRemindInfo.setVisibility(0);
                                        MoreActivity.this.mRemindTone.setVisibility(0);
                                        MoreActivity.this.mFrequency.setBackgroundResource(R.drawable.more_up);
                                        break;
                                    case 2:
                                        TiebaApplication.app.setMsgFrequency(300);
                                        MoreActivity.this.mRemindInfo.setVisibility(0);
                                        MoreActivity.this.mRemindTone.setVisibility(0);
                                        MoreActivity.this.mFrequency.setBackgroundResource(R.drawable.more_up);
                                        break;
                                    case 3:
                                        TiebaApplication.app.setMsgFrequency(0);
                                        MoreActivity.this.mRemindInfo.setVisibility(8);
                                        MoreActivity.this.mRemindTone.setVisibility(8);
                                        MoreActivity.this.mFrequency.setBackgroundResource(R.drawable.more_all);
                                        break;
                                }
                                DatabaseService.saveSettingData();
                                MoreActivity.this.updateFrequencyTime();
                            }
                        });
                        MoreActivity.this.mFrequencyDialog = builder.create();
                        MoreActivity.this.mFrequencyDialog.show();
                        return;
                    case R.id.remind_info /* 2131362008 */:
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(MoreActivity.this);
                        builder2.setTitle(R.string.remind_info);
                        builder2.setMultiChoiceItems(MoreActivity.this.mMsgInfoMenu, MoreActivity.this.mMsgInfoMenuState, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.baidu.tieba.more.MoreActivity.1.2
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
                        builder2.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.more.MoreActivity.1.3
                            @Override // android.content.DialogInterface.OnCancelListener
                            public void onCancel(DialogInterface dialog) {
                                DatabaseService.saveSettingData();
                            }
                        });
                        MoreActivity.this.mRemindInfoDialog = builder2.create();
                        MoreActivity.this.mRemindInfoDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mRemindInfoDialog.show();
                        return;
                    case R.id.remind_tone /* 2131362009 */:
                        MoreActivity.this.mRemindToneDialog = new AlertDialog.Builder(MoreActivity.this).setTitle(R.string.remind_tone).setItems(R.array.menu_remind_tone, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.1.7
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        TiebaApplication.app.setMsgTone(true);
                                        break;
                                    case 1:
                                        TiebaApplication.app.setMsgTone(false);
                                        break;
                                }
                                MoreActivity.this.updateRemindTone();
                            }
                        }).create();
                        MoreActivity.this.mRemindToneDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mRemindToneDialog.show();
                        return;
                    case R.id.upload_image_quality /* 2131362011 */:
                        SpannableString qualityHigh = new SpannableString(MoreActivity.this.getString(R.string.image_quality_high_menu));
                        qualityHigh.setSpan(new AbsoluteSizeSpan(UtilHelper.dip2px(MoreActivity.this, 16.0f)), 1, qualityHigh.length(), 18);
                        SpannableString qualityLow = new SpannableString(MoreActivity.this.getString(R.string.image_quality_low_menu));
                        qualityLow.setSpan(new AbsoluteSizeSpan(UtilHelper.dip2px(MoreActivity.this, 16.0f)), 1, qualityLow.length(), 18);
                        CharSequence[] menuViewImageQuality = {qualityHigh, MoreActivity.this.getString(R.string.image_quality_mid_menu), qualityLow};
                        MoreActivity.this.mImageQualityDialog = new AlertDialog.Builder(MoreActivity.this).setTitle(R.string.upload_image_quality).setItems(menuViewImageQuality, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.1.5
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        TiebaApplication.app.setUploadImageQuality(1);
                                        break;
                                    case 1:
                                        TiebaApplication.app.setUploadImageQuality(2);
                                        break;
                                    case 2:
                                        TiebaApplication.app.setUploadImageQuality(3);
                                        break;
                                }
                                MoreActivity.this.updateImageQuality();
                            }
                        }).create();
                        MoreActivity.this.mImageQualityDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mImageQualityDialog.show();
                        return;
                    case R.id.view_images /* 2131362013 */:
                        MoreActivity.this.mViewImagesDialog = new AlertDialog.Builder(MoreActivity.this).setTitle(R.string.view_images).setItems(R.array.menu_view_images, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.1.8
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        TiebaApplication.app.setShowImages(true);
                                        break;
                                    case 1:
                                        TiebaApplication.app.setShowImages(false);
                                        break;
                                }
                                MoreActivity.this.updateIsShowImages();
                            }
                        }).create();
                        MoreActivity.this.mViewImagesDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mViewImagesDialog.show();
                        return;
                    case R.id.view_images_quality /* 2131362015 */:
                        SpannableString viewQualityHigh = new SpannableString(MoreActivity.this.getString(R.string.view_image_quality_high_menu));
                        viewQualityHigh.setSpan(new AbsoluteSizeSpan(UtilHelper.dip2px(MoreActivity.this, 16.0f)), 1, viewQualityHigh.length(), 18);
                        SpannableString viewQualityLow = new SpannableString(MoreActivity.this.getString(R.string.view_image_quality_low_menu));
                        viewQualityLow.setSpan(new AbsoluteSizeSpan(UtilHelper.dip2px(MoreActivity.this, 16.0f)), 1, viewQualityLow.length(), 18);
                        CharSequence[] menuImageQuality = {viewQualityHigh, viewQualityLow};
                        MoreActivity.this.mViewImageQualityDialog = new AlertDialog.Builder(MoreActivity.this).setTitle(R.string.view_images_quality).setItems(menuImageQuality, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.1.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        TiebaApplication.app.setViewImageQuality(1);
                                        break;
                                    case 1:
                                        TiebaApplication.app.setViewImageQuality(2);
                                        break;
                                }
                                MoreActivity.this.updateViewImageQuality();
                            }
                        }).create();
                        MoreActivity.this.mViewImageQualityDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mViewImageQualityDialog.show();
                        return;
                    case R.id.font_size /* 2131362017 */:
                        SpannableString fontBig = new SpannableString(MoreActivity.this.getString(R.string.font_size_big));
                        fontBig.setSpan(new AbsoluteSizeSpan(UtilHelper.dip2px(MoreActivity.this, 18.0f)), 0, fontBig.length(), 18);
                        SpannableString fontMid = new SpannableString(MoreActivity.this.getString(R.string.font_size_mid));
                        fontMid.setSpan(new AbsoluteSizeSpan(UtilHelper.dip2px(MoreActivity.this, 17.0f)), 0, fontMid.length(), 18);
                        SpannableString fontSmall = new SpannableString(MoreActivity.this.getString(R.string.font_size_small));
                        fontSmall.setSpan(new AbsoluteSizeSpan(UtilHelper.dip2px(MoreActivity.this, 16.0f)), 0, fontSmall.length(), 18);
                        CharSequence[] menuFontSize = {fontBig, fontMid, fontSmall};
                        MoreActivity.this.mFontSizeDialog = new AlertDialog.Builder(MoreActivity.this).setTitle(R.string.font_size).setItems(menuFontSize, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.more.MoreActivity.1.6
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        TiebaApplication.app.setFontSize(1);
                                        break;
                                    case 1:
                                        TiebaApplication.app.setFontSize(2);
                                        break;
                                    case 2:
                                        TiebaApplication.app.setFontSize(3);
                                        break;
                                }
                                MoreActivity.this.updateFontSize();
                            }
                        }).create();
                        MoreActivity.this.mFontSizeDialog.setCanceledOnTouchOutside(true);
                        MoreActivity.this.mFontSizeDialog.show();
                        return;
                    case R.id.clear_cash /* 2131362019 */:
                        if (MoreActivity.this.mClearTaks == null) {
                            MoreActivity.this.mClearTaks = new ClearAsyncTask(MoreActivity.this, null);
                            MoreActivity.this.mClearTaks.execute(new String[0]);
                            return;
                        }
                        return;
                    case R.id.about_bieta /* 2131362020 */:
                        AboutActivity.startActivity(MoreActivity.this);
                        return;
                    case R.id.position_paper /* 2131362021 */:
                        AntiData anti = new AntiData();
                        anti.setIfpost(1);
                        WriteActivity.startActivityFeedBack(MoreActivity.this, Config.POSITION_PAGER_ID, Config.POSITION_PAGER_NAME, anti);
                        return;
                }
            }
        };
        this.mAccountManager = (LinearLayout) findViewById(R.id.account_manager);
        if (TiebaApplication.isBaiduAccountManager()) {
            this.mAccountManager.setFocusable(false);
            this.mAccountManager.setClickable(false);
            TextView accountText = (TextView) findViewById(R.id.account_name);
            accountText.setText(TiebaApplication.getCurrentAccountName());
            ImageView image = (ImageView) findViewById(R.id.arrow);
            image.setVisibility(8);
        } else {
            this.mAccountManager.setOnClickListener(this.mClickListener);
        }
        this.mFrequency = (LinearLayout) findViewById(R.id.frequency);
        this.mFrequency.setOnClickListener(this.mClickListener);
        this.mRemindInfo = (LinearLayout) findViewById(R.id.remind_info);
        this.mRemindInfo.setOnClickListener(this.mClickListener);
        this.mRemindTone = (LinearLayout) findViewById(R.id.remind_tone);
        this.mRemindTone.setOnClickListener(this.mClickListener);
        this.mClearCash = (LinearLayout) findViewById(R.id.clear_cash);
        this.mClearCash.setOnClickListener(this.mClickListener);
        this.mAbout = (LinearLayout) findViewById(R.id.about_bieta);
        this.mAbout.setOnClickListener(this.mClickListener);
        this.mPositionPaper = (LinearLayout) findViewById(R.id.position_paper);
        this.mPositionPaper.setOnClickListener(this.mClickListener);
        this.mFrequencyTime = (TextView) findViewById(R.id.frequency_time);
        this.mRemindToneInfo = (TextView) findViewById(R.id.text_remind_tone);
        this.mViewImageQuality = (LinearLayout) findViewById(R.id.view_images_quality);
        this.mViewImageQuality.setOnClickListener(this.mClickListener);
        this.mImageQuality = (LinearLayout) findViewById(R.id.upload_image_quality);
        this.mImageQuality.setOnClickListener(this.mClickListener);
        this.mViewImages = (LinearLayout) findViewById(R.id.view_images);
        this.mViewImages.setOnClickListener(this.mClickListener);
        this.mFontSize = (LinearLayout) findViewById(R.id.font_size);
        this.mFontSize.setOnClickListener(this.mClickListener);
        this.mImageQualityInfo = (TextView) findViewById(R.id.text_upload_image_quality);
        this.mViewImageQualityInfo = (TextView) findViewById(R.id.text_view_images_quality);
        this.mViewImagesInfo = (TextView) findViewById(R.id.text_view_images);
        this.mFontSizeInfo = (TextView) findViewById(R.id.text_font_size);
        updateFrequencyTime();
        updateImageQuality();
        updateIsShowImages();
        updateFontSize();
        updateRemindTone();
        updateViewImageQuality();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFrequencyTime() {
        if (TiebaApplication.app.getMsgFrequency() <= 0) {
            this.mFrequencyTime.setText(R.string.close);
            this.mRemindInfo.setVisibility(8);
            this.mRemindTone.setVisibility(8);
            this.mFrequency.setBackgroundResource(R.drawable.more_all);
        } else if (TiebaApplication.app.getMsgFrequency() == 30) {
            this.mFrequencyTime.setText(R.string.half_minute);
        } else if (TiebaApplication.app.getMsgFrequency() == 120) {
            this.mFrequencyTime.setText(R.string.tow_minute);
        } else {
            this.mFrequencyTime.setText(R.string.five_minute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemindTone() {
        if (TiebaApplication.app.isMsgToneOn()) {
            this.mRemindToneInfo.setText(getString(R.string.remind_tone_open));
        } else {
            this.mRemindToneInfo.setText(getString(R.string.remind_tone_close));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateImageQuality() {
        switch (TiebaApplication.app.getUploadImageQuality()) {
            case 1:
                this.mImageQualityInfo.setText(getString(R.string.image_quality_high));
                return;
            case 2:
                this.mImageQualityInfo.setText(getString(R.string.image_quality_mid));
                return;
            case 3:
                this.mImageQualityInfo.setText(getString(R.string.image_quality_low));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewImageQuality() {
        switch (TiebaApplication.app.getViewImageQuality()) {
            case 1:
                this.mViewImageQualityInfo.setText(getString(R.string.image_quality_high));
                return;
            case 2:
                this.mViewImageQualityInfo.setText(getString(R.string.image_quality_low));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIsShowImages() {
        if (TiebaApplication.app.isShowImages()) {
            this.mViewImagesInfo.setText(getString(R.string.view_images_open));
        } else {
            this.mViewImagesInfo.setText(getString(R.string.view_images_close));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFontSize() {
        switch (TiebaApplication.app.getFontSize()) {
            case 1:
                this.mFontSizeInfo.setText(getString(R.string.font_size_big));
                return;
            case 2:
                this.mFontSizeInfo.setText(getString(R.string.font_size_mid));
                return;
            case 3:
                this.mFontSizeInfo.setText(getString(R.string.font_size_small));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    private class ClearAsyncTask extends AsyncTask<String, Integer, String> {
        private ClearAsyncTask() {
        }

        /* synthetic */ ClearAsyncTask(MoreActivity moreActivity, ClearAsyncTask clearAsyncTask) {
            this();
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
            try {
                File file = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + Config.TMP_PIC_DIR_NAME + "/");
                File[] list = file.listFiles();
                if (list != null) {
                    for (File file2 : list) {
                        file2.delete();
                    }
                }
                File[] fileArr = null;
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
            }
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
        if (this.mImageQualityDialog != null) {
            this.mImageQualityDialog.dismiss();
        }
        if (this.mViewImagesDialog != null) {
            this.mViewImagesDialog.dismiss();
        }
        if (this.mFontSizeDialog != null) {
            this.mFontSizeDialog.dismiss();
        }
    }
}
