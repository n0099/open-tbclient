package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebResourceRequest;
import java.util.Map;
@TargetApi(21)
/* loaded from: classes4.dex */
public final class WebResourceRequestImpl implements WebResourceRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final android.webkit.WebResourceRequest mRequest;

    public WebResourceRequestImpl(android.webkit.WebResourceRequest webResourceRequest) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webResourceRequest};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRequest = webResourceRequest;
    }

    public static WebResourceRequest from(android.webkit.WebResourceRequest webResourceRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, webResourceRequest)) == null) {
            if (webResourceRequest == null) {
                return null;
            }
            return new WebResourceRequestImpl(webResourceRequest);
        }
        return (WebResourceRequest) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebResourceRequest
    public final String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRequest.getMethod() : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebResourceRequest
    public final Map<String, String> getRequestHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRequest.getRequestHeaders() : (Map) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebResourceRequest
    public final Uri getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRequest.getUrl() : (Uri) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebResourceRequest
    public final boolean hasGesture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRequest.hasGesture() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebResourceRequest
    public final boolean isForMainFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRequest.isForMainFrame() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebResourceRequest
    @TargetApi(24)
    public final boolean isRedirect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return this.mRequest.isRedirect();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
