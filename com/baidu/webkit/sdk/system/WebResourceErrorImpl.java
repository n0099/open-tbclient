package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebResourceError;
@TargetApi(23)
/* loaded from: classes5.dex */
public final class WebResourceErrorImpl extends WebResourceError {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final android.webkit.WebResourceError mError;

    public WebResourceErrorImpl(android.webkit.WebResourceError webResourceError) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webResourceError};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mError = webResourceError;
    }

    public static WebResourceError from(android.webkit.WebResourceError webResourceError) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, webResourceError)) == null) {
            if (webResourceError == null) {
                return null;
            }
            return new WebResourceErrorImpl(webResourceError);
        }
        return (WebResourceError) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebResourceError
    public final CharSequence getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mError.getDescription() : (CharSequence) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebResourceError
    public final int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mError.getErrorCode() : invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebResourceError
    public final int getOriginErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }
}
