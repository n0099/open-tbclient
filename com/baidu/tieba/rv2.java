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
/* loaded from: classes8.dex */
public class rv2 extends y12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public qv2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948135003, "Lcom/baidu/tieba/rv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948135003, "Lcom/baidu/tieba/rv2;");
                return;
            }
        }
        boolean z = sm1.a;
    }

    @Override // com.baidu.tieba.y12, com.baidu.tieba.gw2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rv2() {
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
        this.B = new qv2();
        this.C = true;
    }

    public static rv2 h(JSONObject jSONObject, @NonNull rv2 rv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, rv2Var)) == null) {
            rv2 rv2Var2 = new rv2();
            if (jSONObject != null) {
                rv2Var2.e(jSONObject, rv2Var);
                rv2Var2.j = jSONObject.optString("videoId", rv2Var.j);
                rv2Var2.n = jSONObject.optBoolean("autoplay", rv2Var.n);
                rv2Var2.k = jSONObject.optBoolean("muted", rv2Var.k);
                rv2Var2.m = jSONObject.optString("initialTime", rv2Var.m);
                rv2Var2.l = jSONObject.optString(NativeConstants.POSTER, rv2Var.l);
                rv2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, rv2Var.p);
                rv2Var2.q = jSONObject.optBoolean("fullScreen", rv2Var.q);
                rv2Var2.o = jSONObject.optBoolean("loop", rv2Var.o);
                rv2Var2.r = jSONObject.optBoolean("controls", rv2Var.r);
                rv2Var2.s = i(jSONObject.optString("src", rv2Var.s));
                rv2Var2.A = !pd3.E(jSONObject.optString("src", rv2Var.s));
                rv2Var2.u = jSONObject.optBoolean("showPlayBtn", rv2Var.u);
                rv2Var2.v = jSONObject.optBoolean("showMuteBtn", rv2Var.v);
                rv2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", rv2Var.w);
                rv2Var2.x = jSONObject.optBoolean("showProgress", rv2Var.x);
                rv2Var2.z = jSONObject.optBoolean("showFullscreenBtn", rv2Var.z);
                rv2Var2.t = jSONObject.optString("sanId", rv2Var.t);
                rv2Var2.B = rv2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                rv2Var2.C = jSONObject.optBoolean("showNoWifiTip", rv2Var.C);
            }
            return rv2Var2;
        }
        return (rv2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (pd3.E(str) && h63.M() != null) {
                return pd3.H(str, h63.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y12
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
