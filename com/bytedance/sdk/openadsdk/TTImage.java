package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public class TTImage {

    /* renamed from: a  reason: collision with root package name */
    public int f27111a;

    /* renamed from: b  reason: collision with root package name */
    public int f27112b;

    /* renamed from: c  reason: collision with root package name */
    public String f27113c;

    /* renamed from: d  reason: collision with root package name */
    public double f27114d;

    public TTImage(int i2, int i3, String str, double d2) {
        this.f27114d = 0.0d;
        this.f27111a = i2;
        this.f27112b = i3;
        this.f27113c = str;
        this.f27114d = d2;
    }

    public double getDuration() {
        return this.f27114d;
    }

    public int getHeight() {
        return this.f27111a;
    }

    public String getImageUrl() {
        return this.f27113c;
    }

    public int getWidth() {
        return this.f27112b;
    }

    public boolean isValid() {
        String str;
        return this.f27111a > 0 && this.f27112b > 0 && (str = this.f27113c) != null && str.length() > 0;
    }
}
