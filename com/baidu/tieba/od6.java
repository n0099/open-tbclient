package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
/* loaded from: classes5.dex */
public class od6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WebResourceResponse a;
    public final ByteArrayInputStream b;
    public final int c;

    public od6(WebResourceResponse webResourceResponse, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webResourceResponse, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = webResourceResponse;
        if (bArr != null) {
            this.c = bArr.length;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            this.b = byteArrayInputStream;
            byteArrayInputStream.mark(0);
            return;
        }
        this.c = 0;
        this.b = null;
    }

    public WebResourceResponse a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.b != null && c()) {
                this.b.reset();
                this.a.setData(this.b);
            }
            return this.a;
        }
        return (WebResourceResponse) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a != null && this.b != null && d() > 0) {
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

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WebResourceResponse webResourceResponse = this.a;
            if (webResourceResponse != null && !ef6.b(webResourceResponse.getResponseHeaders())) {
                return TextUtils.equals(this.a.getResponseHeaders().get("tieba-response-via"), PrefetchEvent.MODULE);
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
