package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
public class d extends com.bytedance.sdk.openadsdk.core.a.a {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.d.j f4485a;

    public d(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.d.l lVar, @NonNull String str, int i) {
        super(context, lVar, str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0104  */
    @Override // com.bytedance.sdk.openadsdk.core.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.bytedance.sdk.openadsdk.core.d.f a(int i, int i2, int i3, int i4, long j, long j2, View view, View view2) {
        int[] iArr;
        int[] iArr2;
        this.y = 1;
        this.z = 0;
        this.A = 0;
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
        int[] iArr3 = new int[2];
        int[] iArr4 = new int[2];
        if (this.f4485a != null) {
            j = this.f4485a.e;
            j2 = this.f4485a.f;
            iArr3[0] = i5 + ((int) ak.a(this.c, this.f4485a.g));
            iArr3[1] = i6 + ((int) ak.a(this.c, this.f4485a.h));
            int a3 = (int) ak.a(this.c, this.f4485a.i);
            int a4 = (int) ak.a(this.c, this.f4485a.j);
            iArr4[0] = a3;
            iArr4[1] = a4;
            if (a3 == 0 && a4 == 0) {
                iArr2 = ak.a(view2);
                iArr = ak.c(view2);
                return new f.a().e(i).d(i2).c(i3).b(i4).b(j).a(j2).b(a2).a(iArr2).c(ak.c(view)).d(iArr).f(this.y).g(this.z).h(this.A).a(!com.bytedance.sdk.openadsdk.core.i.d().b() ? 1 : 2).a(this.C).a();
            }
        }
        iArr = iArr4;
        iArr2 = iArr3;
        return new f.a().e(i).d(i2).c(i3).b(i4).b(j).a(j2).b(a2).a(iArr2).c(ak.c(view)).d(iArr).f(this.y).g(this.z).h(this.A).a(!com.bytedance.sdk.openadsdk.core.i.d().b() ? 1 : 2).a(this.C).a();
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.j jVar) {
        this.f4485a = jVar;
    }
}
