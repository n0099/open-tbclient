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
public class qy2 extends w42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public py2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948108095, "Lcom/baidu/tieba/qy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948108095, "Lcom/baidu/tieba/qy2;");
                return;
            }
        }
        boolean z = qp1.a;
    }

    @Override // com.baidu.tieba.w42, com.baidu.tieba.fz2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qy2() {
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
        this.B = new py2();
        this.C = true;
    }

    public static qy2 h(JSONObject jSONObject, @NonNull qy2 qy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, qy2Var)) == null) {
            qy2 qy2Var2 = new qy2();
            if (jSONObject != null) {
                qy2Var2.e(jSONObject, qy2Var);
                qy2Var2.j = jSONObject.optString("videoId", qy2Var.j);
                qy2Var2.n = jSONObject.optBoolean("autoplay", qy2Var.n);
                qy2Var2.k = jSONObject.optBoolean("muted", qy2Var.k);
                qy2Var2.m = jSONObject.optString("initialTime", qy2Var.m);
                qy2Var2.l = jSONObject.optString(NativeConstants.POSTER, qy2Var.l);
                qy2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, qy2Var.p);
                qy2Var2.q = jSONObject.optBoolean("fullScreen", qy2Var.q);
                qy2Var2.o = jSONObject.optBoolean("loop", qy2Var.o);
                qy2Var2.r = jSONObject.optBoolean("controls", qy2Var.r);
                qy2Var2.s = i(jSONObject.optString("src", qy2Var.s));
                qy2Var2.A = !og3.E(jSONObject.optString("src", qy2Var.s));
                qy2Var2.u = jSONObject.optBoolean("showPlayBtn", qy2Var.u);
                qy2Var2.v = jSONObject.optBoolean("showMuteBtn", qy2Var.v);
                qy2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", qy2Var.w);
                qy2Var2.x = jSONObject.optBoolean("showProgress", qy2Var.x);
                qy2Var2.z = jSONObject.optBoolean("showFullscreenBtn", qy2Var.z);
                qy2Var2.t = jSONObject.optString("sanId", qy2Var.t);
                qy2Var2.B = qy2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                qy2Var2.C = jSONObject.optBoolean("showNoWifiTip", qy2Var.C);
            }
            return qy2Var2;
        }
        return (qy2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (og3.E(str) && g93.M() != null) {
                return og3.H(str, g93.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.w42
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
