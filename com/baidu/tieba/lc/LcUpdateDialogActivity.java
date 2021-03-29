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
import com.baidu.clientupdate.download.DownloadState;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
/* loaded from: classes3.dex */
public class LcUpdateDialogActivity extends BaseActivity<LcUpdateDialogActivity> implements View.OnClickListener {
    public static final String LC_UPDATE_FAIL = "com.baidu.clientupdate.RSA.STATUS_FAIL";
    public static final String LC_UPDATE_MERGE = "com.baidu.clientupdate.download.STATUS_MERGE";
    public static final String LC_UPDATE_PROGRESS = "com.baidu.clientupdate.download.PROGRESS_CHANGE";
    public static final String LC_UPDATE_STATUS = "com.baidu.clientupdate.download.STATUS_CHANGE";
    public String mApkMD5RSA;
    public LinearLayout mBgView;
    public View mButtonLineView;
    public TextView mCancelView;
    public ClientUpdateInfo mClientUpdateInfo;
    public TextView mConfirmView;
    public View mContentLineView;
    public TextView mDescView;
    public Download mDownloadInfo;
    public PermissionJudgePolicy mPermissionJudgement;
    public TextView mProgressView;
    public TextView mTitleView;
    public LinearLayout mTransBgView;
    public int mSkinType = 3;
    public long mClientId = -1;
    public BroadcastReceiver mReceiver = new a();

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LcUpdateDialogActivity.this.mDownloadInfo = (Download) intent.getSerializableExtra("download");
            if (LcUpdateDialogActivity.this.mDownloadInfo == null || LcUpdateDialogActivity.this.mDownloadInfo.mSourceKey == null || !LcUpdateDialogActivity.this.mDownloadInfo.mSourceKey.contains(LcUpdateDialogActivity.this.getApplicationContext().getPackageName())) {
                return;
            }
            LcUpdateDialogActivity lcUpdateDialogActivity = LcUpdateDialogActivity.this;
            lcUpdateDialogActivity.mClientId = lcUpdateDialogActivity.mDownloadInfo.mId;
            if ("com.baidu.clientupdate.download.PROGRESS_CHANGE".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("progress", 0);
                LcUpdateDialogActivity.this.mProgressView.setVisibility(0);
                LcUpdateDialogActivity.this.mProgressView.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.lc_app_downloading), String.valueOf(intExtra)));
            } else if ("com.baidu.clientupdate.download.STATUS_CHANGE".equals(intent.getAction())) {
                LcUpdateDialogActivity lcUpdateDialogActivity2 = LcUpdateDialogActivity.this;
                TbadkCoreApplication.saveClientId(lcUpdateDialogActivity2, String.valueOf(lcUpdateDialogActivity2.mClientId));
                TbadkCoreApplication.setClientId(String.valueOf(LcUpdateDialogActivity.this.mClientId));
                if (DownloadState.FINISH != LcUpdateDialogActivity.this.mDownloadInfo.getState()) {
                    if (DownloadState.DOWNLOADING == LcUpdateDialogActivity.this.mDownloadInfo.getState() || DownloadState.PAUSE == LcUpdateDialogActivity.this.mDownloadInfo.getState() || DownloadState.CANCEL != LcUpdateDialogActivity.this.mDownloadInfo.getState()) {
                        return;
                    }
                    Toast.makeText(LcUpdateDialogActivity.this.getApplicationContext(), LcUpdateDialogActivity.this.mDownloadInfo.mFileName + ": 已删除", 1).show();
                    return;
                }
                String str = LcUpdateDialogActivity.this.mDownloadInfo.mSavedPath + "/" + LcUpdateDialogActivity.this.mDownloadInfo.mFileName;
                LcUpdateDialogActivity.this.finish();
            } else if ("com.baidu.clientupdate.download.STATUS_MERGE".equals(intent.getAction())) {
                if (DownloadState.MEAGESTART == LcUpdateDialogActivity.this.mDownloadInfo.getState()) {
                    return;
                }
                DownloadState downloadState = DownloadState.MEAGEEND;
                LcUpdateDialogActivity.this.mDownloadInfo.getState();
            } else if (LcUpdateDialogActivity.LC_UPDATE_FAIL.equals(intent.getAction())) {
                Toast.makeText(LcUpdateDialogActivity.this.getApplicationContext(), "安装包存在被劫持风险，已删除", 1).show();
            }
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.mClientUpdateInfo = (ClientUpdateInfo) bundle.getSerializable(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA);
            this.mApkMD5RSA = bundle.getString(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.mClientUpdateInfo = (ClientUpdateInfo) intent.getSerializableExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA);
            this.mApkMD5RSA = intent.getStringExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA);
        }
    }

    private void initView() {
        this.mTransBgView = (LinearLayout) findViewById(R.id.lc_update_trans_bg);
        this.mBgView = (LinearLayout) findViewById(R.id.lc_update_bg);
        this.mTitleView = (TextView) findViewById(R.id.lc_update_title);
        this.mDescView = (TextView) findViewById(R.id.lc_update_desc);
        this.mContentLineView = findViewById(R.id.lc_update_content_divider);
        this.mCancelView = (TextView) findViewById(R.id.lc_update_cancel);
        this.mButtonLineView = findViewById(R.id.lc_update_button_divider);
        this.mConfirmView = (TextView) findViewById(R.id.lc_update_confirm);
        this.mProgressView = (TextView) findViewById(R.id.lc_update_progress);
        this.mTransBgView.setBackgroundColor(Color.parseColor("#A8000000"));
        ClientUpdateInfo clientUpdateInfo = this.mClientUpdateInfo;
        if (clientUpdateInfo != null) {
            this.mDescView.setText(clientUpdateInfo.mChangelog);
        }
        this.mCancelView.setOnClickListener(this);
        this.mConfirmView.setOnClickListener(this);
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.clientupdate.download.PROGRESS_CHANGE");
        intentFilter.addAction("com.baidu.clientupdate.download.STATUS_CHANGE");
        intentFilter.addAction("com.baidu.clientupdate.download.STATUS_MERGE");
        intentFilter.addAction(LC_UPDATE_FAIL);
        registerReceiver(this.mReceiver, intentFilter);
    }

    private boolean update() {
        if (!FileHelper.checkSD()) {
            showToast(FileHelper.getSdErrorString());
            return false;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            return false;
        }
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaLcUpdateService.class);
        intent.addFlags(268435456);
        intent.putExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA, this.mClientUpdateInfo);
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (i == this.mSkinType) {
            return;
        }
        this.mSkinType = i;
        super.onChangeSkinType(i);
        SkinManager.setBackgroundResource(this.mBgView, R.drawable.dialog_background);
        SkinManager.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.mDescView, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.mContentLineView, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.mCancelView, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.mCancelView, R.drawable.dialog_left_button_selector);
        SkinManager.setBackgroundColor(this.mButtonLineView, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.mConfirmView, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.mConfirmView, R.drawable.dialog_right_button_selector);
        SkinManager.setViewTextColor(this.mProgressView, R.color.CAM_X0302);
        SkinManager.setBackgroundColor(this.mProgressView, R.color.CAM_X0211);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mCancelView) {
            finish();
        } else if (view == this.mConfirmView && update()) {
            showToast(R.string.download_begin_tip);
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_lc_update_layout);
        initData(bundle);
        initView();
        registerReceiver();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        ClientUpdater.getInstance(TbadkCoreApplication.getInst()).cancelDownload(this.mClientId);
        ClientUpdater.getInstance(TbadkCoreApplication.getInst()).cancelAutoCheckUpdate();
        unregisterReceiver(this.mReceiver);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ClientUpdateInfo clientUpdateInfo = this.mClientUpdateInfo;
        if (clientUpdateInfo != null) {
            bundle.putSerializable(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA, clientUpdateInfo);
        }
        if (TextUtils.isEmpty(this.mApkMD5RSA)) {
            return;
        }
        bundle.putString(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA, this.mApkMD5RSA);
    }
}
