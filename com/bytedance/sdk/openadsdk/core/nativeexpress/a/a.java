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
/* loaded from: classes5.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f30517a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.dynamic.a.a f30518b;

    /* renamed from: c  reason: collision with root package name */
    public ThemeStatusBroadcastReceiver f30519c;

    /* renamed from: d  reason: collision with root package name */
    public n f30520d;

    /* renamed from: e  reason: collision with root package name */
    public g f30521e;

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
        this.f30517a = context;
        this.f30521e = gVar;
        this.f30519c = themeStatusBroadcastReceiver;
        this.f30520d = nVar;
        m a2 = gVar.a();
        com.bytedance.sdk.openadsdk.core.dynamic.a.a aVar = new com.bytedance.sdk.openadsdk.core.dynamic.a.a(this.f30517a, this.f30519c);
        this.f30518b = aVar;
        aVar.a(a2).a(a2.ak()).b(a2.ao()).a(q.a(this.f30521e.c())).c(q.i(a2)).a(this.f30521e.b());
        this.f30518b.a(this.f30520d);
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
            this.f30521e.d().d();
            this.f30518b.a(new com.bytedance.sdk.openadsdk.core.nativeexpress.m(this, aVar) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e.a f30522a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f30523b;

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
                    this.f30523b = this;
                    this.f30522a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(View view, p pVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, pVar) == null) || this.f30522a.c()) {
                        return;
                    }
                    this.f30523b.f30521e.d().e();
                    this.f30523b.f30521e.d().k();
                    com.bytedance.sdk.openadsdk.core.nativeexpress.p b2 = this.f30522a.b();
                    if (b2 == null) {
                        return;
                    }
                    b2.a(this.f30523b.f30518b, pVar);
                    this.f30522a.a(true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.f30523b.f30521e.d().f();
                        if (this.f30522a.b(this.f30523b)) {
                            this.f30522a.a(this.f30523b);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.nativeexpress.p b2 = this.f30522a.b();
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
