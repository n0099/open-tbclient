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
import com.baidu.tbadk.switchs.UploadLogButtonSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.az8;
import com.baidu.tieba.b4a;
import com.baidu.tieba.c4a;
import com.baidu.tieba.da5;
import com.baidu.tieba.k9;
import com.baidu.tieba.nx4;
import com.baidu.tieba.setting.model.AboutModel;
import com.baidu.tieba.t3a;
import com.baidu.tieba.w3a;
import com.baidu.tieba.yf5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes7.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t3a a;
    public AboutModel b;
    public c c;
    public String d;
    public b4a e;
    public c4a f;
    public int g;

    /* loaded from: classes7.dex */
    public class a implements w3a {
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

        @Override // com.baidu.tieba.w3a
        public void a(int i) {
            String str;
            String fileDireciory;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.a.finish();
                } else if (i != 1) {
                    if (i == 2) {
                        this.a.sendMessage(new CustomMessage(2015001, new GuildActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                    } else if (i == 3) {
                        da5.p().A(SettingTextFunctionIntroView.h, true);
                        nx4.x(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.function_intro), this.a.d, true, false, false);
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
                            aboutActivity.e = new b4a(aboutActivity.getActivity());
                            this.a.e.create(this.a.getPageContext());
                        }
                        this.a.e.show();
                    } else if (i == 6) {
                        UploadLogButtonSwitch.forceOn(true);
                        if (!PermissionUtil.checkWriteExternalStorage(this.a)) {
                            AboutActivity aboutActivity2 = this.a;
                            PermissionUtil.requestWriteExternalStorgePermission(aboutActivity2, aboutActivity2.g);
                            return;
                        }
                        this.a.H1();
                    }
                } else {
                    this.a.D1();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends k9 {
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

        @Override // com.baidu.tieba.k9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, obj) != null) {
                return;
            }
            this.a.E1(obj);
        }
    }

    /* loaded from: classes7.dex */
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
                this.this$0.a.Y();
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

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            az8.b().a(true);
            AboutModel aboutModel = this.b;
            if (aboutModel == null) {
                this.b = new AboutModel(this, new b(this));
            } else {
                aboutModel.cancelLoadData();
            }
            this.b.Z();
            t3a t3aVar = this.a;
            if (t3aVar != null) {
                t3aVar.T();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            I1();
            AboutModel aboutModel = this.b;
            if (aboutModel != null) {
                aboutModel.cancelLoadData();
            }
            t3a t3aVar = this.a;
            if (t3aVar != null) {
                t3aVar.U();
            }
            b4a b4aVar = this.e;
            if (b4aVar != null) {
                b4aVar.dismiss();
            }
            c4a c4aVar = this.f;
            if (c4aVar != null) {
                c4aVar.i();
                this.f = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            t3a t3aVar = this.a;
            if (t3aVar != null) {
                t3aVar.a0(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            this.f = new c4a();
            t3a t3aVar = new t3a(this, new a(this));
            this.a = t3aVar;
            t3aVar.Y();
            F1();
        }
    }

    public final void E1(Object obj) {
        yf5 yf5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            t3a t3aVar = this.a;
            if (t3aVar != null) {
                t3aVar.U();
            }
            if (obj != null) {
                yf5Var = (yf5) obj;
            } else {
                yf5Var = null;
            }
            if (yf5Var != null) {
                TbadkCoreApplication.getInst().setVersionData(yf5Var.u());
                TbadkCoreApplication.getInst().refreshNewVersion(false);
                if (yf5Var.u().hasNewVer() && TbConfig.COULD_UPDATE) {
                    if (yf5Var.u().forceUpdate()) {
                        sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), yf5Var.u(), yf5Var.j())));
                    } else {
                        Long valueOf = Long.valueOf(new Date().getTime());
                        CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), yf5Var.u(), yf5Var.j()));
                        TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                        sendMessage(customMessage);
                    }
                }
                t3a t3aVar2 = this.a;
                if (t3aVar2 != null) {
                    t3aVar2.Y();
                    return;
                }
                return;
            }
            showToast(getResources().getString(R.string.obfuscated_res_0x7f0f0e1f));
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = new c(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
            registerReceiver(this.c, intentFilter);
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.f.d()) {
            this.f.g();
        }
    }

    public final void I1() {
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
            t3a t3aVar = this.a;
            if (t3aVar != null) {
                t3aVar.Y();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, strArr, iArr) == null) && i == this.g) {
            if (PermissionUtil.checkWriteExternalStorage(getActivity().getApplicationContext())) {
                H1();
            } else {
                showToast(R.string.write_external_storage_permission_denied_fun_disable);
            }
        }
    }
}
