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
    public Context f67159a;

    /* renamed from: b  reason: collision with root package name */
    public q f67160b;

    /* renamed from: c  reason: collision with root package name */
    public v f67161c;

    /* renamed from: d  reason: collision with root package name */
    public n f67162d;

    /* renamed from: e  reason: collision with root package name */
    public g f67163e;

    /* renamed from: f  reason: collision with root package name */
    public ScheduledFuture<?> f67164f;

    /* renamed from: g  reason: collision with root package name */
    public ThemeStatusBroadcastReceiver f67165g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f67166h;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public e.a f67169a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f67170b;

        /* renamed from: c  reason: collision with root package name */
        public int f67171c;

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
            this.f67170b = hVar;
            this.f67171c = i2;
            this.f67169a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f67171c == 1) {
                k.b("RenderInterceptor", "WebView Render timeout");
                this.f67170b.f67161c.a(true);
                this.f67170b.a(this.f67169a, 107);
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
        this.f67159a = context;
        this.f67163e = gVar;
        this.f67165g = themeStatusBroadcastReceiver;
        this.f67160b = qVar;
        this.f67162d = nVar;
        this.f67166h = new AtomicBoolean(false);
        v vVar = new v(this.f67159a, gVar, this.f67165g, this.f67160b);
        this.f67161c = vVar;
        vVar.a(this.f67162d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            try {
                if (this.f67164f != null && !this.f67164f.isCancelled()) {
                    this.f67164f.cancel(false);
                    this.f67164f = null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67161c : (v) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.e
    public boolean a(e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            this.f67164f = com.bytedance.sdk.component.d.e.d().schedule(new a(this, 1, aVar), this.f67163e.e(), TimeUnit.MILLISECONDS);
            this.f67161c.a(new m(this, aVar) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.a.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e.a f67167a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ h f67168b;

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
                    this.f67168b = this;
                    this.f67167a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(View view, p pVar) {
                    com.bytedance.sdk.openadsdk.core.nativeexpress.p b2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, pVar) == null) {
                        this.f67168b.c();
                        if (this.f67167a.c() || (b2 = this.f67167a.b()) == null) {
                            return;
                        }
                        b2.a(this.f67168b.f67161c, pVar);
                        this.f67167a.a(true);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.f67168b.a(this.f67167a, i2);
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
            this.f67161c.e();
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65537, this, aVar, i2) == null) || this.f67166h.get()) {
            return;
        }
        c();
        this.f67163e.d().a(i2);
        if (aVar.b(this)) {
            aVar.a(this);
        } else {
            com.bytedance.sdk.openadsdk.core.nativeexpress.p b2 = aVar.b();
            if (b2 == null) {
                return;
            }
            b2.d(i2);
        }
        this.f67166h.getAndSet(true);
    }
}
