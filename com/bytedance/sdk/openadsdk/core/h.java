package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.bytedance.sdk.openadsdk.AppLogHelper;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTSecAbs;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h v;
    public static TTCustomController y;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public volatile String f66614a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public String f66615b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66616c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public String f66617d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public String f66618e;

    /* renamed from: f  reason: collision with root package name */
    public int f66619f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66620g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66621h;

    /* renamed from: i  reason: collision with root package name */
    public TTGlobalAppDownloadListener f66622i;

    /* renamed from: j  reason: collision with root package name */
    public final Set<Integer> f66623j;
    public boolean k;
    public Bitmap l;
    public com.bytedance.sdk.openadsdk.q.a m;
    public TTDownloadEventLogger n;
    public TTSecAbs o;
    public String[] p;
    public TTCustomController q;
    public String r;
    public String s;
    public HashMap<String, Object> t;
    public boolean u;
    public com.bytedance.sdk.openadsdk.d.b w;
    public com.bytedance.sdk.openadsdk.core.h.c x;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(210334734, "Lcom/bytedance/sdk/openadsdk/core/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(210334734, "Lcom/bytedance/sdk/openadsdk/core/h;");
                return;
            }
        }
        y = new TTCustomController() { // from class: com.bytedance.sdk.openadsdk.core.h.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        };
    }

    public h() {
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
        this.f66619f = 0;
        this.f66620g = true;
        this.f66621h = false;
        this.f66623j = Collections.synchronizedSet(new HashSet());
        this.k = false;
        this.l = null;
        this.m = new com.bytedance.sdk.openadsdk.q.a();
        this.t = new HashMap<>();
        this.u = false;
        Context a2 = o.a();
        if (a2 != null) {
            com.bytedance.sdk.openadsdk.n.g.a.a(a2);
        }
        this.f66623j.add(4);
        if (a2 instanceof Application) {
            ((Application) a2).registerActivityLifecycleCallbacks(this.m);
        } else if (a2 != null && a2.getApplicationContext() != null) {
            ((Application) a2.getApplicationContext()).registerActivityLifecycleCallbacks(this.m);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                ShortcutManager shortcutManager = (ShortcutManager) o.a().getSystemService(ShortcutManager.class);
                if (shortcutManager != null) {
                    this.u = shortcutManager.isRequestPinShortcutSupported();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static h d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (v == null) {
                synchronized (h.class) {
                    if (v == null) {
                        v = new h();
                    }
                }
            }
            return v;
        }
        return (h) invokeV.objValue;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "sdk_key_theme_status", 0);
            }
            return com.bytedance.sdk.component.utils.u.a((String) null, o.a()).b("sdk_key_theme_status", 0);
        }
        return invokeV.intValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.m.a() : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public com.bytedance.sdk.openadsdk.q.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.m : (com.bytedance.sdk.openadsdk.q.a) invokeV.objValue;
    }

    public void e() {
        TTCustomController f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (f2 = f()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.o.a.b(7, String.valueOf(f2.isCanUseLocation() ? 1 : 0));
        com.bytedance.sdk.openadsdk.o.a.b(8, String.valueOf(f2.getTTLocation() == null ? 0 : 1));
        com.bytedance.sdk.openadsdk.o.a.b(9, String.valueOf(f2.isCanUsePhoneState() ? 1 : 0));
        com.bytedance.sdk.openadsdk.o.a.b(10, String.valueOf(!TextUtils.isEmpty(f2.getDevImei()) ? 1 : 0));
        com.bytedance.sdk.openadsdk.o.a.b(11, String.valueOf(f2.isCanUseWifiState() ? 1 : 0));
        com.bytedance.sdk.openadsdk.o.a.b(12, String.valueOf(f2.isCanUseWriteExternal() ? 1 : 0));
        com.bytedance.sdk.openadsdk.o.a.b(13, String.valueOf(!TextUtils.isEmpty(f2.getDevOaid()) ? 1 : 0));
        com.bytedance.sdk.openadsdk.o.a.b(14, String.valueOf(d().u() ? 1 : 0));
    }

    @NonNull
    public TTCustomController f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (l.f66740b != null) {
                return l.f66740b;
            }
            TTCustomController tTCustomController = this.q;
            return tTCustomController == null ? y : tTCustomController;
        }
        return (TTCustomController) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "sdk_activate_init", true);
            }
            return com.bytedance.sdk.component.utils.u.a((String) null, o.a()).b("sdk_activate_init", true);
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (!TextUtils.isEmpty(this.f66614a)) {
                return this.f66614a;
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "app_id", (String) null);
            }
            return this.f66614a;
        }
        return (String) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String h2 = d().h();
            if (TextUtils.isEmpty(h2)) {
                h2 = String.valueOf(164362);
            }
            hashMap.put("host_appid", h2);
            hashMap.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, "3.7.0.3");
            AppLogHelper.getInstance().setHeaderInfo(hashMap);
        }
    }

    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "name", (String) null);
            }
            return this.f66615b;
        }
        return (String) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", false);
            }
            return this.f66616c;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "keywords", (String) null);
            }
            return this.f66617d;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "extra_data", (String) null);
            }
            return this.f66618e;
        }
        return (String) invokeV.objValue;
    }

    public Map<String, Object> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (!this.t.isEmpty()) {
                return this.t;
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "extra_internal_data", (String) null);
                this.t.putAll(TextUtils.isEmpty(b2) ? e(b2) : new HashMap<>());
            }
            return this.t;
        }
        return (Map) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "title_bar_theme", 0);
            }
            return this.f66619f;
        }
        return invokeV.intValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_show_notify", true);
            }
            return this.f66620g;
        }
        return invokeV.booleanValue;
    }

    public TTDownloadEventLogger q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.n : (TTDownloadEventLogger) invokeV.objValue;
    }

    public TTSecAbs r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.o : (TTSecAbs) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.d.b s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.w == null) {
                this.w = new com.bytedance.sdk.openadsdk.d.b(10, 8, true);
            }
            return this.w;
        }
        return (com.bytedance.sdk.openadsdk.d.b) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.core.h.c t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.x == null) {
                this.x = new com.bytedance.sdk.openadsdk.core.h.c(10, 8);
            }
            return this.x;
        }
        return (com.bytedance.sdk.openadsdk.core.h.c) invokeV.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", false);
            }
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public Bitmap v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.component.utils.d.a(com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "pause_icon", (String) null));
            }
            return this.l;
        }
        return (Bitmap) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return TextUtils.isEmpty(this.r) ? "" : this.r;
            }
            String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "tob_ab_sdk_version", (String) null);
            return TextUtils.isEmpty(b2) ? "" : b2;
        }
        return (String) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? "5001121".equals(this.f66614a) : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? "com.union_test.toutiao".equals(com.bytedance.sdk.openadsdk.q.q.d()) : invokeV.booleanValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (!TextUtils.isEmpty(this.s)) {
                return this.s;
            }
            String a2 = com.bytedance.sdk.openadsdk.q.e.a();
            this.s = a2;
            if (!TextUtils.isEmpty(a2)) {
                return this.s;
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.q.e.a(valueOf);
            this.s = valueOf;
            return valueOf;
        }
        return (String) invokeV.objValue;
    }

    public boolean a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, activity)) == null) ? this.m.a(activity) : invokeL.booleanValue;
    }

    public void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            g(str);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "name", str);
            }
            this.f66615b = str;
        }
    }

    public void c(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            h(str);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "keywords", str);
            }
            this.f66617d = str;
        }
    }

    public void a(TTCustomController tTCustomController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tTCustomController) == null) {
            this.q = tTCustomController;
            e();
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            com.bytedance.sdk.component.utils.p.a(str, "appid不能为空");
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            com.bytedance.sdk.component.utils.p.a(str, "name不能为空");
        }
    }

    public static JSONObject j(String str) {
        InterceptResult invokeL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", str, (String) null);
            } else {
                b2 = com.bytedance.sdk.component.utils.u.a((String) null, o.a()).b(str, (String) null);
            }
            if (TextUtils.isEmpty(b2)) {
                return null;
            }
            try {
                return new JSONObject(b2);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "sdk_activate_init", Boolean.valueOf(z));
            }
            com.bytedance.sdk.component.utils.u.a((String) null, o.a()).a("sdk_activate_init", z);
        }
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.p.a(str.length() <= 1000, "keyword超长, 最长为1000");
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", Boolean.valueOf(z));
            }
            this.f66616c = z;
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_show_notify", Boolean.valueOf(z));
            }
            this.f66620g = z;
        }
    }

    public void d(@Nullable String str) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            i(str);
            try {
                jSONArray = TextUtils.isEmpty(str) ? new JSONArray() : new JSONArray(str);
            } catch (Exception unused) {
                jSONArray = new JSONArray();
            }
            HashMap hashMap = new HashMap();
            JSONArray jSONArray2 = new JSONArray();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    if (!optJSONObject.isNull("__name__")) {
                        String optString = optJSONObject.optString("__name__");
                        String optString2 = optJSONObject.optString("value");
                        if (!TextUtils.isEmpty(optString)) {
                            hashMap.put(optString, optString2);
                        }
                    } else {
                        jSONArray2.put(optJSONObject);
                    }
                }
            }
            if ((jSONArray2.length() == 0 && hashMap.isEmpty()) || jSONArray2.length() != 0) {
                this.f66618e = jSONArray2.toString();
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "extra_data", jSONArray2.toString());
                }
                this.f66618e = jSONArray2.toString();
            }
            if (hashMap.isEmpty()) {
                return;
            }
            this.t.putAll(hashMap);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "extra_internal_data", a(this.t));
            }
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.p.a(str.length() <= 1000, "data超长, 最长为1000");
    }

    public void a(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            f(str);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "app_id", str);
            }
            this.f66614a = str;
        }
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "network_state", (String) null);
                if (TextUtils.isEmpty(b2)) {
                    return false;
                }
                String[] split = b2.split(",");
                if (split.length > 0) {
                    for (String str : split) {
                        if (!TextUtils.isEmpty(str) && String.valueOf(i2).equals(str)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return this.f66623j.contains(Integer.valueOf(i2));
        }
        return invokeI.booleanValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "sdk_key_theme_status", Integer.valueOf(i2));
            } else {
                com.bytedance.sdk.component.utils.u.a((String) null, o.a()).a("sdk_key_theme_status", i2);
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "title_bar_theme", Integer.valueOf(i2));
            }
            this.f66619f = i2;
        }
    }

    public void a(TTGlobalAppDownloadListener tTGlobalAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tTGlobalAppDownloadListener) == null) {
            this.f66622i = tTGlobalAppDownloadListener;
        }
    }

    public void a(TTDownloadEventLogger tTDownloadEventLogger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tTDownloadEventLogger) == null) {
            this.n = tTDownloadEventLogger;
        }
    }

    public void a(TTSecAbs tTSecAbs) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tTSecAbs) == null) {
            this.o = tTSecAbs;
        }
    }

    public static final HashMap<String, Object> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new HashMap<>();
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        hashMap.put(next, jSONObject.opt(next));
                    }
                }
                return hashMap;
            } catch (Exception unused) {
                return new HashMap<>();
            }
        }
        return (HashMap) invokeL.objValue;
    }

    public void a(int... iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, iArr) == null) || iArr == null) {
            return;
        }
        try {
            this.f66623j.clear();
            for (int i2 : iArr) {
                this.f66623j.add(Integer.valueOf(i2));
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (!this.f66623j.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (Integer num : this.f66623j) {
                        sb.append(num);
                        sb.append(",");
                    }
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "network_state", sb.toString());
                    return;
                }
                com.bytedance.sdk.openadsdk.multipro.d.a.c("sp_global_info", "network_state");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", Boolean.valueOf(z));
            }
            this.k = z;
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_lp_when_screen_lock", Boolean.valueOf(z));
            }
            this.f66621h = z;
        }
    }

    public static final String a(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, map)) == null) {
            if (map == null || map.isEmpty()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    try {
                        jSONObject.putOpt(entry.getKey(), entry.getValue());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                String a2 = com.bytedance.sdk.component.utils.d.a(bitmap);
                if (!TextUtils.isEmpty(a2)) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "pause_icon", a2);
                }
            }
            this.l = bitmap;
        }
    }

    public void a(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, strArr) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b() && strArr != null && strArr.length > 0) {
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        int i3 = i2 + 1;
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        sb.append(str);
                        i2 = i3;
                    }
                }
                String sb2 = sb.toString();
                if (!TextUtils.isEmpty(sb2)) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "need_clear_task_reset", sb2);
                }
            }
            this.p = strArr;
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", str2);
            jSONObject.put("time", System.currentTimeMillis());
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", str, jSONObject.toString());
            } else {
                com.bytedance.sdk.component.utils.u.a((String) null, o.a()).a(str, jSONObject.toString());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static String a(String str, long j2) {
        InterceptResult invokeLJ;
        JSONObject j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, str, j2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                j3 = j(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (j3 == null) {
                com.bytedance.sdk.component.utils.k.b("GlobalInfo", "without cache key=", str);
                return null;
            }
            if (System.currentTimeMillis() - j3.getLong("time") <= j2) {
                String string = j3.getString("value");
                com.bytedance.sdk.component.utils.k.b("GlobalInfo", "use cache key=", str, " value = ", string);
                return string;
            }
            com.bytedance.sdk.component.utils.k.b("GlobalInfo", "without cache key=", str);
            return null;
        }
        return (String) invokeLJ.objValue;
    }
}
