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
public class l93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final k93<l93> u;
    public static final j93<l93> v;
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
    public static class a extends k93<l93> {
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
        @Override // com.baidu.tieba.k93
        /* renamed from: b */
        public void a(@NonNull l93 l93Var, @NonNull cs2 cs2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l93Var, cs2Var) == null) {
                cs2Var.writeInt(l93Var.a);
                cs2Var.f(l93Var.b);
                cs2Var.f(l93Var.c);
                cs2Var.f(l93Var.d);
                cs2Var.writeInt(l93Var.e);
                cs2Var.writeBoolean(l93Var.f);
                cs2Var.f(l93Var.g);
                cs2Var.writeBoolean(l93Var.h);
                cs2Var.writeBoolean(l93Var.i);
                cs2Var.f(l93Var.j);
                cs2Var.writeBoolean(l93Var.k);
                cs2Var.writeBoolean(l93Var.l);
                cs2Var.writeBoolean(l93Var.m);
                cs2Var.writeBoolean(l93Var.n);
                cs2Var.writeBoolean(l93Var.o);
                cs2Var.writeBoolean(l93Var.p);
                cs2Var.f(l93Var.q);
                cs2Var.f(l93Var.r);
                cs2Var.f(l93Var.s);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends j93<l93> {
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
        @Override // com.baidu.tieba.j93
        /* renamed from: b */
        public l93 a(@NonNull bs2 bs2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bs2Var)) == null) {
                l93 l93Var = new l93();
                l93Var.a = bs2Var.readInt();
                l93Var.b = bs2Var.g();
                l93Var.c = bs2Var.g();
                l93Var.d = bs2Var.g();
                l93Var.e = bs2Var.readInt();
                l93Var.f = bs2Var.readBoolean();
                l93Var.g = bs2Var.g();
                l93Var.h = bs2Var.readBoolean();
                l93Var.i = bs2Var.readBoolean();
                l93Var.j = bs2Var.g();
                l93Var.k = bs2Var.readBoolean();
                l93Var.l = bs2Var.readBoolean();
                l93Var.m = bs2Var.readBoolean();
                l93Var.n = bs2Var.readBoolean();
                l93Var.o = bs2Var.readBoolean();
                l93Var.p = bs2Var.readBoolean();
                l93Var.q = bs2Var.g();
                l93Var.r = bs2Var.g();
                l93Var.s = bs2Var.g();
                return l93Var;
            }
            return (l93) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947897667, "Lcom/baidu/tieba/l93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947897667, "Lcom/baidu/tieba/l93;");
                return;
            }
        }
        t = gp1.a;
        u = new a();
        v = new b();
    }

    public l93() {
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

    public static l93 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new l93();
        }
        return (l93) invokeV.objValue;
    }

    public static l93 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (l93) invokeL.objValue;
    }

    public static boolean f(l93 l93Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, l93Var)) == null) {
            if (l93Var == null) {
                return false;
            }
            if (!l93Var.h && !TextUtils.equals(l93Var.j, "custom")) {
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

    public static l93 b(String str, @NonNull l93 l93Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, l93Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return l93Var;
            }
            try {
                return e(new JSONObject(str), l93Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return l93Var;
            }
        }
        return (l93) invokeLL.objValue;
    }

    public static l93 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            l93 l93Var = new l93();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            l93Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            l93Var.c = optString2;
            l93Var.b = optJSONObject.optString("navigationBarTitleText");
            l93Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            l93Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            l93Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            l93Var.g = optJSONObject.optString("onReachBottomDistance");
            l93Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            l93Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            l93Var.j = optJSONObject.optString("navigationStyle", "default");
            l93Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            l93Var.q = optJSONObject.optString("textSizeAdjust");
            l93Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return l93Var;
        }
        return (l93) invokeL.objValue;
    }

    public static l93 e(JSONObject jSONObject, @NonNull l93 l93Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, l93Var)) == null) {
            l93 l93Var2 = new l93();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = l93Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            l93Var2.a = t2;
            l93Var2.b = jSONObject.optString("navigationBarTitleText", l93Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = l93Var.c;
            }
            l93Var2.c = optString2;
            l93Var2.d = jSONObject.optString("backgroundTextStyle", l93Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = l93Var.e;
            }
            l93Var2.e = i;
            l93Var2.f = jSONObject.optBoolean("enablePullDownRefresh", l93Var.f);
            l93Var2.g = jSONObject.optString("onReachBottomDistance", l93Var.g);
            l93Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", l93Var.h);
            l93Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", l93Var.i);
            l93Var2.j = jSONObject.optString("navigationStyle", l93Var.j);
            l93Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", l93Var.k);
            l93Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            l93Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            l93Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            l93Var2.o = jSONObject.optBoolean("_hasVideo", false);
            l93Var2.r = jSONObject.optString("viewMode", l93Var.r);
            l93Var2.s = jSONObject.optString("htmlFontSize", l93Var.s);
            jSONObject.optJSONArray("fontFace");
            return l93Var2;
        }
        return (l93) invokeLL.objValue;
    }
}
