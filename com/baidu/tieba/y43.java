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
/* loaded from: classes7.dex */
public class y43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final x43<y43> u;
    public static final w43<y43> v;
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
    public static class a extends x43<y43> {
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
        @Override // com.baidu.tieba.x43
        /* renamed from: b */
        public void a(@NonNull y43 y43Var, @NonNull pn2 pn2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y43Var, pn2Var) == null) {
                pn2Var.writeInt(y43Var.a);
                pn2Var.f(y43Var.b);
                pn2Var.f(y43Var.c);
                pn2Var.f(y43Var.d);
                pn2Var.writeInt(y43Var.e);
                pn2Var.writeBoolean(y43Var.f);
                pn2Var.f(y43Var.g);
                pn2Var.writeBoolean(y43Var.h);
                pn2Var.writeBoolean(y43Var.i);
                pn2Var.f(y43Var.j);
                pn2Var.writeBoolean(y43Var.k);
                pn2Var.writeBoolean(y43Var.l);
                pn2Var.writeBoolean(y43Var.m);
                pn2Var.writeBoolean(y43Var.n);
                pn2Var.writeBoolean(y43Var.o);
                pn2Var.writeBoolean(y43Var.p);
                pn2Var.f(y43Var.q);
                pn2Var.f(y43Var.r);
                pn2Var.f(y43Var.s);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends w43<y43> {
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
        @Override // com.baidu.tieba.w43
        /* renamed from: b */
        public y43 a(@NonNull on2 on2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on2Var)) == null) {
                y43 y43Var = new y43();
                y43Var.a = on2Var.readInt();
                y43Var.b = on2Var.g();
                y43Var.c = on2Var.g();
                y43Var.d = on2Var.g();
                y43Var.e = on2Var.readInt();
                y43Var.f = on2Var.readBoolean();
                y43Var.g = on2Var.g();
                y43Var.h = on2Var.readBoolean();
                y43Var.i = on2Var.readBoolean();
                y43Var.j = on2Var.g();
                y43Var.k = on2Var.readBoolean();
                y43Var.l = on2Var.readBoolean();
                y43Var.m = on2Var.readBoolean();
                y43Var.n = on2Var.readBoolean();
                y43Var.o = on2Var.readBoolean();
                y43Var.p = on2Var.readBoolean();
                y43Var.q = on2Var.g();
                y43Var.r = on2Var.g();
                y43Var.s = on2Var.g();
                return y43Var;
            }
            return (y43) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948280145, "Lcom/baidu/tieba/y43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948280145, "Lcom/baidu/tieba/y43;");
                return;
            }
        }
        t = tk1.a;
        u = new a();
        v = new b();
    }

    public y43() {
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

    public static y43 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new y43();
        }
        return (y43) invokeV.objValue;
    }

    public static y43 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (y43) invokeL.objValue;
    }

    public static boolean f(y43 y43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, y43Var)) == null) {
            if (y43Var == null) {
                return false;
            }
            if (!y43Var.h && !TextUtils.equals(y43Var.j, "custom")) {
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

    public static y43 b(String str, @NonNull y43 y43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, y43Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return y43Var;
            }
            try {
                return e(new JSONObject(str), y43Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return y43Var;
            }
        }
        return (y43) invokeLL.objValue;
    }

    public static y43 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            y43 y43Var = new y43();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            y43Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            y43Var.c = optString2;
            y43Var.b = optJSONObject.optString("navigationBarTitleText");
            y43Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            y43Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            y43Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            y43Var.g = optJSONObject.optString("onReachBottomDistance");
            y43Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            y43Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            y43Var.j = optJSONObject.optString("navigationStyle", "default");
            y43Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            y43Var.q = optJSONObject.optString("textSizeAdjust");
            y43Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return y43Var;
        }
        return (y43) invokeL.objValue;
    }

    public static y43 e(JSONObject jSONObject, @NonNull y43 y43Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, y43Var)) == null) {
            y43 y43Var2 = new y43();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = y43Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            y43Var2.a = t2;
            y43Var2.b = jSONObject.optString("navigationBarTitleText", y43Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = y43Var.c;
            }
            y43Var2.c = optString2;
            y43Var2.d = jSONObject.optString("backgroundTextStyle", y43Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = y43Var.e;
            }
            y43Var2.e = i;
            y43Var2.f = jSONObject.optBoolean("enablePullDownRefresh", y43Var.f);
            y43Var2.g = jSONObject.optString("onReachBottomDistance", y43Var.g);
            y43Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", y43Var.h);
            y43Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", y43Var.i);
            y43Var2.j = jSONObject.optString("navigationStyle", y43Var.j);
            y43Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", y43Var.k);
            y43Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            y43Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            y43Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            y43Var2.o = jSONObject.optBoolean("_hasVideo", false);
            y43Var2.r = jSONObject.optString("viewMode", y43Var.r);
            y43Var2.s = jSONObject.optString("htmlFontSize", y43Var.s);
            jSONObject.optJSONArray("fontFace");
            return y43Var2;
        }
        return (y43) invokeLL.objValue;
    }
}
