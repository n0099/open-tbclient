package com.baidu.tieba.yuyinala.charm.audiencelist;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class OnlineListHttpResponseMessage extends JsonHttpResponsedMessage {
    private long mAudienceCount;
    private b osd;

    public OnlineListHttpResponseMessage() {
        super(1031031);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.mAudienceCount = optJSONObject.optLong("user_count");
            if (optJSONObject.optJSONArray("user_info") != null) {
                this.osd = new b();
                this.osd.parserJson(optJSONObject);
            }
        }
    }

    public long bTW() {
        return this.mAudienceCount;
    }

    public b eau() {
        return this.osd;
    }
}
