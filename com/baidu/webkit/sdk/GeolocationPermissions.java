package com.baidu.webkit.sdk;

import android.webkit.ValueCallback;
import java.util.Set;
/* loaded from: classes12.dex */
public class GeolocationPermissions {
    private static final GeolocationPermissions mInstance = new GeolocationPermissions();

    /* loaded from: classes12.dex */
    public interface Callback {
        void invoke(String str, boolean z, boolean z2);
    }

    public static GeolocationPermissions getInstance() {
        return mInstance;
    }

    public void allow(String str) {
        WebViewFactory.getProvider().getGeolocationPermissions().allow(str);
    }

    public void clear(String str) {
        WebViewFactory.getProvider().getGeolocationPermissions().clear(str);
    }

    public void clearAll() {
        WebViewFactory.getProvider().getGeolocationPermissions().clearAll();
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        WebViewFactory.getProvider().getGeolocationPermissions().getAllowed(str, valueCallback);
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        WebViewFactory.getProvider().getGeolocationPermissions().getOrigins(valueCallback);
    }
}
