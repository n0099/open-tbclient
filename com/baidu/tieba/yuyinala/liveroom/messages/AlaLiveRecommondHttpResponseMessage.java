package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.yuyinala.liveroom.k.c omL;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1031037);
    }

    public com.baidu.tieba.yuyinala.liveroom.k.c dZo() {
        return this.omL;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.omL = new com.baidu.tieba.yuyinala.liveroom.k.c();
            this.omL.parserJson(jSONObject);
        }
    }
}
