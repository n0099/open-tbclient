package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.r.a;
import com.bytedance.sdk.openadsdk.r.b;
import com.bytedance.sdk.openadsdk.r.o;
import com.bytedance.sdk.openadsdk.r.q;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.a.a.c.i;
import d.l.a.a.a.f.a;
import d.l.a.d.b.c;
import d.l.a.d.h;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f31052a;

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicBoolean f31053b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f31054c;

    /* renamed from: d  reason: collision with root package name */
    public static Map<Integer, a.InterfaceC0348a> f31055d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f31056e;

    /* renamed from: f  reason: collision with root package name */
    public static d.l.a.a.a.d.a.a f31057f;
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
        f31053b = new AtomicBoolean(false);
        f31056e = true;
        f31057f = new d.l.a.a.a.d.a.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.1
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

            @Override // d.l.a.a.a.d.a.a
            public void a(@NonNull d.l.a.a.a.d.d dVar, @Nullable d.l.a.a.a.d.b bVar, @Nullable d.l.a.a.a.d.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, dVar, bVar, cVar) == null) {
                    j.b("LibHolder", "completeListener: onDownloadStart");
                }
            }

            @Override // d.l.a.a.a.d.a.a
            public void b(@Nullable DownloadInfo downloadInfo, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048580, this, downloadInfo, str) == null) {
                    j.b("LibHolder", "completeListener: onInstalled");
                    g.b(str);
                }
            }

            @Override // d.l.a.a.a.d.a.a
            public void a(@NonNull DownloadInfo downloadInfo, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, str) == null) {
                    j.b("LibHolder", "completeListener: onDownloadFinished");
                }
            }

            @Override // d.l.a.a.a.d.a.a
            public void a(@NonNull DownloadInfo downloadInfo, BaseException baseException, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo, baseException, str) == null) {
                    j.b("LibHolder", "completeListener: onDownloadFailed");
                }
            }

            @Override // d.l.a.a.a.d.a.a
            public void a(@NonNull DownloadInfo downloadInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, downloadInfo) == null) {
                    j.b("LibHolder", "completeListener: onCanceled");
                }
            }
        };
        try {
            f31052a = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
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
        d.l.a.b.a.c.b d2;
        JSONObject g2;
        JSONObject optJSONObject;
        com.bytedance.sdk.openadsdk.downloadnew.a.b.a a2;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            if (!q.a()) {
                j.b("LibHolder", "锁屏不执行自启动调起");
            } else if (TextUtils.isEmpty(str) || (d2 = c.g.e().d(str)) == null || (g2 = d2.g()) == null || (optJSONObject = g2.optJSONObject("open_ad_sdk_download_extra")) == null || (a2 = com.bytedance.sdk.openadsdk.downloadnew.a.b.a.a(optJSONObject)) == null || (mVar = a2.f31014a) == null) {
            } else {
                a(str, mVar);
            }
        }
    }

    public static void c(m mVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65560, null, mVar, str) == null) && mVar != null && o.a(g(), str)) {
            j.b("LibHolder", "通过包名调起 " + str);
        }
    }

    public static h d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            a(com.bytedance.sdk.openadsdk.core.o.a());
            return h.b(g());
        }
        return (h) invokeV.objValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, null) == null) {
            d().r();
            if (TextUtils.isEmpty(f31052a)) {
                return;
            }
            com.bytedance.sdk.component.utils.f.c(new File(f31052a));
        }
    }

    public static Context g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            Context context = f31054c;
            return context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context;
        }
        return (Context) invokeV.objValue;
    }

    @Nullable
    public static Map<Integer, a.InterfaceC0348a> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? f31055d : (Map) invokeV.objValue;
    }

    @NonNull
    public static JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            com.bytedance.sdk.openadsdk.core.j.h h2 = com.bytedance.sdk.openadsdk.core.o.h();
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
        if (!(interceptable == null || interceptable.invokeV(65559, null) == null) || (h2 = com.bytedance.sdk.openadsdk.core.o.h()) == null || f31056e == (w = h2.w())) {
            return;
        }
        f31056e = w;
        a();
    }

    public static void a(String str, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, mVar) == null) {
            try {
                if (g() != null && !TextUtils.isEmpty(str) && mVar != null && mVar.n()) {
                    com.bytedance.sdk.openadsdk.core.e.g an = mVar.an();
                    if (an != null && !TextUtils.isEmpty(an.a())) {
                        j.f("LibHolder", "含有deepLink");
                        if (mVar.y() != 0) {
                            j.f("LibHolder", "deepLink过滤 mMeta.getDownConfigAutoOpen() " + mVar.y());
                            return;
                        }
                    }
                    if (mVar.n()) {
                        if (com.bytedance.sdk.openadsdk.n.a.a(str)) {
                            j.f("LibHolder", "该app已被激活 pkgName " + str);
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
        com.bytedance.sdk.openadsdk.r.a c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65554, null, mVar, str) == null) || a(mVar) || (c2 = com.bytedance.sdk.openadsdk.core.h.d().c()) == null) {
            return;
        }
        c2.a(new a.InterfaceC0367a(c2, str, mVar, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.r.a f31058a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f31059b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ m f31060c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ long f31061d;

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
                this.f31058a = c2;
                this.f31059b = str;
                this.f31060c = mVar;
                this.f31061d = r9;
            }

            @Override // com.bytedance.sdk.openadsdk.r.a.InterfaceC0367a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (!q.a()) {
                        j.b("LibHolder", "锁屏不执行自启动调起");
                        com.bytedance.sdk.openadsdk.r.a aVar = this.f31058a;
                        if (aVar != null) {
                            aVar.b();
                            return;
                        }
                        return;
                    }
                    if (!com.bytedance.sdk.openadsdk.n.a.a(this.f31059b)) {
                        g.b(this.f31060c, this.f31061d, this.f31058a, this.f31059b);
                    }
                    com.bytedance.sdk.openadsdk.r.a aVar2 = this.f31058a;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.a.InterfaceC0367a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.a.InterfaceC0367a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.a.InterfaceC0367a
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.a.InterfaceC0367a
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.a.InterfaceC0367a
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                }
            }
        });
    }

    public static void b(m mVar, long j, com.bytedance.sdk.openadsdk.r.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{mVar, Long.valueOf(j), aVar, str}) == null) || mVar == null) {
            return;
        }
        if (System.currentTimeMillis() - j >= mVar.r() * 1000) {
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
                if ((TextUtils.isEmpty(mVar.ax()) || X != 4) && !com.bytedance.sdk.openadsdk.r.d.f()) {
                    return false;
                }
                com.bytedance.sdk.openadsdk.r.d.a(false);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(com.bytedance.sdk.openadsdk.r.a aVar, m mVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65555, null, aVar, mVar, str, str2, str3) == null) || aVar == null) {
            return;
        }
        if (!o.c(g(), str3)) {
            j.b("LibHolder", "该app未安装 packageName " + str3);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String ak = mVar.ak();
        com.bytedance.sdk.openadsdk.r.b.a(g(), ak, str, str2, "立即打开", "退出", new b.a(mVar, str3, aVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ m f31067a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f31068b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.r.a f31069c;

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
                this.f31067a = mVar;
                this.f31068b = str3;
                this.f31069c = aVar;
            }

            @Override // com.bytedance.sdk.openadsdk.r.b.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    g.c(this.f31067a, this.f31068b);
                    com.bytedance.sdk.openadsdk.r.a aVar2 = this.f31069c;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.b.a
            public void b() {
                com.bytedance.sdk.openadsdk.r.a aVar2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar2 = this.f31069c) == null) {
                    return;
                }
                aVar2.b();
            }

            @Override // com.bytedance.sdk.openadsdk.r.b.a
            public void c() {
                com.bytedance.sdk.openadsdk.r.a aVar2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar2 = this.f31069c) == null) {
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
        com.bytedance.sdk.openadsdk.r.a c3 = com.bytedance.sdk.openadsdk.core.h.d().c();
        if (c3 == null) {
            return;
        }
        c3.a(new a.InterfaceC0367a(c3, str, mVar, c2, str2) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.r.a f31062a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f31063b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ m f31064c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f31065d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f31066e;

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
                this.f31062a = c3;
                this.f31063b = str;
                this.f31064c = mVar;
                this.f31065d = c2;
                this.f31066e = str2;
            }

            @Override // com.bytedance.sdk.openadsdk.r.a.InterfaceC0367a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        if (!q.a()) {
                            j.b("LibHolder", "锁屏不执行自启动调起");
                            if (this.f31062a != null) {
                                this.f31062a.b();
                                return;
                            }
                            return;
                        }
                        if (!com.bytedance.sdk.openadsdk.n.a.a(this.f31063b)) {
                            g.b(this.f31062a, this.f31064c, this.f31065d, this.f31066e, this.f31063b);
                        }
                        if (this.f31062a != null) {
                            this.f31062a.b();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.a.InterfaceC0367a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.a.InterfaceC0367a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.a.InterfaceC0367a
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.a.InterfaceC0367a
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.a.InterfaceC0367a
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
                return com.bytedance.sdk.openadsdk.core.g.d.a().a(g(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
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
            d.l.a.a.a.b a2 = h.b(applicationContext).a();
            if (a2 == null) {
                return false;
            }
            a.C2043a c2043a = new a.C2043a();
            c2043a.d("143");
            c2043a.a("open_news");
            c2043a.f("3.6.1.3");
            c2043a.h(String.valueOf(3613));
            d.l.a.a.a.f.a b2 = c2043a.b();
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

                @Override // d.l.a.a.a.c.i
                public JSONObject a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? g.i() : (JSONObject) invokeV.objValue;
                }
            });
            a2.g(new com.bytedance.sdk.openadsdk.downloadnew.a.a.a(applicationContext));
            a2.i(b2);
            a2.h(new d.l.a.a.a.c.q() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.5
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

                @Override // d.l.a.a.a.c.q
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
            h.b(applicationContext).f(f31057f);
            d.l.a.e.a.e.G().o(new d.l.a.e.b.f.h() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.7
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

                @Override // d.l.a.e.b.f.h
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
                context = com.bytedance.sdk.openadsdk.core.o.a();
            }
            if (context == null || f31053b.get()) {
                return;
            }
            synchronized (g.class) {
                if (!f31053b.get()) {
                    f31054c = context.getApplicationContext();
                    a();
                    f31053b.set(b(f31054c));
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
                if (f31056e && !b()) {
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
                    f31052a = str;
                    com.bytedance.sdk.openadsdk.r.e.a();
                }
                j.b("LibHolder", "path: " + String.valueOf(f31052a));
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(int i2) {
        Map<Integer, a.InterfaceC0348a> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65540, null, i2) == null) || (map = f31055d) == null) {
            return;
        }
        map.remove(Integer.valueOf(i2));
    }

    public static void a(int i2, a.InterfaceC0348a interfaceC0348a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, interfaceC0348a) == null) || interfaceC0348a == null) {
            return;
        }
        if (f31055d == null) {
            f31055d = Collections.synchronizedMap(new WeakHashMap());
        }
        f31055d.put(Integer.valueOf(i2), interfaceC0348a);
    }

    public static boolean a(String str, String str2, m mVar, Object obj) {
        InterceptResult invokeLLLL;
        Map<Integer, a.InterfaceC0348a> h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65551, null, str, str2, mVar, obj)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && mVar != null && (h2 = h()) != null) {
                for (Map.Entry<Integer, a.InterfaceC0348a> entry : h2.entrySet()) {
                    int intValue = entry.getKey().intValue();
                    a.InterfaceC0348a value = entry.getValue();
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
                List<DownloadInfo> w = d.l.a.e.a.e.G().w(context);
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

    public static d.l.a.e.b.g.b a(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, jSONObject)) == null) {
            int optInt = jSONObject.optInt("download_exp_switch_temp", 1040187391);
            d.l.a.e.b.g.b bVar = new d.l.a.e.b.g.b(context);
            bVar.d(new d.l.a.e.b.f.e() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.8
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

                @Override // d.l.a.e.b.f.e
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
        return (d.l.a.e.b.g.b) invokeLL.objValue;
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
