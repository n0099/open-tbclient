package com.bytedance.sdk.openadsdk;
/* loaded from: classes4.dex */
public class TTLocation {

    /* renamed from: a  reason: collision with root package name */
    private double f6092a;

    /* renamed from: b  reason: collision with root package name */
    private double f6093b;

    public TTLocation(double d, double d2) {
        this.f6092a = 0.0d;
        this.f6093b = 0.0d;
        this.f6092a = d;
        this.f6093b = d2;
    }

    public double getLatitude() {
        return this.f6092a;
    }

    public void setLatitude(double d) {
        this.f6092a = d;
    }

    public double getLongitude() {
        return this.f6093b;
    }

    public void setLongitude(double d) {
        this.f6093b = d;
    }
}
