package com.baidu.tieba.yuyinala.liveroom.rename;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetRoomNameRenameHttpResponseMessage extends JsonHttpResponsedMessage {
    private d oaE;

    public AlaGetRoomNameRenameHttpResponseMessage() {
        super(1031020);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031020) {
            this.oaE = new d();
            if (jSONObject.has(BdStatsConstant.StatsType.ERROR) && (optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR)) != null) {
                this.oaE.errno = optJSONObject.optInt(BaseJsonData.TAG_ERRNO);
                this.oaE.errmsg = optJSONObject.optString(BaseJsonData.TAG_ERRMSG);
                this.oaE.usermsg = optJSONObject.optString("usermsg");
            }
        }
    }

    public d dYn() {
        return this.oaE;
    }
}
