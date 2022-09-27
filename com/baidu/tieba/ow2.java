package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes5.dex */
public class ow2 implements ei3<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile long a;

        /* renamed from: com.baidu.tieba.ow2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0360a {
            public static /* synthetic */ Interceptable $ic;
            public static a a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1098593275, "Lcom/baidu/tieba/ow2$a$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1098593275, "Lcom/baidu/tieba/ow2$a$a;");
                        return;
                    }
                }
                a = new a();
            }
        }

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

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C0360a.a : (a) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948046591, "Lcom/baidu/tieba/ow2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948046591, "Lcom/baidu/tieba/ow2;");
                return;
            }
        }
        a = vj1.a;
    }

    public ow2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ei3
    /* renamed from: b */
    public void a(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            c(hybridUbcFlow);
        }
    }

    @SuppressLint({"SwanDebugLog", "LogConditional"})
    public void c(HybridUbcFlow hybridUbcFlow) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hybridUbcFlow) == null) || hybridUbcFlow == null || hybridUbcFlow.f.isEmpty()) {
            return;
        }
        long f = hybridUbcFlow.f("slave_first_rendered", "master_dispatch_start");
        hf3.g.update((gf3<Long>) Long.valueOf(f));
        String str2 = "naStart";
        hf3.b.update((gf3<Long>) Long.valueOf(hybridUbcFlow.f("slave_first_rendered", "naStart")));
        String str3 = "aps_start_download";
        String str4 = "aps_end_req";
        hf3.c.update((gf3<Long>) Long.valueOf(hybridUbcFlow.f("aps_end_download", "aps_start_download", "aps_end_req", "aps_start_req", "naStart")));
        long f2 = hybridUbcFlow.f("na_first_meaningful_paint", "naStart");
        if (f2 < 1) {
            f2 = hybridUbcFlow.f("na_first_paint", "naStart");
        }
        long j = f2 >= 1 ? f2 : 1L;
        a.a().a = j;
        l33 b0 = l33.b0();
        if (b0 == null) {
            return;
        }
        if (a || kz2.d("aiapps_startup_reporter", false)) {
            int i = kz2.u().getInt("aiapps_startup_reporter_resolution", 100);
            String Z = b0.Z();
            if (TextUtils.isEmpty(Z)) {
                Z = "";
            }
            Log.i("StartupReporter", "\n\n  小程序启动性能报告: " + Z + " appID: " + (!TextUtils.isEmpty(b0.b) ? b0.b : "") + " speedLog\n");
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                sb.append("&");
            }
            boolean z = true;
            Log.i("StartupReporter", String.format(" Cost [%s] Delta Src  Total Action", sb.toString()));
            long g = hybridUbcFlow.f.get(0).g();
            Iterator<UbcFlowEvent> it = hybridUbcFlow.f.iterator();
            long j2 = 0;
            while (it.hasNext()) {
                UbcFlowEvent next = it.next();
                if (!next.b() || kz2.d("aiapps_startup_reporter_local_report", z)) {
                    String[] strArr = new String[2];
                    Iterator<UbcFlowEvent> it2 = it;
                    strArr[0] = next.a;
                    strArr[z ? 1 : 0] = str2;
                    long f3 = hybridUbcFlow.f(strArr);
                    boolean z2 = f3 < 0;
                    boolean z3 = f3 > j;
                    if (z2) {
                        f3 = 0;
                    }
                    if (z3) {
                        f3 = j;
                    }
                    long j3 = f3 - j2;
                    if (j3 < 0) {
                        str = str2;
                        j3 = 0;
                    } else {
                        str = str2;
                    }
                    long j4 = i;
                    String str5 = str3;
                    String str6 = str4;
                    int round = Math.round((float) ((f3 * j4) / j));
                    if (round > i) {
                        round = i;
                    }
                    int round2 = Math.round((float) ((j4 * j3) / j));
                    if (round2 > i) {
                        round2 = i;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    long j5 = j;
                    sb2.append(String.format(Locale.getDefault(), " %5d ", Long.valueOf(f3)));
                    sb2.append(z2 ? "<" : PreferencesUtil.LEFT_MOUNT);
                    for (int i3 = 0; i3 < i; i3++) {
                        if (i3 > round) {
                            sb2.append(".");
                        } else if (i3 > round2) {
                            sb2.append("=");
                        } else {
                            sb2.append("#");
                        }
                    }
                    sb2.append(z3 ? ">" : PreferencesUtil.RIGHT_MOUNT);
                    sb2.append(String.format(Locale.getDefault(), "%5d", Long.valueOf(j3)));
                    sb2.append(String.format("  %s", next.f()));
                    sb2.append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(next.g() - g)));
                    sb2.append(next.a);
                    if (next.b()) {
                        sb2.append("(LocalRecord)");
                    }
                    Log.i("StartupReporter", sb2.toString());
                    it = it2;
                    j2 = f3;
                    str2 = str;
                    j = j5;
                    str3 = str5;
                    str4 = str6;
                    z = true;
                }
            }
            String str7 = str2;
            String str8 = str3;
            String str9 = str4;
            long j6 = j;
            Log.i("StartupReporter", "Total  ： " + hybridUbcFlow.f.size());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\n========APS下载完成:" + hybridUbcFlow.f("aps_end_download", str7));
            sb3.append("\n========解压包时长:" + hybridUbcFlow.f("package_end_unzip", "first_anim_start", "aps_end_download"));
            sb3.append("\n========第一次setData的调用:" + hybridUbcFlow.f("slave_first_loaded", "slave_js_parsed"));
            sb3.append("\n========master第一次和slave通信:" + hybridUbcFlow.f("slave_first_loaded", "master_first_init_data"));
            sb3.append("\n========slave第一次收到数据:" + hybridUbcFlow.f("slave_first_recieve_data", "master_first_init_data"));
            sb3.append("\n========slave第一次渲染完成:" + hybridUbcFlow.f("slave_first_rendered", "slave_first_recieve_data"));
            sb3.append("\n========第一次动画时长:" + hybridUbcFlow.f("first_anim_end", "first_anim_start"));
            sb3.append("\n========第二次动画时长:" + hybridUbcFlow.f("second_anim_end", "second_anim_start"));
            sb3.append("\n\n核心指标--------");
            sb3.append("\n========aps接口时长:" + hybridUbcFlow.f(str9, "aps_start_req", str7));
            sb3.append("\n========aps纯下载时长:" + hybridUbcFlow.f("aps_end_download", str8, str9, "aps_start_req", str7));
            sb3.append("\n========");
            sb3.append("\n========准备启动时长:" + hybridUbcFlow.f("na_launch_activity", str7));
            sb3.append("\n========准备查库时长:" + hybridUbcFlow.f("na_query_db", str7));
            sb3.append("\n========Activity调起时长:" + hybridUbcFlow.f("frame_start_create", "na_launch_activity"));
            sb3.append("\n========");
            sb3.append("\n========预加载等待时长:" + hybridUbcFlow.f("na_pre_load_ok", "na_pre_load_check"));
            sb3.append("\n========主线程阻塞时长:" + hybridUbcFlow.f("na_post_to_main_end", "na_post_to_main_start"));
            sb3.append("\n========本地小程序包加载及渲染总时长:" + hybridUbcFlow.f("slave_first_rendered", "first_anim_start"));
            sb3.append("\n\n启动线性跟踪分段指标简报--------");
            sb3.append("\n========取包（网络开销，从小程序入口，到APS及前置接口等网络交互完成）:" + hybridUbcFlow.f("first_anim_start", str7));
            sb3.append("\n========安装（IO开销，从下载完成，到小程序包解压安装作业完成）:" + hybridUbcFlow.f("package_end_unzip", "first_anim_start"));
            sb3.append("\n========下载-安装（IO开销，从下载开始，到小程序包解压安装作业完成）:" + hybridUbcFlow.f("package_end_unzip", str8));
            sb3.append("\n========小程序框架启动总时长（NA开销，从开始，到 NA 准备完成）:" + hybridUbcFlow.f("master_dispatch_start", str7));
            sb3.append("\n========AppReady派发时长:" + hybridUbcFlow.f("fe_master_dispatch_start", "master_dispatch_start"));
            sb3.append("\n========小程序业务渲染总时长（H5开销，从 NA 准备完成，到页面渲染）:" + f);
            int optInt = hybridUbcFlow.m().optInt("type", -1);
            String h = hybridUbcFlow.h("preload_scene");
            String h2 = hybridUbcFlow.h("app_package_version");
            if (TextUtils.isEmpty(h)) {
                h = "-1";
            }
            String h3 = hybridUbcFlow.h("package_type");
            String str10 = TextUtils.isEmpty(h3) ? "-1" : h3;
            String h4 = hybridUbcFlow.h("preload");
            sb3.append("\n\n小程序启动总时长：========> " + j6 + " LaunchDiff=" + hybridUbcFlow.f(str7, "user_action"));
            sb3.append(hybridUbcFlow.d.contains("package_start_unzip") ^ true ? "(热启动)" : "(冷启动)");
            sb3.append("  relaunchType:" + optInt);
            sb3.append("  preloadType:" + h);
            sb3.append(" packageType:" + str10);
            sb3.append(" preload:" + h4);
            if (!TextUtils.isEmpty(h2)) {
                sb3.append(" packageVersion:" + h2);
            }
            Log.i("StartupReporter", "Report ： " + sb3.toString());
        }
    }
}
