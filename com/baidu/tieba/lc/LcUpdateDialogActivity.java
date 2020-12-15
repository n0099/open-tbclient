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
    private TextView dLD;
    private TextView elj;
    private String kQc;
    private ClientUpdateInfo kQf;
    private LinearLayout kQg;
    private LinearLayout kQh;
    private View kQi;
    private View kQj;
    private TextView kQk;
    private Download kQl;
    private TextView mDescView;
    private PermissionJudgePolicy mPermissionJudgement;
    private TextView mTitleView;
    private int mSkinType = 3;
    private long kQm = -1;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.lc.LcUpdateDialogActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LcUpdateDialogActivity.this.kQl = (Download) intent.getSerializableExtra("download");
            if (LcUpdateDialogActivity.this.kQl != null && LcUpdateDialogActivity.this.kQl.mSourceKey != null && LcUpdateDialogActivity.this.kQl.mSourceKey.contains(LcUpdateDialogActivity.this.getApplicationContext().getPackageName())) {
                LcUpdateDialogActivity.this.kQm = LcUpdateDialogActivity.this.kQl.mId;
                if (DownloadManager.ACTION_DOWNLOAD_PROGRESS_CHANGE.equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("progress", 0);
                    LcUpdateDialogActivity.this.dLD.setVisibility(0);
                    LcUpdateDialogActivity.this.dLD.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.lc_app_downloading), String.valueOf(intExtra)));
                } else if (DownloadManager.ACTION_DOWNLOAD_STATUS_CHANGE.equals(intent.getAction())) {
                    TbadkCoreApplication.saveClientId(LcUpdateDialogActivity.this, String.valueOf(LcUpdateDialogActivity.this.kQm));
                    TbadkCoreApplication.setClientId(String.valueOf(LcUpdateDialogActivity.this.kQm));
                    if (DownloadState.FINISH == LcUpdateDialogActivity.this.kQl.getState()) {
                        String str = LcUpdateDialogActivity.this.kQl.mSavedPath + "/" + LcUpdateDialogActivity.this.kQl.mFileName;
                        LcUpdateDialogActivity.this.finish();
                    } else if (DownloadState.DOWNLOADING != LcUpdateDialogActivity.this.kQl.getState() && DownloadState.PAUSE != LcUpdateDialogActivity.this.kQl.getState() && DownloadState.CANCEL == LcUpdateDialogActivity.this.kQl.getState()) {
                        Toast.makeText(LcUpdateDialogActivity.this.getApplicationContext(), LcUpdateDialogActivity.this.kQl.mFileName + ": 已删除", 1).show();
                    }
                } else if (DownloadManager.ACTION_DOWNLOAD_MERGE_STATUS.equals(intent.getAction())) {
                    if (DownloadState.MEAGESTART == LcUpdateDialogActivity.this.kQl.getState() || DownloadState.MEAGEEND != LcUpdateDialogActivity.this.kQl.getState()) {
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
            this.kQf = (ClientUpdateInfo) bundle.getSerializable(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA);
            this.kQc = bundle.getString(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.kQf = (ClientUpdateInfo) intent.getSerializableExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA);
            this.kQc = intent.getStringExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA);
        }
    }

    private void initView() {
        this.kQg = (LinearLayout) findViewById(R.id.lc_update_trans_bg);
        this.kQh = (LinearLayout) findViewById(R.id.lc_update_bg);
        this.mTitleView = (TextView) findViewById(R.id.lc_update_title);
        this.mDescView = (TextView) findViewById(R.id.lc_update_desc);
        this.kQi = findViewById(R.id.lc_update_content_divider);
        this.elj = (TextView) findViewById(R.id.lc_update_cancel);
        this.kQj = findViewById(R.id.lc_update_button_divider);
        this.kQk = (TextView) findViewById(R.id.lc_update_confirm);
        this.dLD = (TextView) findViewById(R.id.lc_update_progress);
        this.kQg.setBackgroundColor(Color.parseColor("#A8000000"));
        if (this.kQf != null) {
            this.mDescView.setText(this.kQf.mChangelog);
        }
        this.elj.setOnClickListener(this);
        this.kQk.setOnClickListener(this);
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
        if (view == this.elj) {
            finish();
        } else if (view == this.kQk && update()) {
            showToast(R.string.download_begin_tip);
            finish();
        }
        if (this.kQl != null) {
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
        intent.putExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA, this.kQf);
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.kQf != null) {
            bundle.putSerializable(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA, this.kQf);
        }
        if (!TextUtils.isEmpty(this.kQc)) {
            bundle.putString(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA, this.kQc);
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
            ap.setBackgroundResource(this.kQh, R.drawable.dialog_background);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
            ap.setViewTextColor(this.mDescView, R.color.CAM_X0105);
            ap.setBackgroundColor(this.kQi, R.color.CAM_X0204);
            ap.setViewTextColor(this.elj, R.color.CAM_X0302);
            ap.setBackgroundResource(this.elj, R.drawable.dialog_left_button_selector);
            ap.setBackgroundColor(this.kQj, R.color.CAM_X0204);
            ap.setViewTextColor(this.kQk, R.color.CAM_X0302);
            ap.setBackgroundResource(this.kQk, R.drawable.dialog_right_button_selector);
            ap.setViewTextColor(this.dLD, R.color.CAM_X0302);
            ap.setBackgroundColor(this.dLD, R.color.CAM_X0211);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        ClientUpdater.getInstance(TbadkCoreApplication.getInst()).cancelDownload(this.kQm);
        ClientUpdater.getInstance(TbadkCoreApplication.getInst()).cancelAutoCheckUpdate();
        unregisterReceiver(this.mReceiver);
        super.onDestroy();
    }
}
