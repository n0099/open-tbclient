package com.baidu.tieba.yuyinala.charm.audiencelist;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class OnlineListHttpResponseMessage extends JsonHttpResponsedMessage {
    private long mAudienceCount;
    private b ofE;

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
                this.ofE = new b();
                this.ofE.parserJson(optJSONObject);
            }
        }
    }

    public long bTg() {
        return this.mAudienceCount;
    }

    public b dXT() {
        return this.ofE;
    }
}
