package com.baidu.webkit.sdk.performance;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes5.dex */
public class ZeusPerformance {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ZeusPerformanceTiming mTiming;

    public ZeusPerformance() {
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

    public PagePerformanceTiming pageTiming(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, webView)) == null) {
            if (webView == null || webView.getWebViewProvider() == null) {
                return null;
            }
            return webView.getWebViewProvider().getPerformanceTiming();
        }
        return (PagePerformanceTiming) invokeL.objValue;
    }

    public ZeusPerformanceTiming zeusTiming() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mTiming == null) {
                this.mTiming = new ZeusPerformanceTiming();
            }
            return this.mTiming;
        }
        return (ZeusPerformanceTiming) invokeV.objValue;
    }
}
