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
/* loaded from: classes7.dex */
public class q03 extends w62 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public p03 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948037973, "Lcom/baidu/tieba/q03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948037973, "Lcom/baidu/tieba/q03;");
                return;
            }
        }
        boolean z = qr1.a;
    }

    @Override // com.baidu.tieba.w62, com.baidu.tieba.f13
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q03() {
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
        this.B = new p03();
        this.C = true;
    }

    public static q03 h(JSONObject jSONObject, @NonNull q03 q03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, q03Var)) == null) {
            q03 q03Var2 = new q03();
            if (jSONObject != null) {
                q03Var2.e(jSONObject, q03Var);
                q03Var2.j = jSONObject.optString("videoId", q03Var.j);
                q03Var2.n = jSONObject.optBoolean("autoplay", q03Var.n);
                q03Var2.k = jSONObject.optBoolean("muted", q03Var.k);
                q03Var2.m = jSONObject.optString("initialTime", q03Var.m);
                q03Var2.l = jSONObject.optString(NativeConstants.POSTER, q03Var.l);
                q03Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, q03Var.p);
                q03Var2.q = jSONObject.optBoolean("fullScreen", q03Var.q);
                q03Var2.o = jSONObject.optBoolean("loop", q03Var.o);
                q03Var2.r = jSONObject.optBoolean("controls", q03Var.r);
                q03Var2.s = i(jSONObject.optString("src", q03Var.s));
                q03Var2.A = !oi3.E(jSONObject.optString("src", q03Var.s));
                q03Var2.u = jSONObject.optBoolean("showPlayBtn", q03Var.u);
                q03Var2.v = jSONObject.optBoolean("showMuteBtn", q03Var.v);
                q03Var2.w = jSONObject.optBoolean("showCenterPlayBtn", q03Var.w);
                q03Var2.x = jSONObject.optBoolean("showProgress", q03Var.x);
                q03Var2.z = jSONObject.optBoolean("showFullscreenBtn", q03Var.z);
                q03Var2.t = jSONObject.optString("sanId", q03Var.t);
                q03Var2.B = q03Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                q03Var2.C = jSONObject.optBoolean("showNoWifiTip", q03Var.C);
            }
            return q03Var2;
        }
        return (q03) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (oi3.E(str) && gb3.M() != null) {
                return oi3.H(str, gb3.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.w62
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
