package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class o59 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static volatile o59 u;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public e c;
    public Application d;
    public e59 e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public boolean m;
    public int n;
    public int o;
    public volatile boolean p;
    public int q;
    public long r;
    public Runnable s;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o59 a;

        public a(o59 o59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o59Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
                j49.w().J(this.a.s, 5000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o59 this$0;

        public b(o59 o59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = o59Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null) {
                return;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                    return;
                }
                this.this$0.w();
            } catch (Exception unused) {
                if (o59.t) {
                    Log.d("UBCUploadTimingManager", "get network info error!");
                }
            }
        }

        public /* synthetic */ b(o59 o59Var, a aVar) {
            this(o59Var);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o59 a;

        public c(o59 o59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o59Var;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
                o59.d(this.a);
                if (this.a.a == 1) {
                    this.a.r();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
                o59.e(this.a);
                if (this.a.a == 0) {
                    this.a.u();
                }
            }
        }

        public /* synthetic */ c(o59 o59Var, a aVar) {
            this(o59Var);
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947983382, "Lcom/baidu/tieba/o59;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947983382, "Lcom/baidu/tieba/o59;");
                return;
            }
        }
        t = h59.m();
    }

    public o59() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 0L;
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = 10000;
        this.m = false;
        this.n = 100;
        this.o = TiebaStatic.MAX_COST_VALUE;
        this.p = false;
        this.q = 0;
        this.r = SystemClock.uptimeMillis();
        this.s = new a(this);
    }

    public static /* synthetic */ int d(o59 o59Var) {
        int i = o59Var.a;
        o59Var.a = i + 1;
        return i;
    }

    public static /* synthetic */ int e(o59 o59Var) {
        int i = o59Var.a;
        o59Var.a = i - 1;
        return i;
    }

    public static o59 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (u == null) {
                synchronized (o59.class) {
                    if (u == null) {
                        u = new o59();
                    }
                }
            }
            return u;
        }
        return (o59) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onTimerArrived");
            }
            e eVar = this.c;
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onUploadFinish isSuccess: " + z);
            }
            this.q = Math.max(this.q - 1, 0);
            if (z) {
                C();
            }
            if (this.h) {
                this.r = SystemClock.uptimeMillis();
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j(true, 0, 0);
            if (this.j && this.q == 0) {
                if (t) {
                    Log.d("UBCUploadTimingManager", "onUploadSuccess processOneFailedData");
                }
                j49.w().H();
            }
        }
    }

    public final void j(boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) && this.i) {
            if (z) {
                if (q()) {
                    return;
                }
                v();
                return;
            }
            boolean q = q();
            this.g += i;
            this.f += i2;
            if (!q || q()) {
                return;
            }
            v();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.h && this.q == 0 && SystemClock.uptimeMillis() - this.r >= this.o) {
            A();
        }
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.k) {
                return this.l;
            }
            return m49.o().l();
        }
        return invokeV.intValue;
    }

    public void n(Context context, e59 e59Var, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, context, e59Var, eVar) == null) || context == null) {
            return;
        }
        Application application = (Application) context.getApplicationContext();
        this.d = application;
        application.registerActivityLifecycleCallbacks(new c(this, null));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.d.registerReceiver(new b(this, null), intentFilter);
        this.e = e59Var;
        this.c = eVar;
        this.k = h59.i().a();
        this.l = h59.i().f();
        if (this.k) {
            this.e.k();
        }
        this.m = h59.i().o();
        d s = this.e.s();
        this.f = Math.max(s.a, 0);
        this.g = Math.max(s.b, 0);
        this.i = h59.i().k();
        this.h = h59.i().e();
        this.j = h59.i().p();
        this.n = m49.o().A();
        int B = m49.o().B() * 1000;
        this.o = B;
        if (!this.h || B <= 0 || this.p) {
            return;
        }
        j49.w().J(this.s, 5000L);
        this.p = true;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f + this.g < this.n : invokeV.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onBackgroundToForeground");
            }
            e eVar = this.c;
            if (eVar != null) {
                eVar.c();
            }
        }
    }

    public void s(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) || !this.i || i < 0 || i2 < 0 || i + i2 == 0) {
            return;
        }
        if (t) {
            Log.d("UBCUploadTimingManager", "onClearData eventCount=" + i + ", flowCount=" + i2);
        }
        this.f = Math.max(this.f - i, 0);
        this.g = Math.max(this.g - i2, 0);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.i) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onClearDataAndReset");
            }
            d s = this.e.s();
            this.f = Math.max(s.a, 0);
            this.g = Math.max(s.b, 0);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onForegroundToBackground");
            }
            e eVar = this.c;
            if (eVar != null) {
                eVar.d();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onLogTooMany");
            }
            e eVar = this.c;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onNetworkAvailable");
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.b > 60000) {
                e eVar = this.c;
                if (eVar != null) {
                    eVar.e();
                }
                if (t) {
                    Log.d("UBCUploadTimingManager", "onNetworkAvailable filter completed!");
                }
            }
            this.b = currentTimeMillis;
        }
    }

    public void x(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048592, this, str, i) == null) && this.i && i == -1 && !m49.o().f(str) && m49.o().i(str)) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onNewEvent id=" + str + ", currentEventCount=" + this.f);
            }
            j(false, 0, 1);
        }
    }

    public void y(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) && this.i && i > 0 && !m49.o().f(str) && m49.o().i(str)) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onNewFlow id=" + str + ", currentFlowCount=" + this.g);
            }
            j(false, i, 0);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.q++;
        }
    }
}
