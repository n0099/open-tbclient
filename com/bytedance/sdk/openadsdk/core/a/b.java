package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public Context f27703c;

    /* renamed from: d  reason: collision with root package name */
    public final l f27704d;

    /* renamed from: e  reason: collision with root package name */
    public final String f27705e;

    /* renamed from: f  reason: collision with root package name */
    public final int f27706f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<View> f27707g;

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<View> f27708h;
    public f i;
    public a j;
    public TTNativeAd k;
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c l;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a n;
    public TTNativeExpressAd p;
    public com.bytedance.sdk.openadsdk.core.nativeexpress.a q;
    public boolean m = false;
    public boolean r = false;
    public Map<String, Object> o = new HashMap();

    /* loaded from: classes5.dex */
    public interface a {
        void a(View view, int i);
    }

    public b(@NonNull Context context, @NonNull l lVar, @NonNull String str, int i) {
        this.f27703c = context;
        this.f27704d = lVar;
        this.f27705e = str;
        this.f27706f = i;
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        this.n = aVar;
    }

    public void b(View view) {
        this.f27708h = new WeakReference<>(view);
    }

    public void d(boolean z) {
        this.r = z;
    }

    public void e(boolean z) {
        this.m = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.nativeexpress.a aVar) {
        this.q = aVar;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a d() {
        return this.n;
    }

    public void e() {
        l lVar = this.f27704d;
        if (lVar == null) {
            return;
        }
        boolean C = lVar.C();
        z.a(this.f27703c, this.f27704d, this.f27706f, this.k, this.p, C ? this.f27705e : ak.a(this.f27706f), this.n, C, this.o, this.r, a(this.f27705e));
    }

    public void a(TTNativeAd tTNativeAd) {
        this.k = tTNativeAd;
    }

    public void a(TTNativeExpressAd tTNativeExpressAd) {
        this.p = tTNativeExpressAd;
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar) {
        this.l = cVar;
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    public void a(View view) {
        this.f27707g = new WeakReference<>(view);
    }

    public void a(Map<String, Object> map) {
        Map<String, Object> map2 = this.o;
        if (map2 == null) {
            this.o = map;
        } else {
            map2.putAll(map);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i, int i2, int i3, int i4) {
        l lVar;
        if (a(1)) {
            return;
        }
        if (this.f27703c == null) {
            this.f27703c = p.a();
        }
        if (this.f27703c == null) {
            return;
        }
        long j = this.w;
        long j2 = this.x;
        WeakReference<View> weakReference = this.f27707g;
        View view2 = weakReference == null ? null : weakReference.get();
        WeakReference<View> weakReference2 = this.f27708h;
        this.i = a(i, i2, i3, i4, j, j2, view2, weakReference2 == null ? null : weakReference2.get());
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(view, -1);
        }
        boolean C = this.f27704d.C();
        boolean a2 = z.a(this.f27703c, this.f27704d, this.f27706f, this.k, this.p, C ? this.f27705e : ak.a(this.f27706f), this.n, C, this.o, this.r, a(this.f27705e));
        if (a2 || (lVar = this.f27704d) == null || lVar.ao() == null || this.f27704d.ao().c() != 2) {
            com.bytedance.sdk.openadsdk.c.d.a(this.f27703c, PrefetchEvent.STATE_CLICK, this.f27704d, this.i, this.f27705e, a2, this.o);
        }
    }

    private boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.equals("feed_video_middle_page");
    }

    public f a(int i, int i2, int i3, int i4, long j, long j2, View view, View view2) {
        return new f.a().e(i).d(i2).c(i3).b(i4).b(j).a(j2).b(al.a(view)).a(al.a(view2)).c(al.c(view)).d(al.c(view2)).f(this.y).g(this.z).h(this.A).a(this.C).a(i.d().b() ? 1 : 2).a();
    }

    public boolean a(int i) {
        if (this.q != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            WeakReference<View> weakReference = this.f27708h;
            if (weakReference != null) {
                iArr = al.a(weakReference.get());
                iArr2 = al.c(this.f27708h.get());
            }
            this.q.a(i, new j.a().d(this.s).c(this.t).b(this.u).a(this.v).b(this.w).a(this.x).e(iArr[0]).f(iArr[1]).g(iArr2[0]).h(iArr2[1]).a());
            return true;
        }
        return false;
    }
}
