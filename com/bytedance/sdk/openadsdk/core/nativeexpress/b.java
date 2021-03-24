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
    public AdSlot f28513a;

    /* renamed from: c  reason: collision with root package name */
    public Context f28515c;

    /* renamed from: d  reason: collision with root package name */
    public TTAdNative.NativeExpressAdListener f28516d;

    /* renamed from: f  reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.core.d.l> f28518f;

    /* renamed from: g  reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.core.d.l> f28519g;

    /* renamed from: h  reason: collision with root package name */
    public a f28520h;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f28517e = new AtomicBoolean(false);
    public int i = 5;
    public ScheduledFuture<?> k = null;
    public ScheduledFuture<?> l = null;
    public ScheduledFuture<?> m = null;

    /* renamed from: b  reason: collision with root package name */
    public final q f28514b = p.f();

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(List<com.bytedance.sdk.openadsdk.core.d.l> list);
    }

    public b(Context context) {
        if (context != null) {
            this.f28515c = context.getApplicationContext();
        } else {
            this.f28515c = p.a();
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
        List<com.bytedance.sdk.openadsdk.core.d.l> list = this.f28518f;
        if (list != null) {
            list.clear();
        }
        List<com.bytedance.sdk.openadsdk.core.d.l> list2 = this.f28519g;
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

    public void a(AdSlot adSlot, int i, @NonNull TTAdNative.NativeExpressAdListener nativeExpressAdListener, int i2) {
        a(adSlot, i, nativeExpressAdListener, null, i2);
    }

    public void a(AdSlot adSlot, int i, @Nullable TTAdNative.NativeExpressAdListener nativeExpressAdListener, @Nullable a aVar, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f28517e.get()) {
            u.f("ExpressAdLoadManager", "express ad is loading...");
            return;
        }
        this.i = i;
        this.f28517e.set(true);
        this.f28513a = adSlot;
        this.f28516d = nativeExpressAdListener;
        this.f28520h = aVar;
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
        mVar.f28196e = 2;
        this.f28514b.a(adSlot, mVar, this.i, new q.b() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.1
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                b.this.a(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    b.this.f28518f = aVar.c();
                    b.this.f28519g = aVar.c();
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
        List<com.bytedance.sdk.openadsdk.core.d.l> list = this.f28518f;
        if (list == null) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.core.d.l lVar : list) {
            if (lVar.aH() && lVar.af() != null && !lVar.af().isEmpty()) {
                for (com.bytedance.sdk.openadsdk.core.d.k kVar : lVar.af()) {
                    if (!TextUtils.isEmpty(kVar.a())) {
                        com.bytedance.sdk.openadsdk.i.e.c().g().a(kVar.a(), (b.InterfaceC0321b) com.bytedance.sdk.openadsdk.i.a.b.a(), kVar.b(), kVar.c(), false);
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
        if (this.f28517e.getAndSet(false)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f28519g == null || b.this.f28519g.size() <= 0) {
                        if (b.this.f28516d != null) {
                            b.this.f28516d.onError(108, com.bytedance.sdk.openadsdk.core.h.a(108));
                            b.this.a(108);
                        }
                        if (b.this.f28520h != null) {
                            b.this.f28520h.a();
                        }
                    } else {
                        if (b.this.f28516d != null) {
                            ArrayList arrayList = new ArrayList(b.this.f28519g.size());
                            for (com.bytedance.sdk.openadsdk.core.d.l lVar : b.this.f28519g) {
                                arrayList.add(b.this.a(lVar));
                            }
                            if (!arrayList.isEmpty()) {
                                com.bytedance.sdk.openadsdk.c.d.a(b.this.f28515c, (com.bytedance.sdk.openadsdk.core.d.l) b.this.f28519g.get(0), ak.b(b.this.f28513a.getDurationSlotType()), j2);
                                b.this.f28516d.onNativeExpressAdLoad(arrayList);
                            } else {
                                b.this.f28516d.onError(103, com.bytedance.sdk.openadsdk.core.h.a(103));
                                b.this.a(103);
                            }
                        }
                        if (b.this.f28520h != null) {
                            b.this.f28520h.a(b.this.f28519g);
                        }
                    }
                    b.this.b();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        List<com.bytedance.sdk.openadsdk.core.d.l> list = this.f28518f;
        com.bytedance.sdk.openadsdk.h.a.c f2 = com.bytedance.sdk.openadsdk.h.a.c.b().a(this.i).c(this.f28513a.getCodeId()).f((list == null || list.size() <= 0) ? "" : ak.h(this.f28518f.get(0).ap()));
        f2.b(i).g(com.bytedance.sdk.openadsdk.core.h.a(i));
        com.bytedance.sdk.openadsdk.h.a.a().h(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        if (this.f28517e.getAndSet(false)) {
            TTAdNative.NativeExpressAdListener nativeExpressAdListener = this.f28516d;
            if (nativeExpressAdListener != null) {
                nativeExpressAdListener.onError(i, str);
            }
            a aVar = this.f28520h;
            if (aVar != null) {
                aVar.a();
            }
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TTNativeExpressAd a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        int i = this.i;
        if (i == 1) {
            if (lVar.X() != null) {
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.c(this.f28515c, lVar, this.f28513a);
            }
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.b(this.f28515c, lVar, this.f28513a);
        } else if (i == 2) {
            if (lVar.X() != null) {
                return new com.bytedance.sdk.openadsdk.core.c.c(this.f28515c, lVar, this.f28513a);
            }
            return new com.bytedance.sdk.openadsdk.core.c.b(this.f28515c, lVar, this.f28513a);
        } else if (i != 5) {
            if (i != 9) {
                return null;
            }
            return new m(this.f28515c, lVar, this.f28513a);
        } else if (lVar.X() != null) {
            return new o(this.f28515c, lVar, this.f28513a);
        } else {
            return new k(this.f28515c, lVar, this.f28513a);
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
