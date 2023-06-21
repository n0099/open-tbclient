package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.devicescore.IDeviceScore;
import com.baidu.searchbox.download.center.clearcache.DiskUpdateListener;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k90 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile long b;
    public static volatile long c;
    public static volatile long d;
    public static volatile long e;
    public static volatile String f;
    public static volatile JSONObject g;
    public static volatile boolean h;
    public static volatile String i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            k90.h(2);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947867783, "Lcom/baidu/tieba/k90;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947867783, "Lcom/baidu/tieba/k90;");
                return;
            }
        }
        a = AppConfig.isDebug();
        b = 0L;
        c = 0L;
        d = 0L;
        e = 0L;
        f = "";
        h = false;
        i = "";
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            if (a) {
                Log.d("ExternalTransferStats", "resetStats");
            }
            b = 0L;
            c = 0L;
            d = 0L;
            e = 0L;
            g = null;
            f = "";
            h = false;
            i = "";
        }
    }

    public static synchronized void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            synchronized (k90.class) {
                c(str, String.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public static synchronized void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            synchronized (k90.class) {
                if ((!h && l90.a() == -1) || TextUtils.isEmpty(l90.c())) {
                    return;
                }
                if (a) {
                    Log.d("ExternalTransferStats", "addEvent id " + str + " value " + str2);
                }
                if (TextUtils.equals(str, "external_dispatch_start") && b == 0) {
                    b = Long.valueOf(str2).longValue();
                    if (a) {
                        Log.d("ExternalTransferStats", "set sSchemeDispatcherStartTimeStamp: " + b);
                    }
                } else if (TextUtils.equals(str, "external_dispatch_end") && c == 0) {
                    c = Long.valueOf(str2).longValue();
                    if (a) {
                        Log.d("ExternalTransferStats", "set sSchemeDispatcherEndTimeStamp: " + c);
                    }
                } else if (TextUtils.equals(str, "external_business_create") && d == 0) {
                    d = Long.valueOf(str2).longValue();
                    if (a) {
                        Log.d("ExternalTransferStats", "set sBusinessPageCreateTimeStamp: " + d);
                    }
                } else if (TextUtils.equals(str, "external_business_ui_ready") && e == 0) {
                    e = Long.valueOf(str2).longValue();
                    if (a) {
                        Log.d("ExternalTransferStats", "set sBusinessPageUiReadyTimeStamp: " + e);
                    }
                } else if (TextUtils.equals(str, "c_dom_first_screen_paint") && f == "feed") {
                    e = Long.valueOf(str2).longValue();
                }
                if (!TextUtils.equals(str, "external_dispatch_start") && !TextUtils.equals(str, "external_dispatch_end") && !TextUtils.equals(str, "external_business_create") && !TextUtils.equals(str, "external_business_ui_ready")) {
                    d(str, str2);
                }
            }
        }
    }

    public static synchronized void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            synchronized (k90.class) {
                try {
                    if (g == null) {
                        g = new JSONObject();
                    }
                    if (!g.has(str)) {
                        g.put(str, str2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return i;
        }
        return (String) invokeV.objValue;
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            b = 0L;
            c = 0L;
            d = 0L;
            e = 0L;
            g = null;
            f = "";
            h = true;
            i = str;
            ExecutorUtilsExt.delayPostOnElastic(new a(), "asyncUploadExternalTransferInfo", 3, 15000L);
        }
    }

    public static synchronized void h(int i2) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, null, i2) == null) {
            synchronized (k90.class) {
                if (!h) {
                    return;
                }
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager == null) {
                    f();
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("from", "research");
                    IDeviceScore iDeviceScore = (IDeviceScore) ServiceManager.getService(IDeviceScore.SERVICE_REFERENCE);
                    if (iDeviceScore != null) {
                        jSONObject.put("device_score", iDeviceScore.getFinalScore(AppRuntime.getAppContext()));
                    }
                    jSONObject.put("upload_type", i2);
                    if (d == 0) {
                        jSONObject.put("type", "");
                    } else {
                        long b2 = l90.b();
                        if (b2 != 0 && d - b2 < 0) {
                            jSONObject.put("type", "normal");
                        }
                        jSONObject.put("type", "quick");
                    }
                    jSONObject.put("page", f);
                    jSONObject.put("source", l90.c());
                    if (g90.a()) {
                        jSONObject.put("boot_type", "cold_boot");
                        j = l90.a();
                    } else {
                        jSONObject.put("boot_type", "warm_boot");
                        j = b;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(DiskUpdateListener.BEGIN_TIME, l90.a());
                    if (b != 0) {
                        long j2 = b - j;
                        if (j2 >= 0 && j2 < 60000) {
                            jSONObject2.put("dispatcher_start_duration", j2);
                        } else {
                            jSONObject2.put("dispatcher_start_duration", -1);
                        }
                    } else {
                        jSONObject2.put("dispatcher_start_duration", -1);
                    }
                    if (c != 0) {
                        long j3 = c - j;
                        if (j3 >= 0 && j3 < 60000) {
                            jSONObject2.put("dispatcher_duration", j3);
                        } else {
                            jSONObject2.put("dispatcher_duration", -1);
                        }
                    } else {
                        jSONObject2.put("dispatcher_duration", -1);
                    }
                    if (d != 0) {
                        long j4 = d - j;
                        if (j4 >= 0 && j4 < 60000) {
                            jSONObject2.put("will_show_duration", j4);
                        } else {
                            jSONObject2.put("will_show_duration", -1);
                        }
                    } else {
                        jSONObject2.put("will_show_duration", -1);
                    }
                    if (e != 0) {
                        long j5 = e - j;
                        if (j5 >= 0 && j5 < 60000) {
                            jSONObject2.put("duration", e - j);
                        } else {
                            jSONObject2.put("duration", -1);
                        }
                    } else {
                        jSONObject2.put("duration", -1);
                    }
                    jSONObject2.put("addition_info", g);
                    jSONObject.put("ext", jSONObject2);
                    uBCManager.onEvent("1090", jSONObject.toString());
                    if (a) {
                        Log.d("ExternalTransferStats", jSONObject.toString());
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                f();
            }
        }
    }
}
