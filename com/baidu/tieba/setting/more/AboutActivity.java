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
import com.baidu.tieba.bx4;
import com.baidu.tieba.f25;
import com.baidu.tieba.fg8;
import com.baidu.tieba.gf7;
import com.baidu.tieba.ig8;
import com.baidu.tieba.lo4;
import com.baidu.tieba.ng8;
import com.baidu.tieba.og8;
import com.baidu.tieba.q9;
import com.baidu.tieba.setting.model.AboutModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes5.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fg8 a;
    public AboutModel b;
    public c c;
    public String d;
    public ng8 e;
    public og8 f;
    public int g;

    /* loaded from: classes5.dex */
    public class a implements ig8 {
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

        @Override // com.baidu.tieba.ig8
        public void a(int i) {
            String str;
            String fileDireciory;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.a.finish();
                } else if (i == 1) {
                    this.a.H1();
                } else if (i == 2) {
                    this.a.sendMessage(new CustomMessage(2015001, new GuildActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    bx4.k().u(SettingTextFunctionIntroView.h, true);
                    lo4.s(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f07a2), this.a.d, true, false, false);
                } else if (i != 4) {
                    if (i == 5) {
                        if (this.a.e == null) {
                            AboutActivity aboutActivity = this.a;
                            aboutActivity.e = new ng8(aboutActivity.getActivity());
                            this.a.e.create(this.a.getPageContext());
                        }
                        this.a.e.show();
                    } else if (i == 6) {
                        if (PermissionUtil.checkWriteExternalStorage(this.a)) {
                            this.a.K1();
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

    /* loaded from: classes5.dex */
    public class b extends q9 {
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

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.I1(obj);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            this.this$0.a.G();
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
        this.d = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/topic_page/110_1";
        this.g = 1;
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            gf7.b().a(true);
            AboutModel aboutModel = this.b;
            if (aboutModel == null) {
                this.b = new AboutModel(this, new b(this));
            } else {
                aboutModel.cancelLoadData();
            }
            this.b.D();
            fg8 fg8Var = this.a;
            if (fg8Var != null) {
                fg8Var.B();
            }
        }
    }

    public final void I1(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            fg8 fg8Var = this.a;
            if (fg8Var != null) {
                fg8Var.C();
            }
            f25 f25Var = obj != null ? (f25) obj : null;
            if (f25Var != null) {
                TbadkCoreApplication.getInst().setVersionData(f25Var.t());
                TbadkCoreApplication.getInst().refreshNewVersion(false);
                if (f25Var.t().hasNewVer() && TbConfig.COULD_UPDATE) {
                    if (f25Var.t().forceUpdate()) {
                        sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), f25Var.t(), f25Var.j())));
                    } else {
                        Long valueOf = Long.valueOf(new Date().getTime());
                        CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), f25Var.t(), f25Var.j()));
                        TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                        sendMessage(customMessage);
                    }
                }
                fg8 fg8Var2 = this.a;
                if (fg8Var2 != null) {
                    fg8Var2.G();
                    return;
                }
                return;
            }
            showToast(getResources().getString(R.string.obfuscated_res_0x7f0f0c59));
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = new c(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
            registerReceiver(this.c, intentFilter);
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f.d()) {
            return;
        }
        this.f.g();
    }

    public final void L1() {
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
            fg8 fg8Var = this.a;
            if (fg8Var != null) {
                fg8Var.I(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            this.f = new og8(this);
            fg8 fg8Var = new fg8(this, new a(this));
            this.a = fg8Var;
            fg8Var.G();
            J1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            L1();
            AboutModel aboutModel = this.b;
            if (aboutModel != null) {
                aboutModel.cancelLoadData();
            }
            fg8 fg8Var = this.a;
            if (fg8Var != null) {
                fg8Var.C();
            }
            ng8 ng8Var = this.e;
            if (ng8Var != null) {
                ng8Var.dismiss();
            }
            og8 og8Var = this.f;
            if (og8Var != null) {
                og8Var.i();
                this.f = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, strArr, iArr) == null) && i == this.g) {
            if (PermissionUtil.checkWriteExternalStorage(getActivity().getApplicationContext())) {
                K1();
            } else {
                showToast(R.string.obfuscated_res_0x7f0f15f1);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            fg8 fg8Var = this.a;
            if (fg8Var != null) {
                fg8Var.G();
            }
        }
    }
}
