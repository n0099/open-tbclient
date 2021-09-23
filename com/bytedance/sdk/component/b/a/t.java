package com.bytedance.sdk.component.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final t f64760c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f64761a;

    /* renamed from: b  reason: collision with root package name */
    public long f64762b;

    /* renamed from: d  reason: collision with root package name */
    public long f64763d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731339335, "Lcom/bytedance/sdk/component/b/a/t;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731339335, "Lcom/bytedance/sdk/component/b/a/t;");
                return;
            }
        }
        f64760c = new t() { // from class: com.bytedance.sdk.component.b.a.t.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bytedance.sdk.component.b.a.t
            public t a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeJ = interceptable2.invokeJ(1048576, this, j2)) == null) ? this : (t) invokeJ.objValue;
            }

            @Override // com.bytedance.sdk.component.b.a.t
            public t a(long j2, TimeUnit timeUnit) {
                InterceptResult invokeJL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeJL = interceptable2.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, timeUnit)) == null) ? this : (t) invokeJL.objValue;
            }

            @Override // com.bytedance.sdk.component.b.a.t
            public void g() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        };
    }

    public t() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public t a(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, timeUnit)) == null) {
            if (j2 >= 0) {
                if (timeUnit != null) {
                    this.f64763d = timeUnit.toNanos(j2);
                    return this;
                }
                throw new IllegalArgumentException("unit == null");
            }
            throw new IllegalArgumentException("timeout < 0: " + j2);
        }
        return (t) invokeJL.objValue;
    }

    public long b_() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64763d : invokeV.longValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64761a : invokeV.booleanValue;
    }

    public long c_() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f64761a) {
                return this.f64762b;
            }
            throw new IllegalStateException("No deadline");
        }
        return invokeV.longValue;
    }

    public t e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.f64763d = 0L;
            return this;
        }
        return (t) invokeV.objValue;
    }

    public t f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.f64761a = false;
            return this;
        }
        return (t) invokeV.objValue;
    }

    public void g() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!Thread.interrupted()) {
                if (this.f64761a && this.f64762b - System.nanoTime() <= 0) {
                    throw new InterruptedIOException("deadline reached");
                }
                return;
            }
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public t a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            this.f64761a = true;
            this.f64762b = j2;
            return this;
        }
        return (t) invokeJ.objValue;
    }
}
