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
    public Context f67164a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.dynamic.a.a f67165b;

    /* renamed from: c  reason: collision with root package name */
    public ThemeStatusBroadcastReceiver f67166c;

    /* renamed from: d  reason: collision with root package name */
    public n f67167d;

    /* renamed from: e  reason: collision with root package name */
    public g f67168e;

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
        this.f67164a = context;
        this.f67168e = gVar;
        this.f67166c = themeStatusBroadcastReceiver;
        this.f67167d = nVar;
        m a2 = gVar.a();
        com.bytedance.sdk.openadsdk.core.dynamic.a.a aVar = new com.bytedance.sdk.openadsdk.core.dynamic.a.a(this.f67164a, this.f67166c);
        this.f67165b = aVar;
        aVar.a(a2).a(a2.ak()).b(a2.ao()).a(q.a(this.f67168e.c())).c(q.i(a2)).a(this.f67168e.b());
        this.f67165b.a(this.f67167d);
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
            this.f67168e.d().d();
            this.f67165b.a(new com.bytedance.sdk.openadsdk.core.nativeexpress.m(this, aVar) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e.a f67169a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f67170b;

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
                    this.f67170b = this;
                    this.f67169a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(View view, p pVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, pVar) == null) || this.f67169a.c()) {
                        return;
                    }
                    this.f67170b.f67168e.d().e();
                    this.f67170b.f67168e.d().k();
                    com.bytedance.sdk.openadsdk.core.nativeexpress.p b2 = this.f67169a.b();
                    if (b2 == null) {
                        return;
                    }
                    b2.a(this.f67170b.f67165b, pVar);
                    this.f67169a.a(true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.f67170b.f67168e.d().f();
                        if (this.f67169a.b(this.f67170b)) {
                            this.f67169a.a(this.f67170b);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.nativeexpress.p b2 = this.f67169a.b();
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
