package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int hiU;
    private String hiV;
    private int hiW;
    private int hiX;
    private String hiY;

    public MasterIdentityResponseMessage() {
        super(1031071);
        this.hiW = 0;
        this.hiX = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.hiU = jSONObject.optInt("anchor_identity");
                this.hiV = jSONObject.optString("anchor_proportion");
                this.hiW = jSONObject.optInt("anchor_identity_status");
                this.hiX = jSONObject.optInt("anchor_proportion_status");
                this.hiY = jSONObject.optString("anchor_text");
            }
        }
    }

    public int cdn() {
        return this.hiW;
    }

    public int cdo() {
        return this.hiX;
    }

    public String cdp() {
        return this.hiY;
    }
}
