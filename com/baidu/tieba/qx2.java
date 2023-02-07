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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class qx2 extends m42 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948107134, "Lcom/baidu/tieba/qx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948107134, "Lcom/baidu/tieba/qx2;");
                return;
            }
        }
        X = gp1.a;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m42, com.baidu.tieba.vy2
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
    public qx2() {
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

    public static qx2 h(JSONObject jSONObject, @NonNull qx2 qx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, qx2Var)) == null) {
            qx2 qx2Var2 = new qx2();
            if (jSONObject != null) {
                qx2Var2.e(jSONObject, qx2Var);
                qx2Var2.j = jSONObject.optString("componentId", qx2Var.j);
                qx2Var2.o = jSONObject.optBoolean("autoplay", qx2Var.o);
                qx2Var2.k = jSONObject.optBoolean("muted", qx2Var.k);
                qx2Var2.q = jSONObject.optString("objectFit", qx2Var.q);
                qx2Var2.m = jSONObject.optInt("initialTime", qx2Var.m);
                qx2Var2.l = jSONObject.optString(NativeConstants.POSTER, qx2Var.l);
                qx2Var2.r = jSONObject.optInt(CriusAttrConstants.POSITION, qx2Var.r);
                qx2Var2.s = jSONObject.optBoolean("fullScreen", qx2Var.s);
                qx2Var2.t = p(jSONObject);
                qx2Var2.u = jSONObject.optString("danmuList", qx2Var.u);
                qx2Var2.v = jSONObject.optBoolean("enableDanmu", qx2Var.v);
                qx2Var2.w = jSONObject.optBoolean("danmuBtn", qx2Var.w);
                qx2Var2.p = jSONObject.optBoolean("loop", qx2Var.p);
                qx2Var2.x = jSONObject.optBoolean("controls", qx2Var.x);
                qx2Var2.y = q(jSONObject.optString("src", qx2Var.y));
                qx2Var2.I = !eg3.E(jSONObject.optString("src", qx2Var.y));
                qx2Var2.A = jSONObject.optBoolean("showPlayBtn", qx2Var.A);
                qx2Var2.B = jSONObject.optBoolean("showMuteBtn", qx2Var.B);
                qx2Var2.C = jSONObject.optBoolean("showCenterPlayBtn", qx2Var.C);
                qx2Var2.D = jSONObject.optBoolean("pageGesture", qx2Var.D);
                qx2Var2.E = jSONObject.optBoolean("showProgress", qx2Var.E);
                qx2Var2.F = jSONObject.optInt("direction", qx2Var.F);
                qx2Var2.G = jSONObject.optBoolean("showFullscreenBtn", qx2Var.G);
                qx2Var2.H = jSONObject.optBoolean("enableProgressGesture", qx2Var.H);
                qx2Var2.z = jSONObject.optString("componentId", qx2Var.z);
                qx2Var2.J = jSONObject.optBoolean("showNoWifiTip", qx2Var.J);
                qx2Var2.K = jSONObject.optString("title", qx2Var.K);
                qx2Var2.L = jSONObject.optBoolean("enablePlayGesture", qx2Var.L);
                qx2Var2.M = jSONObject.optBoolean("vslideGestureInFullscreen", qx2Var.M);
                qx2Var2.N = jSONObject.optBoolean("customEnterExitFullScreen", qx2Var.N);
                qx2Var2.P = jSONObject.optBoolean("showRateBtn", qx2Var.P);
                qx2Var2.Q = jSONObject.optBoolean("isFullscreen", qx2Var.Q);
                qx2Var2.O = jSONObject.optBoolean("isAlwaysOnlyShowTopView", qx2Var.O);
                qx2Var2.R = jSONObject.optBoolean("showVslideBtnInFullscreen", qx2Var.R);
                qx2Var2.S = jSONObject.optBoolean("silentPlay", qx2Var.S);
                qx2Var2.T = jSONObject.optString("preload", qx2Var.T);
                qx2Var2.U = jSONObject.optBoolean("showSilentPlayMutedIcon", qx2Var.U);
                qx2Var2.V = jSONObject.optString("silentPlayTips", qx2Var.V);
                qx2Var2.W = jSONObject.optString("rate", qx2Var.W);
            }
            return qx2Var2;
        }
        return (qx2) invokeLL.objValue;
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
            if (eg3.E(str) && w83.M() != null) {
                return eg3.H(str, w83.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.m42
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", duration=" + this.n + ", mAutoPlay=" + this.o + ", mLoop=" + this.p + ", mObjectFit='" + this.q + "', mPos=" + this.r + ", mFullScreen=" + this.s + ", mDanmu='" + this.t + "', mDanmuList='" + this.u + "', mEnableDanmu=" + this.v + ", mShowDanmuBtn=" + this.w + ", mShowControlPanel=" + this.x + ", mSrc='" + this.y + "', mSanId='" + this.z + "', mShowPlayBtn=" + this.A + ", mShowMuteBtn=" + this.B + ", mShowCenterPlayBtn=" + this.C + ", mPageGesture=" + this.D + ", mShowProgress=" + this.E + ", mDirection=" + this.F + ", mShowFullscreenBtn=" + this.G + ", mEnableProgressGesture=" + this.H + ", mIsRemoteFile=" + this.I + '}';
        }
        return (String) invokeV.objValue;
    }
}
