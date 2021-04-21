package com.bytedance.sdk.openadsdk.core.dynamic.d;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.j;
import com.bytedance.sdk.openadsdk.utils.al;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class a extends com.bytedance.sdk.openadsdk.core.a.c {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<View> f27990a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<View> f27991b;

    /* renamed from: c  reason: collision with root package name */
    public j f27992c;

    public void a(j jVar) {
        this.f27992c = jVar;
    }

    public void b(View view) {
        this.f27991b = new WeakReference<>(view);
    }

    public void a(View view) {
        this.f27990a = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i, int i2, int i3, int i4) {
        a(((Integer) view.getTag()).intValue());
    }

    private void a(int i) {
        if (this.f27992c != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            WeakReference<View> weakReference = this.f27991b;
            if (weakReference != null) {
                iArr = al.a(weakReference.get());
                iArr2 = al.c(this.f27991b.get());
            }
            this.f27992c.a(i, new j.a().d(this.s).c(this.t).b(this.u).a(this.v).b(this.w).a(this.x).e(iArr[0]).f(iArr[1]).g(iArr2[0]).h(iArr2[1]).a());
        }
    }
}
