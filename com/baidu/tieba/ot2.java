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
/* loaded from: classes5.dex */
public class ot2 extends uz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public nt2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948043708, "Lcom/baidu/tieba/ot2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948043708, "Lcom/baidu/tieba/ot2;");
                return;
            }
        }
        boolean z = ok1.a;
    }

    @Override // com.baidu.tieba.uz1, com.baidu.tieba.du2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ot2() {
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
        this.B = new nt2();
        this.C = true;
    }

    public static ot2 h(JSONObject jSONObject, @NonNull ot2 ot2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, ot2Var)) == null) {
            ot2 ot2Var2 = new ot2();
            if (jSONObject != null) {
                ot2Var2.e(jSONObject, ot2Var);
                ot2Var2.j = jSONObject.optString("videoId", ot2Var.j);
                ot2Var2.n = jSONObject.optBoolean("autoplay", ot2Var.n);
                ot2Var2.k = jSONObject.optBoolean("muted", ot2Var.k);
                ot2Var2.m = jSONObject.optString("initialTime", ot2Var.m);
                ot2Var2.l = jSONObject.optString(NativeConstants.POSTER, ot2Var.l);
                ot2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, ot2Var.p);
                ot2Var2.q = jSONObject.optBoolean("fullScreen", ot2Var.q);
                ot2Var2.o = jSONObject.optBoolean("loop", ot2Var.o);
                ot2Var2.r = jSONObject.optBoolean("controls", ot2Var.r);
                ot2Var2.s = i(jSONObject.optString("src", ot2Var.s));
                ot2Var2.A = !mb3.E(jSONObject.optString("src", ot2Var.s));
                ot2Var2.u = jSONObject.optBoolean("showPlayBtn", ot2Var.u);
                ot2Var2.v = jSONObject.optBoolean("showMuteBtn", ot2Var.v);
                ot2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", ot2Var.w);
                ot2Var2.x = jSONObject.optBoolean("showProgress", ot2Var.x);
                ot2Var2.z = jSONObject.optBoolean("showFullscreenBtn", ot2Var.z);
                ot2Var2.t = jSONObject.optString("sanId", ot2Var.t);
                ot2Var2.B = ot2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                ot2Var2.C = jSONObject.optBoolean("showNoWifiTip", ot2Var.C);
            }
            return ot2Var2;
        }
        return (ot2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (mb3.E(str) && e43.M() != null) {
                return mb3.H(str, e43.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.uz1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
