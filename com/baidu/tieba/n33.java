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
public class n33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final m33<n33> u;
    public static final l33<n33> v;
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
    public static class a extends m33<n33> {
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
        @Override // com.baidu.tieba.m33
        /* renamed from: b */
        public void a(@NonNull n33 n33Var, @NonNull em2 em2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n33Var, em2Var) == null) {
                em2Var.writeInt(n33Var.a);
                em2Var.f(n33Var.b);
                em2Var.f(n33Var.c);
                em2Var.f(n33Var.d);
                em2Var.writeInt(n33Var.e);
                em2Var.writeBoolean(n33Var.f);
                em2Var.f(n33Var.g);
                em2Var.writeBoolean(n33Var.h);
                em2Var.writeBoolean(n33Var.i);
                em2Var.f(n33Var.j);
                em2Var.writeBoolean(n33Var.k);
                em2Var.writeBoolean(n33Var.l);
                em2Var.writeBoolean(n33Var.m);
                em2Var.writeBoolean(n33Var.n);
                em2Var.writeBoolean(n33Var.o);
                em2Var.writeBoolean(n33Var.p);
                em2Var.f(n33Var.q);
                em2Var.f(n33Var.r);
                em2Var.f(n33Var.s);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends l33<n33> {
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
        @Override // com.baidu.tieba.l33
        /* renamed from: b */
        public n33 a(@NonNull dm2 dm2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dm2Var)) == null) {
                n33 n33Var = new n33();
                n33Var.a = dm2Var.readInt();
                n33Var.b = dm2Var.g();
                n33Var.c = dm2Var.g();
                n33Var.d = dm2Var.g();
                n33Var.e = dm2Var.readInt();
                n33Var.f = dm2Var.readBoolean();
                n33Var.g = dm2Var.g();
                n33Var.h = dm2Var.readBoolean();
                n33Var.i = dm2Var.readBoolean();
                n33Var.j = dm2Var.g();
                n33Var.k = dm2Var.readBoolean();
                n33Var.l = dm2Var.readBoolean();
                n33Var.m = dm2Var.readBoolean();
                n33Var.n = dm2Var.readBoolean();
                n33Var.o = dm2Var.readBoolean();
                n33Var.p = dm2Var.readBoolean();
                n33Var.q = dm2Var.g();
                n33Var.r = dm2Var.g();
                n33Var.s = dm2Var.g();
                return n33Var;
            }
            return (n33) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947951483, "Lcom/baidu/tieba/n33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947951483, "Lcom/baidu/tieba/n33;");
                return;
            }
        }
        t = ij1.a;
        u = new a();
        v = new b();
    }

    public n33() {
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

    public static n33 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (n33) invokeL.objValue;
    }

    public static n33 b(String str, @NonNull n33 n33Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, n33Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return n33Var;
            }
            try {
                return e(new JSONObject(str), n33Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return n33Var;
            }
        }
        return (n33) invokeLL.objValue;
    }

    public static n33 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            n33 n33Var = new n33();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            n33Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            n33Var.c = optString2;
            n33Var.b = optJSONObject.optString("navigationBarTitleText");
            n33Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            n33Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            n33Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            n33Var.g = optJSONObject.optString("onReachBottomDistance");
            n33Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            n33Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            n33Var.j = optJSONObject.optString("navigationStyle", "default");
            n33Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            n33Var.q = optJSONObject.optString("textSizeAdjust");
            n33Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return n33Var;
        }
        return (n33) invokeL.objValue;
    }

    public static n33 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new n33();
        }
        return (n33) invokeV.objValue;
    }

    public static n33 e(JSONObject jSONObject, @NonNull n33 n33Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, n33Var)) == null) {
            n33 n33Var2 = new n33();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            n33Var2.a = TextUtils.isEmpty(optString) ? n33Var.a : SwanAppConfigData.t(optString);
            n33Var2.b = jSONObject.optString("navigationBarTitleText", n33Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = n33Var.c;
            }
            n33Var2.c = optString2;
            n33Var2.d = jSONObject.optString("backgroundTextStyle", n33Var.d);
            n33Var2.e = jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR) ? SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) : n33Var.e;
            n33Var2.f = jSONObject.optBoolean("enablePullDownRefresh", n33Var.f);
            n33Var2.g = jSONObject.optString("onReachBottomDistance", n33Var.g);
            n33Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", n33Var.h);
            n33Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", n33Var.i);
            n33Var2.j = jSONObject.optString("navigationStyle", n33Var.j);
            n33Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", n33Var.k);
            n33Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            n33Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            n33Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            n33Var2.o = jSONObject.optBoolean("_hasVideo", false);
            n33Var2.r = jSONObject.optString("viewMode", n33Var.r);
            n33Var2.s = jSONObject.optString("htmlFontSize", n33Var.s);
            jSONObject.optJSONArray("fontFace");
            return n33Var2;
        }
        return (n33) invokeLL.objValue;
    }

    public static boolean f(n33 n33Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, n33Var)) == null) {
            if (n33Var == null) {
                return false;
            }
            return n33Var.h || TextUtils.equals(n33Var.j, "custom");
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
