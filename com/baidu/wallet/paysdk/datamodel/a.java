package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f25319a;

    /* renamed from: b  reason: collision with root package name */
    public String f25320b;

    public String a() {
        if (TextUtils.isEmpty(this.f25319a)) {
            return this.f25319a;
        }
        return this.f25319a;
    }

    public String b() {
        return this.f25320b;
    }

    public String toString() {
        return "CardInfoDisplayModel [content=" + this.f25319a + ", flag=" + this.f25320b + "]";
    }

    public void b(String str) {
        this.f25320b = str;
    }

    public void a(String str) {
        this.f25319a = str;
    }
}
