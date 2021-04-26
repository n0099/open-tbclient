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
import com.bytedance.sdk.openadsdk.component.reward.f;
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
public class h {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f28309a;

    /* renamed from: b  reason: collision with root package name */
    public Context f28310b;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f28312d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public List<a> f28313e = Collections.synchronizedList(new ArrayList());

    /* renamed from: f  reason: collision with root package name */
    public final BroadcastReceiver f28314f = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.component.reward.h.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || x.c(h.this.f28310b) == 0) {
                return;
            }
            Iterator it = h.this.f28313e.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.openadsdk.l.e.a((com.bytedance.sdk.openadsdk.l.g) it.next(), 1);
                it.remove();
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final q f28311c = p.f();

    /* loaded from: classes5.dex */
    public class a extends com.bytedance.sdk.openadsdk.l.g {

        /* renamed from: a  reason: collision with root package name */
        public l f28331a;

        /* renamed from: b  reason: collision with root package name */
        public AdSlot f28332b;

        public a(l lVar, AdSlot adSlot) {
            super("Reward Task");
            this.f28331a = lVar;
            this.f28332b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.a(h.this.f28310b).a(this.f28331a, new f.a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.h.a.1
                @Override // com.bytedance.sdk.openadsdk.component.reward.f.a
                public void a(boolean z, Object obj) {
                    if (z) {
                        f a2 = f.a(h.this.f28310b);
                        a aVar = a.this;
                        a2.a(aVar.f28332b, aVar.f28331a);
                    }
                }
            });
        }
    }

    public h(Context context) {
        this.f28310b = context == null ? p.a() : context.getApplicationContext();
        c();
    }

    private void c() {
        if (this.f28312d.get()) {
            return;
        }
        this.f28312d.set(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.f28310b.registerReceiver(this.f28314f, intentFilter);
        } catch (Exception unused) {
        }
    }

    private void d() {
        if (this.f28312d.get()) {
            this.f28312d.set(false);
            try {
                this.f28310b.unregisterReceiver(this.f28314f);
            } catch (Exception unused) {
            }
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        d();
    }

    public void b() {
        try {
            f.a(this.f28310b).a();
        } catch (Throwable unused) {
        }
    }

    public static h a(Context context) {
        if (f28309a == null) {
            synchronized (h.class) {
                if (f28309a == null) {
                    f28309a = new h(context);
                }
            }
        }
        return f28309a;
    }

    public void b(AdSlot adSlot) {
        if (adSlot != null && !TextUtils.isEmpty(adSlot.getBidAdm())) {
            u.b("bidding", "preload bidding 逻辑不走预加载逻辑：BidAdm->MD5->" + com.bytedance.sdk.openadsdk.k.g.b.a(adSlot.getBidAdm()));
            return;
        }
        u.b("RewardVideoLoadManager", "preload reward video: " + String.valueOf(adSlot));
        a(adSlot, true, null);
    }

    @Nullable
    public AdSlot b(String str) {
        return f.a(this.f28310b).b(str);
    }

    public void a() {
        AdSlot b2 = f.a(this.f28310b).b();
        if (b2 == null || TextUtils.isEmpty(b2.getCodeId()) || f.a(this.f28310b).c(b2.getCodeId()) != null) {
            return;
        }
        b(b2);
    }

    public void a(AdSlot adSlot) {
        f.a(this.f28310b).b(adSlot);
    }

    public void a(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        u.b("RewardVideoLoadManager", "load reward vide: " + String.valueOf(adSlot));
        u.b("bidding", "load reward vide: BidAdm->MD5->" + com.bytedance.sdk.openadsdk.k.g.b.a(adSlot.getBidAdm()));
        f.a(this.f28310b).a(adSlot);
        a(adSlot, false, rewardVideoAdListener);
    }

    private void a(final AdSlot adSlot, boolean z, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (adSlot.getExtraSmartLookParam() != null) {
                u.b("TTMediationSDK", "smartLook参数不为null时 激励视频不需要缓存");
                return;
            } else {
                a(adSlot, true, rewardVideoAdListener, currentTimeMillis);
                return;
            }
        }
        final l c2 = f.a(this.f28310b).c(adSlot.getCodeId());
        if (c2 != null && adSlot.getExtraSmartLookParam() == null) {
            k kVar = new k(this.f28310b, c2, adSlot);
            if (!c2.D()) {
                kVar.a(f.a(this.f28310b).a(c2));
            }
            com.bytedance.sdk.openadsdk.c.d.a(c2);
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.onRewardVideoAdLoad(kVar);
                if (!c2.D()) {
                    com.bytedance.sdk.openadsdk.c.d.a(this.f28310b, c2, ak.b(adSlot.getDurationSlotType()), currentTimeMillis);
                    rewardVideoAdListener.onRewardVideoCached();
                }
            }
            com.bytedance.sdk.openadsdk.core.g.a.a().a(c2, new a.InterfaceC0305a() { // from class: com.bytedance.sdk.openadsdk.component.reward.h.1
                @Override // com.bytedance.sdk.openadsdk.core.g.a.InterfaceC0305a
                public void a(boolean z2) {
                    if (rewardVideoAdListener == null || !c2.D()) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.c.d.a(h.this.f28310b, c2, ak.b(adSlot.getDurationSlotType()), currentTimeMillis);
                    rewardVideoAdListener.onRewardVideoCached();
                }
            });
            u.b("RewardVideoLoadManager", "get cache data success");
            return;
        }
        u.b("TTMediationSDK", "激励视频从网络获取 smartLook参数不为null时.....");
        a(adSlot, false, rewardVideoAdListener, currentTimeMillis);
    }

    private void a(final AdSlot adSlot, final boolean z, final TTAdNative.RewardVideoAdListener rewardVideoAdListener, final long j) {
        u.b("bidding", "reward video doNetwork 获取新物料:BidAdm->MD5->" + com.bytedance.sdk.openadsdk.k.g.b.a(adSlot.getBidAdm()));
        m mVar = new m();
        mVar.f28736b = z ? 2 : 1;
        if (p.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
            mVar.f28739e = 2;
        }
        this.f28311c.a(adSlot, mVar, 7, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.reward.h.2
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i2, String str) {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener2;
                if (z || (rewardVideoAdListener2 = rewardVideoAdListener) == null) {
                    return;
                }
                rewardVideoAdListener2.onError(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener2;
                TTAdNative.RewardVideoAdListener rewardVideoAdListener3;
                TTAdNative.RewardVideoAdListener rewardVideoAdListener4;
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    u.b("RewardVideoLoadManager", "get material data success isPreload=" + z);
                    final l lVar = aVar.c().get(0);
                    try {
                        if (lVar.aa() != null && !TextUtils.isEmpty(lVar.aa().a())) {
                            String a2 = lVar.aa().a();
                            com.bytedance.sdk.openadsdk.i.c cVar = new com.bytedance.sdk.openadsdk.i.c(true);
                            cVar.a(adSlot.getCodeId());
                            cVar.a(7);
                            cVar.c(lVar.am());
                            cVar.d(lVar.ap());
                            cVar.b(ak.h(lVar.ap()));
                            com.bytedance.sdk.openadsdk.i.e.c().h().f(a2, cVar);
                        }
                    } catch (Throwable unused) {
                    }
                    final k kVar = new k(h.this.f28310b, lVar, adSlot);
                    if (!z && (rewardVideoAdListener4 = rewardVideoAdListener) != null) {
                        rewardVideoAdListener4.onRewardVideoAdLoad(kVar);
                    }
                    com.bytedance.sdk.openadsdk.core.g.a.a().a(lVar, new a.InterfaceC0305a() { // from class: com.bytedance.sdk.openadsdk.component.reward.h.2.1
                        @Override // com.bytedance.sdk.openadsdk.core.g.a.InterfaceC0305a
                        public void a(boolean z2) {
                            l lVar2;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (z || rewardVideoAdListener == null || (lVar2 = lVar) == null || !lVar2.D()) {
                                return;
                            }
                            com.bytedance.sdk.openadsdk.c.d.a(h.this.f28310b, lVar, ak.b(adSlot.getDurationSlotType()), j);
                            rewardVideoAdListener.onRewardVideoCached();
                        }
                    });
                    if (lVar.aH()) {
                        if (z && !lVar.D() && p.h().q(adSlot.getCodeId()).f28943d == 1) {
                            if (x.d(h.this.f28310b)) {
                                return;
                            }
                            h hVar = h.this;
                            hVar.a(new a(lVar, adSlot));
                        } else if (!lVar.D()) {
                            f.a(h.this.f28310b).a(lVar, new f.a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.h.2.2
                                @Override // com.bytedance.sdk.openadsdk.component.reward.f.a
                                public void a(boolean z2, Object obj) {
                                    u.b("RewardVideoLoadManager", "download video file: " + z2 + ", preload: " + z);
                                    if (z2) {
                                        kVar.a(f.a(h.this.f28310b).a(lVar));
                                    }
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    if (z) {
                                        if (z2) {
                                            f.a(h.this.f28310b).a(adSlot, lVar);
                                            return;
                                        }
                                        return;
                                    }
                                    com.bytedance.sdk.openadsdk.c.d.a(lVar);
                                    if (z2) {
                                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                        if (rewardVideoAdListener != null) {
                                            com.bytedance.sdk.openadsdk.c.d.a(h.this.f28310b, lVar, ak.b(adSlot.getDurationSlotType()), j);
                                            rewardVideoAdListener.onRewardVideoCached();
                                        }
                                    }
                                }
                            });
                        } else {
                            f.a(h.this.f28310b).a(adSlot, lVar);
                        }
                    } else if (z || (rewardVideoAdListener3 = rewardVideoAdListener) == null) {
                    } else {
                        rewardVideoAdListener3.onError(-4, com.bytedance.sdk.openadsdk.core.h.a(-4));
                    }
                } else if (z || (rewardVideoAdListener2 = rewardVideoAdListener) == null) {
                } else {
                    rewardVideoAdListener2.onError(-3, com.bytedance.sdk.openadsdk.core.h.a(-3));
                }
            }
        });
    }

    public void a(String str) {
        f.a(this.f28310b).a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f28313e.size() >= 1) {
            this.f28313e.remove(0);
        }
        this.f28313e.add(aVar);
    }
}
