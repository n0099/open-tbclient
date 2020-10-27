package com.baidu.yuyinala.emoticon.message;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaSendEmoticonResponseMessage extends JsonHttpResponsedMessage {
    private String bpe;

    public AlaSendEmoticonResponseMessage() {
        super(1031025);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
        if (optJSONObject != null) {
            this.bpe = optJSONObject.optString("usermsg");
        }
    }

    public String getUserMsg() {
        return this.bpe;
    }
}
