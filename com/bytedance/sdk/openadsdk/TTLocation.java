package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public class TTLocation {

    /* renamed from: a  reason: collision with root package name */
    public double f27083a;

    /* renamed from: b  reason: collision with root package name */
    public double f27084b;

    public TTLocation(double d2, double d3) {
        this.f27083a = 0.0d;
        this.f27084b = 0.0d;
        this.f27083a = d2;
        this.f27084b = d3;
    }

    public double getLatitude() {
        return this.f27083a;
    }

    public double getLongitude() {
        return this.f27084b;
    }

    public void setLatitude(double d2) {
        this.f27083a = d2;
    }

    public void setLongitude(double d2) {
        this.f27084b = d2;
    }
}
