package com.bytedance.sdk.openadsdk.d.b;

import java.math.BigDecimal;
/* loaded from: classes6.dex */
public final class g extends Number {

    /* renamed from: a  reason: collision with root package name */
    private final String f6961a;

    public g(String str) {
        this.f6961a = str;
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            return Integer.parseInt(this.f6961a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f6961a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.f6961a).intValue();
            }
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f6961a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.f6961a).longValue();
        }
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f6961a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f6961a);
    }

    public String toString() {
        return this.f6961a;
    }

    public int hashCode() {
        return this.f6961a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f6961a == gVar.f6961a || this.f6961a.equals(gVar.f6961a);
        }
        return false;
    }
}
