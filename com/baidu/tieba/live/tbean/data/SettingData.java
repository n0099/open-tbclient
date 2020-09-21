package com.baidu.tieba.live.tbean.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SettingData extends BaseData {
    public int amount_pay_limit;
    public int vip_extra_percent;
    public int vip_extra_switch;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.vip_extra_switch = jSONObject.optInt("vip_extra_switch");
            this.vip_extra_percent = jSONObject.optInt("vip_extra_percent");
            this.amount_pay_limit = jSONObject.optInt("amount_pay_limit");
        }
    }
}
