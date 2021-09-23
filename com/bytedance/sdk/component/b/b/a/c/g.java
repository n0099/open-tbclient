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
/* loaded from: classes9.dex */
public final class g implements u.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<u> f64873a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a.b.g f64874b;

    /* renamed from: c  reason: collision with root package name */
    public final c f64875c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a.b.c f64876d;

    /* renamed from: e  reason: collision with root package name */
    public final int f64877e;

    /* renamed from: f  reason: collision with root package name */
    public final z f64878f;

    /* renamed from: g  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.e f64879g;

    /* renamed from: h  reason: collision with root package name */
    public final p f64880h;

    /* renamed from: i  reason: collision with root package name */
    public final int f64881i;

    /* renamed from: j  reason: collision with root package name */
    public final int f64882j;
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
        this.f64873a = list;
        this.f64876d = cVar2;
        this.f64874b = gVar;
        this.f64875c = cVar;
        this.f64877e = i2;
        this.f64878f = zVar;
        this.f64879g = eVar;
        this.f64880h = pVar;
        this.f64881i = i3;
        this.f64882j = i4;
        this.k = i5;
    }

    @Override // com.bytedance.sdk.component.b.b.u.a
    public z a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64878f : (z) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.u.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64881i : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.component.b.b.u.a
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64882j : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f64876d : (com.bytedance.sdk.component.b.b.i) invokeV.objValue;
    }

    public com.bytedance.sdk.component.b.b.a.b.g f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f64874b : (com.bytedance.sdk.component.b.b.a.b.g) invokeV.objValue;
    }

    public c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f64875c : (c) invokeV.objValue;
    }

    public com.bytedance.sdk.component.b.b.e h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f64879g : (com.bytedance.sdk.component.b.b.e) invokeV.objValue;
    }

    public p i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f64880h : (p) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.u.a
    public ab a(z zVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zVar)) == null) ? a(zVar, this.f64874b, this.f64875c, this.f64876d) : (ab) invokeL.objValue;
    }

    public ab a(z zVar, com.bytedance.sdk.component.b.b.a.b.g gVar, c cVar, com.bytedance.sdk.component.b.b.a.b.c cVar2) throws IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zVar, gVar, cVar, cVar2)) == null) {
            if (this.f64877e < this.f64873a.size()) {
                this.l++;
                if (this.f64875c != null && !this.f64876d.a(zVar.a())) {
                    throw new IllegalStateException("network interceptor " + this.f64873a.get(this.f64877e - 1) + " must retain the same host and port");
                } else if (this.f64875c != null && this.l > 1) {
                    throw new IllegalStateException("network interceptor " + this.f64873a.get(this.f64877e - 1) + " must call proceed() exactly once");
                } else {
                    g gVar2 = new g(this.f64873a, gVar, cVar, cVar2, this.f64877e + 1, zVar, this.f64879g, this.f64880h, this.f64881i, this.f64882j, this.k);
                    u uVar = this.f64873a.get(this.f64877e);
                    ab intercept = uVar.intercept(gVar2);
                    if (cVar != null && this.f64877e + 1 < this.f64873a.size() && gVar2.l != 1) {
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
