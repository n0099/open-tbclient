package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private String f6509a;

    /* renamed from: b  reason: collision with root package name */
    private int f6510b;
    private int c;

    public String a() {
        return this.f6509a;
    }

    public void a(String str) {
        this.f6509a = str;
    }

    public int b() {
        return this.f6510b;
    }

    public void a(int i) {
        this.f6510b = i;
    }

    public int c() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.f6509a) && this.f6510b > 0 && this.c > 0;
    }

    public static TTImage a(k kVar) {
        if (kVar == null || !kVar.d()) {
            return null;
        }
        return new TTImage(kVar.c(), kVar.b(), kVar.a());
    }
}
