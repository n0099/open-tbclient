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
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class LcUpdateDialogActivity extends BaseActivity<LcUpdateDialogActivity> implements View.OnClickListener {
    private TextView dRR;
    private TextView erH;
    private TextView kZA;
    private Download kZB;
    private String kZs;
    private ClientUpdateInfo kZv;
    private LinearLayout kZw;
    private LinearLayout kZx;
    private View kZy;
    private View kZz;
    private TextView mDescView;
    private PermissionJudgePolicy mPermissionJudgement;
    private TextView mTitleView;
    private int mSkinType = 3;
    private long kZC = -1;
    private BroadcastReceiver bLP = new BroadcastReceiver() { // from class: com.baidu.tieba.lc.LcUpdateDialogActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LcUpdateDialogActivity.this.kZB = (Download) intent.getSerializableExtra("download");
            if (LcUpdateDialogActivity.this.kZB != null && LcUpdateDialogActivity.this.kZB.mSourceKey != null && LcUpdateDialogActivity.this.kZB.mSourceKey.contains(LcUpdateDialogActivity.this.getApplicationContext().getPackageName())) {
                LcUpdateDialogActivity.this.kZC = LcUpdateDialogActivity.this.kZB.mId;
                if (DownloadManager.ACTION_DOWNLOAD_PROGRESS_CHANGE.equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("progress", 0);
                    LcUpdateDialogActivity.this.dRR.setVisibility(0);
                    LcUpdateDialogActivity.this.dRR.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.lc_app_downloading), String.valueOf(intExtra)));
                } else if (DownloadManager.ACTION_DOWNLOAD_STATUS_CHANGE.equals(intent.getAction())) {
                    TbadkCoreApplication.saveClientId(LcUpdateDialogActivity.this, String.valueOf(LcUpdateDialogActivity.this.kZC));
                    TbadkCoreApplication.setClientId(String.valueOf(LcUpdateDialogActivity.this.kZC));
                    if (DownloadState.FINISH == LcUpdateDialogActivity.this.kZB.getState()) {
                        String str = LcUpdateDialogActivity.this.kZB.mSavedPath + "/" + LcUpdateDialogActivity.this.kZB.mFileName;
                        LcUpdateDialogActivity.this.finish();
                    } else if (DownloadState.DOWNLOADING != LcUpdateDialogActivity.this.kZB.getState() && DownloadState.PAUSE != LcUpdateDialogActivity.this.kZB.getState() && DownloadState.CANCEL == LcUpdateDialogActivity.this.kZB.getState()) {
                        Toast.makeText(LcUpdateDialogActivity.this.getApplicationContext(), LcUpdateDialogActivity.this.kZB.mFileName + ": 已删除", 1).show();
                    }
                } else if (DownloadManager.ACTION_DOWNLOAD_MERGE_STATUS.equals(intent.getAction())) {
                    if (DownloadState.MEAGESTART == LcUpdateDialogActivity.this.kZB.getState() || DownloadState.MEAGEEND != LcUpdateDialogActivity.this.kZB.getState()) {
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
            this.kZv = (ClientUpdateInfo) bundle.getSerializable(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA);
            this.kZs = bundle.getString(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.kZv = (ClientUpdateInfo) intent.getSerializableExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA);
            this.kZs = intent.getStringExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA);
        }
    }

    private void initView() {
        this.kZw = (LinearLayout) findViewById(R.id.lc_update_trans_bg);
        this.kZx = (LinearLayout) findViewById(R.id.lc_update_bg);
        this.mTitleView = (TextView) findViewById(R.id.lc_update_title);
        this.mDescView = (TextView) findViewById(R.id.lc_update_desc);
        this.kZy = findViewById(R.id.lc_update_content_divider);
        this.erH = (TextView) findViewById(R.id.lc_update_cancel);
        this.kZz = findViewById(R.id.lc_update_button_divider);
        this.kZA = (TextView) findViewById(R.id.lc_update_confirm);
        this.dRR = (TextView) findViewById(R.id.lc_update_progress);
        this.kZw.setBackgroundColor(Color.parseColor("#A8000000"));
        if (this.kZv != null) {
            this.mDescView.setText(this.kZv.mChangelog);
        }
        this.erH.setOnClickListener(this);
        this.kZA.setOnClickListener(this);
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DownloadManager.ACTION_DOWNLOAD_PROGRESS_CHANGE);
        intentFilter.addAction(DownloadManager.ACTION_DOWNLOAD_STATUS_CHANGE);
        intentFilter.addAction(DownloadManager.ACTION_DOWNLOAD_MERGE_STATUS);
        intentFilter.addAction("com.baidu.clientupdate.RSA.STATUS_FAIL");
        registerReceiver(this.bLP, intentFilter);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.erH) {
            finish();
        } else if (view == this.kZA && update()) {
            showToast(R.string.download_begin_tip);
            finish();
        }
        if (this.kZB != null) {
        }
    }

    private boolean update() {
        if (!o.checkSD()) {
            showToast(o.getSdErrorString());
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
        intent.putExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA, this.kZv);
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.kZv != null) {
            bundle.putSerializable(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA, this.kZv);
        }
        if (!TextUtils.isEmpty(this.kZs)) {
            bundle.putString(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA, this.kZs);
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
            ap.setBackgroundResource(this.kZx, R.drawable.dialog_background);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
            ap.setViewTextColor(this.mDescView, R.color.CAM_X0105);
            ap.setBackgroundColor(this.kZy, R.color.CAM_X0204);
            ap.setViewTextColor(this.erH, R.color.CAM_X0302);
            ap.setBackgroundResource(this.erH, R.drawable.dialog_left_button_selector);
            ap.setBackgroundColor(this.kZz, R.color.CAM_X0204);
            ap.setViewTextColor(this.kZA, R.color.CAM_X0302);
            ap.setBackgroundResource(this.kZA, R.drawable.dialog_right_button_selector);
            ap.setViewTextColor(this.dRR, R.color.CAM_X0302);
            ap.setBackgroundColor(this.dRR, R.color.CAM_X0211);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        ClientUpdater.getInstance(TbadkCoreApplication.getInst()).cancelDownload(this.kZC);
        ClientUpdater.getInstance(TbadkCoreApplication.getInst()).cancelAutoCheckUpdate();
        unregisterReceiver(this.bLP);
        super.onDestroy();
    }
}
