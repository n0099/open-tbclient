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
import com.bytedance.sdk.openadsdk.component.reward.e;
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
public class g {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile g f4281a;
    private Context b;
    private AtomicBoolean d = new AtomicBoolean(false);
    private List<a> e = Collections.synchronizedList(new ArrayList());
    private final BroadcastReceiver f = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && x.c(g.this.b) != 0) {
                Iterator it = g.this.e.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.openadsdk.j.e.a((Runnable) it.next(), 1);
                    it.remove();
                }
            }
        }
    };
    private final q c = p.f();

    public static g a(Context context) {
        if (f4281a == null) {
            synchronized (g.class) {
                if (f4281a == null) {
                    f4281a = new g(context);
                }
            }
        }
        return f4281a;
    }

    private g(Context context) {
        this.b = context == null ? p.a() : context.getApplicationContext();
        c();
    }

    public void a() {
        AdSlot b = e.a(this.b).b();
        if (b != null && !TextUtils.isEmpty(b.getCodeId()) && e.a(this.b).c(b.getCodeId()) == null) {
            b(b);
        }
    }

    public void a(AdSlot adSlot) {
        e.a(this.b).b(adSlot);
    }

    public void b() {
        try {
            e.a(this.b).a();
        } catch (Throwable th) {
        }
    }

    public void a(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        u.b("RewardVideoLoadManager", "load reward vide: " + String.valueOf(adSlot));
        e.a(this.b).a(adSlot);
        a(adSlot, false, rewardVideoAdListener);
    }

    public void b(AdSlot adSlot) {
        u.b("RewardVideoLoadManager", "preload reward video: " + String.valueOf(adSlot));
        a(adSlot, true, null);
    }

    private void a(AdSlot adSlot, boolean z, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        if (z) {
            if (adSlot.getExtraSmartLookParam() != null) {
                u.b("TTMediationSDK", "smartLook参数不为null时 激励视频不需要缓存");
                return;
            } else {
                b(adSlot, true, rewardVideoAdListener);
                return;
            }
        }
        final l c = e.a(this.b).c(adSlot.getCodeId());
        if (c != null && adSlot.getExtraSmartLookParam() == null) {
            j jVar = new j(this.b, c, adSlot);
            if (!c.D()) {
                jVar.a(e.a(this.b).a(c));
            }
            com.bytedance.sdk.openadsdk.c.d.a(c);
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.onRewardVideoAdLoad(jVar);
                if (!c.D()) {
                    rewardVideoAdListener.onRewardVideoCached();
                }
            }
            com.bytedance.sdk.openadsdk.core.g.a.a().a(c, new a.InterfaceC1020a() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.1
                @Override // com.bytedance.sdk.openadsdk.core.g.a.InterfaceC1020a
                public void a(boolean z2) {
                    if (rewardVideoAdListener != null && c.D()) {
                        rewardVideoAdListener.onRewardVideoCached();
                    }
                }
            });
            u.b("RewardVideoLoadManager", "get cache data success");
            return;
        }
        u.b("TTMediationSDK", "激励视频从网络获取 smartLook参数不为null时.....");
        b(adSlot, false, rewardVideoAdListener);
    }

    private void b(final AdSlot adSlot, final boolean z, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        m mVar = new m();
        mVar.b = z ? 2 : 1;
        if (p.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
            mVar.e = 2;
        }
        this.c.a(adSlot, mVar, 7, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.2
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                if (!z && rewardVideoAdListener != null) {
                    rewardVideoAdListener.onError(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    u.b("RewardVideoLoadManager", "get material data success isPreload=" + z);
                    final l lVar = aVar.c().get(0);
                    try {
                        if (lVar.U() != null && !TextUtils.isEmpty(lVar.U().a())) {
                            String a2 = lVar.U().a();
                            com.bytedance.sdk.openadsdk.h.b bVar = new com.bytedance.sdk.openadsdk.h.b(true);
                            bVar.a(adSlot.getCodeId());
                            bVar.a(7);
                            bVar.c(lVar.ag());
                            bVar.d(lVar.aj());
                            bVar.b(aj.h(lVar.aj()));
                            com.bytedance.sdk.openadsdk.h.d.a(g.this.b).g().a(a2, bVar);
                        }
                    } catch (Throwable th) {
                    }
                    final j jVar = new j(g.this.b, lVar, adSlot);
                    if (!z && rewardVideoAdListener != null) {
                        rewardVideoAdListener.onRewardVideoAdLoad(jVar);
                    }
                    com.bytedance.sdk.openadsdk.core.g.a.a().a(lVar, new a.InterfaceC1020a() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.2.1
                        @Override // com.bytedance.sdk.openadsdk.core.g.a.InterfaceC1020a
                        public void a(boolean z2) {
                            if (!z && rewardVideoAdListener != null && lVar != null && lVar.D()) {
                                rewardVideoAdListener.onRewardVideoCached();
                            }
                        }
                    });
                    if (lVar.aA()) {
                        if (z && !lVar.D() && p.h().r(adSlot.getCodeId()).d == 1) {
                            if (!x.d(g.this.b)) {
                                g.this.a(new a(lVar, adSlot));
                            }
                        } else if (!lVar.D()) {
                            e.a(g.this.b).a(lVar, new e.a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.2.2
                                @Override // com.bytedance.sdk.openadsdk.component.reward.e.a
                                public void a(boolean z2, Object obj) {
                                    u.b("RewardVideoLoadManager", "download video file: " + z2 + ", preload: " + z);
                                    if (z2) {
                                        jVar.a(e.a(g.this.b).a(lVar));
                                    }
                                    if (!z) {
                                        com.bytedance.sdk.openadsdk.c.d.a(lVar);
                                        if (z2 && rewardVideoAdListener != null) {
                                            rewardVideoAdListener.onRewardVideoCached();
                                        }
                                    } else if (z2) {
                                        e.a(g.this.b).a(adSlot, lVar);
                                    }
                                }
                            });
                        } else {
                            e.a(g.this.b).a(adSlot, lVar);
                        }
                    } else if (!z && rewardVideoAdListener != null) {
                        rewardVideoAdListener.onError(-4, com.bytedance.sdk.openadsdk.core.h.a(-4));
                    }
                } else if (!z && rewardVideoAdListener != null) {
                    rewardVideoAdListener.onError(-3, com.bytedance.sdk.openadsdk.core.h.a(-3));
                }
            }
        });
    }

    public void a(String str) {
        e.a(this.b).a(str);
    }

    @Nullable
    public AdSlot b(String str) {
        return e.a(this.b).b(str);
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
        l f4287a;
        AdSlot b;

        a(l lVar, AdSlot adSlot) {
            this.f4287a = lVar;
            this.b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a(g.this.b).a(this.f4287a, new e.a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.a.1
                @Override // com.bytedance.sdk.openadsdk.component.reward.e.a
                public void a(boolean z, Object obj) {
                    if (z) {
                        e.a(g.this.b).a(a.this.b, a.this.f4287a);
                    }
                }
            });
        }
    }
}
