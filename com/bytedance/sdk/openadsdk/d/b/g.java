package com.bytedance.sdk.openadsdk.d.b;

import java.math.BigDecimal;
/* loaded from: classes4.dex */
public final class g extends Number {

    /* renamed from: a  reason: collision with root package name */
    private final String f7259a;

    public g(String str) {
        this.f7259a = str;
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            return Integer.parseInt(this.f7259a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f7259a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.f7259a).intValue();
            }
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f7259a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.f7259a).longValue();
        }
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f7259a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f7259a);
    }

    public String toString() {
        return this.f7259a;
    }

    public int hashCode() {
        return this.f7259a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f7259a == gVar.f7259a || this.f7259a.equals(gVar.f7259a);
        }
        return false;
    }
}
