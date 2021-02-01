package com.baidu.tieba.yuyinala.charm.charmrank;

import com.baidu.live.data.j;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class CharmRankListHttpResponseMessage extends JsonHttpResponsedMessage {
    private j oqo;

    public CharmRankListHttpResponseMessage() {
        super(1031035);
    }

    public j eai() {
        return this.oqo;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0) {
            this.oqo = new j();
            this.oqo.parserJson(jSONObject);
        }
    }
}
