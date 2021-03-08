package com.baidu.tieba.yuyinala.charm.bannedpost;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class BannedListHttpResponseMessage extends JsonHttpResponsedMessage {
    private a osh;

    public BannedListHttpResponseMessage() {
        super(1031038);
    }

    public a eav() {
        return this.osh;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0) {
            this.osh = new a();
            this.osh.parserJson(jSONObject);
        }
    }
}
