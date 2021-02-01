package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
public class e extends com.bytedance.sdk.openadsdk.core.a.b {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.d.j f6637a;

    public e(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.d.l lVar, @NonNull String str, int i) {
        super(context, lVar, str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.a.b
    public com.bytedance.sdk.openadsdk.core.d.f a(int i, int i2, int i3, int i4, long j, long j2, View view, View view2) {
        this.x = 1;
        this.y = 0;
        this.z = 0;
        int i5 = 0;
        int i6 = 0;
        int[] a2 = ak.a(view);
        if (a2 != null && a2.length == 2) {
            i5 = a2[0];
            i6 = a2[1];
            i = ((int) ak.a(this.c, i)) + i5;
            i2 = ((int) ak.a(this.c, i2)) + i6;
            i3 = ((int) ak.a(this.c, i3)) + i5;
            i4 = ((int) ak.a(this.c, i4)) + i6;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (this.f6637a != null) {
            j = this.f6637a.e;
            j2 = this.f6637a.f;
            iArr[0] = i5 + ((int) ak.a(this.c, this.f6637a.g));
            iArr[1] = i6 + ((int) ak.a(this.c, this.f6637a.h));
            iArr2[0] = (int) ak.a(this.c, this.f6637a.i);
            iArr2[1] = (int) ak.a(this.c, this.f6637a.j);
        }
        return new f.a().e(i).d(i2).c(i3).b(i4).b(j).a(j2).b(a2).a(iArr).c(ak.c(view)).d(iArr2).f(this.x).g(this.y).h(this.z).a(com.bytedance.sdk.openadsdk.core.i.c().b() ? 1 : 2).a(this.B).a();
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.j jVar) {
        this.f6637a = jVar;
    }
}
