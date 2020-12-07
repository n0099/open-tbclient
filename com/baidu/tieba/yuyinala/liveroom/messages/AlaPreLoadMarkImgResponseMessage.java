package com.baidu.tieba.yuyinala.liveroom.messages;

import android.text.TextUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaPreLoadMarkImgResponseMessage extends JsonHttpResponsedMessage {
    private List<String> hxP;

    public AlaPreLoadMarkImgResponseMessage() {
        super(1021117);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null && optJSONArray.length() > 0) {
            if (this.hxP == null) {
                this.hxP = new ArrayList();
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String optString = optJSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString)) {
                    this.hxP.add(optString);
                }
            }
        }
    }
}
