package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.text.TextUtils;
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
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
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
    protected com.bytedance.sdk.openadsdk.downloadnew.core.a n;
    protected TTNativeExpressAd p;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.a q;
    protected boolean m = false;
    protected boolean r = false;
    protected Map<String, Object> o = new HashMap();

    /* loaded from: classes6.dex */
    public interface a {
        void a(View view, int i);
    }

    public void d(boolean z) {
        this.r = z;
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        this.n = aVar;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a d() {
        return this.n;
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

    public void e(boolean z) {
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
        if (this.o == null) {
            this.o = map;
        } else {
            this.o.putAll(map);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i, int i2, int i3, int i4) {
        if (!a(1)) {
            if (this.c == null) {
                this.c = p.a();
            }
            if (this.c != null) {
                this.i = a(i, i2, i3, i4, this.w, this.x, this.g == null ? null : this.g.get(), this.h == null ? null : this.h.get());
                if (this.j != null) {
                    this.j.a(view, -1);
                }
                boolean C = this.d.C();
                boolean a2 = z.a(this.c, this.d, this.f, this.k, this.p, C ? this.e : aj.a(this.f), this.n, C, this.o, this.r, a(this.e));
                if (a2 || this.d == null || this.d.ai() == null || this.d.ai().c() != 2) {
                    com.bytedance.sdk.openadsdk.c.d.a(this.c, "click", this.d, this.i, this.e, a2, this.o);
                }
            }
        }
    }

    public void e() {
        if (this.d != null) {
            boolean C = this.d.C();
            z.a(this.c, this.d, this.f, this.k, this.p, C ? this.e : aj.a(this.f), this.n, C, this.o, this.r, a(this.e));
        }
    }

    private boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.equals("feed_video_middle_page");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f a(int i, int i2, int i3, int i4, long j, long j2, View view, View view2) {
        return new f.a().e(i).d(i2).c(i3).b(i4).b(j).a(j2).b(ak.a(view)).a(ak.a(view2)).c(ak.c(view)).d(ak.c(view2)).f(this.y).g(this.z).h(this.A).a(this.C).a(i.d().b() ? 1 : 2).a();
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
            this.q.a(i, new j.a().d(this.s).c(this.t).b(this.u).a(this.v).b(this.w).a(this.x).e(iArr[0]).f(iArr[1]).g(iArr2[0]).h(iArr2[1]).a());
            return true;
        }
        return false;
    }
}
