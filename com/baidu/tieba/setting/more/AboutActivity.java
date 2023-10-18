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
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.UploadLogButtonSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.g4;
import com.baidu.tieba.h5a;
import com.baidu.tieba.k5a;
import com.baidu.tieba.l95;
import com.baidu.tieba.p5a;
import com.baidu.tieba.q5a;
import com.baidu.tieba.setting.model.AboutModel;
import com.baidu.tieba.yx8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes8.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h5a a;
    public AboutModel b;
    public c c;
    public String d;
    public p5a e;
    public q5a f;
    public int g;

    /* loaded from: classes8.dex */
    public class a implements k5a {
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

        @Override // com.baidu.tieba.k5a
        public void a(int i) {
            String str;
            String fileDireciory;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.a.finish();
                } else if (i == 1) {
                    this.a.Z0();
                } else if (i == 2) {
                    this.a.sendMessage(new CustomMessage(2015001, new GuildActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    SharedPrefHelper.getInstance().putBoolean(SettingTextFunctionIntroView.h, true);
                    BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.function_intro), this.a.d, true, false, false);
                } else if (i == 4) {
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
                } else if (i == 5) {
                    if (this.a.e == null) {
                        AboutActivity aboutActivity = this.a;
                        aboutActivity.e = new p5a(aboutActivity.getActivity());
                        this.a.e.create(this.a.getPageContext());
                    }
                    this.a.e.show();
                } else if (i == 6) {
                    UploadLogButtonSwitch.forceOn(true);
                    if (PermissionUtil.checkWriteExternalStorage(this.a)) {
                        this.a.c1();
                        return;
                    }
                    AboutActivity aboutActivity2 = this.a;
                    PermissionUtil.requestWriteExternalStorgePermission(aboutActivity2, aboutActivity2.g);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends g4 {
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

        @Override // com.baidu.tieba.g4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, obj) != null) {
                return;
            }
            this.a.a1(obj);
        }
    }

    /* loaded from: classes8.dex */
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

        public /* synthetic */ c(AboutActivity aboutActivity, a aVar) {
            this(aboutActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && this.this$0.a != null) {
                this.this$0.a.S();
            }
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
        this.d = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/topic_page/110_1";
        this.g = 1;
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            yx8.b().a(true);
            AboutModel aboutModel = this.b;
            if (aboutModel == null) {
                this.b = new AboutModel(this, new b(this));
            } else {
                aboutModel.cancelLoadData();
            }
            this.b.R();
            h5a h5aVar = this.a;
            if (h5aVar != null) {
                h5aVar.N();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            d1();
            AboutModel aboutModel = this.b;
            if (aboutModel != null) {
                aboutModel.cancelLoadData();
            }
            h5a h5aVar = this.a;
            if (h5aVar != null) {
                h5aVar.O();
            }
            p5a p5aVar = this.e;
            if (p5aVar != null) {
                p5aVar.dismiss();
            }
            q5a q5aVar = this.f;
            if (q5aVar != null) {
                q5aVar.i();
                this.f = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            h5a h5aVar = this.a;
            if (h5aVar != null) {
                h5aVar.U(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            this.f = new q5a();
            h5a h5aVar = new h5a(this, new a(this));
            this.a = h5aVar;
            h5aVar.S();
            b1();
        }
    }

    public final void a1(Object obj) {
        l95 l95Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            h5a h5aVar = this.a;
            if (h5aVar != null) {
                h5aVar.O();
            }
            if (obj != null) {
                l95Var = (l95) obj;
            } else {
                l95Var = null;
            }
            if (l95Var != null) {
                TbadkCoreApplication.getInst().setVersionData(l95Var.v());
                TbadkCoreApplication.getInst().refreshNewVersion(false);
                if (l95Var.v().hasNewVer() && TbConfig.COULD_UPDATE) {
                    if (l95Var.v().forceUpdate()) {
                        sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), l95Var.v(), l95Var.j())));
                    } else {
                        Long valueOf = Long.valueOf(new Date().getTime());
                        CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), l95Var.v(), l95Var.j()));
                        TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                        sendMessage(customMessage);
                    }
                }
                h5a h5aVar2 = this.a;
                if (h5aVar2 != null) {
                    h5aVar2.S();
                    return;
                }
                return;
            }
            showToast(getResources().getString(R.string.obfuscated_res_0x7f0f0e4f));
        }
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = new c(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
            registerReceiver(this.c, intentFilter);
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.f.d()) {
            this.f.g();
        }
    }

    public final void d1() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (cVar = this.c) != null) {
            unregisterReceiver(cVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            h5a h5aVar = this.a;
            if (h5aVar != null) {
                h5aVar.S();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, strArr, iArr) == null) && i == this.g) {
            if (PermissionUtil.checkWriteExternalStorage(getActivity().getApplicationContext())) {
                c1();
            } else {
                showToast(R.string.write_external_storage_permission_denied_fun_disable);
            }
        }
    }
}
