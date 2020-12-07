package com.baidu.tieba.yuyinala.charm.bannedpost;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BannedListHttpResponseMessage extends JsonHttpResponsedMessage {
    private a oiB;

    public BannedListHttpResponseMessage() {
        super(1031038);
    }

    public a ecO() {
        return this.oiB;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0) {
            this.oiB = new a();
            this.oiB.parserJson(jSONObject);
        }
    }
}
