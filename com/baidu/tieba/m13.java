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
public class m13 extends s72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public l13 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947919770, "Lcom/baidu/tieba/m13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947919770, "Lcom/baidu/tieba/m13;");
                return;
            }
        }
        boolean z = ms1.a;
    }

    @Override // com.baidu.tieba.s72, com.baidu.tieba.b23
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m13() {
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
        this.B = new l13();
        this.C = true;
    }

    public static m13 h(JSONObject jSONObject, @NonNull m13 m13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, m13Var)) == null) {
            m13 m13Var2 = new m13();
            if (jSONObject != null) {
                m13Var2.e(jSONObject, m13Var);
                m13Var2.j = jSONObject.optString("videoId", m13Var.j);
                m13Var2.n = jSONObject.optBoolean("autoplay", m13Var.n);
                m13Var2.k = jSONObject.optBoolean("muted", m13Var.k);
                m13Var2.m = jSONObject.optString("initialTime", m13Var.m);
                m13Var2.l = jSONObject.optString(NativeConstants.POSTER, m13Var.l);
                m13Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, m13Var.p);
                m13Var2.q = jSONObject.optBoolean("fullScreen", m13Var.q);
                m13Var2.o = jSONObject.optBoolean("loop", m13Var.o);
                m13Var2.r = jSONObject.optBoolean("controls", m13Var.r);
                m13Var2.s = i(jSONObject.optString("src", m13Var.s));
                m13Var2.A = !kj3.E(jSONObject.optString("src", m13Var.s));
                m13Var2.u = jSONObject.optBoolean("showPlayBtn", m13Var.u);
                m13Var2.v = jSONObject.optBoolean("showMuteBtn", m13Var.v);
                m13Var2.w = jSONObject.optBoolean("showCenterPlayBtn", m13Var.w);
                m13Var2.x = jSONObject.optBoolean("showProgress", m13Var.x);
                m13Var2.z = jSONObject.optBoolean("showFullscreenBtn", m13Var.z);
                m13Var2.t = jSONObject.optString("sanId", m13Var.t);
                m13Var2.B = m13Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                m13Var2.C = jSONObject.optBoolean("showNoWifiTip", m13Var.C);
            }
            return m13Var2;
        }
        return (m13) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (kj3.E(str) && cc3.M() != null) {
                return kj3.H(str, cc3.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s72
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
