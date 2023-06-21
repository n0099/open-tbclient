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
public class oc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final nc3<oc3> u;
    public static final mc3<oc3> v;
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
    public static class a extends nc3<oc3> {
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
        @Override // com.baidu.tieba.nc3
        /* renamed from: b */
        public void a(@NonNull oc3 oc3Var, @NonNull fv2 fv2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oc3Var, fv2Var) == null) {
                fv2Var.writeInt(oc3Var.a);
                fv2Var.f(oc3Var.b);
                fv2Var.f(oc3Var.c);
                fv2Var.f(oc3Var.d);
                fv2Var.writeInt(oc3Var.e);
                fv2Var.writeBoolean(oc3Var.f);
                fv2Var.f(oc3Var.g);
                fv2Var.writeBoolean(oc3Var.h);
                fv2Var.writeBoolean(oc3Var.i);
                fv2Var.f(oc3Var.j);
                fv2Var.writeBoolean(oc3Var.k);
                fv2Var.writeBoolean(oc3Var.l);
                fv2Var.writeBoolean(oc3Var.m);
                fv2Var.writeBoolean(oc3Var.n);
                fv2Var.writeBoolean(oc3Var.o);
                fv2Var.writeBoolean(oc3Var.p);
                fv2Var.f(oc3Var.q);
                fv2Var.f(oc3Var.r);
                fv2Var.f(oc3Var.s);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends mc3<oc3> {
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
        @Override // com.baidu.tieba.mc3
        /* renamed from: b */
        public oc3 a(@NonNull ev2 ev2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ev2Var)) == null) {
                oc3 oc3Var = new oc3();
                oc3Var.a = ev2Var.readInt();
                oc3Var.b = ev2Var.g();
                oc3Var.c = ev2Var.g();
                oc3Var.d = ev2Var.g();
                oc3Var.e = ev2Var.readInt();
                oc3Var.f = ev2Var.readBoolean();
                oc3Var.g = ev2Var.g();
                oc3Var.h = ev2Var.readBoolean();
                oc3Var.i = ev2Var.readBoolean();
                oc3Var.j = ev2Var.g();
                oc3Var.k = ev2Var.readBoolean();
                oc3Var.l = ev2Var.readBoolean();
                oc3Var.m = ev2Var.readBoolean();
                oc3Var.n = ev2Var.readBoolean();
                oc3Var.o = ev2Var.readBoolean();
                oc3Var.p = ev2Var.readBoolean();
                oc3Var.q = ev2Var.g();
                oc3Var.r = ev2Var.g();
                oc3Var.s = ev2Var.g();
                return oc3Var;
            }
            return (oc3) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948027402, "Lcom/baidu/tieba/oc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948027402, "Lcom/baidu/tieba/oc3;");
                return;
            }
        }
        t = js1.a;
        u = new a();
        v = new b();
    }

    public oc3() {
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

    public static oc3 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new oc3();
        }
        return (oc3) invokeV.objValue;
    }

    public static oc3 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (oc3) invokeL.objValue;
    }

    public static boolean f(oc3 oc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, oc3Var)) == null) {
            if (oc3Var == null) {
                return false;
            }
            if (!oc3Var.h && !TextUtils.equals(oc3Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static oc3 b(String str, @NonNull oc3 oc3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, oc3Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return oc3Var;
            }
            try {
                return e(new JSONObject(str), oc3Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return oc3Var;
            }
        }
        return (oc3) invokeLL.objValue;
    }

    public static oc3 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (optJSONObject == null) {
                return d();
            }
            oc3 oc3Var = new oc3();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            oc3Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            oc3Var.c = optString2;
            oc3Var.b = optJSONObject.optString("navigationBarTitleText");
            oc3Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            oc3Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            oc3Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            oc3Var.g = optJSONObject.optString("onReachBottomDistance");
            oc3Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            oc3Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            oc3Var.j = optJSONObject.optString("navigationStyle", "default");
            oc3Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            oc3Var.q = optJSONObject.optString("textSizeAdjust");
            oc3Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return oc3Var;
        }
        return (oc3) invokeL.objValue;
    }

    public static oc3 e(JSONObject jSONObject, @NonNull oc3 oc3Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, oc3Var)) == null) {
            oc3 oc3Var2 = new oc3();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = oc3Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            oc3Var2.a = t2;
            oc3Var2.b = jSONObject.optString("navigationBarTitleText", oc3Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = oc3Var.c;
            }
            oc3Var2.c = optString2;
            oc3Var2.d = jSONObject.optString("backgroundTextStyle", oc3Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = oc3Var.e;
            }
            oc3Var2.e = i;
            oc3Var2.f = jSONObject.optBoolean("enablePullDownRefresh", oc3Var.f);
            oc3Var2.g = jSONObject.optString("onReachBottomDistance", oc3Var.g);
            oc3Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", oc3Var.h);
            oc3Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", oc3Var.i);
            oc3Var2.j = jSONObject.optString("navigationStyle", oc3Var.j);
            oc3Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", oc3Var.k);
            oc3Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            oc3Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            oc3Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            oc3Var2.o = jSONObject.optBoolean("_hasVideo", false);
            oc3Var2.r = jSONObject.optString("viewMode", oc3Var.r);
            oc3Var2.s = jSONObject.optString("htmlFontSize", oc3Var.s);
            jSONObject.optJSONArray("fontFace");
            return oc3Var2;
        }
        return (oc3) invokeLL.objValue;
    }
}
