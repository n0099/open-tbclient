package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f6017a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6018b;

    public a(String str, String str2) {
        this.f6017a = str;
        this.f6018b = str2;
    }

    public final String getName() {
        return this.f6017a;
    }

    public final String getValue() {
        return this.f6018b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f6017a, aVar.f6017a) && TextUtils.equals(this.f6018b, aVar.f6018b);
    }

    public int hashCode() {
        return (this.f6017a.hashCode() * 31) + this.f6018b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f6017a + ",value=" + this.f6018b + "]";
    }
}
