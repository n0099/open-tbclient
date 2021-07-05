package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.os.Environment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.e.g;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.executor.DownloadExecutor;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.e.u;
import com.bytedance.sdk.openadsdk.core.o;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static File f30818a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f30819b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f30820c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f30821d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30822e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f30823f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicLong f30824g;

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
        this.f30820c = new AtomicBoolean(true);
        this.f30821d = new AtomicBoolean(false);
        this.f30822e = false;
        this.f30823f = new AtomicInteger(0);
        this.f30824g = new AtomicLong();
        f();
    }

    public static File e() {
        InterceptResult invokeV;
        File externalCacheDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f30818a == null) {
                try {
                    if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && o.a().getExternalCacheDir() != null) {
                        externalCacheDir = o.a().getExternalCacheDir();
                    } else {
                        externalCacheDir = o.a().getCacheDir();
                    }
                    File file = new File(new File(externalCacheDir, "tt_tmpl_pkg"), MediaTrackConfig.AE_IMPORT_TEMPLATE);
                    file.mkdirs();
                    f30818a = file;
                } catch (Throwable th) {
                    j.c("TemplateManager", "getTemplateDir error", th);
                }
            }
            return f30818a;
        }
        return (File) invokeV.objValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            com.bytedance.sdk.component.e.e.a(new g(this, "init") { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f30825a;

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
                    this.f30825a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        f.a();
                        this.f30825a.f30820c.set(false);
                        this.f30825a.g();
                        this.f30825a.d();
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
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            j.b("TemplateManager", "check template usable1");
            u b2 = f.b();
            if (b2 != null && b2.f()) {
                boolean z = true;
                for (u.a aVar : b2.e()) {
                    String a2 = aVar.a();
                    File file = new File(e(), com.bytedance.sdk.component.utils.e.a(a2));
                    String a3 = com.bytedance.sdk.component.utils.e.a(file);
                    if (!file.exists() || !file.isFile() || aVar.b() == null || !aVar.b().equals(a3)) {
                        z = false;
                        j.b("TemplateManager", "check template usable3: " + a2 + "," + file.getAbsolutePath());
                        break;
                    }
                    while (r1.hasNext()) {
                    }
                }
                if (!z) {
                    f.d();
                }
                j.b("TemplateManager", "check template usable4: " + z);
                this.f30822e = z;
                return;
            }
            j.b("TemplateManager", "check template usable2");
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.f30823f.getAndSet(0) <= 0 || System.currentTimeMillis() - this.f30824g.get() <= TTAdConstant.AD_MAX_EVENT_TIME) {
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
            if (f30819b == null) {
                synchronized (b.class) {
                    if (f30819b == null) {
                        f30819b = new b();
                    }
                }
            }
            return f30819b;
        }
        return (b) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30822e : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0127 A[Catch: all -> 0x0242, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0242, blocks: (B:8:0x0014, B:11:0x001e, B:12:0x0023, B:14:0x0038, B:16:0x004d, B:19:0x0055, B:21:0x005f, B:23:0x0073, B:25:0x007f, B:28:0x008b, B:30:0x0095, B:52:0x011b, B:53:0x011f, B:56:0x0127, B:59:0x015b, B:62:0x0164, B:64:0x0184, B:66:0x018a, B:68:0x0190, B:71:0x019b, B:72:0x01a9, B:74:0x01b7, B:75:0x01bb, B:77:0x01c1, B:80:0x01f5, B:84:0x01ff, B:31:0x00a3, B:32:0x00ab, B:34:0x00b1, B:36:0x00c1, B:37:0x00c5, B:39:0x00cf, B:41:0x00d5, B:43:0x00e3, B:44:0x00e7, B:45:0x00ef, B:47:0x00f5, B:49:0x0105, B:50:0x0109, B:51:0x010f, B:85:0x0232), top: B:97:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c1 A[Catch: all -> 0x0242, TRY_LEAVE, TryCatch #0 {all -> 0x0242, blocks: (B:8:0x0014, B:11:0x001e, B:12:0x0023, B:14:0x0038, B:16:0x004d, B:19:0x0055, B:21:0x005f, B:23:0x0073, B:25:0x007f, B:28:0x008b, B:30:0x0095, B:52:0x011b, B:53:0x011f, B:56:0x0127, B:59:0x015b, B:62:0x0164, B:64:0x0184, B:66:0x018a, B:68:0x0190, B:71:0x019b, B:72:0x01a9, B:74:0x01b7, B:75:0x01bb, B:77:0x01c1, B:80:0x01f5, B:84:0x01ff, B:31:0x00a3, B:32:0x00ab, B:34:0x00b1, B:36:0x00c1, B:37:0x00c5, B:39:0x00cf, B:41:0x00d5, B:43:0x00e3, B:44:0x00e7, B:45:0x00ef, B:47:0x00f5, B:49:0x0105, B:50:0x0109, B:51:0x010f, B:85:0x0232), top: B:97:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (this.f30820c.get()) {
                j.b("TemplateManager", "loadTemplate error1");
                return;
            }
            try {
                if (this.f30821d.get()) {
                    if (z) {
                        this.f30823f.getAndIncrement();
                    }
                    j.b("TemplateManager", "loadTemplate error2: " + z);
                    return;
                }
                this.f30821d.set(true);
                u a2 = o.f().a();
                u b2 = f.b();
                if (a2 != null && a2.f()) {
                    if (!f.b(a2.b())) {
                        this.f30821d.set(false);
                        this.f30824g.set(System.currentTimeMillis());
                        j.b("TemplateManager", "loadTemplate error4");
                        return;
                    }
                    ArrayList<u.a> arrayList = new ArrayList();
                    ArrayList<u.a> arrayList2 = new ArrayList();
                    if (b2 != null && !b2.e().isEmpty()) {
                        if (a2.e().isEmpty()) {
                            arrayList.addAll(b2.e());
                            j.b("TemplateManager", "loadTemplate update2");
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
                            j.b("TemplateManager", "loadTemplate update3");
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
                            DownloadExecutor downloadExecutor = com.bytedance.sdk.openadsdk.l.e.b().c().getDownloadExecutor();
                            downloadExecutor.setUrl(a4);
                            downloadExecutor.setFileInfo(e().getAbsolutePath(), a5);
                            NetResponse execute = downloadExecutor.execute();
                            if (execute != null && execute.isSuccess() && execute.getFile() != null && execute.getFile().exists()) {
                                j.a("TemplateManager", "loadTemplate success ulr=", a4);
                            }
                            this.f30821d.set(false);
                            a(arrayList2);
                            j.b("TemplateManager", "loadTemplate error5");
                            return;
                        }
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
                        j.b("TemplateManager", "loadTemplate update success: " + a2.b());
                        g();
                        this.f30821d.set(false);
                        this.f30824g.set(System.currentTimeMillis());
                        h();
                        return;
                    }
                    arrayList2.addAll(a2.e());
                    j.b("TemplateManager", "loadTemplate update1");
                    while (r2.hasNext()) {
                    }
                    while (r0.hasNext()) {
                    }
                    f.a(a2);
                    f.c();
                    j.b("TemplateManager", "loadTemplate update success: " + a2.b());
                    g();
                    this.f30821d.set(false);
                    this.f30824g.set(System.currentTimeMillis());
                    h();
                    return;
                }
                this.f30821d.set(false);
                a(109);
                j.b("TemplateManager", "loadTemplate error3");
            } catch (Throwable th) {
                j.a("TemplateManager", "loadTemplate error: ", th);
            }
        }
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            com.bytedance.sdk.openadsdk.k.a.a().h(com.bytedance.sdk.openadsdk.k.a.c.b().b(i2).h(com.bytedance.sdk.openadsdk.core.g.a(i2)));
        }
    }

    private void a(List<u.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, this, list) == null) || list == null || list.isEmpty()) {
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
