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
public class vb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final ub3<vb3> u;
    public static final tb3<vb3> v;
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
    public static class a extends ub3<vb3> {
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
        @Override // com.baidu.tieba.ub3
        /* renamed from: b */
        public void a(@NonNull vb3 vb3Var, @NonNull mu2 mu2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vb3Var, mu2Var) == null) {
                mu2Var.writeInt(vb3Var.a);
                mu2Var.f(vb3Var.b);
                mu2Var.f(vb3Var.c);
                mu2Var.f(vb3Var.d);
                mu2Var.writeInt(vb3Var.e);
                mu2Var.writeBoolean(vb3Var.f);
                mu2Var.f(vb3Var.g);
                mu2Var.writeBoolean(vb3Var.h);
                mu2Var.writeBoolean(vb3Var.i);
                mu2Var.f(vb3Var.j);
                mu2Var.writeBoolean(vb3Var.k);
                mu2Var.writeBoolean(vb3Var.l);
                mu2Var.writeBoolean(vb3Var.m);
                mu2Var.writeBoolean(vb3Var.n);
                mu2Var.writeBoolean(vb3Var.o);
                mu2Var.writeBoolean(vb3Var.p);
                mu2Var.f(vb3Var.q);
                mu2Var.f(vb3Var.r);
                mu2Var.f(vb3Var.s);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends tb3<vb3> {
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
        @Override // com.baidu.tieba.tb3
        /* renamed from: b */
        public vb3 a(@NonNull lu2 lu2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lu2Var)) == null) {
                vb3 vb3Var = new vb3();
                vb3Var.a = lu2Var.readInt();
                vb3Var.b = lu2Var.g();
                vb3Var.c = lu2Var.g();
                vb3Var.d = lu2Var.g();
                vb3Var.e = lu2Var.readInt();
                vb3Var.f = lu2Var.readBoolean();
                vb3Var.g = lu2Var.g();
                vb3Var.h = lu2Var.readBoolean();
                vb3Var.i = lu2Var.readBoolean();
                vb3Var.j = lu2Var.g();
                vb3Var.k = lu2Var.readBoolean();
                vb3Var.l = lu2Var.readBoolean();
                vb3Var.m = lu2Var.readBoolean();
                vb3Var.n = lu2Var.readBoolean();
                vb3Var.o = lu2Var.readBoolean();
                vb3Var.p = lu2Var.readBoolean();
                vb3Var.q = lu2Var.g();
                vb3Var.r = lu2Var.g();
                vb3Var.s = lu2Var.g();
                return vb3Var;
            }
            return (vb3) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948234978, "Lcom/baidu/tieba/vb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948234978, "Lcom/baidu/tieba/vb3;");
                return;
            }
        }
        t = qr1.a;
        u = new a();
        v = new b();
    }

    public vb3() {
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

    public static vb3 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new vb3();
        }
        return (vb3) invokeV.objValue;
    }

    public static vb3 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (vb3) invokeL.objValue;
    }

    public static boolean f(vb3 vb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, vb3Var)) == null) {
            if (vb3Var == null) {
                return false;
            }
            if (!vb3Var.h && !TextUtils.equals(vb3Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static vb3 b(String str, @NonNull vb3 vb3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, vb3Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return vb3Var;
            }
            try {
                return e(new JSONObject(str), vb3Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return vb3Var;
            }
        }
        return (vb3) invokeLL.objValue;
    }

    public static vb3 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (optJSONObject == null) {
                return d();
            }
            vb3 vb3Var = new vb3();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            vb3Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            vb3Var.c = optString2;
            vb3Var.b = optJSONObject.optString("navigationBarTitleText");
            vb3Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            vb3Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            vb3Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            vb3Var.g = optJSONObject.optString("onReachBottomDistance");
            vb3Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            vb3Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            vb3Var.j = optJSONObject.optString("navigationStyle", "default");
            vb3Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            vb3Var.q = optJSONObject.optString("textSizeAdjust");
            vb3Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return vb3Var;
        }
        return (vb3) invokeL.objValue;
    }

    public static vb3 e(JSONObject jSONObject, @NonNull vb3 vb3Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, vb3Var)) == null) {
            vb3 vb3Var2 = new vb3();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = vb3Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            vb3Var2.a = t2;
            vb3Var2.b = jSONObject.optString("navigationBarTitleText", vb3Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = vb3Var.c;
            }
            vb3Var2.c = optString2;
            vb3Var2.d = jSONObject.optString("backgroundTextStyle", vb3Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = vb3Var.e;
            }
            vb3Var2.e = i;
            vb3Var2.f = jSONObject.optBoolean("enablePullDownRefresh", vb3Var.f);
            vb3Var2.g = jSONObject.optString("onReachBottomDistance", vb3Var.g);
            vb3Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", vb3Var.h);
            vb3Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", vb3Var.i);
            vb3Var2.j = jSONObject.optString("navigationStyle", vb3Var.j);
            vb3Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", vb3Var.k);
            vb3Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            vb3Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            vb3Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            vb3Var2.o = jSONObject.optBoolean("_hasVideo", false);
            vb3Var2.r = jSONObject.optString("viewMode", vb3Var.r);
            vb3Var2.s = jSONObject.optString("htmlFontSize", vb3Var.s);
            jSONObject.optJSONArray("fontFace");
            return vb3Var2;
        }
        return (vb3) invokeLL.objValue;
    }
}
