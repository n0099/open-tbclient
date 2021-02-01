package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class FrameNumCallBackHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int aCY;
    private int aCZ;
    private int aDa;
    private JSONArray aDb;

    public FrameNumCallBackHttpResponseMessage() {
        super(1031090);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031090 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aCY = optJSONObject.optInt("unshow_num", 0);
            this.aCZ = optJSONObject.optInt("unotice_num", 0);
            this.aDa = optJSONObject.optInt("bubble_num", 0);
            this.aDb = optJSONObject.optJSONArray("info_list");
        }
    }
}
