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
public class is2 extends oy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public hs2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947864001, "Lcom/baidu/tieba/is2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947864001, "Lcom/baidu/tieba/is2;");
                return;
            }
        }
        boolean z = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public is2() {
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
        this.B = new hs2();
        this.C = true;
    }

    public static is2 h(JSONObject jSONObject, @NonNull is2 is2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, is2Var)) == null) {
            is2 is2Var2 = new is2();
            if (jSONObject != null) {
                is2Var2.e(jSONObject, is2Var);
                is2Var2.j = jSONObject.optString("videoId", is2Var.j);
                is2Var2.n = jSONObject.optBoolean("autoplay", is2Var.n);
                is2Var2.k = jSONObject.optBoolean("muted", is2Var.k);
                is2Var2.m = jSONObject.optString("initialTime", is2Var.m);
                is2Var2.l = jSONObject.optString(NativeConstants.POSTER, is2Var.l);
                is2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, is2Var.p);
                is2Var2.q = jSONObject.optBoolean("fullScreen", is2Var.q);
                is2Var2.o = jSONObject.optBoolean("loop", is2Var.o);
                is2Var2.r = jSONObject.optBoolean("controls", is2Var.r);
                is2Var2.s = i(jSONObject.optString("src", is2Var.s));
                is2Var2.A = !ga3.E(jSONObject.optString("src", is2Var.s));
                is2Var2.u = jSONObject.optBoolean("showPlayBtn", is2Var.u);
                is2Var2.v = jSONObject.optBoolean("showMuteBtn", is2Var.v);
                is2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", is2Var.w);
                is2Var2.x = jSONObject.optBoolean("showProgress", is2Var.x);
                is2Var2.z = jSONObject.optBoolean("showFullscreenBtn", is2Var.z);
                is2Var2.t = jSONObject.optString("sanId", is2Var.t);
                is2Var2.B = is2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                is2Var2.C = jSONObject.optBoolean("showNoWifiTip", is2Var.C);
            }
            return is2Var2;
        }
        return (is2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (!ga3.E(str) || y23.M() == null) ? str : ga3.H(str, y23.M()) : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.oy1, com.baidu.tieba.xs2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.j) : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.oy1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
