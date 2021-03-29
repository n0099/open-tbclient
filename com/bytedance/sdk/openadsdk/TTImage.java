package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public class TTImage {

    /* renamed from: a  reason: collision with root package name */
    public int f27321a;

    /* renamed from: b  reason: collision with root package name */
    public int f27322b;

    /* renamed from: c  reason: collision with root package name */
    public String f27323c;

    /* renamed from: d  reason: collision with root package name */
    public double f27324d;

    public TTImage(int i, int i2, String str, double d2) {
        this.f27324d = 0.0d;
        this.f27321a = i;
        this.f27322b = i2;
        this.f27323c = str;
        this.f27324d = d2;
    }

    public double getDuration() {
        return this.f27324d;
    }

    public int getHeight() {
        return this.f27321a;
    }

    public String getImageUrl() {
        return this.f27323c;
    }

    public int getWidth() {
        return this.f27322b;
    }

    public boolean isValid() {
        String str;
        return this.f27321a > 0 && this.f27322b > 0 && (str = this.f27323c) != null && str.length() > 0;
    }
}
