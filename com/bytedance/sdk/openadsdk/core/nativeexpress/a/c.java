package com.bytedance.sdk.openadsdk.core.nativeexpress.a;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.e.p;
import com.bytedance.sdk.openadsdk.core.nativeexpress.a.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.m;
import com.bytedance.sdk.openadsdk.theme.ThemeStatusBroadcastReceiver;
/* loaded from: classes5.dex */
public class c implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f30524a;

    /* renamed from: b  reason: collision with root package name */
    public l f30525b;

    /* renamed from: c  reason: collision with root package name */
    public View f30526c;

    /* renamed from: d  reason: collision with root package name */
    public ThemeStatusBroadcastReceiver f30527d;

    /* renamed from: e  reason: collision with root package name */
    public g f30528e;

    public c(Context context, View view, g gVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, gVar, themeStatusBroadcastReceiver};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30524a = context;
        this.f30526c = view;
        this.f30528e = gVar;
        this.f30527d = themeStatusBroadcastReceiver;
        this.f30525b = new l(view, themeStatusBroadcastReceiver, gVar);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            this.f30528e.d().g();
            this.f30525b.a(new m(this, aVar) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e.a f30529a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f30530b;

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
                    this.f30530b = this;
                    this.f30529a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(View view, p pVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, pVar) == null) || this.f30529a.c()) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.nativeexpress.p b2 = this.f30529a.b();
                    if (b2 != null) {
                        b2.a(this.f30530b.f30525b, pVar);
                    }
                    this.f30529a.a(true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(int i2) {
                    com.bytedance.sdk.openadsdk.core.nativeexpress.p b2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) || (b2 = this.f30529a.b()) == null) {
                        return;
                    }
                    b2.d(i2);
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }

    public void a(com.bytedance.sdk.openadsdk.core.nativeexpress.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f30525b.a(cVar);
        }
    }
}
