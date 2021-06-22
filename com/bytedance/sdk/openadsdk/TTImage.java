package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public class TTImage {

    /* renamed from: a  reason: collision with root package name */
    public int f27193a;

    /* renamed from: b  reason: collision with root package name */
    public int f27194b;

    /* renamed from: c  reason: collision with root package name */
    public String f27195c;

    /* renamed from: d  reason: collision with root package name */
    public double f27196d;

    public TTImage(int i2, int i3, String str, double d2) {
        this.f27196d = 0.0d;
        this.f27193a = i2;
        this.f27194b = i3;
        this.f27195c = str;
        this.f27196d = d2;
    }

    public double getDuration() {
        return this.f27196d;
    }

    public int getHeight() {
        return this.f27193a;
    }

    public String getImageUrl() {
        return this.f27195c;
    }

    public int getWidth() {
        return this.f27194b;
    }

    public boolean isValid() {
        String str;
        return this.f27193a > 0 && this.f27194b > 0 && (str = this.f27195c) != null && str.length() > 0;
    }
}
