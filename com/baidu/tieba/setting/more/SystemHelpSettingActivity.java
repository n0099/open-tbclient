package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.bh8;
import com.baidu.tieba.dx4;
import com.baidu.tieba.ej;
import com.baidu.tieba.nu4;
import com.baidu.tieba.ox4;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.model.SystemHelpSettingModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bh8 a;
    public SystemHelpSettingModel b;
    public nu4 c;

    /* loaded from: classes5.dex */
    public class a extends BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SystemHelpSettingActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SystemHelpSettingActivity systemHelpSettingActivity) {
            super(systemHelpSettingActivity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {systemHelpSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((BaseActivity) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = systemHelpSettingActivity;
        }

        @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
        public void callback(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objArr) == null) {
                Object obj = objArr[0];
                if (objArr == null || !(obj instanceof MoreModel.TaskType)) {
                    return;
                }
                if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                    this.a.closeLoadingDialog();
                    this.a.a.l().setTip("");
                    this.a.showToast(R.string.obfuscated_res_0x7f0f1364);
                } else if (obj == MoreModel.TaskType.GET_SIZE) {
                    this.a.a.l().setTip((String) objArr[1]);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SystemHelpSettingActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {systemHelpSettingActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = systemHelpSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.closeLoadingDialog();
                this.a.showToast(R.string.obfuscated_res_0x7f0f1365);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SystemHelpSettingActivity a;

        public c(SystemHelpSettingActivity systemHelpSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {systemHelpSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = systemHelpSettingActivity;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SystemHelpSettingActivity a;

        public d(SystemHelpSettingActivity systemHelpSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {systemHelpSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = systemHelpSettingActivity;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                SystemHelpSettingActivity systemHelpSettingActivity = this.a;
                systemHelpSettingActivity.showLoadingDialog(systemHelpSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f04ca));
                this.a.b.D();
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SystemHelpSettingActivity a;

        public e(SystemHelpSettingActivity systemHelpSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {systemHelpSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = systemHelpSettingActivity;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SystemHelpSettingActivity a;

        public f(SystemHelpSettingActivity systemHelpSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {systemHelpSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = systemHelpSettingActivity;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
                SystemHelpSettingActivity systemHelpSettingActivity = this.a;
                systemHelpSettingActivity.showLoadingDialog(systemHelpSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f04ca));
                this.a.b.E();
            }
        }
    }

    public SystemHelpSettingActivity() {
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
        this.a = null;
        this.b = null;
    }

    public void B1(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("setting: ");
        if (str.equals("prefs_save_paled_video")) {
            sb.append("video ");
        } else if (str.equals("recnbar")) {
            sb.append("forum ");
        }
        sb.append(" uid:");
        sb.append(TbadkCoreApplication.getCurrentAccount());
        sb.append(" value:");
        sb.append(z);
        dx4.a(DI.ACCOUNT, -1L, 0, sb.toString(), 0, "", new Object[0]);
    }

    public final void C1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            boolean h = ox4.k().h("key_secret_is_show_new", false);
            boolean h2 = ox4.k().h("prefs_save_paled_video", false);
            ox4 k = ox4.k();
            boolean h3 = k.h("recnbar" + TbadkCoreApplication.getCurrentAccount(), false);
            dx4.a(DI.ACCOUNT, -1L, 0, "setting: " + str + " uid:" + TbadkCoreApplication.getCurrentAccount() + " " + h + " " + h2 + " " + h3, 0, "", new Object[0]);
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.p().i();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void i0(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, switchState) == null) || view2 == null) {
            return;
        }
        if (view2.equals(this.a.o())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.b.G(true);
            } else {
                this.b.G(false);
            }
        } else if (view2 == this.a.q()) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                ox4.k().u("prefs_save_paled_video", true);
            } else {
                ox4.k().u("prefs_save_paled_video", false);
            }
            B1("prefs_save_paled_video", BdSwitchView.SwitchState.ON == switchState);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        bh8 bh8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view2) == null) || (bh8Var = this.a) == null) {
            return;
        }
        if (view2 == bh8Var.l()) {
            if (this.b != null) {
                CyberPlayerManager.deleteVideoCache(null);
                if (TextUtils.isEmpty(this.a.l().getTip())) {
                    showToast(R.string.obfuscated_res_0x7f0f0c6e);
                } else {
                    this.c = new nu4(getPageContext().getPageActivity()).setMessageId(R.string.obfuscated_res_0x7f0f0262).setPositiveButton(R.string.obfuscated_res_0x7f0f026a, new d(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new c(this)).create(getPageContext()).show();
                }
            }
        } else if (view2 == this.a.m()) {
            if (this.b == null) {
                return;
            }
            this.c = new nu4(getPageContext().getPageActivity()).setMessageId(R.string.obfuscated_res_0x7f0f0263).setPositiveButton(R.string.obfuscated_res_0x7f0f026a, new f(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new e(this)).create(getPageContext()).show();
        } else if (view2 == this.a.p()) {
            sendMessage(new CustomMessage(2002001, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
        } else if (view2 == this.a.n()) {
            ej.K(this, "Debug工具入口迁移到了首页顶部！本入口即将移除~");
            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
            mainTabActivityConfig.setBottomTab(2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = new bh8(this);
            this.b = new SystemHelpSettingModel(this);
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                this.a.o().k();
            } else {
                this.a.o().h();
            }
            if (ox4.k().h("prefs_save_paled_video", true)) {
                this.a.q().k();
            } else {
                this.a.q().h();
            }
            this.a.l().setTip(getPageContext().getString(R.string.obfuscated_res_0x7f0f0365));
            this.a.l().b();
            this.b.H(new a(this));
            registerListener(new b(this, 2008016));
            C1("onCreate");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            nu4 nu4Var = this.c;
            if (nu4Var != null && nu4Var.isShowing()) {
                this.c.dismiss();
            }
            super.onDestroy();
            C1(MissionEvent.MESSAGE_DESTROY);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            SystemHelpSettingModel systemHelpSettingModel = this.b;
            if (systemHelpSettingModel != null) {
                systemHelpSettingModel.F();
            }
            D1();
        }
    }
}
