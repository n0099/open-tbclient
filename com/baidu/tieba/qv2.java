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
public class qv2 extends x12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public pv2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948105212, "Lcom/baidu/tieba/qv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948105212, "Lcom/baidu/tieba/qv2;");
                return;
            }
        }
        boolean z = rm1.a;
    }

    @Override // com.baidu.tieba.x12, com.baidu.tieba.fw2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qv2() {
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
        this.B = new pv2();
        this.C = true;
    }

    public static qv2 h(JSONObject jSONObject, @NonNull qv2 qv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, qv2Var)) == null) {
            qv2 qv2Var2 = new qv2();
            if (jSONObject != null) {
                qv2Var2.e(jSONObject, qv2Var);
                qv2Var2.j = jSONObject.optString("videoId", qv2Var.j);
                qv2Var2.n = jSONObject.optBoolean("autoplay", qv2Var.n);
                qv2Var2.k = jSONObject.optBoolean("muted", qv2Var.k);
                qv2Var2.m = jSONObject.optString("initialTime", qv2Var.m);
                qv2Var2.l = jSONObject.optString(NativeConstants.POSTER, qv2Var.l);
                qv2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, qv2Var.p);
                qv2Var2.q = jSONObject.optBoolean("fullScreen", qv2Var.q);
                qv2Var2.o = jSONObject.optBoolean("loop", qv2Var.o);
                qv2Var2.r = jSONObject.optBoolean("controls", qv2Var.r);
                qv2Var2.s = i(jSONObject.optString("src", qv2Var.s));
                qv2Var2.A = !od3.E(jSONObject.optString("src", qv2Var.s));
                qv2Var2.u = jSONObject.optBoolean("showPlayBtn", qv2Var.u);
                qv2Var2.v = jSONObject.optBoolean("showMuteBtn", qv2Var.v);
                qv2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", qv2Var.w);
                qv2Var2.x = jSONObject.optBoolean("showProgress", qv2Var.x);
                qv2Var2.z = jSONObject.optBoolean("showFullscreenBtn", qv2Var.z);
                qv2Var2.t = jSONObject.optString("sanId", qv2Var.t);
                qv2Var2.B = qv2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                qv2Var2.C = jSONObject.optBoolean("showNoWifiTip", qv2Var.C);
            }
            return qv2Var2;
        }
        return (qv2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (od3.E(str) && g63.M() != null) {
                return od3.H(str, g63.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x12
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
