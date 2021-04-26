package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f28715a;

    /* renamed from: b  reason: collision with root package name */
    public int f28716b;

    /* renamed from: c  reason: collision with root package name */
    public int f28717c;

    /* renamed from: d  reason: collision with root package name */
    public double f28718d;

    public String a() {
        return this.f28715a;
    }

    public int b() {
        return this.f28716b;
    }

    public int c() {
        return this.f28717c;
    }

    public double d() {
        return this.f28718d;
    }

    public boolean e() {
        return !TextUtils.isEmpty(this.f28715a) && this.f28716b > 0 && this.f28717c > 0;
    }

    public void a(String str) {
        this.f28715a = str;
    }

    public void b(int i2) {
        this.f28717c = i2;
    }

    public void a(int i2) {
        this.f28716b = i2;
    }

    public void a(double d2) {
        this.f28718d = d2;
    }

    public static TTImage a(k kVar) {
        if (kVar == null || !kVar.e()) {
            return null;
        }
        return new TTImage(kVar.c(), kVar.b(), kVar.a(), kVar.d());
    }
}
