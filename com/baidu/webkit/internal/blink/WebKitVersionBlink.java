package com.baidu.webkit.internal.blink;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes9.dex */
public class WebKitVersionBlink implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "WebKitBlinkVer";
    public transient /* synthetic */ FieldHolder $fh;

    public WebKitVersionBlink() {
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

    public static String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (WebViewFactory.hasProvider()) {
                try {
                    if (WebViewFactory.isOptimizedPackageInfoEnabled() && WebKitFactory.getCurEngine() == 1) {
                        return WebViewFactory.getZeusVersionName();
                    }
                    WebViewFactory.getLoadedPackageInfo();
                    return WebViewFactory.getLoadedPackageInfo().versionName;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return GlobalConstants.DEFAULT_VERSION;
                }
            }
            return GlobalConstants.DEFAULT_VERSION;
        }
        return (String) invokeV.objValue;
    }

    public static String getZeusVersionByUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (WebViewFactory.hasProvider() && WebKitFactory.getCurEngine() == 1) {
                try {
                    if (WebViewFactory.isOptimizedPackageInfoEnabled()) {
                        return WebViewFactory.getZeusVersionName();
                    }
                    WebViewFactory.getLoadedPackageInfo();
                    return WebViewFactory.getLoadedPackageInfo().versionName;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return GlobalConstants.ZEUS_VERSION_NAME;
                }
            }
            return GlobalConstants.ZEUS_VERSION_NAME;
        }
        return (String) invokeV.objValue;
    }
}
