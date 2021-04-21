package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f25271a;

    /* renamed from: b  reason: collision with root package name */
    public String f25272b;

    public String a() {
        if (TextUtils.isEmpty(this.f25271a)) {
            return this.f25271a;
        }
        return this.f25271a;
    }

    public String b() {
        return this.f25272b;
    }

    public String toString() {
        return "CardInfoDisplayModel [content=" + this.f25271a + ", flag=" + this.f25272b + "]";
    }

    public void b(String str) {
        this.f25272b = str;
    }

    public void a(String str) {
        this.f25271a = str;
    }
}
