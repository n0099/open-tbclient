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
/* loaded from: classes4.dex */
public class c {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f6301a;

    /* renamed from: b  reason: collision with root package name */
    private Context f6302b;
    private AtomicBoolean d = new AtomicBoolean(false);
    private List<a> e = Collections.synchronizedList(new ArrayList());
    private final BroadcastReceiver f = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && x.c(c.this.f6302b) != 0) {
                Iterator it = c.this.e.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.openadsdk.k.a.a().c((Runnable) it.next(), 1);
                    it.remove();
                }
            }
        }
    };
    private final q c = p.f();

    public static c a(Context context) {
        if (f6301a == null) {
            synchronized (c.class) {
                if (f6301a == null) {
                    f6301a = new c(context);
                }
            }
        }
        return f6301a;
    }

    private c(Context context) {
        this.f6302b = context == null ? p.a() : context.getApplicationContext();
        c();
    }

    public void a() {
        try {
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.f6302b).a();
        } catch (Throwable th) {
        }
    }

    public void b() {
        AdSlot b2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f6302b).b();
        if (b2 != null && !TextUtils.isEmpty(b2.getCodeId()) && com.bytedance.sdk.openadsdk.component.reward.a.a(this.f6302b).c(b2.getCodeId()) == null) {
            b(b2);
        }
    }

    public void a(AdSlot adSlot) {
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.f6302b).b(adSlot);
    }

    public void a(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        u.b("FullScreenVideoLoadManager", "load full screen video: " + String.valueOf(adSlot));
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.f6302b).a(adSlot);
        a(adSlot, false, fullScreenVideoAdListener);
    }

    public void b(AdSlot adSlot) {
        u.b("FullScreenVideoLoadManager", "preload full screen video: " + String.valueOf(adSlot));
        a(adSlot, true, null);
    }

    private void a(AdSlot adSlot, boolean z, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        if (z) {
            b(adSlot, true, fullScreenVideoAdListener);
            return;
        }
        final l c = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f6302b).c(adSlot.getCodeId());
        if (c != null) {
            i iVar = new i(this.f6302b, c, adSlot);
            if (!c.t()) {
                iVar.a(com.bytedance.sdk.openadsdk.component.reward.a.a(this.f6302b).a(c));
            }
            com.bytedance.sdk.openadsdk.c.d.a(c);
            if (fullScreenVideoAdListener != null) {
                fullScreenVideoAdListener.onFullScreenVideoAdLoad(iVar);
                if (!c.t()) {
                    fullScreenVideoAdListener.onFullScreenVideoCached();
                }
            }
            com.bytedance.sdk.openadsdk.core.g.a.a().a(c, new a.InterfaceC1003a() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.1
                @Override // com.bytedance.sdk.openadsdk.core.g.a.InterfaceC1003a
                public void a(boolean z2) {
                    if (fullScreenVideoAdListener != null && c.t()) {
                        fullScreenVideoAdListener.onFullScreenVideoCached();
                    }
                }
            });
            u.b("FullScreenVideoLoadManager", "get cache data success");
            return;
        }
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
                        if (lVar.I() != null && !TextUtils.isEmpty(lVar.I().a())) {
                            String a2 = lVar.I().a();
                            com.bytedance.sdk.openadsdk.i.b bVar = new com.bytedance.sdk.openadsdk.i.b(true);
                            bVar.a(adSlot.getCodeId());
                            bVar.a(8);
                            bVar.c(lVar.T());
                            bVar.d(lVar.W());
                            bVar.b(aj.h(lVar.W()));
                            com.bytedance.sdk.openadsdk.i.e.a(c.this.f6302b).g().a(a2, bVar);
                        }
                    } catch (Throwable th) {
                    }
                    final i iVar = new i(c.this.f6302b, lVar, adSlot);
                    if (!z && fullScreenVideoAdListener != null) {
                        fullScreenVideoAdListener.onFullScreenVideoAdLoad(iVar);
                    }
                    com.bytedance.sdk.openadsdk.core.g.a.a().a(lVar, new a.InterfaceC1003a() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2.1
                        @Override // com.bytedance.sdk.openadsdk.core.g.a.InterfaceC1003a
                        public void a(boolean z2) {
                            if (!z && fullScreenVideoAdListener != null && lVar != null && lVar.t()) {
                                fullScreenVideoAdListener.onFullScreenVideoCached();
                            }
                        }
                    });
                    if (lVar.ai()) {
                        if (z && !lVar.t() && p.h().r(adSlot.getCodeId()).d == 1) {
                            if (!x.d(c.this.f6302b)) {
                                c.this.a(new a(lVar, adSlot));
                            }
                        } else if (!lVar.t()) {
                            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f6302b).a(lVar, new a.InterfaceC0997a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2.2
                                @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC0997a
                                public void a(boolean z2, Object obj) {
                                    u.b("FullScreenVideoLoadManager", "download video file: " + z2 + ", preload: " + z);
                                    if (z2) {
                                        iVar.a(com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f6302b).a(lVar));
                                    }
                                    if (!z) {
                                        com.bytedance.sdk.openadsdk.c.d.a(lVar);
                                        if (z2 && fullScreenVideoAdListener != null) {
                                            fullScreenVideoAdListener.onFullScreenVideoCached();
                                        }
                                    } else if (z2) {
                                        com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f6302b).a(adSlot, lVar);
                                    }
                                }
                            });
                        } else {
                            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f6302b).a(adSlot, lVar);
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
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.f6302b).a(str);
    }

    @Nullable
    public AdSlot b(String str) {
        return com.bytedance.sdk.openadsdk.component.reward.a.a(this.f6302b).b(str);
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
                this.f6302b.registerReceiver(this.f, intentFilter);
            } catch (Exception e) {
            }
        }
    }

    private void d() {
        if (this.d.get()) {
            this.d.set(false);
            try {
                this.f6302b.unregisterReceiver(this.f);
            } catch (Exception e) {
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        l f6312a;

        /* renamed from: b  reason: collision with root package name */
        AdSlot f6313b;

        a(l lVar, AdSlot adSlot) {
            this.f6312a = lVar;
            this.f6313b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f6302b).a(this.f6312a, new a.InterfaceC0997a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.a.1
                @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC0997a
                public void a(boolean z, Object obj) {
                    if (z) {
                        com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f6302b).a(a.this.f6313b, a.this.f6312a);
                    }
                }
            });
        }
    }
}
