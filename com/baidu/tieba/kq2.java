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
/* loaded from: classes4.dex */
public class kq2 extends qw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public jq2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947921661, "Lcom/baidu/tieba/kq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947921661, "Lcom/baidu/tieba/kq2;");
                return;
            }
        }
        boolean z = kh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kq2() {
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
        this.B = new jq2();
        this.C = true;
    }

    public static kq2 h(JSONObject jSONObject, @NonNull kq2 kq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, kq2Var)) == null) {
            kq2 kq2Var2 = new kq2();
            if (jSONObject != null) {
                kq2Var2.e(jSONObject, kq2Var);
                kq2Var2.j = jSONObject.optString("videoId", kq2Var.j);
                kq2Var2.n = jSONObject.optBoolean("autoplay", kq2Var.n);
                kq2Var2.k = jSONObject.optBoolean("muted", kq2Var.k);
                kq2Var2.m = jSONObject.optString("initialTime", kq2Var.m);
                kq2Var2.l = jSONObject.optString(NativeConstants.POSTER, kq2Var.l);
                kq2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, kq2Var.p);
                kq2Var2.q = jSONObject.optBoolean("fullScreen", kq2Var.q);
                kq2Var2.o = jSONObject.optBoolean("loop", kq2Var.o);
                kq2Var2.r = jSONObject.optBoolean("controls", kq2Var.r);
                kq2Var2.s = i(jSONObject.optString("src", kq2Var.s));
                kq2Var2.A = !i83.E(jSONObject.optString("src", kq2Var.s));
                kq2Var2.u = jSONObject.optBoolean("showPlayBtn", kq2Var.u);
                kq2Var2.v = jSONObject.optBoolean("showMuteBtn", kq2Var.v);
                kq2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", kq2Var.w);
                kq2Var2.x = jSONObject.optBoolean("showProgress", kq2Var.x);
                kq2Var2.z = jSONObject.optBoolean("showFullscreenBtn", kq2Var.z);
                kq2Var2.t = jSONObject.optString("sanId", kq2Var.t);
                kq2Var2.B = kq2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                kq2Var2.C = jSONObject.optBoolean("showNoWifiTip", kq2Var.C);
            }
            return kq2Var2;
        }
        return (kq2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (!i83.E(str) || a13.M() == null) ? str : i83.H(str, a13.M()) : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qw1, com.baidu.tieba.zq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.j) : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qw1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
