package com.baidu.tieba;

import android.text.TextUtils;
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
public class ws2 extends cz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public vs2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948281075, "Lcom/baidu/tieba/ws2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948281075, "Lcom/baidu/tieba/ws2;");
                return;
            }
        }
        boolean z = wj1.a;
    }

    @Override // com.baidu.tieba.cz1, com.baidu.tieba.lt2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ws2() {
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
        this.B = new vs2();
        this.C = true;
    }

    public static ws2 h(JSONObject jSONObject, ws2 ws2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, ws2Var)) == null) {
            ws2 ws2Var2 = new ws2();
            if (jSONObject != null) {
                ws2Var2.e(jSONObject, ws2Var);
                ws2Var2.j = jSONObject.optString("videoId", ws2Var.j);
                ws2Var2.n = jSONObject.optBoolean("autoplay", ws2Var.n);
                ws2Var2.k = jSONObject.optBoolean("muted", ws2Var.k);
                ws2Var2.m = jSONObject.optString("initialTime", ws2Var.m);
                ws2Var2.l = jSONObject.optString(NativeConstants.POSTER, ws2Var.l);
                ws2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, ws2Var.p);
                ws2Var2.q = jSONObject.optBoolean("fullScreen", ws2Var.q);
                ws2Var2.o = jSONObject.optBoolean("loop", ws2Var.o);
                ws2Var2.r = jSONObject.optBoolean("controls", ws2Var.r);
                ws2Var2.s = i(jSONObject.optString("src", ws2Var.s));
                ws2Var2.A = !ua3.E(jSONObject.optString("src", ws2Var.s));
                ws2Var2.u = jSONObject.optBoolean("showPlayBtn", ws2Var.u);
                ws2Var2.v = jSONObject.optBoolean("showMuteBtn", ws2Var.v);
                ws2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", ws2Var.w);
                ws2Var2.x = jSONObject.optBoolean("showProgress", ws2Var.x);
                ws2Var2.z = jSONObject.optBoolean("showFullscreenBtn", ws2Var.z);
                ws2Var2.t = jSONObject.optString("sanId", ws2Var.t);
                ws2Var2.B = ws2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                ws2Var2.C = jSONObject.optBoolean("showNoWifiTip", ws2Var.C);
            }
            return ws2Var2;
        }
        return (ws2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (ua3.E(str) && m33.M() != null) {
                return ua3.H(str, m33.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.cz1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
