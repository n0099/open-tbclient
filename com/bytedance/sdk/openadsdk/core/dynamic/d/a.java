package com.bytedance.sdk.openadsdk.core.dynamic.d;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.j;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class a extends com.bytedance.sdk.openadsdk.core.a.c {

    /* renamed from: a  reason: collision with root package name */
    protected WeakReference<View> f4419a;
    protected WeakReference<View> b;
    private j c;

    public void a(j jVar) {
        this.c = jVar;
    }

    public void a(View view) {
        this.f4419a = new WeakReference<>(view);
    }

    public void b(View view) {
        this.b = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i, int i2, int i3, int i4) {
        a(((Integer) view.getTag()).intValue());
    }

    private void a(int i) {
        if (this.c != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            if (this.b != null) {
                iArr = ak.a(this.b.get());
                iArr2 = ak.c(this.b.get());
            }
            this.c.a(i, new j.a().d(this.s).c(this.t).b(this.u).a(this.v).b(this.w).a(this.x).e(iArr[0]).f(iArr[1]).g(iArr2[0]).h(iArr2[1]).a());
        }
    }
}
