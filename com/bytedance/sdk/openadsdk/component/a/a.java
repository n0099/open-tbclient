package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f6250a;

    /* renamed from: b  reason: collision with root package name */
    private final q f6251b = p.f();

    public static a a() {
        if (f6250a == null) {
            synchronized (a.class) {
                if (f6250a == null) {
                    f6250a = new a();
                }
            }
        }
        return f6250a;
    }

    private a() {
    }

    public void a(final Context context, final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
        this.f6251b.a(adSlot, (m) null, 5, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.a.a.1
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                feedAdListener.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    List<l> c = aVar.c();
                    ArrayList arrayList = new ArrayList(c.size());
                    for (l lVar : c) {
                        if (lVar.ai()) {
                            arrayList.add(new c(context, lVar, 5, adSlot));
                        }
                        if (lVar.X() == 5 && lVar.F() != null && lVar.F().h() != null) {
                            int d = aj.d(lVar.W());
                            if (p.h().a(String.valueOf(d)) && p.h().q(String.valueOf(d))) {
                                com.bytedance.sdk.openadsdk.j.f.a.a().a(new com.bytedance.sdk.openadsdk.j.f.b().a(lVar.F().h()).a(com.baidu.fsg.base.statistics.b.f1933b).b(lVar.F().k()));
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        feedAdListener.onFeedAdLoad(arrayList);
                        return;
                    } else {
                        feedAdListener.onError(-4, h.a(-4));
                        return;
                    }
                }
                feedAdListener.onError(-3, h.a(-3));
            }
        });
    }

    public void a(final Context context, AdSlot adSlot, final TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        this.f6251b.a(adSlot, (m) null, 9, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.a.a.2
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                drawFeedAdListener.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    List<l> c = aVar.c();
                    ArrayList arrayList = new ArrayList(c.size());
                    for (l lVar : c) {
                        if (lVar.ai()) {
                            arrayList.add(new b(context, lVar, 9));
                        }
                        if (lVar.X() == 5 || lVar.X() == 15) {
                            if (lVar.F() != null && lVar.F().h() != null) {
                                int d = aj.d(lVar.W());
                                if (p.h().a(String.valueOf(d)) && p.h().q(String.valueOf(d))) {
                                    com.bytedance.sdk.openadsdk.j.f.a.a().a(new com.bytedance.sdk.openadsdk.j.f.b().a(lVar.F().h()).a(IoUtils.DEFAULT_IMAGE_TOTAL_SIZE).b(lVar.F().k()));
                                }
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        drawFeedAdListener.onDrawFeedAdLoad(arrayList);
                        return;
                    } else {
                        drawFeedAdListener.onError(-4, h.a(-4));
                        return;
                    }
                }
                drawFeedAdListener.onError(-3, h.a(-3));
            }
        });
    }
}
