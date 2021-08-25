package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.p.a.a.a.c.i;
import c.p.a.a.a.f.a;
import c.p.a.d.b.c;
import c.p.a.d.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.q.a;
import com.bytedance.sdk.openadsdk.q.c;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.q.s;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f67484a;

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicBoolean f67485b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f67486c;

    /* renamed from: d  reason: collision with root package name */
    public static Map<Integer, a.InterfaceC1916a> f67487d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f67488e;

    /* renamed from: f  reason: collision with root package name */
    public static c.p.a.a.a.d.a.a f67489f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1291766194, "Lcom/bytedance/sdk/openadsdk/downloadnew/a/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1291766194, "Lcom/bytedance/sdk/openadsdk/downloadnew/a/g;");
                return;
            }
        }
        f67485b = new AtomicBoolean(false);
        f67488e = true;
        f67489f = new c.p.a.a.a.d.a.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.p.a.a.a.d.a.a
            public void a(@NonNull c.p.a.a.a.d.d dVar, @Nullable c.p.a.a.a.d.b bVar, @Nullable c.p.a.a.a.d.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, dVar, bVar, cVar) == null) {
                    k.b("LibHolder", "completeListener: onDownloadStart");
                }
            }

            @Override // c.p.a.a.a.d.a.a
            public void b(@Nullable DownloadInfo downloadInfo, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048580, this, downloadInfo, str) == null) {
                    k.b("LibHolder", "completeListener: onInstalled");
                    g.b(str);
                }
            }

            @Override // c.p.a.a.a.d.a.a
            public void a(@NonNull DownloadInfo downloadInfo, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048579, this, downloadInfo, str) == null) {
                    k.b("LibHolder", "completeListener: onDownloadFinished");
                }
            }

            @Override // c.p.a.a.a.d.a.a
            public void a(@NonNull DownloadInfo downloadInfo, BaseException baseException, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, baseException, str) == null) {
                    k.b("LibHolder", "completeListener: onDownloadFailed");
                }
            }

            @Override // c.p.a.a.a.d.a.a
            public void a(@NonNull DownloadInfo downloadInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                    k.b("LibHolder", "completeListener: onCanceled");
                }
            }
        };
        try {
            f67484a = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
    }

    public g() {
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

    public static void b(String str) {
        c.p.a.b.a.c.b d2;
        JSONObject g2;
        JSONObject optJSONObject;
        com.bytedance.sdk.openadsdk.downloadnew.a.b.a a2;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            if (!s.a()) {
                k.b("LibHolder", "锁屏不执行自启动调起");
            } else if (TextUtils.isEmpty(str) || (d2 = c.g.e().d(str)) == null || (g2 = d2.g()) == null || (optJSONObject = g2.optJSONObject("open_ad_sdk_download_extra")) == null || (a2 = com.bytedance.sdk.openadsdk.downloadnew.a.b.a.a(optJSONObject)) == null || (mVar = a2.f67445a) == null) {
            } else {
                a(str, mVar);
            }
        }
    }

    public static void c(m mVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65560, null, mVar, str) == null) && mVar != null && q.a(g(), str)) {
            k.b("LibHolder", "通过包名调起 " + str);
        }
    }

    public static h d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            a(o.a());
            return h.b(g());
        }
        return (h) invokeV.objValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, null) == null) {
            d().r();
            if (TextUtils.isEmpty(f67484a)) {
                return;
            }
            com.bytedance.sdk.component.utils.f.c(new File(f67484a));
        }
    }

    public static Context g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            Context context = f67486c;
            return context == null ? o.a() : context;
        }
        return (Context) invokeV.objValue;
    }

    @Nullable
    public static Map<Integer, a.InterfaceC1916a> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? f67487d : (Map) invokeV.objValue;
    }

    @NonNull
    public static JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            com.bytedance.sdk.openadsdk.core.j.h h2 = o.h();
            if (h2 != null && h2.q() != null) {
                return h2.q();
            }
            return new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    public static void c() {
        com.bytedance.sdk.openadsdk.core.j.h h2;
        boolean w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, null) == null) || (h2 = o.h()) == null || f67488e == (w = h2.w())) {
            return;
        }
        f67488e = w;
        a();
    }

    public static void a(String str, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, mVar) == null) {
            try {
                if (g() != null && !TextUtils.isEmpty(str) && mVar != null && mVar.n()) {
                    com.bytedance.sdk.openadsdk.core.e.g an = mVar.an();
                    if (an != null && !TextUtils.isEmpty(an.a())) {
                        k.f("LibHolder", "含有deepLink");
                        if (mVar.y() != 0) {
                            k.f("LibHolder", "deepLink过滤 mMeta.getDownConfigAutoOpen() " + mVar.y());
                            return;
                        }
                    }
                    if (mVar.n()) {
                        if (com.bytedance.sdk.openadsdk.m.a.a(str)) {
                            k.f("LibHolder", "该app已被激活 pkgName " + str);
                        } else if (!mVar.p()) {
                            b(mVar, str);
                        } else {
                            a(g(), mVar, str);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(m mVar, String str) {
        com.bytedance.sdk.openadsdk.q.a c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65554, null, mVar, str) == null) || a(mVar) || (c2 = com.bytedance.sdk.openadsdk.core.h.d().c()) == null) {
            return;
        }
        c2.a(new a.InterfaceC1933a(c2, str, mVar, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.q.a f67490a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f67491b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ m f67492c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f67493d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2, str, mVar, Long.valueOf(r9)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67490a = c2;
                this.f67491b = str;
                this.f67492c = mVar;
                this.f67493d = r9;
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC1933a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (!s.a()) {
                        k.b("LibHolder", "锁屏不执行自启动调起");
                        com.bytedance.sdk.openadsdk.q.a aVar = this.f67490a;
                        if (aVar != null) {
                            aVar.b();
                            return;
                        }
                        return;
                    }
                    if (!com.bytedance.sdk.openadsdk.m.a.a(this.f67491b)) {
                        g.b(this.f67492c, this.f67493d, this.f67490a, this.f67491b);
                    }
                    com.bytedance.sdk.openadsdk.q.a aVar2 = this.f67490a;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC1933a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC1933a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC1933a
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC1933a
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC1933a
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                }
            }
        });
    }

    public static void b(m mVar, long j2, com.bytedance.sdk.openadsdk.q.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{mVar, Long.valueOf(j2), aVar, str}) == null) || mVar == null) {
            return;
        }
        if (System.currentTimeMillis() - j2 >= mVar.r() * 1000) {
            String c2 = mVar.al() != null ? mVar.al().c() : "";
            b(aVar, mVar, c2, TextUtils.isEmpty(c2) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？", str);
            return;
        }
        c(mVar, str);
    }

    public static boolean a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, mVar)) == null) {
            if (mVar != null && a(i())) {
                int X = mVar.X();
                if ((TextUtils.isEmpty(mVar.ax()) || X != 4) && !com.bytedance.sdk.openadsdk.q.e.f()) {
                    return false;
                }
                com.bytedance.sdk.openadsdk.q.e.a(false);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(com.bytedance.sdk.openadsdk.q.a aVar, m mVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65555, null, aVar, mVar, str, str2, str3) == null) || aVar == null) {
            return;
        }
        if (!q.c(g(), str3)) {
            k.b("LibHolder", "该app未安装 packageName " + str3);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String ak = mVar.ak();
        com.bytedance.sdk.openadsdk.q.c.a(g(), ak, str, str2, "立即打开", "退出", new c.a(mVar, str3, aVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ m f67499a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f67500b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.q.a f67501c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, str3, aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67499a = mVar;
                this.f67500b = str3;
                this.f67501c = aVar;
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    g.c(this.f67499a, this.f67500b);
                    com.bytedance.sdk.openadsdk.q.a aVar2 = this.f67501c;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void b() {
                com.bytedance.sdk.openadsdk.q.a aVar2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar2 = this.f67501c) == null) {
                    return;
                }
                aVar2.b();
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void c() {
                com.bytedance.sdk.openadsdk.q.a aVar2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar2 = this.f67501c) == null) {
                    return;
                }
                aVar2.b();
            }
        });
    }

    public static void a(Context context, m mVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, null, context, mVar, str) == null) || context == null || mVar == null || a(mVar)) {
            return;
        }
        String c2 = mVar.al() != null ? mVar.al().c() : "";
        String str2 = TextUtils.isEmpty(c2) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？";
        com.bytedance.sdk.openadsdk.q.a c3 = com.bytedance.sdk.openadsdk.core.h.d().c();
        if (c3 == null) {
            return;
        }
        c3.a(new a.InterfaceC1933a(c3, str, mVar, c2, str2) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.q.a f67494a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f67495b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ m f67496c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f67497d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f67498e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c3, str, mVar, c2, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67494a = c3;
                this.f67495b = str;
                this.f67496c = mVar;
                this.f67497d = c2;
                this.f67498e = str2;
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC1933a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        if (!s.a()) {
                            k.b("LibHolder", "锁屏不执行自启动调起");
                            if (this.f67494a != null) {
                                this.f67494a.b();
                                return;
                            }
                            return;
                        }
                        if (!com.bytedance.sdk.openadsdk.m.a.a(this.f67495b)) {
                            g.b(this.f67494a, this.f67496c, this.f67497d, this.f67498e, this.f67495b);
                        }
                        if (this.f67494a != null) {
                            this.f67494a.b();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC1933a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC1933a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC1933a
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC1933a
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.a.InterfaceC1933a
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                }
            }
        });
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return com.bytedance.sdk.openadsdk.core.g.d.a().a(g(), "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            if (context == null) {
                return false;
            }
            Context applicationContext = context.getApplicationContext();
            String packageName = applicationContext.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                packageName = "";
            }
            c.p.a.a.a.b a2 = h.b(applicationContext).a();
            if (a2 == null) {
                return false;
            }
            a.C1518a c1518a = new a.C1518a();
            c1518a.d("143");
            c1518a.a("open_news");
            c1518a.f("3.7.0.3");
            c1518a.h(String.valueOf(3703));
            c.p.a.a.a.f.a b2 = c1518a.b();
            a2.c(new com.bytedance.sdk.openadsdk.downloadnew.a.a.d(applicationContext));
            a2.a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.b(applicationContext));
            a2.e(new com.bytedance.sdk.openadsdk.downloadnew.a.a.e(applicationContext));
            a2.b(new com.bytedance.sdk.openadsdk.downloadnew.a.a.c(applicationContext));
            a2.d(new i() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // c.p.a.a.a.c.i
                public JSONObject a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? g.i() : (JSONObject) invokeV.objValue;
                }
            });
            a2.g(new com.bytedance.sdk.openadsdk.downloadnew.a.a.a(applicationContext));
            a2.i(b2);
            a2.h(new c.p.a.a.a.c.q() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // c.p.a.a.a.c.q
                public byte[] a(byte[] bArr, int i2) {
                    InterceptResult invokeLI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, bArr, i2)) == null) ? EncryptorUtil.a(bArr, i2) : (byte[]) invokeLI.objValue;
                }
            });
            a2.a(packageName + ".TTFileProvider");
            a2.f(a(applicationContext, i()));
            a2.a();
            h.g.c();
            h.b(applicationContext).o().a(1);
            h.b(applicationContext).f(f67489f);
            c.p.a.e.a.e.G().o(new c.p.a.e.b.f.i() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // c.p.a.e.b.f.i
                public boolean a(Intent intent) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, intent)) == null) {
                        return false;
                    }
                    return invokeL2.booleanValue;
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            if (context == null) {
                context = o.a();
            }
            if (context == null || f67485b.get()) {
                return;
            }
            synchronized (g.class) {
                if (!f67485b.get()) {
                    f67486c = context.getApplicationContext();
                    a();
                    f67485b.set(b(f67486c));
                }
            }
        }
    }

    public static void a() {
        File externalFilesDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            String str = null;
            try {
                if (f67488e && !b()) {
                    File file = new File(g().getCacheDir(), Environment.DIRECTORY_DOWNLOADS);
                    file.mkdirs();
                    str = file.getPath();
                }
                if (TextUtils.isEmpty(str)) {
                    if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = g().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)) != null) {
                        str = externalFilesDir.getPath();
                    }
                    if (TextUtils.isEmpty(str)) {
                        File file2 = new File(g().getFilesDir(), Environment.DIRECTORY_DOWNLOADS);
                        file2.mkdirs();
                        str = file2.getPath();
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    f67484a = str;
                    com.bytedance.sdk.openadsdk.q.f.a();
                }
                k.b("LibHolder", "path: " + String.valueOf(f67484a));
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(int i2) {
        Map<Integer, a.InterfaceC1916a> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2) == null) || (map = f67487d) == null) {
            return;
        }
        map.remove(Integer.valueOf(i2));
    }

    public static void a(int i2, a.InterfaceC1916a interfaceC1916a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, interfaceC1916a) == null) || interfaceC1916a == null) {
            return;
        }
        if (f67487d == null) {
            f67487d = Collections.synchronizedMap(new WeakHashMap());
        }
        f67487d.put(Integer.valueOf(i2), interfaceC1916a);
    }

    public static boolean a(String str, String str2, m mVar, Object obj) {
        InterceptResult invokeLLLL;
        Map<Integer, a.InterfaceC1916a> h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65551, null, str, str2, mVar, obj)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && mVar != null && (h2 = h()) != null) {
                for (Map.Entry<Integer, a.InterfaceC1916a> entry : h2.entrySet()) {
                    int intValue = entry.getKey().intValue();
                    a.InterfaceC1916a value = entry.getValue();
                    if (value != null) {
                        boolean a2 = value.a(intValue, mVar, str, str2, obj);
                        if (!z && !a2) {
                            z = true;
                        }
                    }
                }
            }
            return z;
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                List<DownloadInfo> w = c.p.a.e.a.e.G().w(context);
                if (!w.isEmpty()) {
                    for (DownloadInfo downloadInfo : w) {
                        if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static c.p.a.e.b.g.b a(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, jSONObject)) == null) {
            int optInt = jSONObject.optInt("download_exp_switch_temp", 1040187391);
            c.p.a.e.b.g.b bVar = new c.p.a.e.b.g.b(context);
            bVar.d(new c.p.a.e.b.f.f() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // c.p.a.e.b.f.f
                public JSONObject a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? g.i() : (JSONObject) invokeV.objValue;
                }
            });
            bVar.c(optInt);
            bVar.E(new com.bytedance.sdk.openadsdk.downloadnew.a.a.f(context));
            return bVar;
        }
        return (c.p.a.e.b.g.b) invokeLL.objValue;
    }

    public static boolean a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            return jSONObject.optInt("enable_open_app_dialog") == 1;
        }
        return invokeL.booleanValue;
    }
}
