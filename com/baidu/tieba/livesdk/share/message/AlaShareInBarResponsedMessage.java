package com.baidu.tieba.livesdk.share.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.livesdk.share.b.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaShareInBarResponsedMessage extends JsonHttpResponsedMessage {
    private a data;

    public AlaShareInBarResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.data = new a();
            this.data.parseJson(jSONObject);
        }
    }

    public a getShareInBarData() {
        return this.data;
    }
}
