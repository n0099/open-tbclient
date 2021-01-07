package com.baidu.tieba.yuyinala.liveroom.teamfighttimeset;

import com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class TimeSettingResponseMessage extends BaseJsonHttpResponsedMessage {
    private com.baidu.tieba.yuyinala.liveroom.datingnavigation.b opo;

    public TimeSettingResponseMessage() {
        super(1031085);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031085) {
            if (this.opo == null) {
                this.opo = new com.baidu.tieba.yuyinala.liveroom.datingnavigation.b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.opo.opn = optJSONObject.optString("activity_stage");
                this.opo.opm = optJSONObject.optString("num_fields");
            }
        }
    }
}
