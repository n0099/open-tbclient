package com.baidu.tieba.wallet.pay.data;

import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class PayChannelInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String channel;
    public String iconUrl;
    public boolean isDefault;
    public String prompt;
    public String tag;
    public String title;

    public PayChannelInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.channel = jSONObject.optString("channel");
        this.title = jSONObject.optString("title");
        this.iconUrl = jSONObject.optString("icon");
        this.tag = jSONObject.optString("tag_name");
        this.prompt = jSONObject.optString("prompt_text");
        this.isDefault = jSONObject.optInt(AddressField.KEY_IS_DEFAULT) == 1;
    }
}
