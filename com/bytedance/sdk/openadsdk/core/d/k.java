package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f27859a;

    /* renamed from: b  reason: collision with root package name */
    public int f27860b;

    /* renamed from: c  reason: collision with root package name */
    public int f27861c;

    /* renamed from: d  reason: collision with root package name */
    public double f27862d;

    public String a() {
        return this.f27859a;
    }

    public int b() {
        return this.f27860b;
    }

    public int c() {
        return this.f27861c;
    }

    public double d() {
        return this.f27862d;
    }

    public boolean e() {
        return !TextUtils.isEmpty(this.f27859a) && this.f27860b > 0 && this.f27861c > 0;
    }

    public void a(String str) {
        this.f27859a = str;
    }

    public void b(int i) {
        this.f27861c = i;
    }

    public void a(int i) {
        this.f27860b = i;
    }

    public void a(double d2) {
        this.f27862d = d2;
    }

    public static TTImage a(k kVar) {
        if (kVar == null || !kVar.e()) {
            return null;
        }
        return new TTImage(kVar.c(), kVar.b(), kVar.a(), kVar.d());
    }
}
