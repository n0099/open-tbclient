package com.baidu.tieba.pb.pb.main.adapter;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.j0.d2.h.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PbAdCardGiftItemResponseMessage extends JsonHttpResponsedMessage {
    public b mData;

    public PbAdCardGiftItemResponseMessage() {
        super(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            if (this.mData == null) {
                this.mData = new b();
            }
            this.mData.c(optJSONObject);
        }
    }

    public b getData() {
        return this.mData;
    }
}
