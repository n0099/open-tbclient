package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
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
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.api.plugin.g;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ScheduledExecutorService f62565a;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences f62566b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f62567c;

    /* renamed from: d  reason: collision with root package name */
    public static Map<String, String> f62568d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1462304168, "Lcom/bytedance/sdk/openadsdk/api/plugin/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1462304168, "Lcom/bytedance/sdk/openadsdk/api/plugin/e;");
                return;
            }
        }
        f62565a = Executors.newSingleThreadScheduledExecutor(new g.a("tt_pangle_thread_pl_report"));
        f62567c = false;
        f62568d = new HashMap();
    }

    public static void c(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, str, jSONObject) == null) || jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString("event_name", str);
            bundle.putString("event_extra", jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
        } else if (f62567c) {
        } else {
            f62565a.execute(new Runnable(str, jSONObject) { // from class: com.bytedance.sdk.openadsdk.api.plugin.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f62569a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ JSONObject f62570b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62569a = str;
                    this.f62570b = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        e.b(e.d(this.f62569a, this.f62570b));
                    }
                }
            });
        }
    }

    public static JSONObject d(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put("support_abi", Arrays.toString(Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2}));
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("ad_sdk_version", "4.0.1.1");
                jSONObject3.put("plugin_version", "4.0.1.1");
                jSONObject3.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject3.put("is_plugin", true);
                jSONObject3.put("event_extra", jSONObject.toString());
                jSONObject3.put("type", str);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("model", Build.MODEL);
                jSONObject4.put("vendor", Build.MANUFACTURER);
                jSONObject4.put("imei", f62568d.get("imei"));
                jSONObject4.put("oaid", f62568d.get("oaid"));
                jSONObject3.put("device_info", jSONObject4);
                jSONArray.put(jSONObject3);
                jSONObject2.put("stats_list", jSONArray);
            } catch (JSONException unused) {
            }
            return jSONObject2;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            f62566b = context.getSharedPreferences("tt_sdk_settings", 0);
        }
    }

    public static String b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jSONObject)) == null) {
            SharedPreferences sharedPreferences = f62566b;
            return com.bytedance.sdk.openadsdk.api.a.c.a().a(true, String.format("https://%s%s", sharedPreferences != null ? sharedPreferences.getString("url_alog", "pangolin.snssdk.com") : "pangolin.snssdk.com", "/api/ad/union/sdk/stats/batch/"), com.bytedance.sdk.openadsdk.api.b.b.a(jSONObject).toString().getBytes());
        }
        return (String) invokeL.objValue;
    }

    public static final void a(int i2, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("duration", Long.valueOf(j));
                jSONObject.putOpt("code", Integer.valueOf(i2));
                jSONObject.putOpt("message", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c("plugin_load_failed", jSONObject);
        }
    }

    public static void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, bundle) == null) || bundle == null) {
            return;
        }
        try {
            String string = bundle.getString("event_name");
            String string2 = bundle.getString("event_extra");
            b(d(string, TextUtils.isEmpty(string2) ? new JSONObject() : new JSONObject(string2)));
        } catch (Exception unused) {
        }
    }

    public static void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, jSONObject) == null) {
            c("zeus_" + str, jSONObject);
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || f62567c) {
            return;
        }
        try {
            f62567c = true;
            f62565a.shutdown();
        } catch (Throwable unused) {
        }
    }

    public static void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bundle) == null) || f62567c) {
            return;
        }
        f62565a.execute(new Runnable(bundle) { // from class: com.bytedance.sdk.openadsdk.api.plugin.e.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Bundle f62571a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bundle};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f62571a = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    e.b(this.f62571a);
                }
            }
        });
    }

    public static void a(AdConfig adConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, adConfig) == null) || adConfig == null) {
            return;
        }
        f62568d.put("appid", adConfig.getAppId());
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                f62568d.put("oaid", customController.getDevOaid());
                f62568d.put("imei", customController.getDevImei());
            } catch (Exception unused) {
            }
        }
    }
}
