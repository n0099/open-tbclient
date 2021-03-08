package com.baidu.tieba.yuyinala.liveroom.teamfighttimeset;

import com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class TimeSettingResponseMessage extends BaseJsonHttpResponsedMessage {
    private com.baidu.tieba.yuyinala.liveroom.datingnavigation.a oxg;

    public TimeSettingResponseMessage() {
        super(1031085);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031085) {
            if (this.oxg == null) {
                this.oxg = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.a();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.oxg.oxf = optJSONObject.optString("activity_stage");
                this.oxg.oxe = optJSONObject.optString("num_fields");
            }
        }
    }
}
