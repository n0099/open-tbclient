package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p03 extends l72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean X;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public String K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public String f1148T;
    public boolean U;
    public String V;
    public String W;
    public String j;
    public boolean k;
    public String l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public String q;
    public int r;
    public boolean s;
    public String t;
    public String u;
    public boolean v;
    public boolean w;
    public boolean x;
    public String y;
    public String z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948008182, "Lcom/baidu/tieba/p03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948008182, "Lcom/baidu/tieba/p03;");
                return;
            }
        }
        X = fs1.a;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l72, com.baidu.tieba.u13
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return TextUtils.equals("auto", this.f1148T);
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.C;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.B;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.A;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return !this.f;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p03() {
        super("video", "componentId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = "";
        this.k = false;
        this.l = "";
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.p = false;
        this.q = "";
        this.r = 0;
        this.t = "";
        this.u = "";
        this.v = false;
        this.w = false;
        this.x = true;
        this.y = "";
        this.z = "";
        this.D = false;
        this.E = true;
        this.F = -1;
        this.G = true;
        this.H = true;
        this.I = true;
        this.J = true;
        this.K = "";
        this.L = true;
        this.M = true;
        this.N = false;
        this.O = false;
        this.P = true;
        this.Q = false;
        this.R = true;
        this.S = false;
        this.f1148T = "";
        this.U = true;
        this.V = "";
        this.W = "";
    }

    public static p03 h(JSONObject jSONObject, @NonNull p03 p03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, p03Var)) == null) {
            p03 p03Var2 = new p03();
            if (jSONObject != null) {
                p03Var2.e(jSONObject, p03Var);
                p03Var2.j = jSONObject.optString("componentId", p03Var.j);
                p03Var2.o = jSONObject.optBoolean("autoplay", p03Var.o);
                p03Var2.k = jSONObject.optBoolean("muted", p03Var.k);
                p03Var2.q = jSONObject.optString("objectFit", p03Var.q);
                p03Var2.m = jSONObject.optInt("initialTime", p03Var.m);
                p03Var2.l = jSONObject.optString(NativeConstants.POSTER, p03Var.l);
                p03Var2.r = jSONObject.optInt(CriusAttrConstants.POSITION, p03Var.r);
                p03Var2.s = jSONObject.optBoolean("fullScreen", p03Var.s);
                p03Var2.t = p(jSONObject);
                p03Var2.u = jSONObject.optString("danmuList", p03Var.u);
                p03Var2.v = jSONObject.optBoolean("enableDanmu", p03Var.v);
                p03Var2.w = jSONObject.optBoolean("danmuBtn", p03Var.w);
                p03Var2.p = jSONObject.optBoolean("loop", p03Var.p);
                p03Var2.x = jSONObject.optBoolean("controls", p03Var.x);
                p03Var2.y = q(jSONObject.optString("src", p03Var.y));
                p03Var2.I = !dj3.E(jSONObject.optString("src", p03Var.y));
                p03Var2.A = jSONObject.optBoolean("showPlayBtn", p03Var.A);
                p03Var2.B = jSONObject.optBoolean("showMuteBtn", p03Var.B);
                p03Var2.C = jSONObject.optBoolean("showCenterPlayBtn", p03Var.C);
                p03Var2.D = jSONObject.optBoolean("pageGesture", p03Var.D);
                p03Var2.E = jSONObject.optBoolean("showProgress", p03Var.E);
                p03Var2.F = jSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, p03Var.F);
                p03Var2.G = jSONObject.optBoolean("showFullscreenBtn", p03Var.G);
                p03Var2.H = jSONObject.optBoolean("enableProgressGesture", p03Var.H);
                p03Var2.z = jSONObject.optString("componentId", p03Var.z);
                p03Var2.J = jSONObject.optBoolean("showNoWifiTip", p03Var.J);
                p03Var2.K = jSONObject.optString("title", p03Var.K);
                p03Var2.L = jSONObject.optBoolean("enablePlayGesture", p03Var.L);
                p03Var2.M = jSONObject.optBoolean("vslideGestureInFullscreen", p03Var.M);
                p03Var2.N = jSONObject.optBoolean("customEnterExitFullScreen", p03Var.N);
                p03Var2.P = jSONObject.optBoolean("showRateBtn", p03Var.P);
                p03Var2.Q = jSONObject.optBoolean("isFullscreen", p03Var.Q);
                p03Var2.O = jSONObject.optBoolean("isAlwaysOnlyShowTopView", p03Var.O);
                p03Var2.R = jSONObject.optBoolean("showVslideBtnInFullscreen", p03Var.R);
                p03Var2.S = jSONObject.optBoolean("silentPlay", p03Var.S);
                p03Var2.f1148T = jSONObject.optString("preload", p03Var.f1148T);
                p03Var2.U = jSONObject.optBoolean("showSilentPlayMutedIcon", p03Var.U);
                p03Var2.V = jSONObject.optString("silentPlayTips", p03Var.V);
                p03Var2.W = jSONObject.optString("rate", p03Var.W);
            }
            return p03Var2;
        }
        return (p03) invokeLL.objValue;
    }

    public static String p(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("text", jSONObject.optString("text"));
                jSONObject2.putOpt("color", jSONObject.optString("color"));
                jSONObject2.putOpt("componentId", jSONObject.optString("componentId"));
            } catch (JSONException e) {
                if (X) {
                    e.printStackTrace();
                }
            }
            return jSONObject2.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (dj3.E(str) && vb3.M() != null) {
                return dj3.H(str, vb3.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.l72
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", duration=" + this.n + ", mAutoPlay=" + this.o + ", mLoop=" + this.p + ", mObjectFit='" + this.q + "', mPos=" + this.r + ", mFullScreen=" + this.s + ", mDanmu='" + this.t + "', mDanmuList='" + this.u + "', mEnableDanmu=" + this.v + ", mShowDanmuBtn=" + this.w + ", mShowControlPanel=" + this.x + ", mSrc='" + this.y + "', mSanId='" + this.z + "', mShowPlayBtn=" + this.A + ", mShowMuteBtn=" + this.B + ", mShowCenterPlayBtn=" + this.C + ", mPageGesture=" + this.D + ", mShowProgress=" + this.E + ", mDirection=" + this.F + ", mShowFullscreenBtn=" + this.G + ", mEnableProgressGesture=" + this.H + ", mIsRemoteFile=" + this.I + '}';
        }
        return (String) invokeV.objValue;
    }
}
