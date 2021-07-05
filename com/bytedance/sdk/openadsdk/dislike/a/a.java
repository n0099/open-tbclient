package com.bytedance.sdk.openadsdk.dislike.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f30914a;

    /* renamed from: b  reason: collision with root package name */
    public static b f30915b;

    /* renamed from: c  reason: collision with root package name */
    public static c f30916c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1774608167, "Lcom/bytedance/sdk/openadsdk/dislike/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1774608167, "Lcom/bytedance/sdk/openadsdk/dislike/a/a;");
        }
    }

    public static void a(b bVar, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, bVar, cVar) == null) || f30914a) {
            return;
        }
        f30914a = true;
        f30915b = bVar;
        f30916c = cVar;
    }

    public static c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f30916c : (c) invokeV.objValue;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f30915b : (b) invokeV.objValue;
    }
}
