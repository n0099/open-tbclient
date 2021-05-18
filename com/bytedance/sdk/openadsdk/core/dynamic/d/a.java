package com.bytedance.sdk.openadsdk.core.dynamic.d;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.j;
import com.bytedance.sdk.openadsdk.utils.al;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class a extends com.bytedance.sdk.openadsdk.core.a.c {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<View> f28090a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<View> f28091b;

    /* renamed from: c  reason: collision with root package name */
    public j f28092c;

    public void a(j jVar) {
        this.f28092c = jVar;
    }

    public void b(View view) {
        this.f28091b = new WeakReference<>(view);
    }

    public void a(View view) {
        this.f28090a = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i2, int i3, int i4, int i5) {
        a(((Integer) view.getTag()).intValue());
    }

    private void a(int i2) {
        if (this.f28092c != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            WeakReference<View> weakReference = this.f28091b;
            if (weakReference != null) {
                iArr = al.a(weakReference.get());
                iArr2 = al.c(this.f28091b.get());
            }
            this.f28092c.a(i2, new j.a().d(this.s).c(this.t).b(this.u).a(this.v).b(this.w).a(this.x).e(iArr[0]).f(iArr[1]).g(iArr2[0]).h(iArr2[1]).a());
        }
    }
}
