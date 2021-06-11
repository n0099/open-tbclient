package com.bytedance.sdk.openadsdk.component.c;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final q f27503a = p.f();

    public static a a() {
        return new a();
    }

    public void a(final Context context, AdSlot adSlot, final TTAdNative.InteractionAdListener interactionAdListener) {
        this.f27503a.a(adSlot, new m(), 2, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.c.a.1
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i2, String str) {
                interactionAdListener.onError(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    l lVar = aVar.c().get(0);
                    if (lVar.aH()) {
                        final b bVar = new b(context, lVar);
                        bVar.a(new com.bytedance.sdk.openadsdk.core.l() { // from class: com.bytedance.sdk.openadsdk.component.c.a.1.1
                            @Override // com.bytedance.sdk.openadsdk.core.l
                            public void a() {
                                interactionAdListener.onInteractionAdLoad(bVar);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.l
                            public void b() {
                                interactionAdListener.onError(-6, h.a(-6));
                            }
                        });
                        return;
                    }
                    interactionAdListener.onError(-4, h.a(-4));
                    return;
                }
                interactionAdListener.onError(-3, h.a(-3));
            }
        });
    }
}
