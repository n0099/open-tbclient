package com.bytedance.sdk.openadsdk.d.b.a;

import com.bytedance.sdk.openadsdk.d.t;
import com.bytedance.sdk.openadsdk.d.v;
import com.bytedance.sdk.openadsdk.d.w;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes6.dex */
public final class k extends v<Time> {

    /* renamed from: a  reason: collision with root package name */
    public static final w f6897a = new w() { // from class: com.bytedance.sdk.openadsdk.d.b.a.k.1
        @Override // com.bytedance.sdk.openadsdk.d.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
            if (aVar.a() == Time.class) {
                return new k();
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f6898b = new SimpleDateFormat("hh:mm:ss a");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.d.v
    /* renamed from: a */
    public synchronized Time b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
        Time time;
        if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
            aVar.j();
            time = null;
        } else {
            try {
                time = new Time(this.f6898b.parse(aVar.h()).getTime());
            } catch (ParseException e) {
                throw new t(e);
            }
        }
        return time;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.d.v
    public synchronized void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Time time) throws IOException {
        cVar.b(time == null ? null : this.f6898b.format((Date) time));
    }
}
