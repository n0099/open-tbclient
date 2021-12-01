package com.baidu.webkit.sdk.system;

import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ServiceWorkerClient;
import com.baidu.webkit.sdk.ServiceWorkerController;
import com.baidu.webkit.sdk.ServiceWorkerWebSettings;
/* loaded from: classes12.dex */
public class ServiceWorkerControllerImpl extends ServiceWorkerController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ServiceWorkerClient mClient;

    public ServiceWorkerControllerImpl() {
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

    @Override // com.baidu.webkit.sdk.ServiceWorkerController
    public ServiceWorkerWebSettings getServiceWorkerWebSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return ServiceWorkerWebSettingsImpl.from(android.webkit.ServiceWorkerController.getInstance().getServiceWorkerWebSettings());
            }
            return null;
        }
        return (ServiceWorkerWebSettings) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerController
    public void setServiceWorkerClient(@Nullable ServiceWorkerClient serviceWorkerClient) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, serviceWorkerClient) == null) || Build.VERSION.SDK_INT < 24) {
            return;
        }
        this.mClient = serviceWorkerClient;
        android.webkit.ServiceWorkerController.getInstance().setServiceWorkerClient(new android.webkit.ServiceWorkerClient(this) { // from class: com.baidu.webkit.sdk.system.ServiceWorkerControllerImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ServiceWorkerControllerImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.webkit.ServiceWorkerClient
            public WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, webResourceRequest)) == null) {
                    if (this.this$0.mClient != null) {
                        return Glue.cast(this.this$0.mClient.shouldInterceptRequest(WebResourceRequestImpl.from(webResourceRequest)));
                    }
                    return null;
                }
                return (WebResourceResponse) invokeL.objValue;
            }
        });
    }
}
