package com.bytedance.sdk.component.a;

import android.webkit.WebView;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static w f64503a;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final a f64504b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final WebView f64505c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final j f64506d;

    /* renamed from: e  reason: collision with root package name */
    public final List<n> f64507e;

    /* renamed from: f  reason: collision with root package name */
    public o f64508f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f64509g;

    public r(j jVar) {
        w wVar;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64507e = new ArrayList();
        this.f64509g = false;
        this.f64506d = jVar;
        v a2 = (!jVar.f64484h || (wVar = f64503a) == null) ? null : wVar.a(jVar.k);
        if (jVar.f64477a != null) {
            a aVar = jVar.f64478b;
            if (aVar == null) {
                this.f64504b = new z();
            } else {
                this.f64504b = aVar;
            }
        } else {
            this.f64504b = jVar.f64478b;
        }
        this.f64504b.a(jVar, a2);
        this.f64505c = jVar.f64477a;
        this.f64507e.add(jVar.f64486j);
        i.a(jVar.f64482f);
        y.a(jVar.f64483g);
    }

    public static j a(@NonNull WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, webView)) == null) ? new j(webView) : (j) invokeL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.f64509g) {
            i.a(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }

    @AnyThread
    public <T> void a(@NonNull String str, @Nullable T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, t) == null) {
            b();
            this.f64504b.a(str, (String) t);
        }
    }

    public r a(String str, @NonNull e<?, ?> eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, eVar)) == null) ? a(str, (String) null, eVar) : (r) invokeLL.objValue;
    }

    @NonNull
    @UiThread
    public r a(@NonNull String str, @Nullable String str2, @NonNull e<?, ?> eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, eVar)) == null) {
            b();
            this.f64504b.f64445g.a(str, eVar);
            o oVar = this.f64508f;
            if (oVar != null) {
                oVar.a(str);
            }
            return this;
        }
        return (r) invokeLLL.objValue;
    }

    public r a(String str, @NonNull d.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, bVar)) == null) ? a(str, (String) null, bVar) : (r) invokeLL.objValue;
    }

    @NonNull
    @UiThread
    public r a(@NonNull String str, @Nullable String str2, @NonNull d.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, bVar)) == null) {
            b();
            this.f64504b.f64445g.a(str, bVar);
            o oVar = this.f64508f;
            if (oVar != null) {
                oVar.a(str);
            }
            return this;
        }
        return (r) invokeLLL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f64509g) {
            return;
        }
        this.f64504b.b();
        this.f64509g = true;
        for (n nVar : this.f64507e) {
            if (nVar != null) {
                nVar.a();
            }
        }
    }
}
