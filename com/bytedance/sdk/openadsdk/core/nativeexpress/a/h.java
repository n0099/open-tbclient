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
/* loaded from: classes5.dex */
public class h implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f30547a;

    /* renamed from: b  reason: collision with root package name */
    public q f30548b;

    /* renamed from: c  reason: collision with root package name */
    public v f30549c;

    /* renamed from: d  reason: collision with root package name */
    public n f30550d;

    /* renamed from: e  reason: collision with root package name */
    public g f30551e;

    /* renamed from: f  reason: collision with root package name */
    public ScheduledFuture<?> f30552f;

    /* renamed from: g  reason: collision with root package name */
    public ThemeStatusBroadcastReceiver f30553g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f30554h;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public e.a f30557a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f30558b;

        /* renamed from: c  reason: collision with root package name */
        public int f30559c;

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
            this.f30558b = hVar;
            this.f30559c = i2;
            this.f30557a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f30559c == 1) {
                k.b("RenderInterceptor", "WebView Render timeout");
                this.f30558b.f30549c.a(true);
                this.f30558b.a(this.f30557a, 107);
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
        this.f30547a = context;
        this.f30551e = gVar;
        this.f30553g = themeStatusBroadcastReceiver;
        this.f30548b = qVar;
        this.f30550d = nVar;
        this.f30554h = new AtomicBoolean(false);
        v vVar = new v(this.f30547a, gVar, this.f30553g, this.f30548b);
        this.f30549c = vVar;
        vVar.a(this.f30550d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            try {
                if (this.f30552f != null && !this.f30552f.isCancelled()) {
                    this.f30552f.cancel(false);
                    this.f30552f = null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30549c : (v) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.e
    public boolean a(e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            this.f30552f = com.bytedance.sdk.component.d.e.d().schedule(new a(this, 1, aVar), this.f30551e.e(), TimeUnit.MILLISECONDS);
            this.f30549c.a(new m(this, aVar) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.a.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e.a f30555a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ h f30556b;

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
                    this.f30556b = this;
                    this.f30555a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(View view, p pVar) {
                    com.bytedance.sdk.openadsdk.core.nativeexpress.p b2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, pVar) == null) {
                        this.f30556b.c();
                        if (this.f30555a.c() || (b2 = this.f30555a.b()) == null) {
                            return;
                        }
                        b2.a(this.f30556b.f30549c, pVar);
                        this.f30555a.a(true);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.f30556b.a(this.f30555a, i2);
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
            this.f30549c.e();
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65537, this, aVar, i2) == null) || this.f30554h.get()) {
            return;
        }
        c();
        this.f30551e.d().a(i2);
        if (aVar.b(this)) {
            aVar.a(this);
        } else {
            com.bytedance.sdk.openadsdk.core.nativeexpress.p b2 = aVar.b();
            if (b2 == null) {
                return;
            }
            b2.d(i2);
        }
        this.f30554h.getAndSet(true);
    }
}
