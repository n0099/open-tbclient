package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes7.dex */
public final class nx6 {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public float b;
    public boolean c;
    public float d;
    public long e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948017885, "Lcom/baidu/tieba/nx6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948017885, "Lcom/baidu/tieba/nx6;");
                return;
            }
        }
        f = new a(null);
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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
                }
            }
        }

        public final long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return System.nanoTime();
            }
            return invokeV.longValue;
        }
    }

    public nx6() {
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
        this.b = 1.0f;
        this.c = true;
    }

    public final long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e / 1000000;
        }
        return invokeV.longValue;
    }

    public final float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.floatValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public static /* synthetic */ void f(nx6 nx6Var, long j, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = nx6Var.a();
        }
        if ((i & 2) != 0) {
            f2 = nx6Var.b;
        }
        nx6Var.e(j, f2);
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.c = z;
        }
    }

    public final void e(long j, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Float.valueOf(f2)}) == null) {
            this.c = false;
            this.e = j * 1000000;
            this.b = f2;
            this.a = f.b();
        }
    }

    public final void g(Float f2) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, f2) == null) {
            long b = f.b();
            if (this.c) {
                j = 0;
            } else if (f2 != null) {
                j = f2.floatValue() * 1000000000;
            } else {
                j = b - this.a;
            }
            long j2 = ((float) j) * this.b;
            this.e += j2;
            this.d = ((float) j2) / 1.0E9f;
            this.a = b;
        }
    }
}
