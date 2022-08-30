package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ServiceWorkerWebSettings;
/* loaded from: classes6.dex */
public class ServiceWorkerWebSettingsImpl extends ServiceWorkerWebSettings {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @TargetApi(24)
    public android.webkit.ServiceWorkerWebSettings mSettings;

    public ServiceWorkerWebSettingsImpl(android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {serviceWorkerWebSettings};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.mSettings = serviceWorkerWebSettings;
        }
    }

    public static ServiceWorkerWebSettingsImpl from(android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, serviceWorkerWebSettings)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return new ServiceWorkerWebSettingsImpl(serviceWorkerWebSettings);
            }
            return null;
        }
        return (ServiceWorkerWebSettingsImpl) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public boolean getAllowContentAccess() {
        InterceptResult invokeV;
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
                return false;
            }
            return serviceWorkerWebSettings.getAllowContentAccess();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public boolean getAllowFileAccess() {
        InterceptResult invokeV;
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
                return false;
            }
            return serviceWorkerWebSettings.getAllowFileAccess();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public boolean getBlockNetworkLoads() {
        InterceptResult invokeV;
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
                return false;
            }
            return serviceWorkerWebSettings.getBlockNetworkLoads();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public int getCacheMode() {
        InterceptResult invokeV;
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
                return -1;
            }
            return serviceWorkerWebSettings.getCacheMode();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public void setAllowContentAccess(boolean z) {
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
            return;
        }
        serviceWorkerWebSettings.setAllowContentAccess(z);
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public void setAllowFileAccess(boolean z) {
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
            return;
        }
        serviceWorkerWebSettings.setAllowFileAccess(z);
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public void setBlockNetworkLoads(boolean z) {
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
            return;
        }
        serviceWorkerWebSettings.setBlockNetworkLoads(z);
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerWebSettings
    public void setCacheMode(int i) {
        android.webkit.ServiceWorkerWebSettings serviceWorkerWebSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || Build.VERSION.SDK_INT < 24 || (serviceWorkerWebSettings = this.mSettings) == null) {
            return;
        }
        serviceWorkerWebSettings.setCacheMode(i);
    }
}
