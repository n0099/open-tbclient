package com.baidu.webkit.sdk;
/* loaded from: classes7.dex */
public class GeolocationServiceBridge {
    public static GeolocationServiceBridge sInstance;
    public static final Object sLockObject = new Object();

    public static GeolocationServiceBridge getInstance() {
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

    public void setClient(GeolocationServiceClient geolocationServiceClient) {
    }
}
