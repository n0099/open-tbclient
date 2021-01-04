package com.bytedance.sdk.openadsdk;
/* loaded from: classes4.dex */
public class TTLocation {

    /* renamed from: a  reason: collision with root package name */
    private double f6391a;

    /* renamed from: b  reason: collision with root package name */
    private double f6392b;

    public TTLocation(double d, double d2) {
        this.f6391a = 0.0d;
        this.f6392b = 0.0d;
        this.f6391a = d;
        this.f6392b = d2;
    }

    public double getLatitude() {
        return this.f6391a;
    }

    public void setLatitude(double d) {
        this.f6391a = d;
    }

    public double getLongitude() {
        return this.f6392b;
    }

    public void setLongitude(double d) {
        this.f6392b = d;
    }
}
