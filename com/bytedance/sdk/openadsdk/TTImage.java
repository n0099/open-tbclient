package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public class TTImage {

    /* renamed from: a  reason: collision with root package name */
    public int f27008a;

    /* renamed from: b  reason: collision with root package name */
    public int f27009b;

    /* renamed from: c  reason: collision with root package name */
    public String f27010c;

    /* renamed from: d  reason: collision with root package name */
    public double f27011d;

    public TTImage(int i2, int i3, String str, double d2) {
        this.f27011d = 0.0d;
        this.f27008a = i2;
        this.f27009b = i3;
        this.f27010c = str;
        this.f27011d = d2;
    }

    public double getDuration() {
        return this.f27011d;
    }

    public int getHeight() {
        return this.f27008a;
    }

    public String getImageUrl() {
        return this.f27010c;
    }

    public int getWidth() {
        return this.f27009b;
    }

    public boolean isValid() {
        String str;
        return this.f27008a > 0 && this.f27009b > 0 && (str = this.f27010c) != null && str.length() > 0;
    }
}
