package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes5.dex */
public class d extends com.bytedance.sdk.openadsdk.core.a.a {

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.j f28219a;

    public d(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.d.l lVar, @NonNull String str, int i) {
        super(context, lVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.b
    public com.bytedance.sdk.openadsdk.core.d.f a(int i, int i2, int i3, int i4, long j, long j2, View view, View view2) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        long j3;
        long j4;
        this.y = 1;
        this.z = 0;
        this.A = 0;
        int[] a2 = al.a(view);
        if (a2 == null || a2.length != 2) {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
            i9 = 0;
            i10 = 0;
        } else {
            i9 = a2[0];
            i10 = a2[1];
            i5 = ((int) al.a(this.f27711c, i)) + i9;
            i6 = ((int) al.a(this.f27711c, i2)) + i10;
            i7 = ((int) al.a(this.f27711c, i3)) + i9;
            i8 = ((int) al.a(this.f27711c, i4)) + i10;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        com.bytedance.sdk.openadsdk.core.d.j jVar = this.f28219a;
        if (jVar != null) {
            j3 = jVar.f27855e;
            j4 = jVar.f27856f;
            iArr[0] = ((int) al.a(this.f27711c, jVar.f27857g)) + i9;
            iArr[1] = ((int) al.a(this.f27711c, this.f28219a.f27858h)) + i10;
            int a3 = (int) al.a(this.f27711c, this.f28219a.i);
            int a4 = (int) al.a(this.f27711c, this.f28219a.j);
            iArr2[0] = a3;
            i11 = 1;
            iArr2[1] = a4;
            if (a3 == 0 && a4 == 0) {
                iArr = al.a(view2);
                iArr2 = al.c(view2);
            }
        } else {
            i11 = 1;
            j3 = j;
            j4 = j2;
        }
        f.a h2 = new f.a().e(i5).d(i6).c(i7).b(i8).b(j3).a(j4).b(a2).a(iArr).c(al.c(view)).d(iArr2).f(this.y).g(this.z).h(this.A);
        if (!com.bytedance.sdk.openadsdk.core.i.d().b()) {
            i11 = 2;
        }
        return h2.a(i11).a(this.C).a();
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.j jVar) {
        this.f28219a = jVar;
    }
}
