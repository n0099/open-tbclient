package com.baidu.yuyinala.emoticon.message;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaSendEmoticonResponseMessage extends JsonHttpResponsedMessage {
    private String bxz;
    public String oWH;
    public String oWI;
    public String oWJ;

    public AlaSendEmoticonResponseMessage() {
        super(1031025);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
        this.oWH = jSONObject.optString("prototype_img");
        this.oWI = jSONObject.optString("compression_img");
        this.oWJ = jSONObject.optString("result_img");
        if (optJSONObject != null) {
            this.bxz = optJSONObject.optString("usermsg");
        }
    }

    public String getUserMsg() {
        return this.bxz;
    }
}
