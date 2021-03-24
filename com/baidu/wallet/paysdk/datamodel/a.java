package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f25577a;

    /* renamed from: b  reason: collision with root package name */
    public String f25578b;

    public String a() {
        if (TextUtils.isEmpty(this.f25577a)) {
            return this.f25577a;
        }
        return this.f25577a;
    }

    public String b() {
        return this.f25578b;
    }

    public String toString() {
        return "CardInfoDisplayModel [content=" + this.f25577a + ", flag=" + this.f25578b + "]";
    }

    public void b(String str) {
        this.f25578b = str;
    }

    public void a(String str) {
        this.f25577a = str;
    }
}
