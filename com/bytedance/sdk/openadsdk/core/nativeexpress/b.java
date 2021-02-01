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
import com.bytedance.sdk.openadsdk.utils.aj;
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
    private static Set<b> j = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with root package name */
    private AdSlot f6632a;
    private Context c;
    private TTAdNative.NativeExpressAdListener d;
    private List<com.bytedance.sdk.openadsdk.core.d.l> f;
    private List<com.bytedance.sdk.openadsdk.core.d.l> g;
    private a h;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private int i = 5;
    private ScheduledFuture<?> k = null;
    private ScheduledFuture<?> l = null;
    private ScheduledFuture<?> m = null;

    /* renamed from: b  reason: collision with root package name */
    private final q f6633b = p.f();

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(List<com.bytedance.sdk.openadsdk.core.d.l> list);
    }

    private b(Context context) {
        if (context != null) {
            this.c = context.getApplicationContext();
        } else {
            this.c = p.a();
        }
        j.add(this);
    }

    public static b a(Context context) {
        return new b(context);
    }

    public void a(AdSlot adSlot, int i, @NonNull TTAdNative.NativeExpressAdListener nativeExpressAdListener, int i2) {
        a(adSlot, i, nativeExpressAdListener, null, i2);
    }

    public void a(AdSlot adSlot, int i, @Nullable TTAdNative.NativeExpressAdListener nativeExpressAdListener, @Nullable a aVar, int i2) {
        if (this.e.get()) {
            u.f("ExpressAdLoadManager", "express ad is loading...");
            return;
        }
        this.i = i;
        this.e.set(true);
        this.f6632a = adSlot;
        this.d = nativeExpressAdListener;
        this.h = aVar;
        a(this.f6632a, this.d);
    }

    private void a(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (adSlot != null) {
            com.bytedance.sdk.openadsdk.core.d.m mVar = new com.bytedance.sdk.openadsdk.core.d.m();
            mVar.e = 2;
            this.f6633b.a(adSlot, mVar, this.i, new q.b() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.1
                @Override // com.bytedance.sdk.openadsdk.core.q.b
                public void a(int i, String str) {
                    b.this.a(i, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.q.b
                public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                    if (aVar.c() == null || aVar.c().isEmpty()) {
                        b.this.a(-3, com.bytedance.sdk.openadsdk.core.h.a(-3));
                        return;
                    }
                    b.this.f = aVar.c();
                    b.this.g = aVar.c();
                    b.this.a();
                    b.this.b();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f != null) {
            for (com.bytedance.sdk.openadsdk.core.d.l lVar : this.f) {
                if (lVar.ai() && lVar.M() != null && !lVar.M().isEmpty()) {
                    for (com.bytedance.sdk.openadsdk.core.d.k kVar : lVar.M()) {
                        if (!TextUtils.isEmpty(kVar.a())) {
                            com.bytedance.sdk.openadsdk.i.e.a(this.c).f().a(kVar.a(), (b.InterfaceC1020b) com.bytedance.sdk.openadsdk.i.a.b.a(), kVar.b(), kVar.c(), false);
                        }
                    }
                }
                if (lVar.X() == 5 || lVar.X() == 15) {
                    if (lVar.F() != null && lVar.F().h() != null) {
                        int d = aj.d(lVar.W());
                        if (p.h().a(String.valueOf(d)) && p.h().q(String.valueOf(d))) {
                            com.bytedance.sdk.openadsdk.j.f.a.a().a(new com.bytedance.sdk.openadsdk.j.f.b().a(lVar.F().h()).a(com.baidu.fsg.base.statistics.b.f1933b).b(lVar.F().k()));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.e.getAndSet(false)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.g == null || b.this.g.size() <= 0) {
                        if (b.this.d != null) {
                            b.this.d.onError(108, com.bytedance.sdk.openadsdk.core.h.a(108));
                            b.this.a(108);
                        }
                        if (b.this.h != null) {
                            b.this.h.a();
                        }
                    } else {
                        if (b.this.d != null) {
                            ArrayList arrayList = new ArrayList(b.this.g.size());
                            for (com.bytedance.sdk.openadsdk.core.d.l lVar : b.this.g) {
                                arrayList.add(b.this.a(lVar));
                            }
                            if (!arrayList.isEmpty()) {
                                b.this.d.onNativeExpressAdLoad(arrayList);
                            } else {
                                b.this.d.onError(103, com.bytedance.sdk.openadsdk.core.h.a(103));
                                b.this.a(103);
                            }
                        }
                        if (b.this.h != null) {
                            b.this.h.a(b.this.g);
                        }
                    }
                    b.this.c();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        String str = "";
        if (this.f != null && this.f.size() > 0) {
            str = aj.h(this.f.get(0).W());
        }
        com.bytedance.sdk.openadsdk.h.a.d f = com.bytedance.sdk.openadsdk.h.a.d.b().a(this.i).c(this.f6632a.getCodeId()).f(str);
        f.b(i).g(com.bytedance.sdk.openadsdk.core.h.a(i));
        com.bytedance.sdk.openadsdk.h.a.a().h(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        if (this.e.getAndSet(false)) {
            if (this.d != null) {
                this.d.onError(i, str);
            }
            if (this.h != null) {
                this.h.a();
            }
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TTNativeExpressAd a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        switch (this.i) {
            case 1:
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.b(this.c, lVar, this.f6632a);
            case 2:
                return new com.bytedance.sdk.openadsdk.core.c.b(this.c, lVar, this.f6632a);
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            default:
                return null;
            case 5:
                if (lVar.F() != null) {
                    return new n(this.c, lVar, this.f6632a);
                }
                return new k(this.c, lVar, this.f6632a);
            case 9:
                return new m(this.c, lVar, this.f6632a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f != null) {
            this.f.clear();
        }
        if (this.g != null) {
            this.g.clear();
        }
        a(true);
        b(true);
        c(true);
        d();
    }

    private void a(boolean z) {
        try {
            if (this.l != null && !this.l.isCancelled()) {
                u.f("ExpressAdLoadManager", "CheckValidFutureTask-->cancel......success=" + this.l.cancel(z));
            }
        } catch (Throwable th) {
        }
    }

    private void b(boolean z) {
        try {
            if (this.m != null && !this.m.isCancelled()) {
                u.b("ExpressAdLoadManager", "CheckValidDoneFutureTask-->cancel.....success=" + this.m.cancel(z));
            }
        } catch (Throwable th) {
        }
    }

    private void c(boolean z) {
        try {
            if (this.k != null && !this.k.isCancelled()) {
                u.f("ExpressAdLoadManager", "TimeOutFutureTask-->cancel......success=" + this.k.cancel(z));
            }
        } catch (Throwable th) {
        }
    }

    private void d() {
        j.remove(this);
    }
}
