package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class tz2 implements sz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static volatile tz2 d;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile rz2 a;
    public volatile r03 b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948198429, "Lcom/baidu/tieba/tz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948198429, "Lcom/baidu/tieba/tz2;");
                return;
            }
        }
        c = rm1.a;
    }

    public tz2() {
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
        i();
    }

    public static tz2 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (tz2.class) {
                    if (d == null) {
                        d = new tz2();
                    }
                }
            }
            return d;
        }
        return (tz2) invokeV.objValue;
    }

    public rz2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (rz2) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.a == null) {
                this.a = new pz2();
            }
            if (this.b == null) {
                this.b = new t03();
            }
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return j();
        }
        return invokeV.booleanValue;
    }

    public r03 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (r03) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sz2
    public void end(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048576, this, j) != null) || !k()) {
            return;
        }
        if (c) {
            Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
        }
        this.a.end(j);
        this.b.end(j);
        m(j);
    }

    @Override // com.baidu.tieba.sz2
    public void start(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048583, this, j) != null) || !k()) {
            return;
        }
        if (c) {
            Log.d("StartUpInfoMarker", "aiapp start at - " + j);
        }
        this.a.start(j);
        this.b.start(j);
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (c) {
                return true;
            }
            g63 c0 = g63.c0();
            if (c0 == null) {
                return false;
            }
            String appId = c0.getAppId();
            if (!TextUtils.isEmpty(appId) && jy1.b(appId) != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            ci3.i.d(Long.valueOf(j));
        }
    }
}
