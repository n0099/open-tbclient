package com.bytedance.sdk.openadsdk.core.dynamic.d;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.e.k;
import com.bytedance.sdk.openadsdk.core.nativeexpress.o;
import com.bytedance.sdk.openadsdk.q.s;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<View> f30077a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<View> f30078b;

    /* renamed from: c  reason: collision with root package name */
    public o f30079c;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oVar) == null) {
            this.f30079c = oVar;
        }
    }

    public void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f30078b = new WeakReference<>(view);
        }
    }

    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f30077a = new WeakReference<>(view);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.b.c
    public void a(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            a(((Integer) view.getTag()).intValue());
        }
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65537, this, i2) == null) || this.f30079c == null) {
            return;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        WeakReference<View> weakReference = this.f30078b;
        if (weakReference != null) {
            iArr = s.a(weakReference.get());
            iArr2 = s.c(this.f30078b.get());
        }
        this.f30079c.a(i2, new k.a().d(this.t).c(this.u).b(this.v).a(this.w).b(this.x).a(this.y).e(iArr[0]).f(iArr[1]).g(iArr2[0]).h(iArr2[1]).a());
    }
}
