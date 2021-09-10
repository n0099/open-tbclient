package com.bytedance.sdk.openadsdk.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f66275a = "AppEnvironment";

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f66276b = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f66277d = "ad_style";

    /* renamed from: e  reason: collision with root package name */
    public static String f66278e = "ad_id";

    /* renamed from: f  reason: collision with root package name */
    public static String f66279f = "rit";

    /* renamed from: g  reason: collision with root package name */
    public static String f66280g = "request_id";

    /* renamed from: h  reason: collision with root package name */
    public static String f66281h = "ad_slot_type";

    /* renamed from: i  reason: collision with root package name */
    public static String f66282i = "net_type";

    /* renamed from: j  reason: collision with root package name */
    public static String f66283j = "low_memory";
    public static String k = "total_max_memory_rate";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f66284c;
    public long l;
    public boolean m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(210334610, "Lcom/bytedance/sdk/openadsdk/core/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(210334610, "Lcom/bytedance/sdk/openadsdk/core/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        HashMap hashMap = new HashMap();
        this.f66284c = hashMap;
        hashMap.put(f66277d, "default");
        this.f66284c.put(f66278e, "default");
        this.f66284c.put(f66279f, "default");
        this.f66284c.put(f66280g, "default");
        this.f66284c.put(f66281h, "default");
        this.f66284c.put(f66282i, "default");
        this.f66284c.put(f66283j, "default");
        this.f66284c.put(k, "default");
        this.l = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_env", "last_app_env_time", 0L);
        this.m = false;
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f66276b == null) {
                synchronized (d.class) {
                    if (f66276b == null) {
                        f66276b = new d();
                    }
                }
            }
            return f66276b;
        }
        return (d) invokeV.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            Runtime runtime = Runtime.getRuntime();
            float maxMemory = (float) ((runtime.maxMemory() * 1.0d) / 1048576.0d);
            float f2 = (float) ((runtime.totalMemory() * 1.0d) / 1048576.0d);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) o.a().getSystemService("activity")).getMemoryInfo(memoryInfo);
            String str = f66275a;
            com.bytedance.sdk.component.utils.k.f(str, "系统是否处于低内存运行：" + memoryInfo.lowMemory);
            String str2 = f66275a;
            com.bytedance.sdk.component.utils.k.f(str2, "maxMemory: " + maxMemory);
            String str3 = f66275a;
            com.bytedance.sdk.component.utils.k.f(str3, "totalMemory: " + f2);
            String str4 = f66275a;
            com.bytedance.sdk.component.utils.k.f(str4, "freeMemory: " + ((float) ((runtime.freeMemory() * 1.0d) / 1048576.0d)));
            String str5 = f66275a;
            StringBuilder sb = new StringBuilder();
            sb.append("totalMaxRate: ");
            int i2 = (int) ((f2 / maxMemory) * 100.0f);
            sb.append(i2);
            com.bytedance.sdk.component.utils.k.f(str5, sb.toString());
            this.f66284c.put(f66283j, String.valueOf(memoryInfo.lowMemory));
            this.f66284c.put(k, String.valueOf(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                Context a2 = o.a();
                if (a2 == null) {
                    return null;
                }
                PackageInfo packageInfo = a2.getPackageManager().getPackageInfo(a2.getPackageName(), 4111);
                ApplicationInfo applicationInfo = a2.getApplicationInfo();
                if (applicationInfo != null) {
                    jSONObject.put("application_name", applicationInfo.name);
                }
                jSONObject.put("app_id", h.d().h());
                if (packageInfo != null) {
                    ActivityInfo[] activityInfoArr = packageInfo.activities;
                    String[] strArr = packageInfo.requestedPermissions;
                    ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                    ServiceInfo[] serviceInfoArr = packageInfo.services;
                    ProviderInfo[] providerInfoArr = packageInfo.providers;
                    if (activityInfoArr != null) {
                        JSONArray jSONArray = new JSONArray();
                        for (ActivityInfo activityInfo : activityInfoArr) {
                            jSONArray.put(activityInfo.name);
                        }
                        jSONObject.put("activities", jSONArray);
                    }
                    if (strArr != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (String str : strArr) {
                            jSONArray2.put(str);
                        }
                        jSONObject.put("permissions", jSONArray2);
                    }
                    if (activityInfoArr2 != null) {
                        JSONArray jSONArray3 = new JSONArray();
                        for (ActivityInfo activityInfo2 : activityInfoArr2) {
                            jSONArray3.put(activityInfo2.name);
                        }
                        jSONObject.put("receivers", jSONArray3);
                    }
                    if (serviceInfoArr != null) {
                        JSONArray jSONArray4 = new JSONArray();
                        for (ServiceInfo serviceInfo : serviceInfoArr) {
                            jSONArray4.put(serviceInfo.name);
                        }
                        jSONObject.put("services", jSONArray4);
                    }
                    if (providerInfoArr != null) {
                        JSONArray jSONArray5 = new JSONArray();
                        for (ProviderInfo providerInfo : providerInfoArr) {
                            jSONArray5.put(providerInfo.name);
                        }
                        jSONObject.put("providers", jSONArray5);
                    }
                }
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, mVar) == null) || mVar == null) {
            return;
        }
        this.f66284c.put(f66278e, mVar.ak());
        Map<String, String> map = this.f66284c;
        String str = f66279f;
        map.put(str, "" + com.bytedance.sdk.openadsdk.q.q.d(mVar.ao()));
        this.f66284c.put(f66280g, com.bytedance.sdk.openadsdk.q.q.h(mVar.ao()));
        Map<String, String> map2 = this.f66284c;
        String str2 = f66281h;
        map2.put(str2, "" + com.bytedance.sdk.openadsdk.q.q.c(mVar.ao()));
        this.f66284c.put(f66282i, com.bytedance.sdk.component.utils.n.g(o.a()));
        if (com.bytedance.sdk.openadsdk.core.e.o.a(mVar)) {
            this.f66284c.put(f66277d, "is_playable");
        }
        d();
    }

    public Map<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66284c : (Map) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.m || com.bytedance.sdk.openadsdk.q.q.a(this.l, System.currentTimeMillis())) {
            return;
        }
        this.m = true;
        com.bytedance.sdk.component.d.e.a(new com.bytedance.sdk.component.d.g(this, "trySendAppManifestInfo") { // from class: com.bytedance.sdk.openadsdk.core.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f66285a;

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
                this.f66285a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    JSONObject e2 = this.f66285a.e();
                    if (e2 != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        this.f66285a.l = currentTimeMillis;
                        com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_env", "last_app_env_time", Long.valueOf(currentTimeMillis));
                        com.bytedance.sdk.openadsdk.j.a.a().a(e2);
                    }
                    this.f66285a.m = false;
                }
            }
        }, 1);
    }
}
