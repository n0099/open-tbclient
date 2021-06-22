package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.i.a.b;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class b {
    public static Set<b> j = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with root package name */
    public AdSlot f28431a;

    /* renamed from: c  reason: collision with root package name */
    public Context f28433c;

    /* renamed from: d  reason: collision with root package name */
    public TTAdNative.NativeExpressAdListener f28434d;

    /* renamed from: f  reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.core.d.l> f28436f;

    /* renamed from: g  reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.core.d.l> f28437g;

    /* renamed from: h  reason: collision with root package name */
    public a f28438h;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f28435e = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    public int f28439i = 5;
    public ScheduledFuture<?> k = null;
    public ScheduledFuture<?> l = null;
    public ScheduledFuture<?> m = null;

    /* renamed from: b  reason: collision with root package name */
    public final q f28432b = p.f();

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(List<com.bytedance.sdk.openadsdk.core.d.l> list);
    }

    public b(Context context) {
        if (context != null) {
            this.f28433c = context.getApplicationContext();
        } else {
            this.f28433c = p.a();
        }
        j.add(this);
    }

    private void c(boolean z) {
        try {
            if (this.k == null || this.k.isCancelled()) {
                return;
            }
            boolean cancel = this.k.cancel(z);
            u.f("ExpressAdLoadManager", "TimeOutFutureTask-->cancel......success=" + cancel);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        List<com.bytedance.sdk.openadsdk.core.d.l> list = this.f28436f;
        if (list != null) {
            list.clear();
        }
        List<com.bytedance.sdk.openadsdk.core.d.l> list2 = this.f28437g;
        if (list2 != null) {
            list2.clear();
        }
        a(true);
        b(true);
        c(true);
        c();
    }

    private void c() {
        j.remove(this);
    }

    public static b a(Context context) {
        return new b(context);
    }

    public void a(AdSlot adSlot, int i2, @NonNull TTAdNative.NativeExpressAdListener nativeExpressAdListener, int i3) {
        a(adSlot, i2, nativeExpressAdListener, null, i3);
    }

    public void a(AdSlot adSlot, int i2, @Nullable TTAdNative.NativeExpressAdListener nativeExpressAdListener, @Nullable a aVar, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f28435e.get()) {
            u.f("ExpressAdLoadManager", "express ad is loading...");
            return;
        }
        this.f28439i = i2;
        this.f28435e.set(true);
        this.f28431a = adSlot;
        this.f28434d = nativeExpressAdListener;
        this.f28438h = aVar;
        a(adSlot, currentTimeMillis);
    }

    private void b(boolean z) {
        try {
            if (this.m == null || this.m.isCancelled()) {
                return;
            }
            boolean cancel = this.m.cancel(z);
            u.b("ExpressAdLoadManager", "CheckValidDoneFutureTask-->cancel.....success=" + cancel);
        } catch (Throwable unused) {
        }
    }

    private void a(AdSlot adSlot, final long j2) {
        if (adSlot == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.d.m mVar = new com.bytedance.sdk.openadsdk.core.d.m();
        mVar.f28098e = 2;
        this.f28432b.a(adSlot, mVar, this.f28439i, new q.b() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.1
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i2, String str) {
                b.this.a(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    b.this.f28436f = aVar.c();
                    b.this.f28437g = aVar.c();
                    b.this.a();
                    b.this.a(j2);
                    return;
                }
                b.this.a(-3, com.bytedance.sdk.openadsdk.core.h.a(-3));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        List<com.bytedance.sdk.openadsdk.core.d.l> list = this.f28436f;
        if (list == null) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.core.d.l lVar : list) {
            if (lVar.aH() && lVar.af() != null && !lVar.af().isEmpty()) {
                for (com.bytedance.sdk.openadsdk.core.d.k kVar : lVar.af()) {
                    if (!TextUtils.isEmpty(kVar.a())) {
                        com.bytedance.sdk.openadsdk.i.e.c().g().a(kVar.a(), (b.InterfaceC0312b) com.bytedance.sdk.openadsdk.i.a.b.a(), kVar.b(), kVar.c(), false);
                    }
                }
            }
            if (com.bytedance.sdk.openadsdk.core.d.l.c(lVar) && lVar.X() != null && lVar.X().i() != null) {
                if (p.h().a(String.valueOf(ak.d(lVar.ap()))) && p.h().L()) {
                    com.bytedance.sdk.openadsdk.core.video.e.c.a(new com.bytedance.sdk.openadsdk.k.f.b().a(lVar.X().i()).a(204800).b(lVar.X().l()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j2) {
        if (this.f28435e.getAndSet(false)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f28437g == null || b.this.f28437g.size() <= 0) {
                        if (b.this.f28434d != null) {
                            b.this.f28434d.onError(108, com.bytedance.sdk.openadsdk.core.h.a(108));
                            b.this.a(108);
                        }
                        if (b.this.f28438h != null) {
                            b.this.f28438h.a();
                        }
                    } else {
                        if (b.this.f28434d != null) {
                            ArrayList arrayList = new ArrayList(b.this.f28437g.size());
                            for (com.bytedance.sdk.openadsdk.core.d.l lVar : b.this.f28437g) {
                                arrayList.add(b.this.a(lVar));
                            }
                            if (!arrayList.isEmpty()) {
                                com.bytedance.sdk.openadsdk.c.d.a(b.this.f28433c, (com.bytedance.sdk.openadsdk.core.d.l) b.this.f28437g.get(0), ak.b(b.this.f28431a.getDurationSlotType()), j2);
                                b.this.f28434d.onNativeExpressAdLoad(arrayList);
                            } else {
                                b.this.f28434d.onError(103, com.bytedance.sdk.openadsdk.core.h.a(103));
                                b.this.a(103);
                            }
                        }
                        if (b.this.f28438h != null) {
                            b.this.f28438h.a(b.this.f28437g);
                        }
                    }
                    b.this.b();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        List<com.bytedance.sdk.openadsdk.core.d.l> list = this.f28436f;
        com.bytedance.sdk.openadsdk.h.a.c f2 = com.bytedance.sdk.openadsdk.h.a.c.b().a(this.f28439i).c(this.f28431a.getCodeId()).f((list == null || list.size() <= 0) ? "" : ak.h(this.f28436f.get(0).ap()));
        f2.b(i2).g(com.bytedance.sdk.openadsdk.core.h.a(i2));
        com.bytedance.sdk.openadsdk.h.a.a().h(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        if (this.f28435e.getAndSet(false)) {
            TTAdNative.NativeExpressAdListener nativeExpressAdListener = this.f28434d;
            if (nativeExpressAdListener != null) {
                nativeExpressAdListener.onError(i2, str);
            }
            a aVar = this.f28438h;
            if (aVar != null) {
                aVar.a();
            }
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TTNativeExpressAd a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        int i2 = this.f28439i;
        if (i2 == 1) {
            if (lVar.X() != null) {
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.c(this.f28433c, lVar, this.f28431a);
            }
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.b(this.f28433c, lVar, this.f28431a);
        } else if (i2 == 2) {
            if (lVar.X() != null) {
                return new com.bytedance.sdk.openadsdk.core.c.c(this.f28433c, lVar, this.f28431a);
            }
            return new com.bytedance.sdk.openadsdk.core.c.b(this.f28433c, lVar, this.f28431a);
        } else if (i2 != 5) {
            if (i2 != 9) {
                return null;
            }
            return new m(this.f28433c, lVar, this.f28431a);
        } else if (lVar.X() != null) {
            return new o(this.f28433c, lVar, this.f28431a);
        } else {
            return new k(this.f28433c, lVar, this.f28431a);
        }
    }

    private void a(boolean z) {
        try {
            if (this.l == null || this.l.isCancelled()) {
                return;
            }
            boolean cancel = this.l.cancel(z);
            u.f("ExpressAdLoadManager", "CheckValidFutureTask-->cancel......success=" + cancel);
        } catch (Throwable unused) {
        }
    }
}
