package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.data.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetInviteConnectionWheatListHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int count;
    private List<n> ozt;

    public AlaGetInviteConnectionWheatListHttpResponseMessage() {
        super(1031014);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031014) {
            if (this.ozt == null) {
                this.ozt = new ArrayList();
            }
            this.ozt.clear();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= optJSONArray.length()) {
                            break;
                        }
                        n nVar = new n();
                        nVar.parseJson((JSONObject) optJSONArray.get(i3));
                        this.ozt.add(nVar);
                        i2 = i3 + 1;
                    }
                }
                this.count = optJSONObject.optInt("count");
            }
        }
    }

    public List<n> ecl() {
        return this.ozt;
    }

    public int getCount() {
        return this.count;
    }
}
