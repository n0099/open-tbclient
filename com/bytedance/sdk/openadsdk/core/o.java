package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.e.g;
import com.bytedance.sdk.openadsdk.j.c.c;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.e.b<com.bytedance.sdk.openadsdk.e.a> f66557a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.e.b<c.a> f66558b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.e.b<c.a> f66559c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile p<com.bytedance.sdk.openadsdk.e.a> f66560d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.p.a f66561e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.j.c.a f66562f;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static volatile Context f66563g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.core.j.h f66564h;

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicBoolean f66565i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static volatile Application f66567a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(268405962, "Lcom/bytedance/sdk/openadsdk/core/o$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(268405962, "Lcom/bytedance/sdk/openadsdk/core/o$a;");
                    return;
                }
            }
            try {
                Object b2 = b();
                f66567a = (Application) b2.getClass().getMethod("getApplication", new Class[0]).invoke(b2, new Object[0]);
                com.bytedance.sdk.component.utils.k.f("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.c("MyApplication", "application get failed", th);
            }
        }

        @Nullable
        public static Application a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f66567a : (Application) invokeV.objValue;
        }

        public static Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                try {
                    Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                    method.setAccessible(true);
                    return method.invoke(null, new Object[0]);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.k.c("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(210334951, "Lcom/bytedance/sdk/openadsdk/core/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(210334951, "Lcom/bytedance/sdk/openadsdk/core/o;");
                return;
            }
        }
        f66565i = new AtomicBoolean(false);
    }

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f66563g == null) {
                a(null);
            }
            return f66563g;
        }
        return (Context) invokeV.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            f66557a = null;
            f66561e = null;
            f66562f = null;
        }
    }

    public static com.bytedance.sdk.openadsdk.e.b<com.bytedance.sdk.openadsdk.e.a> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (!com.bytedance.sdk.openadsdk.core.j.g.a()) {
                return com.bytedance.sdk.openadsdk.e.b.c();
            }
            if (f66557a == null) {
                synchronized (o.class) {
                    if (f66557a == null) {
                        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                            f66557a = new com.bytedance.sdk.openadsdk.e.c();
                        } else {
                            f66557a = new com.bytedance.sdk.openadsdk.e.b<>(new com.bytedance.sdk.openadsdk.e.f(f66563g), f(), l(), b(f66563g));
                        }
                    }
                }
            }
            return f66557a;
        }
        return (com.bytedance.sdk.openadsdk.e.b) invokeV.objValue;
    }

    public static com.bytedance.sdk.openadsdk.e.b<c.a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (!com.bytedance.sdk.openadsdk.core.j.g.a()) {
                return com.bytedance.sdk.openadsdk.e.b.d();
            }
            if (f66559c == null) {
                synchronized (o.class) {
                    if (f66559c == null) {
                        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                            f66559c = new com.bytedance.sdk.openadsdk.e.m(false);
                        } else {
                            f66559c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                        }
                    }
                }
            }
            return f66559c;
        }
        return (com.bytedance.sdk.openadsdk.e.b) invokeV.objValue;
    }

    public static com.bytedance.sdk.openadsdk.e.b<c.a> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (!com.bytedance.sdk.openadsdk.core.j.g.a()) {
                return com.bytedance.sdk.openadsdk.e.b.d();
            }
            if (f66558b == null) {
                synchronized (o.class) {
                    if (f66558b == null) {
                        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                            f66558b = new com.bytedance.sdk.openadsdk.e.m(true);
                        } else {
                            f66558b = a("ttad_bk_stats", "AdStatsEventThread", true);
                        }
                    }
                }
            }
            return f66558b;
        }
        return (com.bytedance.sdk.openadsdk.e.b) invokeV.objValue;
    }

    public static p<com.bytedance.sdk.openadsdk.e.a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f66560d == null) {
                synchronized (o.class) {
                    if (f66560d == null) {
                        f66560d = new q(f66563g);
                    }
                }
            }
            return f66560d;
        }
        return (p) invokeV.objValue;
    }

    public static com.bytedance.sdk.openadsdk.p.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (!com.bytedance.sdk.openadsdk.core.j.g.a()) {
                return com.bytedance.sdk.openadsdk.p.b.c();
            }
            if (f66561e == null) {
                synchronized (com.bytedance.sdk.openadsdk.p.a.class) {
                    if (f66561e == null) {
                        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                            f66561e = new com.bytedance.sdk.openadsdk.p.c();
                        } else {
                            f66561e = new com.bytedance.sdk.openadsdk.p.b(f66563g, new com.bytedance.sdk.openadsdk.p.g(f66563g));
                        }
                    }
                }
            }
            return f66561e;
        }
        return (com.bytedance.sdk.openadsdk.p.a) invokeV.objValue;
    }

    public static com.bytedance.sdk.openadsdk.core.j.h h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (f66564h == null) {
                synchronized (com.bytedance.sdk.openadsdk.core.j.h.class) {
                    if (f66564h == null) {
                        f66564h = new com.bytedance.sdk.openadsdk.core.j.h();
                    }
                }
            }
            return f66564h;
        }
        return (com.bytedance.sdk.openadsdk.core.j.h) invokeV.objValue;
    }

    public static com.bytedance.sdk.openadsdk.j.c.a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (!com.bytedance.sdk.openadsdk.core.j.g.a()) {
                return com.bytedance.sdk.openadsdk.j.c.c.c();
            }
            if (f66562f == null) {
                synchronized (com.bytedance.sdk.openadsdk.j.c.c.class) {
                    if (f66562f == null) {
                        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                            f66562f = new com.bytedance.sdk.openadsdk.j.c.d();
                        } else {
                            f66562f = new com.bytedance.sdk.openadsdk.j.c.c();
                        }
                    }
                }
            }
            return f66562f;
        }
        return (com.bytedance.sdk.openadsdk.j.c.a) invokeV.objValue;
    }

    public static void j() {
        AtomicBoolean atomicBoolean;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, null) == null) || (atomicBoolean = f66565i) == null) {
            return;
        }
        atomicBoolean.set(true);
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            AtomicBoolean atomicBoolean = f66565i;
            if (atomicBoolean != null) {
                return atomicBoolean.get();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static g.b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? g.b.a() : (g.b) invokeV.objValue;
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            synchronized (o.class) {
                if (f66563g == null) {
                    if (context != null) {
                        f66563g = context.getApplicationContext();
                    } else if (a.a() != null) {
                        try {
                            f66563g = a.a();
                            if (f66563g != null) {
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }

    public static g.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? new g.a(context) { // from class: com.bytedance.sdk.openadsdk.core.o.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f66566a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66566a = context;
            }

            @Override // com.bytedance.sdk.openadsdk.e.g.a
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    Context context2 = this.f66566a;
                    if (context2 == null) {
                        context2 = o.a();
                    }
                    return com.bytedance.sdk.component.utils.n.a(context2);
                }
                return invokeV.booleanValue;
            }
        } : (g.a) invokeL.objValue;
    }

    public static com.bytedance.sdk.openadsdk.e.b<c.a> a(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        g.b b2;
        com.bytedance.sdk.openadsdk.e.e lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, str, str2, z)) == null) {
            if (z) {
                lVar = new com.bytedance.sdk.openadsdk.e.n(f66563g);
                b2 = g.b.a();
            } else {
                b2 = g.b.b();
                lVar = new com.bytedance.sdk.openadsdk.e.l(f66563g);
            }
            g.a b3 = b(f66563g);
            return new com.bytedance.sdk.openadsdk.e.b<>(lVar, null, b2, b3, new com.bytedance.sdk.openadsdk.e.o(str, str2, lVar, null, b2, b3));
        }
        return (com.bytedance.sdk.openadsdk.e.b) invokeLLZ.objValue;
    }
}
