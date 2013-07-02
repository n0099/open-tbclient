package com.baidu.zeus;
/* loaded from: classes.dex */
public class JsResult {
    private final boolean mDefaultValue;
    protected final CallbackProxy mProxy;
    private boolean mReady;
    protected boolean mResult;
    private boolean mTriedToNotifyBeforeReady;

    public final void cancel() {
        this.mResult = false;
        wakeUp();
    }

    public final void confirm() {
        this.mResult = true;
        wakeUp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsResult(CallbackProxy callbackProxy, boolean z) {
        this.mProxy = callbackProxy;
        this.mDefaultValue = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getResult() {
        return this.mResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setReady() {
        this.mReady = true;
        if (this.mTriedToNotifyBeforeReady) {
            wakeUp();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleDefault() {
        setReady();
        this.mResult = this.mDefaultValue;
        wakeUp();
    }

    protected final void wakeUp() {
        if (this.mReady) {
            synchronized (this.mProxy) {
                this.mProxy.notify();
            }
            return;
        }
        this.mTriedToNotifyBeforeReady = true;
    }
}
