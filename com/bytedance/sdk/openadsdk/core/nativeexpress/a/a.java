package com.bytedance.sdk.openadsdk.core.nativeexpress.a;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.p;
import com.bytedance.sdk.openadsdk.core.nativeexpress.a.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.n;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.theme.ThemeStatusBroadcastReceiver;
/* loaded from: classes9.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f66818a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.dynamic.a.a f66819b;

    /* renamed from: c  reason: collision with root package name */
    public ThemeStatusBroadcastReceiver f66820c;

    /* renamed from: d  reason: collision with root package name */
    public n f66821d;

    /* renamed from: e  reason: collision with root package name */
    public g f66822e;

    public a(Context context, g gVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, gVar, themeStatusBroadcastReceiver, nVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66818a = context;
        this.f66822e = gVar;
        this.f66820c = themeStatusBroadcastReceiver;
        this.f66821d = nVar;
        m a2 = gVar.a();
        com.bytedance.sdk.openadsdk.core.dynamic.a.a aVar = new com.bytedance.sdk.openadsdk.core.dynamic.a.a(this.f66818a, this.f66820c);
        this.f66819b = aVar;
        aVar.a(a2).a(a2.ak()).b(a2.ao()).a(q.a(this.f66822e.c())).c(q.i(a2)).a(this.f66822e.b());
        this.f66819b.a(this.f66821d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.e
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.e
    public boolean a(e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            this.f66822e.d().d();
            this.f66819b.a(new com.bytedance.sdk.openadsdk.core.nativeexpress.m(this, aVar) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e.a f66823a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f66824b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66824b = this;
                    this.f66823a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(View view, p pVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, pVar) == null) || this.f66823a.c()) {
                        return;
                    }
                    this.f66824b.f66822e.d().e();
                    this.f66824b.f66822e.d().k();
                    com.bytedance.sdk.openadsdk.core.nativeexpress.p b2 = this.f66823a.b();
                    if (b2 == null) {
                        return;
                    }
                    b2.a(this.f66824b.f66819b, pVar);
                    this.f66823a.a(true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.f66824b.f66822e.d().f();
                        if (this.f66823a.b(this.f66824b)) {
                            this.f66823a.a(this.f66824b);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.nativeexpress.p b2 = this.f66823a.b();
                        if (b2 == null) {
                            return;
                        }
                        b2.d(i2);
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }
}
