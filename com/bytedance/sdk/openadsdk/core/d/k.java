package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f27889a;

    /* renamed from: b  reason: collision with root package name */
    public int f27890b;

    /* renamed from: c  reason: collision with root package name */
    public int f27891c;

    /* renamed from: d  reason: collision with root package name */
    public double f27892d;

    public String a() {
        return this.f27889a;
    }

    public int b() {
        return this.f27890b;
    }

    public int c() {
        return this.f27891c;
    }

    public double d() {
        return this.f27892d;
    }

    public boolean e() {
        return !TextUtils.isEmpty(this.f27889a) && this.f27890b > 0 && this.f27891c > 0;
    }

    public void a(String str) {
        this.f27889a = str;
    }

    public void b(int i2) {
        this.f27891c = i2;
    }

    public void a(int i2) {
        this.f27890b = i2;
    }

    public void a(double d2) {
        this.f27892d = d2;
    }

    public static TTImage a(k kVar) {
        if (kVar == null || !kVar.e()) {
            return null;
        }
        return new TTImage(kVar.c(), kVar.b(), kVar.a(), kVar.d());
    }
}
