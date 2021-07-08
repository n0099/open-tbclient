package com.bytedance.sdk.openadsdk.core.j;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.e.v;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> A;
    public int B;
    public int C;
    public long D;
    public int E;
    public int F;
    public int G;
    public String H;
    public String I;
    public int J;
    public int K;
    public Set<String> L;
    public String M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public volatile boolean R;
    public float S;
    public final s T;
    public float U;
    public int V;
    public int W;
    public int X;

    /* renamed from: a  reason: collision with root package name */
    public int f30306a;

    /* renamed from: b  reason: collision with root package name */
    public int f30307b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, a> f30308c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, i> f30309d;

    /* renamed from: e  reason: collision with root package name */
    public String f30310e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<String> f30311f;

    /* renamed from: g  reason: collision with root package name */
    public String f30312g;

    /* renamed from: h  reason: collision with root package name */
    public Set<String> f30313h;

    /* renamed from: i  reason: collision with root package name */
    public final List<e> f30314i;
    public String j;
    public int k;
    public int l;
    public int m;
    public int n;
    public JSONObject o;
    public String p;
    public String q;
    public String r;
    public int s;
    public int t;
    public String u;
    public String v;
    public int w;
    public int x;
    public long y;
    public Set<String> z;

    public h() {
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
        this.f30306a = Integer.MAX_VALUE;
        this.f30307b = Integer.MAX_VALUE;
        this.f30308c = new HashMap();
        this.f30309d = new HashMap();
        this.f30311f = new HashSet();
        this.f30313h = Collections.synchronizedSet(new HashSet());
        this.f30314i = new CopyOnWriteArrayList();
        this.k = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.o = null;
        this.p = "";
        this.s = Integer.MAX_VALUE;
        this.t = Integer.MAX_VALUE;
        this.w = Integer.MAX_VALUE;
        this.x = Integer.MAX_VALUE;
        this.y = 0L;
        this.z = Collections.synchronizedSet(new HashSet());
        this.A = Collections.synchronizedSet(new HashSet());
        this.B = Integer.MAX_VALUE;
        this.C = Integer.MAX_VALUE;
        this.D = 2147483647L;
        this.E = Integer.MAX_VALUE;
        this.F = Integer.MAX_VALUE;
        this.G = Integer.MAX_VALUE;
        this.H = null;
        this.I = null;
        this.J = Integer.MAX_VALUE;
        this.K = Integer.MAX_VALUE;
        this.L = Collections.synchronizedSet(new HashSet());
        this.M = null;
        this.N = Integer.MAX_VALUE;
        this.O = Integer.MAX_VALUE;
        this.P = Integer.MAX_VALUE;
        this.Q = 3;
        this.R = false;
        this.S = -1.0f;
        this.U = 2.1474836E9f;
        this.V = Integer.MAX_VALUE;
        this.W = Integer.MAX_VALUE;
        this.X = 2;
        this.T = s.a("tt_sdk_settings", o.a());
    }

    private void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.r = null;
            this.q = null;
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_sdk_settings", "ab_test_version");
                com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_sdk_settings", "ab_test_param");
                return;
            }
            this.T.b("ab_test_version");
            this.T.b("ab_test_param");
        }
    }

    private int a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65538, this, z)) == null) ? z ? 20 : 5 : invokeZ.intValue;
    }

    public static a b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("code_id");
            int optInt = jSONObject.optInt("auto_play", 1);
            int optInt2 = jSONObject.optInt("voice_control", 1);
            int optInt3 = jSONObject.optInt("rv_preload", 2);
            int optInt4 = jSONObject.optInt("nv_preload", 1);
            int optInt5 = jSONObject.optInt("proportion_watching", 100);
            int optInt6 = jSONObject.optInt("skip_time_displayed", 0);
            int optInt7 = jSONObject.optInt("video_skip_result", 2);
            int optInt8 = jSONObject.optInt("reg_creative_control", 1);
            int optInt9 = jSONObject.optInt("play_bar_show_time", 3);
            int optInt10 = jSONObject.optInt("rv_skip_time", -1);
            int optInt11 = jSONObject.optInt("endcard_close_time", -1);
            int optInt12 = jSONObject.optInt("playable_endcard_close_time", -1);
            int optInt13 = jSONObject.optInt("voice_control", 2);
            int optInt14 = jSONObject.optInt("if_show_win", 1);
            int optInt15 = jSONObject.optInt("sp_preload", 0);
            int optInt16 = jSONObject.optInt("stop_time", 1500);
            int optInt17 = jSONObject.optInt("native_playable_delay", 2);
            int optInt18 = jSONObject.optInt("time_out_control", -1);
            int optInt19 = jSONObject.optInt("playable_duration_time", 20);
            int optInt20 = jSONObject.optInt("playable_close_time", -1);
            int optInt21 = jSONObject.optInt("playable_reward_type", 0);
            int optInt22 = jSONObject.optInt("reward_is_callback", 0);
            int optInt23 = jSONObject.optInt("iv_skip_time", 5);
            boolean optBoolean = jSONObject.optBoolean("close_on_click", false);
            JSONArray optJSONArray = jSONObject.optJSONArray("parent_tpl_ids");
            int optInt24 = jSONObject.optInt("splash_load_type", 2);
            int optInt25 = jSONObject.optInt("splash_buffer_time", 100);
            if (!j(optInt2)) {
                optInt2 = 1;
            }
            if (!j(optInt13)) {
                optInt13 = 1;
            }
            return a.a().a(optString).n(optInt).o(optInt2).p(optInt3).q(optInt4).r(optInt5).s(optInt6).t(optInt7).u(optInt8).m(optInt9).l(optInt10).j(optInt11).i(optInt13).k(optInt12).v(optInt14).f(optInt15).g(optInt16).h(optInt17).e(optInt18).a(optInt20).d(optInt19).b(optInt21).c(optInt22).w(optInt24).x(optInt25).y(optInt23).a(optJSONArray).a(optBoolean);
        }
        return (a) invokeL.objValue;
    }

    private int c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, jSONObject)) == null) {
            int optInt = jSONObject.optInt("splash_check_type", 1);
            this.w = optInt;
            if (optInt == 0 || optInt == 1) {
                return this.w;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? i2 == 1 || i2 == 2 : invokeI.booleanValue;
    }

    private void s(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, str) == null) || str == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                e eVar = new e();
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                eVar.f30293a = optJSONObject.optString("action");
                eVar.f30294b = optJSONObject.optString("service");
                eVar.f30295c = optJSONObject.optString(AsInstallService.SCHEME_PACKAGE_ADDED);
                eVar.f30296d = optJSONObject.optInt("wakeup_interval");
                this.f30314i.add(eVar);
            }
            d.c().d();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.W == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.W = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "icon_show_time", 5);
                } else {
                    this.W = this.T.b("icon_show_time", 5);
                }
            }
            return this.W;
        }
        return invokeV.intValue;
    }

    public List<String> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.y + 172800000 < System.currentTimeMillis()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : this.z) {
                arrayList.add(str);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.N == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.N = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "sp_key_if_sp_cache", 0);
                } else {
                    this.N = this.T.b("sp_key_if_sp_cache", 0);
                }
            }
            return this.N;
        }
        return invokeV.intValue;
    }

    public List<String> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.y + 172800000 < System.currentTimeMillis()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : this.A) {
                arrayList.add(str);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.x == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.x = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "app_list_control", 0);
                } else {
                    this.x = this.T.b("app_list_control", 0);
                }
            }
            return this.x == 1;
        }
        return invokeV.booleanValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.J == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.J = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max_tpl_cnts", 100);
                } else {
                    this.J = this.T.b("max_tpl_cnts", 100);
                }
            }
            return this.J;
        }
        return invokeV.intValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.K == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.K = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", 3000);
                } else {
                    this.K = this.T.b("fetch_tpl_timeout_ctrl", 3000);
                }
            }
            if (this.K <= 0) {
                this.K = 3000;
            }
            return this.K;
        }
        return invokeV.intValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.P == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.P = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "webview_cache_count", 20);
                } else {
                    this.P = this.T.b("webview_cache_count", 20);
                }
            }
            int i2 = this.P;
            if (i2 < 0) {
                return 20;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public String[] I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.L == null || this.L.size() == 0) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.L = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "gecko_hosts", (Set<String>) null);
                } else {
                    this.L = this.T.b("gecko_hosts", (Set<String>) null);
                }
                Set<String> a2 = a(this.L);
                this.L = a2;
                if (a2 != null) {
                    if (a2.size() == 0) {
                    }
                }
                return null;
            }
            return (String[]) this.L.toArray(new String[0]);
        }
        return (String[]) invokeV.objValue;
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.F == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.F = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "vbtt", 5);
                } else {
                    this.F = this.T.b("vbtt", 5);
                }
            }
            return this.F;
        }
        return invokeV.intValue;
    }

    public List<e> K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f30314i.isEmpty()) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    s(com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "push_config", (String) null));
                } else {
                    s(this.T.b("push_config", (String) null));
                }
            }
            return this.f30314i;
        }
        return (List) invokeV.objValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.R : invokeV.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.O == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.O = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_pre_connect", 0);
                } else {
                    this.O = this.T.b("if_pre_connect", 0);
                }
            }
            return this.O == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.V == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.V = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "read_video_from_cache", 1);
                } else {
                    this.V = this.T.b("read_video_from_cache", 1);
                }
            }
            return this.V == 1;
        }
        return invokeV.booleanValue;
    }

    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.X : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.j.c
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                this.R = true;
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.H = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "url_ads", "pangolin.snssdk.com");
                    this.I = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "url_alog", "extlog.snssdk.com/service/2/app_log/");
                    this.j = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "xpath", "");
                    this.D = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "duration", 10000L);
                    this.E = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max", 50);
                    this.k = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_network", 1);
                    this.l = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_size", 30);
                    this.m = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_storage_internal", 1);
                    this.F = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "vbtt", 5);
                    this.G = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_template", 3600);
                    this.f30312g = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "template_ids", (String) null);
                    this.q = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ab_test_version", (String) null);
                    this.r = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ab_test_param", (String) null);
                    this.s = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_wifi_enable", 1);
                    this.t = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_page_count", 5);
                    this.u = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "pyload_h5", (String) null);
                    this.v = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "playableLoadH5Url", (String) null);
                    this.w = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_check_type", 1);
                    this.B = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_both_open", 0);
                    this.C = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "support_tnc", 1);
                    this.f30310e = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "tpl_infos", (String) null);
                    this.O = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_pre_connect", 0);
                    this.U = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "global_rate", 1.0f);
                    this.x = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "app_list_control", 0);
                    this.J = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max_tpl_cnts", 100);
                    this.K = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", 3000);
                    this.P = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "webview_cache_count", 20);
                    this.Q = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "webview_render_concurrent_count", 3);
                    if (this.L != null) {
                        this.L.clear();
                    }
                    Set<String> b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "gecko_hosts", (Set<String>) null);
                    this.L = b2;
                    this.L = a(b2);
                    this.y = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "hit_app_list_time", 0L);
                    this.z.clear();
                    this.f30306a = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_splash_switch", 0);
                    this.f30307b = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_load_splash_time", -1);
                    this.N = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "sp_key_if_sp_cache", 0);
                    this.W = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "icon_show_time", 5);
                    this.M = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
                    Set<String> b3 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "hit_app_list_data", (Set<String>) null);
                    if (b3 != null && !b3.isEmpty()) {
                        for (String str : b3) {
                            this.z.add(str);
                        }
                    }
                    this.A.clear();
                    Set<String> b4 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "scheme_list_data", (Set<String>) null);
                    if (b4 != null && !b4.isEmpty()) {
                        for (String str2 : b4) {
                            this.A.add(str2);
                        }
                    }
                    s(com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "push_config", (String) null));
                    String b5 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ad_slot_conf", (String) null);
                    if (!TextUtils.isEmpty(b5)) {
                        try {
                            JSONArray jSONArray = new JSONArray(b5);
                            int length = jSONArray.length();
                            if (length > 0) {
                                this.f30308c.clear();
                                for (int i2 = 0; i2 < length; i2++) {
                                    a b6 = b(jSONArray.optJSONObject(i2));
                                    if (b6 != null) {
                                        this.f30308c.put(b6.f30271a, b6);
                                    }
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    String b7 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "download_sdk_config", "");
                    this.p = b7;
                    if (!TextUtils.isEmpty(b7)) {
                        try {
                            this.o = new JSONObject(this.p);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    this.n = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "enable_download_opt", 0);
                    this.S = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "call_stack_rate", 0.0f);
                    this.V = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "read_video_from_cache", 1);
                    this.X = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "brand_video_cache_count", 2);
                    com.bytedance.sdk.openadsdk.downloadnew.a.g.c();
                    return;
                }
                this.H = this.T.b("url_ads", "pangolin.snssdk.com");
                this.I = this.T.b("url_alog", "extlog.snssdk.com/service/2/app_log/");
                this.j = this.T.b("xpath", "");
                this.D = this.T.b("duration", 10000L);
                this.E = this.T.b("max", 50);
                this.k = this.T.b("download_config_dl_network", 1);
                this.l = this.T.b("download_config_dl_size", 30);
                this.m = this.T.b("download_config_storage_internal", 1);
                this.G = this.T.b("fetch_template", 3600);
                this.q = this.T.a("ab_test_version");
                this.r = this.T.a("ab_test_param");
                this.F = this.T.b("vbtt", 5);
                this.f30312g = this.T.b("template_ids", (String) null);
                this.s = this.T.b("web_info_wifi_enable", 1);
                this.t = this.T.b("web_info_page_count", 5);
                this.u = this.T.b("pyload_h5", (String) null);
                this.v = this.T.b("playableLoadH5Url", (String) null);
                this.w = this.T.b("splash_check_type", 1);
                this.B = this.T.b("if_both_open", 0);
                this.C = this.T.b("support_tnc", 1);
                this.f30310e = this.T.b("tpl_infos", (String) null);
                this.O = this.T.b("if_pre_connect", 0);
                this.U = this.T.b("global_rate", 1.0f);
                this.x = this.T.b("app_list_control", 0);
                this.J = this.T.b("max_tpl_cnts", 100);
                this.K = this.T.b("fetch_tpl_timeout_ctrl", 3000);
                this.P = this.T.b("webview_cache_count", 20);
                this.Q = this.T.b("webview_render_concurrent_count", 3);
                if (this.L != null) {
                    this.L.clear();
                }
                Set<String> b8 = this.T.b("gecko_hosts", (Set<String>) null);
                this.L = b8;
                this.L = a(b8);
                this.y = this.T.b("hit_app_list_time", 0L);
                this.z.clear();
                this.f30306a = this.T.b("circle_splash_switch", 0);
                this.f30307b = this.T.b("circle_load_splash_time", -1);
                this.M = this.T.b("dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
                this.N = this.T.b("sp_key_if_sp_cache", 0);
                this.W = this.T.b("icon_show_time", 5);
                Set<String> b9 = this.T.b("hit_app_list_data", (Set<String>) null);
                if (b9 != null && !b9.isEmpty()) {
                    for (String str3 : b9) {
                        this.z.add(str3);
                    }
                }
                this.A.clear();
                Set<String> b10 = this.T.b("scheme_list_data", (Set<String>) null);
                if (b10 != null && !b10.isEmpty()) {
                    for (String str4 : b10) {
                        this.A.add(str4);
                    }
                }
                s(this.T.b("push_config", (String) null));
                String b11 = this.T.b("ad_slot_conf", (String) null);
                if (!TextUtils.isEmpty(b11)) {
                    try {
                        JSONArray jSONArray2 = new JSONArray(b11);
                        int length2 = jSONArray2.length();
                        if (length2 > 0) {
                            this.f30308c.clear();
                            for (int i3 = 0; i3 < length2; i3++) {
                                a b12 = b(jSONArray2.optJSONObject(i3));
                                if (b12 != null) {
                                    this.f30308c.put(b12.f30271a, b12);
                                }
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                String b13 = this.T.b("download_sdk_config", "");
                this.p = b13;
                if (!TextUtils.isEmpty(b13)) {
                    try {
                        this.o = new JSONObject(this.p);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                this.n = this.T.b("enable_download_opt", 0);
                this.S = this.T.b("call_stack_rate", 0.0f);
                this.V = this.T.b("read_video_from_cache", 1);
                this.X = this.T.b("brand_video_cache_count", 2);
                com.bytedance.sdk.openadsdk.downloadnew.a.g.c();
                return;
            }
        }
    }

    @NonNull
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (TextUtils.isEmpty(this.I)) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.I = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "url_alog", "extlog.snssdk.com/service/2/app_log/");
                } else {
                    this.I = this.T.b("url_alog", "extlog.snssdk.com/service/2/app_log/");
                }
                if (TextUtils.isEmpty(this.I)) {
                    this.I = "extlog.snssdk.com/service/2/app_log/";
                }
            }
            return this.I;
        }
        return (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.C == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.C = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "support_tnc", 1);
                } else {
                    this.C = this.T.b("support_tnc", 1);
                }
            }
            return this.C == 1;
        }
        return invokeV.booleanValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.k == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.k = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_network", 1);
                } else {
                    this.k = this.T.b("download_config_dl_network", 1);
                }
            }
            return this.k;
        }
        return invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (this.l == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.l = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_size", 30);
                } else {
                    this.l = this.T.b("download_config_dl_size", 30);
                }
            }
            return this.l * 1024 * 1024;
        }
        return invokeV.intValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (TextUtils.isEmpty(this.q)) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.q = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ab_test_version", (String) null);
                } else {
                    this.q = this.T.a("ab_test_version");
                }
            }
            return this.q;
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (TextUtils.isEmpty(this.r)) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.r = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ab_test_param", (String) null);
                } else {
                    this.r = this.T.a("ab_test_param");
                }
            }
            return this.r;
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (TextUtils.isEmpty(this.j)) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.j = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "xpath", "");
                } else {
                    this.j = this.T.b("xpath", "");
                }
            }
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.D == 2147483647L) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.D = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "duration", 10000L);
                } else {
                    this.D = this.T.b("duration", 10000L);
                }
            }
            return this.D;
        }
        return invokeV.longValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.E == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.E = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max", 50);
                } else {
                    this.E = this.T.b("max", 50);
                }
            }
            return this.E;
        }
        return invokeV.intValue;
    }

    public float m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.S < 0.0f) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.S = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "call_stack_rate", 0.0f);
                } else {
                    this.S = this.T.b("call_stack_rate", 0.0f);
                }
            }
            return this.S;
        }
        return invokeV.floatValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.t == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.t = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_page_count", 5);
                } else {
                    this.t = this.T.b("web_info_page_count", 5);
                }
            }
            return this.t;
        }
        return invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (TextUtils.isEmpty(this.u)) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.u = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "pyload_h5", (String) null);
                } else {
                    this.u = this.T.b("pyload_h5", (String) null);
                }
            }
            return this.u;
        }
        return (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            if (TextUtils.isEmpty(this.v)) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.v = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "playableLoadH5Url", (String) null);
                } else {
                    this.v = this.T.b("playableLoadH5Url", (String) null);
                }
            }
            return this.v;
        }
        return (String) invokeV.objValue;
    }

    public JSONObject q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (this.o == null) {
                String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "download_sdk_config", "");
                this.p = b2;
                if (!TextUtils.isEmpty(b2)) {
                    try {
                        this.o = new JSONObject(this.p);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return this.o;
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            if (this.n == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.n = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "enable_download_opt", 0);
                } else {
                    this.n = this.T.b("enable_download_opt", 0);
                }
            }
            return this.n == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? s() == 1 : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (this.s == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.s = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_wifi_enable", 1);
                } else {
                    this.s = this.T.b("web_info_wifi_enable", 1);
                }
            }
            return this.s == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (this.U == 2.1474836E9f) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.U = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "global_rate", 1.0f);
                } else {
                    this.U = this.T.b("global_rate", 1.0f);
                }
            }
            return ((float) ((int) this.U)) == 1.0f;
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (this.m == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.m = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_storage_internal", 1);
                } else {
                    this.m = this.T.b("download_config_storage_internal", 1);
                }
            }
            return this.m == 1;
        }
        return invokeV.booleanValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (this.f30306a == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.f30306a = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_splash_switch", 0);
                } else {
                    this.f30306a = this.T.b("circle_splash_switch", 0);
                }
            }
            return this.f30306a;
        }
        return invokeV.intValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (this.f30307b == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.f30307b = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_load_splash_time", -1);
                } else {
                    this.f30307b = this.T.b("circle_load_splash_time", -1);
                }
            }
            return this.f30307b;
        }
        return invokeV.intValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            if (TextUtils.isEmpty(this.M)) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.M = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
                } else {
                    this.M = this.T.b("dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
                }
            }
            return this.M;
        }
        return (String) invokeV.objValue;
    }

    private a t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            return a.a().a(str).n(1).o(!this.f30311f.contains(str) ? 1 : 0).p(2).q(1).r(100).s(0).u(1).m(3).l(-1).j(-1).i(2).k(-1).v(1).e(-1).a(-1).d(20).w(2).x(100).y(5).a(false).a((JSONArray) null);
        }
        return (a) invokeL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.H = "api-access.pangolin-sdk-toutiao-b.com";
        }
    }

    public int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) ? q(String.valueOf(str)).s : invokeL.intValue;
    }

    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) ? i2 != 0 && o.h().q(String.valueOf(i2)).n == 1 : invokeI.booleanValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) ? str == null || o.h().q(String.valueOf(str)).p == 0 : invokeL.booleanValue;
    }

    public int f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            if (str == null) {
                return 1500;
            }
            return o.h().q(String.valueOf(str)).q;
        }
        return invokeL.intValue;
    }

    public int g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) ? o.h().q(String.valueOf(str)).k : invokeL.intValue;
    }

    public JSONArray h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) {
            try {
                Set<String> b2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(str);
                if (b2 != null && b2.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str2 : b2) {
                        v a2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(str2);
                        if (a2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("id", a2.b());
                            jSONObject.put(PackageTable.MD5, a2.c());
                            jSONArray.put(jSONObject);
                        }
                    }
                    return jSONArray;
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }

    public boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
            try {
                a q = o.h().q(String.valueOf(str));
                if (q != null) {
                    return q.z != null;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public int j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, str)) == null) ? q(String.valueOf(str)).f30278h : invokeL.intValue;
    }

    public int k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, str)) == null) ? q(str).j : invokeL.intValue;
    }

    public int l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
            if (str == null) {
                return 0;
            }
            return o.h().q(String.valueOf(str)).v;
        }
        return invokeL.intValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) ? q(String.valueOf(str)).w == 0 : invokeL.booleanValue;
    }

    public int n(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
            if (str != null && (i2 = o.h().q(String.valueOf(str)).t) > 0) {
                return i2;
            }
            return 20;
        }
        return invokeL.intValue;
    }

    public int o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, str)) == null) {
            if (str == null) {
                return -1;
            }
            return o.h().q(String.valueOf(str)).l;
        }
        return invokeL.intValue;
    }

    public int p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, str)) == null) {
            if (str == null) {
                return -1;
            }
            return o.h().q(String.valueOf(str)).m;
        }
        return invokeL.intValue;
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.f30311f.add(str);
        }
    }

    public a q(String str) {
        InterceptResult invokeL;
        JSONArray jSONArray;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) {
            if (this.f30308c.size() == 0) {
                String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ad_slot_conf", (String) null);
                if (!TextUtils.isEmpty(b2)) {
                    try {
                        synchronized (this.f30308c) {
                            if (this.f30308c.size() == 0 && (length = (jSONArray = new JSONArray(b2)).length()) > 0) {
                                for (int i2 = 0; i2 < length; i2++) {
                                    a b3 = b(jSONArray.optJSONObject(i2));
                                    if (b3 != null) {
                                        this.f30308c.put(b3.f30271a, b3);
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            a aVar = this.f30308c.get(str);
            return aVar == null ? t(str) : aVar;
        }
        return (a) invokeL.objValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) ? str == null || o.h().q(String.valueOf(str)).o == 1 : invokeL.booleanValue;
    }

    public int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) ? q(String.valueOf(i2)).f30279i : invokeI.intValue;
    }

    public int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            int i3 = q(String.valueOf(i2)).A;
            if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 3) {
                return i3;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) ? q(String.valueOf(i2)).B : invokeI.intValue;
    }

    public boolean i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i2)) == null) ? q(String.valueOf(i2)).y : invokeI.booleanValue;
    }

    public int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) ? q(String.valueOf(i2)).f30272b : invokeI.intValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (this.w == Integer.MAX_VALUE) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.w = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_check_type", 1);
                } else {
                    this.w = this.T.b("splash_check_type", 1);
                }
            }
            return this.w;
        }
        return invokeV.intValue;
    }

    public int h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) ? q(String.valueOf(i2)).x : invokeI.intValue;
    }

    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (TextUtils.isEmpty(this.H)) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    this.H = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "url_ads", "pangolin.snssdk.com");
                } else {
                    this.H = this.T.b("url_ads", "pangolin.snssdk.com");
                }
                if (TextUtils.isEmpty(this.H)) {
                    this.H = "pangolin.snssdk.com";
                }
            }
            return this.H;
        }
        return (String) invokeV.objValue;
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) ? q(String.valueOf(i2)).f30273c == 1 : invokeI.booleanValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) ? q(String.valueOf(str)).f30277g == 1 : invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0297  */
    @Override // com.bytedance.sdk.openadsdk.core.j.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NonNull JSONObject jSONObject) {
        String str;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONObject) == null) {
            this.M = jSONObject.optString("dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
            this.H = jSONObject.optString("ads_url", "pangolin.snssdk.com");
            this.I = jSONObject.optString("app_log_url", "extlog.snssdk.com/service/2/app_log/");
            this.j = jSONObject.optString("xpath");
            JSONObject optJSONObject = jSONObject.optJSONObject("feq_policy");
            if (optJSONObject != null) {
                this.D = optJSONObject.optLong("duration") * 1000;
                this.E = optJSONObject.optInt("max");
            }
            this.F = jSONObject.optInt("vbtt", 5);
            this.G = jSONObject.optInt("fetch_tpl_interval", 3600);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("abtest");
            if (optJSONObject2 != null) {
                this.q = optJSONObject2.optString("version");
                this.r = optJSONObject2.optString("param");
            } else {
                P();
            }
            this.V = jSONObject.optInt("read_video_from_cache", 1);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("web_info");
            if (optJSONObject3 != null) {
                this.s = optJSONObject3.optInt("web_info_wifi_enable", 1);
                this.t = optJSONObject3.optInt("web_info_page_count", 5);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("log_rate_conf");
            if (optJSONObject4 != null) {
                this.U = (float) optJSONObject4.optDouble("global_rate", 1.0d);
                if (optJSONObject4.has("call_stack_rate")) {
                    this.S = (float) optJSONObject4.optDouble("call_stack_rate");
                } else {
                    this.S = this.U;
                }
            }
            this.u = jSONObject.optString("pyload_h5");
            this.v = jSONObject.optString("pure_pyload_h5");
            this.w = c(jSONObject);
            j.f("splashLoad", "setting-》mSplashCheckType=" + this.w);
            this.B = jSONObject.optInt("if_both_open", 0);
            this.C = jSONObject.optInt("support_tnc", 1);
            this.x = jSONObject.optInt("al", 0);
            this.J = jSONObject.optInt("max_tpl_cnts", 100);
            JSONObject optJSONObject5 = jSONObject.optJSONObject("app_common_config");
            if (optJSONObject5 != null) {
                this.K = optJSONObject5.optInt("fetch_tpl_timeout_ctrl", 3000);
                this.f30306a = optJSONObject5.optInt("circle_splash", 0);
                this.f30307b = optJSONObject5.optInt("circle_time", -1);
                this.N = optJSONObject5.optInt("if_sp_cache", 0);
                this.O = optJSONObject5.optInt("if_pre_connect", 0);
                this.P = optJSONObject5.optInt("webview_cache_count", 20);
                this.Q = optJSONObject5.optInt("webview_render_concurrent_count", 3);
                this.W = optJSONObject5.optInt("icon_show_time", 5);
                try {
                    this.L.clear();
                    JSONArray optJSONArray2 = optJSONObject5.optJSONArray("gecko_hosts");
                    if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            this.L.add(optJSONArray2.getString(i2));
                        }
                    }
                    this.L = a(this.L);
                } catch (Throwable th) {
                    j.b("GeckoLog: settings json error " + th);
                }
            }
            this.y = System.currentTimeMillis();
            this.z.clear();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("spam_app_list");
            if (optJSONArray3 != null) {
                int length = optJSONArray3.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = optJSONArray3.optString(i3);
                    if (!TextUtils.isEmpty(optString)) {
                        this.z.add(optString);
                    }
                }
            }
            this.A.clear();
            JSONArray optJSONArray4 = jSONObject.optJSONArray("scheme_check_list");
            if (optJSONArray4 != null) {
                int length2 = optJSONArray4.length();
                for (int i4 = 0; i4 < length2; i4++) {
                    String optString2 = optJSONArray4.optString(i4);
                    if (!TextUtils.isEmpty(optString2)) {
                        this.A.add(optString2);
                    }
                }
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("download_config");
            if (optJSONObject6 != null) {
                this.k = optJSONObject6.optInt("dl_network", 1);
                this.l = optJSONObject6.optInt("dl_size", 30);
                this.m = optJSONObject6.optInt("if_storage_internal", 1);
                this.n = optJSONObject6.optInt("enable_download_opt", 0);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("download_sdk_config");
            this.o = optJSONObject7;
            if (optJSONObject7 != null) {
                this.p = optJSONObject7.toString();
            } else {
                this.p = "";
            }
            String str2 = null;
            try {
                JSONArray optJSONArray5 = jSONObject.optJSONArray("push_config");
                if (optJSONArray5 != null) {
                    str = optJSONArray5.toString();
                    try {
                        int length3 = optJSONArray5.length();
                        for (int i5 = 0; i5 < length3; i5++) {
                            e eVar = new e();
                            JSONObject optJSONObject8 = optJSONArray5.optJSONObject(i5);
                            if (optJSONObject8 != null) {
                                eVar.f30293a = optJSONObject8.optString("action");
                                eVar.f30294b = optJSONObject8.optString("service");
                                eVar.f30295c = optJSONObject8.optString(AsInstallService.SCHEME_PACKAGE_ADDED);
                                eVar.f30296d = optJSONObject8.optInt("wakeup_interval");
                                this.f30314i.add(eVar);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                        optJSONArray = jSONObject.optJSONArray("ad_slot_conf_list");
                        if (optJSONArray != null) {
                        }
                        this.X = jSONObject.optInt("pre_cache_brand_count", this.X);
                        com.bytedance.sdk.openadsdk.downloadnew.a.g.c();
                        a(str2, str);
                    }
                } else {
                    str = null;
                }
                d.c().d();
            } catch (Throwable th3) {
                th = th3;
                str = null;
            }
            optJSONArray = jSONObject.optJSONArray("ad_slot_conf_list");
            if (optJSONArray != null) {
                str2 = optJSONArray.toString();
                int length4 = optJSONArray.length();
                if (length4 > 0) {
                    this.f30308c.clear();
                    for (int i6 = 0; i6 < length4; i6++) {
                        JSONObject optJSONObject9 = optJSONArray.optJSONObject(i6);
                        a b2 = b(optJSONObject9);
                        if (b2 != null) {
                            this.f30308c.put(b2.f30271a, b2);
                            com.bytedance.sdk.openadsdk.p.a.a(b2.f30271a, optJSONObject9);
                        }
                    }
                }
            }
            this.X = jSONObject.optInt("pre_cache_brand_count", this.X);
            com.bytedance.sdk.openadsdk.downloadnew.a.g.c();
            a(str2, str);
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "url_ads", this.H);
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "url_alog", this.I);
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "xpath", this.j);
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "duration", Long.valueOf(this.D));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max", Integer.valueOf(this.E));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_network", Integer.valueOf(this.k));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_size", Integer.valueOf(this.l));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_storage_internal", Integer.valueOf(this.m));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "vbtt", Integer.valueOf(this.F));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_template", Integer.valueOf(this.G));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_wifi_enable", Integer.valueOf(this.s));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "web_info_page_count", Integer.valueOf(this.t));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_check_type", Integer.valueOf(this.w));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_both_open", Integer.valueOf(this.B));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "support_tnc", Integer.valueOf(this.C));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "pyload_h5", this.u);
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "playableLoadH5Url", this.v);
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "app_list_control", Integer.valueOf(this.x));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max_tpl_cnts", Integer.valueOf(this.J));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", Integer.valueOf(this.K));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "webview_cache_count", Integer.valueOf(this.P));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "webview_render_concurrent_count", Integer.valueOf(this.Q));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "gecko_hosts", this.L);
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "hit_app_list_time", Long.valueOf(this.y));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "hit_app_list_data", this.z);
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "scheme_list_data", this.A);
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_splash_switch", Integer.valueOf(this.f30306a));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "circle_load_splash_time", Integer.valueOf(this.f30307b));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "sp_key_if_sp_cache", Integer.valueOf(this.N));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "dyn_draw_engine_url", this.M);
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_sdk_config", this.p);
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "enable_download_opt", Integer.valueOf(this.n));
                String str3 = this.q;
                if (str3 != null) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ab_test_version", str3);
                }
                String str4 = this.r;
                if (str4 != null) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ab_test_param", str4);
                }
                if (!TextUtils.isEmpty(str2)) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "push_config", str2);
                }
                if (!TextUtils.isEmpty(str)) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ad_slot_conf", str);
                }
                if (!TextUtils.isEmpty(this.f30312g)) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "template_ids", this.f30312g);
                }
                if (!TextUtils.isEmpty(this.f30310e)) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "tpl_infos", this.f30310e);
                }
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "call_stack_rate", Float.valueOf(this.S));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_pre_connect", Integer.valueOf(this.O));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "global_rate", Float.valueOf(this.U));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "read_video_from_cache", Integer.valueOf(this.V));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "icon_show_time", Integer.valueOf(this.W));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "brand_video_cache_count", Integer.valueOf(this.X));
                return;
            }
            this.T.a("url_ads", this.H);
            this.T.a("url_alog", this.I);
            this.T.a("xpath", this.j);
            this.T.a("duration", this.D);
            this.T.a("max", this.E);
            this.T.a("download_config_dl_network", this.k);
            this.T.a("download_config_dl_size", this.l);
            this.T.a("download_config_storage_internal", this.m);
            this.T.a("fetch_template", this.G);
            this.T.a("web_info_wifi_enable", this.s);
            this.T.a("web_info_page_count", this.t);
            this.T.a("pyload_h5", this.u);
            this.T.a("playableLoadH5Url", this.v);
            this.T.a("splash_check_type", this.w);
            this.T.a("if_both_open", this.B);
            this.T.a("support_tnc", this.C);
            this.T.a("app_list_control", this.x);
            this.T.a("max_tpl_cnts", this.J);
            this.T.a("fetch_tpl_timeout_ctrl", this.K);
            this.T.a("webview_cache_count", this.P);
            this.T.a("webview_render_concurrent_count", this.Q);
            this.T.a("gecko_hosts", this.L);
            this.T.a("hit_app_list_time", this.y);
            this.T.a("hit_app_list_data", this.z);
            this.T.a("scheme_list_data", this.A);
            this.T.a("circle_splash_switch", this.f30306a);
            this.T.a("circle_load_splash_time", this.f30307b);
            this.T.a("dyn_draw_engine_url", this.M);
            this.T.a("sp_key_if_sp_cache", this.N);
            this.T.a("download_sdk_config", this.p);
            this.T.a("enable_download_opt", this.n);
            String str5 = this.q;
            if (str5 != null) {
                this.T.a("ab_test_version", str5);
            }
            String str6 = this.r;
            if (str6 != null) {
                this.T.a("ab_test_param", str6);
            }
            this.T.a("vbtt", this.F);
            if (!TextUtils.isEmpty(str2)) {
                this.T.a("push_config", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                this.T.a("ad_slot_conf", str);
            }
            if (!TextUtils.isEmpty(this.f30312g)) {
                this.T.a("template_ids", this.f30312g);
            }
            if (!TextUtils.isEmpty(this.f30310e)) {
                this.T.a("tpl_infos", this.f30310e);
            }
            this.T.a("call_stack_rate", this.S);
            this.T.a("if_pre_connect", this.O);
            this.T.a("global_rate", this.U);
            this.T.a("read_video_from_cache", this.V);
            this.T.a("icon_show_time", this.W);
            this.T.a("brand_video_cache_count", this.X);
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) ? f(i2) != 0 : invokeI.booleanValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            int i2 = o.h().q(String.valueOf(str)).f30275e;
            if (i2 != 1) {
                return i2 == 2 && m.c(o.a()) != 0;
            }
            return m.d(o.a());
        }
        return invokeL.booleanValue;
    }

    public int a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, str, z)) == null) {
            if (str == null) {
                return a(z);
            }
            int i2 = o.h().q(String.valueOf(str)).u;
            return i2 != -1 ? i2 : a(z);
        }
        return invokeLZ.intValue;
    }

    public static Set<String> a(Set<String> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, set)) == null) {
            try {
                if (set == null) {
                    return new HashSet();
                }
                HashSet hashSet = new HashSet();
                for (String str : set) {
                    if (!TextUtils.isEmpty(str)) {
                        hashSet.add(str);
                    }
                }
                return hashSet;
            } catch (Throwable unused) {
                return new HashSet();
            }
        }
        return (Set) invokeL.objValue;
    }
}
