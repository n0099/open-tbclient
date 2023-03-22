package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class wh4 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final vk4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public rh4 a;
    public AtomicBoolean b;
    public qh4 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948270566, "Lcom/baidu/tieba/wh4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948270566, "Lcom/baidu/tieba/wh4;");
                return;
            }
        }
        d = vk4.e();
    }

    public wh4(AtomicBoolean atomicBoolean, rh4 rh4Var, qh4 qh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atomicBoolean, rh4Var, qh4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = atomicBoolean;
        this.a = rh4Var;
        this.c = qh4Var;
    }

    public final <T> void a(vh4<T> vh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vh4Var) == null) {
            this.a.a(vh4Var);
            try {
                try {
                    vh4Var.run();
                } catch (Exception e) {
                    d.g("PMSTaskExecutor", "#runTask 包下载任务出错", e);
                }
            } finally {
                this.a.b(vh4Var);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            while (!this.b.get()) {
                Runnable a = this.c.a(true);
                if (a instanceof vh4) {
                    try {
                        a((vh4) a);
                    } catch (Throwable th) {
                        d.g("PMSTaskExecutor", "#run 包下载任务出错", th);
                    }
                } else {
                    return;
                }
            }
        }
    }
}
