package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public class TTLocation {

    /* renamed from: a  reason: collision with root package name */
    public double f27325a;

    /* renamed from: b  reason: collision with root package name */
    public double f27326b;

    public TTLocation(double d2, double d3) {
        this.f27325a = 0.0d;
        this.f27326b = 0.0d;
        this.f27325a = d2;
        this.f27326b = d3;
    }

    public double getLatitude() {
        return this.f27325a;
    }

    public double getLongitude() {
        return this.f27326b;
    }

    public void setLatitude(double d2) {
        this.f27325a = d2;
    }

    public void setLongitude(double d2) {
        this.f27326b = d2;
    }
}
