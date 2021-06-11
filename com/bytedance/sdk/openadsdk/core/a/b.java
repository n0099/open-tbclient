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
/* loaded from: classes6.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public Context f27827c;

    /* renamed from: d  reason: collision with root package name */
    public final l f27828d;

    /* renamed from: e  reason: collision with root package name */
    public final String f27829e;

    /* renamed from: f  reason: collision with root package name */
    public final int f27830f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<View> f27831g;

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<View> f27832h;

    /* renamed from: i  reason: collision with root package name */
    public f f27833i;
    public a j;
    public TTNativeAd k;
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c l;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a n;
    public TTNativeExpressAd p;
    public com.bytedance.sdk.openadsdk.core.nativeexpress.a q;
    public boolean m = false;
    public boolean r = false;
    public Map<String, Object> o = new HashMap();

    /* loaded from: classes6.dex */
    public interface a {
        void a(View view, int i2);
    }

    public b(@NonNull Context context, @NonNull l lVar, @NonNull String str, int i2) {
        this.f27827c = context;
        this.f27828d = lVar;
        this.f27829e = str;
        this.f27830f = i2;
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        this.n = aVar;
    }

    public void b(View view) {
        this.f27832h = new WeakReference<>(view);
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
        l lVar = this.f27828d;
        if (lVar == null) {
            return;
        }
        boolean C = lVar.C();
        z.a(this.f27827c, this.f27828d, this.f27830f, this.k, this.p, C ? this.f27829e : ak.a(this.f27830f), this.n, C, this.o, this.r, a(this.f27829e));
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
        this.f27831g = new WeakReference<>(view);
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
    public void a(View view, int i2, int i3, int i4, int i5) {
        l lVar;
        if (a(1)) {
            return;
        }
        if (this.f27827c == null) {
            this.f27827c = p.a();
        }
        if (this.f27827c == null) {
            return;
        }
        long j = this.w;
        long j2 = this.x;
        WeakReference<View> weakReference = this.f27831g;
        View view2 = weakReference == null ? null : weakReference.get();
        WeakReference<View> weakReference2 = this.f27832h;
        this.f27833i = a(i2, i3, i4, i5, j, j2, view2, weakReference2 == null ? null : weakReference2.get());
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(view, -1);
        }
        boolean C = this.f27828d.C();
        boolean a2 = z.a(this.f27827c, this.f27828d, this.f27830f, this.k, this.p, C ? this.f27829e : ak.a(this.f27830f), this.n, C, this.o, this.r, a(this.f27829e));
        if (a2 || (lVar = this.f27828d) == null || lVar.ao() == null || this.f27828d.ao().c() != 2) {
            com.bytedance.sdk.openadsdk.c.d.a(this.f27827c, PrefetchEvent.STATE_CLICK, this.f27828d, this.f27833i, this.f27829e, a2, this.o);
        }
    }

    private boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.equals("feed_video_middle_page");
    }

    public f a(int i2, int i3, int i4, int i5, long j, long j2, View view, View view2) {
        return new f.a().e(i2).d(i3).c(i4).b(i5).b(j).a(j2).b(al.a(view)).a(al.a(view2)).c(al.c(view)).d(al.c(view2)).f(this.y).g(this.z).h(this.A).a(this.C).a(i.d().b() ? 1 : 2).a();
    }

    public boolean a(int i2) {
        if (this.q != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            WeakReference<View> weakReference = this.f27832h;
            if (weakReference != null) {
                iArr = al.a(weakReference.get());
                iArr2 = al.c(this.f27832h.get());
            }
            this.q.a(i2, new j.a().d(this.s).c(this.t).b(this.u).a(this.v).b(this.w).a(this.x).e(iArr[0]).f(iArr[1]).g(iArr2[0]).h(iArr2[1]).a());
            return true;
        }
        return false;
    }
}
