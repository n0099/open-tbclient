package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public class TTLocation {

    /* renamed from: a  reason: collision with root package name */
    private double f4080a;
    private double b;

    public TTLocation(double d, double d2) {
        this.f4080a = 0.0d;
        this.b = 0.0d;
        this.f4080a = d;
        this.b = d2;
    }

    public double getLatitude() {
        return this.f4080a;
    }

    public void setLatitude(double d) {
        this.f4080a = d;
    }

    public double getLongitude() {
        return this.b;
    }

    public void setLongitude(double d) {
        this.b = d;
    }
}
