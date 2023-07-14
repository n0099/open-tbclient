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
public class kc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final jc3<kc3> u;
    public static final ic3<kc3> v;
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
    public static class a extends jc3<kc3> {
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
        @Override // com.baidu.tieba.jc3
        /* renamed from: b */
        public void a(@NonNull kc3 kc3Var, @NonNull bv2 bv2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kc3Var, bv2Var) == null) {
                bv2Var.writeInt(kc3Var.a);
                bv2Var.f(kc3Var.b);
                bv2Var.f(kc3Var.c);
                bv2Var.f(kc3Var.d);
                bv2Var.writeInt(kc3Var.e);
                bv2Var.writeBoolean(kc3Var.f);
                bv2Var.f(kc3Var.g);
                bv2Var.writeBoolean(kc3Var.h);
                bv2Var.writeBoolean(kc3Var.i);
                bv2Var.f(kc3Var.j);
                bv2Var.writeBoolean(kc3Var.k);
                bv2Var.writeBoolean(kc3Var.l);
                bv2Var.writeBoolean(kc3Var.m);
                bv2Var.writeBoolean(kc3Var.n);
                bv2Var.writeBoolean(kc3Var.o);
                bv2Var.writeBoolean(kc3Var.p);
                bv2Var.f(kc3Var.q);
                bv2Var.f(kc3Var.r);
                bv2Var.f(kc3Var.s);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends ic3<kc3> {
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
        @Override // com.baidu.tieba.ic3
        /* renamed from: b */
        public kc3 a(@NonNull av2 av2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, av2Var)) == null) {
                kc3 kc3Var = new kc3();
                kc3Var.a = av2Var.readInt();
                kc3Var.b = av2Var.g();
                kc3Var.c = av2Var.g();
                kc3Var.d = av2Var.g();
                kc3Var.e = av2Var.readInt();
                kc3Var.f = av2Var.readBoolean();
                kc3Var.g = av2Var.g();
                kc3Var.h = av2Var.readBoolean();
                kc3Var.i = av2Var.readBoolean();
                kc3Var.j = av2Var.g();
                kc3Var.k = av2Var.readBoolean();
                kc3Var.l = av2Var.readBoolean();
                kc3Var.m = av2Var.readBoolean();
                kc3Var.n = av2Var.readBoolean();
                kc3Var.o = av2Var.readBoolean();
                kc3Var.p = av2Var.readBoolean();
                kc3Var.q = av2Var.g();
                kc3Var.r = av2Var.g();
                kc3Var.s = av2Var.g();
                return kc3Var;
            }
            return (kc3) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947908238, "Lcom/baidu/tieba/kc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947908238, "Lcom/baidu/tieba/kc3;");
                return;
            }
        }
        t = fs1.a;
        u = new a();
        v = new b();
    }

    public kc3() {
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

    public static kc3 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new kc3();
        }
        return (kc3) invokeV.objValue;
    }

    public static kc3 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (kc3) invokeL.objValue;
    }

    public static boolean f(kc3 kc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, kc3Var)) == null) {
            if (kc3Var == null) {
                return false;
            }
            if (!kc3Var.h && !TextUtils.equals(kc3Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static kc3 b(String str, @NonNull kc3 kc3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, kc3Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return kc3Var;
            }
            try {
                return e(new JSONObject(str), kc3Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return kc3Var;
            }
        }
        return (kc3) invokeLL.objValue;
    }

    public static kc3 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (optJSONObject == null) {
                return d();
            }
            kc3 kc3Var = new kc3();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            kc3Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            kc3Var.c = optString2;
            kc3Var.b = optJSONObject.optString("navigationBarTitleText");
            kc3Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            kc3Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            kc3Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            kc3Var.g = optJSONObject.optString("onReachBottomDistance");
            kc3Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            kc3Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            kc3Var.j = optJSONObject.optString("navigationStyle", "default");
            kc3Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            kc3Var.q = optJSONObject.optString("textSizeAdjust");
            kc3Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return kc3Var;
        }
        return (kc3) invokeL.objValue;
    }

    public static kc3 e(JSONObject jSONObject, @NonNull kc3 kc3Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, kc3Var)) == null) {
            kc3 kc3Var2 = new kc3();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = kc3Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            kc3Var2.a = t2;
            kc3Var2.b = jSONObject.optString("navigationBarTitleText", kc3Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = kc3Var.c;
            }
            kc3Var2.c = optString2;
            kc3Var2.d = jSONObject.optString("backgroundTextStyle", kc3Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = kc3Var.e;
            }
            kc3Var2.e = i;
            kc3Var2.f = jSONObject.optBoolean("enablePullDownRefresh", kc3Var.f);
            kc3Var2.g = jSONObject.optString("onReachBottomDistance", kc3Var.g);
            kc3Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", kc3Var.h);
            kc3Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", kc3Var.i);
            kc3Var2.j = jSONObject.optString("navigationStyle", kc3Var.j);
            kc3Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", kc3Var.k);
            kc3Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            kc3Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            kc3Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            kc3Var2.o = jSONObject.optBoolean("_hasVideo", false);
            kc3Var2.r = jSONObject.optString("viewMode", kc3Var.r);
            kc3Var2.s = jSONObject.optString("htmlFontSize", kc3Var.s);
            jSONObject.optJSONArray("fontFace");
            return kc3Var2;
        }
        return (kc3) invokeLL.objValue;
    }
}
