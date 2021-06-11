package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f27992a;

    /* renamed from: b  reason: collision with root package name */
    public int f27993b;

    /* renamed from: c  reason: collision with root package name */
    public int f27994c;

    /* renamed from: d  reason: collision with root package name */
    public double f27995d;

    public String a() {
        return this.f27992a;
    }

    public int b() {
        return this.f27993b;
    }

    public int c() {
        return this.f27994c;
    }

    public double d() {
        return this.f27995d;
    }

    public boolean e() {
        return !TextUtils.isEmpty(this.f27992a) && this.f27993b > 0 && this.f27994c > 0;
    }

    public void a(String str) {
        this.f27992a = str;
    }

    public void b(int i2) {
        this.f27994c = i2;
    }

    public void a(int i2) {
        this.f27993b = i2;
    }

    public void a(double d2) {
        this.f27995d = d2;
    }

    public static TTImage a(k kVar) {
        if (kVar == null || !kVar.e()) {
            return null;
        }
        return new TTImage(kVar.c(), kVar.b(), kVar.a(), kVar.d());
    }
}
