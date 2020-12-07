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
    private String kQa;
    private ClientUpdateInfo kQd;
    private LinearLayout kQe;
    private LinearLayout kQf;
    private View kQg;
    private View kQh;
    private TextView kQi;
    private Download kQj;
    private TextView mDescView;
    private PermissionJudgePolicy mPermissionJudgement;
    private TextView mTitleView;
    private int mSkinType = 3;
    private long kQk = -1;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.lc.LcUpdateDialogActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LcUpdateDialogActivity.this.kQj = (Download) intent.getSerializableExtra("download");
            if (LcUpdateDialogActivity.this.kQj != null && LcUpdateDialogActivity.this.kQj.mSourceKey != null && LcUpdateDialogActivity.this.kQj.mSourceKey.contains(LcUpdateDialogActivity.this.getApplicationContext().getPackageName())) {
                LcUpdateDialogActivity.this.kQk = LcUpdateDialogActivity.this.kQj.mId;
                if (DownloadManager.ACTION_DOWNLOAD_PROGRESS_CHANGE.equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("progress", 0);
                    LcUpdateDialogActivity.this.dLD.setVisibility(0);
                    LcUpdateDialogActivity.this.dLD.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.lc_app_downloading), String.valueOf(intExtra)));
                } else if (DownloadManager.ACTION_DOWNLOAD_STATUS_CHANGE.equals(intent.getAction())) {
                    TbadkCoreApplication.saveClientId(LcUpdateDialogActivity.this, String.valueOf(LcUpdateDialogActivity.this.kQk));
                    TbadkCoreApplication.setClientId(String.valueOf(LcUpdateDialogActivity.this.kQk));
                    if (DownloadState.FINISH == LcUpdateDialogActivity.this.kQj.getState()) {
                        String str = LcUpdateDialogActivity.this.kQj.mSavedPath + "/" + LcUpdateDialogActivity.this.kQj.mFileName;
                        LcUpdateDialogActivity.this.finish();
                    } else if (DownloadState.DOWNLOADING != LcUpdateDialogActivity.this.kQj.getState() && DownloadState.PAUSE != LcUpdateDialogActivity.this.kQj.getState() && DownloadState.CANCEL == LcUpdateDialogActivity.this.kQj.getState()) {
                        Toast.makeText(LcUpdateDialogActivity.this.getApplicationContext(), LcUpdateDialogActivity.this.kQj.mFileName + ": 已删除", 1).show();
                    }
                } else if (DownloadManager.ACTION_DOWNLOAD_MERGE_STATUS.equals(intent.getAction())) {
                    if (DownloadState.MEAGESTART == LcUpdateDialogActivity.this.kQj.getState() || DownloadState.MEAGEEND != LcUpdateDialogActivity.this.kQj.getState()) {
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
            this.kQd = (ClientUpdateInfo) bundle.getSerializable(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA);
            this.kQa = bundle.getString(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.kQd = (ClientUpdateInfo) intent.getSerializableExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA);
            this.kQa = intent.getStringExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA);
        }
    }

    private void initView() {
        this.kQe = (LinearLayout) findViewById(R.id.lc_update_trans_bg);
        this.kQf = (LinearLayout) findViewById(R.id.lc_update_bg);
        this.mTitleView = (TextView) findViewById(R.id.lc_update_title);
        this.mDescView = (TextView) findViewById(R.id.lc_update_desc);
        this.kQg = findViewById(R.id.lc_update_content_divider);
        this.elj = (TextView) findViewById(R.id.lc_update_cancel);
        this.kQh = findViewById(R.id.lc_update_button_divider);
        this.kQi = (TextView) findViewById(R.id.lc_update_confirm);
        this.dLD = (TextView) findViewById(R.id.lc_update_progress);
        this.kQe.setBackgroundColor(Color.parseColor("#A8000000"));
        if (this.kQd != null) {
            this.mDescView.setText(this.kQd.mChangelog);
        }
        this.elj.setOnClickListener(this);
        this.kQi.setOnClickListener(this);
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
        } else if (view == this.kQi && update()) {
            showToast(R.string.download_begin_tip);
            finish();
        }
        if (this.kQj != null) {
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
        intent.putExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA, this.kQd);
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.kQd != null) {
            bundle.putSerializable(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA, this.kQd);
        }
        if (!TextUtils.isEmpty(this.kQa)) {
            bundle.putString(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA, this.kQa);
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
            ap.setBackgroundResource(this.kQf, R.drawable.dialog_background);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
            ap.setViewTextColor(this.mDescView, R.color.CAM_X0105);
            ap.setBackgroundColor(this.kQg, R.color.CAM_X0204);
            ap.setViewTextColor(this.elj, R.color.CAM_X0302);
            ap.setBackgroundResource(this.elj, R.drawable.dialog_left_button_selector);
            ap.setBackgroundColor(this.kQh, R.color.CAM_X0204);
            ap.setViewTextColor(this.kQi, R.color.CAM_X0302);
            ap.setBackgroundResource(this.kQi, R.drawable.dialog_right_button_selector);
            ap.setViewTextColor(this.dLD, R.color.CAM_X0302);
            ap.setBackgroundColor(this.dLD, R.color.CAM_X0211);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        ClientUpdater.getInstance(TbadkCoreApplication.getInst()).cancelDownload(this.kQk);
        ClientUpdater.getInstance(TbadkCoreApplication.getInst()).cancelAutoCheckUpdate();
        unregisterReceiver(this.mReceiver);
        super.onDestroy();
    }
}
