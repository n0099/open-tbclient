package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.executor.DownloadExecutor;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.e.u;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static File f67041a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f67042b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f67043c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f67044d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67045e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f67046f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicLong f67047g;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67043c = new AtomicBoolean(true);
        this.f67044d = new AtomicBoolean(false);
        this.f67045e = false;
        this.f67046f = new AtomicInteger(0);
        this.f67047g = new AtomicLong();
        f();
    }

    public static File e() {
        InterceptResult invokeV;
        File externalCacheDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f67041a == null) {
                try {
                    if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && o.a().getExternalCacheDir() != null) {
                        externalCacheDir = o.a().getExternalCacheDir();
                    } else {
                        externalCacheDir = o.a().getCacheDir();
                    }
                    File file = new File(new File(externalCacheDir, "tt_tmpl_pkg"), MediaTrackConfig.AE_IMPORT_TEMPLATE);
                    file.mkdirs();
                    f67041a = file;
                } catch (Throwable th) {
                    k.c("TemplateManager", "getTemplateDir error", th);
                }
            }
            return f67041a;
        }
        return (File) invokeV.objValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            com.bytedance.sdk.component.d.e.a(new g(this, "init") { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f67048a;

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
                    this.f67048a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        f.a();
                        this.f67048a.f67043c.set(false);
                        this.f67048a.g();
                        this.f67048a.d();
                        l.d().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.b.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f67049a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f67049a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.bytedance.sdk.openadsdk.core.widget.webview.b.b().c();
                                }
                            }
                        });
                    }
                }
            }, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            k.b("TemplateManager", "check template usable1");
            u b2 = f.b();
            if (b2 != null && b2.f()) {
                boolean z = true;
                for (u.a aVar : b2.e()) {
                    String a2 = aVar.a();
                    File file = new File(e(), com.bytedance.sdk.component.utils.e.a(a2));
                    String a3 = com.bytedance.sdk.component.utils.e.a(file);
                    if (!file.exists() || !file.isFile() || aVar.b() == null || !aVar.b().equals(a3)) {
                        z = false;
                        k.b("TemplateManager", "check template usable3: " + a2 + "," + file.getAbsolutePath());
                        break;
                    }
                    while (r1.hasNext()) {
                    }
                }
                if (!z) {
                    f.d();
                }
                k.b("TemplateManager", "check template usable4: " + z);
                this.f67045e = z;
                return;
            }
            k.b("TemplateManager", "check template usable2");
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || this.f67046f.getAndSet(0) <= 0 || System.currentTimeMillis() - this.f67047g.get() <= TTAdConstant.AD_MAX_EVENT_TIME) {
            return;
        }
        d();
    }

    public u c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f.b() : (u) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a(false);
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f67042b == null) {
                synchronized (b.class) {
                    if (f67042b == null) {
                        f67042b = new b();
                    }
                }
            }
            return f67042b;
        }
        return (b) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67045e : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0135 A[Catch: all -> 0x0257, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0257, blocks: (B:8:0x0014, B:11:0x001e, B:12:0x0023, B:14:0x0038, B:16:0x004d, B:19:0x0055, B:21:0x005f, B:24:0x0075, B:25:0x0081, B:27:0x008d, B:30:0x0099, B:32:0x00a3, B:54:0x0129, B:55:0x012d, B:58:0x0135, B:61:0x0169, B:64:0x0172, B:66:0x0192, B:68:0x0198, B:70:0x019e, B:73:0x01a9, B:74:0x01b7, B:76:0x01c5, B:77:0x01d0, B:79:0x01d6, B:82:0x020a, B:86:0x0214, B:33:0x00b1, B:34:0x00b9, B:36:0x00bf, B:38:0x00cf, B:39:0x00d3, B:41:0x00dd, B:43:0x00e3, B:45:0x00f1, B:46:0x00f5, B:47:0x00fd, B:49:0x0103, B:51:0x0113, B:52:0x0117, B:53:0x011d, B:87:0x0247), top: B:103:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d6 A[Catch: all -> 0x0257, TRY_LEAVE, TryCatch #2 {all -> 0x0257, blocks: (B:8:0x0014, B:11:0x001e, B:12:0x0023, B:14:0x0038, B:16:0x004d, B:19:0x0055, B:21:0x005f, B:24:0x0075, B:25:0x0081, B:27:0x008d, B:30:0x0099, B:32:0x00a3, B:54:0x0129, B:55:0x012d, B:58:0x0135, B:61:0x0169, B:64:0x0172, B:66:0x0192, B:68:0x0198, B:70:0x019e, B:73:0x01a9, B:74:0x01b7, B:76:0x01c5, B:77:0x01d0, B:79:0x01d6, B:82:0x020a, B:86:0x0214, B:33:0x00b1, B:34:0x00b9, B:36:0x00bf, B:38:0x00cf, B:39:0x00d3, B:41:0x00dd, B:43:0x00e3, B:45:0x00f1, B:46:0x00f5, B:47:0x00fd, B:49:0x0103, B:51:0x0113, B:52:0x0117, B:53:0x011d, B:87:0x0247), top: B:103:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (this.f67043c.get()) {
                k.b("TemplateManager", "loadTemplate error1");
                return;
            }
            try {
                if (this.f67044d.get()) {
                    if (z) {
                        this.f67046f.getAndIncrement();
                    }
                    k.b("TemplateManager", "loadTemplate error2: " + z);
                    return;
                }
                this.f67044d.set(true);
                u a2 = o.f().a();
                u b2 = f.b();
                if (a2 != null && a2.f()) {
                    boolean b3 = f.b(a2.b());
                    if (!b3) {
                        this.f67044d.set(false);
                        this.f67047g.set(System.currentTimeMillis());
                        k.b("TemplateManager", "loadTemplate error4");
                        return;
                    }
                    if (b3) {
                        l.d().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.b.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ b f67050a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f67050a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    com.bytedance.sdk.openadsdk.core.widget.webview.f.a().c();
                                }
                            }
                        });
                    }
                    ArrayList<u.a> arrayList = new ArrayList();
                    ArrayList<u.a> arrayList2 = new ArrayList();
                    if (b2 != null && !b2.e().isEmpty()) {
                        if (a2.e().isEmpty()) {
                            arrayList.addAll(b2.e());
                            k.b("TemplateManager", "loadTemplate update2");
                        } else {
                            for (u.a aVar : a2.e()) {
                                if (!b2.e().contains(aVar)) {
                                    arrayList2.add(aVar);
                                } else {
                                    u.a a3 = f.a(aVar.a());
                                    if (a3 != null && aVar.b() != null && !aVar.b().equals(a3.b())) {
                                        arrayList2.add(aVar);
                                    }
                                }
                            }
                            for (u.a aVar2 : b2.e()) {
                                if (!a2.e().contains(aVar2)) {
                                    arrayList.add(aVar2);
                                }
                            }
                            k.b("TemplateManager", "loadTemplate update3");
                        }
                        for (u.a aVar3 : arrayList2) {
                            String a4 = aVar3.a();
                            String a5 = com.bytedance.sdk.component.utils.e.a(a4);
                            File file = new File(e(), a5);
                            File file2 = new File(file + ".tmp");
                            if (file.exists()) {
                                try {
                                    file.delete();
                                } catch (Throwable unused) {
                                }
                            }
                            if (file2.exists()) {
                                try {
                                    file2.delete();
                                } catch (Throwable unused2) {
                                }
                            }
                            DownloadExecutor downloadExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getDownloadExecutor();
                            downloadExecutor.setUrl(a4);
                            downloadExecutor.setFileInfo(e().getAbsolutePath(), a5);
                            NetResponse execute = downloadExecutor.execute();
                            if (execute != null && execute.isSuccess() && execute.getFile() != null && execute.getFile().exists()) {
                                k.a("TemplateManager", "loadTemplate success ulr=", a4);
                            }
                            this.f67044d.set(false);
                            a(arrayList2);
                            k.b("TemplateManager", "loadTemplate error5");
                            return;
                        }
                        a(a2.d());
                        for (u.a aVar4 : arrayList) {
                            File file3 = new File(e(), com.bytedance.sdk.component.utils.e.a(aVar4.a()));
                            File file4 = new File(file3 + ".tmp");
                            if (file3.exists()) {
                                try {
                                    file3.delete();
                                } catch (Throwable unused3) {
                                }
                            }
                            if (file4.exists()) {
                                try {
                                    file4.delete();
                                } catch (Throwable unused4) {
                                }
                            }
                        }
                        f.a(a2);
                        f.c();
                        k.b("TemplateManager", "loadTemplate update success: " + a2.b());
                        g();
                        this.f67044d.set(false);
                        this.f67047g.set(System.currentTimeMillis());
                        h();
                        return;
                    }
                    arrayList2.addAll(a2.e());
                    k.b("TemplateManager", "loadTemplate update1");
                    while (r2.hasNext()) {
                    }
                    a(a2.d());
                    while (r0.hasNext()) {
                    }
                    f.a(a2);
                    f.c();
                    k.b("TemplateManager", "loadTemplate update success: " + a2.b());
                    g();
                    this.f67044d.set(false);
                    this.f67047g.set(System.currentTimeMillis());
                    h();
                    return;
                }
                this.f67044d.set(false);
                a(109);
                k.b("TemplateManager", "loadTemplate error3");
            } catch (Throwable th) {
                k.a("TemplateManager", "loadTemplate error: ", th);
            }
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            String a2 = com.bytedance.sdk.component.utils.e.a(str);
            DownloadExecutor downloadExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getDownloadExecutor();
            downloadExecutor.setUrl(str);
            downloadExecutor.setFileInfo(e().getAbsolutePath(), a2);
            NetResponse execute = downloadExecutor.execute();
            if (execute == null || !execute.isSuccess() || execute.getFile() == null || !execute.getFile().exists()) {
                File file = new File(e(), a2);
                File file2 = new File(file + ".tmp");
                if (file.exists()) {
                    try {
                        file.delete();
                    } catch (Throwable unused) {
                    }
                }
                if (file2.exists()) {
                    try {
                        file2.delete();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            com.bytedance.sdk.openadsdk.j.a.a().h(com.bytedance.sdk.openadsdk.j.a.c.b().b(i2).g(com.bytedance.sdk.openadsdk.core.g.a(i2)));
        }
    }

    private void a(List<u.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (u.a aVar : list) {
            File file = new File(e(), com.bytedance.sdk.component.utils.e.a(aVar.a()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
