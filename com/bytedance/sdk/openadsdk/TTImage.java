package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public class TTImage {

    /* renamed from: a  reason: collision with root package name */
    public int f27079a;

    /* renamed from: b  reason: collision with root package name */
    public int f27080b;

    /* renamed from: c  reason: collision with root package name */
    public String f27081c;

    /* renamed from: d  reason: collision with root package name */
    public double f27082d;

    public TTImage(int i2, int i3, String str, double d2) {
        this.f27082d = 0.0d;
        this.f27079a = i2;
        this.f27080b = i3;
        this.f27081c = str;
        this.f27082d = d2;
    }

    public double getDuration() {
        return this.f27082d;
    }

    public int getHeight() {
        return this.f27079a;
    }

    public String getImageUrl() {
        return this.f27081c;
    }

    public int getWidth() {
        return this.f27080b;
    }

    public boolean isValid() {
        String str;
        return this.f27079a > 0 && this.f27080b > 0 && (str = this.f27081c) != null && str.length() > 0;
    }
}
