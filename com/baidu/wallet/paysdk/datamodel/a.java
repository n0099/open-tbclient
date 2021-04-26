package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f26042a;

    /* renamed from: b  reason: collision with root package name */
    public String f26043b;

    public String a() {
        if (TextUtils.isEmpty(this.f26042a)) {
            return this.f26042a;
        }
        return this.f26042a;
    }

    public String b() {
        return this.f26043b;
    }

    public String toString() {
        return "CardInfoDisplayModel [content=" + this.f26042a + ", flag=" + this.f26043b + "]";
    }

    public void b(String str) {
        this.f26043b = str;
    }

    public void a(String str) {
        this.f26042a = str;
    }
}
