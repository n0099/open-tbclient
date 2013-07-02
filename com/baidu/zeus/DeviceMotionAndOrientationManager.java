package com.baidu.zeus;
/* loaded from: classes.dex */
public final class DeviceMotionAndOrientationManager {
    static final /* synthetic */ boolean $assertionsDisabled;
    private WebViewCore mWebViewCore;

    private static native void nativeOnMotionChange(WebViewCore webViewCore, boolean z, double d, boolean z2, double d2, boolean z3, double d3, double d4);

    private static native void nativeOnOrientationChange(WebViewCore webViewCore, boolean z, double d, boolean z2, double d2, boolean z3, double d3);

    private static native void nativeSetMockOrientation(WebViewCore webViewCore, boolean z, double d, boolean z2, double d2, boolean z3, double d3);

    private static native void nativeUseMock(WebViewCore webViewCore);

    static {
        $assertionsDisabled = !DeviceMotionAndOrientationManager.class.desiredAssertionStatus();
    }

    public DeviceMotionAndOrientationManager(WebViewCore webViewCore) {
        this.mWebViewCore = webViewCore;
    }

    public void useMock() {
        if (!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName())) {
            throw new AssertionError();
        }
        nativeUseMock(this.mWebViewCore);
    }

    public void setMockOrientation(boolean z, double d, boolean z2, double d2, boolean z3, double d3) {
        if (!$assertionsDisabled && !"WebViewCoreThread".equals(Thread.currentThread().getName())) {
            throw new AssertionError();
        }
        nativeSetMockOrientation(this.mWebViewCore, z, d, z2, d2, z3, d3);
    }

    public void onMotionChange(Double d, Double d2, Double d3, double d4) {
        nativeOnMotionChange(this.mWebViewCore, d != null, d != null ? d.doubleValue() : 0.0d, d2 != null, d2 != null ? d2.doubleValue() : 0.0d, d3 != null, d3 != null ? d3.doubleValue() : 0.0d, d4);
    }

    public void onOrientationChange(Double d, Double d2, Double d3) {
        nativeOnOrientationChange(this.mWebViewCore, d != null, d != null ? d.doubleValue() : 0.0d, d2 != null, d2 != null ? d2.doubleValue() : 0.0d, d3 != null, d3 != null ? d3.doubleValue() : 0.0d);
    }
}
