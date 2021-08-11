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
    public Context f66438a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.dynamic.a.a f66439b;

    /* renamed from: c  reason: collision with root package name */
    public ThemeStatusBroadcastReceiver f66440c;

    /* renamed from: d  reason: collision with root package name */
    public n f66441d;

    /* renamed from: e  reason: collision with root package name */
    public g f66442e;

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
        this.f66438a = context;
        this.f66442e = gVar;
        this.f66440c = themeStatusBroadcastReceiver;
        this.f66441d = nVar;
        m a2 = gVar.a();
        com.bytedance.sdk.openadsdk.core.dynamic.a.a aVar = new com.bytedance.sdk.openadsdk.core.dynamic.a.a(this.f66438a, this.f66440c);
        this.f66439b = aVar;
        aVar.a(a2).a(a2.ak()).b(a2.ao()).a(q.a(this.f66442e.c())).c(q.i(a2)).a(this.f66442e.b());
        this.f66439b.a(this.f66441d);
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
            this.f66442e.d().d();
            this.f66439b.a(new com.bytedance.sdk.openadsdk.core.nativeexpress.m(this, aVar) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e.a f66443a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f66444b;

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
                    this.f66444b = this;
                    this.f66443a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(View view, p pVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, pVar) == null) || this.f66443a.c()) {
                        return;
                    }
                    this.f66444b.f66442e.d().e();
                    this.f66444b.f66442e.d().k();
                    com.bytedance.sdk.openadsdk.core.nativeexpress.p b2 = this.f66443a.b();
                    if (b2 == null) {
                        return;
                    }
                    b2.a(this.f66444b.f66439b, pVar);
                    this.f66443a.a(true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.f66444b.f66442e.d().f();
                        if (this.f66443a.b(this.f66444b)) {
                            this.f66443a.a(this.f66444b);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.nativeexpress.p b2 = this.f66443a.b();
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
