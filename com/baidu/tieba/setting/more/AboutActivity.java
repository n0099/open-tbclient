package com.baidu.tieba.setting.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.ac7;
import com.repackage.c9;
import com.repackage.gc8;
import com.repackage.jc8;
import com.repackage.oc8;
import com.repackage.pc8;
import com.repackage.sl4;
import com.repackage.yt4;
import com.repackage.yy4;
import java.util.Date;
/* loaded from: classes4.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gc8 a;
    public AboutModel b;
    public c c;
    public String d;
    public oc8 e;
    public pc8 f;
    public int g;

    /* loaded from: classes4.dex */
    public class a implements jc8 {
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

        @Override // com.repackage.jc8
        public void a(int i) {
            String str;
            String fileDireciory;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.a.finish();
                } else if (i == 1) {
                    this.a.I1();
                } else if (i == 2) {
                    this.a.sendMessage(new CustomMessage(2015001, new GuildActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    yt4.k().u(SettingTextFunctionIntroView.h, true);
                    sl4.s(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f077f), this.a.d, true, false, false);
                } else if (i != 4) {
                    if (i == 5) {
                        if (this.a.e == null) {
                            AboutActivity aboutActivity = this.a;
                            aboutActivity.e = new oc8(aboutActivity.getActivity());
                            this.a.e.create(this.a.getPageContext());
                        }
                        this.a.e.show();
                    } else if (i == 6) {
                        if (PermissionUtil.checkWriteExternalStorage(this.a)) {
                            this.a.L1();
                            return;
                        }
                        AboutActivity aboutActivity2 = this.a;
                        PermissionUtil.requestWriteExternalStorgePermission(aboutActivity2, aboutActivity2.g);
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

    /* loaded from: classes4.dex */
    public class b extends c9 {
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

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.J1(obj);
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
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || this.this$0.a == null) {
                return;
            }
            this.this$0.a.x();
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
        this.c = null;
        this.d = TbConfig.SERVER_ADDRESS_WEB_VIEW + TbConfig.FUNCTION_INTRO_WEBVIEW;
        this.g = 1;
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ac7.b().a(true);
            AboutModel aboutModel = this.b;
            if (aboutModel == null) {
                this.b = new AboutModel(this, new b(this));
            } else {
                aboutModel.cancelLoadData();
            }
            this.b.E();
            gc8 gc8Var = this.a;
            if (gc8Var != null) {
                gc8Var.s();
            }
        }
    }

    public final void J1(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            gc8 gc8Var = this.a;
            if (gc8Var != null) {
                gc8Var.t();
            }
            yy4 yy4Var = obj != null ? (yy4) obj : null;
            if (yy4Var != null) {
                TbadkCoreApplication.getInst().setVersionData(yy4Var.s());
                TbadkCoreApplication.getInst().refreshNewVersion(false);
                if (yy4Var.s().hasNewVer() && TbConfig.COULD_UPDATE) {
                    if (yy4Var.s().forceUpdate()) {
                        sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), yy4Var.s(), yy4Var.j())));
                    } else {
                        Long valueOf = Long.valueOf(new Date().getTime());
                        CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), yy4Var.s(), yy4Var.j()));
                        TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                        sendMessage(customMessage);
                    }
                }
                gc8 gc8Var2 = this.a;
                if (gc8Var2 != null) {
                    gc8Var2.x();
                    return;
                }
                return;
            }
            showToast(getResources().getString(R.string.obfuscated_res_0x7f0f0c17));
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = new c(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
            registerReceiver(this.c, intentFilter);
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f.d()) {
            return;
        }
        this.f.g();
    }

    public final void M1() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.c) == null) {
            return;
        }
        unregisterReceiver(cVar);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            gc8 gc8Var = this.a;
            if (gc8Var != null) {
                gc8Var.z(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            this.f = new pc8(this);
            gc8 gc8Var = new gc8(this, new a(this));
            this.a = gc8Var;
            gc8Var.x();
            K1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            M1();
            AboutModel aboutModel = this.b;
            if (aboutModel != null) {
                aboutModel.cancelLoadData();
            }
            gc8 gc8Var = this.a;
            if (gc8Var != null) {
                gc8Var.t();
            }
            oc8 oc8Var = this.e;
            if (oc8Var != null) {
                oc8Var.dismiss();
            }
            pc8 pc8Var = this.f;
            if (pc8Var != null) {
                pc8Var.i();
                this.f = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, strArr, iArr) == null) && i == this.g) {
            if (PermissionUtil.checkWriteExternalStorage(getActivity().getApplicationContext())) {
                L1();
            } else {
                showToast(R.string.obfuscated_res_0x7f0f1584);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            gc8 gc8Var = this.a;
            if (gc8Var != null) {
                gc8Var.x();
            }
        }
    }
}
