package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class ni4 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, ni4> d;
    public static Map<String, Map<String, ni4>> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final AbiType c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948003408, "Lcom/baidu/tieba/ni4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948003408, "Lcom/baidu/tieba/ni4;");
                return;
            }
        }
        d = new HashMap();
        e = new HashMap();
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public ni4(@NonNull String str, @NonNull AbiType abiType) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, abiType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = str;
        }
        this.a = str2;
        this.c = abiType;
        this.b = a(str, abiType);
    }

    @Nullable
    public static synchronized ni4 e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            synchronized (ni4.class) {
                ni4 ni4Var = null;
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    c(str);
                    ni4 ni4Var2 = d.get(str2);
                    if (ni4Var2 != null) {
                        if (TextUtils.equals(str, ni4Var2.a)) {
                            ni4Var = ni4Var2;
                        }
                    }
                    return ni4Var;
                }
                return null;
            }
        }
        return (ni4) invokeLL.objValue;
    }

    public static String a(String str, AbiType abiType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, abiType)) == null) {
            return "so_" + str + "_" + abiType.id;
        }
        return (String) invokeLL.objValue;
    }

    @Nullable
    public static synchronized ni4 d(String str, AbiType abiType) {
        InterceptResult invokeLL;
        ni4 e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, abiType)) == null) {
            synchronized (ni4.class) {
                e2 = e(str, a(str, abiType));
            }
            return e2;
        }
        return (ni4) invokeLL.objValue;
    }

    public static synchronized Map<String, ni4> b(@NonNull String str) {
        InterceptResult invokeL;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (ni4.class) {
                hashMap = new HashMap(c(str));
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static synchronized Map<String, ni4> c(@NonNull String str) {
        InterceptResult invokeL;
        Map<String, ni4> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            synchronized (ni4.class) {
                map = e.get(str);
                if (map == null) {
                    map = new HashMap<>();
                    if (!TextUtils.isEmpty(str)) {
                        for (AbiType abiType : AbiType.values()) {
                            ni4 ni4Var = new ni4(str, abiType);
                            map.put(ni4Var.b, ni4Var);
                        }
                        d.putAll(map);
                        e.put(str, map);
                    }
                }
            }
            return map;
        }
        return (Map) invokeL.objValue;
    }
}
