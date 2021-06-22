package com.bytedance.sdk.a.b.a.e;
/* loaded from: classes6.dex */
public enum b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    

    /* renamed from: g  reason: collision with root package name */
    public final int f27043g;

    b(int i2) {
        this.f27043g = i2;
    }

    public static b a(int i2) {
        b[] values;
        for (b bVar : values()) {
            if (bVar.f27043g == i2) {
                return bVar;
            }
        }
        return null;
    }
}
