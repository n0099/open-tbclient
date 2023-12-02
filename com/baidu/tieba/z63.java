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
/* loaded from: classes9.dex */
public class z63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final y63<z63> u;
    public static final x63<z63> v;
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

    /* loaded from: classes9.dex */
    public static class a extends y63<z63> {
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
        @Override // com.baidu.tieba.y63
        /* renamed from: c */
        public void b(@NonNull z63 z63Var, @NonNull qp2 qp2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z63Var, qp2Var) == null) {
                qp2Var.writeInt(z63Var.a);
                qp2Var.f(z63Var.b);
                qp2Var.f(z63Var.c);
                qp2Var.f(z63Var.d);
                qp2Var.writeInt(z63Var.e);
                qp2Var.writeBoolean(z63Var.f);
                qp2Var.f(z63Var.g);
                qp2Var.writeBoolean(z63Var.h);
                qp2Var.writeBoolean(z63Var.i);
                qp2Var.f(z63Var.j);
                qp2Var.writeBoolean(z63Var.k);
                qp2Var.writeBoolean(z63Var.l);
                qp2Var.writeBoolean(z63Var.m);
                qp2Var.writeBoolean(z63Var.n);
                qp2Var.writeBoolean(z63Var.o);
                qp2Var.writeBoolean(z63Var.p);
                qp2Var.f(z63Var.q);
                qp2Var.f(z63Var.r);
                qp2Var.f(z63Var.s);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends x63<z63> {
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
        @Override // com.baidu.tieba.x63
        /* renamed from: c */
        public z63 b(@NonNull pp2 pp2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pp2Var)) == null) {
                z63 z63Var = new z63();
                z63Var.a = pp2Var.readInt();
                z63Var.b = pp2Var.g();
                z63Var.c = pp2Var.g();
                z63Var.d = pp2Var.g();
                z63Var.e = pp2Var.readInt();
                z63Var.f = pp2Var.readBoolean();
                z63Var.g = pp2Var.g();
                z63Var.h = pp2Var.readBoolean();
                z63Var.i = pp2Var.readBoolean();
                z63Var.j = pp2Var.g();
                z63Var.k = pp2Var.readBoolean();
                z63Var.l = pp2Var.readBoolean();
                z63Var.m = pp2Var.readBoolean();
                z63Var.n = pp2Var.readBoolean();
                z63Var.o = pp2Var.readBoolean();
                z63Var.p = pp2Var.readBoolean();
                z63Var.q = pp2Var.g();
                z63Var.r = pp2Var.g();
                z63Var.s = pp2Var.g();
                return z63Var;
            }
            return (z63) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948311858, "Lcom/baidu/tieba/z63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948311858, "Lcom/baidu/tieba/z63;");
                return;
            }
        }
        t = vm1.a;
        u = new a();
        v = new b();
    }

    public z63() {
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

    public static z63 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new z63();
        }
        return (z63) invokeV.objValue;
    }

    public static z63 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (z63) invokeL.objValue;
    }

    public static boolean f(z63 z63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, z63Var)) == null) {
            if (z63Var == null) {
                return false;
            }
            if (!z63Var.h && !TextUtils.equals(z63Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static z63 b(String str, @NonNull z63 z63Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, z63Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return z63Var;
            }
            try {
                return e(new JSONObject(str), z63Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return z63Var;
            }
        }
        return (z63) invokeLL.objValue;
    }

    public static z63 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (optJSONObject == null) {
                return d();
            }
            z63 z63Var = new z63();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            z63Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            z63Var.c = optString2;
            z63Var.b = optJSONObject.optString("navigationBarTitleText");
            z63Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            z63Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            z63Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            z63Var.g = optJSONObject.optString("onReachBottomDistance");
            z63Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            z63Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            z63Var.j = optJSONObject.optString("navigationStyle", "default");
            z63Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            z63Var.q = optJSONObject.optString("textSizeAdjust");
            z63Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return z63Var;
        }
        return (z63) invokeL.objValue;
    }

    public static z63 e(JSONObject jSONObject, @NonNull z63 z63Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, z63Var)) == null) {
            z63 z63Var2 = new z63();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = z63Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            z63Var2.a = t2;
            z63Var2.b = jSONObject.optString("navigationBarTitleText", z63Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = z63Var.c;
            }
            z63Var2.c = optString2;
            z63Var2.d = jSONObject.optString("backgroundTextStyle", z63Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = z63Var.e;
            }
            z63Var2.e = i;
            z63Var2.f = jSONObject.optBoolean("enablePullDownRefresh", z63Var.f);
            z63Var2.g = jSONObject.optString("onReachBottomDistance", z63Var.g);
            z63Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", z63Var.h);
            z63Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", z63Var.i);
            z63Var2.j = jSONObject.optString("navigationStyle", z63Var.j);
            z63Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", z63Var.k);
            z63Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            z63Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            z63Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            z63Var2.o = jSONObject.optBoolean("_hasVideo", false);
            z63Var2.r = jSONObject.optString("viewMode", z63Var.r);
            z63Var2.s = jSONObject.optString("htmlFontSize", z63Var.s);
            jSONObject.optJSONArray("fontFace");
            return z63Var2;
        }
        return (z63) invokeLL.objValue;
    }
}
