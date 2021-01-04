package com.bytedance.sdk.openadsdk.d.b.a;

import com.bytedance.sdk.openadsdk.d.t;
import com.bytedance.sdk.openadsdk.d.v;
import com.bytedance.sdk.openadsdk.d.w;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* loaded from: classes4.dex */
public final class j extends v<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final w f7192a = new w() { // from class: com.bytedance.sdk.openadsdk.d.b.a.j.1
        @Override // com.bytedance.sdk.openadsdk.d.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new j();
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f7193b = new SimpleDateFormat("MMM d, yyyy");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.d.v
    /* renamed from: a */
    public synchronized Date b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
        Date date;
        if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
            aVar.j();
            date = null;
        } else {
            try {
                date = new Date(this.f7193b.parse(aVar.h()).getTime());
            } catch (ParseException e) {
                throw new t(e);
            }
        }
        return date;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.d.v
    public synchronized void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Date date) throws IOException {
        cVar.b(date == null ? null : this.f7193b.format((java.util.Date) date));
    }
}
