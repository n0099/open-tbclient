package com.bytedance.sdk.component.b.b.a.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.p;
import com.bytedance.sdk.component.b.b.u;
import com.bytedance.sdk.component.b.b.z;
import java.io.IOException;
import java.util.List;
/* loaded from: classes6.dex */
public final class g implements u.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<u> f28129a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a.b.g f28130b;

    /* renamed from: c  reason: collision with root package name */
    public final c f28131c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a.b.c f28132d;

    /* renamed from: e  reason: collision with root package name */
    public final int f28133e;

    /* renamed from: f  reason: collision with root package name */
    public final z f28134f;

    /* renamed from: g  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.e f28135g;

    /* renamed from: h  reason: collision with root package name */
    public final p f28136h;

    /* renamed from: i  reason: collision with root package name */
    public final int f28137i;
    public final int j;
    public final int k;
    public int l;

    public g(List<u> list, com.bytedance.sdk.component.b.b.a.b.g gVar, c cVar, com.bytedance.sdk.component.b.b.a.b.c cVar2, int i2, z zVar, com.bytedance.sdk.component.b.b.e eVar, p pVar, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {list, gVar, cVar, cVar2, Integer.valueOf(i2), zVar, eVar, pVar, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28129a = list;
        this.f28132d = cVar2;
        this.f28130b = gVar;
        this.f28131c = cVar;
        this.f28133e = i2;
        this.f28134f = zVar;
        this.f28135g = eVar;
        this.f28136h = pVar;
        this.f28137i = i3;
        this.j = i4;
        this.k = i5;
    }

    @Override // com.bytedance.sdk.component.b.b.u.a
    public z a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28134f : (z) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.u.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28137i : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.component.b.b.u.a
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.component.b.b.u.a
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : invokeV.intValue;
    }

    public com.bytedance.sdk.component.b.b.i e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f28132d : (com.bytedance.sdk.component.b.b.i) invokeV.objValue;
    }

    public com.bytedance.sdk.component.b.b.a.b.g f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28130b : (com.bytedance.sdk.component.b.b.a.b.g) invokeV.objValue;
    }

    public c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28131c : (c) invokeV.objValue;
    }

    public com.bytedance.sdk.component.b.b.e h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f28135g : (com.bytedance.sdk.component.b.b.e) invokeV.objValue;
    }

    public p i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28136h : (p) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.u.a
    public ab a(z zVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zVar)) == null) ? a(zVar, this.f28130b, this.f28131c, this.f28132d) : (ab) invokeL.objValue;
    }

    public ab a(z zVar, com.bytedance.sdk.component.b.b.a.b.g gVar, c cVar, com.bytedance.sdk.component.b.b.a.b.c cVar2) throws IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zVar, gVar, cVar, cVar2)) == null) {
            if (this.f28133e < this.f28129a.size()) {
                this.l++;
                if (this.f28131c != null && !this.f28132d.a(zVar.a())) {
                    throw new IllegalStateException("network interceptor " + this.f28129a.get(this.f28133e - 1) + " must retain the same host and port");
                } else if (this.f28131c != null && this.l > 1) {
                    throw new IllegalStateException("network interceptor " + this.f28129a.get(this.f28133e - 1) + " must call proceed() exactly once");
                } else {
                    g gVar2 = new g(this.f28129a, gVar, cVar, cVar2, this.f28133e + 1, zVar, this.f28135g, this.f28136h, this.f28137i, this.j, this.k);
                    u uVar = this.f28129a.get(this.f28133e);
                    ab intercept = uVar.intercept(gVar2);
                    if (cVar != null && this.f28133e + 1 < this.f28129a.size() && gVar2.l != 1) {
                        throw new IllegalStateException("network interceptor " + uVar + " must call proceed() exactly once");
                    } else if (intercept != null) {
                        if (intercept.h() != null) {
                            return intercept;
                        }
                        throw new IllegalStateException("interceptor " + uVar + " returned a response with no body");
                    } else {
                        throw new NullPointerException("interceptor " + uVar + " returned null");
                    }
                }
            }
            throw new AssertionError();
        }
        return (ab) invokeLLLL.objValue;
    }
}
