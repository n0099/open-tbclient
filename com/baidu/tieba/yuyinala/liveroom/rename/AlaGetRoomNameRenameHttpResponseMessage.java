package com.baidu.tieba.yuyinala.liveroom.rename;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetRoomNameRenameHttpResponseMessage extends JsonHttpResponsedMessage {
    private d ooq;

    public AlaGetRoomNameRenameHttpResponseMessage() {
        super(1031020);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031020) {
            this.ooq = new d();
            if (jSONObject.has(BdStatsConstant.StatsType.ERROR) && (optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR)) != null) {
                this.ooq.errno = optJSONObject.optInt(BaseJsonData.TAG_ERRNO);
                this.ooq.errmsg = optJSONObject.optString(BaseJsonData.TAG_ERRMSG);
                this.ooq.usermsg = optJSONObject.optString("usermsg");
            }
        }
    }

    public d dZt() {
        return this.ooq;
    }
}
