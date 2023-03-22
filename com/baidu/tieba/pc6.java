package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class pc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> a;
    public final HashMap<String, String> b;
    public final ConcurrentHashMap<String, vc6> c;
    public final Map<String, vc6> d;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final pc6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-522708216, "Lcom/baidu/tieba/pc6$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-522708216, "Lcom/baidu/tieba/pc6$b;");
                    return;
                }
            }
            a = new pc6(null);
        }
    }

    public pc6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = new HashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap();
    }

    public /* synthetic */ pc6(a aVar) {
        this();
    }

    public vc6 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return this.d.get(str);
        }
        return (vc6) invokeL.objValue;
    }

    public vc6 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return this.c.get(str);
        }
        return (vc6) invokeL.objValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d.remove(str);
        }
    }

    public void j(HashMap<String, vc6> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hashMap) == null) {
            this.c.clear();
            if (hashMap == null) {
                return;
            }
            this.c.putAll(hashMap);
        }
    }

    public static pc6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (pc6) invokeV.objValue;
    }

    public ConcurrentHashMap<String, vc6> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (ConcurrentHashMap) invokeV.objValue;
    }

    public void a(String str, vc6 vc6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, vc6Var) == null) {
            this.d.put(str, vc6Var);
        }
    }

    public void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.a.put(str, str2);
        }
    }

    public void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.b.put(str, str2);
        }
    }

    public void m(String str, HashMap<String, vc6> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, hashMap) == null) {
            g(str);
            this.c.putAll(hashMap);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<String> it = this.c.keySet().iterator();
        while (it.hasNext()) {
            vc6 vc6Var = this.c.get(it.next());
            if (vc6Var != null && str.equals(vc6Var.c)) {
                it.remove();
            }
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            for (String str : this.c.keySet()) {
                vc6 vc6Var = this.c.get(str);
                if (vc6Var != null) {
                    vc6Var.g = z;
                }
            }
        }
    }

    public void i(boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048583, this, z, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        for (String str2 : this.c.keySet()) {
            vc6 vc6Var = this.c.get(str2);
            if (vc6Var != null && str.equals(vc6Var.c)) {
                vc6Var.g = z;
            }
        }
    }
}
