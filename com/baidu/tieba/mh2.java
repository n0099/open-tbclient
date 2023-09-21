package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class mh2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppSlaveManager a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public g13 e;
    public volatile boolean f;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh2 a;

        public a(mh2 mh2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mh2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947972594, "Lcom/baidu/tieba/mh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947972594, "Lcom/baidu/tieba/mh2;");
                return;
            }
        }
        g = qr1.a;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ao3.c(new a(this), "delayDownloadGuideRes", 3L, TimeUnit.SECONDS);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c || this.f) {
            return;
        }
        this.f = true;
        nu2.l0().c(fb3.K().getAppId());
    }

    public void c() {
        xx1 L;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.c) {
            SwanAppSlaveManager swanAppSlaveManager = this.a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.y;
            if (swanAppWebViewWidget == null) {
                L = swanAppSlaveManager.H;
            } else {
                L = swanAppWebViewWidget.L();
            }
            uh3.d(this.e, "realsuccess", L);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = true;
            if (!(this.a instanceof SwanAppWebViewWidget)) {
                g();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!(this.a instanceof SwanAppWebViewWidget)) {
                f();
            }
            this.b = false;
            if (this.c) {
                uh3.d(this.e, "success", null);
            }
        }
    }

    public mh2(@NonNull SwanAppSlaveManager swanAppSlaveManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppSlaveManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = false;
        this.d = false;
        this.f = false;
        this.a = swanAppSlaveManager;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d = false;
            boolean b = uh3.b();
            boolean a2 = uh3.a();
            if (b) {
                this.c = false;
            } else if (this.b) {
                this.c = true;
                if (!a2) {
                    this.e.f = UUID.randomUUID().toString();
                    g13 g13Var = this.e;
                    g13Var.e = "6";
                    uh3.h(g13Var);
                    if (g) {
                        Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.e);
                    }
                }
            } else {
                this.c = !TextUtils.isEmpty(this.a.h0());
            }
        }
    }

    public void g() {
        xx1 L;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (g) {
                Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.e);
            }
            if (this.c && !this.d) {
                this.d = true;
                SwanAppSlaveManager swanAppSlaveManager = this.a;
                SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.y;
                if (swanAppWebViewWidget == null) {
                    L = swanAppSlaveManager.H;
                } else {
                    L = swanAppWebViewWidget.L();
                }
                if (L != null && L.c > 0) {
                    uh3.d(this.e, "arrivesuccess", L);
                } else {
                    uh3.d(this.e, "arrivecancel", L);
                }
            }
        }
    }

    public void h(@NonNull g13 g13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, g13Var) == null) {
            this.e = g13Var;
        }
    }
}
