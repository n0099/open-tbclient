package com.baidu.tieba;

import com.baidu.tieba.sd2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import com.facebook.common.internal.Sets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class td2 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public static final Set<String> b;
    public static final Set<String> c;
    public static final Map<String, sd2> d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948177287, "Lcom/baidu/tieba/td2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948177287, "Lcom/baidu/tieba/td2;");
                return;
            }
        }
        a = Sets.newHashSet(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
        b = new HashSet(a);
        c = new HashSet(b);
        d = new HashMap();
        e = false;
    }

    public static sd2 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            c();
            return d.get(str);
        }
        return (sd2) invokeL.objValue;
    }

    public static sd2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            sd2.b bVar = new sd2.b();
            bVar.d(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
            bVar.e(mn2.w0().a());
            bVar.b(mn2.w0().d());
            return bVar.a();
        }
        return (sd2) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (!e) {
                for (String str : c) {
                    if (ZeusWebViewPreloadClass.ZEUS_FILE_DIR.equals(str)) {
                        d.put(str, b());
                    }
                }
            }
            e = true;
        }
    }
}
