package com.baidu.webkit.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class GeolocationServiceBridge {
    public static /* synthetic */ Interceptable $ic;
    public static GeolocationServiceBridge sInstance;
    public static final Object sLockObject;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(187294991, "Lcom/baidu/webkit/sdk/GeolocationServiceBridge;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(187294991, "Lcom/baidu/webkit/sdk/GeolocationServiceBridge;");
                return;
            }
        }
        sLockObject = new Object();
    }

    public GeolocationServiceBridge() {
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

    public static GeolocationServiceBridge getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (sLockObject) {
                if (sInstance != null) {
                    return sInstance;
                }
                GeolocationServiceBridge geolocationServiceBridge = WebViewFactory.getProvider().getGeolocationServiceBridge();
                sInstance = geolocationServiceBridge;
                if (geolocationServiceBridge == null) {
                    sInstance = new GeolocationServiceBridge();
                }
                return sInstance;
            }
        }
        return (GeolocationServiceBridge) invokeV.objValue;
    }

    public void setClient(GeolocationServiceClient geolocationServiceClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, geolocationServiceClient) == null) {
        }
    }
}
