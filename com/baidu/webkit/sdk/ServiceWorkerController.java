package com.baidu.webkit.sdk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes15.dex */
public abstract class ServiceWorkerController {
    @NonNull
    public static ServiceWorkerController getInstance() {
        return WebViewFactory.getProvider().getServiceWorkerController();
    }

    @NonNull
    public abstract ServiceWorkerWebSettings getServiceWorkerWebSettings();

    public abstract void setServiceWorkerClient(@Nullable ServiceWorkerClient serviceWorkerClient);
}
