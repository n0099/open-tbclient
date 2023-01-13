package com.baidu.tieba;

import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.optimization.quotasaver.QuotaSaver;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.n43;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class o43 extends i43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile j43 l;
    public final e13 m;
    public SwanAppActivity n;
    public boolean o;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(o43 o43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o43Var};
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (o43.p) {
                    Log.w("SwanImpl", "kill process myself");
                }
                Process.killProcess(Process.myPid());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947982235, "Lcom/baidu/tieba/o43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947982235, "Lcom/baidu/tieba/o43;");
                return;
            }
        }
        p = tk1.a;
    }

    public o43() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = new e13(this);
        this.o = false;
    }

    @Override // com.baidu.tieba.m43
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return q().E();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m43
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            n("flag_finish_activity", "flag_remove_task");
            di3.a0(new a(this));
        }
    }

    @Override // com.baidu.tieba.i43
    public sd4 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new u72(this);
        }
        return (sd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i43
    public t63 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new u63(this);
        }
        return (t63) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i43
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            QuotaSaver.l.o(this);
        }
    }

    @Override // com.baidu.tieba.m43
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.l == null) {
                return "";
            }
            return this.l.getAppId();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m43
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return q().k();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.m43
    public SwanAppCores m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return q().m();
        }
        return (SwanAppCores) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m43
    @NonNull
    public j43 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.l == null) {
                synchronized (this) {
                    if (this.l == null) {
                        this.l = new j43(this, "");
                    }
                }
            }
            return this.l;
        }
        return (j43) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m43
    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.l != null && this.l.E()) {
            this.l.s();
            G();
        }
    }

    @Override // com.baidu.tieba.m43
    public SwanAppActivity w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.n;
        }
        return (SwanAppActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m43
    @Nullable
    public e13 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.m;
        }
        return (e13) invokeV.objValue;
    }

    public static String T(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.equals(jSONObject.optString("token"), "swanubc")) {
                    return jSONObject.toString();
                }
            } catch (JSONException e) {
                if (p) {
                    e.printStackTrace();
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public final boolean U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return m43.o0.contains(str);
        }
        return invokeL.booleanValue;
    }

    public final boolean V(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return TextUtils.equals("update_tag_by_app_launch", str);
        }
        return invokeL.booleanValue;
    }

    public final boolean W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return TextUtils.equals("update_tag_by_prefetch", str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.m43
    public void r(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, swanAppActivity) == null) {
            this.n = null;
        }
    }

    @Override // com.baidu.tieba.m43
    public void t(SwanAppActivity swanAppActivity) {
        SwanAppActivity swanAppActivity2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, swanAppActivity) == null) && swanAppActivity != null && (swanAppActivity2 = this.n) != swanAppActivity) {
            if (swanAppActivity2 != null) {
                r(swanAppActivity2);
            }
            this.n = swanAppActivity;
        }
    }

    public final void X(@NonNull Bundle bundle, boolean z) {
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = bundle.getLong("launch_time");
            long j3 = currentTimeMillis - j2;
            long millis = TimeUnit.SECONDS.toMillis(10L);
            boolean z2 = false;
            z2 = (bundle.getBoolean("should_ignore_launch_time", false) || j2 <= 1 || j3 > millis) ? true : true;
            if (z2) {
                bundle.putLong("launch_time", currentTimeMillis);
                j2 = currentTimeMillis;
            }
            long j4 = bundle.getLong("start_activity_time");
            if (z2 || j4 < 1) {
                j4 = j2;
            }
            long j5 = bundle.getLong("receive_launch_intent_time");
            if (!z2 && j5 >= 1) {
                j = j5;
            } else {
                j = j4;
            }
            HybridUbcFlow p2 = ox2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("naStart");
            ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
            ubcFlowEvent.h(j2);
            p2.F(ubcFlowEvent);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_last_start");
            ubcFlowEvent2.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
            ubcFlowEvent2.h(j2);
            p2.F(ubcFlowEvent2);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("na_launch_activity");
            ubcFlowEvent3.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
            ubcFlowEvent3.h(j4);
            p2.F(ubcFlowEvent3);
            UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("na_receive_intent");
            ubcFlowEvent4.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
            ubcFlowEvent4.h(j);
            p2.F(ubcFlowEvent4);
            p2.D("process", String.valueOf(SwanAppProcessInfo.current()));
            if (z) {
                str = "1";
            } else {
                str = "0";
            }
            p2.D("reuse", str);
            long j6 = bundle.getLong("veloce_start_time", 0L);
            if (j6 > 0) {
                UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("na_veloce_start");
                ubcFlowEvent5.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                ubcFlowEvent5.h(j6);
                p2.F(ubcFlowEvent5);
            }
            long j7 = bundle.getLong("t7_loading_start", -1L);
            int i = (j7 > 0L ? 1 : (j7 == 0L ? 0 : -1));
            if (i > 0) {
                UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("na_t7_load_start");
                ubcFlowEvent6.h(j7);
                p2.F(ubcFlowEvent6);
            }
            long j8 = bundle.getLong("t7_loading_end", -1L);
            if (i > 0) {
                UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("na_t7_load_end");
                ubcFlowEvent7.h(j8);
                p2.F(ubcFlowEvent7);
            }
            Bundle bundle2 = bundle.getBundle("mExtraData");
            if (bundle2 != null) {
                String T = T(bundle2.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
                if (!TextUtils.isEmpty(T)) {
                    p2.D(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, T);
                }
                p2.D("abtest", bundle2.getString("aiapp_abtest_info", ""));
                long j9 = bundle2.getLong("click_time", -1L);
                if (j9 > 0) {
                    HybridUbcFlow p3 = ox2.p("startup");
                    UbcFlowEvent ubcFlowEvent8 = new UbcFlowEvent("user_action");
                    ubcFlowEvent8.h(j9);
                    p3.F(ubcFlowEvent8);
                }
            }
            ox2.n();
            this.l.W().G1(j4);
            this.l.W().B0(j4);
            wx2.h().start(j2);
            dz2.g().e("updateLaunchInfo");
            fb3.d();
            long j10 = bundle.getLong("launch_flag_for_statistic");
            long j11 = bundle.getLong("page_display_flag_for_statistic");
            if (j10 < 1 || j11 < 1 || currentTimeMillis - j10 > millis || currentTimeMillis - j11 > millis) {
                bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
                bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0074 A[Catch: all -> 0x01b3, TryCatch #0 {, blocks: (B:6:0x000b, B:10:0x0013, B:12:0x005c, B:14:0x0062, B:22:0x0074, B:23:0x0092, B:25:0x0098, B:28:0x00a0, B:30:0x00ac, B:32:0x00b6, B:34:0x00bc, B:36:0x00c2, B:37:0x00c5, B:41:0x00d8, B:43:0x00de, B:44:0x00e2, B:46:0x00f4, B:49:0x00fc, B:50:0x0102, B:52:0x0117, B:55:0x012e, B:56:0x013f, B:58:0x0143, B:63:0x014f, B:65:0x0168, B:69:0x0173, B:71:0x0184, B:74:0x018d, B:76:0x0197, B:77:0x01a7, B:17:0x0069), top: B:86:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0173 A[Catch: all -> 0x01b3, TryCatch #0 {, blocks: (B:6:0x000b, B:10:0x0013, B:12:0x005c, B:14:0x0062, B:22:0x0074, B:23:0x0092, B:25:0x0098, B:28:0x00a0, B:30:0x00ac, B:32:0x00b6, B:34:0x00bc, B:36:0x00c2, B:37:0x00c5, B:41:0x00d8, B:43:0x00de, B:44:0x00e2, B:46:0x00f4, B:49:0x00fc, B:50:0x0102, B:52:0x0117, B:55:0x012e, B:56:0x013f, B:58:0x0143, B:63:0x014f, B:65:0x0168, B:69:0x0173, B:71:0x0184, B:74:0x018d, B:76:0x0197, B:77:0x01a7, B:17:0x0069), top: B:86:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0184 A[Catch: all -> 0x01b3, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x000b, B:10:0x0013, B:12:0x005c, B:14:0x0062, B:22:0x0074, B:23:0x0092, B:25:0x0098, B:28:0x00a0, B:30:0x00ac, B:32:0x00b6, B:34:0x00bc, B:36:0x00c2, B:37:0x00c5, B:41:0x00d8, B:43:0x00de, B:44:0x00e2, B:46:0x00f4, B:49:0x00fc, B:50:0x0102, B:52:0x0117, B:55:0x012e, B:56:0x013f, B:58:0x0143, B:63:0x014f, B:65:0x0168, B:69:0x0173, B:71:0x0184, B:74:0x018d, B:76:0x0197, B:77:0x01a7, B:17:0x0069), top: B:86:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0197 A[Catch: all -> 0x01b3, TryCatch #0 {, blocks: (B:6:0x000b, B:10:0x0013, B:12:0x005c, B:14:0x0062, B:22:0x0074, B:23:0x0092, B:25:0x0098, B:28:0x00a0, B:30:0x00ac, B:32:0x00b6, B:34:0x00bc, B:36:0x00c2, B:37:0x00c5, B:41:0x00d8, B:43:0x00de, B:44:0x00e2, B:46:0x00f4, B:49:0x00fc, B:50:0x0102, B:52:0x0117, B:55:0x012e, B:56:0x013f, B:58:0x0143, B:63:0x014f, B:65:0x0168, B:69:0x0173, B:71:0x0184, B:74:0x018d, B:76:0x0197, B:77:0x01a7, B:17:0x0069), top: B:86:0x000b }] */
    @Override // com.baidu.tieba.m43
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void l(Bundle bundle, String str) {
        boolean z;
        long j;
        long j2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean D0;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, bundle, str) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                if (bundle == null) {
                    return;
                }
                String string = bundle.getString("mAppId");
                j12.k("SwanImpl", "updateSwanApp updateTag:" + str + ",old appId:" + getAppId() + ",new appId:" + string);
                String string2 = bundle.getString("launch_id");
                jy2.update(string2);
                HybridUbcFlow p2 = ox2.p("startup");
                boolean z6 = false;
                if (!ly2.b() ? p2.N(string2) : p2.u() && p2.N(string2)) {
                    z = false;
                    if (z) {
                        ox2.r("startup");
                        p2 = ox2.p("startup");
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("resetFlow");
                        ubcFlowEvent.a(true);
                        p2.F(ubcFlowEvent);
                        p2.N(string2);
                    }
                    if (!W(str) && !V(str)) {
                        boolean U = U(str);
                        if (TextUtils.isEmpty(string) && (!TextUtils.equals(string, getAppId()) || a22.d())) {
                            if (a22.d()) {
                                a22.e(str);
                            }
                            j = System.currentTimeMillis();
                            if (!TextUtils.isEmpty(n(new String[0]))) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (z5) {
                                bb3.d(3);
                            }
                            this.l = new j43(this, string);
                            z2 = z5;
                            j2 = currentTimeMillis2;
                            U = true;
                            z3 = true;
                        } else {
                            j = 0;
                            j2 = 0;
                            z2 = false;
                            z3 = false;
                        }
                        if (E()) {
                            if (U) {
                                SwanLauncher.g(bundle);
                                X(bundle, z2);
                            }
                            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("swan_app_update_start");
                            ubcFlowEvent2.h(currentTimeMillis);
                            ubcFlowEvent2.a(true);
                            p2.F(ubcFlowEvent2);
                            if (j > 0) {
                                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("swan_app_update_reset_start");
                                ubcFlowEvent3.h(j);
                                ubcFlowEvent3.a(true);
                                p2.F(ubcFlowEvent3);
                            }
                            long j3 = j2;
                            if (j3 > 0) {
                                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("swan_app_update_reset_ok");
                                ubcFlowEvent4.h(j3);
                                ubcFlowEvent4.a(true);
                                p2.F(ubcFlowEvent4);
                            }
                            j43 j43Var = this.l;
                            if (!z3 && this.l.I()) {
                                z4 = false;
                                D0 = j43Var.D0(bundle, str, z4);
                                this.l.I0(str);
                                UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("swan_app_update_end");
                                ubcFlowEvent5.a(true);
                                p2.F(ubcFlowEvent5);
                                if (!D0 && this.l.I()) {
                                    z6 = true;
                                }
                                if (z6) {
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString("app_update_tag", str);
                                    v("event_on_app_updated", bundle2);
                                }
                            }
                            z4 = true;
                            D0 = j43Var.D0(bundle, str, z4);
                            this.l.I0(str);
                            UbcFlowEvent ubcFlowEvent52 = new UbcFlowEvent("swan_app_update_end");
                            ubcFlowEvent52.a(true);
                            p2.F(ubcFlowEvent52);
                            if (!D0) {
                                z6 = true;
                            }
                            if (z6) {
                            }
                        }
                        if (z3) {
                            db2.U().P(z2);
                        }
                        return;
                    }
                    if (!TextUtils.equals(string, getAppId())) {
                        n("flag_not_unregister");
                        this.l = new j43(this, string);
                    }
                    this.l.K0(bundle);
                    this.l.I0(str);
                }
                z = true;
                if (z) {
                }
                if (!W(str)) {
                    boolean U2 = U(str);
                    if (TextUtils.isEmpty(string)) {
                    }
                    j = 0;
                    j2 = 0;
                    z2 = false;
                    z3 = false;
                    if (E()) {
                    }
                    if (z3) {
                    }
                    return;
                }
                if (!TextUtils.equals(string, getAppId())) {
                }
                this.l.K0(bundle);
                this.l.I0(str);
            }
        }
    }

    @Override // com.baidu.tieba.m43
    public synchronized String n(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, strArr)) == null) {
            synchronized (this) {
                if (this.o) {
                    return "";
                }
                this.o = true;
                String str = "";
                if (this.l != null && this.l.E()) {
                    str = this.l.C0(strArr);
                    this.l = null;
                    A((n43.a) new n43.a("event_on_app_reseted").A("event_params_reset_flags", strArr));
                    if (strArr == null || !Sets.newHashSet(strArr).contains("flag_not_unregister")) {
                        z03.e().h(new b13(2));
                    }
                }
                this.o = false;
                return str;
            }
        }
        return (String) invokeL.objValue;
    }
}
