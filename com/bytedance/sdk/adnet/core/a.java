package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f6315a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6316b;

    public a(String str, String str2) {
        this.f6315a = str;
        this.f6316b = str2;
    }

    public final String getName() {
        return this.f6315a;
    }

    public final String getValue() {
        return this.f6316b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f6315a, aVar.f6315a) && TextUtils.equals(this.f6316b, aVar.f6316b);
    }

    public int hashCode() {
        return (this.f6315a.hashCode() * 31) + this.f6316b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f6315a + ",value=" + this.f6316b + "]";
    }
}
