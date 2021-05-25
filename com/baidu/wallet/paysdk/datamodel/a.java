package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f25216a;

    /* renamed from: b  reason: collision with root package name */
    public String f25217b;

    public String a() {
        if (TextUtils.isEmpty(this.f25216a)) {
            return this.f25216a;
        }
        return this.f25216a;
    }

    public String b() {
        return this.f25217b;
    }

    public String toString() {
        return "CardInfoDisplayModel [content=" + this.f25216a + ", flag=" + this.f25217b + "]";
    }

    public void b(String str) {
        this.f25217b = str;
    }

    public void a(String str) {
        this.f25216a = str;
    }
}
