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
/* loaded from: classes9.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WebView f63751a;

    /* renamed from: b  reason: collision with root package name */
    public a f63752b;

    /* renamed from: c  reason: collision with root package name */
    public String f63753c;

    /* renamed from: d  reason: collision with root package name */
    public h f63754d;

    /* renamed from: e  reason: collision with root package name */
    public Context f63755e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63756f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63757g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63758h;

    /* renamed from: i  reason: collision with root package name */
    public m f63759i;

    /* renamed from: j  reason: collision with root package name */
    public n f63760j;
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
        this.f63753c = "IESJSBridge";
        this.k = "host";
        this.l = new LinkedHashSet();
        this.m = new LinkedHashSet();
        this.f63751a = webView;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if ((this.f63751a == null && !this.n && this.f63752b == null) || ((TextUtils.isEmpty(this.f63753c) && this.f63751a != null) || this.f63754d == null)) {
                throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
            }
        }
    }

    public j a(@NonNull a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            this.f63752b = aVar;
            return this;
        }
        return (j) invokeL.objValue;
    }

    public j b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f63757g = z;
            return this;
        }
        return (j) invokeZ.objValue;
    }

    public j a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f63753c = str;
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
            this.f63754d = h.a(lVar);
            return this;
        }
        return (j) invokeL.objValue;
    }

    public j a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.f63756f = z;
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
        this.f63753c = "IESJSBridge";
        this.k = "host";
        this.l = new LinkedHashSet();
        this.m = new LinkedHashSet();
    }
}
