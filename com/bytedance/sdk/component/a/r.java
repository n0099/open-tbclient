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
    public static w f63977a;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final a f63978b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final WebView f63979c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final j f63980d;

    /* renamed from: e  reason: collision with root package name */
    public final List<n> f63981e;

    /* renamed from: f  reason: collision with root package name */
    public o f63982f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f63983g;

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
        this.f63981e = new ArrayList();
        this.f63983g = false;
        this.f63980d = jVar;
        v a2 = (!jVar.f63958h || (wVar = f63977a) == null) ? null : wVar.a(jVar.k);
        if (jVar.f63951a != null) {
            a aVar = jVar.f63952b;
            if (aVar == null) {
                this.f63978b = new z();
            } else {
                this.f63978b = aVar;
            }
        } else {
            this.f63978b = jVar.f63952b;
        }
        this.f63978b.a(jVar, a2);
        this.f63979c = jVar.f63951a;
        this.f63981e.add(jVar.f63960j);
        i.a(jVar.f63956f);
        y.a(jVar.f63957g);
    }

    public static j a(@NonNull WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, webView)) == null) ? new j(webView) : (j) invokeL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.f63983g) {
            i.a(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }

    @AnyThread
    public <T> void a(@NonNull String str, @Nullable T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, t) == null) {
            b();
            this.f63978b.a(str, (String) t);
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
            this.f63978b.f63919g.a(str, eVar);
            o oVar = this.f63982f;
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
            this.f63978b.f63919g.a(str, bVar);
            o oVar = this.f63982f;
            if (oVar != null) {
                oVar.a(str);
            }
            return this;
        }
        return (r) invokeLLL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f63983g) {
            return;
        }
        this.f63978b.b();
        this.f63983g = true;
        for (n nVar : this.f63981e) {
            if (nVar != null) {
                nVar.a();
            }
        }
    }
}
