package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f28074a;

    /* renamed from: b  reason: collision with root package name */
    public int f28075b;

    /* renamed from: c  reason: collision with root package name */
    public int f28076c;

    /* renamed from: d  reason: collision with root package name */
    public double f28077d;

    public String a() {
        return this.f28074a;
    }

    public int b() {
        return this.f28075b;
    }

    public int c() {
        return this.f28076c;
    }

    public double d() {
        return this.f28077d;
    }

    public boolean e() {
        return !TextUtils.isEmpty(this.f28074a) && this.f28075b > 0 && this.f28076c > 0;
    }

    public void a(String str) {
        this.f28074a = str;
    }

    public void b(int i2) {
        this.f28076c = i2;
    }

    public void a(int i2) {
        this.f28075b = i2;
    }

    public void a(double d2) {
        this.f28077d = d2;
    }

    public static TTImage a(k kVar) {
        if (kVar == null || !kVar.e()) {
            return null;
        }
        return new TTImage(kVar.c(), kVar.b(), kVar.a(), kVar.d());
    }
}
