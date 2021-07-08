package com.bytedance.sdk.component.b.b.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.b.b.t;
import com.bytedance.sdk.component.b.b.z;
import java.net.Proxy;
/* loaded from: classes5.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(z zVar, Proxy.Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, zVar, type)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(zVar.b());
            sb.append(' ');
            if (b(zVar, type)) {
                sb.append(zVar.a());
            } else {
                sb.append(a(zVar.a()));
            }
            sb.append(" HTTP/1.1");
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static boolean b(z zVar, Proxy.Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, zVar, type)) == null) ? !zVar.h() && type == Proxy.Type.HTTP : invokeLL.booleanValue;
    }

    public static String a(t tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tVar)) == null) {
            String i2 = tVar.i();
            String k = tVar.k();
            if (k != null) {
                return i2 + '?' + k;
            }
            return i2;
        }
        return (String) invokeL.objValue;
    }
}
