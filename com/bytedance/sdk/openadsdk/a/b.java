package com.bytedance.sdk.openadsdk.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.NetClient;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import com.bytedance.sdk.component.net.executor.DownloadExecutor;
import com.bytedance.sdk.component.net.executor.NetExecutor;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.CacheDirConstants;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.q.e;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, com.bytedance.sdk.openadsdk.a.a> f65734a;

    /* renamed from: b  reason: collision with root package name */
    public ReentrantLock f65735b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f65736c;

    /* renamed from: d  reason: collision with root package name */
    public NetClient f65737d;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f65744a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-664305601, "Lcom/bytedance/sdk/openadsdk/a/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-664305601, "Lcom/bytedance/sdk/openadsdk/a/b$a;");
                    return;
                }
            }
            f65744a = new b();
        }
    }

    private NetClient b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (this.f65737d == null) {
                this.f65737d = new NetClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).build();
            }
            return this.f65737d;
        }
        return (NetClient) invokeV.objValue;
    }

    private JSONArray c(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, jSONObject)) == null) {
            JSONArray optJSONArray2 = jSONObject.optJSONArray("creatives");
            JSONArray jSONArray = new JSONArray();
            if (optJSONArray2 == null) {
                return jSONArray;
            }
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("precache_brand_video")) != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        jSONArray.put(optJSONArray.opt(i3));
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            JSONArray jSONArray = new JSONArray();
            for (String str : this.f65734a.keySet()) {
                com.bytedance.sdk.openadsdk.a.a aVar = this.f65734a.get(str);
                if (aVar != null) {
                    jSONArray.put(aVar.e());
                }
            }
            String jSONArray2 = jSONArray.toString();
            e.f(jSONArray2);
            k.b("BrandVideoCacheManager", "save video cache:" + jSONArray2);
        }
    }

    @NonNull
    private Map<String, com.bytedance.sdk.openadsdk.a.a> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, com.bytedance.sdk.openadsdk.a.a>> it = this.f65734a.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, com.bytedance.sdk.openadsdk.a.a> next = it.next();
                if (next.getValue().d()) {
                    hashMap.put(next.getKey(), next.getValue());
                    it.remove();
                } else {
                    arrayList.add(next.getValue());
                }
            }
            int N = o.h().N();
            k.b("BrandVideoCacheManager", "setting num:" + N);
            int size = this.f65734a.size() - N;
            if (size > 0) {
                Collections.sort(arrayList, new Comparator<com.bytedance.sdk.openadsdk.a.a>(this) { // from class: com.bytedance.sdk.openadsdk.a.b.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f65743a;

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
                        this.f65743a = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(com.bytedance.sdk.openadsdk.a.a aVar, com.bytedance.sdk.openadsdk.a.a aVar2) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, aVar, aVar2)) == null) {
                            long c2 = aVar2.c() - aVar.c();
                            if (c2 == 0) {
                                String brandCacheDir = CacheDirConstants.getBrandCacheDir();
                                c2 = aVar.a(brandCacheDir) - aVar2.a(brandCacheDir);
                            }
                            return (int) c2;
                        }
                        return invokeLL.intValue;
                    }
                });
                for (int i2 = 0; i2 < size; i2++) {
                    com.bytedance.sdk.openadsdk.a.a aVar = (com.bytedance.sdk.openadsdk.a.a) arrayList.get(i2);
                    this.f65734a.remove(aVar.b());
                    hashMap.put(aVar.b(), aVar);
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

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
        this.f65734a = new HashMap();
        this.f65735b = new ReentrantLock();
        this.f65736c = new HashSet();
        String i4 = e.i();
        if (TextUtils.isEmpty(i4)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(i4);
            for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                b(jSONArray.optJSONObject(i5));
            }
        } catch (Throwable unused) {
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f65744a : (b) invokeV.objValue;
    }

    public void a(@NonNull JSONObject jSONObject) {
        JSONArray c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || (c2 = c(jSONObject)) == null || c2.length() == 0) {
            return;
        }
        l.c().postDelayed(new Runnable(this, c2) { // from class: com.bytedance.sdk.openadsdk.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JSONArray f65738a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f65739b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, c2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f65739b = this;
                this.f65738a = c2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    k.b("BrandVideoCacheManager", "onReceivedNewBrandCache start:" + this.f65738a.length());
                    this.f65739b.a(this.f65738a);
                }
            }
        }, 20000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, jSONArray) == null) {
            try {
                this.f65735b.lock();
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    b(jSONArray.optJSONObject(i2));
                }
                Map<String, com.bytedance.sdk.openadsdk.a.a> e2 = e();
                int c2 = c();
                d();
                a(e2);
                this.f65735b.unlock();
                a(c2);
            } catch (Throwable th) {
                this.f65735b.unlock();
                throw th;
            }
        }
    }

    private void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.a.a aVar = new com.bytedance.sdk.openadsdk.a.a(jSONObject);
        this.f65734a.put(aVar.b(), aVar);
    }

    private int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            int i2 = 0;
            for (String str : this.f65734a.keySet()) {
                com.bytedance.sdk.openadsdk.n.f.b a2 = a(this.f65734a.get(str));
                if (a2 != null) {
                    String c2 = a2.c();
                    String b2 = a2.b();
                    String a3 = a2.a();
                    File file = new File(c2, b2);
                    if (file.exists() && file.length() > 0) {
                        k.b("BrandVideoCacheManager", " file :" + b2 + " exist!");
                    } else {
                        i2++;
                        if (this.f65736c.contains(b2)) {
                            k.c("BrandVideoCacheManager", " task :" + b2 + " is running!");
                        } else {
                            this.f65736c.add(b2);
                            a(a3, c2, b2);
                        }
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, str) == null) {
            try {
                this.f65735b.lock();
                this.f65736c.remove(str);
            } finally {
                this.f65735b.unlock();
            }
        }
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2) == null) {
            File[] listFiles = new File(CacheDirConstants.getBrandCacheDir()).listFiles();
            int N = o.h().N();
            if (listFiles == null || listFiles.length <= N - i2) {
                return;
            }
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                String a2 = a(listFiles[i3]);
                if (!this.f65734a.containsKey(a2) && listFiles[i3].exists()) {
                    listFiles[i3].delete();
                    k.d("BrandVideoCacheManager", "delete not need:" + a2);
                }
            }
        }
    }

    private String a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, file)) == null) {
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(".");
            return lastIndexOf != -1 ? name.substring(0, lastIndexOf) : name;
        }
        return (String) invokeL.objValue;
    }

    private void a(@NonNull Map<String, com.bytedance.sdk.openadsdk.a.a> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, map) == null) {
            for (String str : map.keySet()) {
                com.bytedance.sdk.openadsdk.a.a aVar = map.get(str);
                boolean b2 = aVar.b(CacheDirConstants.getBrandCacheDir());
                k.b("BrandVideoCacheManager", "try delete: " + aVar.b() + " ,result " + b2);
            }
        }
    }

    private void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, this, str, str2, str3) == null) {
            DownloadExecutor downloadExecutor = b().getDownloadExecutor();
            downloadExecutor.setUrl(str);
            downloadExecutor.setFileInfo(str2, str3);
            downloadExecutor.enqueue(new NetCallback(this, str, str3) { // from class: com.bytedance.sdk.openadsdk.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f65740a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f65741b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f65742c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65742c = this;
                    this.f65740a = str;
                    this.f65741b = str3;
                }

                @Override // com.bytedance.sdk.component.net.callback.NetCallback
                public void onFailure(NetExecutor netExecutor, IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                        k.d("BrandVideoCacheManager", "download " + this.f65740a + " failed: " + iOException);
                        this.f65742c.b(this.f65741b);
                    }
                }

                @Override // com.bytedance.sdk.component.net.callback.NetCallback
                public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) {
                        k.b("BrandVideoCacheManager", "download " + this.f65740a + " finish: code = " + netResponse.getCode());
                        this.f65742c.b(this.f65741b);
                    }
                }
            });
        }
    }

    private com.bytedance.sdk.openadsdk.n.f.b a(com.bytedance.sdk.openadsdk.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
            bVar.a(aVar.a());
            String b2 = aVar.b();
            if (TextUtils.isEmpty(b2)) {
                b2 = com.bytedance.sdk.component.utils.e.a(aVar.a());
            }
            bVar.b(b2);
            bVar.b(true);
            bVar.c(CacheDirConstants.getBrandCacheDir());
            bVar.a(5242880);
            return bVar;
        }
        return (com.bytedance.sdk.openadsdk.n.f.b) invokeL.objValue;
    }

    public static File a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? new File(CacheDirConstants.getBrandCacheDir(), str) : (File) invokeL.objValue;
    }
}
