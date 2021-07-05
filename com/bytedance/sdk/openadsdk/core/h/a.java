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
import com.bytedance.sdk.component.adnet.b.b;
import com.bytedance.sdk.component.adnet.core.i;
import com.bytedance.sdk.component.adnet.err.VAdError;
import com.bytedance.sdk.component.e.e;
import com.bytedance.sdk.component.e.g;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f30119a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f30120b;

    /* renamed from: c  reason: collision with root package name */
    public Map<m, b> f30121c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, JSONObject> f30122d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f30123e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f30124f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f30125g;

    /* renamed from: com.bytedance.sdk.openadsdk.core.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0339a {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f30139a;

        /* renamed from: b  reason: collision with root package name */
        public long f30140b;

        /* renamed from: c  reason: collision with root package name */
        public long f30141c;

        /* renamed from: d  reason: collision with root package name */
        public long f30142d;

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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30140b - this.f30139a : invokeV.longValue;
        }

        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30142d - this.f30141c : invokeV.longValue;
        }

        public b c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                this.f30141c = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                this.f30142d = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                this.f30139a = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.f30140b = j;
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
        this.f30121c = Collections.synchronizedMap(new HashMap());
        this.f30122d = Collections.synchronizedMap(new HashMap());
        this.f30123e = new AtomicBoolean(false);
        this.f30124f = Collections.synchronizedSet(new HashSet());
        this.f30125g = new Handler(Looper.getMainLooper());
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
                        j.d("PlayableCache", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private boolean e(File file) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, file)) == null) {
            if (file == null || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
                return false;
            }
            return Arrays.asList(list).contains("index.html");
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f30123e.get()) {
            return;
        }
        e.a(new g(this, "PlayableCache") { // from class: com.bytedance.sdk.openadsdk.core.h.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f30126a;

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
                this.f30126a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        String c2 = this.f30126a.c();
                        if (!TextUtils.isEmpty(c2)) {
                            File file = new File(c2);
                            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                                for (File file2 : listFiles) {
                                    try {
                                        this.f30126a.a(this.f30126a.a(file2), true);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                    this.f30126a.f30123e.set(true);
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
            if (f30119a == null) {
                synchronized (a.class) {
                    if (f30119a == null) {
                        f30119a = new a();
                    }
                }
            }
            return f30119a;
        }
        return (a) invokeV.objValue;
    }

    private boolean b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, this, file)) == null) ? file != null && file.exists() && file.isFile() && file.canRead() : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        InterceptResult invokeV;
        File externalCacheDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            if (TextUtils.isEmpty(this.f30120b)) {
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
                    this.f30120b = file.getAbsolutePath();
                } catch (Throwable th) {
                    j.f("PlayableCache", "init root path error: " + th);
                }
            }
            return this.f30120b;
        }
        return (String) invokeV.objValue;
    }

    public boolean a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar)) == null) {
            if (this.f30123e.get() && mVar != null && mVar.V() != null && mVar.V().k() != null) {
                try {
                    String a2 = com.bytedance.sdk.component.utils.e.a(mVar.V().k());
                    if (this.f30122d.get(a2) == null) {
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
                    a2 = com.bytedance.sdk.component.c.a.a(new String(d2), com.bytedance.sdk.openadsdk.core.a.c());
                }
                if (TextUtils.isEmpty(a2)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(a2);
                if (z && jSONObject.length() > 0) {
                    this.f30122d.put(file.getParentFile().getName(), jSONObject);
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
                j.c("PlayableCache", "playable intercept error: ", th);
            }
            if (!this.f30123e.get() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
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
            String a2 = l.a(o.a(), str3);
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
                if (a(a3, replace, file2)) {
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
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, this, str, str2, file)) == null) ? (file == null || !file.exists() || (jSONObject = this.f30122d.get(str)) == null || (optString = jSONObject.optString(str2)) == null || !optString.equalsIgnoreCase(com.bytedance.sdk.component.utils.e.a(file))) ? false : true : invokeLLL.booleanValue;
    }

    public void a(m mVar, InterfaceC0339a interfaceC0339a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar, interfaceC0339a) == null) {
            if (mVar != null && mVar.V() != null && !TextUtils.isEmpty(mVar.V().k())) {
                String k = mVar.V().k();
                if (this.f30124f.contains(k)) {
                    return;
                }
                this.f30121c.put(mVar, new b().a(System.currentTimeMillis()));
                com.bytedance.sdk.openadsdk.core.h.b.a(o.a(), mVar);
                String a2 = com.bytedance.sdk.component.utils.e.a(k);
                File file = new File(c(), a2);
                if (e(file)) {
                    com.bytedance.sdk.openadsdk.core.h.b.a(o.a(), mVar, -702, (String) null);
                    d(file);
                    this.f30121c.remove(mVar);
                    a(interfaceC0339a, true);
                    return;
                }
                try {
                    f.c(file);
                } catch (Throwable unused) {
                }
                this.f30124f.add(k);
                com.bytedance.sdk.openadsdk.l.e.b().a(k, new b.a(this, a2, k, mVar, file, interfaceC0339a) { // from class: com.bytedance.sdk.openadsdk.core.h.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f30127a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f30128b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ m f30129c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ File f30130d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ InterfaceC0339a f30131e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ a f30132f;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, a2, k, mVar, file, interfaceC0339a};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f30132f = this;
                        this.f30127a = a2;
                        this.f30128b = k;
                        this.f30129c = mVar;
                        this.f30130d = file;
                        this.f30131e = interfaceC0339a;
                    }

                    @Override // com.bytedance.sdk.component.adnet.b.b.a
                    public File a(String str) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                            return null;
                        }
                        return (File) invokeL.objValue;
                    }

                    @Override // com.bytedance.sdk.component.adnet.b.c.a
                    public void a(long j, long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.component.adnet.core.m.a
                    public void a(com.bytedance.sdk.component.adnet.core.m<File> mVar2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar2) == null) {
                            this.f30132f.f30124f.remove(this.f30128b);
                            b bVar = (b) this.f30132f.f30121c.remove(this.f30129c);
                            if (bVar != null) {
                                bVar.b(System.currentTimeMillis());
                            }
                            if (mVar2 != null && mVar2.f27921a != null) {
                                e.a(new g(this, "downloadZip", bVar, mVar2) { // from class: com.bytedance.sdk.openadsdk.core.h.a.2.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ b f30133a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ com.bytedance.sdk.component.adnet.core.m f30134b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass2 f30135c;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(r8);
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, r8, bVar, mVar2};
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
                                        this.f30135c = this;
                                        this.f30133a = bVar;
                                        this.f30134b = mVar2;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        long j;
                                        long j2;
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            boolean z = true;
                                            try {
                                                if (this.f30133a != null) {
                                                    this.f30133a.c(System.currentTimeMillis());
                                                }
                                                v.a(((File) this.f30134b.f27921a).getAbsolutePath(), this.f30135c.f30132f.c());
                                                if (this.f30133a != null) {
                                                    this.f30133a.d(System.currentTimeMillis());
                                                }
                                                if (this.f30133a != null) {
                                                    long a3 = this.f30133a.a();
                                                    j = this.f30133a.b();
                                                    j2 = a3;
                                                } else {
                                                    j = 0;
                                                    j2 = 0;
                                                }
                                                com.bytedance.sdk.openadsdk.core.h.b.a(o.a(), this.f30135c.f30129c, j2, j);
                                                this.f30135c.f30132f.c(this.f30135c.f30130d);
                                                try {
                                                    this.f30135c.f30132f.a(this.f30135c.f30132f.a(this.f30135c.f30130d), true);
                                                } catch (Throwable unused2) {
                                                }
                                            } catch (Throwable th) {
                                                j.c("PlayableCache", "unzip error: ", th);
                                                com.bytedance.sdk.openadsdk.core.h.b.a(o.a(), this.f30135c.f30129c, -704, th.getMessage());
                                                z = false;
                                            }
                                            try {
                                                ((File) this.f30134b.f27921a).delete();
                                            } catch (Throwable unused3) {
                                            }
                                            AnonymousClass2 anonymousClass2 = this.f30135c;
                                            anonymousClass2.f30132f.a(anonymousClass2.f30131e, z);
                                        }
                                    }
                                }, 5);
                                return;
                            }
                            int i2 = -700;
                            if (mVar2 != null) {
                                long j = mVar2.f27928h;
                                if (j != 0) {
                                    i2 = Long.valueOf(j).intValue();
                                }
                            }
                            com.bytedance.sdk.openadsdk.core.h.b.a(o.a(), this.f30129c, i2, (String) null);
                            this.f30132f.a(this.f30131e, false);
                        }
                    }

                    @Override // com.bytedance.sdk.component.adnet.b.b.a
                    public void a(String str, File file2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048579, this, str, file2) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.component.adnet.b.b.a
                    public File b(String str) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048580, this, str)) == null) {
                            String d2 = this.f30132f.d();
                            return new File(d2, this.f30127a + ".zip");
                        }
                        return (File) invokeL.objValue;
                    }

                    @Override // com.bytedance.sdk.component.adnet.core.m.a
                    public void b(com.bytedance.sdk.component.adnet.core.m<File> mVar2) {
                        i iVar;
                        int i2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048581, this, mVar2) == null) {
                            this.f30132f.f30124f.remove(this.f30128b);
                            this.f30132f.f30121c.remove(this.f30129c);
                            int i3 = -700;
                            String str = null;
                            if (mVar2 != null) {
                                long j = mVar2.f27928h;
                                if (j != 0) {
                                    i3 = Long.valueOf(j).intValue();
                                } else {
                                    VAdError vAdError = mVar2.f27923c;
                                    if (vAdError != null && (iVar = vAdError.networkResponse) != null && (i2 = iVar.f27904a) != 0) {
                                        i3 = i2;
                                    }
                                }
                                VAdError vAdError2 = mVar2.f27923c;
                                if (vAdError2 != null) {
                                    str = vAdError2.getMessage();
                                }
                            }
                            com.bytedance.sdk.openadsdk.core.h.b.a(o.a(), this.f30129c, i3, str);
                            this.f30132f.a(this.f30131e, false);
                        }
                    }
                });
                return;
            }
            com.bytedance.sdk.openadsdk.core.h.b.a(o.a(), mVar, -701, (String) null);
            a(interfaceC0339a, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterfaceC0339a interfaceC0339a, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, this, interfaceC0339a, z) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (interfaceC0339a != null) {
                    interfaceC0339a.a(z);
                }
            } else if (interfaceC0339a != null) {
                this.f30125g.post(new Runnable(this, interfaceC0339a, z) { // from class: com.bytedance.sdk.openadsdk.core.h.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ InterfaceC0339a f30136a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ boolean f30137b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f30138c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, interfaceC0339a, Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f30138c = this;
                        this.f30136a = interfaceC0339a;
                        this.f30137b = z;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        InterfaceC0339a interfaceC0339a2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (interfaceC0339a2 = this.f30136a) == null) {
                            return;
                        }
                        interfaceC0339a2.a(this.f30137b);
                    }
                });
            }
        }
    }
}
