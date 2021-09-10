package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.e.f;
/* loaded from: classes9.dex */
public class d extends com.bytedance.sdk.openadsdk.core.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.k f66877a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.e.m mVar, @NonNull String str, int i2) {
        super(context, mVar, str, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (com.bytedance.sdk.openadsdk.core.e.m) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.b.b
    public com.bytedance.sdk.openadsdk.core.e.f a(int i2, int i3, int i4, int i5, long j2, long j3, View view, View view2, String str) {
        InterceptResult invokeCommon;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        long j4;
        long j5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j2), Long.valueOf(j3), view, view2, str})) == null) {
            this.z = 1;
            this.A = 0;
            this.B = 0;
            int[] a2 = com.bytedance.sdk.openadsdk.q.s.a(view);
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
                i6 = ((int) com.bytedance.sdk.openadsdk.q.s.b(this.f66213b, i2)) + i10;
                i7 = ((int) com.bytedance.sdk.openadsdk.q.s.b(this.f66213b, i3)) + i11;
                i8 = ((int) com.bytedance.sdk.openadsdk.q.s.b(this.f66213b, i4)) + i10;
                i9 = ((int) com.bytedance.sdk.openadsdk.q.s.b(this.f66213b, i5)) + i11;
            }
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            com.bytedance.sdk.openadsdk.core.e.k kVar = this.f66877a;
            if (kVar != null) {
                j4 = kVar.f66450e;
                j5 = kVar.f66451f;
                iArr[0] = ((int) com.bytedance.sdk.openadsdk.q.s.b(this.f66213b, kVar.f66452g)) + i10;
                iArr[1] = ((int) com.bytedance.sdk.openadsdk.q.s.b(this.f66213b, this.f66877a.f66453h)) + i11;
                int b2 = (int) com.bytedance.sdk.openadsdk.q.s.b(this.f66213b, this.f66877a.f66454i);
                int b3 = (int) com.bytedance.sdk.openadsdk.q.s.b(this.f66213b, this.f66877a.f66455j);
                iArr2[0] = b2;
                i12 = 1;
                iArr2[1] = b3;
                if (b2 == 0 && b3 == 0) {
                    iArr = com.bytedance.sdk.openadsdk.q.s.a(view2);
                    iArr2 = com.bytedance.sdk.openadsdk.q.s.c(view2);
                }
            } else {
                i12 = 1;
                j4 = j2;
                j5 = j3;
            }
            f.a h2 = new f.a().e(i6).d(i7).c(i8).b(i9).b(j4).a(j5).b(a2).a(iArr).c(com.bytedance.sdk.openadsdk.q.s.c(view)).d(iArr2).f(this.z).g(this.A).h(this.B);
            if (!com.bytedance.sdk.openadsdk.core.h.d().b()) {
                i12 = 2;
            }
            return h2.a(i12).a(this.D).a(str).a();
        }
        return (com.bytedance.sdk.openadsdk.core.e.f) invokeCommon.objValue;
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar) == null) {
            this.f66877a = kVar;
        }
    }
}
