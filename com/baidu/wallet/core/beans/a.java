package com.baidu.wallet.core.beans;

import android.content.Context;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.utils.Identifier;
/* loaded from: classes11.dex */
public class a implements RestHttpRequestInterceptor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "X-Requested-Session-ID";

    /* renamed from: b  reason: collision with root package name */
    public static final String f52390b = "X-Domain-From-Config";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52391c;

    public a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52391c = false;
        this.f52391c = z;
    }

    @Override // com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor
    public void intercept(Context context, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, dVar) == null) {
            if (dVar != null && dVar.a() != null) {
                dVar.a().a(a, Identifier.sessionID());
            }
            dVar.a().a(f52390b, this.f52391c ? "1" : "0");
        }
    }
}
