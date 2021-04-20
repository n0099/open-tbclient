package com.bytedance.sdk.openadsdk;
/* loaded from: classes5.dex */
public class TTLocation {

    /* renamed from: a  reason: collision with root package name */
    public double f27010a;

    /* renamed from: b  reason: collision with root package name */
    public double f27011b;

    public TTLocation(double d2, double d3) {
        this.f27010a = 0.0d;
        this.f27011b = 0.0d;
        this.f27010a = d2;
        this.f27011b = d3;
    }

    public double getLatitude() {
        return this.f27010a;
    }

    public double getLongitude() {
        return this.f27011b;
    }

    public void setLatitude(double d2) {
        this.f27010a = d2;
    }

    public void setLongitude(double d2) {
        this.f27011b = d2;
    }
}
