package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f25263a;

    /* renamed from: b  reason: collision with root package name */
    public String f25264b;

    public String a() {
        if (TextUtils.isEmpty(this.f25263a)) {
            return this.f25263a;
        }
        return this.f25263a;
    }

    public String b() {
        return this.f25264b;
    }

    public String toString() {
        return "CardInfoDisplayModel [content=" + this.f25263a + ", flag=" + this.f25264b + "]";
    }

    public void b(String str) {
        this.f25264b = str;
    }

    public void a(String str) {
        this.f25263a = str;
    }
}
