package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f30342a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile TTCustomController f30343b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f30344c;

    /* renamed from: d  reason: collision with root package name */
    public static int f30345d;

    /* renamed from: e  reason: collision with root package name */
    public static AtomicBoolean f30346e;

    /* renamed from: f  reason: collision with root package name */
    public static AtomicBoolean f30347f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile HandlerThread f30348g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile Handler f30349h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Handler f30350i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(210334858, "Lcom/bytedance/sdk/openadsdk/core/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(210334858, "Lcom/bytedance/sdk/openadsdk/core/l;");
                return;
            }
        }
        f30348g = new HandlerThread("tt_pangle_thread_init", 10);
        f30348g.start();
        f30350i = new Handler(f30348g.getLooper());
        f30344c = false;
        f30345d = -1;
        f30346e = new AtomicBoolean(false);
        f30347f = new AtomicBoolean(false);
    }

    public l() {
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

    public static void a() {
        Context a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            f30346e.set(true);
            f30347f.set(true);
            if (o.h().e() && (a2 = o.a()) != null) {
                try {
                    com.bytedance.sdk.openadsdk.l.e.b().c().tryInitTTAdNet(a2, com.bytedance.sdk.openadsdk.multipro.b.b(), true, new com.bytedance.sdk.openadsdk.l.d(a2));
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            if (com.bytedance.sdk.openadsdk.r.d.g() == 0) {
                com.bytedance.sdk.openadsdk.r.d.b(System.currentTimeMillis());
            }
            long g2 = com.bytedance.sdk.openadsdk.r.d.g();
            long currentTimeMillis = System.currentTimeMillis();
            String b2 = com.bytedance.sdk.openadsdk.r.o.b(g2, currentTimeMillis);
            long h2 = com.bytedance.sdk.openadsdk.r.d.h();
            com.bytedance.sdk.openadsdk.k.a.a().a(b2, ((currentTimeMillis - h2) / 1000) + "");
            com.bytedance.sdk.openadsdk.r.d.c(System.currentTimeMillis());
        }
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            com.bytedance.sdk.openadsdk.n.a.c(context);
        }
    }

    public static Handler d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f30349h == null) {
                synchronized (l.class) {
                    if (f30349h == null) {
                        f30349h = new Handler(Looper.getMainLooper());
                    }
                }
            }
            return f30349h;
        }
        return (Handler) invokeV.objValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, null) == null) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(invoke, true);
        } catch (Throwable unused) {
        }
    }

    public static Handler c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f30348g == null || !f30348g.isAlive()) {
                synchronized (l.class) {
                    if (f30348g == null || !f30348g.isAlive()) {
                        f30348g = new HandlerThread("tt_pangle_thread_init", 10);
                        f30348g.start();
                        f30350i = new Handler(f30348g.getLooper());
                    }
                }
            }
            return f30350i;
        }
        return (Handler) invokeV.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            e();
            c(context);
            com.bytedance.sdk.openadsdk.r.m.a();
            com.bytedance.sdk.openadsdk.r.q.a(context);
            b(context);
            o.i().a();
            String a2 = j.a(context);
            if (!TextUtils.isEmpty(a2)) {
                o.g().a(a2);
            }
            com.bytedance.sdk.openadsdk.n.a.b(a2);
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a();
            com.bytedance.sdk.openadsdk.core.h.a.a().b();
            a();
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context) == null) {
            c.a(context).a("uuid", UUID.randomUUID().toString());
        }
    }
}
