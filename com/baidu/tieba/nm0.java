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
/* loaded from: classes5.dex */
public class nm0 implements wm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public om0 b;
    public int c;
    public long d;
    public AtomicBoolean e;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final nm0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-570910054, "Lcom/baidu/tieba/nm0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-570910054, "Lcom/baidu/tieba/nm0$b;");
                    return;
                }
            }
            a = new nm0(null);
        }
    }

    public /* synthetic */ nm0(a aVar) {
        this();
    }

    public static nm0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (nm0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wm0
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.e.get()) {
            return;
        }
        om0 om0Var = this.b;
        if (om0Var != null) {
            om0Var.d();
            this.b = null;
            this.c = -1;
        }
        if (z) {
            if (this.d == 0 || System.currentTimeMillis() - this.d <= 300000) {
                return;
            }
            if (this.e.compareAndSet(false, true)) {
                this.b = new om0(60, this.c + 1, true);
            }
        } else {
            if (this.e.compareAndSet(false, true)) {
                this.b = new om0(60, this.c + 1, false);
            }
            km0.d().f();
        }
        b();
        this.d = System.currentTimeMillis();
    }

    public void b() {
        om0 om0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.c + 1;
            this.c = i;
            if (i <= 2 && (om0Var = this.b) != null) {
                om0Var.e();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.set(false);
        }
    }

    public nm0() {
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
        this.c = -1;
        this.d = 0L;
        this.e = new AtomicBoolean(false);
    }
}
