package com.baidu.webkit.sdk;

import android.os.Handler;
/* loaded from: classes5.dex */
public abstract class WebMessagePort {

    /* loaded from: classes5.dex */
    public static abstract class WebMessageCallback {
        public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
        }
    }

    public abstract void close();

    public abstract void postMessage(WebMessage webMessage);

    public abstract void setWebMessageCallback(WebMessageCallback webMessageCallback);

    public abstract void setWebMessageCallback(WebMessageCallback webMessageCallback, Handler handler);
}
