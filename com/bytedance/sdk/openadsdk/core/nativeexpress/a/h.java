package com.bytedance.sdk.openadsdk.core.nativeexpress.a;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.e.p;
import com.bytedance.sdk.openadsdk.core.nativeexpress.a.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.v;
import com.bytedance.sdk.openadsdk.e.q;
import com.bytedance.sdk.openadsdk.theme.ThemeStatusBroadcastReceiver;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class h implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f66848a;

    /* renamed from: b  reason: collision with root package name */
    public q f66849b;

    /* renamed from: c  reason: collision with root package name */
    public v f66850c;

    /* renamed from: d  reason: collision with root package name */
    public n f66851d;

    /* renamed from: e  reason: collision with root package name */
    public g f66852e;

    /* renamed from: f  reason: collision with root package name */
    public ScheduledFuture<?> f66853f;

    /* renamed from: g  reason: collision with root package name */
    public ThemeStatusBroadcastReceiver f66854g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f66855h;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public e.a f66858a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f66859b;

        /* renamed from: c  reason: collision with root package name */
        public int f66860c;

        public a(h hVar, int i2, e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66859b = hVar;
            this.f66860c = i2;
            this.f66858a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f66860c == 1) {
                k.b("RenderInterceptor", "WebView Render timeout");
                this.f66859b.f66850c.a(true);
                this.f66859b.a(this.f66858a, 107);
            }
        }
    }

    public h(Context context, g gVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, q qVar, n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, gVar, themeStatusBroadcastReceiver, qVar, nVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66848a = context;
        this.f66852e = gVar;
        this.f66854g = themeStatusBroadcastReceiver;
        this.f66849b = qVar;
        this.f66851d = nVar;
        this.f66855h = new AtomicBoolean(false);
        v vVar = new v(this.f66848a, gVar, this.f66854g, this.f66849b);
        this.f66850c = vVar;
        vVar.a(this.f66851d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            try {
                if (this.f66853f != null && !this.f66853f.isCancelled()) {
                    this.f66853f.cancel(false);
                    this.f66853f = null;
                }
                k.b("RenderInterceptor", "WebView Render cancel timeout timer");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public v b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66850c : (v) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.e
    public boolean a(e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            this.f66853f = com.bytedance.sdk.component.d.e.d().schedule(new a(this, 1, aVar), this.f66852e.e(), TimeUnit.MILLISECONDS);
            this.f66850c.a(new m(this, aVar) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.a.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e.a f66856a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ h f66857b;

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
                    this.f66857b = this;
                    this.f66856a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(View view, p pVar) {
                    com.bytedance.sdk.openadsdk.core.nativeexpress.p b2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, pVar) == null) {
                        this.f66857b.c();
                        if (this.f66856a.c() || (b2 = this.f66856a.b()) == null) {
                            return;
                        }
                        b2.a(this.f66857b.f66850c, pVar);
                        this.f66856a.a(true);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.f66857b.a(this.f66856a, i2);
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.e
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f66850c.e();
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65537, this, aVar, i2) == null) || this.f66855h.get()) {
            return;
        }
        c();
        this.f66852e.d().a(i2);
        if (aVar.b(this)) {
            aVar.a(this);
        } else {
            com.bytedance.sdk.openadsdk.core.nativeexpress.p b2 = aVar.b();
            if (b2 == null) {
                return;
            }
            b2.d(i2);
        }
        this.f66855h.getAndSet(true);
    }
}
