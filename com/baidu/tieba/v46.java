package com.baidu.tieba;

import android.app.Application;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.PageCountSwitch;
import com.baidu.tieba.w46;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class v46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v46 j;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public boolean b;
    public gx4 c;
    public CustomMessageListener d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public CustomMessageListener h;
    public CustomMessageListener i;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v46 v46Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v46Var, Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && uy9.m().j() != null) {
                uy9.m().j().b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v46 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(v46 v46Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v46Var, Integer.valueOf(i)};
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
            this.a = v46Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !PageCountSwitch.isOn() && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof LogoActivity)) {
                    this.a.e();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v46 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(v46 v46Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v46Var, Integer.valueOf(i)};
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
            this.a = v46Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || PageCountSwitch.isOn() || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016520 || this.a.a == 0) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data.getClass().getSimpleName().equals(LoginActivity.E) || (data instanceof LogoActivity)) {
                return;
            }
            this.a.f(data);
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v46 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(v46 v46Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v46Var, Integer.valueOf(i)};
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
            this.a = v46Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && PageCountSwitch.isOn() && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921813) {
                if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof LogoActivity)) {
                    this.a.e();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v46 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(v46 v46Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v46Var, Integer.valueOf(i)};
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
            this.a = v46Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !PageCountSwitch.isOn() || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921812 || this.a.a == 0) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data.getClass().getSimpleName().equals(LoginActivity.E) || (data instanceof LogoActivity)) {
                return;
            }
            this.a.f(data);
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v46 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(v46 v46Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v46Var, Integer.valueOf(i)};
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
            this.a = v46Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        v46 v46Var = this.a;
                        if (currentTimeMillis - v46Var.a <= 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        v46Var.b = z;
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements w46.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v46 a;

        public g(v46 v46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v46Var;
        }

        @Override // com.baidu.tieba.w46.c
        public void a(Application application) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, application) != null) || PageCountSwitch.isOn() || !UbsABTestHelper.isFixHotSplashRule()) {
                return;
            }
            this.a.e();
        }

        @Override // com.baidu.tieba.w46.c
        public void b(Application application) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, application) != null) || PageCountSwitch.isOn() || !UbsABTestHelper.isFixHotSplashRule()) {
                return;
            }
            this.a.f(application);
        }
    }

    public v46() {
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
        this.d = new a(this, 2016522);
        this.e = new b(this, 2016521);
        this.f = new c(this, 2016520);
        this.g = new d(this, 2921813);
        this.h = new e(this, 2921812);
        this.i = new f(this, 2016523);
        this.b = false;
        MessageManager.getInstance().registerListener(this.e);
        MessageManager.getInstance().registerListener(this.f);
        MessageManager.getInstance().registerListener(this.g);
        MessageManager.getInstance().registerListener(this.h);
        MessageManager.getInstance().registerListener(this.d);
        MessageManager.getInstance().registerListener(this.i);
        if (uy9.m().j() != null) {
            uy9.m().j().c();
        }
        w46.b().c(new g(this));
    }

    public static v46 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (j == null) {
                synchronized (v46.class) {
                    if (j == null) {
                        j = new v46();
                    }
                }
            }
            return j;
        }
        return (v46) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = System.currentTimeMillis() / 1000;
        }
    }

    public final void f(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) != null) || MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
            return;
        }
        boolean g2 = g();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis - this.a > 5) {
            new StatisticItem(TbadkCoreStatisticKey.HOT_SPLASH_APP_START).param("obj_param1", g2 ? 1 : 0).param(TiebaStatic.Params.OBJ_PARAM2, currentTimeMillis - this.a).param(TiebaStatic.Params.OBJ_PARAM3, r85.b ? 1 : 0).eventStat();
            if (r85.b) {
                r85.b = false;
            }
            lz5.f(new WeakReference(TbadkCoreApplication.getInst()));
        }
        if (g2) {
            TbSingleton.getInstance().isCanShowHotSplash = true;
            LogoActivityConfig.IS_HOT_SPLASH_SHOW = true;
            if (obj instanceof BaseActivity) {
                BaseActivity baseActivity = (BaseActivity) obj;
                Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                intent.putExtra(SpeedStatsUtils.UBC_VALUE_SPLASH, true);
                intent.setFlags(65536);
                baseActivity.startActivity(intent);
            } else if (obj instanceof BaseFragmentActivity) {
                BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) obj;
                Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                intent2.putExtra(SpeedStatsUtils.UBC_VALUE_SPLASH, true);
                intent2.setFlags(65536);
                baseFragmentActivity.getActivity().startActivity(intent2);
            } else if (obj instanceof Application) {
                Application application = (Application) obj;
                Intent intent3 = new Intent(application, LogoActivity.class);
                intent3.putExtra(SpeedStatsUtils.UBC_VALUE_SPLASH, true);
                intent3.setFlags(268500992);
                application.startActivity(intent3);
            }
            TbadkCoreApplication.getInst().setCanShowHotSplash(2);
            return;
        }
        TbadkCoreApplication.getInst().setCanShowHotSplash(1);
    }

    public final boolean g() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = i();
            int j2 = j();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.b) {
                this.b = false;
                return false;
            }
            long j3 = this.a;
            if (currentTimeMillis - j3 <= 2) {
                return false;
            }
            if (currentTimeMillis - j3 <= i2) {
                BaseVM.m(7);
                return false;
            }
            oy9 j4 = uy9.m().j();
            if (j4 != null) {
                i = j4.a();
            } else {
                i = j2;
            }
            PrintStream printStream = System.out;
            printStream.println("TestTest => hotSplashMaxTime: " + j2 + " currentTime: " + i + " interval: " + i2);
            if (i >= j2) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final int i() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (fx5.a()) {
                return 3;
            }
            if (this.c == null && (runTask = MessageManager.getInstance().runTask(2921564, gx4.class)) != null) {
                this.c = (gx4) runTask.getData();
            }
            gx4 gx4Var = this.c;
            if (gx4Var != null) {
                return (int) (gx4Var.a() * 60.0f);
            }
            ed5 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                int b2 = adAdSense.b();
                if (b2 <= 0) {
                    return 86400;
                }
                return b2;
            }
            return 300;
        }
        return invokeV.intValue;
    }

    public final int j() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (fx5.a()) {
                return 1000000;
            }
            if (this.c == null && (runTask = MessageManager.getInstance().runTask(2921564, gx4.class)) != null) {
                this.c = (gx4) runTask.getData();
            }
            gx4 gx4Var = this.c;
            if (gx4Var != null) {
                return gx4Var.b();
            }
            return 3;
        }
        return invokeV.intValue;
    }
}
