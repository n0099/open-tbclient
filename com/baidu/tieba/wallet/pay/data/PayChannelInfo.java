package com.baidu.tieba.wallet.pay.data;

import com.baidu.pass.ecommerce.bean.AddressField;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class PayChannelInfo {
    public String channel;
    public String iconUrl;
    public boolean isDefault;
    public String prompt;
    public String tag;
    public String title;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
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
