package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.GlideException;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import d.c.c.b.b.d;
import d.c.c.b.d.o;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f27636a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Context> f27637b;

    /* renamed from: c  reason: collision with root package name */
    public final q f27638c = p.f();

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(@NonNull com.bytedance.sdk.openadsdk.component.a.a aVar);
    }

    public b(Context context) {
        this.f27637b = new WeakReference<>(context);
    }

    private void b(Context context) {
        this.f27637b = new WeakReference<>(context);
    }

    public static b a(@NonNull Context context) {
        if (f27636a == null) {
            synchronized (b.class) {
                if (f27636a == null) {
                    f27636a = new b(context);
                }
            }
        } else {
            f27636a.b(context);
        }
        return f27636a;
    }

    public void a(@NonNull AdSlot adSlot, final a aVar) {
        this.f27638c.a(adSlot, new m(), 1, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.a.b.1
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                u.b("BannerAdManager", str + GlideException.IndentedAppendable.INDENT + i);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar2) {
                if (aVar2.c() == null || aVar2.c().isEmpty()) {
                    return;
                }
                l lVar = aVar2.c().get(0);
                if (lVar.aH()) {
                    b.this.a(lVar, aVar);
                    return;
                }
                u.b("BannerAdManager", "Banner广告解析失败/广告为空");
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a();
                }
            }
        });
    }

    public void a(@NonNull final AdSlot adSlot, @NonNull final TTAdNative.BannerAdListener bannerAdListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        this.f27638c.a(adSlot, new m(), 1, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.a.b.2
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                bannerAdListener.onError(i, str);
                u.b("BannerAdManager", str + " " + i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    final l lVar = aVar.c().get(0);
                    if (lVar.aH()) {
                        b.this.a(lVar, new a() { // from class: com.bytedance.sdk.openadsdk.component.a.b.2.1
                            @Override // com.bytedance.sdk.openadsdk.component.a.b.a
                            public void a(@NonNull com.bytedance.sdk.openadsdk.component.a.a aVar2) {
                                if (b.this.f27637b.get() != null) {
                                    e eVar = new e((Context) b.this.f27637b.get(), aVar2, adSlot);
                                    com.bytedance.sdk.openadsdk.c.d.a((Context) b.this.f27637b.get(), lVar, ak.b(adSlot.getDurationSlotType()), currentTimeMillis);
                                    bannerAdListener.onBannerAdLoad(eVar);
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.component.a.b.a
                            public void a() {
                                bannerAdListener.onError(-5, h.a(-5));
                            }
                        });
                        return;
                    }
                    u.b("BannerAdManager", "Banner广告解析失败");
                    bannerAdListener.onError(-4, h.a(-4));
                    return;
                }
                u.b("BannerAdManager", "Banner广告解析失败/广告为空");
                bannerAdListener.onError(-4, h.a(-4));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull final l lVar, @Nullable final a aVar) {
        com.bytedance.sdk.openadsdk.i.e.c().h().f(lVar.af().get(0).a(), new com.bytedance.sdk.openadsdk.i.b() { // from class: com.bytedance.sdk.openadsdk.component.a.b.3
            @Override // com.bytedance.sdk.openadsdk.i.b, d.c.c.b.b.d.k
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.i.b, d.c.c.b.b.d.k
            public void a(d.i iVar, boolean z) {
                if (iVar != null && iVar.a() != null) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(new com.bytedance.sdk.openadsdk.component.a.a(iVar.a(), lVar));
                        return;
                    }
                    return;
                }
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.b, d.c.c.b.d.o.a
            public void a(o<Bitmap> oVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.i.b, d.c.c.b.b.d.k
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.i.b, d.c.c.b.d.o.a
            public void b(o<Bitmap> oVar) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        });
    }
}
