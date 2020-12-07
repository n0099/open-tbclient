package com.baidu.webkit.sdk;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes12.dex */
public abstract class ServiceWorkerController {
    @NonNull
    public static ServiceWorkerController getInstance() {
        return WebViewFactory.getProvider().getServiceWorkerController();
    }

    @NonNull
    public abstract ServiceWorkerWebSettings getServiceWorkerWebSettings();

    public abstract void setServiceWorkerClient(@Nullable ServiceWorkerClient serviceWorkerClient);
}
