package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ny4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public int f;
    public volatile boolean g;
    public volatile boolean h;
    public AtomicLong i;
    public ScheduledExecutorService j;
    public e k;
    public boolean l;
    public CustomMessageListener m;

    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ny4 b;

        /* loaded from: classes5.dex */
        public class a extends oj5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.oj5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.a.b.k();
                    if (Build.VERSION.SDK_INT >= 24) {
                        this.a.a.deleteSharedPreferences(AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS);
                    } else {
                        qy4.k().d();
                    }
                    qy4.k().u("key_is_jump_splash_ad", true);
                    qy4.k().H();
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class b implements ti5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.ti5
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    c cVar = this.a;
                    cVar.b.t(cVar.a);
                    yi.J(this.a.a);
                }
            }
        }

        public c(ny4 ny4Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny4Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ny4Var;
            this.a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(1048576, this, dialogInterface, i) != null) {
                return;
            }
            this.b.B("fix");
            this.b.z(this.a);
            sj5.b(new a(this), new b(this));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny4 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.g();
                }
            }
        }

        public e(ny4 ny4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ny4Var;
        }

        public /* synthetic */ e(ny4 ny4Var, a aVar) {
            this(ny4Var);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i.incrementAndGet();
                if (this.a.i.get() >= 10) {
                    ah.a().post(new a(this));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ny4 ny4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny4Var, Integer.valueOf(i)};
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
            this.a = ny4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ny4 b;

        public b(ny4 ny4Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny4Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ny4Var;
            this.a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(1048576, this, dialogInterface, i) != null) {
                return;
            }
            this.b.B("cancel");
            this.b.l();
            dialogInterface.dismiss();
            this.a.finish();
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final ny4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-559708576, "Lcom/baidu/tieba/ny4$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-559708576, "Lcom/baidu/tieba/ny4$d;");
                    return;
                }
            }
            a = new ny4(null);
        }
    }

    public ny4() {
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
        this.e = false;
        this.i = new AtomicLong(0L);
        this.k = new e(this, null);
        this.l = true;
        this.m = new a(this, 2001011);
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            boolean z = qy4.k().l("key_is_start_safe_mode", 0) == 1;
            this.a = z;
            if (!z) {
                return;
            }
            this.b = qy4.k().l("key_first_level_safe_mode_continuous_crash_time", 3);
            this.c = qy4.k().l("key_second_level_safe_mode_continuous_crash_time", 6);
            this.d = qy4.k().l("key_continupus_crash_times", 0);
            MessageManager.getInstance().registerListener(this.m);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            j();
            n(new File("/data/data/" + TbadkCoreApplication.getInst().getPackageName() + "/databases"));
            n(new File("/data/data/" + TbadkCoreApplication.getInst().getPackageName() + "/shared_prefs"));
            n(new File("/data/data/" + TbadkCoreApplication.getInst().getPackageName() + "/files"));
        }
    }

    public /* synthetic */ ny4(a aVar) {
        this();
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", str);
                uBCManager.onEvent("5087", jSONObject);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public final void n(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, file) == null) {
            FileHelper.deleteFileOrDir(file);
        }
    }

    public void x(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, activity) == null) && TbadkCoreApplication.getInst().isMainProcess(false) && n9.g().h() == 1) {
            q().g();
        }
    }

    public static final ny4 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return d.a;
        }
        return (ny4) invokeV.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a && !this.g && !this.h) {
            this.g = true;
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.j = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.scheduleWithFixedDelay(this.k, 0L, 1L, TimeUnit.SECONDS);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || !this.a || this.h) {
            return;
        }
        this.d++;
        qy4.k().w("key_continupus_crash_times", this.d);
        qy4.k().H();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.d > 0) {
            this.d = 0;
            qy4.k().w("key_continupus_crash_times", this.d);
            qy4.k().H();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d = 0;
            qy4.k().w("key_continupus_crash_times", this.d);
            qy4.k().u("key_is_jump_splash_ad", false);
        }
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public final void C(int i, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            if (i == 1) {
                str = "first_level";
            } else if (i == 2) {
                str = "second_level";
            } else {
                str = "";
            }
            try {
                jSONObject.put("type", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("crash_times", i2);
                jSONObject.put("ext", jSONObject2);
                uBCManager.onEvent("5081", jSONObject);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a && !this.h && this.g) {
            this.h = true;
            ScheduledExecutorService scheduledExecutorService = this.j;
            if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
                this.j.shutdownNow();
            }
            if (this.i.get() <= 5) {
                return;
            }
            l();
        }
    }

    public int i(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, activity)) == null) {
            if (!this.a || this.e) {
                return 0;
            }
            this.e = true;
            this.f = 0;
            int i = this.d;
            if (i >= this.c) {
                if (activity == null) {
                    return 0;
                }
                y(activity);
                this.f = 2;
                C(2, this.d);
                return this.f;
            } else if (i < this.b) {
                return 0;
            } else {
                j();
                this.f = 1;
                C(1, this.d);
                return this.f;
            }
        }
        return invokeL.intValue;
    }

    public final void z(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, activity) == null) {
            if (activity instanceof BaseActivity) {
                BaseActivity baseActivity = (BaseActivity) activity;
                baseActivity.showLoadingView(activity.getWindow().findViewById(16908290), true);
                ja5 loadingView = baseActivity.getLoadingView();
                if (loadingView != null) {
                    loadingView.q(R.string.obfuscated_res_0x7f0f0495);
                }
            } else if (activity instanceof BaseFragmentActivity) {
                BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) activity;
                baseFragmentActivity.showLoadingView(activity.getWindow().findViewById(16908290), true);
                ja5 loadingView2 = baseFragmentActivity.getLoadingView();
                if (loadingView2 != null) {
                    loadingView2.q(R.string.obfuscated_res_0x7f0f0495);
                }
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            n(new File(FileHelper.getCacheDir()));
            n(TbadkCoreApplication.getInst().getCacheDir());
            n(TbadkCoreApplication.getInst().getExternalCacheDir());
            jv4.f();
            try {
                jv4.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).g("0", null);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public final void t(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, activity) == null) {
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).hideLoadingView(activity.getWindow().findViewById(16908290));
            } else if (activity instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) activity).hideLoadingView(activity.getWindow().findViewById(16908290));
            }
        }
    }

    public final void y(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, activity) == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.obfuscated_res_0x7f1003df);
            builder.setMessage(R.string.obfuscated_res_0x7f0f03b5);
            builder.setCancelable(false);
            builder.setPositiveButton(R.string.obfuscated_res_0x7f0f05e5, new b(this, activity));
            builder.setNegativeButton(R.string.obfuscated_res_0x7f0f0654, new c(this, activity));
            builder.show();
        }
    }

    public boolean v(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, activity)) == null) {
            if (!q().u() || activity == null || !TbadkCoreApplication.getInst().isMainProcess(false) || !activity.getClass().getPackage().getName().startsWith("com.baidu.tieba") || !this.l || q().o() < q().r() || activity.getClass().getSimpleName().equals("MainTabActivity")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void w(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, activity) == null) && q().u() && activity != null && TbadkCoreApplication.getInst().isMainProcess(false) && activity.getClass().getPackage().getName().startsWith("com.baidu.tieba")) {
            if (this.l && q().o() >= q().r() && !activity.getClass().getSimpleName().equals("MainTabActivity")) {
                this.l = false;
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(activity).createNormalCfg(2)));
                activity.finish();
                return;
            }
            q().A();
        }
    }
}
