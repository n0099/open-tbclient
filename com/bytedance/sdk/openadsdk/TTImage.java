package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public class TTImage {

    /* renamed from: a  reason: collision with root package name */
    private int f4079a;
    private int b;
    private String c;
    private double d;

    public TTImage(int i, int i2, String str, double d) {
        this.d = 0.0d;
        this.f4079a = i;
        this.b = i2;
        this.c = str;
        this.d = d;
    }

    public int getHeight() {
        return this.f4079a;
    }

    public int getWidth() {
        return this.b;
    }

    public String getImageUrl() {
        return this.c;
    }

    public double getDuration() {
        return this.d;
    }

    public boolean isValid() {
        return this.f4079a > 0 && this.b > 0 && this.c != null && this.c.length() > 0;
    }
}
