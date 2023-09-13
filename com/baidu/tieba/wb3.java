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
public class wb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final vb3<wb3> u;
    public static final ub3<wb3> v;
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
    public static class a extends vb3<wb3> {
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
        @Override // com.baidu.tieba.vb3
        /* renamed from: b */
        public void a(@NonNull wb3 wb3Var, @NonNull nu2 nu2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wb3Var, nu2Var) == null) {
                nu2Var.writeInt(wb3Var.a);
                nu2Var.f(wb3Var.b);
                nu2Var.f(wb3Var.c);
                nu2Var.f(wb3Var.d);
                nu2Var.writeInt(wb3Var.e);
                nu2Var.writeBoolean(wb3Var.f);
                nu2Var.f(wb3Var.g);
                nu2Var.writeBoolean(wb3Var.h);
                nu2Var.writeBoolean(wb3Var.i);
                nu2Var.f(wb3Var.j);
                nu2Var.writeBoolean(wb3Var.k);
                nu2Var.writeBoolean(wb3Var.l);
                nu2Var.writeBoolean(wb3Var.m);
                nu2Var.writeBoolean(wb3Var.n);
                nu2Var.writeBoolean(wb3Var.o);
                nu2Var.writeBoolean(wb3Var.p);
                nu2Var.f(wb3Var.q);
                nu2Var.f(wb3Var.r);
                nu2Var.f(wb3Var.s);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends ub3<wb3> {
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
        @Override // com.baidu.tieba.ub3
        /* renamed from: b */
        public wb3 a(@NonNull mu2 mu2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mu2Var)) == null) {
                wb3 wb3Var = new wb3();
                wb3Var.a = mu2Var.readInt();
                wb3Var.b = mu2Var.g();
                wb3Var.c = mu2Var.g();
                wb3Var.d = mu2Var.g();
                wb3Var.e = mu2Var.readInt();
                wb3Var.f = mu2Var.readBoolean();
                wb3Var.g = mu2Var.g();
                wb3Var.h = mu2Var.readBoolean();
                wb3Var.i = mu2Var.readBoolean();
                wb3Var.j = mu2Var.g();
                wb3Var.k = mu2Var.readBoolean();
                wb3Var.l = mu2Var.readBoolean();
                wb3Var.m = mu2Var.readBoolean();
                wb3Var.n = mu2Var.readBoolean();
                wb3Var.o = mu2Var.readBoolean();
                wb3Var.p = mu2Var.readBoolean();
                wb3Var.q = mu2Var.g();
                wb3Var.r = mu2Var.g();
                wb3Var.s = mu2Var.g();
                return wb3Var;
            }
            return (wb3) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948264769, "Lcom/baidu/tieba/wb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948264769, "Lcom/baidu/tieba/wb3;");
                return;
            }
        }
        t = rr1.a;
        u = new a();
        v = new b();
    }

    public wb3() {
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

    public static wb3 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new wb3();
        }
        return (wb3) invokeV.objValue;
    }

    public static wb3 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (wb3) invokeL.objValue;
    }

    public static boolean f(wb3 wb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, wb3Var)) == null) {
            if (wb3Var == null) {
                return false;
            }
            if (!wb3Var.h && !TextUtils.equals(wb3Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static wb3 b(String str, @NonNull wb3 wb3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, wb3Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return wb3Var;
            }
            try {
                return e(new JSONObject(str), wb3Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return wb3Var;
            }
        }
        return (wb3) invokeLL.objValue;
    }

    public static wb3 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (optJSONObject == null) {
                return d();
            }
            wb3 wb3Var = new wb3();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            wb3Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            wb3Var.c = optString2;
            wb3Var.b = optJSONObject.optString("navigationBarTitleText");
            wb3Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            wb3Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            wb3Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            wb3Var.g = optJSONObject.optString("onReachBottomDistance");
            wb3Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            wb3Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            wb3Var.j = optJSONObject.optString("navigationStyle", "default");
            wb3Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            wb3Var.q = optJSONObject.optString("textSizeAdjust");
            wb3Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return wb3Var;
        }
        return (wb3) invokeL.objValue;
    }

    public static wb3 e(JSONObject jSONObject, @NonNull wb3 wb3Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, wb3Var)) == null) {
            wb3 wb3Var2 = new wb3();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = wb3Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            wb3Var2.a = t2;
            wb3Var2.b = jSONObject.optString("navigationBarTitleText", wb3Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = wb3Var.c;
            }
            wb3Var2.c = optString2;
            wb3Var2.d = jSONObject.optString("backgroundTextStyle", wb3Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = wb3Var.e;
            }
            wb3Var2.e = i;
            wb3Var2.f = jSONObject.optBoolean("enablePullDownRefresh", wb3Var.f);
            wb3Var2.g = jSONObject.optString("onReachBottomDistance", wb3Var.g);
            wb3Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", wb3Var.h);
            wb3Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", wb3Var.i);
            wb3Var2.j = jSONObject.optString("navigationStyle", wb3Var.j);
            wb3Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", wb3Var.k);
            wb3Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            wb3Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            wb3Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            wb3Var2.o = jSONObject.optBoolean("_hasVideo", false);
            wb3Var2.r = jSONObject.optString("viewMode", wb3Var.r);
            wb3Var2.s = jSONObject.optString("htmlFontSize", wb3Var.s);
            jSONObject.optJSONArray("fontFace");
            return wb3Var2;
        }
        return (wb3) invokeLL.objValue;
    }
}
