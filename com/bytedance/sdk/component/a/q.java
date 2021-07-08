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
/* loaded from: classes5.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static v f27781a;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final a f27782b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final WebView f27783c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final j f27784d;

    /* renamed from: e  reason: collision with root package name */
    public final List<n> f27785e;

    /* renamed from: f  reason: collision with root package name */
    public o f27786f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f27787g;

    public q(j jVar) {
        v vVar;
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
        this.f27785e = new ArrayList();
        this.f27787g = false;
        this.f27784d = jVar;
        u a2 = (!jVar.f27764h || (vVar = f27781a) == null) ? null : vVar.a(jVar.k);
        if (jVar.f27757a != null) {
            a aVar = jVar.f27758b;
            if (aVar == null) {
                this.f27782b = new y();
            } else {
                this.f27782b = aVar;
            }
        } else {
            this.f27782b = jVar.f27758b;
        }
        this.f27782b.a(jVar, a2);
        this.f27783c = jVar.f27757a;
        this.f27785e.add(jVar.j);
        i.a(jVar.f27762f);
        x.a(jVar.f27763g);
    }

    public static j a(@NonNull WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, webView)) == null) ? new j(webView) : (j) invokeL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.f27787g) {
            i.a(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }

    @AnyThread
    public <T> void a(@NonNull String str, @Nullable T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, t) == null) {
            b();
            this.f27782b.a(str, (String) t);
        }
    }

    public q a(String str, @NonNull e<?, ?> eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, eVar)) == null) ? a(str, (String) null, eVar) : (q) invokeLL.objValue;
    }

    @NonNull
    @UiThread
    public q a(@NonNull String str, @Nullable String str2, @NonNull e<?, ?> eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, eVar)) == null) {
            b();
            this.f27782b.f27726g.a(str, eVar);
            o oVar = this.f27786f;
            if (oVar != null) {
                oVar.a(str);
            }
            return this;
        }
        return (q) invokeLLL.objValue;
    }

    public q a(String str, @NonNull d.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, bVar)) == null) ? a(str, (String) null, bVar) : (q) invokeLL.objValue;
    }

    @NonNull
    @UiThread
    public q a(@NonNull String str, @Nullable String str2, @NonNull d.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, bVar)) == null) {
            b();
            this.f27782b.f27726g.a(str, bVar);
            o oVar = this.f27786f;
            if (oVar != null) {
                oVar.a(str);
            }
            return this;
        }
        return (q) invokeLLL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f27787g) {
            return;
        }
        this.f27782b.b();
        this.f27787g = true;
        for (n nVar : this.f27785e) {
            if (nVar != null) {
                nVar.a();
            }
        }
    }
}
