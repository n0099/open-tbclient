package com.bytedance.sdk.openadsdk.component.interaction;

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
    private final q f6285a = p.f();

    public static a a() {
        return new a();
    }

    private a() {
    }

    public void a(final Context context, AdSlot adSlot, final TTAdNative.InteractionAdListener interactionAdListener) {
        this.f6285a.a(adSlot, (m) null, 2, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.interaction.a.1
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                interactionAdListener.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    l lVar = aVar.c().get(0);
                    if (lVar.ai()) {
                        final b bVar = new b(context, lVar);
                        bVar.a(new com.bytedance.sdk.openadsdk.core.l() { // from class: com.bytedance.sdk.openadsdk.component.interaction.a.1.1
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
