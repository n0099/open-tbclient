package com.baidu.webkit.sdk;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes2.dex */
public class WebIconDatabase {
    public static /* synthetic */ Interceptable $ic;
    public static final WebIconDatabase mInstance;
    public transient /* synthetic */ FieldHolder $fh;

    @Deprecated
    /* loaded from: classes2.dex */
    public interface IconListener {
        void onReceivedIcon(String str, Bitmap bitmap);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1969435943, "Lcom/baidu/webkit/sdk/WebIconDatabase;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1969435943, "Lcom/baidu/webkit/sdk/WebIconDatabase;");
                return;
            }
        }
        mInstance = new WebIconDatabase();
    }

    public WebIconDatabase() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static WebIconDatabase getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? mInstance : (WebIconDatabase) invokeV.objValue;
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            WebViewFactory.getProvider().getWebIconDatabase().close();
        }
    }

    public void open(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            WebViewFactory.getProvider().getWebIconDatabase().open(str);
        }
    }

    public void releaseIconForPageUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            WebViewFactory.getProvider().getWebIconDatabase().releaseIconForPageUrl(str);
        }
    }

    public void removeAllIcons() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            WebViewFactory.getProvider().getWebIconDatabase().removeAllIcons();
        }
    }

    public void requestIconForPageUrl(String str, IconListener iconListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, iconListener) == null) {
            WebViewFactory.getProvider().getWebIconDatabase().requestIconForPageUrl(str, iconListener);
        }
    }

    public void retainIconForPageUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            WebViewFactory.getProvider().getWebIconDatabase().retainIconForPageUrl(str);
        }
    }
}
