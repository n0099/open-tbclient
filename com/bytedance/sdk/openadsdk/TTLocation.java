package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public class TTLocation {

    /* renamed from: a  reason: collision with root package name */
    public double f27012a;

    /* renamed from: b  reason: collision with root package name */
    public double f27013b;

    public TTLocation(double d2, double d3) {
        this.f27012a = 0.0d;
        this.f27013b = 0.0d;
        this.f27012a = d2;
        this.f27013b = d3;
    }

    public double getLatitude() {
        return this.f27012a;
    }

    public double getLongitude() {
        return this.f27013b;
    }

    public void setLatitude(double d2) {
        this.f27012a = d2;
    }

    public void setLongitude(double d2) {
        this.f27013b = d2;
    }
}
