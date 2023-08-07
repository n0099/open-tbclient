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
public class sz2 extends o62 {
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
    public String f1166T;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948168638, "Lcom/baidu/tieba/sz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948168638, "Lcom/baidu/tieba/sz2;");
                return;
            }
        }
        X = ir1.a;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.o62, com.baidu.tieba.x03
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
            return TextUtils.equals("auto", this.f1166T);
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
    public sz2() {
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
        this.f1166T = "";
        this.U = true;
        this.V = "";
        this.W = "";
    }

    public static sz2 h(JSONObject jSONObject, @NonNull sz2 sz2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, sz2Var)) == null) {
            sz2 sz2Var2 = new sz2();
            if (jSONObject != null) {
                sz2Var2.e(jSONObject, sz2Var);
                sz2Var2.j = jSONObject.optString("componentId", sz2Var.j);
                sz2Var2.o = jSONObject.optBoolean("autoplay", sz2Var.o);
                sz2Var2.k = jSONObject.optBoolean("muted", sz2Var.k);
                sz2Var2.q = jSONObject.optString("objectFit", sz2Var.q);
                sz2Var2.m = jSONObject.optInt("initialTime", sz2Var.m);
                sz2Var2.l = jSONObject.optString(NativeConstants.POSTER, sz2Var.l);
                sz2Var2.r = jSONObject.optInt(CriusAttrConstants.POSITION, sz2Var.r);
                sz2Var2.s = jSONObject.optBoolean("fullScreen", sz2Var.s);
                sz2Var2.t = p(jSONObject);
                sz2Var2.u = jSONObject.optString("danmuList", sz2Var.u);
                sz2Var2.v = jSONObject.optBoolean("enableDanmu", sz2Var.v);
                sz2Var2.w = jSONObject.optBoolean("danmuBtn", sz2Var.w);
                sz2Var2.p = jSONObject.optBoolean("loop", sz2Var.p);
                sz2Var2.x = jSONObject.optBoolean("controls", sz2Var.x);
                sz2Var2.y = q(jSONObject.optString("src", sz2Var.y));
                sz2Var2.I = !gi3.E(jSONObject.optString("src", sz2Var.y));
                sz2Var2.A = jSONObject.optBoolean("showPlayBtn", sz2Var.A);
                sz2Var2.B = jSONObject.optBoolean("showMuteBtn", sz2Var.B);
                sz2Var2.C = jSONObject.optBoolean("showCenterPlayBtn", sz2Var.C);
                sz2Var2.D = jSONObject.optBoolean("pageGesture", sz2Var.D);
                sz2Var2.E = jSONObject.optBoolean("showProgress", sz2Var.E);
                sz2Var2.F = jSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, sz2Var.F);
                sz2Var2.G = jSONObject.optBoolean("showFullscreenBtn", sz2Var.G);
                sz2Var2.H = jSONObject.optBoolean("enableProgressGesture", sz2Var.H);
                sz2Var2.z = jSONObject.optString("componentId", sz2Var.z);
                sz2Var2.J = jSONObject.optBoolean("showNoWifiTip", sz2Var.J);
                sz2Var2.K = jSONObject.optString("title", sz2Var.K);
                sz2Var2.L = jSONObject.optBoolean("enablePlayGesture", sz2Var.L);
                sz2Var2.M = jSONObject.optBoolean("vslideGestureInFullscreen", sz2Var.M);
                sz2Var2.N = jSONObject.optBoolean("customEnterExitFullScreen", sz2Var.N);
                sz2Var2.P = jSONObject.optBoolean("showRateBtn", sz2Var.P);
                sz2Var2.Q = jSONObject.optBoolean("isFullscreen", sz2Var.Q);
                sz2Var2.O = jSONObject.optBoolean("isAlwaysOnlyShowTopView", sz2Var.O);
                sz2Var2.R = jSONObject.optBoolean("showVslideBtnInFullscreen", sz2Var.R);
                sz2Var2.S = jSONObject.optBoolean("silentPlay", sz2Var.S);
                sz2Var2.f1166T = jSONObject.optString("preload", sz2Var.f1166T);
                sz2Var2.U = jSONObject.optBoolean("showSilentPlayMutedIcon", sz2Var.U);
                sz2Var2.V = jSONObject.optString("silentPlayTips", sz2Var.V);
                sz2Var2.W = jSONObject.optString("rate", sz2Var.W);
            }
            return sz2Var2;
        }
        return (sz2) invokeLL.objValue;
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
            if (gi3.E(str) && ya3.M() != null) {
                return gi3.H(str, ya3.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.o62
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", duration=" + this.n + ", mAutoPlay=" + this.o + ", mLoop=" + this.p + ", mObjectFit='" + this.q + "', mPos=" + this.r + ", mFullScreen=" + this.s + ", mDanmu='" + this.t + "', mDanmuList='" + this.u + "', mEnableDanmu=" + this.v + ", mShowDanmuBtn=" + this.w + ", mShowControlPanel=" + this.x + ", mSrc='" + this.y + "', mSanId='" + this.z + "', mShowPlayBtn=" + this.A + ", mShowMuteBtn=" + this.B + ", mShowCenterPlayBtn=" + this.C + ", mPageGesture=" + this.D + ", mShowProgress=" + this.E + ", mDirection=" + this.F + ", mShowFullscreenBtn=" + this.G + ", mEnableProgressGesture=" + this.H + ", mIsRemoteFile=" + this.I + '}';
        }
        return (String) invokeV.objValue;
    }
}
