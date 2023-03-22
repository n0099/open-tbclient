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
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.retrieve.core.task.UploadTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.b35;
import com.baidu.tieba.hi;
import com.baidu.tieba.i49;
import com.baidu.tieba.jg;
import com.baidu.tieba.log.TbLogManager;
import com.baidu.tieba.m35;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.model.SystemHelpSettingModel;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i49 a;
    public SystemHelpSettingModel b;
    public zz4 c;

    /* loaded from: classes6.dex */
    public class g implements TbLogManager.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ SystemHelpSettingActivity b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    SystemHelpSettingActivity systemHelpSettingActivity = this.a.b;
                    systemHelpSettingActivity.showToast("上报成功：" + this.a.a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ g b;

            public b(g gVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    SystemHelpSettingActivity systemHelpSettingActivity = this.b.b;
                    systemHelpSettingActivity.showToast("上报失败：" + this.a);
                }
            }
        }

        public g(SystemHelpSettingActivity systemHelpSettingActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {systemHelpSettingActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = systemHelpSettingActivity;
            this.a = str;
        }

        @Override // com.baidu.tieba.log.TbLogManager.b
        public void onFailure(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                jg.a().post(new b(this, str));
            }
        }

        @Override // com.baidu.tieba.log.TbLogManager.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                jg.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (objArr != null && (obj instanceof MoreModel.TaskType)) {
                    if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                        this.a.closeLoadingDialog();
                        this.a.a.m().setTip("");
                        this.a.showToast(R.string.obfuscated_res_0x7f0f143c);
                    } else if (obj == MoreModel.TaskType.GET_SIZE) {
                        this.a.a.m().setTip((String) objArr[1]);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.showToast(R.string.obfuscated_res_0x7f0f143d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                SystemHelpSettingActivity systemHelpSettingActivity = this.a;
                systemHelpSettingActivity.showLoadingDialog(systemHelpSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f04f7));
                this.a.b.U();
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
                SystemHelpSettingActivity systemHelpSettingActivity = this.a;
                systemHelpSettingActivity.showLoadingDialog(systemHelpSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f04f7));
                this.a.b.V();
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

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.q().i();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            zz4 zz4Var = this.c;
            if (zz4Var != null && zz4Var.isShowing()) {
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
                systemHelpSettingModel.W();
            }
            E1();
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

    public void B1(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, str, z) != null) || TextUtils.isEmpty(str)) {
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
        b35.a(DI.ACCOUNT, -1L, 0, sb.toString(), 0, "", new Object[0]);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void g0(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, view2, switchState) != null) || view2 == null) {
            return;
        }
        boolean z = true;
        if (view2.equals(this.a.p())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.b.X(true);
            } else {
                this.b.X(false);
            }
        } else if (view2 == this.a.s()) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                m35.m().w("prefs_save_paled_video", true);
            } else {
                m35.m().w("prefs_save_paled_video", false);
            }
            if (BdSwitchView.SwitchState.ON != switchState) {
                z = false;
            }
            B1("prefs_save_paled_video", z);
        }
    }

    public final void C1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            boolean i = m35.m().i("key_secret_is_show_new", false);
            boolean i2 = m35.m().i("prefs_save_paled_video", false);
            m35 m = m35.m();
            boolean i3 = m.i("recnbar" + TbadkCoreApplication.getCurrentAccount(), false);
            b35.a(DI.ACCOUNT, -1L, 0, "setting: " + str + " uid:" + TbadkCoreApplication.getCurrentAccount() + " " + i + " " + i2 + " " + i3, 0, "", new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = new i49(this);
            this.b = new SystemHelpSettingModel(this);
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                this.a.p().k();
            } else {
                this.a.p().h();
            }
            if (m35.m().i("prefs_save_paled_video", true)) {
                this.a.s().k();
            } else {
                this.a.s().h();
            }
            this.a.m().setTip(getPageContext().getString(R.string.obfuscated_res_0x7f0f037d));
            this.a.m().b();
            this.b.Y(new a(this));
            registerListener(new b(this, 2008016));
            C1("onCreate");
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        i49 i49Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, view2) != null) || (i49Var = this.a) == null) {
            return;
        }
        if (view2 == i49Var.m()) {
            if (this.b != null) {
                CyberPlayerManager.deleteVideoCache(null);
                if (TextUtils.isEmpty(this.a.m().getTip())) {
                    showToast(R.string.obfuscated_res_0x7f0f0d38);
                } else {
                    this.c = new zz4(getPageContext().getPageActivity()).setMessageId(R.string.obfuscated_res_0x7f0f0267).setPositiveButton(R.string.alert_yes_button, new d(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new c(this)).create(getPageContext()).show();
                }
            }
        } else if (view2 == this.a.n()) {
            if (this.b == null) {
                return;
            }
            this.c = new zz4(getPageContext().getPageActivity()).setMessageId(R.string.alert_clear_cache).setPositiveButton(R.string.alert_yes_button, new f(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new e(this)).create(getPageContext()).show();
        } else if (view2 == this.a.q()) {
            sendMessage(new CustomMessage(2002001, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
        } else if (view2 == this.a.o()) {
            hi.N(this, "Debug工具入口迁移到了首页顶部！本入口即将移除~");
            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
            mainTabActivityConfig.setBottomTab(2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
        } else if (view2 == this.a.r()) {
            TbLogManager.flushDefault();
            ArrayList arrayList = new ArrayList();
            arrayList.add("*/*");
            String str = "flow-android-" + TbadkCoreApplication.getInst().getVersionName();
            TbLogManager.activeUpload(str, ADConfigError.REQUEST_HAS_SUCCESS_BEFORE, arrayList, UploadTask.SIZE_LIMIT_DEFAULT, 0L, System.currentTimeMillis(), new g(this, str));
        }
    }
}
