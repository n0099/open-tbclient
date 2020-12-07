package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.yuyinala.liveroom.i.c ooc;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1031037);
    }

    public com.baidu.tieba.yuyinala.liveroom.i.c edN() {
        return this.ooc;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.ooc = new com.baidu.tieba.yuyinala.liveroom.i.c();
            this.ooc.parserJson(jSONObject);
        }
    }
}
