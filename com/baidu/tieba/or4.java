package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class or4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public b b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public int e;
        public String f;
        public String g;
        public int h;

        public a(or4 or4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = "Android";
            this.b = Build.VERSION.RELEASE;
            this.c = Build.MANUFACTURER;
            this.e = Build.VERSION.SDK_INT;
            this.f = Build.MODEL;
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            this.g = windowManager.getDefaultDisplay().getWidth() + "_" + windowManager.getDefaultDisplay().getHeight();
            this.h = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* loaded from: classes7.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public b(or4 or4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = br4.g().u(AppRuntime.getAppContext());
        }
    }

    public or4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this);
        this.b = new b(this);
        this.i = sr4.c();
        this.o = "";
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.c = packageInfo.versionName;
            this.e = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission(com.kuaishou.weapon.p0.h.c) == 0)) {
            this.j = telephonyManager.getSimOperator();
        }
        this.f = br4.g().getDeviceId(appContext);
        this.g = br4.g().o(appContext);
        this.h = br4.g().a();
        this.n = br4.g().b();
        this.q = br4.g().s();
        this.r = str;
    }

    public static void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jSONObject) == null) {
            JSONObject e = new or4(jSONObject.optString("bizId")).e();
            Iterator<String> keys = e.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!jSONObject.has(next)) {
                    try {
                        jSONObject.putOpt(next, e.opt(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (br4.g() == null) {
                return str;
            }
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                return c(jSONObject);
            } catch (JSONException unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            ir4 g = br4.g();
            String str = "";
            if (jSONObject == null || g == null) {
                return "";
            }
            try {
                if (g.k() == 0) {
                    str = "swan";
                } else if (g.k() == 1) {
                    str = SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("smartAppId", g.getAppId());
                jSONObject2.putOpt("smartAppVersion", g.getAppVersion());
                jSONObject2.putOpt("swanCoreVersion", g.m());
                jSONObject2.putOpt("swanNativeVersion", g.b());
                jSONObject2.putOpt("swanType", str);
                jSONObject.putOpt(DI.APP_INFO_NAME, jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("source", g.getScene());
                jSONObject.put("propagation", jSONObject3);
                return jSONObject.toString();
            } catch (JSONException unused) {
                return jSONObject.toString();
            }
        }
        return (String) invokeL.objValue;
    }

    public static void d(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray) == null) && jSONArray != null && jSONArray.length() >= 1) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(DI.APP_INFO_NAME);
                    Iterator<String> keys = jSONObject3.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.putOpt(next, jSONObject3.optString(next));
                    }
                    jSONObject2.remove(DI.APP_INFO_NAME);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("os", this.a.a);
                jSONObject2.putOpt("osversion", this.a.b);
                jSONObject2.putOpt("model", this.a.f);
                jSONObject2.putOpt("deviceType", this.a.d);
                jSONObject2.putOpt("sdk", this.a.e + "");
                jSONObject2.putOpt("brand", this.a.c);
                jSONObject2.putOpt("screen", this.a.g);
                jSONObject2.putOpt("density", this.a.h + "");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("passId", this.b.a);
                jSONObject.putOpt("userInfo", jSONObject3);
                jSONObject.putOpt("system", jSONObject2);
                jSONObject.putOpt("appVersion", this.c);
                jSONObject.putOpt("appBranch", this.d);
                jSONObject.putOpt("appPackageName", this.e);
                jSONObject.putOpt("cuid", this.f);
                jSONObject.putOpt("uuid", this.g);
                jSONObject.putOpt("hostName", this.h);
                jSONObject.putOpt("net", this.i);
                jSONObject.putOpt("operator", this.j);
                jSONObject.putOpt("smartAppId", this.k);
                jSONObject.putOpt("smartAppVersion", this.l);
                jSONObject.putOpt("swanCoreVersion", this.m);
                jSONObject.putOpt("swanNativeVersion", this.n);
                jSONObject.putOpt("swanType", this.o);
                jSONObject.putOpt("swanId", this.p);
                jSONObject.putOpt("bizId", this.r);
                jSONObject.putOpt("eventType", this.s);
                jSONObject.putOpt("eventName", this.t);
                jSONObject.putOpt("content", this.u);
                if (!TextUtils.isEmpty(this.q)) {
                    jSONObject.putOpt("appClientId", this.q);
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
