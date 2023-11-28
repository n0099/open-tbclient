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
public class w63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final v63<w63> u;
    public static final u63<w63> v;
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
    public static class a extends v63<w63> {
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
        @Override // com.baidu.tieba.v63
        /* renamed from: c */
        public void b(@NonNull w63 w63Var, @NonNull np2 np2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w63Var, np2Var) == null) {
                np2Var.writeInt(w63Var.a);
                np2Var.f(w63Var.b);
                np2Var.f(w63Var.c);
                np2Var.f(w63Var.d);
                np2Var.writeInt(w63Var.e);
                np2Var.writeBoolean(w63Var.f);
                np2Var.f(w63Var.g);
                np2Var.writeBoolean(w63Var.h);
                np2Var.writeBoolean(w63Var.i);
                np2Var.f(w63Var.j);
                np2Var.writeBoolean(w63Var.k);
                np2Var.writeBoolean(w63Var.l);
                np2Var.writeBoolean(w63Var.m);
                np2Var.writeBoolean(w63Var.n);
                np2Var.writeBoolean(w63Var.o);
                np2Var.writeBoolean(w63Var.p);
                np2Var.f(w63Var.q);
                np2Var.f(w63Var.r);
                np2Var.f(w63Var.s);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends u63<w63> {
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
        @Override // com.baidu.tieba.u63
        /* renamed from: c */
        public w63 b(@NonNull mp2 mp2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mp2Var)) == null) {
                w63 w63Var = new w63();
                w63Var.a = mp2Var.readInt();
                w63Var.b = mp2Var.g();
                w63Var.c = mp2Var.g();
                w63Var.d = mp2Var.g();
                w63Var.e = mp2Var.readInt();
                w63Var.f = mp2Var.readBoolean();
                w63Var.g = mp2Var.g();
                w63Var.h = mp2Var.readBoolean();
                w63Var.i = mp2Var.readBoolean();
                w63Var.j = mp2Var.g();
                w63Var.k = mp2Var.readBoolean();
                w63Var.l = mp2Var.readBoolean();
                w63Var.m = mp2Var.readBoolean();
                w63Var.n = mp2Var.readBoolean();
                w63Var.o = mp2Var.readBoolean();
                w63Var.p = mp2Var.readBoolean();
                w63Var.q = mp2Var.g();
                w63Var.r = mp2Var.g();
                w63Var.s = mp2Var.g();
                return w63Var;
            }
            return (w63) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948222485, "Lcom/baidu/tieba/w63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948222485, "Lcom/baidu/tieba/w63;");
                return;
            }
        }
        t = sm1.a;
        u = new a();
        v = new b();
    }

    public w63() {
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

    public static w63 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new w63();
        }
        return (w63) invokeV.objValue;
    }

    public static w63 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (w63) invokeL.objValue;
    }

    public static boolean f(w63 w63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, w63Var)) == null) {
            if (w63Var == null) {
                return false;
            }
            if (!w63Var.h && !TextUtils.equals(w63Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static w63 b(String str, @NonNull w63 w63Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, w63Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return w63Var;
            }
            try {
                return e(new JSONObject(str), w63Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return w63Var;
            }
        }
        return (w63) invokeLL.objValue;
    }

    public static w63 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (optJSONObject == null) {
                return d();
            }
            w63 w63Var = new w63();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            w63Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            w63Var.c = optString2;
            w63Var.b = optJSONObject.optString("navigationBarTitleText");
            w63Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            w63Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            w63Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            w63Var.g = optJSONObject.optString("onReachBottomDistance");
            w63Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            w63Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            w63Var.j = optJSONObject.optString("navigationStyle", "default");
            w63Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            w63Var.q = optJSONObject.optString("textSizeAdjust");
            w63Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return w63Var;
        }
        return (w63) invokeL.objValue;
    }

    public static w63 e(JSONObject jSONObject, @NonNull w63 w63Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, w63Var)) == null) {
            w63 w63Var2 = new w63();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = w63Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            w63Var2.a = t2;
            w63Var2.b = jSONObject.optString("navigationBarTitleText", w63Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = w63Var.c;
            }
            w63Var2.c = optString2;
            w63Var2.d = jSONObject.optString("backgroundTextStyle", w63Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = w63Var.e;
            }
            w63Var2.e = i;
            w63Var2.f = jSONObject.optBoolean("enablePullDownRefresh", w63Var.f);
            w63Var2.g = jSONObject.optString("onReachBottomDistance", w63Var.g);
            w63Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", w63Var.h);
            w63Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", w63Var.i);
            w63Var2.j = jSONObject.optString("navigationStyle", w63Var.j);
            w63Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", w63Var.k);
            w63Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            w63Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            w63Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            w63Var2.o = jSONObject.optBoolean("_hasVideo", false);
            w63Var2.r = jSONObject.optString("viewMode", w63Var.r);
            w63Var2.s = jSONObject.optString("htmlFontSize", w63Var.s);
            jSONObject.optJSONArray("fontFace");
            return w63Var2;
        }
        return (w63) invokeLL.objValue;
    }
}
