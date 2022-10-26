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
/* loaded from: classes5.dex */
public class sq0 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] g;
    public static final sq0 h;
    public transient /* synthetic */ FieldHolder $fh;
    public BodyStyle a;
    public String b;
    public String c;
    public byte[] d;
    public File e;
    public Map f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948159927, "Lcom/baidu/tieba/sq0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948159927, "Lcom/baidu/tieba/sq0;");
                return;
            }
        }
        byte[] bArr = new byte[0];
        g = bArr;
        h = d(null, bArr);
        b(null, "");
        c(null, new HashMap());
    }

    public sq0() {
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

    public static sq0 b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            sq0 sq0Var = new sq0();
            sq0Var.k(BodyStyle.STRING);
            sq0Var.i(str);
            sq0Var.h(str2);
            return sq0Var;
        }
        return (sq0) invokeLL.objValue;
    }

    public static sq0 c(String str, Map map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, map)) == null) {
            sq0 sq0Var = new sq0();
            sq0Var.k(BodyStyle.FORM);
            sq0Var.i(str);
            sq0Var.j(map);
            return sq0Var;
        }
        return (sq0) invokeLL.objValue;
    }

    public static sq0 d(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, bArr)) == null) {
            sq0 sq0Var = new sq0();
            sq0Var.k(BodyStyle.BYTE);
            sq0Var.i(str);
            sq0Var.g(bArr);
            return sq0Var;
        }
        return (sq0) invokeLL.objValue;
    }

    public sq0 a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.f == null) {
                this.f = new HashMap();
            }
            this.f.put(str, str2);
            return this;
        }
        return (sq0) invokeLL.objValue;
    }

    public static sq0 e(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, map)) == null) {
            return c("application/x-www-form-urlencoded", map);
        }
        return (sq0) invokeL.objValue;
    }

    public static sq0 f(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            return d("application/octet-stream", bArr);
        }
        return (sq0) invokeL.objValue;
    }

    public sq0 g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            this.d = bArr;
            return this;
        }
        return (sq0) invokeL.objValue;
    }

    public sq0 h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (sq0) invokeL.objValue;
    }

    public sq0 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.b = str;
            return this;
        }
        return (sq0) invokeL.objValue;
    }

    public sq0 j(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            this.f = map;
            return this;
        }
        return (sq0) invokeL.objValue;
    }

    public sq0 k(BodyStyle bodyStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bodyStyle)) == null) {
            this.a = bodyStyle;
            return this;
        }
        return (sq0) invokeL.objValue;
    }
}
