package com.baidu.tieba.pb.pb.main.emotion.message;

import android.text.TextUtils;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GetSugMatchWordsResponseMessage extends JsonHttpResponsedMessage {
    public List<String> mData;

    public GetSugMatchWordsResponseMessage(int i2) {
        super(i2);
    }

    private List<String> parseSugMatchWordsData(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (!TextUtils.isEmpty(jSONArray.optString(i2))) {
                    arrayList.add(jSONArray.optString(i2));
                }
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode != 200 || error != 0 || jSONObject == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        this.mData = parseSugMatchWordsData(optJSONObject.optJSONArray("sug_keywords"));
    }

    public List<String> getData() {
        return this.mData;
    }
}
