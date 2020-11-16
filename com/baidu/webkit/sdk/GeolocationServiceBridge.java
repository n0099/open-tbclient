package com.baidu.webkit.sdk;
/* loaded from: classes5.dex */
public class GeolocationServiceBridge {
    static GeolocationServiceBridge sInstance;
    private static final Object sLockObject = new Object();

    public static GeolocationServiceBridge getInstance() {
        GeolocationServiceBridge geolocationServiceBridge;
        synchronized (sLockObject) {
            if (sInstance != null) {
                geolocationServiceBridge = sInstance;
            } else {
                GeolocationServiceBridge geolocationServiceBridge2 = WebViewFactory.getProvider().getGeolocationServiceBridge();
                sInstance = geolocationServiceBridge2;
                if (geolocationServiceBridge2 == null) {
                    sInstance = new GeolocationServiceBridge();
                }
                geolocationServiceBridge = sInstance;
            }
        }
        return geolocationServiceBridge;
    }

    public void setClient(GeolocationServiceClient geolocationServiceClient) {
    }
}
