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
    public static w f63777a;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final a f63778b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final WebView f63779c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final j f63780d;

    /* renamed from: e  reason: collision with root package name */
    public final List<n> f63781e;

    /* renamed from: f  reason: collision with root package name */
    public o f63782f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f63783g;

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
        this.f63781e = new ArrayList();
        this.f63783g = false;
        this.f63780d = jVar;
        v a2 = (!jVar.f63758h || (wVar = f63777a) == null) ? null : wVar.a(jVar.k);
        if (jVar.f63751a != null) {
            a aVar = jVar.f63752b;
            if (aVar == null) {
                this.f63778b = new z();
            } else {
                this.f63778b = aVar;
            }
        } else {
            this.f63778b = jVar.f63752b;
        }
        this.f63778b.a(jVar, a2);
        this.f63779c = jVar.f63751a;
        this.f63781e.add(jVar.f63760j);
        i.a(jVar.f63756f);
        y.a(jVar.f63757g);
    }

    public static j a(@NonNull WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, webView)) == null) ? new j(webView) : (j) invokeL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.f63783g) {
            i.a(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }

    @AnyThread
    public <T> void a(@NonNull String str, @Nullable T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, t) == null) {
            b();
            this.f63778b.a(str, (String) t);
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
            this.f63778b.f63719g.a(str, eVar);
            o oVar = this.f63782f;
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
            this.f63778b.f63719g.a(str, bVar);
            o oVar = this.f63782f;
            if (oVar != null) {
                oVar.a(str);
            }
            return this;
        }
        return (r) invokeLLL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f63783g) {
            return;
        }
        this.f63778b.b();
        this.f63783g = true;
        for (n nVar : this.f63781e) {
            if (nVar != null) {
                nVar.a();
            }
        }
    }
}
