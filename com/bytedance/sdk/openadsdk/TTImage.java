package com.bytedance.sdk.openadsdk;
/* loaded from: classes5.dex */
public class TTImage {

    /* renamed from: a  reason: collision with root package name */
    public int f27006a;

    /* renamed from: b  reason: collision with root package name */
    public int f27007b;

    /* renamed from: c  reason: collision with root package name */
    public String f27008c;

    /* renamed from: d  reason: collision with root package name */
    public double f27009d;

    public TTImage(int i, int i2, String str, double d2) {
        this.f27009d = 0.0d;
        this.f27006a = i;
        this.f27007b = i2;
        this.f27008c = str;
        this.f27009d = d2;
    }

    public double getDuration() {
        return this.f27009d;
    }

    public int getHeight() {
        return this.f27006a;
    }

    public String getImageUrl() {
        return this.f27008c;
    }

    public int getWidth() {
        return this.f27007b;
    }

    public boolean isValid() {
        String str;
        return this.f27006a > 0 && this.f27007b > 0 && (str = this.f27008c) != null && str.length() > 0;
    }
}
