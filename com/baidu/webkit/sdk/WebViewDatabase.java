package com.baidu.webkit.sdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class WebViewDatabase {
    public static /* synthetic */ Interceptable $ic;
    public static Context mContext;
    public static final WebViewDatabase mInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2049283973, "Lcom/baidu/webkit/sdk/WebViewDatabase;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2049283973, "Lcom/baidu/webkit/sdk/WebViewDatabase;");
                return;
            }
        }
        mInstance = new WebViewDatabase();
    }

    public WebViewDatabase() {
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

    public static WebViewDatabase getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (mContext == null) {
                mContext = context;
            }
            return mInstance;
        }
        return (WebViewDatabase) invokeL.objValue;
    }

    public void clearFormData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            WebViewFactory.getProvider().getWebViewDatabase(mContext).clearFormData();
        }
    }

    public void clearHttpAuthUsernamePassword() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            WebViewFactory.getProvider().getWebViewDatabase(mContext).clearHttpAuthUsernamePassword();
        }
    }

    @Deprecated
    public void clearUsernamePassword() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WebViewFactory.getProvider().getWebViewDatabase(mContext).clearUsernamePassword();
        }
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? WebViewFactory.getProvider().getWebViewDatabase(mContext).getHttpAuthUsernamePassword(str, str2) : (String[]) invokeLL.objValue;
    }

    public boolean hasFormData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? WebViewFactory.getProvider().getWebViewDatabase(mContext).hasFormData() : invokeV.booleanValue;
    }

    public boolean hasHttpAuthUsernamePassword() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? WebViewFactory.getProvider().getWebViewDatabase(mContext).hasHttpAuthUsernamePassword() : invokeV.booleanValue;
    }

    @Deprecated
    public boolean hasUsernamePassword() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? WebViewFactory.getProvider().getWebViewDatabase(mContext).hasUsernamePassword() : invokeV.booleanValue;
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, str4) == null) {
            WebViewFactory.getProvider().getWebViewDatabase(mContext).setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }
}
