package com.bytedance.sdk.openadsdk.component.banner;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f6263a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Context> f6264b;
    private final q c = p.f();

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(@NonNull com.bytedance.sdk.openadsdk.component.banner.a aVar);
    }

    private b(Context context) {
        this.f6264b = new WeakReference<>(context);
    }

    private void b(Context context) {
        this.f6264b = new WeakReference<>(context);
    }

    public static b a(@NonNull Context context) {
        if (f6263a == null) {
            synchronized (b.class) {
                if (f6263a == null) {
                    f6263a = new b(context);
                }
            }
        } else {
            f6263a.b(context);
        }
        return f6263a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull AdSlot adSlot, final a aVar) {
        this.c.a(adSlot, (m) null, 1, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.banner.b.1
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                u.b("BannerAdManager", str + "  " + i);
                if (aVar != null) {
                    aVar.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar2) {
                if (aVar2.c() != null && !aVar2.c().isEmpty()) {
                    l lVar = aVar2.c().get(0);
                    if (lVar.ai()) {
                        b.this.a(lVar, aVar);
                        return;
                    }
                    u.b("BannerAdManager", "Banner广告解析失败/广告为空");
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            }
        });
    }

    public void a(@NonNull final AdSlot adSlot, @NonNull final TTAdNative.BannerAdListener bannerAdListener) {
        this.c.a(adSlot, (m) null, 1, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.banner.b.2
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                bannerAdListener.onError(i, str);
                u.b("BannerAdManager", str + " " + i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    l lVar = aVar.c().get(0);
                    if (lVar.ai()) {
                        b.this.a(lVar, new a() { // from class: com.bytedance.sdk.openadsdk.component.banner.b.2.1
                            @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
                            public void a(@NonNull com.bytedance.sdk.openadsdk.component.banner.a aVar2) {
                                if (b.this.f6264b.get() != null) {
                                    bannerAdListener.onBannerAdLoad(new e((Context) b.this.f6264b.get(), aVar2, adSlot));
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
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

    private Context a() {
        return (this.f6264b == null || this.f6264b.get() == null) ? p.a() : this.f6264b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull final l lVar, @Nullable final a aVar) {
        com.bytedance.sdk.openadsdk.i.e.a(a()).g().a(lVar.M().get(0).a(), new d.InterfaceC0997d() { // from class: com.bytedance.sdk.openadsdk.component.banner.b.3
            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0997d
            public void a() {
            }

            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0997d
            public void a(d.c cVar, boolean z) {
                if (cVar != null && cVar.a() != null) {
                    if (aVar != null) {
                        aVar.a(new com.bytedance.sdk.openadsdk.component.banner.a(cVar.a(), lVar));
                    }
                } else if (aVar != null) {
                    aVar.a();
                }
            }

            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0997d
            public void b() {
            }

            @Override // com.bytedance.sdk.adnet.core.p.a
            public void a(com.bytedance.sdk.adnet.core.p<Bitmap> pVar) {
            }

            @Override // com.bytedance.sdk.adnet.core.p.a
            public void b(com.bytedance.sdk.adnet.core.p<Bitmap> pVar) {
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
    }
}
