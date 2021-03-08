package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private String f4397a;
    private int b;
    private int c;
    private double d;

    public String a() {
        return this.f4397a;
    }

    public void a(String str) {
        this.f4397a = str;
    }

    public int b() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public int c() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public double d() {
        return this.d;
    }

    public void a(double d) {
        this.d = d;
    }

    public boolean e() {
        return !TextUtils.isEmpty(this.f4397a) && this.b > 0 && this.c > 0;
    }

    public static TTImage a(k kVar) {
        if (kVar == null || !kVar.e()) {
            return null;
        }
        return new TTImage(kVar.c(), kVar.b(), kVar.a(), kVar.d());
    }
}
