package com.bytedance.sdk.openadsdk;
/* loaded from: classes8.dex */
public class TTLocation implements LocationProvider {
    public double a;
    public double b;

    public TTLocation(double d, double d2) {
        this.a = 0.0d;
        this.b = 0.0d;
        this.a = d;
        this.b = d2;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.b;
    }

    public void setLatitude(double d) {
        this.a = d;
    }

    public void setLongitude(double d) {
        this.b = d;
    }
}
