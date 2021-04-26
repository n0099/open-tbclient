package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes5.dex */
public class e extends com.bytedance.sdk.openadsdk.core.a.b {

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.j f29086a;

    public e(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.d.l lVar, @NonNull String str, int i2) {
        super(context, lVar, str, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.b
    public com.bytedance.sdk.openadsdk.core.d.f a(int i2, int i3, int i4, int i5, long j, long j2, View view, View view2) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        long j3;
        long j4;
        this.y = 1;
        this.z = 0;
        this.A = 0;
        int[] a2 = al.a(view);
        if (a2 == null || a2.length != 2) {
            i6 = i2;
            i7 = i3;
            i8 = i4;
            i9 = i5;
            i10 = 0;
            i11 = 0;
        } else {
            i10 = a2[0];
            i11 = a2[1];
            i6 = ((int) al.a(this.f28550c, i2)) + i10;
            i7 = ((int) al.a(this.f28550c, i3)) + i11;
            i8 = ((int) al.a(this.f28550c, i4)) + i10;
            i9 = ((int) al.a(this.f28550c, i5)) + i11;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        com.bytedance.sdk.openadsdk.core.d.j jVar = this.f29086a;
        if (jVar != null) {
            j3 = jVar.f28701e;
            j4 = jVar.f28702f;
            iArr[0] = ((int) al.a(this.f28550c, jVar.f28703g)) + i10;
            iArr[1] = ((int) al.a(this.f28550c, this.f29086a.f28704h)) + i11;
            iArr2[0] = (int) al.a(this.f28550c, this.f29086a.f28705i);
            i12 = 1;
            iArr2[1] = (int) al.a(this.f28550c, this.f29086a.j);
        } else {
            i12 = 1;
            j3 = j;
            j4 = j2;
        }
        f.a h2 = new f.a().e(i6).d(i7).c(i8).b(i9).b(j3).a(j4).b(a2).a(iArr).c(al.c(view)).d(iArr2).f(this.y).g(this.z).h(this.A);
        if (!com.bytedance.sdk.openadsdk.core.i.d().b()) {
            i12 = 2;
        }
        return h2.a(i12).a(this.C).a();
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.j jVar) {
        this.f29086a = jVar;
    }
}
