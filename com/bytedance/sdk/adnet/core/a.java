package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f6015a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6016b;

    public a(String str, String str2) {
        this.f6015a = str;
        this.f6016b = str2;
    }

    public final String getName() {
        return this.f6015a;
    }

    public final String getValue() {
        return this.f6016b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f6015a, aVar.f6015a) && TextUtils.equals(this.f6016b, aVar.f6016b);
    }

    public int hashCode() {
        return (this.f6015a.hashCode() * 31) + this.f6016b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f6015a + ",value=" + this.f6016b + "]";
    }
}
