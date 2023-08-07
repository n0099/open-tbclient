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
public class nb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final mb3<nb3> u;
    public static final lb3<nb3> v;
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
    public static class a extends mb3<nb3> {
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
        @Override // com.baidu.tieba.mb3
        /* renamed from: b */
        public void a(@NonNull nb3 nb3Var, @NonNull eu2 eu2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var, eu2Var) == null) {
                eu2Var.writeInt(nb3Var.a);
                eu2Var.f(nb3Var.b);
                eu2Var.f(nb3Var.c);
                eu2Var.f(nb3Var.d);
                eu2Var.writeInt(nb3Var.e);
                eu2Var.writeBoolean(nb3Var.f);
                eu2Var.f(nb3Var.g);
                eu2Var.writeBoolean(nb3Var.h);
                eu2Var.writeBoolean(nb3Var.i);
                eu2Var.f(nb3Var.j);
                eu2Var.writeBoolean(nb3Var.k);
                eu2Var.writeBoolean(nb3Var.l);
                eu2Var.writeBoolean(nb3Var.m);
                eu2Var.writeBoolean(nb3Var.n);
                eu2Var.writeBoolean(nb3Var.o);
                eu2Var.writeBoolean(nb3Var.p);
                eu2Var.f(nb3Var.q);
                eu2Var.f(nb3Var.r);
                eu2Var.f(nb3Var.s);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends lb3<nb3> {
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
        @Override // com.baidu.tieba.lb3
        /* renamed from: b */
        public nb3 a(@NonNull du2 du2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, du2Var)) == null) {
                nb3 nb3Var = new nb3();
                nb3Var.a = du2Var.readInt();
                nb3Var.b = du2Var.g();
                nb3Var.c = du2Var.g();
                nb3Var.d = du2Var.g();
                nb3Var.e = du2Var.readInt();
                nb3Var.f = du2Var.readBoolean();
                nb3Var.g = du2Var.g();
                nb3Var.h = du2Var.readBoolean();
                nb3Var.i = du2Var.readBoolean();
                nb3Var.j = du2Var.g();
                nb3Var.k = du2Var.readBoolean();
                nb3Var.l = du2Var.readBoolean();
                nb3Var.m = du2Var.readBoolean();
                nb3Var.n = du2Var.readBoolean();
                nb3Var.o = du2Var.readBoolean();
                nb3Var.p = du2Var.readBoolean();
                nb3Var.q = du2Var.g();
                nb3Var.r = du2Var.g();
                nb3Var.s = du2Var.g();
                return nb3Var;
            }
            return (nb3) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947996650, "Lcom/baidu/tieba/nb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947996650, "Lcom/baidu/tieba/nb3;");
                return;
            }
        }
        t = ir1.a;
        u = new a();
        v = new b();
    }

    public nb3() {
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

    public static nb3 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new nb3();
        }
        return (nb3) invokeV.objValue;
    }

    public static nb3 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (nb3) invokeL.objValue;
    }

    public static boolean f(nb3 nb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, nb3Var)) == null) {
            if (nb3Var == null) {
                return false;
            }
            if (!nb3Var.h && !TextUtils.equals(nb3Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static nb3 b(String str, @NonNull nb3 nb3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, nb3Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return nb3Var;
            }
            try {
                return e(new JSONObject(str), nb3Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return nb3Var;
            }
        }
        return (nb3) invokeLL.objValue;
    }

    public static nb3 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (optJSONObject == null) {
                return d();
            }
            nb3 nb3Var = new nb3();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            nb3Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            nb3Var.c = optString2;
            nb3Var.b = optJSONObject.optString("navigationBarTitleText");
            nb3Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            nb3Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            nb3Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            nb3Var.g = optJSONObject.optString("onReachBottomDistance");
            nb3Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            nb3Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            nb3Var.j = optJSONObject.optString("navigationStyle", "default");
            nb3Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            nb3Var.q = optJSONObject.optString("textSizeAdjust");
            nb3Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return nb3Var;
        }
        return (nb3) invokeL.objValue;
    }

    public static nb3 e(JSONObject jSONObject, @NonNull nb3 nb3Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, nb3Var)) == null) {
            nb3 nb3Var2 = new nb3();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = nb3Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            nb3Var2.a = t2;
            nb3Var2.b = jSONObject.optString("navigationBarTitleText", nb3Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = nb3Var.c;
            }
            nb3Var2.c = optString2;
            nb3Var2.d = jSONObject.optString("backgroundTextStyle", nb3Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = nb3Var.e;
            }
            nb3Var2.e = i;
            nb3Var2.f = jSONObject.optBoolean("enablePullDownRefresh", nb3Var.f);
            nb3Var2.g = jSONObject.optString("onReachBottomDistance", nb3Var.g);
            nb3Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", nb3Var.h);
            nb3Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", nb3Var.i);
            nb3Var2.j = jSONObject.optString("navigationStyle", nb3Var.j);
            nb3Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", nb3Var.k);
            nb3Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            nb3Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            nb3Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            nb3Var2.o = jSONObject.optBoolean("_hasVideo", false);
            nb3Var2.r = jSONObject.optString("viewMode", nb3Var.r);
            nb3Var2.s = jSONObject.optString("htmlFontSize", nb3Var.s);
            jSONObject.optJSONArray("fontFace");
            return nb3Var2;
        }
        return (nb3) invokeLL.objValue;
    }
}
