package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.e.b.o;
/* loaded from: classes5.dex */
public class g extends com.bytedance.sdk.openadsdk.core.video.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, ViewGroup viewGroup, m mVar) {
        super(context, viewGroup, mVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ViewGroup) objArr2[1], (m) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.f30767b == null) {
            return;
        }
        o.a aVar = new o.a();
        aVar.b(o());
        aVar.c(q());
        aVar.a(n());
        aVar.a(i2);
        aVar.b(i3);
        com.bytedance.sdk.openadsdk.e.a.a.d(this.f30767b.get(), w(), aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            o.a aVar = new o.a();
            aVar.a(n());
            aVar.c(q());
            aVar.b(o());
            aVar.f(p());
            com.bytedance.sdk.openadsdk.e.a.a.g(this.f30767b.get(), this.f30766a, aVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            o.a aVar = new o.a();
            aVar.a(n());
            aVar.c(q());
            aVar.b(o());
            com.bytedance.sdk.openadsdk.e.a.a.b(this.f30767b.get(), this.f30766a, aVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            o.a aVar = new o.a();
            aVar.a(n());
            aVar.c(q());
            aVar.b(o());
            com.bytedance.sdk.openadsdk.e.a.a.c(this.f30767b.get(), w(), aVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            o.a aVar = new o.a();
            aVar.b(true);
            com.bytedance.sdk.openadsdk.e.a.a.a(this.f30767b.get(), this.f30766a, aVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.bytedance.sdk.openadsdk.e.a.a.a(this.f30767b.get(), this.f30768c, this.f30766a, this.j);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            o.a aVar = new o.a();
            aVar.b(true);
            com.bytedance.sdk.openadsdk.e.a.a.a(this.f30767b.get(), this.f30766a, aVar);
        }
    }
}
