package com.bytedance.sdk.openadsdk;
/* loaded from: classes5.dex */
public class TTLocation {

    /* renamed from: a  reason: collision with root package name */
    public double f27838a;

    /* renamed from: b  reason: collision with root package name */
    public double f27839b;

    public TTLocation(double d2, double d3) {
        this.f27838a = 0.0d;
        this.f27839b = 0.0d;
        this.f27838a = d2;
        this.f27839b = d3;
    }

    public double getLatitude() {
        return this.f27838a;
    }

    public double getLongitude() {
        return this.f27839b;
    }

    public void setLatitude(double d2) {
        this.f27838a = d2;
    }

    public void setLongitude(double d2) {
        this.f27839b = d2;
    }
}
