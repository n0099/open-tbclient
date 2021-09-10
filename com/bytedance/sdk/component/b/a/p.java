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
    public static o f64445a;

    /* renamed from: b  reason: collision with root package name */
    public static long f64446b;
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
                if (f64445a != null) {
                    o oVar = f64445a;
                    f64445a = oVar.f64443f;
                    oVar.f64443f = null;
                    f64446b -= 8192;
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
            if (oVar.f64443f == null && oVar.f64444g == null) {
                if (oVar.f64441d) {
                    return;
                }
                synchronized (p.class) {
                    if (f64446b + 8192 > 65536) {
                        return;
                    }
                    f64446b += 8192;
                    oVar.f64443f = f64445a;
                    oVar.f64440c = 0;
                    oVar.f64439b = 0;
                    f64445a = oVar;
                    return;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
