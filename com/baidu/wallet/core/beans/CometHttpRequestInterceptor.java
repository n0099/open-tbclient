package com.baidu.wallet.core.beans;

import android.content.Context;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class CometHttpRequestInterceptor extends EbpayHttpRequestInterceptor {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f60755a = 60000;

    /* renamed from: b  reason: collision with root package name */
    public static final String f60756b = "CometHttpRequestInterceptor";
    public transient /* synthetic */ FieldHolder $fh;

    public CometHttpRequestInterceptor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.wallet.core.beans.EbpayHttpRequestInterceptor, com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor
    public void intercept(Context context, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, dVar) == null) {
            super.intercept(context, dVar);
            dVar.a(60000);
        }
    }
}
