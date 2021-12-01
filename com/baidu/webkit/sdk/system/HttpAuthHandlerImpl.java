package com.baidu.webkit.sdk.system;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.HttpAuthHandler;
/* loaded from: classes12.dex */
public final class HttpAuthHandlerImpl extends HttpAuthHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final android.webkit.HttpAuthHandler mHandler;

    public HttpAuthHandlerImpl(android.webkit.HttpAuthHandler httpAuthHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpAuthHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandler = httpAuthHandler;
    }

    public static HttpAuthHandler from(android.webkit.HttpAuthHandler httpAuthHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, httpAuthHandler)) == null) {
            if (httpAuthHandler == null) {
                return null;
            }
            return new HttpAuthHandlerImpl(httpAuthHandler);
        }
        return (HttpAuthHandler) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.HttpAuthHandler
    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mHandler.cancel();
        }
    }

    @Override // com.baidu.webkit.sdk.HttpAuthHandler
    public final void proceed(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.mHandler.proceed(str, str2);
        }
    }

    @Override // com.baidu.webkit.sdk.HttpAuthHandler
    public final boolean useHttpAuthUsernamePassword() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mHandler.useHttpAuthUsernamePassword() : invokeV.booleanValue;
    }
}
