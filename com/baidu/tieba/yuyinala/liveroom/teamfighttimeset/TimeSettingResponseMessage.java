package com.baidu.tieba.yuyinala.liveroom.teamfighttimeset;

import com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class TimeSettingResponseMessage extends BaseJsonHttpResponsedMessage {
    private com.baidu.tieba.yuyinala.liveroom.datingnavigation.b okI;

    public TimeSettingResponseMessage() {
        super(1031085);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031085) {
            if (this.okI == null) {
                this.okI = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.okI.okH = optJSONObject.optString("activity_stage");
                this.okI.okG = optJSONObject.optString("num_fields");
            }
        }
    }
}
