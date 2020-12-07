package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int hxW;
    private String hxX;
    private int hxY;
    private int hxZ;
    private String hya;

    public MasterIdentityResponseMessage() {
        super(1031071);
        this.hxY = 0;
        this.hxZ = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.hxW = jSONObject.optInt("anchor_identity");
                this.hxX = jSONObject.optString("anchor_proportion");
                this.hxY = jSONObject.optInt("anchor_identity_status");
                this.hxZ = jSONObject.optInt("anchor_proportion_status");
                this.hya = jSONObject.optString("anchor_text");
            }
        }
    }

    public int cjb() {
        return this.hxY;
    }

    public int cjc() {
        return this.hxZ;
    }

    public String cjd() {
        return this.hya;
    }
}
