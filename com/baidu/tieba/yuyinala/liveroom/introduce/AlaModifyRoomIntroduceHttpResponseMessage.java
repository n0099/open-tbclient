package com.baidu.tieba.yuyinala.liveroom.introduce;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.introduce.f;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaModifyRoomIntroduceHttpResponseMessage extends JsonHttpResponsedMessage {
    private f olV;

    public AlaModifyRoomIntroduceHttpResponseMessage() {
        super(1031034);
    }

    public f dZj() {
        return this.olV;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject jSONObject2;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031034) {
            this.olV = new f();
            this.olV.omi = new f.a();
            if (jSONObject.has(BdStatsConstant.StatsType.ERROR) && (jSONObject2 = jSONObject.getJSONObject(BdStatsConstant.StatsType.ERROR)) != null) {
                this.olV.omi.errno = jSONObject2.optInt(BaseJsonData.TAG_ERRNO);
                this.olV.omi.usermsg = jSONObject2.optString("usermsg");
            }
        }
    }
}
