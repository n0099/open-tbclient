package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes5.dex */
public class p13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final o13<p13> u;
    public static final n13<p13> v;
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

    /* loaded from: classes5.dex */
    public static class a extends o13<p13> {
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
        @Override // com.baidu.tieba.o13
        /* renamed from: b */
        public void a(@NonNull p13 p13Var, @NonNull gk2 gk2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p13Var, gk2Var) == null) {
                gk2Var.writeInt(p13Var.a);
                gk2Var.f(p13Var.b);
                gk2Var.f(p13Var.c);
                gk2Var.f(p13Var.d);
                gk2Var.writeInt(p13Var.e);
                gk2Var.writeBoolean(p13Var.f);
                gk2Var.f(p13Var.g);
                gk2Var.writeBoolean(p13Var.h);
                gk2Var.writeBoolean(p13Var.i);
                gk2Var.f(p13Var.j);
                gk2Var.writeBoolean(p13Var.k);
                gk2Var.writeBoolean(p13Var.l);
                gk2Var.writeBoolean(p13Var.m);
                gk2Var.writeBoolean(p13Var.n);
                gk2Var.writeBoolean(p13Var.o);
                gk2Var.writeBoolean(p13Var.p);
                gk2Var.f(p13Var.q);
                gk2Var.f(p13Var.r);
                gk2Var.f(p13Var.s);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends n13<p13> {
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
        @Override // com.baidu.tieba.n13
        /* renamed from: b */
        public p13 a(@NonNull fk2 fk2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fk2Var)) == null) {
                p13 p13Var = new p13();
                p13Var.a = fk2Var.readInt();
                p13Var.b = fk2Var.g();
                p13Var.c = fk2Var.g();
                p13Var.d = fk2Var.g();
                p13Var.e = fk2Var.readInt();
                p13Var.f = fk2Var.readBoolean();
                p13Var.g = fk2Var.g();
                p13Var.h = fk2Var.readBoolean();
                p13Var.i = fk2Var.readBoolean();
                p13Var.j = fk2Var.g();
                p13Var.k = fk2Var.readBoolean();
                p13Var.l = fk2Var.readBoolean();
                p13Var.m = fk2Var.readBoolean();
                p13Var.n = fk2Var.readBoolean();
                p13Var.o = fk2Var.readBoolean();
                p13Var.p = fk2Var.readBoolean();
                p13Var.q = fk2Var.g();
                p13Var.r = fk2Var.g();
                p13Var.s = fk2Var.g();
                return p13Var;
            }
            return (p13) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948009143, "Lcom/baidu/tieba/p13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948009143, "Lcom/baidu/tieba/p13;");
                return;
            }
        }
        t = kh1.a;
        u = new a();
        v = new b();
    }

    public p13() {
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

    public static p13 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (p13) invokeL.objValue;
    }

    public static p13 b(String str, @NonNull p13 p13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, p13Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return p13Var;
            }
            try {
                return e(new JSONObject(str), p13Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return p13Var;
            }
        }
        return (p13) invokeLL.objValue;
    }

    public static p13 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            p13 p13Var = new p13();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            p13Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            p13Var.c = optString2;
            p13Var.b = optJSONObject.optString("navigationBarTitleText");
            p13Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            p13Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            p13Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            p13Var.g = optJSONObject.optString("onReachBottomDistance");
            p13Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            p13Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            p13Var.j = optJSONObject.optString("navigationStyle", "default");
            p13Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            p13Var.q = optJSONObject.optString("textSizeAdjust");
            p13Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return p13Var;
        }
        return (p13) invokeL.objValue;
    }

    public static p13 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new p13();
        }
        return (p13) invokeV.objValue;
    }

    public static p13 e(JSONObject jSONObject, @NonNull p13 p13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, p13Var)) == null) {
            p13 p13Var2 = new p13();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            p13Var2.a = TextUtils.isEmpty(optString) ? p13Var.a : SwanAppConfigData.t(optString);
            p13Var2.b = jSONObject.optString("navigationBarTitleText", p13Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = p13Var.c;
            }
            p13Var2.c = optString2;
            p13Var2.d = jSONObject.optString("backgroundTextStyle", p13Var.d);
            p13Var2.e = jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR) ? SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) : p13Var.e;
            p13Var2.f = jSONObject.optBoolean("enablePullDownRefresh", p13Var.f);
            p13Var2.g = jSONObject.optString("onReachBottomDistance", p13Var.g);
            p13Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", p13Var.h);
            p13Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", p13Var.i);
            p13Var2.j = jSONObject.optString("navigationStyle", p13Var.j);
            p13Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", p13Var.k);
            p13Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            p13Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            p13Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            p13Var2.o = jSONObject.optBoolean("_hasVideo", false);
            p13Var2.r = jSONObject.optString("viewMode", p13Var.r);
            p13Var2.s = jSONObject.optString("htmlFontSize", p13Var.s);
            jSONObject.optJSONArray("fontFace");
            return p13Var2;
        }
        return (p13) invokeLL.objValue;
    }

    public static boolean f(p13 p13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, p13Var)) == null) {
            if (p13Var == null) {
                return false;
            }
            return p13Var.h || TextUtils.equals(p13Var.j, "custom");
        }
        return invokeL.booleanValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && !this.p) {
            this.p = true;
        }
    }
}
