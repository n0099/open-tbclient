package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class yz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;

    public yz4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1500;
        this.b = 3000;
        this.c = 6000;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.optInt("wifiSlow", -1);
            jSONObject.optInt("threeGSlow", -1);
            jSONObject.optInt("twoGSlow", -1);
            int optInt = jSONObject.optInt("wifiLog", -1);
            if (optInt > 0) {
                this.a = optInt;
            }
            int optInt2 = jSONObject.optInt("threeGLog", -1);
            if (optInt2 > 0) {
                this.b = optInt2;
            }
            int optInt3 = jSONObject.optInt("twoGLog", -1);
            if (optInt3 > 0) {
                this.c = optInt3;
            }
            jSONObject.optInt("mobile_cdn_switch", 1);
        } catch (Exception unused) {
        }
    }
}
