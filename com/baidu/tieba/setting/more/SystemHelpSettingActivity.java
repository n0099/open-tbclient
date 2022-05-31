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
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.model.SystemHelpSettingModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dq4;
import com.repackage.la8;
import com.repackage.li;
import com.repackage.ns4;
import com.repackage.ys4;
/* loaded from: classes3.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dq4 mBdAlertDialog;
    public SystemHelpSettingModel mModel;
    public la8 mView;

    /* loaded from: classes3.dex */
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
                    this.a.mView.g().setTip("");
                    this.a.showToast(R.string.obfuscated_res_0x7f0f134f);
                } else if (obj == MoreModel.TaskType.GET_SIZE) {
                    this.a.mView.g().setTip((String) objArr[1]);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.showToast(R.string.obfuscated_res_0x7f0f1350);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                SystemHelpSettingActivity systemHelpSettingActivity = this.a;
                systemHelpSettingActivity.showLoadingDialog(systemHelpSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f04be));
                this.a.mModel.C();
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
                SystemHelpSettingActivity systemHelpSettingActivity = this.a;
                systemHelpSettingActivity.showLoadingDialog(systemHelpSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f04be));
                this.a.mModel.D();
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
        this.mView = null;
        this.mModel = null;
    }

    private void readSwitchStateLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            boolean h = ys4.k().h("key_secret_is_show_new", false);
            boolean h2 = ys4.k().h("prefs_save_paled_video", false);
            ys4 k = ys4.k();
            boolean h3 = k.h("recnbar" + TbadkCoreApplication.getCurrentAccount(), false);
            ns4.a(DI.ACCOUNT, -1L, 0, "setting: " + str + " uid:" + TbadkCoreApplication.getCurrentAccount() + " " + h + " " + h2 + " " + h3, 0, "", new Object[0]);
        }
    }

    private void refreshNew() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mView.k().i();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) || view2 == null) {
            return;
        }
        if (view2.equals(this.mView.j())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.mModel.F(true);
            } else {
                this.mModel.F(false);
            }
        } else if (view2 == this.mView.l()) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                ys4.k().u("prefs_save_paled_video", true);
            } else {
                ys4.k().u("prefs_save_paled_video", false);
            }
            changeSwitchStateLog("prefs_save_paled_video", BdSwitchView.SwitchState.ON == switchState);
        }
    }

    public void changeSwitchStateLog(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) || TextUtils.isEmpty(str)) {
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
        ns4.a(DI.ACCOUNT, -1L, 0, sb.toString(), 0, "", new Object[0]);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        la8 la8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || (la8Var = this.mView) == null) {
            return;
        }
        if (view2 == la8Var.g()) {
            if (this.mModel != null) {
                CyberPlayerManager.deleteVideoCache(null);
                if (TextUtils.isEmpty(this.mView.g().getTip())) {
                    showToast(R.string.obfuscated_res_0x7f0f0c48);
                } else {
                    this.mBdAlertDialog = new dq4(getPageContext().getPageActivity()).setMessageId(R.string.obfuscated_res_0x7f0f0258).setPositiveButton(R.string.obfuscated_res_0x7f0f0260, new d(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new c(this)).create(getPageContext()).show();
                }
            }
        } else if (view2 == this.mView.h()) {
            if (this.mModel == null) {
                return;
            }
            this.mBdAlertDialog = new dq4(getPageContext().getPageActivity()).setMessageId(R.string.obfuscated_res_0x7f0f0259).setPositiveButton(R.string.obfuscated_res_0x7f0f0260, new f(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new e(this)).create(getPageContext()).show();
        } else if (view2 == this.mView.k()) {
            sendMessage(new CustomMessage(2002001, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
        } else if (view2 == this.mView.i()) {
            li.L(this, "Debug工具入口迁移到了首页顶部！本入口即将移除~");
            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
            mainTabActivityConfig.setBottomTab(2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.mView = new la8(this);
            this.mModel = new SystemHelpSettingModel(this);
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                this.mView.j().l();
            } else {
                this.mView.j().i();
            }
            if (ys4.k().h("prefs_save_paled_video", true)) {
                this.mView.l().l();
            } else {
                this.mView.l().i();
            }
            this.mView.g().setTip(getPageContext().getString(R.string.obfuscated_res_0x7f0f0366));
            this.mView.g().b();
            this.mModel.G(new a(this));
            registerListener(new b(this, 2008016));
            readSwitchStateLog("onCreate");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            dq4 dq4Var = this.mBdAlertDialog;
            if (dq4Var != null && dq4Var.isShowing()) {
                this.mBdAlertDialog.dismiss();
            }
            super.onDestroy();
            readSwitchStateLog(MissionEvent.MESSAGE_DESTROY);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            SystemHelpSettingModel systemHelpSettingModel = this.mModel;
            if (systemHelpSettingModel != null) {
                systemHelpSettingModel.E();
            }
            refreshNew();
        }
    }
}
