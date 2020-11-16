package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int hos;
    private String hot;
    private int hou;
    private int hov;
    private String how;

    public MasterIdentityResponseMessage() {
        super(1031071);
        this.hou = 0;
        this.hov = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.hos = jSONObject.optInt("anchor_identity");
                this.hot = jSONObject.optString("anchor_proportion");
                this.hou = jSONObject.optInt("anchor_identity_status");
                this.hov = jSONObject.optInt("anchor_proportion_status");
                this.how = jSONObject.optString("anchor_text");
            }
        }
    }

    public int cfh() {
        return this.hou;
    }

    public int cfi() {
        return this.hov;
    }

    public String cfj() {
        return this.how;
    }
}
