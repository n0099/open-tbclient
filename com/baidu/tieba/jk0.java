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
public class jk0 {
    public static /* synthetic */ Interceptable $ic;
    public static gk0 a;
    public static ik0 b;
    public static fk0 c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947886042, "Lcom/baidu/tieba/jk0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947886042, "Lcom/baidu/tieba/jk0;");
        }
    }

    public jk0() {
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

    public static fk0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (jk0.class) {
                    if (c == null) {
                        c = (fk0) ServiceManager.getService(fk0.a);
                    }
                    if (c == null) {
                        c = fk0.b;
                    }
                }
            }
            return c;
        }
        return (fk0) invokeV.objValue;
    }

    public static gk0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (jk0.class) {
                    if (a == null) {
                        a = (gk0) ServiceManager.getService(gk0.a);
                    }
                    if (a == null) {
                        a = gk0.b;
                    }
                }
            }
            return a;
        }
        return (gk0) invokeV.objValue;
    }

    public static ik0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                synchronized (jk0.class) {
                    if (b == null) {
                        b = (ik0) ServiceManager.getService(ik0.a);
                    }
                    if (b == null) {
                        b = ik0.b;
                    }
                }
            }
            return b;
        }
        return (ik0) invokeV.objValue;
    }
}
