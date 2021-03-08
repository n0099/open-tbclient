package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f4033a;
    private final String b;

    public a(String str, String str2) {
        this.f4033a = str;
        this.b = str2;
    }

    public final String getName() {
        return this.f4033a;
    }

    public final String getValue() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f4033a, aVar.f4033a) && TextUtils.equals(this.b, aVar.b);
    }

    public int hashCode() {
        return (this.f4033a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f4033a + ",value=" + this.b + "]";
    }
}
