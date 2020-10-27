package com.baidu.yuyinala.background.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.yuyinala.background.b.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaAudioBackgroundListResponseMessage extends JsonHttpResponsedMessage {
    private List<a> naP;
    private a okd;

    public AlaAudioBackgroundListResponseMessage() {
        super(1031015);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray = jSONObject.optJSONArray("background_list");
        int length = optJSONArray.length();
        this.naP = new ArrayList();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            a aVar = new a();
            aVar.parse(optJSONObject);
            this.naP.add(aVar);
            if (aVar.eaS() && this.okd == null) {
                this.okd = aVar;
            }
        }
    }

    public List<a> getBgList() {
        return this.naP;
    }

    public a eaT() {
        return this.okd;
    }
}
