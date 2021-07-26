package com.bytedance.sdk.component.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.a.k;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WebView f27915a;

    /* renamed from: b  reason: collision with root package name */
    public a f27916b;

    /* renamed from: c  reason: collision with root package name */
    public String f27917c;

    /* renamed from: d  reason: collision with root package name */
    public h f27918d;

    /* renamed from: e  reason: collision with root package name */
    public Context f27919e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27920f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27921g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27922h;

    /* renamed from: i  reason: collision with root package name */
    public m f27923i;
    public n j;
    public String k;
    public final Set<String> l;
    public final Set<String> m;
    public boolean n;
    public boolean o;
    public k.b p;

    public j(@NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27917c = "IESJSBridge";
        this.k = "host";
        this.l = new LinkedHashSet();
        this.m = new LinkedHashSet();
        this.f27915a = webView;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if ((this.f27915a == null && !this.n && this.f27916b == null) || ((TextUtils.isEmpty(this.f27917c) && this.f27915a != null) || this.f27918d == null)) {
                throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
            }
        }
    }

    public j a(@NonNull a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            this.f27916b = aVar;
            return this;
        }
        return (j) invokeL.objValue;
    }

    public j b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f27921g = z;
            return this;
        }
        return (j) invokeZ.objValue;
    }

    public j a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f27917c = str;
            return this;
        }
        return (j) invokeL.objValue;
    }

    public r b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c();
            return new r(this);
        }
        return (r) invokeV.objValue;
    }

    public j a(@NonNull l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar)) == null) {
            this.f27918d = h.a(lVar);
            return this;
        }
        return (j) invokeL.objValue;
    }

    public j a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.f27920f = z;
            return this;
        }
        return (j) invokeZ.objValue;
    }

    public j a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.o = true;
            return this;
        }
        return (j) invokeV.objValue;
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27917c = "IESJSBridge";
        this.k = "host";
        this.l = new LinkedHashSet();
        this.m = new LinkedHashSet();
    }
}
