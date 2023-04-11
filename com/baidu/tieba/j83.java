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
public class j83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final i83<j83> u;
    public static final h83<j83> v;
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
    public static class a extends i83<j83> {
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
        @Override // com.baidu.tieba.i83
        /* renamed from: b */
        public void a(@NonNull j83 j83Var, @NonNull ar2 ar2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j83Var, ar2Var) == null) {
                ar2Var.writeInt(j83Var.a);
                ar2Var.f(j83Var.b);
                ar2Var.f(j83Var.c);
                ar2Var.f(j83Var.d);
                ar2Var.writeInt(j83Var.e);
                ar2Var.writeBoolean(j83Var.f);
                ar2Var.f(j83Var.g);
                ar2Var.writeBoolean(j83Var.h);
                ar2Var.writeBoolean(j83Var.i);
                ar2Var.f(j83Var.j);
                ar2Var.writeBoolean(j83Var.k);
                ar2Var.writeBoolean(j83Var.l);
                ar2Var.writeBoolean(j83Var.m);
                ar2Var.writeBoolean(j83Var.n);
                ar2Var.writeBoolean(j83Var.o);
                ar2Var.writeBoolean(j83Var.p);
                ar2Var.f(j83Var.q);
                ar2Var.f(j83Var.r);
                ar2Var.f(j83Var.s);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends h83<j83> {
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
        @Override // com.baidu.tieba.h83
        /* renamed from: b */
        public j83 a(@NonNull zq2 zq2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zq2Var)) == null) {
                j83 j83Var = new j83();
                j83Var.a = zq2Var.readInt();
                j83Var.b = zq2Var.g();
                j83Var.c = zq2Var.g();
                j83Var.d = zq2Var.g();
                j83Var.e = zq2Var.readInt();
                j83Var.f = zq2Var.readBoolean();
                j83Var.g = zq2Var.g();
                j83Var.h = zq2Var.readBoolean();
                j83Var.i = zq2Var.readBoolean();
                j83Var.j = zq2Var.g();
                j83Var.k = zq2Var.readBoolean();
                j83Var.l = zq2Var.readBoolean();
                j83Var.m = zq2Var.readBoolean();
                j83Var.n = zq2Var.readBoolean();
                j83Var.o = zq2Var.readBoolean();
                j83Var.p = zq2Var.readBoolean();
                j83Var.q = zq2Var.g();
                j83Var.r = zq2Var.g();
                j83Var.s = zq2Var.g();
                return j83Var;
            }
            return (j83) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947837124, "Lcom/baidu/tieba/j83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947837124, "Lcom/baidu/tieba/j83;");
                return;
            }
        }
        t = eo1.a;
        u = new a();
        v = new b();
    }

    public j83() {
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

    public static j83 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new j83();
        }
        return (j83) invokeV.objValue;
    }

    public static j83 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (j83) invokeL.objValue;
    }

    public static boolean f(j83 j83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, j83Var)) == null) {
            if (j83Var == null) {
                return false;
            }
            if (!j83Var.h && !TextUtils.equals(j83Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static j83 b(String str, @NonNull j83 j83Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, j83Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return j83Var;
            }
            try {
                return e(new JSONObject(str), j83Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return j83Var;
            }
        }
        return (j83) invokeLL.objValue;
    }

    public static j83 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            j83 j83Var = new j83();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            j83Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            j83Var.c = optString2;
            j83Var.b = optJSONObject.optString("navigationBarTitleText");
            j83Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            j83Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            j83Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            j83Var.g = optJSONObject.optString("onReachBottomDistance");
            j83Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            j83Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            j83Var.j = optJSONObject.optString("navigationStyle", "default");
            j83Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            j83Var.q = optJSONObject.optString("textSizeAdjust");
            j83Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return j83Var;
        }
        return (j83) invokeL.objValue;
    }

    public static j83 e(JSONObject jSONObject, @NonNull j83 j83Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, j83Var)) == null) {
            j83 j83Var2 = new j83();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = j83Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            j83Var2.a = t2;
            j83Var2.b = jSONObject.optString("navigationBarTitleText", j83Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = j83Var.c;
            }
            j83Var2.c = optString2;
            j83Var2.d = jSONObject.optString("backgroundTextStyle", j83Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = j83Var.e;
            }
            j83Var2.e = i;
            j83Var2.f = jSONObject.optBoolean("enablePullDownRefresh", j83Var.f);
            j83Var2.g = jSONObject.optString("onReachBottomDistance", j83Var.g);
            j83Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", j83Var.h);
            j83Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", j83Var.i);
            j83Var2.j = jSONObject.optString("navigationStyle", j83Var.j);
            j83Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", j83Var.k);
            j83Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            j83Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            j83Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            j83Var2.o = jSONObject.optBoolean("_hasVideo", false);
            j83Var2.r = jSONObject.optString("viewMode", j83Var.r);
            j83Var2.s = jSONObject.optString("htmlFontSize", j83Var.s);
            jSONObject.optJSONArray("fontFace");
            return j83Var2;
        }
        return (j83) invokeLL.objValue;
    }
}
