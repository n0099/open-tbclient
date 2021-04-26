package com.bytedance.sdk.openadsdk;
/* loaded from: classes5.dex */
public class TTImage {

    /* renamed from: a  reason: collision with root package name */
    public int f27834a;

    /* renamed from: b  reason: collision with root package name */
    public int f27835b;

    /* renamed from: c  reason: collision with root package name */
    public String f27836c;

    /* renamed from: d  reason: collision with root package name */
    public double f27837d;

    public TTImage(int i2, int i3, String str, double d2) {
        this.f27837d = 0.0d;
        this.f27834a = i2;
        this.f27835b = i3;
        this.f27836c = str;
        this.f27837d = d2;
    }

    public double getDuration() {
        return this.f27837d;
    }

    public int getHeight() {
        return this.f27834a;
    }

    public String getImageUrl() {
        return this.f27836c;
    }

    public int getWidth() {
        return this.f27835b;
    }

    public boolean isValid() {
        String str;
        return this.f27834a > 0 && this.f27835b > 0 && (str = this.f27836c) != null && str.length() > 0;
    }
}
