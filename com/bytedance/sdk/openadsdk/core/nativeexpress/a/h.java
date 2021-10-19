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
    public Context f67194a;

    /* renamed from: b  reason: collision with root package name */
    public q f67195b;

    /* renamed from: c  reason: collision with root package name */
    public v f67196c;

    /* renamed from: d  reason: collision with root package name */
    public n f67197d;

    /* renamed from: e  reason: collision with root package name */
    public g f67198e;

    /* renamed from: f  reason: collision with root package name */
    public ScheduledFuture<?> f67199f;

    /* renamed from: g  reason: collision with root package name */
    public ThemeStatusBroadcastReceiver f67200g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f67201h;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public e.a f67204a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f67205b;

        /* renamed from: c  reason: collision with root package name */
        public int f67206c;

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
            this.f67205b = hVar;
            this.f67206c = i2;
            this.f67204a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f67206c == 1) {
                k.b("RenderInterceptor", "WebView Render timeout");
                this.f67205b.f67196c.a(true);
                this.f67205b.a(this.f67204a, 107);
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
        this.f67194a = context;
        this.f67198e = gVar;
        this.f67200g = themeStatusBroadcastReceiver;
        this.f67195b = qVar;
        this.f67197d = nVar;
        this.f67201h = new AtomicBoolean(false);
        v vVar = new v(this.f67194a, gVar, this.f67200g, this.f67195b);
        this.f67196c = vVar;
        vVar.a(this.f67197d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            try {
                if (this.f67199f != null && !this.f67199f.isCancelled()) {
                    this.f67199f.cancel(false);
                    this.f67199f = null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67196c : (v) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.e
    public boolean a(e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            this.f67199f = com.bytedance.sdk.component.d.e.d().schedule(new a(this, 1, aVar), this.f67198e.e(), TimeUnit.MILLISECONDS);
            this.f67196c.a(new m(this, aVar) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.a.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e.a f67202a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ h f67203b;

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
                    this.f67203b = this;
                    this.f67202a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(View view, p pVar) {
                    com.bytedance.sdk.openadsdk.core.nativeexpress.p b2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, pVar) == null) {
                        this.f67203b.c();
                        if (this.f67202a.c() || (b2 = this.f67202a.b()) == null) {
                            return;
                        }
                        b2.a(this.f67203b.f67196c, pVar);
                        this.f67202a.a(true);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.f67203b.a(this.f67202a, i2);
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
            this.f67196c.e();
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65537, this, aVar, i2) == null) || this.f67201h.get()) {
            return;
        }
        c();
        this.f67198e.d().a(i2);
        if (aVar.b(this)) {
            aVar.a(this);
        } else {
            com.bytedance.sdk.openadsdk.core.nativeexpress.p b2 = aVar.b();
            if (b2 == null) {
                return;
            }
            b2.d(i2);
        }
        this.f67201h.getAndSet(true);
    }
}
