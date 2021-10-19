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
    public static o f64791a;

    /* renamed from: b  reason: collision with root package name */
    public static long f64792b;
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
                if (f64791a != null) {
                    o oVar = f64791a;
                    f64791a = oVar.f64789f;
                    oVar.f64789f = null;
                    f64792b -= 8192;
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
            if (oVar.f64789f == null && oVar.f64790g == null) {
                if (oVar.f64787d) {
                    return;
                }
                synchronized (p.class) {
                    if (f64792b + 8192 > 65536) {
                        return;
                    }
                    f64792b += 8192;
                    oVar.f64789f = f64791a;
                    oVar.f64786c = 0;
                    oVar.f64785b = 0;
                    f64791a = oVar;
                    return;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
