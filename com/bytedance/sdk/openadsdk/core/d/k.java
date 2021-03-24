package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f28173a;

    /* renamed from: b  reason: collision with root package name */
    public int f28174b;

    /* renamed from: c  reason: collision with root package name */
    public int f28175c;

    /* renamed from: d  reason: collision with root package name */
    public double f28176d;

    public String a() {
        return this.f28173a;
    }

    public int b() {
        return this.f28174b;
    }

    public int c() {
        return this.f28175c;
    }

    public double d() {
        return this.f28176d;
    }

    public boolean e() {
        return !TextUtils.isEmpty(this.f28173a) && this.f28174b > 0 && this.f28175c > 0;
    }

    public void a(String str) {
        this.f28173a = str;
    }

    public void b(int i) {
        this.f28175c = i;
    }

    public void a(int i) {
        this.f28174b = i;
    }

    public void a(double d2) {
        this.f28176d = d2;
    }

    public static TTImage a(k kVar) {
        if (kVar == null || !kVar.e()) {
            return null;
        }
        return new TTImage(kVar.c(), kVar.b(), kVar.a(), kVar.d());
    }
}
