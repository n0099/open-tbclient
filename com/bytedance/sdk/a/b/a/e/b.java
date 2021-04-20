package com.bytedance.sdk.a.b.a.e;
/* loaded from: classes5.dex */
public enum b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    

    /* renamed from: g  reason: collision with root package name */
    public final int f26862g;

    b(int i) {
        this.f26862g = i;
    }

    public static b a(int i) {
        b[] values;
        for (b bVar : values()) {
            if (bVar.f26862g == i) {
                return bVar;
            }
        }
        return null;
    }
}
