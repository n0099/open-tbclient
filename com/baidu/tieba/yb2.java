package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public class yb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public Timer a;
    public volatile boolean b;
    public final zb2 c;

    /* loaded from: classes8.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yb2 a;

        public a(yb2 yb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yb2Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (yb2.d) {
                    Log.d("RequestMonitor", ">> finish collecting request info.");
                }
                this.a.b = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final yb2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-266088542, "Lcom/baidu/tieba/yb2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-266088542, "Lcom/baidu/tieba/yb2$b;");
                    return;
                }
            }
            a = new yb2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948324320, "Lcom/baidu/tieba/yb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948324320, "Lcom/baidu/tieba/yb2;");
                return;
            }
        }
        d = rr1.a;
    }

    public yb2() {
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
        this.b = true;
        this.c = new zb2();
    }

    public static yb2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return b.a;
        }
        return (yb2) invokeV.objValue;
    }

    public List<xb2> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.a.d();
        }
        return (List) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = true;
            h();
            this.c.h();
        }
    }

    public final void h() {
        Timer timer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (timer = this.a) != null) {
            timer.cancel();
            this.a = null;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b = false;
            h();
            if (d) {
                Log.d("RequestMonitor", ">> stop to collect request info.");
            }
        }
    }

    public /* synthetic */ yb2(a aVar) {
        this();
    }

    public void e(xb2 xb2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xb2Var) == null) && this.b) {
            if (d) {
                Log.d("RequestMonitor", ">> add request " + xb2Var.toString());
            }
            this.c.a(xb2Var);
        }
    }

    @NonNull
    public ac2 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ac2 g = this.c.g();
            if (d) {
                Log.d("RequestMonitor", ">> requestResult: " + g.d() + g.c());
            }
            return g;
        }
        return (ac2) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (d) {
                Log.d("RequestMonitor", ">> start to collect request info. ");
            }
            this.c.i();
            h();
            Timer timer = new Timer();
            this.a = timer;
            timer.schedule(new a(this), LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION);
        }
    }
}
