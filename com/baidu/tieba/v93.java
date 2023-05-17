package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes7.dex */
public class v93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final u93<v93> u;
    public static final t93<v93> v;
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

    /* loaded from: classes7.dex */
    public static class a extends u93<v93> {
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
        @Override // com.baidu.tieba.u93
        /* renamed from: b */
        public void a(@NonNull v93 v93Var, @NonNull ms2 ms2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v93Var, ms2Var) == null) {
                ms2Var.writeInt(v93Var.a);
                ms2Var.f(v93Var.b);
                ms2Var.f(v93Var.c);
                ms2Var.f(v93Var.d);
                ms2Var.writeInt(v93Var.e);
                ms2Var.writeBoolean(v93Var.f);
                ms2Var.f(v93Var.g);
                ms2Var.writeBoolean(v93Var.h);
                ms2Var.writeBoolean(v93Var.i);
                ms2Var.f(v93Var.j);
                ms2Var.writeBoolean(v93Var.k);
                ms2Var.writeBoolean(v93Var.l);
                ms2Var.writeBoolean(v93Var.m);
                ms2Var.writeBoolean(v93Var.n);
                ms2Var.writeBoolean(v93Var.o);
                ms2Var.writeBoolean(v93Var.p);
                ms2Var.f(v93Var.q);
                ms2Var.f(v93Var.r);
                ms2Var.f(v93Var.s);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends t93<v93> {
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
        @Override // com.baidu.tieba.t93
        /* renamed from: b */
        public v93 a(@NonNull ls2 ls2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ls2Var)) == null) {
                v93 v93Var = new v93();
                v93Var.a = ls2Var.readInt();
                v93Var.b = ls2Var.g();
                v93Var.c = ls2Var.g();
                v93Var.d = ls2Var.g();
                v93Var.e = ls2Var.readInt();
                v93Var.f = ls2Var.readBoolean();
                v93Var.g = ls2Var.g();
                v93Var.h = ls2Var.readBoolean();
                v93Var.i = ls2Var.readBoolean();
                v93Var.j = ls2Var.g();
                v93Var.k = ls2Var.readBoolean();
                v93Var.l = ls2Var.readBoolean();
                v93Var.m = ls2Var.readBoolean();
                v93Var.n = ls2Var.readBoolean();
                v93Var.o = ls2Var.readBoolean();
                v93Var.p = ls2Var.readBoolean();
                v93Var.q = ls2Var.g();
                v93Var.r = ls2Var.g();
                v93Var.s = ls2Var.g();
                return v93Var;
            }
            return (v93) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948195577, "Lcom/baidu/tieba/v93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948195577, "Lcom/baidu/tieba/v93;");
                return;
            }
        }
        t = qp1.a;
        u = new a();
        v = new b();
    }

    public v93() {
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

    public static v93 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new v93();
        }
        return (v93) invokeV.objValue;
    }

    public static v93 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (v93) invokeL.objValue;
    }

    public static boolean f(v93 v93Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, v93Var)) == null) {
            if (v93Var == null) {
                return false;
            }
            if (!v93Var.h && !TextUtils.equals(v93Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static v93 b(String str, @NonNull v93 v93Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, v93Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return v93Var;
            }
            try {
                return e(new JSONObject(str), v93Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return v93Var;
            }
        }
        return (v93) invokeLL.objValue;
    }

    public static v93 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            v93 v93Var = new v93();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            v93Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            v93Var.c = optString2;
            v93Var.b = optJSONObject.optString("navigationBarTitleText");
            v93Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            v93Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            v93Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            v93Var.g = optJSONObject.optString("onReachBottomDistance");
            v93Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            v93Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            v93Var.j = optJSONObject.optString("navigationStyle", "default");
            v93Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            v93Var.q = optJSONObject.optString("textSizeAdjust");
            v93Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return v93Var;
        }
        return (v93) invokeL.objValue;
    }

    public static v93 e(JSONObject jSONObject, @NonNull v93 v93Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, v93Var)) == null) {
            v93 v93Var2 = new v93();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = v93Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            v93Var2.a = t2;
            v93Var2.b = jSONObject.optString("navigationBarTitleText", v93Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = v93Var.c;
            }
            v93Var2.c = optString2;
            v93Var2.d = jSONObject.optString("backgroundTextStyle", v93Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = v93Var.e;
            }
            v93Var2.e = i;
            v93Var2.f = jSONObject.optBoolean("enablePullDownRefresh", v93Var.f);
            v93Var2.g = jSONObject.optString("onReachBottomDistance", v93Var.g);
            v93Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", v93Var.h);
            v93Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", v93Var.i);
            v93Var2.j = jSONObject.optString("navigationStyle", v93Var.j);
            v93Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", v93Var.k);
            v93Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            v93Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            v93Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            v93Var2.o = jSONObject.optBoolean("_hasVideo", false);
            v93Var2.r = jSONObject.optString("viewMode", v93Var.r);
            v93Var2.s = jSONObject.optString("htmlFontSize", v93Var.s);
            jSONObject.optJSONArray("fontFace");
            return v93Var2;
        }
        return (v93) invokeLL.objValue;
    }
}
