package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaLinkCallBackHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int fans;
    private String oIX;
    private int oIY;
    private int oIZ;

    public AlaLinkCallBackHttpResponseMessage() {
        super(1031027);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031027 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oIX = optJSONObject.optString("minute");
            this.fans = optJSONObject.optInt("fans");
            this.oIY = optJSONObject.optInt(SdkStaticKeys.RANK_TYPE_CHARM);
            this.oIZ = optJSONObject.optInt(SubPbActivityConfig.KEY_USER_IDENTITY);
        }
    }

    public boolean eet() {
        return this.oIZ == 1 || this.oIZ == 2 || this.oIZ == 3;
    }

    public String eeu() {
        return this.oIX;
    }

    public int cZo() {
        return this.fans;
    }

    public int eev() {
        return this.oIY;
    }
}
