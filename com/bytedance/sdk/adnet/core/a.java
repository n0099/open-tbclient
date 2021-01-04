package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f6314a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6315b;

    public a(String str, String str2) {
        this.f6314a = str;
        this.f6315b = str2;
    }

    public final String getName() {
        return this.f6314a;
    }

    public final String getValue() {
        return this.f6315b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f6314a, aVar.f6314a) && TextUtils.equals(this.f6315b, aVar.f6315b);
    }

    public int hashCode() {
        return (this.f6314a.hashCode() * 31) + this.f6315b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f6314a + ",value=" + this.f6315b + "]";
    }
}
