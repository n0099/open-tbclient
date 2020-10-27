package com.baidu.tieba.yuyinala.charm.charmrank;

import com.baidu.live.data.i;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CharmRankListHttpResponseMessage extends JsonHttpResponsedMessage {
    private i nMR;

    public CharmRankListHttpResponseMessage() {
        super(1031035);
    }

    public i dUO() {
        return this.nMR;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0) {
            this.nMR = new i();
            this.nMR.parserJson(jSONObject);
        }
    }
}
