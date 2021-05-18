package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f27960a;

    /* renamed from: b  reason: collision with root package name */
    public int f27961b;

    /* renamed from: c  reason: collision with root package name */
    public int f27962c;

    /* renamed from: d  reason: collision with root package name */
    public double f27963d;

    public String a() {
        return this.f27960a;
    }

    public int b() {
        return this.f27961b;
    }

    public int c() {
        return this.f27962c;
    }

    public double d() {
        return this.f27963d;
    }

    public boolean e() {
        return !TextUtils.isEmpty(this.f27960a) && this.f27961b > 0 && this.f27962c > 0;
    }

    public void a(String str) {
        this.f27960a = str;
    }

    public void b(int i2) {
        this.f27962c = i2;
    }

    public void a(int i2) {
        this.f27961b = i2;
    }

    public void a(double d2) {
        this.f27963d = d2;
    }

    public static TTImage a(k kVar) {
        if (kVar == null || !kVar.e()) {
            return null;
        }
        return new TTImage(kVar.c(), kVar.b(), kVar.a(), kVar.d());
    }
}
