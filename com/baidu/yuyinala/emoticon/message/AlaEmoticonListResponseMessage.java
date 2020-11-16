package com.baidu.yuyinala.emoticon.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.yuyinala.emoticon.a.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaEmoticonListResponseMessage extends JsonHttpResponsedMessage {
    private int mSendIntervalTime;
    private List<a> ovd;

    public AlaEmoticonListResponseMessage() {
        super(1031004);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        this.mSendIntervalTime = optJSONObject.optInt("interval_time", 4);
        JSONArray optJSONArray = optJSONObject.optJSONArray("img");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            this.ovd = new ArrayList();
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                a aVar = new a();
                aVar.parse(optJSONArray.getJSONObject(i2));
                this.ovd.add(aVar);
            }
        }
    }

    public List<a> getEmoticonList() {
        return this.ovd;
    }

    public int getSendIntervalTime() {
        return this.mSendIntervalTime;
    }
}
