package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int hJQ;
    private String hJR;
    private int hJS;
    private int hJT;
    private String hJU;

    public MasterIdentityResponseMessage() {
        super(1031071);
        this.hJS = 0;
        this.hJT = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.hJQ = jSONObject.optInt("anchor_identity");
                this.hJR = jSONObject.optString("anchor_proportion");
                this.hJS = jSONObject.optInt("anchor_identity_status");
                this.hJT = jSONObject.optInt("anchor_proportion_status");
                this.hJU = jSONObject.optString("anchor_text");
            }
        }
    }

    public int ciX() {
        return this.hJS;
    }

    public int ciY() {
        return this.hJT;
    }

    public String ciZ() {
        return this.hJU;
    }
}
