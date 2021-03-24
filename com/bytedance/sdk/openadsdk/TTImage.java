package com.bytedance.sdk.openadsdk;
/* loaded from: classes5.dex */
public class TTImage {

    /* renamed from: a  reason: collision with root package name */
    public int f27320a;

    /* renamed from: b  reason: collision with root package name */
    public int f27321b;

    /* renamed from: c  reason: collision with root package name */
    public String f27322c;

    /* renamed from: d  reason: collision with root package name */
    public double f27323d;

    public TTImage(int i, int i2, String str, double d2) {
        this.f27323d = 0.0d;
        this.f27320a = i;
        this.f27321b = i2;
        this.f27322c = str;
        this.f27323d = d2;
    }

    public double getDuration() {
        return this.f27323d;
    }

    public int getHeight() {
        return this.f27320a;
    }

    public String getImageUrl() {
        return this.f27322c;
    }

    public int getWidth() {
        return this.f27321b;
    }

    public boolean isValid() {
        String str;
        return this.f27320a > 0 && this.f27321b > 0 && (str = this.f27322c) != null && str.length() > 0;
    }
}
