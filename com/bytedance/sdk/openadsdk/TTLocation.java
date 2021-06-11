package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public class TTLocation {

    /* renamed from: a  reason: collision with root package name */
    public double f27115a;

    /* renamed from: b  reason: collision with root package name */
    public double f27116b;

    public TTLocation(double d2, double d3) {
        this.f27115a = 0.0d;
        this.f27116b = 0.0d;
        this.f27115a = d2;
        this.f27116b = d3;
    }

    public double getLatitude() {
        return this.f27115a;
    }

    public double getLongitude() {
        return this.f27116b;
    }

    public void setLatitude(double d2) {
        this.f27115a = d2;
    }

    public void setLongitude(double d2) {
        this.f27116b = d2;
    }
}
