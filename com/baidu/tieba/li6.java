package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class li6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WebResourceResponse a;
    public final String b;
    public final int c;
    public final byte[] d;
    public final AtomicInteger e;

    public li6(String str, @NonNull WebResourceResponse webResourceResponse, @NonNull byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, webResourceResponse, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new AtomicInteger(0);
        this.b = str;
        this.a = webResourceResponse;
        this.d = bArr;
        this.c = bArr.length;
    }

    @Nullable
    public WebResourceResponse a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.e.getAndIncrement() == 0) {
                this.a.setData(new ByteArrayInputStream(this.d));
                return this.a;
            }
            int statusCode = this.a.getStatusCode();
            String reasonPhrase = this.a.getReasonPhrase();
            if (statusCode != 0 && !TextUtils.isEmpty(reasonPhrase)) {
                WebResourceResponse webResourceResponse = new WebResourceResponse(this.a.getMimeType(), this.a.getEncoding(), new ByteArrayInputStream(this.d));
                webResourceResponse.setResponseHeaders(this.a.getResponseHeaders());
                webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
                return webResourceResponse;
            }
            return null;
        }
        return (WebResourceResponse) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "WebResourceResponseWrap{size='" + this.c + "', calledCount='" + this.e.get() + "', isSuccessful='" + c() + "', isPrefetchData='" + b() + "', url='" + this.b + "'}";
        }
        return (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!jk6.b(this.a.getResponseHeaders())) {
                return TextUtils.equals(this.a.getResponseHeaders().get("tieba-response-via"), PrefetchEvent.MODULE);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (d() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }
}
