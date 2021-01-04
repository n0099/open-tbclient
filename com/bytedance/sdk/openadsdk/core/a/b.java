package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes4.dex */
public class b extends c {
    protected Context c;
    protected final l d;
    protected final String e;
    protected final int f;
    protected WeakReference<View> g;
    protected WeakReference<View> h;
    protected f i;
    protected a j;
    protected TTNativeAd k;
    protected com.bytedance.sdk.openadsdk.core.video.nativevideo.c l;
    protected boolean m = false;
    protected com.bytedance.sdk.openadsdk.downloadnew.core.a n;
    protected Map<String, Object> o;
    protected TTNativeExpressAd p;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.a q;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view, int i);
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        this.n = aVar;
    }

    public void a(com.bytedance.sdk.openadsdk.core.nativeexpress.a aVar) {
        this.q = aVar;
    }

    public void a(TTNativeAd tTNativeAd) {
        this.k = tTNativeAd;
    }

    public void a(TTNativeExpressAd tTNativeExpressAd) {
        this.p = tTNativeExpressAd;
    }

    public void d(boolean z) {
        this.m = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar) {
        this.l = cVar;
    }

    public b(@NonNull Context context, @NonNull l lVar, @NonNull String str, int i) {
        this.c = context;
        this.d = lVar;
        this.e = str;
        this.f = i;
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    public void a(View view) {
        this.g = new WeakReference<>(view);
    }

    public void b(View view) {
        this.h = new WeakReference<>(view);
    }

    public void a(Map<String, Object> map) {
        this.o = map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i, int i2, int i3, int i4) {
        if (!a(1)) {
            if (this.c == null) {
                this.c = p.a();
            }
            if (this.c != null) {
                this.i = a(i, i2, i3, i4, this.v, this.w, this.g == null ? null : this.g.get(), this.h == null ? null : this.h.get());
                if (this.j != null) {
                    this.j.a(view, -1);
                }
                boolean s = this.d.s();
                boolean a2 = z.a(this.c, this.d, this.f, this.k, this.p, s ? this.e : aj.a(this.f), this.n, s);
                if (a2 || this.d == null || this.d.V() == null || this.d.V().c() != 2) {
                    com.bytedance.sdk.openadsdk.c.d.a(this.c, "click", this.d, this.i, this.e, a2, this.o);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f a(int i, int i2, int i3, int i4, long j, long j2, View view, View view2) {
        return new f.a().e(i).d(i2).c(i3).b(i4).b(j).a(j2).b(ak.a(view)).a(ak.a(view2)).c(ak.c(view)).d(ak.c(view2)).f(this.x).g(this.y).h(this.z).a(this.B).a(i.c().b() ? 1 : 2).a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i) {
        if (this.q != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            if (this.h != null) {
                iArr = ak.a(this.h.get());
                iArr2 = ak.c(this.h.get());
            }
            this.q.a(i, new j.a().d(this.r).c(this.s).b(this.t).a(this.u).b(this.v).a(this.w).e(iArr[0]).f(iArr[1]).g(iArr2[0]).h(iArr2[1]).a());
            return true;
        }
        return false;
    }
}
