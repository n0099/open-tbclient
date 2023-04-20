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
/* loaded from: classes5.dex */
public class k83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final j83<k83> u;
    public static final i83<k83> v;
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

    /* loaded from: classes5.dex */
    public static class a extends j83<k83> {
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
        @Override // com.baidu.tieba.j83
        /* renamed from: b */
        public void a(@NonNull k83 k83Var, @NonNull br2 br2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k83Var, br2Var) == null) {
                br2Var.writeInt(k83Var.a);
                br2Var.f(k83Var.b);
                br2Var.f(k83Var.c);
                br2Var.f(k83Var.d);
                br2Var.writeInt(k83Var.e);
                br2Var.writeBoolean(k83Var.f);
                br2Var.f(k83Var.g);
                br2Var.writeBoolean(k83Var.h);
                br2Var.writeBoolean(k83Var.i);
                br2Var.f(k83Var.j);
                br2Var.writeBoolean(k83Var.k);
                br2Var.writeBoolean(k83Var.l);
                br2Var.writeBoolean(k83Var.m);
                br2Var.writeBoolean(k83Var.n);
                br2Var.writeBoolean(k83Var.o);
                br2Var.writeBoolean(k83Var.p);
                br2Var.f(k83Var.q);
                br2Var.f(k83Var.r);
                br2Var.f(k83Var.s);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends i83<k83> {
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
        @Override // com.baidu.tieba.i83
        /* renamed from: b */
        public k83 a(@NonNull ar2 ar2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ar2Var)) == null) {
                k83 k83Var = new k83();
                k83Var.a = ar2Var.readInt();
                k83Var.b = ar2Var.g();
                k83Var.c = ar2Var.g();
                k83Var.d = ar2Var.g();
                k83Var.e = ar2Var.readInt();
                k83Var.f = ar2Var.readBoolean();
                k83Var.g = ar2Var.g();
                k83Var.h = ar2Var.readBoolean();
                k83Var.i = ar2Var.readBoolean();
                k83Var.j = ar2Var.g();
                k83Var.k = ar2Var.readBoolean();
                k83Var.l = ar2Var.readBoolean();
                k83Var.m = ar2Var.readBoolean();
                k83Var.n = ar2Var.readBoolean();
                k83Var.o = ar2Var.readBoolean();
                k83Var.p = ar2Var.readBoolean();
                k83Var.q = ar2Var.g();
                k83Var.r = ar2Var.g();
                k83Var.s = ar2Var.g();
                return k83Var;
            }
            return (k83) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947866915, "Lcom/baidu/tieba/k83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947866915, "Lcom/baidu/tieba/k83;");
                return;
            }
        }
        t = fo1.a;
        u = new a();
        v = new b();
    }

    public k83() {
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

    public static k83 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new k83();
        }
        return (k83) invokeV.objValue;
    }

    public static k83 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (k83) invokeL.objValue;
    }

    public static boolean f(k83 k83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, k83Var)) == null) {
            if (k83Var == null) {
                return false;
            }
            if (!k83Var.h && !TextUtils.equals(k83Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static k83 b(String str, @NonNull k83 k83Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, k83Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return k83Var;
            }
            try {
                return e(new JSONObject(str), k83Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return k83Var;
            }
        }
        return (k83) invokeLL.objValue;
    }

    public static k83 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            k83 k83Var = new k83();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            k83Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            k83Var.c = optString2;
            k83Var.b = optJSONObject.optString("navigationBarTitleText");
            k83Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            k83Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            k83Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            k83Var.g = optJSONObject.optString("onReachBottomDistance");
            k83Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            k83Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            k83Var.j = optJSONObject.optString("navigationStyle", "default");
            k83Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            k83Var.q = optJSONObject.optString("textSizeAdjust");
            k83Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return k83Var;
        }
        return (k83) invokeL.objValue;
    }

    public static k83 e(JSONObject jSONObject, @NonNull k83 k83Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, k83Var)) == null) {
            k83 k83Var2 = new k83();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = k83Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            k83Var2.a = t2;
            k83Var2.b = jSONObject.optString("navigationBarTitleText", k83Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = k83Var.c;
            }
            k83Var2.c = optString2;
            k83Var2.d = jSONObject.optString("backgroundTextStyle", k83Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = k83Var.e;
            }
            k83Var2.e = i;
            k83Var2.f = jSONObject.optBoolean("enablePullDownRefresh", k83Var.f);
            k83Var2.g = jSONObject.optString("onReachBottomDistance", k83Var.g);
            k83Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", k83Var.h);
            k83Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", k83Var.i);
            k83Var2.j = jSONObject.optString("navigationStyle", k83Var.j);
            k83Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", k83Var.k);
            k83Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            k83Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            k83Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            k83Var2.o = jSONObject.optBoolean("_hasVideo", false);
            k83Var2.r = jSONObject.optString("viewMode", k83Var.r);
            k83Var2.s = jSONObject.optString("htmlFontSize", k83Var.s);
            jSONObject.optJSONArray("fontFace");
            return k83Var2;
        }
        return (k83) invokeLL.objValue;
    }
}
