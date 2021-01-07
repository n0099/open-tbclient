package com.bytedance.sdk.openadsdk.d.b.a;

import com.bytedance.sdk.openadsdk.d.t;
import com.bytedance.sdk.openadsdk.d.v;
import com.bytedance.sdk.openadsdk.d.w;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
/* loaded from: classes4.dex */
public final class c extends v<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final w f7174a = new w() { // from class: com.bytedance.sdk.openadsdk.d.b.a.c.1
        @Override // com.bytedance.sdk.openadsdk.d.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new c();
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final List<DateFormat> f7175b = new ArrayList();

    public c() {
        this.f7175b.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f7175b.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.bytedance.sdk.openadsdk.d.b.e.b()) {
            this.f7175b.add(com.bytedance.sdk.openadsdk.d.b.j.a(2, 2));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.d.v
    /* renamed from: a */
    public Date b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
        if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
            aVar.j();
            return null;
        }
        return a(aVar.h());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
        r0 = com.bytedance.sdk.openadsdk.d.b.a.a.a.a(r3, new java.text.ParsePosition(0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized Date a(String str) {
        Date a2;
        Iterator<DateFormat> it = this.f7175b.iterator();
        while (true) {
            if (it.hasNext()) {
                try {
                    a2 = it.next().parse(str);
                    break;
                } catch (ParseException e) {
                }
            } else {
                try {
                    break;
                } catch (ParseException e2) {
                    throw new t(str, e2);
                }
            }
        }
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.d.v
    public synchronized void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.f();
        } else {
            cVar.b(this.f7175b.get(0).format(date));
        }
    }
}
