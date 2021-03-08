package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class FrameNumCallBackHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int aEA;
    private JSONArray aEB;
    private int aEy;
    private int aEz;

    public FrameNumCallBackHttpResponseMessage() {
        super(1031090);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031090 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aEy = optJSONObject.optInt("unshow_num", 0);
            this.aEz = optJSONObject.optInt("unotice_num", 0);
            this.aEA = optJSONObject.optInt("bubble_num", 0);
            this.aEB = optJSONObject.optJSONArray("info_list");
        }
    }
}
