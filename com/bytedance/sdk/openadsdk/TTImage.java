package com.bytedance.sdk.openadsdk;
/* loaded from: classes4.dex */
public class TTImage {

    /* renamed from: a  reason: collision with root package name */
    private int f6389a;

    /* renamed from: b  reason: collision with root package name */
    private int f6390b;
    private String c;

    public TTImage(int i, int i2, String str) {
        this.f6389a = i;
        this.f6390b = i2;
        this.c = str;
    }

    public int getHeight() {
        return this.f6389a;
    }

    public int getWidth() {
        return this.f6390b;
    }

    public String getImageUrl() {
        return this.c;
    }

    public boolean isValid() {
        return this.f6389a > 0 && this.f6390b > 0 && this.c != null && this.c.length() > 0;
    }
}
