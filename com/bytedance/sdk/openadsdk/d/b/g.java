package com.bytedance.sdk.openadsdk.d.b;

import java.math.BigDecimal;
/* loaded from: classes4.dex */
public final class g extends Number {

    /* renamed from: a  reason: collision with root package name */
    private final String f6959a;

    public g(String str) {
        this.f6959a = str;
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            return Integer.parseInt(this.f6959a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f6959a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.f6959a).intValue();
            }
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f6959a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.f6959a).longValue();
        }
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f6959a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f6959a);
    }

    public String toString() {
        return this.f6959a;
    }

    public int hashCode() {
        return this.f6959a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f6959a == gVar.f6959a || this.f6959a.equals(gVar.f6959a);
        }
        return false;
    }
}
