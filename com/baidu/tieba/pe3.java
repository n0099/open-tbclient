package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class pe3 implements ne3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oe3 a;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-520950578, "Lcom/baidu/tieba/pe3$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-520950578, "Lcom/baidu/tieba/pe3$a;");
                    return;
                }
            }
            int[] iArr = new int[PathType.values().length];
            a = iArr;
            try {
                iArr[PathType.RELATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PathType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PathType.BD_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public pe3() {
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

    @Override // com.baidu.tieba.ne3
    @NonNull
    public synchronized oe3 d() {
        InterceptResult invokeV;
        oe3 oe3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new qe3();
                }
                oe3Var = this.a;
            }
            return oe3Var;
        }
        return (oe3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ne3
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                return "";
            }
            return sd3.z(c0.b);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ne3
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                return "";
            }
            return sd3.x(c0.b);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ne3
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                return str;
            }
            return sd3.H(str, c0);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ne3
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return sd3.G(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ne3
    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                return "";
            }
            return sd3.n(c0.b, str, null);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ne3
    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                return null;
            }
            return sd3.L(str, c0, c0.l0());
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ne3
    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                return str;
            }
            return sd3.I(str, c0.b);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ne3
    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                return null;
            }
            return sd3.M(str, c0.b);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ne3
    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            return sd3.F(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ne3
    public String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            return sd3.K(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ne3
    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            String t = nm4.t(str);
            if (TextUtils.isEmpty(t)) {
                return g(str);
            }
            return g(str) + "." + t;
        }
        return (String) invokeL.objValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int indexOf = str.indexOf("../");
            if (indexOf == 0) {
                String substring = str.substring(3);
                if (TextUtils.isEmpty(substring) || !substring.contains("../")) {
                    return false;
                }
                return true;
            } else if (indexOf <= 0) {
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ne3
    public boolean j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            PathType s = sd3.s(str);
            if (z) {
                s = o(str, s);
            }
            if (s == PathType.ERROR) {
                return false;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public final PathType o(String str, PathType pathType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, pathType)) == null) {
            int i = a.a[pathType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return PathType.ERROR;
                    }
                    return pathType;
                }
                if (str.startsWith("bdfile://code" + File.separator) || "bdfile://code".equals(str)) {
                    return PathType.RELATIVE;
                }
                return pathType;
            } else if (n(str)) {
                return PathType.ERROR;
            } else {
                return pathType;
            }
        }
        return (PathType) invokeLL.objValue;
    }
}
