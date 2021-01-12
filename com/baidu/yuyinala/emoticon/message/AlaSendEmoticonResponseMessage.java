package com.baidu.yuyinala.emoticon.message;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaSendEmoticonResponseMessage extends JsonHttpResponsedMessage {
    private String btU;
    public String oMa;
    public String oMb;
    public String oMc;

    public AlaSendEmoticonResponseMessage() {
        super(1031025);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
        this.oMa = jSONObject.optString("prototype_img");
        this.oMb = jSONObject.optString("compression_img");
        this.oMc = jSONObject.optString("result_img");
        if (optJSONObject != null) {
            this.btU = optJSONObject.optString("usermsg");
        }
    }

    public String getUserMsg() {
        return this.btU;
    }
}
