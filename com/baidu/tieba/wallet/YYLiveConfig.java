package com.baidu.tieba.wallet;

import c.a.d.f.p.m;
import c.a.t0.s.j0.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class YYLiveConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int yyIsConvert;
    public int yyPayOpen;

    public YYLiveConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.yyPayOpen = 0;
        this.yyIsConvert = 0;
    }

    private void parse(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.yyPayOpen = jSONObject.optInt("yy_pay_open");
        this.yyIsConvert = jSONObject.optInt("yy_is_convert");
    }

    public boolean isYYPayNeedConfirm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.yyPayOpen == 1 && this.yyIsConvert == 0 : invokeV.booleanValue;
    }

    public boolean isYyIsConvert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.yyPayOpen == 1 && this.yyIsConvert == 1 : invokeV.booleanValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            if (jSONObject != null) {
                parse(jSONObject);
                b.k().y("key_extra_yy_config", jSONObject.toString());
                return;
            }
            String q = b.k().q("key_extra_yy_config", "");
            if (!m.isEmpty(q)) {
                try {
                    parse(new JSONObject(q));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            b.k().y("key_extra_yy_config", "");
        }
    }

    public void updateStatusAndCache(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.yyIsConvert = i2;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("yy_pay_open", this.yyPayOpen);
                jSONObject.put("yy_is_convert", this.yyIsConvert);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            b.k().y("key_extra_yy_config", jSONObject.toString());
        }
    }
}
