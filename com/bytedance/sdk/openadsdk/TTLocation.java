package com.bytedance.sdk.openadsdk;
/* loaded from: classes5.dex */
public class TTLocation {

    /* renamed from: a  reason: collision with root package name */
    public double f27018a;

    /* renamed from: b  reason: collision with root package name */
    public double f27019b;

    public TTLocation(double d2, double d3) {
        this.f27018a = 0.0d;
        this.f27019b = 0.0d;
        this.f27018a = d2;
        this.f27019b = d3;
    }

    public double getLatitude() {
        return this.f27018a;
    }

    public double getLongitude() {
        return this.f27019b;
    }

    public void setLatitude(double d2) {
        this.f27018a = d2;
    }

    public void setLongitude(double d2) {
        this.f27019b = d2;
    }
}
