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
/* loaded from: classes6.dex */
public class ju2 extends g12 {
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
    public String f1130T;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947895714, "Lcom/baidu/tieba/ju2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947895714, "Lcom/baidu/tieba/ju2;");
                return;
            }
        }
        X = am1.a;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.g12, com.baidu.tieba.ov2
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
            return TextUtils.equals("auto", this.f1130T);
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
    public ju2() {
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
        this.f1130T = "";
        this.U = true;
        this.V = "";
        this.W = "";
    }

    public static ju2 h(JSONObject jSONObject, @NonNull ju2 ju2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, ju2Var)) == null) {
            ju2 ju2Var2 = new ju2();
            if (jSONObject != null) {
                ju2Var2.e(jSONObject, ju2Var);
                ju2Var2.j = jSONObject.optString("componentId", ju2Var.j);
                ju2Var2.o = jSONObject.optBoolean("autoplay", ju2Var.o);
                ju2Var2.k = jSONObject.optBoolean("muted", ju2Var.k);
                ju2Var2.q = jSONObject.optString("objectFit", ju2Var.q);
                ju2Var2.m = jSONObject.optInt("initialTime", ju2Var.m);
                ju2Var2.l = jSONObject.optString(NativeConstants.POSTER, ju2Var.l);
                ju2Var2.r = jSONObject.optInt(CriusAttrConstants.POSITION, ju2Var.r);
                ju2Var2.s = jSONObject.optBoolean("fullScreen", ju2Var.s);
                ju2Var2.t = p(jSONObject);
                ju2Var2.u = jSONObject.optString("danmuList", ju2Var.u);
                ju2Var2.v = jSONObject.optBoolean("enableDanmu", ju2Var.v);
                ju2Var2.w = jSONObject.optBoolean("danmuBtn", ju2Var.w);
                ju2Var2.p = jSONObject.optBoolean("loop", ju2Var.p);
                ju2Var2.x = jSONObject.optBoolean("controls", ju2Var.x);
                ju2Var2.y = q(jSONObject.optString("src", ju2Var.y));
                ju2Var2.I = !xc3.E(jSONObject.optString("src", ju2Var.y));
                ju2Var2.A = jSONObject.optBoolean("showPlayBtn", ju2Var.A);
                ju2Var2.B = jSONObject.optBoolean("showMuteBtn", ju2Var.B);
                ju2Var2.C = jSONObject.optBoolean("showCenterPlayBtn", ju2Var.C);
                ju2Var2.D = jSONObject.optBoolean("pageGesture", ju2Var.D);
                ju2Var2.E = jSONObject.optBoolean("showProgress", ju2Var.E);
                ju2Var2.F = jSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, ju2Var.F);
                ju2Var2.G = jSONObject.optBoolean("showFullscreenBtn", ju2Var.G);
                ju2Var2.H = jSONObject.optBoolean("enableProgressGesture", ju2Var.H);
                ju2Var2.z = jSONObject.optString("componentId", ju2Var.z);
                ju2Var2.J = jSONObject.optBoolean("showNoWifiTip", ju2Var.J);
                ju2Var2.K = jSONObject.optString("title", ju2Var.K);
                ju2Var2.L = jSONObject.optBoolean("enablePlayGesture", ju2Var.L);
                ju2Var2.M = jSONObject.optBoolean("vslideGestureInFullscreen", ju2Var.M);
                ju2Var2.N = jSONObject.optBoolean("customEnterExitFullScreen", ju2Var.N);
                ju2Var2.P = jSONObject.optBoolean("showRateBtn", ju2Var.P);
                ju2Var2.Q = jSONObject.optBoolean("isFullscreen", ju2Var.Q);
                ju2Var2.O = jSONObject.optBoolean("isAlwaysOnlyShowTopView", ju2Var.O);
                ju2Var2.R = jSONObject.optBoolean("showVslideBtnInFullscreen", ju2Var.R);
                ju2Var2.S = jSONObject.optBoolean("silentPlay", ju2Var.S);
                ju2Var2.f1130T = jSONObject.optString("preload", ju2Var.f1130T);
                ju2Var2.U = jSONObject.optBoolean("showSilentPlayMutedIcon", ju2Var.U);
                ju2Var2.V = jSONObject.optString("silentPlayTips", ju2Var.V);
                ju2Var2.W = jSONObject.optString("rate", ju2Var.W);
            }
            return ju2Var2;
        }
        return (ju2) invokeLL.objValue;
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
            if (xc3.E(str) && p53.M() != null) {
                return xc3.H(str, p53.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g12
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", duration=" + this.n + ", mAutoPlay=" + this.o + ", mLoop=" + this.p + ", mObjectFit='" + this.q + "', mPos=" + this.r + ", mFullScreen=" + this.s + ", mDanmu='" + this.t + "', mDanmuList='" + this.u + "', mEnableDanmu=" + this.v + ", mShowDanmuBtn=" + this.w + ", mShowControlPanel=" + this.x + ", mSrc='" + this.y + "', mSanId='" + this.z + "', mShowPlayBtn=" + this.A + ", mShowMuteBtn=" + this.B + ", mShowCenterPlayBtn=" + this.C + ", mPageGesture=" + this.D + ", mShowProgress=" + this.E + ", mDirection=" + this.F + ", mShowFullscreenBtn=" + this.G + ", mEnableProgressGesture=" + this.H + ", mIsRemoteFile=" + this.I + '}';
        }
        return (String) invokeV.objValue;
    }
}
