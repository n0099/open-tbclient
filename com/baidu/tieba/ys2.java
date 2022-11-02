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
public class ys2 extends uz1 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948340657, "Lcom/baidu/tieba/ys2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948340657, "Lcom/baidu/tieba/ys2;");
                return;
            }
        }
        X = ok1.a;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.uz1, com.baidu.tieba.du2
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
    public ys2() {
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

    public static ys2 h(JSONObject jSONObject, @NonNull ys2 ys2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, ys2Var)) == null) {
            ys2 ys2Var2 = new ys2();
            if (jSONObject != null) {
                ys2Var2.e(jSONObject, ys2Var);
                ys2Var2.j = jSONObject.optString("componentId", ys2Var.j);
                ys2Var2.o = jSONObject.optBoolean("autoplay", ys2Var.o);
                ys2Var2.k = jSONObject.optBoolean("muted", ys2Var.k);
                ys2Var2.q = jSONObject.optString("objectFit", ys2Var.q);
                ys2Var2.m = jSONObject.optInt("initialTime", ys2Var.m);
                ys2Var2.l = jSONObject.optString(NativeConstants.POSTER, ys2Var.l);
                ys2Var2.r = jSONObject.optInt(CriusAttrConstants.POSITION, ys2Var.r);
                ys2Var2.s = jSONObject.optBoolean("fullScreen", ys2Var.s);
                ys2Var2.t = p(jSONObject);
                ys2Var2.u = jSONObject.optString("danmuList", ys2Var.u);
                ys2Var2.v = jSONObject.optBoolean("enableDanmu", ys2Var.v);
                ys2Var2.w = jSONObject.optBoolean("danmuBtn", ys2Var.w);
                ys2Var2.p = jSONObject.optBoolean("loop", ys2Var.p);
                ys2Var2.x = jSONObject.optBoolean("controls", ys2Var.x);
                ys2Var2.y = q(jSONObject.optString("src", ys2Var.y));
                ys2Var2.I = !mb3.E(jSONObject.optString("src", ys2Var.y));
                ys2Var2.A = jSONObject.optBoolean("showPlayBtn", ys2Var.A);
                ys2Var2.B = jSONObject.optBoolean("showMuteBtn", ys2Var.B);
                ys2Var2.C = jSONObject.optBoolean("showCenterPlayBtn", ys2Var.C);
                ys2Var2.D = jSONObject.optBoolean("pageGesture", ys2Var.D);
                ys2Var2.E = jSONObject.optBoolean("showProgress", ys2Var.E);
                ys2Var2.F = jSONObject.optInt("direction", ys2Var.F);
                ys2Var2.G = jSONObject.optBoolean("showFullscreenBtn", ys2Var.G);
                ys2Var2.H = jSONObject.optBoolean("enableProgressGesture", ys2Var.H);
                ys2Var2.z = jSONObject.optString("componentId", ys2Var.z);
                ys2Var2.J = jSONObject.optBoolean("showNoWifiTip", ys2Var.J);
                ys2Var2.K = jSONObject.optString("title", ys2Var.K);
                ys2Var2.L = jSONObject.optBoolean("enablePlayGesture", ys2Var.L);
                ys2Var2.M = jSONObject.optBoolean("vslideGestureInFullscreen", ys2Var.M);
                ys2Var2.N = jSONObject.optBoolean("customEnterExitFullScreen", ys2Var.N);
                ys2Var2.P = jSONObject.optBoolean("showRateBtn", ys2Var.P);
                ys2Var2.Q = jSONObject.optBoolean("isFullscreen", ys2Var.Q);
                ys2Var2.O = jSONObject.optBoolean("isAlwaysOnlyShowTopView", ys2Var.O);
                ys2Var2.R = jSONObject.optBoolean("showVslideBtnInFullscreen", ys2Var.R);
                ys2Var2.S = jSONObject.optBoolean("silentPlay", ys2Var.S);
                ys2Var2.T = jSONObject.optString("preload", ys2Var.T);
                ys2Var2.U = jSONObject.optBoolean("showSilentPlayMutedIcon", ys2Var.U);
                ys2Var2.V = jSONObject.optString("silentPlayTips", ys2Var.V);
                ys2Var2.W = jSONObject.optString("rate", ys2Var.W);
            }
            return ys2Var2;
        }
        return (ys2) invokeLL.objValue;
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
            if (mb3.E(str) && e43.M() != null) {
                return mb3.H(str, e43.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.uz1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", duration=" + this.n + ", mAutoPlay=" + this.o + ", mLoop=" + this.p + ", mObjectFit='" + this.q + "', mPos=" + this.r + ", mFullScreen=" + this.s + ", mDanmu='" + this.t + "', mDanmuList='" + this.u + "', mEnableDanmu=" + this.v + ", mShowDanmuBtn=" + this.w + ", mShowControlPanel=" + this.x + ", mSrc='" + this.y + "', mSanId='" + this.z + "', mShowPlayBtn=" + this.A + ", mShowMuteBtn=" + this.B + ", mShowCenterPlayBtn=" + this.C + ", mPageGesture=" + this.D + ", mShowProgress=" + this.E + ", mDirection=" + this.F + ", mShowFullscreenBtn=" + this.G + ", mEnableProgressGesture=" + this.H + ", mIsRemoteFile=" + this.I + '}';
        }
        return (String) invokeV.objValue;
    }
}
