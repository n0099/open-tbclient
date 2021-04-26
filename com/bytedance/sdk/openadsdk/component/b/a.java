package com.bytedance.sdk.openadsdk.component.b;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f28199a;

    /* renamed from: b  reason: collision with root package name */
    public final q f28200b = p.f();

    public static a a() {
        if (f28199a == null) {
            synchronized (a.class) {
                if (f28199a == null) {
                    f28199a = new a();
                }
            }
        }
        return f28199a;
    }

    public void b(final Context context, final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        this.f28200b.a(adSlot, new m(), 6, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.b.a.2
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i2, String str) {
                feedAdListener.onError(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    List<l> c2 = aVar.c();
                    ArrayList arrayList = new ArrayList(c2.size());
                    for (l lVar : c2) {
                        if (lVar.aH()) {
                            arrayList.add(new c(context, lVar, 6, adSlot));
                        }
                        if (!l.a(lVar) && l.c(lVar) && lVar.X() != null && lVar.X().i() != null) {
                            if (p.h().a(String.valueOf(ak.d(lVar.ap()))) && p.h().L()) {
                                com.bytedance.sdk.openadsdk.core.video.e.c.a(new com.bytedance.sdk.openadsdk.k.f.b().a(lVar.X().i()).a(204800).b(lVar.X().l()));
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        d.a(context, c2.get(0), ak.b(adSlot.getDurationSlotType()), currentTimeMillis);
                        feedAdListener.onFeedAdLoad(arrayList);
                        return;
                    }
                    feedAdListener.onError(-4, h.a(-4));
                    return;
                }
                feedAdListener.onError(-3, h.a(-3));
            }
        });
    }

    public void a(final Context context, final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        this.f28200b.a(adSlot, new m(), 5, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.b.a.1
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i2, String str) {
                feedAdListener.onError(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    List<l> c2 = aVar.c();
                    ArrayList arrayList = new ArrayList(c2.size());
                    for (l lVar : c2) {
                        if (lVar.aH()) {
                            arrayList.add(new c(context, lVar, 5, adSlot));
                        }
                        if (!l.a(lVar) && l.c(lVar) && lVar.X() != null && lVar.X().i() != null) {
                            if (p.h().a(String.valueOf(ak.d(lVar.ap()))) && p.h().L()) {
                                com.bytedance.sdk.openadsdk.core.video.e.c.a(new com.bytedance.sdk.openadsdk.k.f.b().a(lVar.X().i()).a(204800).b(lVar.X().l()));
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        d.a(context, c2.get(0), ak.b(adSlot.getDurationSlotType()), currentTimeMillis);
                        feedAdListener.onFeedAdLoad(arrayList);
                        return;
                    }
                    feedAdListener.onError(-4, h.a(-4));
                    return;
                }
                feedAdListener.onError(-3, h.a(-3));
            }
        });
    }

    public void a(final Context context, final AdSlot adSlot, final TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        this.f28200b.a(adSlot, new m(), 9, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.b.a.3
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i2, String str) {
                drawFeedAdListener.onError(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    List<l> c2 = aVar.c();
                    ArrayList arrayList = new ArrayList(c2.size());
                    for (l lVar : c2) {
                        if (lVar.aH()) {
                            arrayList.add(new b(context, lVar, 9, adSlot));
                        }
                        if (l.c(lVar) && lVar.X() != null && lVar.X().i() != null) {
                            if (p.h().a(String.valueOf(ak.d(lVar.ap()))) && p.h().L()) {
                                com.bytedance.sdk.openadsdk.core.video.e.c.a(new com.bytedance.sdk.openadsdk.k.f.b().a(lVar.X().i()).a(512000).b(lVar.X().l()));
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        d.a(context, c2.get(0), ak.b(adSlot.getDurationSlotType()), currentTimeMillis);
                        drawFeedAdListener.onDrawFeedAdLoad(arrayList);
                        return;
                    }
                    drawFeedAdListener.onError(-4, h.a(-4));
                    return;
                }
                drawFeedAdListener.onError(-3, h.a(-3));
            }
        });
    }
}
