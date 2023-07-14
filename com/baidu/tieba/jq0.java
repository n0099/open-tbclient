package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jq0 {
    public static /* synthetic */ Interceptable $ic;
    public static gq0 a;
    public static iq0 b;
    public static fq0 c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947891808, "Lcom/baidu/tieba/jq0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947891808, "Lcom/baidu/tieba/jq0;");
        }
    }

    public jq0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static fq0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (jq0.class) {
                    if (c == null) {
                        c = (fq0) ServiceManager.getService(fq0.a);
                    }
                    if (c == null) {
                        c = fq0.b;
                    }
                }
            }
            return c;
        }
        return (fq0) invokeV.objValue;
    }

    public static gq0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (jq0.class) {
                    if (a == null) {
                        a = (gq0) ServiceManager.getService(gq0.a);
                    }
                    if (a == null) {
                        a = gq0.b;
                    }
                }
            }
            return a;
        }
        return (gq0) invokeV.objValue;
    }

    public static iq0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                synchronized (jq0.class) {
                    if (b == null) {
                        b = (iq0) ServiceManager.getService(iq0.a);
                    }
                    if (b == null) {
                        b = iq0.b;
                    }
                }
            }
            return b;
        }
        return (iq0) invokeV.objValue;
    }
}
