package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaOnLineHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int oDS;
    private int oDZ;

    public AlaOnLineHttpResponseMessage() {
        super(1031036);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031036 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oDS = optJSONObject.optInt("online");
            this.oDZ = optJSONObject.optInt(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY);
        }
    }

    public boolean isOnline() {
        return this.oDS == 1;
    }
}
