package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bb4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class uc4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile uc4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public bb4 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948206179, "Lcom/baidu/tieba/uc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948206179, "Lcom/baidu/tieba/uc4;");
                return;
            }
        }
        b = rr1.a;
    }

    public uc4() {
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

    public static uc4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (uc4.class) {
                    if (c == null) {
                        c = new uc4();
                    }
                }
            }
            return c;
        }
        return (uc4) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        bb4 bb4Var;
        bb4.c cVar;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2) || (bb4Var = this.a) == null || (cVar = bb4Var.d) == null || (hashMap = cVar.a) == null) {
                return null;
            }
            return hashMap.get(c2);
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(String str, int i) {
        InterceptResult invokeLI;
        bb4 bb4Var;
        bb4.b bVar;
        List<bb4.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            if (!TextUtils.isEmpty(str) && (bb4Var = this.a) != null && (bVar = bb4Var.c) != null && (list = bVar.a) != null) {
                for (bb4.a aVar : list) {
                    if (TextUtils.equals(aVar.a, str) || TextUtils.equals(aVar.b, str)) {
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        return aVar.b;
                                    }
                                    return aVar.d;
                                }
                                return aVar.c;
                            }
                            return aVar.b;
                        }
                        return aVar.a;
                    }
                    while (r0.hasNext()) {
                    }
                }
            }
            return null;
        }
        return (String) invokeLI.objValue;
    }

    public void f(String str, boolean z) {
        bb4 bb4Var;
        bb4.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && !TextUtils.isEmpty(str) && (bb4Var = this.a) != null && (bVar = bb4Var.c) != null && bVar.b != null) {
            if (b) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.a.c.b.put(str, Boolean.valueOf(z));
        }
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        bb4.b bVar;
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2)) {
                return false;
            }
            bb4 bb4Var = this.a;
            if (bb4Var != null && (bVar = bb4Var.c) != null && (hashMap = bVar.b) != null && hashMap.containsKey(c2)) {
                if (b) {
                    Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
                }
                return this.a.c.b.get(c2).booleanValue();
            }
            if (b) {
                Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
            }
            String g0 = hb3.g0();
            if (hb3.M() == null) {
                return false;
            }
            String k0 = hb3.M().k0();
            if (TextUtils.isEmpty(g0) || TextUtils.isEmpty(k0)) {
                return false;
            }
            boolean n = ej4.i().n(g0, k0, c2);
            if (n) {
                f(c2, true);
            }
            return n;
        }
        return invokeL.booleanValue;
    }

    public void e(bb4 bb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bb4Var) == null) {
            this.a = bb4Var;
        }
    }
}
