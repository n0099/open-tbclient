package com.baidu.tieba.livesdk.share.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.i0.l1.k.b.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaShareInBarResponsedMessage extends JsonHttpResponsedMessage {
    public a data;

    public AlaShareInBarResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() != 200 || jSONObject == null) {
            return;
        }
        a aVar = new a();
        this.data = aVar;
        aVar.a(jSONObject);
    }

    public a getShareInBarData() {
        return this.data;
    }
}
