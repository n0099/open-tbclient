package com.bytedance.sdk.openadsdk;
/* loaded from: classes2.dex */
public class TTLocation implements LocationProvider {
    public double a;

    /* renamed from: b  reason: collision with root package name */
    public double f53176b;

    public TTLocation(double d2, double d3) {
        this.a = 0.0d;
        this.f53176b = 0.0d;
        this.a = d2;
        this.f53176b = d3;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.f53176b;
    }

    public void setLatitude(double d2) {
        this.a = d2;
    }

    public void setLongitude(double d2) {
        this.f53176b = d2;
    }
}
