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
public class wy2 extends c52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public vy2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948286841, "Lcom/baidu/tieba/wy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948286841, "Lcom/baidu/tieba/wy2;");
                return;
            }
        }
        boolean z = wp1.a;
    }

    @Override // com.baidu.tieba.c52, com.baidu.tieba.lz2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wy2() {
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
        this.B = new vy2();
        this.C = true;
    }

    public static wy2 h(JSONObject jSONObject, @NonNull wy2 wy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, wy2Var)) == null) {
            wy2 wy2Var2 = new wy2();
            if (jSONObject != null) {
                wy2Var2.e(jSONObject, wy2Var);
                wy2Var2.j = jSONObject.optString("videoId", wy2Var.j);
                wy2Var2.n = jSONObject.optBoolean("autoplay", wy2Var.n);
                wy2Var2.k = jSONObject.optBoolean("muted", wy2Var.k);
                wy2Var2.m = jSONObject.optString("initialTime", wy2Var.m);
                wy2Var2.l = jSONObject.optString(NativeConstants.POSTER, wy2Var.l);
                wy2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, wy2Var.p);
                wy2Var2.q = jSONObject.optBoolean("fullScreen", wy2Var.q);
                wy2Var2.o = jSONObject.optBoolean("loop", wy2Var.o);
                wy2Var2.r = jSONObject.optBoolean("controls", wy2Var.r);
                wy2Var2.s = i(jSONObject.optString("src", wy2Var.s));
                wy2Var2.A = !ug3.E(jSONObject.optString("src", wy2Var.s));
                wy2Var2.u = jSONObject.optBoolean("showPlayBtn", wy2Var.u);
                wy2Var2.v = jSONObject.optBoolean("showMuteBtn", wy2Var.v);
                wy2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", wy2Var.w);
                wy2Var2.x = jSONObject.optBoolean("showProgress", wy2Var.x);
                wy2Var2.z = jSONObject.optBoolean("showFullscreenBtn", wy2Var.z);
                wy2Var2.t = jSONObject.optString("sanId", wy2Var.t);
                wy2Var2.B = wy2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                wy2Var2.C = jSONObject.optBoolean("showNoWifiTip", wy2Var.C);
            }
            return wy2Var2;
        }
        return (wy2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (ug3.E(str) && m93.M() != null) {
                return ug3.H(str, m93.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.c52
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
