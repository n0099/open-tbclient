package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import com.baidu.webkit.sdk.WebMessagePort;
@TargetApi(23)
/* loaded from: classes7.dex */
public final class WebMessagePortImpl extends WebMessagePort {
    public final android.webkit.WebMessagePort mMsgPort;

    /* loaded from: classes7.dex */
    public class WebMessageCallbackWrapper extends WebMessagePort.WebMessageCallback {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public final WebMessagePort.WebMessageCallback mCallback;

        public WebMessageCallbackWrapper(WebMessagePort.WebMessageCallback webMessageCallback) {
            this.mCallback = webMessageCallback;
        }

        @Override // android.webkit.WebMessagePort.WebMessageCallback
        public void onMessage(android.webkit.WebMessagePort webMessagePort, WebMessage webMessage) {
            this.mCallback.onMessage(WebMessagePortImpl.this, Glue.cast(webMessage));
        }
    }

    public WebMessagePortImpl(android.webkit.WebMessagePort webMessagePort) {
        this.mMsgPort = webMessagePort;
    }

    public static com.baidu.webkit.sdk.WebMessagePort from(android.webkit.WebMessagePort webMessagePort) {
        if (webMessagePort == null) {
            return null;
        }
        return new WebMessagePortImpl(webMessagePort);
    }

    public static android.webkit.WebMessagePort[] from(com.baidu.webkit.sdk.WebMessagePort[] webMessagePortArr) {
        if (webMessagePortArr == null) {
            return null;
        }
        android.webkit.WebMessagePort[] webMessagePortArr2 = new android.webkit.WebMessagePort[webMessagePortArr.length];
        for (int i = 0; i < webMessagePortArr.length; i++) {
            webMessagePortArr2[i] = ((WebMessagePortImpl) webMessagePortArr[i]).getImpl();
        }
        return webMessagePortArr2;
    }

    public static com.baidu.webkit.sdk.WebMessagePort[] from(android.webkit.WebMessagePort[] webMessagePortArr) {
        if (webMessagePortArr == null) {
            return null;
        }
        com.baidu.webkit.sdk.WebMessagePort[] webMessagePortArr2 = new com.baidu.webkit.sdk.WebMessagePort[webMessagePortArr.length];
        for (int i = 0; i < webMessagePortArr.length; i++) {
            webMessagePortArr2[i] = from(webMessagePortArr[i]);
        }
        return webMessagePortArr2;
    }

    @Override // com.baidu.webkit.sdk.WebMessagePort
    public final void close() {
        this.mMsgPort.close();
    }

    public final android.webkit.WebMessagePort getImpl() {
        return this.mMsgPort;
    }

    @Override // com.baidu.webkit.sdk.WebMessagePort
    public final void postMessage(com.baidu.webkit.sdk.WebMessage webMessage) {
        this.mMsgPort.postMessage(Glue.cast(webMessage));
    }

    @Override // com.baidu.webkit.sdk.WebMessagePort
    public final void setWebMessageCallback(WebMessagePort.WebMessageCallback webMessageCallback) {
        setWebMessageCallback(webMessageCallback, null);
    }

    @Override // com.baidu.webkit.sdk.WebMessagePort
    public final void setWebMessageCallback(WebMessagePort.WebMessageCallback webMessageCallback, Handler handler) {
        if (webMessageCallback != null) {
            this.mMsgPort.setWebMessageCallback(new WebMessageCallbackWrapper(webMessageCallback), handler);
        }
    }
}
