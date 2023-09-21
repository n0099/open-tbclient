package com.baidu.tieba;

import android.os.Handler;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class zw2 implements xw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public final boolean b;
    public long c;
    public volatile boolean d;
    @NonNull
    public final List<xw2> e;
    public final Runnable f;
    public final Runnable g;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw2 a;

        public a(zw2 zw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw2 a;

        public b(zw2 zw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final zw2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-218065419, "Lcom/baidu/tieba/zw2$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-218065419, "Lcom/baidu/tieba/zw2$c;");
                    return;
                }
            }
            a = new zw2(null);
        }
    }

    public zw2() {
        boolean z;
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
        long millis = TimeUnit.SECONDS.toMillis(ex2.b.a());
        this.a = millis;
        if (millis >= 0 && ex2.b.e()) {
            z = true;
        } else {
            z = false;
        }
        this.b = z;
        this.c = 0L;
        this.d = false;
        this.f = new a(this);
        this.g = new b(this);
        this.e = new ArrayList();
        if (ex2.b.e()) {
            if (ex2.b.d()) {
                this.e.add(new ax2());
            }
            if (ex2.b.b()) {
                this.e.add(new bx2());
            }
            if (ex2.b.c()) {
                this.e.add(new yw2());
            }
        }
    }

    public /* synthetic */ zw2(a aVar) {
        this();
    }

    public static xw2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return c.a;
        }
        return (xw2) invokeV.objValue;
    }

    public final void d() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.c;
            if (this.b && !this.d && ProcessUtils.isSwanProcess() && xo3.C(true)) {
                z = true;
            } else {
                z = false;
            }
            g82.i("SwanBackStageManager", "performPause: shouldPerform=" + z + " for " + currentTimeMillis + "/" + this.a);
            if (z) {
                for (xw2 xw2Var : this.e) {
                    g82.i("SwanBackStageManager", "performPause for strategy=" + xw2Var);
                    xw2Var.onPause();
                }
                this.d = true;
            }
        }
    }

    public final void e() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.b && this.d) {
                z = true;
            } else {
                z = false;
            }
            g82.i("SwanBackStageManager", "performResume: shouldPerform=" + z);
            for (xw2 xw2Var : this.e) {
                g82.i("SwanBackStageManager", "performResume for strategy=" + xw2Var);
                xw2Var.onResume();
            }
            this.d = false;
        }
    }

    @Override // com.baidu.tieba.xw2
    @AnyThread
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g82.i("SwanBackStageManager", "onPause: enable=" + this.b + " delay=" + this.a);
            if (this.b) {
                this.c = System.currentTimeMillis();
                Handler M = fb3.M();
                M.removeCallbacks(this.f);
                M.removeCallbacks(this.g);
                M.postDelayed(this.f, this.a);
            }
        }
    }

    @Override // com.baidu.tieba.xw2
    @AnyThread
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            g82.i("SwanBackStageManager", "onResume: enable=" + this.b);
            if (this.b) {
                Handler M = fb3.M();
                M.removeCallbacks(this.f);
                M.removeCallbacks(this.g);
                ap3.e0(this.g);
            }
        }
    }
}
