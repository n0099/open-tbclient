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
public class u43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final t43<u43> u;
    public static final s43<u43> v;
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
    public static class a extends t43<u43> {
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
        @Override // com.baidu.tieba.t43
        /* renamed from: b */
        public void a(@NonNull u43 u43Var, @NonNull ln2 ln2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u43Var, ln2Var) == null) {
                ln2Var.writeInt(u43Var.a);
                ln2Var.f(u43Var.b);
                ln2Var.f(u43Var.c);
                ln2Var.f(u43Var.d);
                ln2Var.writeInt(u43Var.e);
                ln2Var.writeBoolean(u43Var.f);
                ln2Var.f(u43Var.g);
                ln2Var.writeBoolean(u43Var.h);
                ln2Var.writeBoolean(u43Var.i);
                ln2Var.f(u43Var.j);
                ln2Var.writeBoolean(u43Var.k);
                ln2Var.writeBoolean(u43Var.l);
                ln2Var.writeBoolean(u43Var.m);
                ln2Var.writeBoolean(u43Var.n);
                ln2Var.writeBoolean(u43Var.o);
                ln2Var.writeBoolean(u43Var.p);
                ln2Var.f(u43Var.q);
                ln2Var.f(u43Var.r);
                ln2Var.f(u43Var.s);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends s43<u43> {
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
        @Override // com.baidu.tieba.s43
        /* renamed from: b */
        public u43 a(@NonNull kn2 kn2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kn2Var)) == null) {
                u43 u43Var = new u43();
                u43Var.a = kn2Var.readInt();
                u43Var.b = kn2Var.g();
                u43Var.c = kn2Var.g();
                u43Var.d = kn2Var.g();
                u43Var.e = kn2Var.readInt();
                u43Var.f = kn2Var.readBoolean();
                u43Var.g = kn2Var.g();
                u43Var.h = kn2Var.readBoolean();
                u43Var.i = kn2Var.readBoolean();
                u43Var.j = kn2Var.g();
                u43Var.k = kn2Var.readBoolean();
                u43Var.l = kn2Var.readBoolean();
                u43Var.m = kn2Var.readBoolean();
                u43Var.n = kn2Var.readBoolean();
                u43Var.o = kn2Var.readBoolean();
                u43Var.p = kn2Var.readBoolean();
                u43Var.q = kn2Var.g();
                u43Var.r = kn2Var.g();
                u43Var.s = kn2Var.g();
                return u43Var;
            }
            return (u43) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948160981, "Lcom/baidu/tieba/u43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948160981, "Lcom/baidu/tieba/u43;");
                return;
            }
        }
        t = pk1.a;
        u = new a();
        v = new b();
    }

    public u43() {
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

    public static u43 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new u43();
        }
        return (u43) invokeV.objValue;
    }

    public static u43 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (u43) invokeL.objValue;
    }

    public static boolean f(u43 u43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, u43Var)) == null) {
            if (u43Var == null) {
                return false;
            }
            if (!u43Var.h && !TextUtils.equals(u43Var.j, "custom")) {
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

    public static u43 b(String str, @NonNull u43 u43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, u43Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return u43Var;
            }
            try {
                return e(new JSONObject(str), u43Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return u43Var;
            }
        }
        return (u43) invokeLL.objValue;
    }

    public static u43 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            u43 u43Var = new u43();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            u43Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            u43Var.c = optString2;
            u43Var.b = optJSONObject.optString("navigationBarTitleText");
            u43Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            u43Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            u43Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            u43Var.g = optJSONObject.optString("onReachBottomDistance");
            u43Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            u43Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            u43Var.j = optJSONObject.optString("navigationStyle", "default");
            u43Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            u43Var.q = optJSONObject.optString("textSizeAdjust");
            u43Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return u43Var;
        }
        return (u43) invokeL.objValue;
    }

    public static u43 e(JSONObject jSONObject, @NonNull u43 u43Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, u43Var)) == null) {
            u43 u43Var2 = new u43();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = u43Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            u43Var2.a = t2;
            u43Var2.b = jSONObject.optString("navigationBarTitleText", u43Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = u43Var.c;
            }
            u43Var2.c = optString2;
            u43Var2.d = jSONObject.optString("backgroundTextStyle", u43Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = u43Var.e;
            }
            u43Var2.e = i;
            u43Var2.f = jSONObject.optBoolean("enablePullDownRefresh", u43Var.f);
            u43Var2.g = jSONObject.optString("onReachBottomDistance", u43Var.g);
            u43Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", u43Var.h);
            u43Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", u43Var.i);
            u43Var2.j = jSONObject.optString("navigationStyle", u43Var.j);
            u43Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", u43Var.k);
            u43Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            u43Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            u43Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            u43Var2.o = jSONObject.optBoolean("_hasVideo", false);
            u43Var2.r = jSONObject.optString("viewMode", u43Var.r);
            u43Var2.s = jSONObject.optString("htmlFontSize", u43Var.s);
            jSONObject.optJSONArray("fontFace");
            return u43Var2;
        }
        return (u43) invokeLL.objValue;
    }
}
