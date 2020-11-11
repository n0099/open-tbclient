package com.baidu.tieba.lc;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.clientupdate.ClientUpdater;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.download.Download;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.clientupdate.download.DownloadState;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class LcUpdateDialogActivity extends BaseActivity<LcUpdateDialogActivity> implements View.OnClickListener {
    private TextView dGm;
    private TextView efP;
    private View kCA;
    private TextView kCB;
    private Download kCC;
    private String kCt;
    private ClientUpdateInfo kCw;
    private LinearLayout kCx;
    private LinearLayout kCy;
    private View kCz;
    private TextView mDescView;
    private PermissionJudgePolicy mPermissionJudgement;
    private TextView mTitleView;
    private int mSkinType = 3;
    private long kCD = -1;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.lc.LcUpdateDialogActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LcUpdateDialogActivity.this.kCC = (Download) intent.getSerializableExtra("download");
            if (LcUpdateDialogActivity.this.kCC != null && LcUpdateDialogActivity.this.kCC.mSourceKey != null && LcUpdateDialogActivity.this.kCC.mSourceKey.contains(LcUpdateDialogActivity.this.getApplicationContext().getPackageName())) {
                LcUpdateDialogActivity.this.kCD = LcUpdateDialogActivity.this.kCC.mId;
                if (DownloadManager.ACTION_DOWNLOAD_PROGRESS_CHANGE.equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("progress", 0);
                    LcUpdateDialogActivity.this.dGm.setVisibility(0);
                    LcUpdateDialogActivity.this.dGm.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.lc_app_downloading), String.valueOf(intExtra)));
                } else if (DownloadManager.ACTION_DOWNLOAD_STATUS_CHANGE.equals(intent.getAction())) {
                    TbadkCoreApplication.saveClientId(LcUpdateDialogActivity.this, String.valueOf(LcUpdateDialogActivity.this.kCD));
                    TbadkCoreApplication.setClientId(String.valueOf(LcUpdateDialogActivity.this.kCD));
                    if (DownloadState.FINISH == LcUpdateDialogActivity.this.kCC.getState()) {
                        String str = LcUpdateDialogActivity.this.kCC.mSavedPath + "/" + LcUpdateDialogActivity.this.kCC.mFileName;
                        LcUpdateDialogActivity.this.finish();
                    } else if (DownloadState.DOWNLOADING != LcUpdateDialogActivity.this.kCC.getState() && DownloadState.PAUSE != LcUpdateDialogActivity.this.kCC.getState() && DownloadState.CANCEL == LcUpdateDialogActivity.this.kCC.getState()) {
                        Toast.makeText(LcUpdateDialogActivity.this.getApplicationContext(), LcUpdateDialogActivity.this.kCC.mFileName + ": 已删除", 1).show();
                    }
                } else if (DownloadManager.ACTION_DOWNLOAD_MERGE_STATUS.equals(intent.getAction())) {
                    if (DownloadState.MEAGESTART == LcUpdateDialogActivity.this.kCC.getState() || DownloadState.MEAGEEND != LcUpdateDialogActivity.this.kCC.getState()) {
                    }
                } else if ("com.baidu.clientupdate.RSA.STATUS_FAIL".equals(intent.getAction())) {
                    Toast.makeText(LcUpdateDialogActivity.this.getApplicationContext(), "安装包存在被劫持风险，已删除", 1).show();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_lc_update_layout);
        initData(bundle);
        initView();
        registerReceiver();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.kCw = (ClientUpdateInfo) bundle.getSerializable(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA);
            this.kCt = bundle.getString(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.kCw = (ClientUpdateInfo) intent.getSerializableExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA);
            this.kCt = intent.getStringExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA);
        }
    }

    private void initView() {
        this.kCx = (LinearLayout) findViewById(R.id.lc_update_trans_bg);
        this.kCy = (LinearLayout) findViewById(R.id.lc_update_bg);
        this.mTitleView = (TextView) findViewById(R.id.lc_update_title);
        this.mDescView = (TextView) findViewById(R.id.lc_update_desc);
        this.kCz = findViewById(R.id.lc_update_content_divider);
        this.efP = (TextView) findViewById(R.id.lc_update_cancel);
        this.kCA = findViewById(R.id.lc_update_button_divider);
        this.kCB = (TextView) findViewById(R.id.lc_update_confirm);
        this.dGm = (TextView) findViewById(R.id.lc_update_progress);
        this.kCx.setBackgroundColor(Color.parseColor("#A8000000"));
        if (this.kCw != null) {
            this.mDescView.setText(this.kCw.mChangelog);
        }
        this.efP.setOnClickListener(this);
        this.kCB.setOnClickListener(this);
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DownloadManager.ACTION_DOWNLOAD_PROGRESS_CHANGE);
        intentFilter.addAction(DownloadManager.ACTION_DOWNLOAD_STATUS_CHANGE);
        intentFilter.addAction(DownloadManager.ACTION_DOWNLOAD_MERGE_STATUS);
        intentFilter.addAction("com.baidu.clientupdate.RSA.STATUS_FAIL");
        registerReceiver(this.mReceiver, intentFilter);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.efP) {
            finish();
        } else if (view == this.kCB && update()) {
            showToast(R.string.download_begin_tip);
            finish();
        }
        if (this.kCC != null) {
        }
    }

    private boolean update() {
        if (!n.checkSD()) {
            showToast(n.getSdErrorString());
            return false;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            return false;
        }
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaLcUpdateService.class);
        intent.addFlags(268435456);
        intent.putExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA, this.kCw);
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.kCw != null) {
            bundle.putSerializable(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA, this.kCw);
        }
        if (!TextUtils.isEmpty(this.kCt)) {
            bundle.putString(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA, this.kCt);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            super.onChangeSkinType(i);
            ap.setBackgroundResource(this.kCy, R.drawable.dialog_background);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
            ap.setViewTextColor(this.mDescView, R.color.cp_cont_b);
            ap.setBackgroundColor(this.kCz, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.efP, R.color.cp_link_tip_a);
            ap.setBackgroundResource(this.efP, R.drawable.dialog_left_button_selector);
            ap.setBackgroundColor(this.kCA, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.kCB, R.color.cp_link_tip_a);
            ap.setBackgroundResource(this.kCB, R.drawable.dialog_right_button_selector);
            ap.setViewTextColor(this.dGm, R.color.cp_link_tip_a);
            ap.setBackgroundColor(this.dGm, R.color.cp_bg_line_k);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        ClientUpdater.getInstance(TbadkCoreApplication.getInst()).cancelDownload(this.kCD);
        ClientUpdater.getInstance(TbadkCoreApplication.getInst()).cancelAutoCheckUpdate();
        unregisterReceiver(this.mReceiver);
        super.onDestroy();
    }
}
