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
/* loaded from: classes6.dex */
public class t43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final s43<t43> u;
    public static final r43<t43> v;
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

    /* loaded from: classes6.dex */
    public static class a extends s43<t43> {
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
        @Override // com.baidu.tieba.s43
        /* renamed from: b */
        public void a(@NonNull t43 t43Var, @NonNull kn2 kn2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t43Var, kn2Var) == null) {
                kn2Var.writeInt(t43Var.a);
                kn2Var.f(t43Var.b);
                kn2Var.f(t43Var.c);
                kn2Var.f(t43Var.d);
                kn2Var.writeInt(t43Var.e);
                kn2Var.writeBoolean(t43Var.f);
                kn2Var.f(t43Var.g);
                kn2Var.writeBoolean(t43Var.h);
                kn2Var.writeBoolean(t43Var.i);
                kn2Var.f(t43Var.j);
                kn2Var.writeBoolean(t43Var.k);
                kn2Var.writeBoolean(t43Var.l);
                kn2Var.writeBoolean(t43Var.m);
                kn2Var.writeBoolean(t43Var.n);
                kn2Var.writeBoolean(t43Var.o);
                kn2Var.writeBoolean(t43Var.p);
                kn2Var.f(t43Var.q);
                kn2Var.f(t43Var.r);
                kn2Var.f(t43Var.s);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends r43<t43> {
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
        @Override // com.baidu.tieba.r43
        /* renamed from: b */
        public t43 a(@NonNull jn2 jn2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jn2Var)) == null) {
                t43 t43Var = new t43();
                t43Var.a = jn2Var.readInt();
                t43Var.b = jn2Var.g();
                t43Var.c = jn2Var.g();
                t43Var.d = jn2Var.g();
                t43Var.e = jn2Var.readInt();
                t43Var.f = jn2Var.readBoolean();
                t43Var.g = jn2Var.g();
                t43Var.h = jn2Var.readBoolean();
                t43Var.i = jn2Var.readBoolean();
                t43Var.j = jn2Var.g();
                t43Var.k = jn2Var.readBoolean();
                t43Var.l = jn2Var.readBoolean();
                t43Var.m = jn2Var.readBoolean();
                t43Var.n = jn2Var.readBoolean();
                t43Var.o = jn2Var.readBoolean();
                t43Var.p = jn2Var.readBoolean();
                t43Var.q = jn2Var.g();
                t43Var.r = jn2Var.g();
                t43Var.s = jn2Var.g();
                return t43Var;
            }
            return (t43) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948131190, "Lcom/baidu/tieba/t43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948131190, "Lcom/baidu/tieba/t43;");
                return;
            }
        }
        t = ok1.a;
        u = new a();
        v = new b();
    }

    public t43() {
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

    public static t43 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new t43();
        }
        return (t43) invokeV.objValue;
    }

    public static t43 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (t43) invokeL.objValue;
    }

    public static boolean f(t43 t43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, t43Var)) == null) {
            if (t43Var == null) {
                return false;
            }
            if (!t43Var.h && !TextUtils.equals(t43Var.j, "custom")) {
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

    public static t43 b(String str, @NonNull t43 t43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, t43Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return t43Var;
            }
            try {
                return e(new JSONObject(str), t43Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return t43Var;
            }
        }
        return (t43) invokeLL.objValue;
    }

    public static t43 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            t43 t43Var = new t43();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            t43Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            t43Var.c = optString2;
            t43Var.b = optJSONObject.optString("navigationBarTitleText");
            t43Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            t43Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            t43Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            t43Var.g = optJSONObject.optString("onReachBottomDistance");
            t43Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            t43Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            t43Var.j = optJSONObject.optString("navigationStyle", "default");
            t43Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            t43Var.q = optJSONObject.optString("textSizeAdjust");
            t43Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return t43Var;
        }
        return (t43) invokeL.objValue;
    }

    public static t43 e(JSONObject jSONObject, @NonNull t43 t43Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, t43Var)) == null) {
            t43 t43Var2 = new t43();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = t43Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            t43Var2.a = t2;
            t43Var2.b = jSONObject.optString("navigationBarTitleText", t43Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = t43Var.c;
            }
            t43Var2.c = optString2;
            t43Var2.d = jSONObject.optString("backgroundTextStyle", t43Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = t43Var.e;
            }
            t43Var2.e = i;
            t43Var2.f = jSONObject.optBoolean("enablePullDownRefresh", t43Var.f);
            t43Var2.g = jSONObject.optString("onReachBottomDistance", t43Var.g);
            t43Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", t43Var.h);
            t43Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", t43Var.i);
            t43Var2.j = jSONObject.optString("navigationStyle", t43Var.j);
            t43Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", t43Var.k);
            t43Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            t43Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            t43Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            t43Var2.o = jSONObject.optBoolean("_hasVideo", false);
            t43Var2.r = jSONObject.optString("viewMode", t43Var.r);
            t43Var2.s = jSONObject.optString("htmlFontSize", t43Var.s);
            jSONObject.optJSONArray("fontFace");
            return t43Var2;
        }
        return (t43) invokeLL.objValue;
    }
}
