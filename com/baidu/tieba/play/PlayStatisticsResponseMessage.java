package com.baidu.tieba.play;

import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class PlayStatisticsResponseMessage extends JsonHttpResponsedMessage {
    public PlayStatisticsResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (i2 != 1001804 || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("info")) == null) {
            return;
        }
        TbSingleton.getInstance().setVideoTestType(optJSONObject.optString("exp_tag", ""));
        TbSingleton.getInstance().setPcdnConfigData(optJSONObject.optJSONObject("pcdn_config"));
    }
}
