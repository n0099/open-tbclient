package com.baidu.yuyinala.emoticon.message;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaSendEmoticonResponseMessage extends JsonHttpResponsedMessage {
    private String btV;
    public String oKq;
    public String oKr;
    public String oKs;

    public AlaSendEmoticonResponseMessage() {
        super(1031025);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
        this.oKq = jSONObject.optString("prototype_img");
        this.oKr = jSONObject.optString("compression_img");
        this.oKs = jSONObject.optString("result_img");
        if (optJSONObject != null) {
            this.btV = optJSONObject.optString("usermsg");
        }
    }

    public String getUserMsg() {
        return this.btV;
    }
}
