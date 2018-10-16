package com.baidu.webkit.sdk;
/* loaded from: classes2.dex */
public class GeolocationServiceBridge {
    static GeolocationServiceBridge sInstance = null;

    public static synchronized GeolocationServiceBridge getInstance() {
        GeolocationServiceBridge geolocationServiceBridge;
        synchronized (GeolocationServiceBridge.class) {
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
