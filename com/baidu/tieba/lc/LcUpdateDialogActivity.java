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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.ClientUpdater;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.download.Download;
import com.baidu.clientupdate.download.DownloadManager;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public LinearLayout b;
    public LinearLayout c;
    public TextView d;
    public TextView e;
    public View f;
    public TextView g;
    public View h;
    public TextView i;
    public TextView j;
    public ClientUpdateInfo k;
    public Download l;
    public long m;
    public String n;
    public PermissionJudgePolicy o;
    public BroadcastReceiver p;

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
                this.this$0.l = (Download) intent.getSerializableExtra("download");
                if (this.this$0.l == null || this.this$0.l.mSourceKey == null || !this.this$0.l.mSourceKey.contains(this.this$0.getApplicationContext().getPackageName())) {
                    return;
                }
                LcUpdateDialogActivity lcUpdateDialogActivity = this.this$0;
                lcUpdateDialogActivity.m = lcUpdateDialogActivity.l.mId;
                if (DownloadManager.ACTION_DOWNLOAD_PROGRESS_CHANGE.equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("progress", 0);
                    this.this$0.j.setVisibility(0);
                    this.this$0.j.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09b8), String.valueOf(intExtra)));
                } else if (DownloadManager.ACTION_DOWNLOAD_STATUS_CHANGE.equals(intent.getAction())) {
                    LcUpdateDialogActivity lcUpdateDialogActivity2 = this.this$0;
                    TbadkCoreApplication.saveClientId(lcUpdateDialogActivity2, String.valueOf(lcUpdateDialogActivity2.m));
                    TbadkCoreApplication.setClientId(String.valueOf(this.this$0.m));
                    if (DownloadState.FINISH != this.this$0.l.getState()) {
                        if (DownloadState.DOWNLOADING == this.this$0.l.getState() || DownloadState.PAUSE == this.this$0.l.getState() || DownloadState.CANCEL != this.this$0.l.getState()) {
                            return;
                        }
                        Toast.makeText(this.this$0.getApplicationContext(), this.this$0.l.mFileName + ": 已删除", 1).show();
                        return;
                    }
                    String str = this.this$0.l.mSavedPath + "/" + this.this$0.l.mFileName;
                    this.this$0.finish();
                } else if (DownloadManager.ACTION_DOWNLOAD_MERGE_STATUS.equals(intent.getAction())) {
                    if (DownloadState.MEAGESTART == this.this$0.l.getState()) {
                        return;
                    }
                    DownloadState downloadState = DownloadState.MEAGEEND;
                    this.this$0.l.getState();
                } else if ("com.baidu.clientupdate.RSA.STATUS_FAIL".equals(intent.getAction())) {
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
        this.a = 3;
        this.m = -1L;
        this.p = new a(this);
    }

    private void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(DownloadManager.ACTION_DOWNLOAD_PROGRESS_CHANGE);
            intentFilter.addAction(DownloadManager.ACTION_DOWNLOAD_STATUS_CHANGE);
            intentFilter.addAction(DownloadManager.ACTION_DOWNLOAD_MERGE_STATUS);
            intentFilter.addAction("com.baidu.clientupdate.RSA.STATUS_FAIL");
            registerReceiver(this.p, intentFilter);
        }
    }

    private boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (!FileHelper.checkSD()) {
                showToast(FileHelper.getSdErrorString());
                return false;
            }
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.o == null) {
                this.o = new PermissionJudgePolicy();
            }
            this.o.clearRequestPermissionList();
            this.o.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.o.startRequestPermission(pageActivity) || this.k == null) {
                return false;
            }
            Intent intent = new Intent(getPageContext().getPageActivity(), TiebaLcUpdateService.class);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.putExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA, this.k);
            getPageContext().getPageActivity().startService(intent);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void F1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            if (bundle != null) {
                this.k = (ClientUpdateInfo) bundle.getSerializable(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA);
                this.n = bundle.getString(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA);
                return;
            }
            Intent intent = getIntent();
            if (intent != null) {
                this.k = (ClientUpdateInfo) intent.getSerializableExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA);
                this.n = intent.getStringExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA);
            }
        }
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091242);
            this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09123a);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091241);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09123f);
            this.f = findViewById(R.id.obfuscated_res_0x7f09123e);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f09123c);
            this.h = findViewById(R.id.obfuscated_res_0x7f09123b);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f09123d);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f091240);
            this.b.setBackgroundColor(Color.parseColor("#A8000000"));
            ClientUpdateInfo clientUpdateInfo = this.k;
            if (clientUpdateInfo != null) {
                this.e.setText(clientUpdateInfo.mChangelog);
            }
            this.g.setOnClickListener(this);
            this.i.setOnClickListener(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || i == this.a) {
            return;
        }
        this.a = i;
        super.onChangeSkinType(i);
        SkinManager.setBackgroundResource(this.c, R.drawable.dialog_background);
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.g, R.drawable.dialog_left_button_selector);
        SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.i, R.drawable.dialog_right_button_selector);
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0302);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0211);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.g) {
                finish();
            } else if (view2 == this.i && update()) {
                showToast(R.string.obfuscated_res_0x7f0f04f1);
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d003f);
            F1(bundle);
            G1();
            registerReceiver();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ClientUpdater.getInstance(TbadkCoreApplication.getInst()).cancelDownload(this.m);
            ClientUpdater.getInstance(TbadkCoreApplication.getInst()).cancelAutoCheckUpdate();
            unregisterReceiver(this.p);
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            ClientUpdateInfo clientUpdateInfo = this.k;
            if (clientUpdateInfo != null) {
                bundle.putSerializable(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA, clientUpdateInfo);
            }
            if (TextUtils.isEmpty(this.n)) {
                return;
            }
            bundle.putString(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_APKMD5RSA, this.n);
        }
    }
}
