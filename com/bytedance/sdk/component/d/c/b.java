package com.bytedance.sdk.component.d.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.c.a.b.e;
import com.bytedance.sdk.component.d.f;
import com.bytedance.sdk.component.d.i;
import com.bytedance.sdk.component.d.j;
import com.bytedance.sdk.component.d.o;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f28670a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<a>> f28671b;

    /* renamed from: c  reason: collision with root package name */
    public final o f28672c;

    /* renamed from: d  reason: collision with root package name */
    public i f28673d;

    /* renamed from: e  reason: collision with root package name */
    public j f28674e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.component.d.b f28675f;

    /* renamed from: g  reason: collision with root package name */
    public com.bytedance.sdk.component.d.c f28676g;

    /* renamed from: h  reason: collision with root package name */
    public f f28677h;

    /* renamed from: i  reason: collision with root package name */
    public ExecutorService f28678i;
    public com.bytedance.sdk.component.d.a j;

    public b(Context context, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28671b = new ConcurrentHashMap();
        this.f28672c = (o) d.a(oVar);
        com.bytedance.sdk.component.d.a h2 = oVar.h();
        this.j = h2;
        if (h2 == null) {
            this.j = com.bytedance.sdk.component.d.a.a(context);
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? (b) d.a(f28670a, "ImageFactory was not initialized!") : (b) invokeV.objValue;
    }

    private i i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            i d2 = this.f28672c.d();
            if (d2 != null) {
                return com.bytedance.sdk.component.d.c.a.b.a.a(d2);
            }
            return com.bytedance.sdk.component.d.c.a.b.a.a(this.j.b());
        }
        return (i) invokeV.objValue;
    }

    private j j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            j e2 = this.f28672c.e();
            return e2 != null ? e2 : e.a(this.j.b());
        }
        return (j) invokeV.objValue;
    }

    private com.bytedance.sdk.component.d.b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            com.bytedance.sdk.component.d.b f2 = this.f28672c.f();
            return f2 != null ? f2 : new com.bytedance.sdk.component.d.c.a.a.b(this.j.c(), this.j.a(), g());
        }
        return (com.bytedance.sdk.component.d.b) invokeV.objValue;
    }

    private com.bytedance.sdk.component.d.c l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            com.bytedance.sdk.component.d.c c2 = this.f28672c.c();
            return c2 == null ? com.bytedance.sdk.component.d.b.b.a() : c2;
        }
        return (com.bytedance.sdk.component.d.c) invokeV.objValue;
    }

    private f m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            f a2 = this.f28672c.a();
            return a2 != null ? a2 : com.bytedance.sdk.component.d.a.b.a();
        }
        return (f) invokeV.objValue;
    }

    private ExecutorService n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            ExecutorService b2 = this.f28672c.b();
            return b2 != null ? b2 : com.bytedance.sdk.component.d.a.c.a();
        }
        return (ExecutorService) invokeV.objValue;
    }

    public i b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f28673d == null) {
                this.f28673d = i();
            }
            return this.f28673d;
        }
        return (i) invokeV.objValue;
    }

    public j c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f28674e == null) {
                this.f28674e = j();
            }
            return this.f28674e;
        }
        return (j) invokeV.objValue;
    }

    public com.bytedance.sdk.component.d.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f28675f == null) {
                this.f28675f = k();
            }
            return this.f28675f;
        }
        return (com.bytedance.sdk.component.d.b) invokeV.objValue;
    }

    public com.bytedance.sdk.component.d.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f28676g == null) {
                this.f28676g = l();
            }
            return this.f28676g;
        }
        return (com.bytedance.sdk.component.d.c) invokeV.objValue;
    }

    public f f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f28677h == null) {
                this.f28677h = m();
            }
            return this.f28677h;
        }
        return (f) invokeV.objValue;
    }

    public ExecutorService g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f28678i == null) {
                this.f28678i = n();
            }
            return this.f28678i;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public Map<String, List<a>> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28671b : (Map) invokeV.objValue;
    }

    public static synchronized void a(Context context, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, oVar) == null) {
            synchronized (b.class) {
                f28670a = new b(context, oVar);
                c.a(oVar.g());
            }
        }
    }

    public com.bytedance.sdk.component.d.c.b.a a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            ImageView.ScaleType f2 = aVar.f();
            if (f2 == null) {
                f2 = com.bytedance.sdk.component.d.c.b.a.f28679a;
            }
            Bitmap.Config g2 = aVar.g();
            if (g2 == null) {
                g2 = com.bytedance.sdk.component.d.c.b.a.f28680b;
            }
            return new com.bytedance.sdk.component.d.c.b.a(aVar.h(), aVar.i(), f2, g2);
        }
        return (com.bytedance.sdk.component.d.c.b.a) invokeL.objValue;
    }
}
