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
/* loaded from: classes8.dex */
public class w03 extends s72 {
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
    public String f1174T;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948216719, "Lcom/baidu/tieba/w03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948216719, "Lcom/baidu/tieba/w03;");
                return;
            }
        }
        X = ms1.a;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s72, com.baidu.tieba.b23
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
            return TextUtils.equals("auto", this.f1174T);
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
    public w03() {
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
        this.f1174T = "";
        this.U = true;
        this.V = "";
        this.W = "";
    }

    public static w03 h(JSONObject jSONObject, @NonNull w03 w03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, w03Var)) == null) {
            w03 w03Var2 = new w03();
            if (jSONObject != null) {
                w03Var2.e(jSONObject, w03Var);
                w03Var2.j = jSONObject.optString("componentId", w03Var.j);
                w03Var2.o = jSONObject.optBoolean("autoplay", w03Var.o);
                w03Var2.k = jSONObject.optBoolean("muted", w03Var.k);
                w03Var2.q = jSONObject.optString("objectFit", w03Var.q);
                w03Var2.m = jSONObject.optInt("initialTime", w03Var.m);
                w03Var2.l = jSONObject.optString(NativeConstants.POSTER, w03Var.l);
                w03Var2.r = jSONObject.optInt(CriusAttrConstants.POSITION, w03Var.r);
                w03Var2.s = jSONObject.optBoolean("fullScreen", w03Var.s);
                w03Var2.t = p(jSONObject);
                w03Var2.u = jSONObject.optString("danmuList", w03Var.u);
                w03Var2.v = jSONObject.optBoolean("enableDanmu", w03Var.v);
                w03Var2.w = jSONObject.optBoolean("danmuBtn", w03Var.w);
                w03Var2.p = jSONObject.optBoolean("loop", w03Var.p);
                w03Var2.x = jSONObject.optBoolean("controls", w03Var.x);
                w03Var2.y = q(jSONObject.optString("src", w03Var.y));
                w03Var2.I = !kj3.E(jSONObject.optString("src", w03Var.y));
                w03Var2.A = jSONObject.optBoolean("showPlayBtn", w03Var.A);
                w03Var2.B = jSONObject.optBoolean("showMuteBtn", w03Var.B);
                w03Var2.C = jSONObject.optBoolean("showCenterPlayBtn", w03Var.C);
                w03Var2.D = jSONObject.optBoolean("pageGesture", w03Var.D);
                w03Var2.E = jSONObject.optBoolean("showProgress", w03Var.E);
                w03Var2.F = jSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, w03Var.F);
                w03Var2.G = jSONObject.optBoolean("showFullscreenBtn", w03Var.G);
                w03Var2.H = jSONObject.optBoolean("enableProgressGesture", w03Var.H);
                w03Var2.z = jSONObject.optString("componentId", w03Var.z);
                w03Var2.J = jSONObject.optBoolean("showNoWifiTip", w03Var.J);
                w03Var2.K = jSONObject.optString("title", w03Var.K);
                w03Var2.L = jSONObject.optBoolean("enablePlayGesture", w03Var.L);
                w03Var2.M = jSONObject.optBoolean("vslideGestureInFullscreen", w03Var.M);
                w03Var2.N = jSONObject.optBoolean("customEnterExitFullScreen", w03Var.N);
                w03Var2.P = jSONObject.optBoolean("showRateBtn", w03Var.P);
                w03Var2.Q = jSONObject.optBoolean("isFullscreen", w03Var.Q);
                w03Var2.O = jSONObject.optBoolean("isAlwaysOnlyShowTopView", w03Var.O);
                w03Var2.R = jSONObject.optBoolean("showVslideBtnInFullscreen", w03Var.R);
                w03Var2.S = jSONObject.optBoolean("silentPlay", w03Var.S);
                w03Var2.f1174T = jSONObject.optString("preload", w03Var.f1174T);
                w03Var2.U = jSONObject.optBoolean("showSilentPlayMutedIcon", w03Var.U);
                w03Var2.V = jSONObject.optString("silentPlayTips", w03Var.V);
                w03Var2.W = jSONObject.optString("rate", w03Var.W);
            }
            return w03Var2;
        }
        return (w03) invokeLL.objValue;
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
            if (kj3.E(str) && cc3.M() != null) {
                return kj3.H(str, cc3.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s72
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", duration=" + this.n + ", mAutoPlay=" + this.o + ", mLoop=" + this.p + ", mObjectFit='" + this.q + "', mPos=" + this.r + ", mFullScreen=" + this.s + ", mDanmu='" + this.t + "', mDanmuList='" + this.u + "', mEnableDanmu=" + this.v + ", mShowDanmuBtn=" + this.w + ", mShowControlPanel=" + this.x + ", mSrc='" + this.y + "', mSanId='" + this.z + "', mShowPlayBtn=" + this.A + ", mShowMuteBtn=" + this.B + ", mShowCenterPlayBtn=" + this.C + ", mPageGesture=" + this.D + ", mShowProgress=" + this.E + ", mDirection=" + this.F + ", mShowFullscreenBtn=" + this.G + ", mEnableProgressGesture=" + this.H + ", mIsRemoteFile=" + this.I + '}';
        }
        return (String) invokeV.objValue;
    }
}
