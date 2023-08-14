package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes6.dex */
public class kw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public a b;
    public boolean c;
    public final pw2 d;

    /* loaded from: classes6.dex */
    public interface b {
        void h(int i);
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b a;
        public Timer b;
        public long c;
        public int d;

        /* renamed from: com.baidu.tieba.kw2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0374a extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0374a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (kw2.e) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + this.a.c);
                    }
                    this.a.c -= 10;
                    if (this.a.c <= 0 && this.a.a != null) {
                        this.a.a.h(1);
                        this.a.l();
                    }
                }
            }
        }

        public a() {
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
            this.c = 300L;
            this.d = 0;
        }

        public final synchronized void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    if (this.b != null) {
                        this.b.cancel();
                        this.b.purge();
                        this.b = null;
                    }
                }
            }
        }

        public final TimerTask e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new C0374a(this);
            }
            return (TimerTask) invokeV.objValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.d == 2) {
                return;
            }
            this.d = 4;
            d();
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.c = x43.a();
                if (kw2.e && x63.u().getBoolean("swan_5min_back_optimize", false)) {
                    this.c = 30L;
                }
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.d != 4) {
                return;
            }
            this.d = 3;
            d();
            i();
        }

        public final void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                Timer timer = new Timer();
                this.b = timer;
                timer.schedule(e(), 0L, 10000L);
            }
        }

        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.d = 1;
                g();
                d();
                i();
            }
        }

        public void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.d = 2;
                d();
                g();
            }
        }

        public void j(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
                this.a = bVar;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<kw2> mPolicyRef;

        public c(kw2 kw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPolicyRef = new WeakReference<>(kw2Var);
        }

        public static IntentFilter getIntentFilter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                return intentFilter;
            }
            return (IntentFilter) invokeV.objValue;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kw2 kw2Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) || intent == null || TextUtils.isEmpty(intent.getAction()) || (kw2Var = this.mPolicyRef.get()) == null) {
                return;
            }
            String action = intent.getAction();
            char c = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -2128145023) {
                if (hashCode == -1454123155 && action.equals("android.intent.action.SCREEN_ON")) {
                    c = 0;
                }
            } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                c = 1;
            }
            if (c == 0) {
                kw2Var.d(true);
            } else if (c == 1) {
                kw2Var.d(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947927427, "Lcom/baidu/tieba/kw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947927427, "Lcom/baidu/tieba/kw2;");
                return;
            }
        }
        e = ir1.a;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.f();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.h();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (e) {
                Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
            }
            this.d.onPause();
            this.b.k();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (e) {
                Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
            }
            this.d.onResume();
            this.b.l();
        }
    }

    public kw2() {
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
        this.a = new c(this);
        this.b = new a();
        this.d = rw2.c();
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, context) != null) || this.c) {
            return;
        }
        if (context == null && (context = fu2.c()) == null) {
            return;
        }
        this.c = true;
        context.registerReceiver(this.a, c.getIntentFilter());
    }

    public void f(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, context) != null) || !this.c) {
            return;
        }
        if (context == null && (context = fu2.c()) == null) {
            return;
        }
        this.c = false;
        try {
            context.unregisterReceiver(this.a);
        } catch (IllegalArgumentException e2) {
            if (e) {
                e2.printStackTrace();
            }
        }
    }

    public void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.b.j(bVar);
        }
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (e) {
                Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
            }
            if (z) {
                g();
            } else {
                e();
            }
        }
    }
}
