package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private String hLA;
    private int hLB;
    private int hLC;
    private String hLD;
    private int hLz;

    public MasterIdentityResponseMessage() {
        super(1031071);
        this.hLB = 0;
        this.hLC = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.hLz = jSONObject.optInt("anchor_identity");
                this.hLA = jSONObject.optString("anchor_proportion");
                this.hLB = jSONObject.optInt("anchor_identity_status");
                this.hLC = jSONObject.optInt("anchor_proportion_status");
                this.hLD = jSONObject.optString("anchor_text");
            }
        }
    }

    public int cjd() {
        return this.hLB;
    }

    public int cje() {
        return this.hLC;
    }

    public String cjf() {
        return this.hLD;
    }
}
