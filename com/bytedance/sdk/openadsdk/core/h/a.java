package com.bytedance.sdk.openadsdk.core.h;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.e;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import com.bytedance.sdk.component.net.executor.DownloadExecutor;
import com.bytedance.sdk.component.net.executor.NetExecutor;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.k.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f66244a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f66245b;

    /* renamed from: c  reason: collision with root package name */
    public Map<m, b> f66246c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, JSONObject> f66247d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f66248e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f66249f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f66250g;

    /* renamed from: com.bytedance.sdk.openadsdk.core.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1901a {
        void a(boolean z);
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f66263a;

        /* renamed from: b  reason: collision with root package name */
        public long f66264b;

        /* renamed from: c  reason: collision with root package name */
        public long f66265c;

        /* renamed from: d  reason: collision with root package name */
        public long f66266d;

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
                }
            }
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66264b - this.f66263a : invokeV.longValue;
        }

        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66266d - this.f66265c : invokeV.longValue;
        }

        public b c(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
                this.f66265c = j2;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b d(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                this.f66266d = j2;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                this.f66263a = j2;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
                this.f66264b = j2;
                return this;
            }
            return (b) invokeJ.objValue;
        }
    }

    public a() {
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
        this.f66246c = Collections.synchronizedMap(new HashMap());
        this.f66247d = Collections.synchronizedMap(new HashMap());
        this.f66248e = new AtomicBoolean(false);
        this.f66249f = Collections.synchronizedSet(new HashSet());
        this.f66250g = new Handler(Looper.getMainLooper());
    }

    private boolean e(File file) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, file)) == null) {
            if (file == null || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
                return false;
            }
            return Arrays.asList(list).contains("index.html");
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, file) == null) {
            d(file);
            try {
                h.d().t().a(file);
            } catch (Throwable unused) {
            }
        }
    }

    private void d(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, file) == null) {
            try {
                if (file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (file.setLastModified(currentTimeMillis)) {
                        return;
                    }
                    file.renameTo(file);
                    if (file.lastModified() < currentTimeMillis) {
                        k.d("PlayableCache", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f66248e.get()) {
            return;
        }
        e.a(new g(this, "PlayableCache") { // from class: com.bytedance.sdk.openadsdk.core.h.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f66251a;

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
                this.f66251a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        String c2 = this.f66251a.c();
                        if (!TextUtils.isEmpty(c2)) {
                            File file = new File(c2);
                            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                                for (File file2 : listFiles) {
                                    try {
                                        this.f66251a.a(this.f66251a.a(file2), true);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                    this.f66251a.f66248e.set(true);
                }
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            File file = new File(d(), "games");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f66244a == null) {
                synchronized (a.class) {
                    if (f66244a == null) {
                        f66244a = new a();
                    }
                }
            }
            return f66244a;
        }
        return (a) invokeV.objValue;
    }

    private boolean b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, this, file)) == null) ? file != null && file.exists() && file.isFile() && file.canRead() : invokeL.booleanValue;
    }

    private String d() {
        InterceptResult invokeV;
        File externalCacheDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            if (TextUtils.isEmpty(this.f66245b)) {
                try {
                    if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && o.a().getExternalCacheDir() != null) {
                        externalCacheDir = o.a().getExternalCacheDir();
                    } else {
                        externalCacheDir = o.a().getCacheDir();
                    }
                    File file = new File(externalCacheDir, "playable");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.f66245b = file.getAbsolutePath();
                } catch (Throwable th) {
                    k.f("PlayableCache", "init root path error: " + th);
                }
            }
            return this.f66245b;
        }
        return (String) invokeV.objValue;
    }

    public boolean a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar)) == null) {
            if (this.f66248e.get() && mVar != null && mVar.V() != null && mVar.V().k() != null) {
                try {
                    String a2 = com.bytedance.sdk.component.utils.e.a(mVar.V().k());
                    if (this.f66247d.get(a2) == null) {
                        return false;
                    }
                    return e(new File(c(), a2));
                } catch (Throwable unused) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(File file, boolean z) {
        byte[] d2;
        String a2;
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, this, file, z)) == null) {
            try {
                if (!b(file) || (d2 = f.d(file)) == null || d2.length <= 0) {
                    return null;
                }
                if (TextUtils.equals(file.getName(), "new_tt_open_ad_sdk_check_res.dat")) {
                    a2 = com.bytedance.sdk.component.utils.a.b(new String(d2));
                } else {
                    a2 = com.bytedance.sdk.component.c.a.a(new String(d2), com.bytedance.sdk.openadsdk.core.a.b());
                }
                if (TextUtils.isEmpty(a2)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(a2);
                if (z && jSONObject.length() > 0) {
                    this.f66247d.put(file.getParentFile().getName(), jSONObject);
                }
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeLZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, file)) == null) {
            File file2 = new File(file, "new_tt_open_ad_sdk_check_res.dat");
            return b(file2) ? file2 : new File(file, "tt_open_ad_sdk_check_res.dat");
        }
        return (File) invokeL.objValue;
    }

    public WebResourceResponse a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            try {
            } catch (Throwable th) {
                k.c("PlayableCache", "playable intercept error: ", th);
            }
            if (!this.f66248e.get() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                if (str3.startsWith("http") && str3.contains("?")) {
                    str3 = str3.split("\\?")[0];
                    if (str3.endsWith("/")) {
                        str3 = str3.substring(0, str3.length() - 1);
                    }
                }
            } catch (Throwable unused) {
            }
            String a2 = com.bytedance.sdk.component.utils.m.a(o.a(), str3);
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            String a3 = com.bytedance.sdk.component.utils.e.a(str);
            if (TextUtils.isEmpty(a3)) {
                return null;
            }
            File file = new File(c(), a3);
            if (e(file)) {
                String a4 = a(str2);
                if (TextUtils.isEmpty(a4)) {
                    return null;
                }
                String replace = str3.replace(a4, "");
                if (TextUtils.isEmpty(replace)) {
                    return null;
                }
                File file2 = new File(file, replace);
                if (a(a3, replace, file2) && file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                    return new WebResourceResponse(a2, "utf-8", new FileInputStream(file2));
                }
            }
            return null;
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] split = str.split("\\?");
            if (split != null && split.length == 2) {
                if (split[0] != null && split[0].endsWith("/")) {
                    str = str.substring(0, split.length - 1);
                }
                if (split[0] != null && split[0].endsWith("index.html")) {
                    str = split[0];
                }
            }
            return str.replace("index.html", "");
        }
        return (String) invokeL.objValue;
    }

    private boolean a(String str, String str2, File file) {
        InterceptResult invokeLLL;
        JSONObject jSONObject;
        String optString;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, this, str, str2, file)) == null) ? (file == null || !file.exists() || (jSONObject = this.f66247d.get(str)) == null || (optString = jSONObject.optString(str2)) == null || !optString.equalsIgnoreCase(com.bytedance.sdk.component.utils.e.a(file))) ? false : true : invokeLLL.booleanValue;
    }

    public void a(m mVar, InterfaceC1901a interfaceC1901a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar, interfaceC1901a) == null) {
            if (mVar != null && mVar.V() != null && !TextUtils.isEmpty(mVar.V().k())) {
                String k = mVar.V().k();
                if (this.f66249f.contains(k)) {
                    return;
                }
                this.f66246c.put(mVar, new b().a(System.currentTimeMillis()));
                com.bytedance.sdk.openadsdk.core.h.b.a(o.a(), mVar);
                String a2 = com.bytedance.sdk.component.utils.e.a(k);
                File file = new File(c(), a2);
                if (e(file)) {
                    com.bytedance.sdk.openadsdk.core.h.b.a(o.a(), mVar, -702, (String) null);
                    d(file);
                    this.f66246c.remove(mVar);
                    a(interfaceC1901a, true);
                    return;
                }
                try {
                    f.c(file);
                } catch (Throwable unused) {
                }
                this.f66249f.add(k);
                String d2 = d();
                File file2 = new File(d2, a2 + ".zip");
                DownloadExecutor downloadExecutor = d.b().c().getDownloadExecutor();
                downloadExecutor.setUrl(k);
                downloadExecutor.setFileInfo(file2.getParent(), file2.getName());
                downloadExecutor.enqueue(new NetCallback(this, k, mVar, file, interfaceC1901a) { // from class: com.bytedance.sdk.openadsdk.core.h.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f66252a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ m f66253b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ File f66254c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ InterfaceC1901a f66255d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ a f66256e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, k, mVar, file, interfaceC1901a};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66256e = this;
                        this.f66252a = k;
                        this.f66253b = mVar;
                        this.f66254c = file;
                        this.f66255d = interfaceC1901a;
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onFailure(NetExecutor netExecutor, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                            this.f66256e.f66249f.remove(this.f66252a);
                            this.f66256e.f66246c.remove(this.f66253b);
                            com.bytedance.sdk.openadsdk.core.h.b.a(o.a(), this.f66253b, -700, iOException.getMessage());
                            this.f66256e.a(this.f66255d, false);
                            k.c("PlayableCache", "onFailure: Playable zip download fail");
                        }
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) {
                            this.f66256e.f66249f.remove(this.f66252a);
                            b bVar = (b) this.f66256e.f66246c.remove(this.f66253b);
                            if (bVar != null) {
                                bVar.b(System.currentTimeMillis());
                            }
                            if (netResponse.isSuccess() && netResponse.getFile() != null && netResponse.getFile().exists()) {
                                k.c("PlayableCache", "onResponse: Playable zip download success");
                                e.a(new g(this, "downloadZip", bVar, netResponse) { // from class: com.bytedance.sdk.openadsdk.core.h.a.2.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ b f66257a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ NetResponse f66258b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass2 f66259c;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(r8);
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, r8, bVar, netResponse};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                super((String) newInitContext.callArgs[0]);
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f66259c = this;
                                        this.f66257a = bVar;
                                        this.f66258b = netResponse;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        long j2;
                                        long j3;
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            boolean z = true;
                                            try {
                                                if (this.f66257a != null) {
                                                    this.f66257a.c(System.currentTimeMillis());
                                                }
                                                x.a(this.f66258b.getFile().getAbsolutePath(), this.f66259c.f66256e.c());
                                                if (this.f66257a != null) {
                                                    this.f66257a.d(System.currentTimeMillis());
                                                }
                                                if (this.f66257a != null) {
                                                    long a3 = this.f66257a.a();
                                                    j2 = this.f66257a.b();
                                                    j3 = a3;
                                                } else {
                                                    j2 = 0;
                                                    j3 = 0;
                                                }
                                                com.bytedance.sdk.openadsdk.core.h.b.a(o.a(), this.f66259c.f66253b, j3, j2);
                                                this.f66259c.f66256e.c(this.f66259c.f66254c);
                                                try {
                                                    this.f66259c.f66256e.a(this.f66259c.f66256e.a(this.f66259c.f66254c), true);
                                                } catch (Throwable unused2) {
                                                }
                                            } catch (Throwable th) {
                                                k.c("PlayableCache", "unzip error: ", th);
                                                com.bytedance.sdk.openadsdk.core.h.b.a(o.a(), this.f66259c.f66253b, -704, th.getMessage());
                                                z = false;
                                            }
                                            try {
                                                this.f66258b.getFile().delete();
                                            } catch (Throwable unused3) {
                                            }
                                            AnonymousClass2 anonymousClass2 = this.f66259c;
                                            anonymousClass2.f66256e.a(anonymousClass2.f66255d, z);
                                        }
                                    }
                                }, 5);
                                return;
                            }
                            com.bytedance.sdk.openadsdk.core.h.b.a(o.a(), this.f66253b, netResponse.getCode() != 0 ? netResponse.getCode() : -700, (String) null);
                            k.c("PlayableCache", "onResponse: Playable zip download fail");
                            this.f66256e.a(this.f66255d, false);
                        }
                    }
                });
                return;
            }
            com.bytedance.sdk.openadsdk.core.h.b.a(o.a(), mVar, -701, (String) null);
            a(interfaceC1901a, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterfaceC1901a interfaceC1901a, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, this, interfaceC1901a, z) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (interfaceC1901a != null) {
                    interfaceC1901a.a(z);
                }
            } else if (interfaceC1901a != null) {
                this.f66250g.post(new Runnable(this, interfaceC1901a, z) { // from class: com.bytedance.sdk.openadsdk.core.h.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ InterfaceC1901a f66260a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ boolean f66261b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f66262c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, interfaceC1901a, Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66262c = this;
                        this.f66260a = interfaceC1901a;
                        this.f66261b = z;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        InterfaceC1901a interfaceC1901a2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (interfaceC1901a2 = this.f66260a) == null) {
                            return;
                        }
                        interfaceC1901a2.a(this.f66261b);
                    }
                });
            }
        }
    }
}
