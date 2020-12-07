package com.baidu.tieba.yuyinala.charm.charmrank;

import com.baidu.live.data.i;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CharmRankListHttpResponseMessage extends JsonHttpResponsedMessage {
    private i ojm;

    public CharmRankListHttpResponseMessage() {
        super(1031035);
    }

    public i ecR() {
        return this.ojm;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0) {
            this.ojm = new i();
            this.ojm.parserJson(jSONObject);
        }
    }
}
