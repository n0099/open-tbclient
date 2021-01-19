package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaLinkCallBackHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int fans;
    private String ozp;
    private int ozq;
    private int ozr;

    public AlaLinkCallBackHttpResponseMessage() {
        super(1031027);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031027 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.ozp = optJSONObject.optString("minute");
            this.fans = optJSONObject.optInt("fans");
            this.ozq = optJSONObject.optInt(SdkStaticKeys.RANK_TYPE_CHARM);
            this.ozr = optJSONObject.optInt(SubPbActivityConfig.KEY_USER_IDENTITY);
        }
    }

    public boolean ecf() {
        return this.ozr == 1 || this.ozr == 2 || this.ozr == 3;
    }

    public String ecg() {
        return this.ozp;
    }

    public int cXq() {
        return this.fans;
    }

    public int ech() {
        return this.ozq;
    }
}
