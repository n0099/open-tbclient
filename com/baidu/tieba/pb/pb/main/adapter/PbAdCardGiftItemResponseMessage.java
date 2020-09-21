package com.baidu.tieba.pb.pb.main.adapter;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class PbAdCardGiftItemResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.pb.data.b mData;

    public PbAdCardGiftItemResponseMessage() {
        super(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            if (this.mData == null) {
                this.mData = new com.baidu.tieba.pb.data.b();
            }
            this.mData.parseJson(optJSONObject);
        }
    }

    public com.baidu.tieba.pb.data.b getData() {
        return this.mData;
    }
}
