package com.baidu.tieba.live.tbean.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UserInfoData extends BaseData {
    public int is_mem;
    public int scores_total;
    public long user_id;
    public long user_name;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optLong("user_id");
            this.user_name = jSONObject.optLong("user_name");
            this.is_mem = jSONObject.optInt("is_mem");
            this.scores_total = jSONObject.optInt("scores_total");
        }
    }
}
