package com.baidu.tieba.yuyinala.liveroom.rename;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetRoomNameRenameHttpResponseMessage extends JsonHttpResponsedMessage {
    private d oyH;

    public AlaGetRoomNameRenameHttpResponseMessage() {
        super(1031020);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031020) {
            this.oyH = new d();
            if (jSONObject.has(BdStatsConstant.StatsType.ERROR) && (optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR)) != null) {
                this.oyH.errno = optJSONObject.optInt(BaseJsonData.TAG_ERRNO);
                this.oyH.errmsg = optJSONObject.optString(BaseJsonData.TAG_ERRMSG);
                this.oyH.usermsg = optJSONObject.optString("usermsg");
            }
        }
    }

    public d ebO() {
        return this.oyH;
    }
}
