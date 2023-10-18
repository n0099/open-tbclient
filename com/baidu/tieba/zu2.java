package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
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
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zu2 extends g12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public yu2 B;
    public boolean C;
    public String j;
    public boolean k;
    public String l;
    public String m;
    public boolean n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public String s;
    public String t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public int y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948372370, "Lcom/baidu/tieba/zu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948372370, "Lcom/baidu/tieba/zu2;");
                return;
            }
        }
        boolean z = am1.a;
    }

    @Override // com.baidu.tieba.g12, com.baidu.tieba.ov2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zu2() {
        super("vrvideo", "viewId");
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
        this.m = "0";
        this.n = false;
        this.o = false;
        this.p = 0;
        this.r = true;
        this.s = "";
        this.t = "";
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = -1;
        this.z = true;
        this.A = true;
        this.B = new yu2();
        this.C = true;
    }

    public static zu2 h(JSONObject jSONObject, @NonNull zu2 zu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, zu2Var)) == null) {
            zu2 zu2Var2 = new zu2();
            if (jSONObject != null) {
                zu2Var2.e(jSONObject, zu2Var);
                zu2Var2.j = jSONObject.optString("videoId", zu2Var.j);
                zu2Var2.n = jSONObject.optBoolean("autoplay", zu2Var.n);
                zu2Var2.k = jSONObject.optBoolean("muted", zu2Var.k);
                zu2Var2.m = jSONObject.optString("initialTime", zu2Var.m);
                zu2Var2.l = jSONObject.optString(NativeConstants.POSTER, zu2Var.l);
                zu2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, zu2Var.p);
                zu2Var2.q = jSONObject.optBoolean("fullScreen", zu2Var.q);
                zu2Var2.o = jSONObject.optBoolean("loop", zu2Var.o);
                zu2Var2.r = jSONObject.optBoolean("controls", zu2Var.r);
                zu2Var2.s = i(jSONObject.optString("src", zu2Var.s));
                zu2Var2.A = !xc3.E(jSONObject.optString("src", zu2Var.s));
                zu2Var2.u = jSONObject.optBoolean("showPlayBtn", zu2Var.u);
                zu2Var2.v = jSONObject.optBoolean("showMuteBtn", zu2Var.v);
                zu2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", zu2Var.w);
                zu2Var2.x = jSONObject.optBoolean("showProgress", zu2Var.x);
                zu2Var2.z = jSONObject.optBoolean("showFullscreenBtn", zu2Var.z);
                zu2Var2.t = jSONObject.optString("sanId", zu2Var.t);
                zu2Var2.B = zu2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                zu2Var2.C = jSONObject.optBoolean("showNoWifiTip", zu2Var.C);
            }
            return zu2Var2;
        }
        return (zu2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
