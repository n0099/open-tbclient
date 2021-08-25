package com.bytedance.sdk.openadsdk.core.nativeexpress;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class h implements com.bytedance.sdk.openadsdk.core.nativeexpress.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.e.q f66701a;

    /* renamed from: b  reason: collision with root package name */
    public String f66702b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f66703c;

    /* renamed from: d  reason: collision with root package name */
    public String f66704d;

    public h(@NonNull com.bytedance.sdk.openadsdk.e.q qVar, String str, com.bytedance.sdk.openadsdk.core.e.m mVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qVar, str, mVar, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66701a = qVar;
        this.f66702b = str;
        this.f66704d = str2;
        this.f66703c = mVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.d
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.bytedance.sdk.component.utils.k.b("ExpressRenderEvent", "dynamic start render");
            this.f66701a.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.d
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            com.bytedance.sdk.component.utils.k.b("ExpressRenderEvent", "dynamic success");
            this.f66701a.e();
            this.f66701a.a(true);
            com.bytedance.sdk.component.d.e.b(new com.bytedance.sdk.component.d.g(this, "dynamic_success") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f66705a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66705a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.bytedance.sdk.openadsdk.e.d.g(com.bytedance.sdk.openadsdk.core.o.a(), this.f66705a.f66703c, this.f66705a.f66702b, "dynamic_backup_native_render", null);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.d
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.bytedance.sdk.component.utils.k.b("ExpressRenderEvent", "dynamic fail");
            this.f66701a.a(true);
            this.f66701a.f();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.d
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.bytedance.sdk.component.utils.k.b("ExpressRenderEvent", "native render start");
            this.f66701a.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.d
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            com.bytedance.sdk.component.utils.k.b("ExpressRenderEvent", "native success");
            this.f66701a.a(true);
            this.f66701a.i();
            com.bytedance.sdk.component.d.e.b(new com.bytedance.sdk.component.d.g(this, "native_success") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f66706a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66706a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        g.a(this.f66706a.f66702b, this.f66706a.f66704d, this.f66706a.f66703c);
                        com.bytedance.sdk.openadsdk.e.d.g(com.bytedance.sdk.openadsdk.core.o.a(), this.f66706a.f66703c, this.f66706a.f66702b, "dynamic_backup_render", null);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.d
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            com.bytedance.sdk.component.utils.k.b("ExpressRenderEvent", "no native render");
            this.f66701a.q();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.d
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            com.bytedance.sdk.component.utils.k.b("ExpressRenderEvent", "render fail");
            this.f66701a.r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.d
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            com.bytedance.sdk.component.utils.k.b("ExpressRenderEvent", "render success");
            this.f66701a.b();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f66701a.s();
            this.f66701a.t();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f66701a.a();
            com.bytedance.sdk.component.utils.k.b("ExpressRenderEvent", "start render ");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f66701a.g();
            com.bytedance.sdk.component.utils.k.b("ExpressRenderEvent", "webview start request");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.d
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.bytedance.sdk.component.utils.k.b("ExpressRenderEvent", "webview render success");
            this.f66701a.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.d
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f66701a.a(i2);
            g.a(i2, this.f66702b, this.f66704d, this.f66703c);
            com.bytedance.sdk.component.utils.k.b("ExpressRenderEvent", "WebView render fail");
        }
    }
}
