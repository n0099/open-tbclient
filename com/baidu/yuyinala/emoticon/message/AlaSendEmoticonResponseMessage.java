package com.baidu.yuyinala.emoticon.message;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaSendEmoticonResponseMessage extends JsonHttpResponsedMessage {
    private String byZ;
    public String oYM;
    public String oYN;
    public String oYO;

    public AlaSendEmoticonResponseMessage() {
        super(1031025);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
        this.oYM = jSONObject.optString("prototype_img");
        this.oYN = jSONObject.optString("compression_img");
        this.oYO = jSONObject.optString("result_img");
        if (optJSONObject != null) {
            this.byZ = optJSONObject.optString("usermsg");
        }
    }

    public String getUserMsg() {
        return this.byZ;
    }
}
