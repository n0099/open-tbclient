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
public class tt2 extends zz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public st2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948192663, "Lcom/baidu/tieba/tt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948192663, "Lcom/baidu/tieba/tt2;");
                return;
            }
        }
        boolean z = tk1.a;
    }

    @Override // com.baidu.tieba.zz1, com.baidu.tieba.iu2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tt2() {
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
        this.B = new st2();
        this.C = true;
    }

    public static tt2 h(JSONObject jSONObject, @NonNull tt2 tt2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, tt2Var)) == null) {
            tt2 tt2Var2 = new tt2();
            if (jSONObject != null) {
                tt2Var2.e(jSONObject, tt2Var);
                tt2Var2.j = jSONObject.optString("videoId", tt2Var.j);
                tt2Var2.n = jSONObject.optBoolean("autoplay", tt2Var.n);
                tt2Var2.k = jSONObject.optBoolean("muted", tt2Var.k);
                tt2Var2.m = jSONObject.optString("initialTime", tt2Var.m);
                tt2Var2.l = jSONObject.optString(NativeConstants.POSTER, tt2Var.l);
                tt2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, tt2Var.p);
                tt2Var2.q = jSONObject.optBoolean("fullScreen", tt2Var.q);
                tt2Var2.o = jSONObject.optBoolean("loop", tt2Var.o);
                tt2Var2.r = jSONObject.optBoolean("controls", tt2Var.r);
                tt2Var2.s = i(jSONObject.optString("src", tt2Var.s));
                tt2Var2.A = !rb3.E(jSONObject.optString("src", tt2Var.s));
                tt2Var2.u = jSONObject.optBoolean("showPlayBtn", tt2Var.u);
                tt2Var2.v = jSONObject.optBoolean("showMuteBtn", tt2Var.v);
                tt2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", tt2Var.w);
                tt2Var2.x = jSONObject.optBoolean("showProgress", tt2Var.x);
                tt2Var2.z = jSONObject.optBoolean("showFullscreenBtn", tt2Var.z);
                tt2Var2.t = jSONObject.optString("sanId", tt2Var.t);
                tt2Var2.B = tt2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                tt2Var2.C = jSONObject.optBoolean("showNoWifiTip", tt2Var.C);
            }
            return tt2Var2;
        }
        return (tt2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (rb3.E(str) && j43.M() != null) {
                return rb3.H(str, j43.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zz1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
