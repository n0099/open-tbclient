package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetVerifyStrategyResponseHttpMessage extends JsonHttpResponsedMessage {
    public int hJE;
    public String hJF;
    public int hJG;
    public String hJH;
    public int hJI;
    public int hJJ;
    public String hJK;
    public String hJM;
    public String hJN;
    public int verifyType;

    public AlaGetVerifyStrategyResponseHttpMessage() {
        super(1031028);
        this.hJE = 0;
        this.hJG = 2;
        this.hJI = 0;
        this.verifyType = 0;
        this.hJJ = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        String[] split;
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject(UbcStatConstant.ContentType.UBC_TYPE_STRATEGY)) != null) {
                JSONObject optJSONObject3 = optJSONObject.optJSONObject(LogConfig.VALUE_LIVE_HK_RECORD_START);
                if (optJSONObject3 != null) {
                    this.hJE = optJSONObject3.optInt("switch");
                    this.hJF = optJSONObject3.optString("text");
                    String optString = optJSONObject3.optString("toast_content");
                    this.hJN = optString;
                    if (!StringUtils.isNull(optString) && (split = optString.split("\\\\n")) != null && split.length == 2) {
                        this.hJM = split[0];
                        this.hJN = split[1];
                    }
                }
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("certify");
                if (optJSONObject4 != null) {
                    this.hJJ = optJSONObject4.optInt("switch");
                    this.hJK = optJSONObject4.optString("text");
                }
                JSONObject optJSONObject5 = optJSONObject.optJSONObject("user_verify");
                if (optJSONObject5 != null) {
                    this.hJG = optJSONObject5.optInt("switch");
                    this.hJI = optJSONObject5.optInt("in_testlist");
                    this.hJH = optJSONObject5.optString("text");
                    this.verifyType = optJSONObject5.optInt("type");
                }
            }
        }
    }
}
