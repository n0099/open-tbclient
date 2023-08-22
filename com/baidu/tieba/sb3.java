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
public class sb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final rb3<sb3> u;
    public static final qb3<sb3> v;
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
    public static class a extends rb3<sb3> {
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
        @Override // com.baidu.tieba.rb3
        /* renamed from: b */
        public void a(@NonNull sb3 sb3Var, @NonNull ju2 ju2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb3Var, ju2Var) == null) {
                ju2Var.writeInt(sb3Var.a);
                ju2Var.f(sb3Var.b);
                ju2Var.f(sb3Var.c);
                ju2Var.f(sb3Var.d);
                ju2Var.writeInt(sb3Var.e);
                ju2Var.writeBoolean(sb3Var.f);
                ju2Var.f(sb3Var.g);
                ju2Var.writeBoolean(sb3Var.h);
                ju2Var.writeBoolean(sb3Var.i);
                ju2Var.f(sb3Var.j);
                ju2Var.writeBoolean(sb3Var.k);
                ju2Var.writeBoolean(sb3Var.l);
                ju2Var.writeBoolean(sb3Var.m);
                ju2Var.writeBoolean(sb3Var.n);
                ju2Var.writeBoolean(sb3Var.o);
                ju2Var.writeBoolean(sb3Var.p);
                ju2Var.f(sb3Var.q);
                ju2Var.f(sb3Var.r);
                ju2Var.f(sb3Var.s);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends qb3<sb3> {
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
        @Override // com.baidu.tieba.qb3
        /* renamed from: b */
        public sb3 a(@NonNull iu2 iu2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iu2Var)) == null) {
                sb3 sb3Var = new sb3();
                sb3Var.a = iu2Var.readInt();
                sb3Var.b = iu2Var.g();
                sb3Var.c = iu2Var.g();
                sb3Var.d = iu2Var.g();
                sb3Var.e = iu2Var.readInt();
                sb3Var.f = iu2Var.readBoolean();
                sb3Var.g = iu2Var.g();
                sb3Var.h = iu2Var.readBoolean();
                sb3Var.i = iu2Var.readBoolean();
                sb3Var.j = iu2Var.g();
                sb3Var.k = iu2Var.readBoolean();
                sb3Var.l = iu2Var.readBoolean();
                sb3Var.m = iu2Var.readBoolean();
                sb3Var.n = iu2Var.readBoolean();
                sb3Var.o = iu2Var.readBoolean();
                sb3Var.p = iu2Var.readBoolean();
                sb3Var.q = iu2Var.g();
                sb3Var.r = iu2Var.g();
                sb3Var.s = iu2Var.g();
                return sb3Var;
            }
            return (sb3) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948145605, "Lcom/baidu/tieba/sb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948145605, "Lcom/baidu/tieba/sb3;");
                return;
            }
        }
        t = nr1.a;
        u = new a();
        v = new b();
    }

    public sb3() {
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

    public static sb3 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new sb3();
        }
        return (sb3) invokeV.objValue;
    }

    public static sb3 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (sb3) invokeL.objValue;
    }

    public static boolean f(sb3 sb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, sb3Var)) == null) {
            if (sb3Var == null) {
                return false;
            }
            if (!sb3Var.h && !TextUtils.equals(sb3Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static sb3 b(String str, @NonNull sb3 sb3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, sb3Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return sb3Var;
            }
            try {
                return e(new JSONObject(str), sb3Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return sb3Var;
            }
        }
        return (sb3) invokeLL.objValue;
    }

    public static sb3 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (optJSONObject == null) {
                return d();
            }
            sb3 sb3Var = new sb3();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            sb3Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            sb3Var.c = optString2;
            sb3Var.b = optJSONObject.optString("navigationBarTitleText");
            sb3Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            sb3Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            sb3Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            sb3Var.g = optJSONObject.optString("onReachBottomDistance");
            sb3Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            sb3Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            sb3Var.j = optJSONObject.optString("navigationStyle", "default");
            sb3Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            sb3Var.q = optJSONObject.optString("textSizeAdjust");
            sb3Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return sb3Var;
        }
        return (sb3) invokeL.objValue;
    }

    public static sb3 e(JSONObject jSONObject, @NonNull sb3 sb3Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, sb3Var)) == null) {
            sb3 sb3Var2 = new sb3();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = sb3Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            sb3Var2.a = t2;
            sb3Var2.b = jSONObject.optString("navigationBarTitleText", sb3Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = sb3Var.c;
            }
            sb3Var2.c = optString2;
            sb3Var2.d = jSONObject.optString("backgroundTextStyle", sb3Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = sb3Var.e;
            }
            sb3Var2.e = i;
            sb3Var2.f = jSONObject.optBoolean("enablePullDownRefresh", sb3Var.f);
            sb3Var2.g = jSONObject.optString("onReachBottomDistance", sb3Var.g);
            sb3Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", sb3Var.h);
            sb3Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", sb3Var.i);
            sb3Var2.j = jSONObject.optString("navigationStyle", sb3Var.j);
            sb3Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", sb3Var.k);
            sb3Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            sb3Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            sb3Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            sb3Var2.o = jSONObject.optBoolean("_hasVideo", false);
            sb3Var2.r = jSONObject.optString("viewMode", sb3Var.r);
            sb3Var2.s = jSONObject.optString("htmlFontSize", sb3Var.s);
            jSONObject.optJSONArray("fontFace");
            return sb3Var2;
        }
        return (sb3) invokeLL.objValue;
    }
}
