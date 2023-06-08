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
/* loaded from: classes6.dex */
public class nc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final mc3<nc3> u;
    public static final lc3<nc3> v;
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
    public static class a extends mc3<nc3> {
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
        @Override // com.baidu.tieba.mc3
        /* renamed from: b */
        public void a(@NonNull nc3 nc3Var, @NonNull ev2 ev2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nc3Var, ev2Var) == null) {
                ev2Var.writeInt(nc3Var.a);
                ev2Var.f(nc3Var.b);
                ev2Var.f(nc3Var.c);
                ev2Var.f(nc3Var.d);
                ev2Var.writeInt(nc3Var.e);
                ev2Var.writeBoolean(nc3Var.f);
                ev2Var.f(nc3Var.g);
                ev2Var.writeBoolean(nc3Var.h);
                ev2Var.writeBoolean(nc3Var.i);
                ev2Var.f(nc3Var.j);
                ev2Var.writeBoolean(nc3Var.k);
                ev2Var.writeBoolean(nc3Var.l);
                ev2Var.writeBoolean(nc3Var.m);
                ev2Var.writeBoolean(nc3Var.n);
                ev2Var.writeBoolean(nc3Var.o);
                ev2Var.writeBoolean(nc3Var.p);
                ev2Var.f(nc3Var.q);
                ev2Var.f(nc3Var.r);
                ev2Var.f(nc3Var.s);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends lc3<nc3> {
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
        @Override // com.baidu.tieba.lc3
        /* renamed from: b */
        public nc3 a(@NonNull dv2 dv2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dv2Var)) == null) {
                nc3 nc3Var = new nc3();
                nc3Var.a = dv2Var.readInt();
                nc3Var.b = dv2Var.g();
                nc3Var.c = dv2Var.g();
                nc3Var.d = dv2Var.g();
                nc3Var.e = dv2Var.readInt();
                nc3Var.f = dv2Var.readBoolean();
                nc3Var.g = dv2Var.g();
                nc3Var.h = dv2Var.readBoolean();
                nc3Var.i = dv2Var.readBoolean();
                nc3Var.j = dv2Var.g();
                nc3Var.k = dv2Var.readBoolean();
                nc3Var.l = dv2Var.readBoolean();
                nc3Var.m = dv2Var.readBoolean();
                nc3Var.n = dv2Var.readBoolean();
                nc3Var.o = dv2Var.readBoolean();
                nc3Var.p = dv2Var.readBoolean();
                nc3Var.q = dv2Var.g();
                nc3Var.r = dv2Var.g();
                nc3Var.s = dv2Var.g();
                return nc3Var;
            }
            return (nc3) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947997611, "Lcom/baidu/tieba/nc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947997611, "Lcom/baidu/tieba/nc3;");
                return;
            }
        }
        t = is1.a;
        u = new a();
        v = new b();
    }

    public nc3() {
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

    public static nc3 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new nc3();
        }
        return (nc3) invokeV.objValue;
    }

    public static nc3 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (nc3) invokeL.objValue;
    }

    public static boolean f(nc3 nc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, nc3Var)) == null) {
            if (nc3Var == null) {
                return false;
            }
            if (!nc3Var.h && !TextUtils.equals(nc3Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static nc3 b(String str, @NonNull nc3 nc3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, nc3Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return nc3Var;
            }
            try {
                return e(new JSONObject(str), nc3Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return nc3Var;
            }
        }
        return (nc3) invokeLL.objValue;
    }

    public static nc3 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (optJSONObject == null) {
                return d();
            }
            nc3 nc3Var = new nc3();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            nc3Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            nc3Var.c = optString2;
            nc3Var.b = optJSONObject.optString("navigationBarTitleText");
            nc3Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            nc3Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            nc3Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            nc3Var.g = optJSONObject.optString("onReachBottomDistance");
            nc3Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            nc3Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            nc3Var.j = optJSONObject.optString("navigationStyle", "default");
            nc3Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            nc3Var.q = optJSONObject.optString("textSizeAdjust");
            nc3Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return nc3Var;
        }
        return (nc3) invokeL.objValue;
    }

    public static nc3 e(JSONObject jSONObject, @NonNull nc3 nc3Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, nc3Var)) == null) {
            nc3 nc3Var2 = new nc3();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = nc3Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            nc3Var2.a = t2;
            nc3Var2.b = jSONObject.optString("navigationBarTitleText", nc3Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = nc3Var.c;
            }
            nc3Var2.c = optString2;
            nc3Var2.d = jSONObject.optString("backgroundTextStyle", nc3Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = nc3Var.e;
            }
            nc3Var2.e = i;
            nc3Var2.f = jSONObject.optBoolean("enablePullDownRefresh", nc3Var.f);
            nc3Var2.g = jSONObject.optString("onReachBottomDistance", nc3Var.g);
            nc3Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", nc3Var.h);
            nc3Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", nc3Var.i);
            nc3Var2.j = jSONObject.optString("navigationStyle", nc3Var.j);
            nc3Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", nc3Var.k);
            nc3Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            nc3Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            nc3Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            nc3Var2.o = jSONObject.optBoolean("_hasVideo", false);
            nc3Var2.r = jSONObject.optString("viewMode", nc3Var.r);
            nc3Var2.s = jSONObject.optString("htmlFontSize", nc3Var.s);
            jSONObject.optJSONArray("fontFace");
            return nc3Var2;
        }
        return (nc3) invokeLL.objValue;
    }
}
