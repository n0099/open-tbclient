package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int hFq;
    private String hFr;
    private int hFs;
    private int hFt;
    private String hFu;

    public MasterIdentityResponseMessage() {
        super(1031071);
        this.hFs = 0;
        this.hFt = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.hFq = jSONObject.optInt("anchor_identity");
                this.hFr = jSONObject.optString("anchor_proportion");
                this.hFs = jSONObject.optInt("anchor_identity_status");
                this.hFt = jSONObject.optInt("anchor_proportion_status");
                this.hFu = jSONObject.optString("anchor_text");
            }
        }
    }

    public int chX() {
        return this.hFs;
    }

    public int chY() {
        return this.hFt;
    }

    public String chZ() {
        return this.hFu;
    }
}
