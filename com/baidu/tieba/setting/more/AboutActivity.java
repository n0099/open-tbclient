package com.baidu.tieba.setting.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.AboutModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a9;
import com.repackage.ea8;
import com.repackage.ha8;
import com.repackage.ma8;
import com.repackage.mx4;
import com.repackage.na8;
import com.repackage.sk4;
import com.repackage.x97;
import com.repackage.ys4;
import java.util.Date;
/* loaded from: classes3.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int REQUEST_WRITE_EXTERNAL_STORGE_PERMISSON;
    public na8 collectorManager;
    public String functionIntroUrl;
    public AboutModel mModel;
    public ea8 mView;
    public ma8 mVisitPreviewServerDialog;
    public c receiver;

    /* loaded from: classes3.dex */
    public class a implements ha8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AboutActivity a;

        public a(AboutActivity aboutActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aboutActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aboutActivity;
        }

        @Override // com.repackage.ha8
        public void a(int i) {
            String str;
            String fileDireciory;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.a.finish();
                } else if (i == 1) {
                    this.a.checkUpdata();
                } else if (i == 2) {
                    this.a.sendMessage(new CustomMessage(2015001, new GuildActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    ys4.k().u(SettingTextFunctionIntroView.h, true);
                    sk4.s(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0784), this.a.functionIntroUrl, true, false, false);
                } else if (i != 4) {
                    if (i == 5) {
                        if (this.a.mVisitPreviewServerDialog == null) {
                            AboutActivity aboutActivity = this.a;
                            aboutActivity.mVisitPreviewServerDialog = new ma8(aboutActivity.getActivity());
                            this.a.mVisitPreviewServerDialog.create(this.a.getPageContext());
                        }
                        this.a.mVisitPreviewServerDialog.show();
                    } else if (i == 6) {
                        if (PermissionUtil.checkWriteExternalStorage(this.a)) {
                            this.a.startCollectLog();
                            return;
                        }
                        AboutActivity aboutActivity2 = this.a;
                        PermissionUtil.requestWriteExternalStorgePermission(aboutActivity2, aboutActivity2.REQUEST_WRITE_EXTERNAL_STORGE_PERMISSON);
                    }
                } else {
                    if (TbConfig.getDebugSwitch()) {
                        str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_DEBUG_FILE;
                    } else {
                        str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_FILE;
                    }
                    if (TbConfig.getDebugSwitch()) {
                        fileDireciory = FileHelper.getFileDireciory(TbConfig.FATAL_ERROR_DEBUG_FILE);
                    } else {
                        fileDireciory = FileHelper.getFileDireciory(TbConfig.FATAL_ERROR_FILE);
                    }
                    FileHelper.copyFileByAbsolutelyPath(str, fileDireciory);
                    FileHelper.CopyDir(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/newStat", FileHelper.getCacheDir() + "newStat", false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AboutActivity a;

        public b(AboutActivity aboutActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aboutActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aboutActivity;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.handlCallBack(obj);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AboutActivity this$0;

        public c(AboutActivity aboutActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aboutActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = aboutActivity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || this.this$0.mView == null) {
                return;
            }
            this.this$0.mView.v();
        }

        public /* synthetic */ c(AboutActivity aboutActivity, a aVar) {
            this(aboutActivity);
        }
    }

    public AboutActivity() {
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
        this.receiver = null;
        this.functionIntroUrl = TbConfig.SERVER_ADDRESS_WEB_VIEW + TbConfig.FUNCTION_INTRO_WEBVIEW;
        this.REQUEST_WRITE_EXTERNAL_STORGE_PERMISSON = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            x97.b().a(true);
            AboutModel aboutModel = this.mModel;
            if (aboutModel == null) {
                this.mModel = new AboutModel(this, new b(this));
            } else {
                aboutModel.cancelLoadData();
            }
            this.mModel.C();
            ea8 ea8Var = this.mView;
            if (ea8Var != null) {
                ea8Var.q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlCallBack(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, obj) == null) {
            ea8 ea8Var = this.mView;
            if (ea8Var != null) {
                ea8Var.r();
            }
            mx4 mx4Var = obj != null ? (mx4) obj : null;
            if (mx4Var != null) {
                TbadkCoreApplication.getInst().setVersionData(mx4Var.s());
                TbadkCoreApplication.getInst().refreshNewVersion(false);
                if (mx4Var.s().hasNewVer() && TbConfig.COULD_UPDATE) {
                    if (mx4Var.s().forceUpdate()) {
                        sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), mx4Var.s(), mx4Var.j())));
                    } else {
                        Long valueOf = Long.valueOf(new Date().getTime());
                        CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), mx4Var.s(), mx4Var.j()));
                        TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                        sendMessage(customMessage);
                    }
                }
                ea8 ea8Var2 = this.mView;
                if (ea8Var2 != null) {
                    ea8Var2.v();
                    return;
                }
                return;
            }
            showToast(getResources().getString(R.string.obfuscated_res_0x7f0f0c33));
        }
    }

    private void regReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.receiver = new c(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
            registerReceiver(this.receiver, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCollectLog() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.collectorManager.d()) {
            return;
        }
        this.collectorManager.g();
    }

    private void unregReceiver() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (cVar = this.receiver) == null) {
            return;
        }
        unregisterReceiver(cVar);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            ea8 ea8Var = this.mView;
            if (ea8Var != null) {
                ea8Var.x(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            this.collectorManager = new na8(this);
            ea8 ea8Var = new ea8(this, new a(this));
            this.mView = ea8Var;
            ea8Var.v();
            regReceiver();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            unregReceiver();
            AboutModel aboutModel = this.mModel;
            if (aboutModel != null) {
                aboutModel.cancelLoadData();
            }
            ea8 ea8Var = this.mView;
            if (ea8Var != null) {
                ea8Var.r();
            }
            ma8 ma8Var = this.mVisitPreviewServerDialog;
            if (ma8Var != null) {
                ma8Var.dismiss();
            }
            na8 na8Var = this.collectorManager;
            if (na8Var != null) {
                na8Var.i();
                this.collectorManager = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048579, this, i, strArr, iArr) == null) && i == this.REQUEST_WRITE_EXTERNAL_STORGE_PERMISSON) {
            if (PermissionUtil.checkWriteExternalStorage(getActivity().getApplicationContext())) {
                startCollectLog();
            } else {
                showToast(R.string.obfuscated_res_0x7f0f15c8);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            ea8 ea8Var = this.mView;
            if (ea8Var != null) {
                ea8Var.v();
            }
        }
    }
}
