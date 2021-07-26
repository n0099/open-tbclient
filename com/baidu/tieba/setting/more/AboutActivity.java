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
import d.a.d.a.e;
import d.a.q0.z2.c.d;
import d.a.q0.z2.c.i;
import java.util.Date;
/* loaded from: classes4.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int REQUEST_WRITE_EXTERNAL_STORGE_PERMISSON;
    public d.a.q0.z2.c.j.a collectorManager;
    public String functionIntroUrl;
    public AboutModel mModel;
    public d.a.q0.z2.c.a mView;
    public i mVisitPreviewServerDialog;
    public c receiver;

    /* loaded from: classes4.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AboutActivity f20888a;

        public a(AboutActivity aboutActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aboutActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20888a = aboutActivity;
        }

        @Override // d.a.q0.z2.c.d
        public void a(int i2) {
            String str;
            String fileDireciory;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    this.f20888a.finish();
                } else if (i2 == 1) {
                    this.f20888a.checkUpdata();
                } else if (i2 == 2) {
                    this.f20888a.sendMessage(new CustomMessage(2015001, new GuildActivityConfig(this.f20888a.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i2 == 3) {
                    d.a.p0.s.d0.b.j().t(SettingTextFunctionIntroView.m, true);
                    d.a.p0.m.a.o(this.f20888a.getPageContext().getPageActivity(), this.f20888a.getPageContext().getString(R.string.function_intro), this.f20888a.functionIntroUrl, true, false, false);
                } else if (i2 != 4) {
                    if (i2 == 5) {
                        if (this.f20888a.mVisitPreviewServerDialog == null) {
                            AboutActivity aboutActivity = this.f20888a;
                            aboutActivity.mVisitPreviewServerDialog = new i(aboutActivity.getActivity());
                            this.f20888a.mVisitPreviewServerDialog.create(this.f20888a.getPageContext());
                        }
                        this.f20888a.mVisitPreviewServerDialog.show();
                    } else if (i2 == 6) {
                        if (PermissionUtil.checkWriteExternalStorage(this.f20888a)) {
                            this.f20888a.startCollectLog();
                            return;
                        }
                        AboutActivity aboutActivity2 = this.f20888a;
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
                    FileHelper.copyFile(str, fileDireciory);
                    FileHelper.CopyDir(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/newStat", FileHelper.getCacheDir() + "newStat", false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AboutActivity f20889a;

        public b(AboutActivity aboutActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aboutActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20889a = aboutActivity;
        }

        @Override // d.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f20889a.handlCallBack(obj);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            this.this$0.mView.u();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            d.a.q0.m1.c.b().a(true);
            AboutModel aboutModel = this.mModel;
            if (aboutModel == null) {
                this.mModel = new AboutModel(this, new b(this));
            } else {
                aboutModel.cancelLoadData();
            }
            this.mModel.A();
            d.a.q0.z2.c.a aVar = this.mView;
            if (aVar != null) {
                aVar.p();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlCallBack(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, obj) == null) {
            d.a.q0.z2.c.a aVar = this.mView;
            if (aVar != null) {
                aVar.q();
            }
            d.a.p0.t.e.e eVar = obj != null ? (d.a.p0.t.e.e) obj : null;
            if (eVar != null) {
                TbadkCoreApplication.getInst().setVersionData(eVar.s());
                TbadkCoreApplication.getInst().refreshNewVersion(false);
                if (eVar.s().hasNewVer() && TbConfig.COULD_UPDATE) {
                    if (eVar.s().forceUpdate()) {
                        sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.s(), eVar.j())));
                    } else {
                        Long valueOf = Long.valueOf(new Date().getTime());
                        CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.s(), eVar.j()));
                        TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                        sendMessage(customMessage);
                    }
                }
                d.a.q0.z2.c.a aVar2 = this.mView;
                if (aVar2 != null) {
                    aVar2.u();
                    return;
                }
                return;
            }
            showToast(getResources().getString(R.string.neterror));
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
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.q0.z2.c.a aVar = this.mView;
            if (aVar != null) {
                aVar.w(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            this.collectorManager = new d.a.q0.z2.c.j.a(this);
            d.a.q0.z2.c.a aVar = new d.a.q0.z2.c.a(this, new a(this));
            this.mView = aVar;
            aVar.u();
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
            d.a.q0.z2.c.a aVar = this.mView;
            if (aVar != null) {
                aVar.q();
            }
            i iVar = this.mVisitPreviewServerDialog;
            if (iVar != null) {
                iVar.dismiss();
            }
            d.a.q0.z2.c.j.a aVar2 = this.collectorManager;
            if (aVar2 != null) {
                aVar2.i();
                this.collectorManager = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048579, this, i2, strArr, iArr) == null) && i2 == this.REQUEST_WRITE_EXTERNAL_STORGE_PERMISSON) {
            if (PermissionUtil.checkWriteExternalStorage(getActivity().getApplicationContext())) {
                startCollectLog();
            } else {
                showToast(R.string.write_external_storage_permission_denied_fun_disable);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            d.a.q0.z2.c.a aVar = this.mView;
            if (aVar != null) {
                aVar.u();
            }
        }
    }
}
