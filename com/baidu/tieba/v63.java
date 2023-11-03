package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class v63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final u63<v63> u;
    public static final t63<v63> v;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public String d;
    public int e;
    public boolean f;
    public String g;
    public boolean h;
    public boolean i;
    public String j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public String q;
    public String r;
    public String s;

    /* loaded from: classes8.dex */
    public static class a extends u63<v63> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u63
        /* renamed from: c */
        public void b(@NonNull v63 v63Var, @NonNull mp2 mp2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v63Var, mp2Var) == null) {
                mp2Var.writeInt(v63Var.a);
                mp2Var.f(v63Var.b);
                mp2Var.f(v63Var.c);
                mp2Var.f(v63Var.d);
                mp2Var.writeInt(v63Var.e);
                mp2Var.writeBoolean(v63Var.f);
                mp2Var.f(v63Var.g);
                mp2Var.writeBoolean(v63Var.h);
                mp2Var.writeBoolean(v63Var.i);
                mp2Var.f(v63Var.j);
                mp2Var.writeBoolean(v63Var.k);
                mp2Var.writeBoolean(v63Var.l);
                mp2Var.writeBoolean(v63Var.m);
                mp2Var.writeBoolean(v63Var.n);
                mp2Var.writeBoolean(v63Var.o);
                mp2Var.writeBoolean(v63Var.p);
                mp2Var.f(v63Var.q);
                mp2Var.f(v63Var.r);
                mp2Var.f(v63Var.s);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends t63<v63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.t63
        /* renamed from: c */
        public v63 b(@NonNull lp2 lp2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lp2Var)) == null) {
                v63 v63Var = new v63();
                v63Var.a = lp2Var.readInt();
                v63Var.b = lp2Var.g();
                v63Var.c = lp2Var.g();
                v63Var.d = lp2Var.g();
                v63Var.e = lp2Var.readInt();
                v63Var.f = lp2Var.readBoolean();
                v63Var.g = lp2Var.g();
                v63Var.h = lp2Var.readBoolean();
                v63Var.i = lp2Var.readBoolean();
                v63Var.j = lp2Var.g();
                v63Var.k = lp2Var.readBoolean();
                v63Var.l = lp2Var.readBoolean();
                v63Var.m = lp2Var.readBoolean();
                v63Var.n = lp2Var.readBoolean();
                v63Var.o = lp2Var.readBoolean();
                v63Var.p = lp2Var.readBoolean();
                v63Var.q = lp2Var.g();
                v63Var.r = lp2Var.g();
                v63Var.s = lp2Var.g();
                return v63Var;
            }
            return (v63) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948192694, "Lcom/baidu/tieba/v63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948192694, "Lcom/baidu/tieba/v63;");
                return;
            }
        }
        t = rm1.a;
        u = new a();
        v = new b();
    }

    public v63() {
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
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = false;
        this.p = false;
        this.a = -16777216;
        this.c = "#ffffff";
        this.j = "default";
        this.e = -1;
        this.f = false;
    }

    public static v63 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new v63();
        }
        return (v63) invokeV.objValue;
    }

    public static v63 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (v63) invokeL.objValue;
    }

    public static boolean f(v63 v63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, v63Var)) == null) {
            if (v63Var == null) {
                return false;
            }
            if (!v63Var.h && !TextUtils.equals(v63Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && !this.p) {
            this.p = true;
        }
    }

    public static v63 b(String str, @NonNull v63 v63Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, v63Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return v63Var;
            }
            try {
                return e(new JSONObject(str), v63Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return v63Var;
            }
        }
        return (v63) invokeLL.objValue;
    }

    public static v63 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (optJSONObject == null) {
                return d();
            }
            v63 v63Var = new v63();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            v63Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            v63Var.c = optString2;
            v63Var.b = optJSONObject.optString("navigationBarTitleText");
            v63Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            v63Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            v63Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            v63Var.g = optJSONObject.optString("onReachBottomDistance");
            v63Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            v63Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            v63Var.j = optJSONObject.optString("navigationStyle", "default");
            v63Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            v63Var.q = optJSONObject.optString("textSizeAdjust");
            v63Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return v63Var;
        }
        return (v63) invokeL.objValue;
    }

    public static v63 e(JSONObject jSONObject, @NonNull v63 v63Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, v63Var)) == null) {
            v63 v63Var2 = new v63();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = v63Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            v63Var2.a = t2;
            v63Var2.b = jSONObject.optString("navigationBarTitleText", v63Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = v63Var.c;
            }
            v63Var2.c = optString2;
            v63Var2.d = jSONObject.optString("backgroundTextStyle", v63Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = v63Var.e;
            }
            v63Var2.e = i;
            v63Var2.f = jSONObject.optBoolean("enablePullDownRefresh", v63Var.f);
            v63Var2.g = jSONObject.optString("onReachBottomDistance", v63Var.g);
            v63Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", v63Var.h);
            v63Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", v63Var.i);
            v63Var2.j = jSONObject.optString("navigationStyle", v63Var.j);
            v63Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", v63Var.k);
            v63Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            v63Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            v63Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            v63Var2.o = jSONObject.optBoolean("_hasVideo", false);
            v63Var2.r = jSONObject.optString("viewMode", v63Var.r);
            v63Var2.s = jSONObject.optString("htmlFontSize", v63Var.s);
            jSONObject.optJSONArray("fontFace");
            return v63Var2;
        }
        return (v63) invokeLL.objValue;
    }
}
