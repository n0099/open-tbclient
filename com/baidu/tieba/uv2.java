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
public class uv2 extends b22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public tv2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948224376, "Lcom/baidu/tieba/uv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948224376, "Lcom/baidu/tieba/uv2;");
                return;
            }
        }
        boolean z = vm1.a;
    }

    @Override // com.baidu.tieba.b22, com.baidu.tieba.jw2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uv2() {
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
        this.B = new tv2();
        this.C = true;
    }

    public static uv2 h(JSONObject jSONObject, @NonNull uv2 uv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, uv2Var)) == null) {
            uv2 uv2Var2 = new uv2();
            if (jSONObject != null) {
                uv2Var2.e(jSONObject, uv2Var);
                uv2Var2.j = jSONObject.optString("videoId", uv2Var.j);
                uv2Var2.n = jSONObject.optBoolean("autoplay", uv2Var.n);
                uv2Var2.k = jSONObject.optBoolean("muted", uv2Var.k);
                uv2Var2.m = jSONObject.optString("initialTime", uv2Var.m);
                uv2Var2.l = jSONObject.optString(NativeConstants.POSTER, uv2Var.l);
                uv2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, uv2Var.p);
                uv2Var2.q = jSONObject.optBoolean("fullScreen", uv2Var.q);
                uv2Var2.o = jSONObject.optBoolean("loop", uv2Var.o);
                uv2Var2.r = jSONObject.optBoolean("controls", uv2Var.r);
                uv2Var2.s = i(jSONObject.optString("src", uv2Var.s));
                uv2Var2.A = !sd3.E(jSONObject.optString("src", uv2Var.s));
                uv2Var2.u = jSONObject.optBoolean("showPlayBtn", uv2Var.u);
                uv2Var2.v = jSONObject.optBoolean("showMuteBtn", uv2Var.v);
                uv2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", uv2Var.w);
                uv2Var2.x = jSONObject.optBoolean("showProgress", uv2Var.x);
                uv2Var2.z = jSONObject.optBoolean("showFullscreenBtn", uv2Var.z);
                uv2Var2.t = jSONObject.optString("sanId", uv2Var.t);
                uv2Var2.B = uv2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                uv2Var2.C = jSONObject.optBoolean("showNoWifiTip", uv2Var.C);
            }
            return uv2Var2;
        }
        return (uv2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (sd3.E(str) && k63.M() != null) {
                return sd3.H(str, k63.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.b22
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
