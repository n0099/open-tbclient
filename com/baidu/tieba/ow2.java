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
/* loaded from: classes5.dex */
public class ow2 extends k32 {
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
    public String T;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948046591, "Lcom/baidu/tieba/ow2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948046591, "Lcom/baidu/tieba/ow2;");
                return;
            }
        }
        X = eo1.a;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k32, com.baidu.tieba.tx2
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
            return TextUtils.equals("auto", this.T);
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
    public ow2() {
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
        this.T = "";
        this.U = true;
        this.V = "";
        this.W = "";
    }

    public static ow2 h(JSONObject jSONObject, @NonNull ow2 ow2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, ow2Var)) == null) {
            ow2 ow2Var2 = new ow2();
            if (jSONObject != null) {
                ow2Var2.e(jSONObject, ow2Var);
                ow2Var2.j = jSONObject.optString("componentId", ow2Var.j);
                ow2Var2.o = jSONObject.optBoolean("autoplay", ow2Var.o);
                ow2Var2.k = jSONObject.optBoolean("muted", ow2Var.k);
                ow2Var2.q = jSONObject.optString("objectFit", ow2Var.q);
                ow2Var2.m = jSONObject.optInt("initialTime", ow2Var.m);
                ow2Var2.l = jSONObject.optString(NativeConstants.POSTER, ow2Var.l);
                ow2Var2.r = jSONObject.optInt(CriusAttrConstants.POSITION, ow2Var.r);
                ow2Var2.s = jSONObject.optBoolean("fullScreen", ow2Var.s);
                ow2Var2.t = p(jSONObject);
                ow2Var2.u = jSONObject.optString("danmuList", ow2Var.u);
                ow2Var2.v = jSONObject.optBoolean("enableDanmu", ow2Var.v);
                ow2Var2.w = jSONObject.optBoolean("danmuBtn", ow2Var.w);
                ow2Var2.p = jSONObject.optBoolean("loop", ow2Var.p);
                ow2Var2.x = jSONObject.optBoolean("controls", ow2Var.x);
                ow2Var2.y = q(jSONObject.optString("src", ow2Var.y));
                ow2Var2.I = !cf3.E(jSONObject.optString("src", ow2Var.y));
                ow2Var2.A = jSONObject.optBoolean("showPlayBtn", ow2Var.A);
                ow2Var2.B = jSONObject.optBoolean("showMuteBtn", ow2Var.B);
                ow2Var2.C = jSONObject.optBoolean("showCenterPlayBtn", ow2Var.C);
                ow2Var2.D = jSONObject.optBoolean("pageGesture", ow2Var.D);
                ow2Var2.E = jSONObject.optBoolean("showProgress", ow2Var.E);
                ow2Var2.F = jSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, ow2Var.F);
                ow2Var2.G = jSONObject.optBoolean("showFullscreenBtn", ow2Var.G);
                ow2Var2.H = jSONObject.optBoolean("enableProgressGesture", ow2Var.H);
                ow2Var2.z = jSONObject.optString("componentId", ow2Var.z);
                ow2Var2.J = jSONObject.optBoolean("showNoWifiTip", ow2Var.J);
                ow2Var2.K = jSONObject.optString("title", ow2Var.K);
                ow2Var2.L = jSONObject.optBoolean("enablePlayGesture", ow2Var.L);
                ow2Var2.M = jSONObject.optBoolean("vslideGestureInFullscreen", ow2Var.M);
                ow2Var2.N = jSONObject.optBoolean("customEnterExitFullScreen", ow2Var.N);
                ow2Var2.P = jSONObject.optBoolean("showRateBtn", ow2Var.P);
                ow2Var2.Q = jSONObject.optBoolean("isFullscreen", ow2Var.Q);
                ow2Var2.O = jSONObject.optBoolean("isAlwaysOnlyShowTopView", ow2Var.O);
                ow2Var2.R = jSONObject.optBoolean("showVslideBtnInFullscreen", ow2Var.R);
                ow2Var2.S = jSONObject.optBoolean("silentPlay", ow2Var.S);
                ow2Var2.T = jSONObject.optString("preload", ow2Var.T);
                ow2Var2.U = jSONObject.optBoolean("showSilentPlayMutedIcon", ow2Var.U);
                ow2Var2.V = jSONObject.optString("silentPlayTips", ow2Var.V);
                ow2Var2.W = jSONObject.optString("rate", ow2Var.W);
            }
            return ow2Var2;
        }
        return (ow2) invokeLL.objValue;
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
            if (cf3.E(str) && u73.M() != null) {
                return cf3.H(str, u73.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.k32
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", duration=" + this.n + ", mAutoPlay=" + this.o + ", mLoop=" + this.p + ", mObjectFit='" + this.q + "', mPos=" + this.r + ", mFullScreen=" + this.s + ", mDanmu='" + this.t + "', mDanmuList='" + this.u + "', mEnableDanmu=" + this.v + ", mShowDanmuBtn=" + this.w + ", mShowControlPanel=" + this.x + ", mSrc='" + this.y + "', mSanId='" + this.z + "', mShowPlayBtn=" + this.A + ", mShowMuteBtn=" + this.B + ", mShowCenterPlayBtn=" + this.C + ", mPageGesture=" + this.D + ", mShowProgress=" + this.E + ", mDirection=" + this.F + ", mShowFullscreenBtn=" + this.G + ", mEnableProgressGesture=" + this.H + ", mIsRemoteFile=" + this.I + '}';
        }
        return (String) invokeV.objValue;
    }
}
