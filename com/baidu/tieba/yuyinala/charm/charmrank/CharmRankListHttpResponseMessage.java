package com.baidu.tieba.yuyinala.charm.charmrank;

import com.baidu.live.data.j;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class CharmRankListHttpResponseMessage extends JsonHttpResponsedMessage {
    private j ogu;

    public CharmRankListHttpResponseMessage() {
        super(1031035);
    }

    public j dXX() {
        return this.ogu;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0) {
            this.ogu = new j();
            this.ogu.parserJson(jSONObject);
        }
    }
}
