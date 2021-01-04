package com.baidu.yuyinala.background.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.yuyinala.background.b.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaAudioBackgroundListResponseMessage extends JsonHttpResponsedMessage {
    private List<a> nBr;
    private a oQg;

    public AlaAudioBackgroundListResponseMessage() {
        super(1031015);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray = jSONObject.optJSONArray("background_list");
        int length = optJSONArray.length();
        this.nBr = new ArrayList();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            a aVar = new a();
            aVar.parse(optJSONObject);
            this.nBr.add(aVar);
            if (aVar.eku() && this.oQg == null) {
                this.oQg = aVar;
            }
        }
    }

    public List<a> getBgList() {
        return this.nBr;
    }

    public a ekw() {
        return this.oQg;
    }
}
