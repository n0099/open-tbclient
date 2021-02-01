package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public class TTLocation {

    /* renamed from: a  reason: collision with root package name */
    private double f6094a;

    /* renamed from: b  reason: collision with root package name */
    private double f6095b;

    public TTLocation(double d, double d2) {
        this.f6094a = 0.0d;
        this.f6095b = 0.0d;
        this.f6094a = d;
        this.f6095b = d2;
    }

    public double getLatitude() {
        return this.f6094a;
    }

    public void setLatitude(double d) {
        this.f6094a = d;
    }

    public double getLongitude() {
        return this.f6095b;
    }

    public void setLongitude(double d) {
        this.f6095b = d;
    }
}
