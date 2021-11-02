package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.s.a;
import b.a.r0.c3.c.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DebugToolActivityConfig;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.model.SystemHelpSettingModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.q0.s.s.a mBdAlertDialog;
    public SystemHelpSettingModel mModel;
    public h mView;

    /* loaded from: classes9.dex */
    public class a extends BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SystemHelpSettingActivity f53890a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SystemHelpSettingActivity systemHelpSettingActivity) {
            super(systemHelpSettingActivity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {systemHelpSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((BaseActivity) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53890a = systemHelpSettingActivity;
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
                    this.f53890a.closeLoadingDialog();
                    this.f53890a.mView.d().setTip("");
                    this.f53890a.showToast(R.string.systemhelpsetting_clear_cache_success);
                } else if (obj == MoreModel.TaskType.GET_SIZE) {
                    this.f53890a.mView.d().setTip((String) objArr[1]);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SystemHelpSettingActivity f53891a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SystemHelpSettingActivity systemHelpSettingActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {systemHelpSettingActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53891a = systemHelpSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f53891a.closeLoadingDialog();
                this.f53891a.showToast(R.string.systemhelpsetting_clear_im_success);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SystemHelpSettingActivity f53892e;

        public c(SystemHelpSettingActivity systemHelpSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {systemHelpSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53892e = systemHelpSettingActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SystemHelpSettingActivity f53893e;

        public d(SystemHelpSettingActivity systemHelpSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {systemHelpSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53893e = systemHelpSettingActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                SystemHelpSettingActivity systemHelpSettingActivity = this.f53893e;
                systemHelpSettingActivity.showLoadingDialog(systemHelpSettingActivity.getPageContext().getString(R.string.deleting));
                this.f53893e.mModel.A();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SystemHelpSettingActivity f53894e;

        public e(SystemHelpSettingActivity systemHelpSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {systemHelpSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53894e = systemHelpSettingActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SystemHelpSettingActivity f53895e;

        public f(SystemHelpSettingActivity systemHelpSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {systemHelpSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53895e = systemHelpSettingActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                SystemHelpSettingActivity systemHelpSettingActivity = this.f53895e;
                systemHelpSettingActivity.showLoadingDialog(systemHelpSettingActivity.getPageContext().getString(R.string.deleting));
                this.f53895e.mModel.B();
            }
        }
    }

    public SystemHelpSettingActivity() {
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
        this.mView = null;
        this.mModel = null;
    }

    private void goBaiduWallet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2001351, new IntentConfig(getPageContext().getPageActivity())));
        }
    }

    private void refreshNew() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mView.h().refresh();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) || view == null) {
            return;
        }
        if (view.equals(this.mView.g())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.mModel.D(true);
            } else {
                this.mModel.D(false);
            }
        } else if (view == this.mView.i()) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                b.a.q0.s.e0.b.j().t("prefs_save_paled_video", true);
            } else {
                b.a.q0.s.e0.b.j().t("prefs_save_paled_video", false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || (hVar = this.mView) == null) {
            return;
        }
        if (view == hVar.d()) {
            if (this.mModel != null) {
                CyberPlayerManager.deleteVideoCache(null);
                if (TextUtils.isEmpty(this.mView.d().getTip())) {
                    showToast(R.string.no_cache_delete);
                } else {
                    this.mBdAlertDialog = new b.a.q0.s.s.a(getPageContext().getPageActivity()).setMessageId(R.string.alert_clear_all_cache).setPositiveButton(R.string.alert_yes_button, new d(this)).setNegativeButton(R.string.cancel, new c(this)).create(getPageContext()).show();
                }
            }
        } else if (view == this.mView.e()) {
            if (this.mModel == null) {
                return;
            }
            this.mBdAlertDialog = new b.a.q0.s.s.a(getPageContext().getPageActivity()).setMessageId(R.string.alert_clear_cache).setPositiveButton(R.string.alert_yes_button, new f(this)).setNegativeButton(R.string.cancel, new e(this)).create(getPageContext()).show();
        } else if (view == this.mView.h()) {
            sendMessage(new CustomMessage(2002001, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mView.f()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DebugToolActivityConfig(this)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.mView = new h(this);
            this.mModel = new SystemHelpSettingModel(this);
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                this.mView.g().turnOn();
            } else {
                this.mView.g().turnOff();
            }
            if (b.a.q0.s.e0.b.j().g("prefs_save_paled_video", true)) {
                this.mView.i().turnOn();
            } else {
                this.mView.i().turnOff();
            }
            this.mView.d().setTip(getPageContext().getString(R.string.calc_cache_size));
            this.mView.d().displayTip();
            this.mModel.E(new a(this));
            registerListener(new b(this, 2008016));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.a.q0.s.s.a aVar = this.mBdAlertDialog;
            if (aVar != null && aVar.isShowing()) {
                this.mBdAlertDialog.dismiss();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            SystemHelpSettingModel systemHelpSettingModel = this.mModel;
            if (systemHelpSettingModel != null) {
                systemHelpSettingModel.C();
            }
            refreshNew();
        }
    }
}
