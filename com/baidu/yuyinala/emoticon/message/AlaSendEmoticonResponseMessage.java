package com.baidu.yuyinala.emoticon.message;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaSendEmoticonResponseMessage extends JsonHttpResponsedMessage {
    private String boM;
    public String ovi;
    public String ovj;
    public String ovk;

    public AlaSendEmoticonResponseMessage() {
        super(1031025);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
        this.ovi = jSONObject.optString("prototype_img");
        this.ovj = jSONObject.optString("compression_img");
        this.ovk = jSONObject.optString("result_img");
        if (optJSONObject != null) {
            this.boM = optJSONObject.optString("usermsg");
        }
    }

    public String getUserMsg() {
        return this.boM;
    }
}
