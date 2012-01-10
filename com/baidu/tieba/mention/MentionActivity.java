package com.baidu.tieba.mention;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.mention.MentionView;
import com.baidu.tieba.model.MentionModel;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.write.WriteActivity;
/* loaded from: classes.dex */
public class MentionActivity extends BaseActivity {
    private static final int MENU_ID_ABOUT = 4;
    private static final int MENU_ID_ACCOUNT = 2;
    private static final int MENU_ID_FEEDBACK = 3;
    private static final int MENU_ID_QUIT = 5;
    private static final int MENU_ID_SETUP = 1;
    public static final int PAGE_TYPE_ATME = 1;
    public static final int PAGE_TYPE_REPLYME = 0;
    public static final String TYPE = "type";
    private int mPageType;
    private Button mButtonAtme = null;
    private Button mButtonReplyme = null;
    private MentionView mViewReplyme = null;
    private MentionView mViewAtme = null;
    private TextView mTextNoReply = null;
    private TextView mTextNoAt = null;
    private UpdateReceiver receiver = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mention_activity);
        regReceiver();
        initUI();
        if (savedInstanceState != null) {
            this.mPageType = savedInstanceState.getInt(TYPE, 0);
            return;
        }
        Intent intent = getIntent();
        this.mPageType = intent.getIntExtra(TYPE, 0);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (TiebaApplication.app.getMsgReplyme() > 0) {
            this.mPageType = 0;
            this.mViewReplyme.setUpdateType(2);
            this.mViewReplyme.show();
        } else if (TiebaApplication.app.getMsgAtme() > 0) {
            this.mPageType = 1;
            this.mViewAtme.setUpdateType(2);
            this.mViewAtme.show();
        } else {
            switch (this.mPageType) {
                case 0:
                    this.mViewReplyme.setUpdateType(1);
                    this.mViewReplyme.show();
                    this.mViewReplyme.checkFontConfig();
                    return;
                case 1:
                    this.mViewAtme.setUpdateType(1);
                    this.mViewAtme.show();
                    this.mViewAtme.checkFontConfig();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        try {
            if (this.mViewReplyme != null) {
                this.mViewReplyme.cancelAsyncTask();
                this.mViewReplyme.releaseProgressBar();
            }
            if (this.mViewAtme != null) {
                this.mViewAtme.cancelAsyncTask();
                this.mViewAtme.releaseProgressBar();
            }
            System.gc();
        } catch (Exception e) {
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(TYPE, this.mPageType);
    }

    public int getPageType() {
        return this.mPageType;
    }

    private void initUI() {
        this.mPageType = 0;
        this.mTextNoReply = (TextView) findViewById(R.id.reply_nodata);
        this.mTextNoAt = (TextView) findViewById(R.id.at_nodata);
        this.mButtonReplyme = (Button) findViewById(R.id.mention_bt_replyme);
        this.mButtonReplyme.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mention.MentionActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MentionActivity.this.mPageType = 0;
                if (TiebaApplication.app.getMsgReplyme() > 0) {
                    MentionActivity.this.mViewReplyme.setUpdateType(2);
                } else {
                    MentionActivity.this.mViewReplyme.setUpdateType(1);
                }
                MentionActivity.this.mTextNoAt.setVisibility(8);
                MentionActivity.this.mTextNoReply.setVisibility(0);
                MentionActivity.this.mViewReplyme.show();
                if (MentionActivity.this.mViewAtme != null) {
                    MentionActivity.this.mViewAtme.cancelAsyncTask();
                    MentionActivity.this.mViewAtme.releaseProgressBar();
                }
            }
        });
        this.mButtonAtme = (Button) findViewById(R.id.mention_bt_atme);
        this.mButtonAtme.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mention.MentionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MentionActivity.this.mPageType = 1;
                if (TiebaApplication.app.getMsgAtme() > 0) {
                    MentionActivity.this.mViewAtme.setUpdateType(2);
                } else {
                    MentionActivity.this.mViewAtme.setUpdateType(1);
                }
                MentionActivity.this.mTextNoReply.setVisibility(8);
                MentionActivity.this.mTextNoAt.setVisibility(0);
                MentionActivity.this.mViewAtme.show();
                if (MentionActivity.this.mViewReplyme != null) {
                    MentionActivity.this.mViewReplyme.cancelAsyncTask();
                    MentionActivity.this.mViewReplyme.releaseProgressBar();
                }
            }
        });
        this.mViewReplyme = new MentionView(this, 0, new MentionView.CacheCallback() { // from class: com.baidu.tieba.mention.MentionActivity.3
            @Override // com.baidu.tieba.mention.MentionView.CacheCallback
            public void set(String data) {
                DatabaseService.cashReplymeData(data);
            }

            @Override // com.baidu.tieba.mention.MentionView.CacheCallback
            public String get() {
                return DatabaseService.getReplymeData();
            }

            @Override // com.baidu.tieba.mention.MentionView.CacheCallback
            public void delete() {
                DatabaseService.delReplymeData();
            }
        });
        ListView list1 = (ListView) findViewById(R.id.mention_lv_replyme);
        this.mViewReplyme.setListView(list1);
        ProgressBar progress1 = (ProgressBar) findViewById(R.id.mention_progress_replyme);
        this.mViewReplyme.setProgressBar(progress1);
        FrameLayout layout1 = (FrameLayout) findViewById(R.id.mention_layout_replyme);
        this.mViewReplyme.setLayout(layout1);
        this.mViewReplyme.setNoDataText(R.string.mention_replyme_nodata);
        this.mViewReplyme.setTextNoData(this.mTextNoReply);
        this.mViewReplyme.setURL(Config.REPLYME_ADDRESS);
        this.mViewReplyme.init();
        this.mViewAtme = new MentionView(this, 1, new MentionView.CacheCallback() { // from class: com.baidu.tieba.mention.MentionActivity.4
            @Override // com.baidu.tieba.mention.MentionView.CacheCallback
            public void set(String data) {
                DatabaseService.cashAtmeData(data);
            }

            @Override // com.baidu.tieba.mention.MentionView.CacheCallback
            public String get() {
                return DatabaseService.getAtmeData();
            }

            @Override // com.baidu.tieba.mention.MentionView.CacheCallback
            public void delete() {
                DatabaseService.delAtmeData();
            }
        });
        ListView list2 = (ListView) findViewById(R.id.mention_lv_atme);
        this.mViewAtme.setListView(list2);
        ProgressBar progress2 = (ProgressBar) findViewById(R.id.mention_progress_atme);
        this.mViewAtme.setProgressBar(progress2);
        FrameLayout layout2 = (FrameLayout) findViewById(R.id.mention_layout_atme);
        this.mViewAtme.setLayout(layout2);
        this.mViewAtme.setNoDataText(R.string.mention_atme_nodata);
        this.mViewAtme.setTextNoData(this.mTextNoAt);
        this.mViewAtme.setURL(Config.ATME_ADDRESS);
        this.mViewAtme.init();
    }

    public void showButton() {
        if (this.mPageType == 0) {
            this.mViewReplyme.getLayout().setVisibility(0);
            this.mViewAtme.getLayout().setVisibility(8);
            this.mButtonReplyme.setClickable(false);
            this.mButtonReplyme.setBackgroundResource(R.drawable.home_topbar_bt);
            this.mButtonReplyme.setTextColor(-1);
            this.mButtonAtme.setClickable(true);
            this.mButtonAtme.setBackgroundDrawable(null);
            this.mButtonAtme.setTextColor(-7294977);
        } else if (this.mPageType == 1) {
            this.mViewReplyme.getLayout().setVisibility(8);
            this.mViewAtme.getLayout().setVisibility(0);
            this.mButtonReplyme.setClickable(true);
            this.mButtonReplyme.setBackgroundDrawable(null);
            this.mButtonReplyme.setTextColor(-7294977);
            this.mButtonAtme.setClickable(false);
            this.mButtonAtme.setBackgroundResource(R.drawable.home_topbar_bt);
            this.mButtonAtme.setTextColor(-1);
        }
    }

    public void showMsg(int pageType, boolean needRefresh) {
        long replyme = TiebaApplication.app.getMsgReplyme();
        long atme = TiebaApplication.app.getMsgAtme();
        if (needRefresh) {
            switch (pageType) {
                case 0:
                    refreshMsg(0L, atme);
                    TiebaApplication.app.setMsgReplyme(0L);
                    return;
                case 1:
                    refreshMsg(replyme, 0L);
                    TiebaApplication.app.setMsgAtme(0L);
                    return;
                default:
                    return;
            }
        }
        refreshMsg(replyme, atme);
    }

    public void refreshMsgNumByTalk(MentionModel model) {
        if (this.mPageType == 0) {
            this.mButtonReplyme.setText(R.string.mention_replyme);
            if (model != null) {
                long num = model.getMessage().getAtme();
                StringBuffer msg = new StringBuffer(40);
                msg.append(getText(R.string.mention_atme));
                msg.append('(');
                msg.append(num);
                msg.append(')');
                this.mButtonAtme.setText(msg);
            }
        } else if (this.mPageType == 1) {
            this.mButtonAtme.setText(R.string.mention_atme);
            if (model != null) {
                long num2 = model.getMessage().getReplyme();
                StringBuffer msg2 = new StringBuffer(40);
                msg2.append(getText(R.string.mention_replyme));
                msg2.append('(');
                msg2.append(num2);
                msg2.append(')');
                this.mButtonReplyme.setText(msg2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshMsg(long replyme, long atme) {
        if (replyme > 0) {
            String s = String.format("%s(%s)", getString(R.string.mention_replyme), String.valueOf(replyme));
            this.mButtonReplyme.setText(s);
        } else {
            this.mButtonReplyme.setText(R.string.mention_replyme);
        }
        if (atme > 0) {
            String s2 = String.format("%s(%s)", getString(R.string.mention_atme), String.valueOf(atme));
            this.mButtonAtme.setText(s2);
            return;
        }
        this.mButtonAtme.setText(R.string.mention_atme);
    }

    public void closeMenuDialog() {
        if (this.mViewAtme != null) {
            this.mViewAtme.closeMenuDialog();
        }
        if (this.mViewReplyme != null) {
            this.mViewReplyme.closeMenuDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class UpdateReceiver extends BroadcastReceiver {
        private UpdateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long r = intent.getLongExtra(Config.BROADCAST_RELAY_ME_NUM, 0L);
            long a = intent.getLongExtra(Config.BROADCAST_AT_ME_NUM, 0L);
            MentionActivity.this.refreshMsg(r, a);
        }
    }

    private void regReceiver() {
        this.receiver = new UpdateReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Config.BROADCAST_NOTIFY);
        registerReceiver(this.receiver, filter);
    }

    private void unregReceiver() {
        if (this.receiver != null) {
            unregisterReceiver(this.receiver);
        }
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            MenuItem item = menu.findItem(1);
            item.setVisible(true);
            MenuItem item2 = menu.findItem(2);
            item2.setVisible(true);
            MenuItem item3 = menu.findItem(3);
            item3.setVisible(true);
            MenuItem item4 = menu.findItem(4);
            item4.setVisible(true);
            MenuItem item5 = menu.findItem(5);
            item5.setVisible(true);
        } catch (Exception ex) {
            TiebaLog.e("HomeActivity", "onPrepareOptionsMenu", "exp: " + ex.toString());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, getString(R.string.setup)).setIcon(R.drawable.menu_setup);
        menu.add(0, 2, 2, getString(R.string.account)).setIcon(R.drawable.menu_account);
        menu.add(0, 3, 3, getString(R.string.feedback)).setIcon(R.drawable.menu_feedback);
        menu.add(0, 4, 4, getString(R.string.about)).setIcon(R.drawable.menu_about);
        menu.add(0, 5, 5, getString(R.string.quit)).setIcon(R.drawable.menu_quit);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                MainTabActivity.startActivity(this, MainTabActivity.GOTO_MORE);
                break;
            case 2:
                AccountActivity.startActivity(this);
                break;
            case 3:
                AntiData anti = new AntiData();
                anti.setIfpost(1);
                WriteActivity.startActivityFeedBack(this, Config.POSITION_PAGER_ID, Config.POSITION_PAGER_NAME, anti);
                break;
            case 4:
                AboutActivity.startActivity(this);
                break;
            case 5:
                quitDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
