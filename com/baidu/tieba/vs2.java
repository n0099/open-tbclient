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
/* loaded from: classes6.dex */
public class vs2 extends bz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public us2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948251284, "Lcom/baidu/tieba/vs2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948251284, "Lcom/baidu/tieba/vs2;");
                return;
            }
        }
        boolean z = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vs2() {
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
        this.B = new us2();
        this.C = true;
    }

    public static vs2 h(JSONObject jSONObject, @NonNull vs2 vs2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, vs2Var)) == null) {
            vs2 vs2Var2 = new vs2();
            if (jSONObject != null) {
                vs2Var2.e(jSONObject, vs2Var);
                vs2Var2.j = jSONObject.optString("videoId", vs2Var.j);
                vs2Var2.n = jSONObject.optBoolean("autoplay", vs2Var.n);
                vs2Var2.k = jSONObject.optBoolean("muted", vs2Var.k);
                vs2Var2.m = jSONObject.optString("initialTime", vs2Var.m);
                vs2Var2.l = jSONObject.optString(NativeConstants.POSTER, vs2Var.l);
                vs2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, vs2Var.p);
                vs2Var2.q = jSONObject.optBoolean("fullScreen", vs2Var.q);
                vs2Var2.o = jSONObject.optBoolean("loop", vs2Var.o);
                vs2Var2.r = jSONObject.optBoolean("controls", vs2Var.r);
                vs2Var2.s = i(jSONObject.optString("src", vs2Var.s));
                vs2Var2.A = !ta3.E(jSONObject.optString("src", vs2Var.s));
                vs2Var2.u = jSONObject.optBoolean("showPlayBtn", vs2Var.u);
                vs2Var2.v = jSONObject.optBoolean("showMuteBtn", vs2Var.v);
                vs2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", vs2Var.w);
                vs2Var2.x = jSONObject.optBoolean("showProgress", vs2Var.x);
                vs2Var2.z = jSONObject.optBoolean("showFullscreenBtn", vs2Var.z);
                vs2Var2.t = jSONObject.optString("sanId", vs2Var.t);
                vs2Var2.B = vs2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                vs2Var2.C = jSONObject.optBoolean("showNoWifiTip", vs2Var.C);
            }
            return vs2Var2;
        }
        return (vs2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (!ta3.E(str) || l33.M() == null) ? str : ta3.H(str, l33.M()) : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bz1, com.baidu.tieba.kt2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.j) : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bz1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
