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
/* loaded from: classes7.dex */
public class rc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final qc3<rc3> u;
    public static final pc3<rc3> v;
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
    public static class a extends qc3<rc3> {
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
        @Override // com.baidu.tieba.qc3
        /* renamed from: b */
        public void a(@NonNull rc3 rc3Var, @NonNull iv2 iv2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rc3Var, iv2Var) == null) {
                iv2Var.writeInt(rc3Var.a);
                iv2Var.f(rc3Var.b);
                iv2Var.f(rc3Var.c);
                iv2Var.f(rc3Var.d);
                iv2Var.writeInt(rc3Var.e);
                iv2Var.writeBoolean(rc3Var.f);
                iv2Var.f(rc3Var.g);
                iv2Var.writeBoolean(rc3Var.h);
                iv2Var.writeBoolean(rc3Var.i);
                iv2Var.f(rc3Var.j);
                iv2Var.writeBoolean(rc3Var.k);
                iv2Var.writeBoolean(rc3Var.l);
                iv2Var.writeBoolean(rc3Var.m);
                iv2Var.writeBoolean(rc3Var.n);
                iv2Var.writeBoolean(rc3Var.o);
                iv2Var.writeBoolean(rc3Var.p);
                iv2Var.f(rc3Var.q);
                iv2Var.f(rc3Var.r);
                iv2Var.f(rc3Var.s);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends pc3<rc3> {
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
        @Override // com.baidu.tieba.pc3
        /* renamed from: b */
        public rc3 a(@NonNull hv2 hv2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hv2Var)) == null) {
                rc3 rc3Var = new rc3();
                rc3Var.a = hv2Var.readInt();
                rc3Var.b = hv2Var.g();
                rc3Var.c = hv2Var.g();
                rc3Var.d = hv2Var.g();
                rc3Var.e = hv2Var.readInt();
                rc3Var.f = hv2Var.readBoolean();
                rc3Var.g = hv2Var.g();
                rc3Var.h = hv2Var.readBoolean();
                rc3Var.i = hv2Var.readBoolean();
                rc3Var.j = hv2Var.g();
                rc3Var.k = hv2Var.readBoolean();
                rc3Var.l = hv2Var.readBoolean();
                rc3Var.m = hv2Var.readBoolean();
                rc3Var.n = hv2Var.readBoolean();
                rc3Var.o = hv2Var.readBoolean();
                rc3Var.p = hv2Var.readBoolean();
                rc3Var.q = hv2Var.g();
                rc3Var.r = hv2Var.g();
                rc3Var.s = hv2Var.g();
                return rc3Var;
            }
            return (rc3) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948116775, "Lcom/baidu/tieba/rc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948116775, "Lcom/baidu/tieba/rc3;");
                return;
            }
        }
        t = ms1.a;
        u = new a();
        v = new b();
    }

    public rc3() {
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

    public static rc3 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new rc3();
        }
        return (rc3) invokeV.objValue;
    }

    public static rc3 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (rc3) invokeL.objValue;
    }

    public static boolean f(rc3 rc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, rc3Var)) == null) {
            if (rc3Var == null) {
                return false;
            }
            if (!rc3Var.h && !TextUtils.equals(rc3Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static rc3 b(String str, @NonNull rc3 rc3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, rc3Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return rc3Var;
            }
            try {
                return e(new JSONObject(str), rc3Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return rc3Var;
            }
        }
        return (rc3) invokeLL.objValue;
    }

    public static rc3 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (optJSONObject == null) {
                return d();
            }
            rc3 rc3Var = new rc3();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            rc3Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            rc3Var.c = optString2;
            rc3Var.b = optJSONObject.optString("navigationBarTitleText");
            rc3Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            rc3Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            rc3Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            rc3Var.g = optJSONObject.optString("onReachBottomDistance");
            rc3Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            rc3Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            rc3Var.j = optJSONObject.optString("navigationStyle", "default");
            rc3Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            rc3Var.q = optJSONObject.optString("textSizeAdjust");
            rc3Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return rc3Var;
        }
        return (rc3) invokeL.objValue;
    }

    public static rc3 e(JSONObject jSONObject, @NonNull rc3 rc3Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, rc3Var)) == null) {
            rc3 rc3Var2 = new rc3();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = rc3Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            rc3Var2.a = t2;
            rc3Var2.b = jSONObject.optString("navigationBarTitleText", rc3Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = rc3Var.c;
            }
            rc3Var2.c = optString2;
            rc3Var2.d = jSONObject.optString("backgroundTextStyle", rc3Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = rc3Var.e;
            }
            rc3Var2.e = i;
            rc3Var2.f = jSONObject.optBoolean("enablePullDownRefresh", rc3Var.f);
            rc3Var2.g = jSONObject.optString("onReachBottomDistance", rc3Var.g);
            rc3Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", rc3Var.h);
            rc3Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", rc3Var.i);
            rc3Var2.j = jSONObject.optString("navigationStyle", rc3Var.j);
            rc3Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", rc3Var.k);
            rc3Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            rc3Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            rc3Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            rc3Var2.o = jSONObject.optBoolean("_hasVideo", false);
            rc3Var2.r = jSONObject.optString("viewMode", rc3Var.r);
            rc3Var2.s = jSONObject.optString("htmlFontSize", rc3Var.s);
            jSONObject.optJSONArray("fontFace");
            return rc3Var2;
        }
        return (rc3) invokeLL.objValue;
    }
}
