package com.bytedance.sdk.openadsdk.component.reward;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.reward.a;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.g.a;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class c {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f4268a;
    private Context b;
    private AtomicBoolean d = new AtomicBoolean(false);
    private List<a> e = Collections.synchronizedList(new ArrayList());
    private final BroadcastReceiver f = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && x.c(c.this.b) != 0) {
                Iterator it = c.this.e.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.openadsdk.j.e.a((Runnable) it.next(), 1);
                    it.remove();
                }
            }
        }
    };
    private final q c = p.f();

    public static c a(Context context) {
        if (f4268a == null) {
            synchronized (c.class) {
                if (f4268a == null) {
                    f4268a = new c(context);
                }
            }
        }
        return f4268a;
    }

    private c(Context context) {
        this.b = context == null ? p.a() : context.getApplicationContext();
        c();
    }

    public void a() {
        try {
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).a();
        } catch (Throwable th) {
        }
    }

    public void b() {
        AdSlot b = com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).b();
        if (b != null && !TextUtils.isEmpty(b.getCodeId()) && com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).c(b.getCodeId()) == null) {
            b(b);
        }
    }

    public void a(AdSlot adSlot) {
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).b(adSlot);
    }

    public void a(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        u.b("FullScreenVideoLoadManager", "load full screen video: " + String.valueOf(adSlot));
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).a(adSlot);
        a(adSlot, false, fullScreenVideoAdListener);
    }

    public void b(AdSlot adSlot) {
        u.b("FullScreenVideoLoadManager", "preload full screen video: " + String.valueOf(adSlot));
        a(adSlot, true, null);
    }

    private void a(AdSlot adSlot, boolean z, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        if (z) {
            if (adSlot.getExtraSmartLookParam() != null) {
                u.b("TTMediationSDK", "全屏视频不走预加载 smartLook参数不为null时.....");
                return;
            } else {
                b(adSlot, true, fullScreenVideoAdListener);
                return;
            }
        }
        final l c = com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).c(adSlot.getCodeId());
        if (c != null && adSlot.getExtraSmartLookParam() == null) {
            i iVar = new i(this.b, c, adSlot);
            if (!c.D()) {
                iVar.a(com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).a(c));
            }
            com.bytedance.sdk.openadsdk.c.d.a(c);
            if (fullScreenVideoAdListener != null) {
                fullScreenVideoAdListener.onFullScreenVideoAdLoad(iVar);
                if (!c.D()) {
                    fullScreenVideoAdListener.onFullScreenVideoCached();
                }
            }
            com.bytedance.sdk.openadsdk.core.g.a.a().a(c, new a.InterfaceC1020a() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.1
                @Override // com.bytedance.sdk.openadsdk.core.g.a.InterfaceC1020a
                public void a(boolean z2) {
                    if (fullScreenVideoAdListener != null && c.D()) {
                        fullScreenVideoAdListener.onFullScreenVideoCached();
                    }
                }
            });
            u.b("FullScreenVideoLoadManager", "get cache data success");
            return;
        }
        u.b("TTMediationSDK", "全屏视频从网络获取 smartLook参数不为null时.....");
        b(adSlot, false, fullScreenVideoAdListener);
    }

    private void b(final AdSlot adSlot, final boolean z, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        m mVar = new m();
        mVar.c = z ? 2 : 1;
        if (p.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
            mVar.e = 2;
        }
        this.c.a(adSlot, mVar, 8, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                if (!z && fullScreenVideoAdListener != null) {
                    fullScreenVideoAdListener.onError(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    u.b("FullScreenVideoLoadManager", "get material data success isPreload=" + z);
                    final l lVar = aVar.c().get(0);
                    try {
                        if (lVar.U() != null && !TextUtils.isEmpty(lVar.U().a())) {
                            String a2 = lVar.U().a();
                            com.bytedance.sdk.openadsdk.h.b bVar = new com.bytedance.sdk.openadsdk.h.b(true);
                            bVar.a(adSlot.getCodeId());
                            bVar.a(8);
                            bVar.c(lVar.ag());
                            bVar.d(lVar.aj());
                            bVar.b(aj.h(lVar.aj()));
                            com.bytedance.sdk.openadsdk.h.d.a(c.this.b).g().a(a2, bVar);
                        }
                    } catch (Throwable th) {
                    }
                    final i iVar = new i(c.this.b, lVar, adSlot);
                    if (!z && fullScreenVideoAdListener != null) {
                        fullScreenVideoAdListener.onFullScreenVideoAdLoad(iVar);
                    }
                    com.bytedance.sdk.openadsdk.core.g.a.a().a(lVar, new a.InterfaceC1020a() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2.1
                        @Override // com.bytedance.sdk.openadsdk.core.g.a.InterfaceC1020a
                        public void a(boolean z2) {
                            if (!z && fullScreenVideoAdListener != null && lVar != null && lVar.D()) {
                                fullScreenVideoAdListener.onFullScreenVideoCached();
                            }
                        }
                    });
                    if (lVar.aA()) {
                        if (z && !lVar.D() && p.h().r(adSlot.getCodeId()).d == 1) {
                            if (!x.d(c.this.b)) {
                                c.this.a(new a(lVar, adSlot));
                            }
                        } else if (!lVar.D()) {
                            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.b).a(lVar, new a.InterfaceC1012a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2.2
                                @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC1012a
                                public void a(boolean z2, Object obj) {
                                    u.b("FullScreenVideoLoadManager", "download video file: " + z2 + ", preload: " + z);
                                    if (z2) {
                                        iVar.a(com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.b).a(lVar));
                                    }
                                    if (!z) {
                                        com.bytedance.sdk.openadsdk.c.d.a(lVar);
                                        if (z2 && fullScreenVideoAdListener != null) {
                                            fullScreenVideoAdListener.onFullScreenVideoCached();
                                        }
                                    } else if (z2) {
                                        com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.b).a(adSlot, lVar);
                                    }
                                }
                            });
                        } else {
                            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.b).a(adSlot, lVar);
                        }
                    } else if (!z && fullScreenVideoAdListener != null) {
                        fullScreenVideoAdListener.onError(-4, com.bytedance.sdk.openadsdk.core.h.a(-4));
                    }
                } else if (!z && fullScreenVideoAdListener != null) {
                    fullScreenVideoAdListener.onError(-3, com.bytedance.sdk.openadsdk.core.h.a(-3));
                }
            }
        });
    }

    public void a(String str) {
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).a(str);
    }

    @Nullable
    public AdSlot b(String str) {
        return com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null) {
            if (this.e.size() >= 1) {
                this.e.remove(0);
            }
            this.e.add(aVar);
        }
    }

    private void c() {
        if (!this.d.get()) {
            this.d.set(true);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                this.b.registerReceiver(this.f, intentFilter);
            } catch (Exception e) {
            }
        }
    }

    private void d() {
        if (this.d.get()) {
            this.d.set(false);
            try {
                this.b.unregisterReceiver(this.f);
            } catch (Exception e) {
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        l f4274a;
        AdSlot b;

        a(l lVar, AdSlot adSlot) {
            this.f4274a = lVar;
            this.b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.b).a(this.f4274a, new a.InterfaceC1012a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.a.1
                @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC1012a
                public void a(boolean z, Object obj) {
                    if (z) {
                        com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.b).a(a.this.b, a.this.f4274a);
                    }
                }
            });
        }
    }
}
