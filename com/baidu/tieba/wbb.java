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
import com.baidu.searchbox.dns.stratege.DnsStrategy;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wbb {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static volatile wbb u;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public e c;
    public Application d;
    public mbb e;
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

    /* loaded from: classes8.dex */
    public interface e {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wbb a;

        public a(wbb wbbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wbbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wbbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.k();
            rab.w().J(this.a.s, 5000L);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wbb this$0;

        public b(wbb wbbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wbbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = wbbVar;
        }

        public /* synthetic */ b(wbb wbbVar, a aVar) {
            this(wbbVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null) {
                return;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                    this.this$0.w();
                }
            } catch (Exception unused) {
                if (wbb.t) {
                    Log.d("UBCUploadTimingManager", "get network info error!");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wbb a;

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

        public c(wbb wbbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wbbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wbbVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
                wbb.d(this.a);
                if (this.a.a != 1) {
                    return;
                }
                this.a.r();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
                wbb.e(this.a);
                if (this.a.a != 0) {
                    return;
                }
                this.a.u();
            }
        }

        public /* synthetic */ c(wbb wbbVar, a aVar) {
            this(wbbVar);
        }
    }

    /* loaded from: classes8.dex */
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948266226, "Lcom/baidu/tieba/wbb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948266226, "Lcom/baidu/tieba/wbb;");
                return;
            }
        }
        t = pbb.m();
    }

    public static wbb m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (u == null) {
                synchronized (wbb.class) {
                    if (u == null) {
                        u = new wbb();
                    }
                }
            }
            return u;
        }
        return (wbb) invokeV.objValue;
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

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j(true, 0, 0);
            if (this.j && this.q == 0) {
                if (t) {
                    Log.d("UBCUploadTimingManager", "onUploadSuccess processOneFailedData");
                }
                rab.w().H();
            }
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
            return uab.o().l();
        }
        return invokeV.intValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f + this.g < this.n) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
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

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.q++;
        }
    }

    public wbb() {
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
        this.o = DnsStrategy.Factory.PRE_FETCH_INTERVAL;
        this.p = false;
        this.q = 0;
        this.r = SystemClock.uptimeMillis();
        this.s = new a(this);
    }

    public static /* synthetic */ int d(wbb wbbVar) {
        int i = wbbVar.a;
        wbbVar.a = i + 1;
        return i;
    }

    public static /* synthetic */ int e(wbb wbbVar) {
        int i = wbbVar.a;
        wbbVar.a = i - 1;
        return i;
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
            if (!this.h) {
                return;
            }
            this.r = SystemClock.uptimeMillis();
        }
    }

    public final void j(boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) != null) || !this.i) {
            return;
        }
        if (z) {
            if (!q()) {
                v();
                return;
            }
            return;
        }
        boolean q = q();
        this.g += i;
        this.f += i2;
        if (q && !q()) {
            v();
        }
    }

    public void n(Context context, mbb mbbVar, e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, context, mbbVar, eVar) != null) || context == null) {
            return;
        }
        Application application = (Application) context.getApplicationContext();
        this.d = application;
        application.registerActivityLifecycleCallbacks(new c(this, null));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
        this.d.registerReceiver(new b(this, null), intentFilter);
        this.e = mbbVar;
        this.c = eVar;
        this.k = pbb.i().a();
        this.l = pbb.i().e();
        if (this.k) {
            this.e.k();
        }
        this.m = pbb.i().n();
        d s = this.e.s();
        this.f = Math.max(s.a, 0);
        this.g = Math.max(s.b, 0);
        this.i = pbb.i().j();
        this.h = pbb.i().d();
        this.j = pbb.i().o();
        this.n = uab.o().A();
        int B = uab.o().B() * 1000;
        this.o = B;
        if (this.h && B > 0 && !this.p) {
            rab.w().J(this.s, 5000L);
            this.p = true;
        }
    }

    public void s(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) && this.i && i >= 0 && i2 >= 0 && i + i2 != 0) {
            if (t) {
                Log.d("UBCUploadTimingManager", "onClearData eventCount=" + i + ", flowCount=" + i2);
            }
            this.f = Math.max(this.f - i, 0);
            this.g = Math.max(this.g - i2, 0);
        }
    }

    public void x(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048592, this, str, i) != null) || !this.i || i != -1 || uab.o().f(str) || !uab.o().i(str)) {
            return;
        }
        if (t) {
            Log.d("UBCUploadTimingManager", "onNewEvent id=" + str + ", currentEventCount=" + this.f);
        }
        j(false, 0, 1);
    }

    public void y(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048593, this, str, i) != null) || !this.i || i <= 0 || uab.o().f(str) || !uab.o().i(str)) {
            return;
        }
        if (t) {
            Log.d("UBCUploadTimingManager", "onNewFlow id=" + str + ", currentFlowCount=" + this.g);
        }
        j(false, i, 0);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !this.i) {
            return;
        }
        if (t) {
            Log.d("UBCUploadTimingManager", "onClearDataAndReset");
        }
        d s = this.e.s();
        this.f = Math.max(s.a, 0);
        this.g = Math.max(s.b, 0);
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
}
