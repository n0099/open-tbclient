package com.bytedance.sdk.openadsdk;
/* loaded from: classes5.dex */
public class TTImage {

    /* renamed from: a  reason: collision with root package name */
    public int f27014a;

    /* renamed from: b  reason: collision with root package name */
    public int f27015b;

    /* renamed from: c  reason: collision with root package name */
    public String f27016c;

    /* renamed from: d  reason: collision with root package name */
    public double f27017d;

    public TTImage(int i, int i2, String str, double d2) {
        this.f27017d = 0.0d;
        this.f27014a = i;
        this.f27015b = i2;
        this.f27016c = str;
        this.f27017d = d2;
    }

    public double getDuration() {
        return this.f27017d;
    }

    public int getHeight() {
        return this.f27014a;
    }

    public String getImageUrl() {
        return this.f27016c;
    }

    public int getWidth() {
        return this.f27015b;
    }

    public boolean isValid() {
        String str;
        return this.f27014a > 0 && this.f27015b > 0 && (str = this.f27016c) != null && str.length() > 0;
    }
}
