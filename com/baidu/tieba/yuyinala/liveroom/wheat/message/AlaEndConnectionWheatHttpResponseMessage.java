package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaEndConnectionWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int fans;
    private String ozo;
    private int ozp;
    private int ozq;

    public AlaEndConnectionWheatHttpResponseMessage() {
        super(1031011);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031011 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.ozo = optJSONObject.optString("minute");
            this.fans = optJSONObject.optInt("fans");
            this.ozp = optJSONObject.optInt(SdkStaticKeys.RANK_TYPE_CHARM);
            this.ozq = optJSONObject.optInt(SubPbActivityConfig.KEY_USER_IDENTITY);
        }
    }

    public boolean ecf() {
        return this.ozq == 1 || this.ozq == 2 || this.ozq == 3;
    }

    public String ecg() {
        return this.ozo;
    }

    public int cXq() {
        return this.fans;
    }

    public int ech() {
        return this.ozp;
    }
}
