package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import com.baidu.webkit.sdk.WebMessagePort;
/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(23)
/* loaded from: classes19.dex */
public final class WebMessagePortImpl extends WebMessagePort {
    private final android.webkit.WebMessagePort mMsgPort;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes19.dex */
    public class WebMessageCallbackWrapper extends WebMessagePort.WebMessageCallback {
        static final /* synthetic */ boolean $assertionsDisabled;
        private final WebMessagePort.WebMessageCallback mCallback;

        static {
            $assertionsDisabled = !WebMessagePortImpl.class.desiredAssertionStatus();
        }

        public WebMessageCallbackWrapper(WebMessagePort.WebMessageCallback webMessageCallback) {
            this.mCallback = webMessageCallback;
        }

        @Override // android.webkit.WebMessagePort.WebMessageCallback
        public void onMessage(android.webkit.WebMessagePort webMessagePort, WebMessage webMessage) {
            if (!$assertionsDisabled && webMessagePort != WebMessagePortImpl.this.mMsgPort) {
                throw new AssertionError();
            }
            this.mCallback.onMessage(WebMessagePortImpl.this, Glue.cast(webMessage));
        }
    }

    private WebMessagePortImpl(android.webkit.WebMessagePort webMessagePort) {
        this.mMsgPort = webMessagePort;
    }

    static com.baidu.webkit.sdk.WebMessagePort from(android.webkit.WebMessagePort webMessagePort) {
        if (webMessagePort == null) {
            return null;
        }
        return new WebMessagePortImpl(webMessagePort);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static android.webkit.WebMessagePort[] from(com.baidu.webkit.sdk.WebMessagePort[] webMessagePortArr) {
        if (webMessagePortArr == null) {
            return null;
        }
        android.webkit.WebMessagePort[] webMessagePortArr2 = new android.webkit.WebMessagePort[webMessagePortArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= webMessagePortArr.length) {
                return webMessagePortArr2;
            }
            webMessagePortArr2[i2] = ((WebMessagePortImpl) webMessagePortArr[i2]).getImpl();
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
