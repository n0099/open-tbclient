package com.baidu.tieba.yuyinala.charm.bannedpost;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class BannedListHttpResponseMessage extends JsonHttpResponsedMessage {
    private a okm;

    public BannedListHttpResponseMessage() {
        super(1031038);
    }

    public a ebM() {
        return this.okm;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0) {
            this.okm = new a();
            this.okm.parserJson(jSONObject);
        }
    }
}
