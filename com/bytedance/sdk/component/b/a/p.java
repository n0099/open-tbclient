package com.bytedance.sdk.component.b.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static o f64265a;

    /* renamed from: b  reason: collision with root package name */
    public static long f64266b;
    public transient /* synthetic */ FieldHolder $fh;

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static o a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (p.class) {
                if (f64265a != null) {
                    o oVar = f64265a;
                    f64265a = oVar.f64263f;
                    oVar.f64263f = null;
                    f64266b -= 8192;
                    return oVar;
                }
                return new o();
            }
        }
        return (o) invokeV.objValue;
    }

    public static void a(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, oVar) == null) {
            if (oVar.f64263f == null && oVar.f64264g == null) {
                if (oVar.f64261d) {
                    return;
                }
                synchronized (p.class) {
                    if (f64266b + 8192 > 65536) {
                        return;
                    }
                    f64266b += 8192;
                    oVar.f64263f = f64265a;
                    oVar.f64260c = 0;
                    oVar.f64259b = 0;
                    f64265a = oVar;
                    return;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
