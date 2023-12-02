package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public class x74 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile x74 c;
    public transient /* synthetic */ FieldHolder $fh;
    public e64 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948253268, "Lcom/baidu/tieba/x74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948253268, "Lcom/baidu/tieba/x74;");
                return;
            }
        }
        b = vm1.a;
    }

    public x74() {
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

    public static x74 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (x74.class) {
                    if (c == null) {
                        c = new x74();
                    }
                }
            }
            return c;
        }
        return (x74) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        e64 e64Var;
        e64.c cVar;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2) || (e64Var = this.a) == null || (cVar = e64Var.d) == null || (hashMap = cVar.a) == null) {
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
        e64 e64Var;
        e64.b bVar;
        List<e64.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            if (!TextUtils.isEmpty(str) && (e64Var = this.a) != null && (bVar = e64Var.c) != null && (list = bVar.a) != null) {
                for (e64.a aVar : list) {
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
        e64 e64Var;
        e64.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && !TextUtils.isEmpty(str) && (e64Var = this.a) != null && (bVar = e64Var.c) != null && bVar.b != null) {
            if (b) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.a.c.b.put(str, Boolean.valueOf(z));
        }
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        e64.b bVar;
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2)) {
                return false;
            }
            e64 e64Var = this.a;
            if (e64Var != null && (bVar = e64Var.c) != null && (hashMap = bVar.b) != null && hashMap.containsKey(c2)) {
                if (b) {
                    Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
                }
                return this.a.c.b.get(c2).booleanValue();
            }
            if (b) {
                Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
            }
            String h0 = k63.h0();
            if (k63.M() == null) {
                return false;
            }
            String l0 = k63.M().l0();
            if (TextUtils.isEmpty(h0) || TextUtils.isEmpty(l0)) {
                return false;
            }
            boolean n = he4.i().n(h0, l0, c2);
            if (n) {
                f(c2, true);
            }
            return n;
        }
        return invokeL.booleanValue;
    }

    public void e(e64 e64Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, e64Var) == null) {
            this.a = e64Var;
        }
    }
}
