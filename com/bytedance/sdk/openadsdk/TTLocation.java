package com.bytedance.sdk.openadsdk;
/* loaded from: classes5.dex */
public class TTLocation {

    /* renamed from: a  reason: collision with root package name */
    public double f27324a;

    /* renamed from: b  reason: collision with root package name */
    public double f27325b;

    public TTLocation(double d2, double d3) {
        this.f27324a = 0.0d;
        this.f27325b = 0.0d;
        this.f27324a = d2;
        this.f27325b = d3;
    }

    public double getLatitude() {
        return this.f27324a;
    }

    public double getLongitude() {
        return this.f27325b;
    }

    public void setLatitude(double d2) {
        this.f27324a = d2;
    }

    public void setLongitude(double d2) {
        this.f27325b = d2;
    }
}
