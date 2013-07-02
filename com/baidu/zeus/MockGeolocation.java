package com.baidu.zeus;
/* loaded from: classes.dex */
public final class MockGeolocation {
    private static MockGeolocation sMockGeolocation;

    private static native void nativeSetError(int i, String str);

    private static native void nativeSetPosition(double d, double d2, double d3);

    public void setPosition(double d, double d2, double d3) {
        nativeSetPosition(d, d2, d3);
    }

    public void setError(int i, String str) {
        nativeSetError(i, str);
    }

    public static MockGeolocation getInstance() {
        if (sMockGeolocation == null) {
            sMockGeolocation = new MockGeolocation();
        }
        return sMockGeolocation;
    }
}
