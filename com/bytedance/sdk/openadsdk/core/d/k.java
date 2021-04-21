package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f27867a;

    /* renamed from: b  reason: collision with root package name */
    public int f27868b;

    /* renamed from: c  reason: collision with root package name */
    public int f27869c;

    /* renamed from: d  reason: collision with root package name */
    public double f27870d;

    public String a() {
        return this.f27867a;
    }

    public int b() {
        return this.f27868b;
    }

    public int c() {
        return this.f27869c;
    }

    public double d() {
        return this.f27870d;
    }

    public boolean e() {
        return !TextUtils.isEmpty(this.f27867a) && this.f27868b > 0 && this.f27869c > 0;
    }

    public void a(String str) {
        this.f27867a = str;
    }

    public void b(int i) {
        this.f27869c = i;
    }

    public void a(int i) {
        this.f27868b = i;
    }

    public void a(double d2) {
        this.f27870d = d2;
    }

    public static TTImage a(k kVar) {
        if (kVar == null || !kVar.e()) {
            return null;
        }
        return new TTImage(kVar.c(), kVar.b(), kVar.a(), kVar.d());
    }
}
