package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public class TTImage {

    /* renamed from: a  reason: collision with root package name */
    private int f6092a;

    /* renamed from: b  reason: collision with root package name */
    private int f6093b;
    private String c;

    public TTImage(int i, int i2, String str) {
        this.f6092a = i;
        this.f6093b = i2;
        this.c = str;
    }

    public int getHeight() {
        return this.f6092a;
    }

    public int getWidth() {
        return this.f6093b;
    }

    public String getImageUrl() {
        return this.c;
    }

    public boolean isValid() {
        return this.f6092a > 0 && this.f6093b > 0 && this.c != null && this.c.length() > 0;
    }
}
