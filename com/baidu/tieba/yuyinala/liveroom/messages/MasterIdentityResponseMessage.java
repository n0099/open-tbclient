package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int hJW;
    private String hJX;
    private int hJY;
    private int hJZ;
    private String hKa;

    public MasterIdentityResponseMessage() {
        super(1031071);
        this.hJY = 0;
        this.hJZ = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.hJW = jSONObject.optInt("anchor_identity");
                this.hJX = jSONObject.optString("anchor_proportion");
                this.hJY = jSONObject.optInt("anchor_identity_status");
                this.hJZ = jSONObject.optInt("anchor_proportion_status");
                this.hKa = jSONObject.optString("anchor_text");
            }
        }
    }

    public int clP() {
        return this.hJY;
    }

    public int clQ() {
        return this.hJZ;
    }

    public String clR() {
        return this.hKa;
    }
}
