package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class uz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public Object c;
    public boolean d;
    public String e;

    public uz2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.b = str;
    }

    public static String a(tz2 tz2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tz2Var)) == null) {
            if (tz2Var == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("componentId", tz2Var.f);
                jSONObject.put("pluginProvider", tz2Var.b);
                jSONObject.put(WebChromeClient.KEY_ARG_ARRAY, tz2Var.g);
                jSONObject.put("slaveId", tz2Var.e);
            } catch (JSONException e) {
                b03.b(Log.getStackTraceString(e));
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            pe2 pe2Var = new pe2();
            ?? jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "functionPageFinished");
                jSONObject.put("componentId", this.b);
                jSONObject.put("isSuccess", this.d);
                jSONObject.put("data", this.e);
                if (this.c != null) {
                    jSONObject.put("error", this.c.toString());
                }
            } catch (JSONException e) {
                b03.b(Log.getStackTraceString(e));
            }
            pe2Var.c = jSONObject;
            wp2.U().m(this.a, pe2Var);
            b03.b("finish event, isSuccess = " + this.d);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.b + "', error=" + this.c + ", isSuccess=" + this.d + ", resultData='" + this.e + "'}";
        }
        return (String) invokeV.objValue;
    }
}
