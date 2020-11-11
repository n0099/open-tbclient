package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLinkCallBackHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int fans;
    private String ogu;
    private int ogv;
    private int ogw;

    public AlaLinkCallBackHttpResponseMessage() {
        super(1031027);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031027 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.ogu = optJSONObject.optString("minute");
            this.fans = optJSONObject.optInt("fans");
            this.ogv = optJSONObject.optInt(SdkStaticKeys.RANK_TYPE_CHARM);
            this.ogw = optJSONObject.optInt(SubPbActivityConfig.KEY_USER_IDENTITY);
        }
    }

    public boolean eai() {
        return this.ogw == 1 || this.ogw == 2 || this.ogw == 3;
    }

    public String eaj() {
        return this.ogu;
    }

    public int cWL() {
        return this.fans;
    }

    public int eak() {
        return this.ogv;
    }
}
