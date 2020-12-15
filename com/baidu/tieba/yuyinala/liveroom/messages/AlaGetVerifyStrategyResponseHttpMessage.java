package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetVerifyStrategyResponseHttpMessage extends JsonHttpResponsedMessage {
    public int hxG;
    public String hxH;
    public int hxI;
    public String hxJ;
    public int hxK;
    public int hxL;
    public String hxM;
    public String hxO;
    public String hxP;
    public int verifyType;

    public AlaGetVerifyStrategyResponseHttpMessage() {
        super(1031028);
        this.hxG = 0;
        this.hxI = 2;
        this.hxK = 0;
        this.verifyType = 0;
        this.hxL = 0;
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
                    this.hxG = optJSONObject3.optInt("switch");
                    this.hxH = optJSONObject3.optString("text");
                    String optString = optJSONObject3.optString("toast_content");
                    this.hxP = optString;
                    if (!StringUtils.isNull(optString) && (split = optString.split("\\\\n")) != null && split.length == 2) {
                        this.hxO = split[0];
                        this.hxP = split[1];
                    }
                }
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("certify");
                if (optJSONObject4 != null) {
                    this.hxL = optJSONObject4.optInt("switch");
                    this.hxM = optJSONObject4.optString("text");
                }
                JSONObject optJSONObject5 = optJSONObject.optJSONObject("user_verify");
                if (optJSONObject5 != null) {
                    this.hxI = optJSONObject5.optInt("switch");
                    this.hxK = optJSONObject5.optInt("in_testlist");
                    this.hxJ = optJSONObject5.optString("text");
                    this.verifyType = optJSONObject5.optInt("type");
                }
            }
        }
    }
}
