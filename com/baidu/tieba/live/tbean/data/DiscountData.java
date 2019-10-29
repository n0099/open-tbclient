package com.baidu.tieba.live.tbean.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class DiscountData extends BaseData {
    public int rebate;
    public int recharge;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.recharge = jSONObject.optInt("recharge");
            this.rebate = jSONObject.optInt("rebate");
        }
    }
}
