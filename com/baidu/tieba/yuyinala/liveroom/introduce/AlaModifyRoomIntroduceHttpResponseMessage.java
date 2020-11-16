package com.baidu.tieba.yuyinala.liveroom.introduce;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.introduce.f;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaModifyRoomIntroduceHttpResponseMessage extends JsonHttpResponsedMessage {
    private f nYl;

    public AlaModifyRoomIntroduceHttpResponseMessage() {
        super(1031034);
    }

    public f dYe() {
        return this.nYl;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject jSONObject2;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031034) {
            this.nYl = new f();
            this.nYl.nYy = new f.a();
            if (jSONObject.has(BdStatsConstant.StatsType.ERROR) && (jSONObject2 = jSONObject.getJSONObject(BdStatsConstant.StatsType.ERROR)) != null) {
                this.nYl.nYy.errno = jSONObject2.optInt(BaseJsonData.TAG_ERRNO);
                this.nYl.nYy.usermsg = jSONObject2.optString("usermsg");
            }
        }
    }
}
