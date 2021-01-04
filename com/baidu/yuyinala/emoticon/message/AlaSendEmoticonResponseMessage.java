package com.baidu.yuyinala.emoticon.message;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaSendEmoticonResponseMessage extends JsonHttpResponsedMessage {
    private String byH;
    public String oQC;
    public String oQD;
    public String oQE;

    public AlaSendEmoticonResponseMessage() {
        super(1031025);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
        this.oQC = jSONObject.optString("prototype_img");
        this.oQD = jSONObject.optString("compression_img");
        this.oQE = jSONObject.optString("result_img");
        if (optJSONObject != null) {
            this.byH = optJSONObject.optString("usermsg");
        }
    }

    public String getUserMsg() {
        return this.byH;
    }
}
