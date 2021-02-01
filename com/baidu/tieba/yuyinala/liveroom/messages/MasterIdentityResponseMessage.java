package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int hJC;
    private String hJD;
    private int hJE;
    private int hJF;
    private String hJG;

    public MasterIdentityResponseMessage() {
        super(1031071);
        this.hJE = 0;
        this.hJF = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.hJC = jSONObject.optInt("anchor_identity");
                this.hJD = jSONObject.optString("anchor_proportion");
                this.hJE = jSONObject.optInt("anchor_identity_status");
                this.hJF = jSONObject.optInt("anchor_proportion_status");
                this.hJG = jSONObject.optString("anchor_text");
            }
        }
    }

    public int ciQ() {
        return this.hJE;
    }

    public int ciR() {
        return this.hJF;
    }

    public String ciS() {
        return this.hJG;
    }
}
