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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.ClientUpdater;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.download.Download;
import com.baidu.clientupdate.download.DownloadState;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class LcUpdateDialogActivity extends BaseActivity<LcUpdateDialogActivity> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LC_UPDATE_FAIL = "com.baidu.clientupdate.RSA.STATUS_FAIL";
    public static final String LC_UPDATE_MERGE = "com.baidu.clientupdate.download.STATUS_MERGE";
    public static final String LC_UPDATE_PROGRESS = "com.baidu.clientupdate.download.PROGRESS_CHANGE";
    public static final String LC_UPDATE_STATUS = "com.baidu.clientupdate.download.STATUS_CHANGE";
    public transient /* synthetic */ FieldHolder $fh;
    public String mApkMD5RSA;
    public LinearLayout mBgView;
    public View mButtonLineView;
    public TextView mCancelView;
    public long mClientId;
    public ClientUpdateInfo mClientUpdateInfo;
    public TextView mConfirmView;
    public View mContentLineView;
    public TextView mDescView;
    public Download mDownloadInfo;
    public PermissionJudgePolicy mPermissionJudgement;
    public TextView mProgressView;
    public BroadcastReceiver mReceiver;
    public int mSkinType;
    public TextView mTitleView;
    public LinearLayout mTransBgView;

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LcUpdateDialogActivity this$0;

        public a(LcUpdateDialogActivity lcUpdateDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lcUpdateDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = lcUpdateDialogActivity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.mDownloadInfo = (Download) intent.getSerializableExtra("download");
                if (this.this$0.mDownloadInfo == null || this.this$0.mDownloadInfo.mSourceKey == null || !this.this$0.mDownloadInfo.mSourceKey.contains(this.this$0.getApplicationContext().getPackageName())) {
                    return;
                }
                LcUpdateDialogActivity lcUpdateDialogActivity = this.this$0;
                lcUpdateDialogActivity.mClientId = lcUpdateDialogActivity.mDownloadInfo.mId;
                if ("com.baidu.clientupdate.download.PROGRESS_CHANGE".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("progress", 0);
                    this.this$0.mProgressView.setVisibility(0);
                    this.this$0.mProgressView.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09cd), String.valueOf(intExtra)));
                } else if ("com.baidu.clientupdate.download.STATUS_CHANGE".equals(intent.getAction())) {
                    LcUpdateDialogActivity lcUpdateDialogActivity2 = this.this$0;
                    TbadkCoreApplication.saveClientId(lcUpdateDialogActivity2, String.valueOf(lcUpdateDialogActivity2.mClientId));
                    TbadkCoreApplication.setClientId(String.valueOf(this.this$0.mClientId));
                    if (DownloadState.FINISH != this.this$0.mDownloadInfo.getState()) {
                        if (DownloadState.DOWNLOADING == this.this$0.mDownloadInfo.getState() || DownloadState.PAUSE == this.this$0.mDownloadInfo.getState() || DownloadState.CANCEL != this.this$0.mDownloadInfo.getState()) {
                            return;
                        }
                        Toast.makeText(this.this$0.getApplicationContext(), this.this$0.mDownloadInfo.mFileName + ": 已删除", 1).show();
                        return;
                    }
                    String str = this.this$0.mDownloadInfo.mSavedPath + "/" + this.this$0.mDownloadInfo.mFileName;
                    this.this$0.finish();
                } else if ("com.baidu.clientupdate.download.STATUS_MERGE".equals(intent.getAction())) {
                    if (DownloadState.MEAGESTART == this.this$0.mDownloadInfo.getState()) {
                        return;
                    }
                    DownloadState downloadState = DownloadState.MEAGEEND;
                    this.this$0.mDownloadInfo.getState();
                } else if (LcUpdateDialogActivity.LC_UPDATE_FAIL.equals(intent.getAction())) {
                    Toast.makeText(this.this$0.getApplicationContext(), "安装包存在被劫持风险，已删除", 1).show();
                }
            }
        }
    }

    public LcUpdateDialogActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSkinType = 3;
        this.mClientId = -1L;
        this.mReceiver = new a(this);
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, bundle) == null) {
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
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mTransBgView = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091201);
            this.mBgView = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911f9);
            this.mTitleView = (TextView) findViewById(R.id.obfuscated_res_0x7f091200);
            this.mDescView = (TextView) findViewById(R.id.obfuscated_res_0x7f0911fe);
            this.mContentLineView = findViewById(R.id.obfuscated_res_0x7f0911fd);
            this.mCancelView = (TextView) findViewById(R.id.obfuscated_res_0x7f0911fb);
            this.mButtonLineView = findViewById(R.id.obfuscated_res_0x7f0911fa);
            this.mConfirmView = (TextView) findViewById(R.id.obfuscated_res_0x7f0911fc);
            this.mProgressView = (TextView) findViewById(R.id.obfuscated_res_0x7f0911ff);
            this.mTransBgView.setBackgroundColor(Color.parseColor("#A8000000"));
            ClientUpdateInfo clientUpdateInfo = this.mClientUpdateInfo;
            if (clientUpdateInfo != null) {
                this.mDescView.setText(clientUpdateInfo.mChangelog);
            }
            this.mCancelView.setOnClickListener(this);
            this.mConfirmView.setOnClickListener(this);
        }
    }

    private void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.clientupdate.download.PROGRESS_CHANGE");
            intentFilter.addAction("com.baidu.clientupdate.download.STATUS_CHANGE");
            intentFilter.addAction("com.baidu.clientupdate.download.STATUS_MERGE");
            intentFilter.addAction(LC_UPDATE_FAIL);
            registerReceiver(this.mReceiver, intentFilter);
        }
    }

    private boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (!FileHelper.checkSD()) {
                showToast(FileHelper.getSdErrorString());
                return false;
            }
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(pageActivity) || this.mClientUpdateInfo == null) {
                return false;
            }
            Intent intent = new Intent(getPageContext().getPageActivity(), TiebaLcUpdateService.class);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.putExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA, this.mClientUpdateInfo);
            getPageContext().getPageActivity().startService(intent);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || i == this.mSkinType) {
            return;
        }
        this.mSkinType = i;
        super.onChangeSkinType(i);
        SkinManager.setBackgroundResource(this.mBgView, R.drawable.dialog_background);
        SkinManager.setViewTextColor(this.mTitleView, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.mDescView, (int) R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.mContentLineView, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.mCancelView, (int) R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.mCancelView, R.drawable.dialog_left_button_selector);
        SkinManager.setBackgroundColor(this.mButtonLineView, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.mConfirmView, (int) R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.mConfirmView, R.drawable.dialog_right_button_selector);
        SkinManager.setViewTextColor(this.mProgressView, (int) R.color.CAM_X0302);
        SkinManager.setBackgroundColor(this.mProgressView, R.color.CAM_X0211);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.mCancelView) {
                finish();
            } else if (view2 == this.mConfirmView && update()) {
                showToast(R.string.obfuscated_res_0x7f0f04ec);
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d0041);
            initData(bundle);
            initView();
            registerReceiver();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ClientUpdater.getInstance(TbadkCoreApplication.getInst()).cancelDownload(this.mClientId);
            ClientUpdater.getInstance(TbadkCoreApplication.getInst()).cancelAutoCheckUpdate();
            unregisterReceiver(this.mReceiver);
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
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
}
