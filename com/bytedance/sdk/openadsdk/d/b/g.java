package com.bytedance.sdk.openadsdk.d.b;

import java.math.BigDecimal;
/* loaded from: classes4.dex */
public final class g extends Number {

    /* renamed from: a  reason: collision with root package name */
    private final String f7258a;

    public g(String str) {
        this.f7258a = str;
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            return Integer.parseInt(this.f7258a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f7258a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.f7258a).intValue();
            }
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f7258a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.f7258a).longValue();
        }
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f7258a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f7258a);
    }

    public String toString() {
        return this.f7258a;
    }

    public int hashCode() {
        return this.f7258a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f7258a == gVar.f7258a || this.f7258a.equals(gVar.f7258a);
        }
        return false;
    }
}
