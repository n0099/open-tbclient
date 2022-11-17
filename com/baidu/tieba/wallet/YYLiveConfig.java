package com.baidu.tieba.wallet;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qy4;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.yyPayOpen = 0;
        this.yyIsConvert = 0;
    }

    public boolean isYYPayNeedConfirm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.yyPayOpen == 1 && this.yyIsConvert == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isYyIsConvert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.yyPayOpen == 1 && this.yyIsConvert == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void parse(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) && jSONObject != null) {
            this.yyPayOpen = jSONObject.optInt("yy_pay_open");
            this.yyIsConvert = jSONObject.optInt("yy_is_convert");
        }
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            if (jSONObject != null) {
                parse(jSONObject);
                qy4.k().y("key_extra_yy_config", jSONObject.toString());
                return;
            }
            String q = qy4.k().q("key_extra_yy_config", "");
            if (!xi.isEmpty(q)) {
                try {
                    parse(new JSONObject(q));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            qy4.k().y("key_extra_yy_config", "");
        }
    }

    public void updateStatusAndCache(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.yyIsConvert = i;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("yy_pay_open", this.yyPayOpen);
                jSONObject.put("yy_is_convert", this.yyIsConvert);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            qy4.k().y("key_extra_yy_config", jSONObject.toString());
        }
    }
}
