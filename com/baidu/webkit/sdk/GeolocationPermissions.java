package com.baidu.webkit.sdk;

import android.webkit.ValueCallback;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
/* loaded from: classes5.dex */
public class GeolocationPermissions {
    public static /* synthetic */ Interceptable $ic;
    public static final GeolocationPermissions mInstance;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface Callback {
        void invoke(String str, boolean z, boolean z2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(867708009, "Lcom/baidu/webkit/sdk/GeolocationPermissions;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(867708009, "Lcom/baidu/webkit/sdk/GeolocationPermissions;");
                return;
            }
        }
        mInstance = new GeolocationPermissions();
    }

    public GeolocationPermissions() {
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

    public static GeolocationPermissions getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? mInstance : (GeolocationPermissions) invokeV.objValue;
    }

    public void allow(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            WebViewFactory.getProvider().getGeolocationPermissions().allow(str);
        }
    }

    public void clear(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            WebViewFactory.getProvider().getGeolocationPermissions().clear(str);
        }
    }

    public void clearAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WebViewFactory.getProvider().getGeolocationPermissions().clearAll();
        }
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, valueCallback) == null) {
            WebViewFactory.getProvider().getGeolocationPermissions().getAllowed(str, valueCallback);
        }
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, valueCallback) == null) {
            WebViewFactory.getProvider().getGeolocationPermissions().getOrigins(valueCallback);
        }
    }
}
