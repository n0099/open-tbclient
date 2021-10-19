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
/* loaded from: classes9.dex */
public class b extends com.bytedance.sdk.openadsdk.core.video.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, ViewGroup viewGroup, m mVar) {
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
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.f67417b == null) {
            return;
        }
        o.a aVar = new o.a();
        aVar.b(o());
        aVar.c(q());
        aVar.a(n());
        aVar.a(i2);
        aVar.b(i3);
        com.bytedance.sdk.openadsdk.e.a.a.d(this.f67417b.get(), w(), aVar);
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
            com.bytedance.sdk.openadsdk.e.a.a.g(this.f67417b.get(), this.f67416a, aVar);
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
            com.bytedance.sdk.openadsdk.e.a.a.b(this.f67417b.get(), this.f67416a, aVar);
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
            com.bytedance.sdk.openadsdk.e.a.a.c(this.f67417b.get(), w(), aVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            o.a aVar = new o.a();
            aVar.b(true);
            com.bytedance.sdk.openadsdk.e.a.a.a(this.f67417b.get(), this.f67416a, aVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.bytedance.sdk.openadsdk.e.a.a.a(this.f67417b.get(), this.f67418c, this.f67416a, this.f67425j);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            o.a aVar = new o.a();
            aVar.b(true);
            com.bytedance.sdk.openadsdk.e.a.a.a(this.f67417b.get(), this.f67416a, aVar);
        }
    }
}
