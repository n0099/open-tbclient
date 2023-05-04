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
public class m83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final l83<m83> u;
    public static final k83<m83> v;
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
    public static class a extends l83<m83> {
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
        @Override // com.baidu.tieba.l83
        /* renamed from: b */
        public void a(@NonNull m83 m83Var, @NonNull dr2 dr2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m83Var, dr2Var) == null) {
                dr2Var.writeInt(m83Var.a);
                dr2Var.f(m83Var.b);
                dr2Var.f(m83Var.c);
                dr2Var.f(m83Var.d);
                dr2Var.writeInt(m83Var.e);
                dr2Var.writeBoolean(m83Var.f);
                dr2Var.f(m83Var.g);
                dr2Var.writeBoolean(m83Var.h);
                dr2Var.writeBoolean(m83Var.i);
                dr2Var.f(m83Var.j);
                dr2Var.writeBoolean(m83Var.k);
                dr2Var.writeBoolean(m83Var.l);
                dr2Var.writeBoolean(m83Var.m);
                dr2Var.writeBoolean(m83Var.n);
                dr2Var.writeBoolean(m83Var.o);
                dr2Var.writeBoolean(m83Var.p);
                dr2Var.f(m83Var.q);
                dr2Var.f(m83Var.r);
                dr2Var.f(m83Var.s);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends k83<m83> {
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
        @Override // com.baidu.tieba.k83
        /* renamed from: b */
        public m83 a(@NonNull cr2 cr2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cr2Var)) == null) {
                m83 m83Var = new m83();
                m83Var.a = cr2Var.readInt();
                m83Var.b = cr2Var.g();
                m83Var.c = cr2Var.g();
                m83Var.d = cr2Var.g();
                m83Var.e = cr2Var.readInt();
                m83Var.f = cr2Var.readBoolean();
                m83Var.g = cr2Var.g();
                m83Var.h = cr2Var.readBoolean();
                m83Var.i = cr2Var.readBoolean();
                m83Var.j = cr2Var.g();
                m83Var.k = cr2Var.readBoolean();
                m83Var.l = cr2Var.readBoolean();
                m83Var.m = cr2Var.readBoolean();
                m83Var.n = cr2Var.readBoolean();
                m83Var.o = cr2Var.readBoolean();
                m83Var.p = cr2Var.readBoolean();
                m83Var.q = cr2Var.g();
                m83Var.r = cr2Var.g();
                m83Var.s = cr2Var.g();
                return m83Var;
            }
            return (m83) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947926497, "Lcom/baidu/tieba/m83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947926497, "Lcom/baidu/tieba/m83;");
                return;
            }
        }
        t = ho1.a;
        u = new a();
        v = new b();
    }

    public m83() {
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

    public static m83 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new m83();
        }
        return (m83) invokeV.objValue;
    }

    public static m83 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (m83) invokeL.objValue;
    }

    public static boolean f(m83 m83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, m83Var)) == null) {
            if (m83Var == null) {
                return false;
            }
            if (!m83Var.h && !TextUtils.equals(m83Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static m83 b(String str, @NonNull m83 m83Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, m83Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return m83Var;
            }
            try {
                return e(new JSONObject(str), m83Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return m83Var;
            }
        }
        return (m83) invokeLL.objValue;
    }

    public static m83 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            m83 m83Var = new m83();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            m83Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            m83Var.c = optString2;
            m83Var.b = optJSONObject.optString("navigationBarTitleText");
            m83Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            m83Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            m83Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            m83Var.g = optJSONObject.optString("onReachBottomDistance");
            m83Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            m83Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            m83Var.j = optJSONObject.optString("navigationStyle", "default");
            m83Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            m83Var.q = optJSONObject.optString("textSizeAdjust");
            m83Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return m83Var;
        }
        return (m83) invokeL.objValue;
    }

    public static m83 e(JSONObject jSONObject, @NonNull m83 m83Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, m83Var)) == null) {
            m83 m83Var2 = new m83();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = m83Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            m83Var2.a = t2;
            m83Var2.b = jSONObject.optString("navigationBarTitleText", m83Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = m83Var.c;
            }
            m83Var2.c = optString2;
            m83Var2.d = jSONObject.optString("backgroundTextStyle", m83Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = m83Var.e;
            }
            m83Var2.e = i;
            m83Var2.f = jSONObject.optBoolean("enablePullDownRefresh", m83Var.f);
            m83Var2.g = jSONObject.optString("onReachBottomDistance", m83Var.g);
            m83Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", m83Var.h);
            m83Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", m83Var.i);
            m83Var2.j = jSONObject.optString("navigationStyle", m83Var.j);
            m83Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", m83Var.k);
            m83Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            m83Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            m83Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            m83Var2.o = jSONObject.optBoolean("_hasVideo", false);
            m83Var2.r = jSONObject.optString("viewMode", m83Var.r);
            m83Var2.s = jSONObject.optString("htmlFontSize", m83Var.s);
            jSONObject.optJSONArray("fontFace");
            return m83Var2;
        }
        return (m83) invokeLL.objValue;
    }
}
