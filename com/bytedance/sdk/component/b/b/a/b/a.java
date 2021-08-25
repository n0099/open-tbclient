package com.bytedance.sdk.component.b.b.a.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.u;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.b.b.z;
import java.io.IOException;
/* loaded from: classes9.dex */
public final class a implements u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w f64325a;

    public a(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64325a = wVar;
    }

    @Override // com.bytedance.sdk.component.b.b.u
    public ab intercept(u.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            com.bytedance.sdk.component.b.b.a.c.g gVar = (com.bytedance.sdk.component.b.b.a.c.g) aVar;
            z a2 = gVar.a();
            g f2 = gVar.f();
            return gVar.a(a2, f2, f2.a(this.f64325a, aVar, !a2.b().equals("GET")), f2.b());
        }
        return (ab) invokeL.objValue;
    }
}
