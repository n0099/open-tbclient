package com.bytedance.sdk.openadsdk;
/* loaded from: classes4.dex */
public class TTImage {

    /* renamed from: a  reason: collision with root package name */
    private int f6090a;

    /* renamed from: b  reason: collision with root package name */
    private int f6091b;
    private String c;

    public TTImage(int i, int i2, String str) {
        this.f6090a = i;
        this.f6091b = i2;
        this.c = str;
    }

    public int getHeight() {
        return this.f6090a;
    }

    public int getWidth() {
        return this.f6091b;
    }

    public String getImageUrl() {
        return this.c;
    }

    public boolean isValid() {
        return this.f6090a > 0 && this.f6091b > 0 && this.c != null && this.c.length() > 0;
    }
}
