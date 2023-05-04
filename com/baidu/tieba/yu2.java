package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yu2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948342579, "Lcom/baidu/tieba/yu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948342579, "Lcom/baidu/tieba/yu2;");
                return;
            }
        }
        boolean z = ho1.a;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.a);
        }
        return invokeV.booleanValue;
    }

    public yu2() {
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

    public static yu2 a(JSONObject jSONObject, yu2 yu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, yu2Var)) == null) {
            yu2 yu2Var2 = new yu2();
            if (jSONObject != null) {
                yu2Var2.a = jSONObject.optString("audioId", yu2Var.a);
                yu2Var2.b = jSONObject.optString("slaveId", yu2Var.b);
                yu2Var2.e = jSONObject.optBoolean("autoplay", yu2Var.e);
                yu2Var2.f = jSONObject.optBoolean("loop", yu2Var.f);
                yu2Var2.c = jSONObject.optString("src", yu2Var.c);
                yu2Var2.d = jSONObject.optInt("startTime", yu2Var.d);
                yu2Var2.g = jSONObject.optBoolean("obeyMuteSwitch", yu2Var.g);
                yu2Var2.h = jSONObject.optInt(CriusAttrConstants.POSITION, yu2Var.h);
                yu2Var2.i = (float) jSONObject.optDouble("volume", yu2Var.i);
                yu2Var2.j = jSONObject.optString("cb", yu2Var.j);
            }
            return yu2Var2;
        }
        return (yu2) invokeLL.objValue;
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
