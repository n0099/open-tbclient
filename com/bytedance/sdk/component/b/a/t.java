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
/* loaded from: classes6.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final t f28022c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f28023a;

    /* renamed from: b  reason: collision with root package name */
    public long f28024b;

    /* renamed from: d  reason: collision with root package name */
    public long f28025d;

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
        f28022c = new t() { // from class: com.bytedance.sdk.component.b.a.t.1
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
            public t a(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeJ = interceptable2.invokeJ(1048576, this, j)) == null) ? this : (t) invokeJ.objValue;
            }

            @Override // com.bytedance.sdk.component.b.a.t
            public t a(long j, TimeUnit timeUnit) {
                InterceptResult invokeJL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeJL = interceptable2.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, timeUnit)) == null) ? this : (t) invokeJL.objValue;
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

    public t a(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, timeUnit)) == null) {
            if (j >= 0) {
                if (timeUnit != null) {
                    this.f28025d = timeUnit.toNanos(j);
                    return this;
                }
                throw new IllegalArgumentException("unit == null");
            }
            throw new IllegalArgumentException("timeout < 0: " + j);
        }
        return (t) invokeJL.objValue;
    }

    public long b_() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28025d : invokeV.longValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28023a : invokeV.booleanValue;
    }

    public long c_() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f28023a) {
                return this.f28024b;
            }
            throw new IllegalStateException("No deadline");
        }
        return invokeV.longValue;
    }

    public t e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.f28025d = 0L;
            return this;
        }
        return (t) invokeV.objValue;
    }

    public t f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.f28023a = false;
            return this;
        }
        return (t) invokeV.objValue;
    }

    public void g() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!Thread.interrupted()) {
                if (this.f28023a && this.f28024b - System.nanoTime() <= 0) {
                    throw new InterruptedIOException("deadline reached");
                }
                return;
            }
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public t a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            this.f28023a = true;
            this.f28024b = j;
            return this;
        }
        return (t) invokeJ.objValue;
    }
}
