package com.baidu.tieba.myCollection.message;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaMGetLiveStatusHttpResponseMessage extends JsonHttpResponsedMessage {
    public List<Long> closeLives;
    public long interval;

    public AlaMGetLiveStatusHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null) {
            return;
        }
        setError(jSONObject.optInt("error_code"));
        setErrorString(jSONObject.optString("error_msg"));
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("close_live");
            if (optJSONArray != null) {
                if (this.closeLives == null) {
                    this.closeLives = new ArrayList();
                }
                this.closeLives.clear();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    if (optJSONArray.get(i2) instanceof Integer) {
                        this.closeLives.add(Long.valueOf(((Integer) optJSONArray.get(i2)).longValue()));
                    }
                }
            }
            this.interval = jSONObject.optLong("interval");
        }
    }

    public List<Long> getCloseLives() {
        return this.closeLives;
    }
}
