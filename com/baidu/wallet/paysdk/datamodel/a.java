package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f25287a;

    /* renamed from: b  reason: collision with root package name */
    public String f25288b;

    public String a() {
        if (TextUtils.isEmpty(this.f25287a)) {
            return this.f25287a;
        }
        return this.f25287a;
    }

    public String b() {
        return this.f25288b;
    }

    public String toString() {
        return "CardInfoDisplayModel [content=" + this.f25287a + ", flag=" + this.f25288b + "]";
    }

    public void b(String str) {
        this.f25288b = str;
    }

    public void a(String str) {
        this.f25287a = str;
    }
}
