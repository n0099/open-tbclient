package com.bytedance.sdk.openadsdk.d;

import java.math.BigInteger;
/* loaded from: classes4.dex */
public final class q extends l {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7300a;

    public q(Boolean bool) {
        this.f7300a = com.bytedance.sdk.openadsdk.d.b.a.a(bool);
    }

    public q(Number number) {
        this.f7300a = com.bytedance.sdk.openadsdk.d.b.a.a(number);
    }

    public q(String str) {
        this.f7300a = com.bytedance.sdk.openadsdk.d.b.a.a(str);
    }

    public boolean n() {
        return this.f7300a instanceof Boolean;
    }

    @Override // com.bytedance.sdk.openadsdk.d.l
    public boolean f() {
        return n() ? ((Boolean) this.f7300a).booleanValue() : Boolean.parseBoolean(b());
    }

    public boolean o() {
        return this.f7300a instanceof Number;
    }

    @Override // com.bytedance.sdk.openadsdk.d.l
    public Number a() {
        return this.f7300a instanceof String ? new com.bytedance.sdk.openadsdk.d.b.g((String) this.f7300a) : (Number) this.f7300a;
    }

    public boolean p() {
        return this.f7300a instanceof String;
    }

    @Override // com.bytedance.sdk.openadsdk.d.l
    public String b() {
        if (o()) {
            return a().toString();
        }
        if (n()) {
            return ((Boolean) this.f7300a).toString();
        }
        return (String) this.f7300a;
    }

    @Override // com.bytedance.sdk.openadsdk.d.l
    public double c() {
        return o() ? a().doubleValue() : Double.parseDouble(b());
    }

    @Override // com.bytedance.sdk.openadsdk.d.l
    public long d() {
        return o() ? a().longValue() : Long.parseLong(b());
    }

    @Override // com.bytedance.sdk.openadsdk.d.l
    public int e() {
        return o() ? a().intValue() : Integer.parseInt(b());
    }

    public int hashCode() {
        if (this.f7300a == null) {
            return 31;
        }
        if (a(this)) {
            long longValue = a().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (this.f7300a instanceof Number) {
            long doubleToLongBits = Double.doubleToLongBits(a().doubleValue());
            return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        } else {
            return this.f7300a.hashCode();
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f7300a == null) {
            return qVar.f7300a == null;
        } else if (a(this) && a(qVar)) {
            return a().longValue() == qVar.a().longValue();
        } else if ((this.f7300a instanceof Number) && (qVar.f7300a instanceof Number)) {
            double doubleValue = a().doubleValue();
            double doubleValue2 = qVar.a().doubleValue();
            if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                z = true;
            }
            return z;
        } else {
            return this.f7300a.equals(qVar.f7300a);
        }
    }

    private static boolean a(q qVar) {
        if (qVar.f7300a instanceof Number) {
            Number number = (Number) qVar.f7300a;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }
}
