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
/* loaded from: classes4.dex */
public class g {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile g f6322a;

    /* renamed from: b  reason: collision with root package name */
    private Context f6323b;
    private AtomicBoolean d = new AtomicBoolean(false);
    private List<a> e = Collections.synchronizedList(new ArrayList());
    private final BroadcastReceiver f = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && x.c(g.this.f6323b) != 0) {
                Iterator it = g.this.e.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.openadsdk.k.a.a().c((Runnable) it.next(), 1);
                    it.remove();
                }
            }
        }
    };
    private final q c = p.f();

    public static g a(Context context) {
        if (f6322a == null) {
            synchronized (g.class) {
                if (f6322a == null) {
                    f6322a = new g(context);
                }
            }
        }
        return f6322a;
    }

    private g(Context context) {
        this.f6323b = context == null ? p.a() : context.getApplicationContext();
        c();
    }

    public void a() {
        AdSlot b2 = e.a(this.f6323b).b();
        if (b2 != null && !TextUtils.isEmpty(b2.getCodeId()) && e.a(this.f6323b).c(b2.getCodeId()) == null) {
            b(b2);
        }
    }

    public void a(AdSlot adSlot) {
        e.a(this.f6323b).b(adSlot);
    }

    public void b() {
        try {
            e.a(this.f6323b).a();
        } catch (Throwable th) {
        }
    }

    public void a(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        u.b("RewardVideoLoadManager", "load reward vide: " + String.valueOf(adSlot));
        e.a(this.f6323b).a(adSlot);
        a(adSlot, false, rewardVideoAdListener);
    }

    public void b(AdSlot adSlot) {
        u.b("RewardVideoLoadManager", "preload reward video: " + String.valueOf(adSlot));
        a(adSlot, true, null);
    }

    private void a(AdSlot adSlot, boolean z, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        if (z) {
            b(adSlot, true, rewardVideoAdListener);
            return;
        }
        final l c = e.a(this.f6323b).c(adSlot.getCodeId());
        if (c != null) {
            j jVar = new j(this.f6323b, c, adSlot);
            if (!c.t()) {
                jVar.a(e.a(this.f6323b).a(c));
            }
            com.bytedance.sdk.openadsdk.c.d.a(c);
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.onRewardVideoAdLoad(jVar);
                if (!c.t()) {
                    rewardVideoAdListener.onRewardVideoCached();
                }
            }
            com.bytedance.sdk.openadsdk.core.g.a.a().a(c, new a.InterfaceC1003a() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.1
                @Override // com.bytedance.sdk.openadsdk.core.g.a.InterfaceC1003a
                public void a(boolean z2) {
                    if (rewardVideoAdListener != null && c.t()) {
                        rewardVideoAdListener.onRewardVideoCached();
                    }
                }
            });
            u.b("RewardVideoLoadManager", "get cache data success");
            return;
        }
        b(adSlot, false, rewardVideoAdListener);
    }

    private void b(final AdSlot adSlot, final boolean z, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        m mVar = new m();
        mVar.f6514b = z ? 2 : 1;
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
                        if (lVar.I() != null && !TextUtils.isEmpty(lVar.I().a())) {
                            String a2 = lVar.I().a();
                            com.bytedance.sdk.openadsdk.i.b bVar = new com.bytedance.sdk.openadsdk.i.b(true);
                            bVar.a(adSlot.getCodeId());
                            bVar.a(7);
                            bVar.c(lVar.T());
                            bVar.d(lVar.W());
                            bVar.b(aj.h(lVar.W()));
                            com.bytedance.sdk.openadsdk.i.e.a(g.this.f6323b).g().a(a2, bVar);
                        }
                    } catch (Throwable th) {
                    }
                    final j jVar = new j(g.this.f6323b, lVar, adSlot);
                    if (!z && rewardVideoAdListener != null) {
                        rewardVideoAdListener.onRewardVideoAdLoad(jVar);
                    }
                    com.bytedance.sdk.openadsdk.core.g.a.a().a(lVar, new a.InterfaceC1003a() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.2.1
                        @Override // com.bytedance.sdk.openadsdk.core.g.a.InterfaceC1003a
                        public void a(boolean z2) {
                            if (!z && rewardVideoAdListener != null && lVar != null && lVar.t()) {
                                rewardVideoAdListener.onRewardVideoCached();
                            }
                        }
                    });
                    if (lVar.ai()) {
                        if (z && !lVar.t() && p.h().r(adSlot.getCodeId()).d == 1) {
                            if (!x.d(g.this.f6323b)) {
                                g.this.a(new a(lVar, adSlot));
                            }
                        } else if (!lVar.t()) {
                            e.a(g.this.f6323b).a(lVar, new e.a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.2.2
                                @Override // com.bytedance.sdk.openadsdk.component.reward.e.a
                                public void a(boolean z2, Object obj) {
                                    u.b("RewardVideoLoadManager", "download video file: " + z2 + ", preload: " + z);
                                    if (z2) {
                                        jVar.a(e.a(g.this.f6323b).a(lVar));
                                    }
                                    if (!z) {
                                        com.bytedance.sdk.openadsdk.c.d.a(lVar);
                                        if (z2 && rewardVideoAdListener != null) {
                                            rewardVideoAdListener.onRewardVideoCached();
                                        }
                                    } else if (z2) {
                                        e.a(g.this.f6323b).a(adSlot, lVar);
                                    }
                                }
                            });
                        } else {
                            e.a(g.this.f6323b).a(adSlot, lVar);
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
        e.a(this.f6323b).a(str);
    }

    @Nullable
    public AdSlot b(String str) {
        return e.a(this.f6323b).b(str);
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
                this.f6323b.registerReceiver(this.f, intentFilter);
            } catch (Exception e) {
            }
        }
    }

    private void d() {
        if (this.d.get()) {
            this.d.set(false);
            try {
                this.f6323b.unregisterReceiver(this.f);
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
        l f6333a;

        /* renamed from: b  reason: collision with root package name */
        AdSlot f6334b;

        a(l lVar, AdSlot adSlot) {
            this.f6333a = lVar;
            this.f6334b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a(g.this.f6323b).a(this.f6333a, new e.a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.a.1
                @Override // com.bytedance.sdk.openadsdk.component.reward.e.a
                public void a(boolean z, Object obj) {
                    if (z) {
                        e.a(g.this.f6323b).a(a.this.f6334b, a.this.f6333a);
                    }
                }
            });
        }
    }
}
