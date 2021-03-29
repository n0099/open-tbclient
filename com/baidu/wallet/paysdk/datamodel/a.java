package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f25578a;

    /* renamed from: b  reason: collision with root package name */
    public String f25579b;

    public String a() {
        if (TextUtils.isEmpty(this.f25578a)) {
            return this.f25578a;
        }
        return this.f25578a;
    }

    public String b() {
        return this.f25579b;
    }

    public String toString() {
        return "CardInfoDisplayModel [content=" + this.f25578a + ", flag=" + this.f25579b + "]";
    }

    public void b(String str) {
        this.f25579b = str;
    }

    public void a(String str) {
        this.f25578a = str;
    }
}
