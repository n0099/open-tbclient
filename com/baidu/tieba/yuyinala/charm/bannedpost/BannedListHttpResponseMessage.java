package com.baidu.tieba.yuyinala.charm.bannedpost;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class BannedListHttpResponseMessage extends JsonHttpResponsedMessage {
    private a opB;

    public BannedListHttpResponseMessage() {
        super(1031038);
    }

    public a eaf() {
        return this.opB;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0) {
            this.opB = new a();
            this.opB.parserJson(jSONObject);
        }
    }
}
