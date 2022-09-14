package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class zp2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public int h;
    public float i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948367565, "Lcom/baidu/tieba/zp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948367565, "Lcom/baidu/tieba/zp2;");
                return;
            }
        }
        boolean z = ij1.a;
    }

    public zp2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = 0;
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = 0;
        this.i = 1.0f;
    }

    public static zp2 a(JSONObject jSONObject, zp2 zp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, zp2Var)) == null) {
            zp2 zp2Var2 = new zp2();
            if (jSONObject != null) {
                zp2Var2.a = jSONObject.optString("audioId", zp2Var.a);
                zp2Var2.b = jSONObject.optString("slaveId", zp2Var.b);
                zp2Var2.e = jSONObject.optBoolean("autoplay", zp2Var.e);
                zp2Var2.f = jSONObject.optBoolean("loop", zp2Var.f);
                zp2Var2.c = jSONObject.optString("src", zp2Var.c);
                zp2Var2.d = jSONObject.optInt(FetchLog.START_TIME, zp2Var.d);
                zp2Var2.g = jSONObject.optBoolean("obeyMuteSwitch", zp2Var.g);
                zp2Var2.h = jSONObject.optInt(CriusAttrConstants.POSITION, zp2Var.h);
                zp2Var2.i = (float) jSONObject.optDouble("volume", zp2Var.i);
                zp2Var2.j = jSONObject.optString("cb", zp2Var.j);
            }
            return zp2Var2;
        }
        return (zp2) invokeLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.a) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "playerId : " + this.a + "; slaveId : " + this.b + "; url : " + this.c + "; AutoPlay : " + this.e + "; Loop : " + this.f + "; startTime : " + this.d + "; ObeyMute : " + this.g + "; pos : " + this.h;
        }
        return (String) invokeV.objValue;
    }
}
