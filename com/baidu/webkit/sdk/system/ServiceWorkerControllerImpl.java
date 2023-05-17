package com.baidu.webkit.sdk.system;

import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.ServiceWorkerClient;
import com.baidu.webkit.sdk.ServiceWorkerController;
import com.baidu.webkit.sdk.ServiceWorkerWebSettings;
/* loaded from: classes8.dex */
public class ServiceWorkerControllerImpl extends ServiceWorkerController {
    public ServiceWorkerClient mClient;

    @Override // com.baidu.webkit.sdk.ServiceWorkerController
    public ServiceWorkerWebSettings getServiceWorkerWebSettings() {
        if (Build.VERSION.SDK_INT >= 24) {
            return ServiceWorkerWebSettingsImpl.from(android.webkit.ServiceWorkerController.getInstance().getServiceWorkerWebSettings());
        }
        return null;
    }

    @Override // com.baidu.webkit.sdk.ServiceWorkerController
    public void setServiceWorkerClient(@Nullable ServiceWorkerClient serviceWorkerClient) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mClient = serviceWorkerClient;
            android.webkit.ServiceWorkerController.getInstance().setServiceWorkerClient(new android.webkit.ServiceWorkerClient() { // from class: com.baidu.webkit.sdk.system.ServiceWorkerControllerImpl.1
                @Override // android.webkit.ServiceWorkerClient
                public WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
                    if (ServiceWorkerControllerImpl.this.mClient != null) {
                        return Glue.cast(ServiceWorkerControllerImpl.this.mClient.shouldInterceptRequest(WebResourceRequestImpl.from(webResourceRequest)));
                    }
                    return null;
                }
            });
        }
    }
}
