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
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class c {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f28257a;

    /* renamed from: b  reason: collision with root package name */
    public Context f28258b;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f28260d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public List<a> f28261e = Collections.synchronizedList(new ArrayList());

    /* renamed from: f  reason: collision with root package name */
    public final BroadcastReceiver f28262f = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || x.c(c.this.f28258b) == 0) {
                return;
            }
            Iterator it = c.this.f28261e.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.openadsdk.l.e.a((com.bytedance.sdk.openadsdk.l.g) it.next(), 1);
                it.remove();
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final q f28259c = p.f();

    /* loaded from: classes5.dex */
    public class a extends com.bytedance.sdk.openadsdk.l.g {

        /* renamed from: a  reason: collision with root package name */
        public l f28279a;

        /* renamed from: b  reason: collision with root package name */
        public AdSlot f28280b;

        public a(l lVar, AdSlot adSlot) {
            super("Fullscreen Task");
            this.f28279a = lVar;
            this.f28280b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f28258b).a(this.f28279a, new a.InterfaceC0297a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.a.1
                @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC0297a
                public void a(boolean z, Object obj) {
                    if (z) {
                        com.bytedance.sdk.openadsdk.component.reward.a a2 = com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f28258b);
                        a aVar = a.this;
                        a2.a(aVar.f28280b, aVar.f28279a);
                    }
                }
            });
        }
    }

    public c(Context context) {
        this.f28258b = context == null ? p.a() : context.getApplicationContext();
        c();
    }

    private void c() {
        if (this.f28260d.get()) {
            return;
        }
        this.f28260d.set(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.f28258b.registerReceiver(this.f28262f, intentFilter);
        } catch (Exception unused) {
        }
    }

    private void d() {
        if (this.f28260d.get()) {
            this.f28260d.set(false);
            try {
                this.f28258b.unregisterReceiver(this.f28262f);
            } catch (Exception unused) {
            }
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        d();
    }

    public void b() {
        AdSlot b2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f28258b).b();
        if (b2 == null || TextUtils.isEmpty(b2.getCodeId()) || com.bytedance.sdk.openadsdk.component.reward.a.a(this.f28258b).c(b2.getCodeId()) != null) {
            return;
        }
        b(b2);
    }

    public static c a(Context context) {
        if (f28257a == null) {
            synchronized (c.class) {
                if (f28257a == null) {
                    f28257a = new c(context);
                }
            }
        }
        return f28257a;
    }

    public void b(AdSlot adSlot) {
        if (adSlot != null && !TextUtils.isEmpty(adSlot.getBidAdm())) {
            u.b("bidding", "preload bidding 逻辑不走预加载逻辑：BidAdm->MD5->" + com.bytedance.sdk.openadsdk.k.g.b.a(adSlot.getBidAdm()));
            return;
        }
        u.b("FullScreenVideoLoadManager", "preload full screen video: " + String.valueOf(adSlot));
        a(adSlot, true, null);
    }

    public void a() {
        try {
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.f28258b).a();
        } catch (Throwable unused) {
        }
    }

    public void a(AdSlot adSlot) {
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.f28258b).b(adSlot);
    }

    @Nullable
    public AdSlot b(String str) {
        return com.bytedance.sdk.openadsdk.component.reward.a.a(this.f28258b).b(str);
    }

    public void a(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        u.b("FullScreenVideoLoadManager", "load full screen video: " + String.valueOf(adSlot));
        u.b("bidding", "load full video: BidAdm->MD5->" + com.bytedance.sdk.openadsdk.k.g.b.a(adSlot.getBidAdm()));
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.f28258b).a(adSlot);
        a(adSlot, false, fullScreenVideoAdListener);
    }

    private void a(final AdSlot adSlot, boolean z, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (adSlot.getExtraSmartLookParam() != null) {
                return;
            }
            a(adSlot, true, fullScreenVideoAdListener, currentTimeMillis);
            return;
        }
        final l c2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f28258b).c(adSlot.getCodeId());
        if (c2 != null && adSlot.getExtraSmartLookParam() == null) {
            j jVar = new j(this.f28258b, c2, adSlot);
            if (!c2.D()) {
                jVar.a(com.bytedance.sdk.openadsdk.component.reward.a.a(this.f28258b).a(c2));
            }
            com.bytedance.sdk.openadsdk.c.d.a(c2);
            if (fullScreenVideoAdListener != null) {
                fullScreenVideoAdListener.onFullScreenVideoAdLoad(jVar);
                if (!c2.D()) {
                    com.bytedance.sdk.openadsdk.c.d.a(this.f28258b, c2, ak.b(adSlot.getDurationSlotType()), currentTimeMillis);
                    fullScreenVideoAdListener.onFullScreenVideoCached();
                }
            }
            com.bytedance.sdk.openadsdk.core.g.a.a().a(c2, new a.InterfaceC0305a() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.1
                @Override // com.bytedance.sdk.openadsdk.core.g.a.InterfaceC0305a
                public void a(boolean z2) {
                    if (fullScreenVideoAdListener == null || !c2.D()) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.c.d.a(c.this.f28258b, c2, ak.b(adSlot.getDurationSlotType()), currentTimeMillis);
                    fullScreenVideoAdListener.onFullScreenVideoCached();
                }
            });
            u.b("FullScreenVideoLoadManager", "get cache data success");
            return;
        }
        u.b("TTMediationSDK", "全屏视频从网络获取 smartLook参数不为null时.....");
        a(adSlot, false, fullScreenVideoAdListener, currentTimeMillis);
    }

    private void a(final AdSlot adSlot, final boolean z, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener, final long j) {
        u.b("bidding", "full video doNetwork 获取新物料:BidAdm->MD5->" + com.bytedance.sdk.openadsdk.k.g.b.a(adSlot.getBidAdm()));
        m mVar = new m();
        mVar.f28737c = z ? 2 : 1;
        if (p.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
            mVar.f28739e = 2;
        }
        this.f28259c.a(adSlot, mVar, 8, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i2, String str) {
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                if (z || (fullScreenVideoAdListener2 = fullScreenVideoAdListener) == null) {
                    return;
                }
                fullScreenVideoAdListener2.onError(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener3;
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener4;
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    u.b("FullScreenVideoLoadManager", "get material data success isPreload=" + z);
                    final l lVar = aVar.c().get(0);
                    try {
                        if (lVar.aa() != null && !TextUtils.isEmpty(lVar.aa().a())) {
                            String a2 = lVar.aa().a();
                            com.bytedance.sdk.openadsdk.i.c cVar = new com.bytedance.sdk.openadsdk.i.c(true);
                            cVar.a(adSlot.getCodeId());
                            cVar.a(8);
                            cVar.c(lVar.am());
                            cVar.d(lVar.ap());
                            cVar.b(ak.h(lVar.ap()));
                            com.bytedance.sdk.openadsdk.i.e.c().h().f(a2, cVar);
                        }
                    } catch (Throwable unused) {
                    }
                    final j jVar = new j(c.this.f28258b, lVar, adSlot);
                    if (!z && (fullScreenVideoAdListener4 = fullScreenVideoAdListener) != null) {
                        fullScreenVideoAdListener4.onFullScreenVideoAdLoad(jVar);
                    }
                    com.bytedance.sdk.openadsdk.core.g.a.a().a(lVar, new a.InterfaceC0305a() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2.1
                        @Override // com.bytedance.sdk.openadsdk.core.g.a.InterfaceC0305a
                        public void a(boolean z2) {
                            l lVar2;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (z || fullScreenVideoAdListener == null || (lVar2 = lVar) == null || !lVar2.D()) {
                                return;
                            }
                            com.bytedance.sdk.openadsdk.c.d.a(c.this.f28258b, lVar, ak.b(adSlot.getDurationSlotType()), j);
                            fullScreenVideoAdListener.onFullScreenVideoCached();
                        }
                    });
                    if (lVar.aH()) {
                        if (z && !lVar.D() && p.h().q(adSlot.getCodeId()).f28943d == 1) {
                            if (x.d(c.this.f28258b)) {
                                return;
                            }
                            c cVar2 = c.this;
                            cVar2.a(new a(lVar, adSlot));
                        } else if (!lVar.D()) {
                            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f28258b).a(lVar, new a.InterfaceC0297a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2.2
                                @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC0297a
                                public void a(boolean z2, Object obj) {
                                    u.b("FullScreenVideoLoadManager", "download video file: " + z2 + ", preload: " + z);
                                    if (z2) {
                                        jVar.a(com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f28258b).a(lVar));
                                    }
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    if (z) {
                                        if (z2) {
                                            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f28258b).a(adSlot, lVar);
                                            return;
                                        }
                                        return;
                                    }
                                    com.bytedance.sdk.openadsdk.c.d.a(lVar);
                                    if (z2) {
                                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                        if (fullScreenVideoAdListener != null) {
                                            com.bytedance.sdk.openadsdk.c.d.a(c.this.f28258b, lVar, ak.b(adSlot.getDurationSlotType()), j);
                                            fullScreenVideoAdListener.onFullScreenVideoCached();
                                        }
                                    }
                                }
                            });
                        } else {
                            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.f28258b).a(adSlot, lVar);
                        }
                    } else if (z || (fullScreenVideoAdListener3 = fullScreenVideoAdListener) == null) {
                    } else {
                        fullScreenVideoAdListener3.onError(-4, com.bytedance.sdk.openadsdk.core.h.a(-4));
                    }
                } else if (z || (fullScreenVideoAdListener2 = fullScreenVideoAdListener) == null) {
                } else {
                    fullScreenVideoAdListener2.onError(-3, com.bytedance.sdk.openadsdk.core.h.a(-3));
                }
            }
        });
    }

    public void a(String str) {
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.f28258b).a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f28261e.size() >= 1) {
            this.f28261e.remove(0);
        }
        this.f28261e.add(aVar);
    }
}
