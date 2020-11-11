package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.yuyinala.liveroom.i.c nXz;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1031037);
    }

    public com.baidu.tieba.yuyinala.liveroom.i.c dYk() {
        return this.nXz;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.nXz = new com.baidu.tieba.yuyinala.liveroom.i.c();
            this.nXz.parserJson(jSONObject);
        }
    }
}
