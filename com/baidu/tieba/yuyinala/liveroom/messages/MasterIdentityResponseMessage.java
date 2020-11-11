package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int hoL;
    private String hoM;
    private int hoN;
    private int hoO;
    private String hoP;

    public MasterIdentityResponseMessage() {
        super(1031071);
        this.hoN = 0;
        this.hoO = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.hoL = jSONObject.optInt("anchor_identity");
                this.hoM = jSONObject.optString("anchor_proportion");
                this.hoN = jSONObject.optInt("anchor_identity_status");
                this.hoO = jSONObject.optInt("anchor_proportion_status");
                this.hoP = jSONObject.optString("anchor_text");
            }
        }
    }

    public int cfO() {
        return this.hoN;
    }

    public int cfP() {
        return this.hoO;
    }

    public String cfQ() {
        return this.hoP;
    }
}
