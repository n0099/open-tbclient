package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class qr0 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] g;
    public static final qr0 h;
    public transient /* synthetic */ FieldHolder $fh;
    public BodyStyle a;
    public String b;
    public String c;
    public byte[] d;
    public File e;
    public Map<String, String> f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948101306, "Lcom/baidu/tieba/qr0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948101306, "Lcom/baidu/tieba/qr0;");
                return;
            }
        }
        byte[] bArr = new byte[0];
        g = bArr;
        h = d(null, bArr);
        b(null, "");
        c(null, new HashMap());
    }

    public qr0() {
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

    public static qr0 b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            qr0 qr0Var = new qr0();
            qr0Var.k(BodyStyle.STRING);
            qr0Var.i(str);
            qr0Var.h(str2);
            return qr0Var;
        }
        return (qr0) invokeLL.objValue;
    }

    public static qr0 c(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, map)) == null) {
            qr0 qr0Var = new qr0();
            qr0Var.k(BodyStyle.FORM);
            qr0Var.i(str);
            qr0Var.j(map);
            return qr0Var;
        }
        return (qr0) invokeLL.objValue;
    }

    public static qr0 d(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, bArr)) == null) {
            qr0 qr0Var = new qr0();
            qr0Var.k(BodyStyle.BYTE);
            qr0Var.i(str);
            qr0Var.g(bArr);
            return qr0Var;
        }
        return (qr0) invokeLL.objValue;
    }

    public qr0 a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.f == null) {
                this.f = new HashMap();
            }
            this.f.put(str, str2);
            return this;
        }
        return (qr0) invokeLL.objValue;
    }

    public static qr0 e(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, map)) == null) {
            return c("application/x-www-form-urlencoded", map);
        }
        return (qr0) invokeL.objValue;
    }

    public static qr0 f(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            return d("application/octet-stream", bArr);
        }
        return (qr0) invokeL.objValue;
    }

    public qr0 g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            this.d = bArr;
            return this;
        }
        return (qr0) invokeL.objValue;
    }

    public qr0 h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (qr0) invokeL.objValue;
    }

    public qr0 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.b = str;
            return this;
        }
        return (qr0) invokeL.objValue;
    }

    public qr0 j(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            this.f = map;
            return this;
        }
        return (qr0) invokeL.objValue;
    }

    public qr0 k(BodyStyle bodyStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bodyStyle)) == null) {
            this.a = bodyStyle;
            return this;
        }
        return (qr0) invokeL.objValue;
    }
}
