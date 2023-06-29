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
/* loaded from: classes8.dex */
public class vx2 implements tx2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public final boolean b;
    public long c;
    public volatile boolean d;
    @NonNull
    public final List<tx2> e;
    public final Runnable f;
    public final Runnable g;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vx2 a;

        public a(vx2 vx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vx2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vx2 a;

        public b(vx2 vx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vx2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final vx2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-331658502, "Lcom/baidu/tieba/vx2$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-331658502, "Lcom/baidu/tieba/vx2$c;");
                    return;
                }
            }
            a = new vx2(null);
        }
    }

    public vx2() {
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
        long millis = TimeUnit.SECONDS.toMillis(ay2.b.a());
        this.a = millis;
        if (millis >= 0 && ay2.b.e()) {
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
        if (ay2.b.e()) {
            if (ay2.b.d()) {
                this.e.add(new wx2());
            }
            if (ay2.b.b()) {
                this.e.add(new xx2());
            }
            if (ay2.b.c()) {
                this.e.add(new ux2());
            }
        }
    }

    public /* synthetic */ vx2(a aVar) {
        this();
    }

    public static tx2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return c.a;
        }
        return (tx2) invokeV.objValue;
    }

    public final void d() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.c;
            if (this.b && !this.d && ProcessUtils.isSwanProcess() && tp3.C(true)) {
                z = true;
            } else {
                z = false;
            }
            c92.i("SwanBackStageManager", "performPause: shouldPerform=" + z + " for " + currentTimeMillis + "/" + this.a);
            if (z) {
                for (tx2 tx2Var : this.e) {
                    c92.i("SwanBackStageManager", "performPause for strategy=" + tx2Var);
                    tx2Var.onPause();
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
            c92.i("SwanBackStageManager", "performResume: shouldPerform=" + z);
            for (tx2 tx2Var : this.e) {
                c92.i("SwanBackStageManager", "performResume for strategy=" + tx2Var);
                tx2Var.onResume();
            }
            this.d = false;
        }
    }

    @Override // com.baidu.tieba.tx2
    @AnyThread
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c92.i("SwanBackStageManager", "onPause: enable=" + this.b + " delay=" + this.a);
            if (this.b) {
                this.c = System.currentTimeMillis();
                Handler M = bc3.M();
                M.removeCallbacks(this.f);
                M.removeCallbacks(this.g);
                M.postDelayed(this.f, this.a);
            }
        }
    }

    @Override // com.baidu.tieba.tx2
    @AnyThread
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c92.i("SwanBackStageManager", "onResume: enable=" + this.b);
            if (this.b) {
                Handler M = bc3.M();
                M.removeCallbacks(this.f);
                M.removeCallbacks(this.g);
                wp3.e0(this.g);
            }
        }
    }
}
