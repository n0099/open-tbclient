package com.baidu.tieba.pb.pb.main.emotion.message;

import android.text.TextUtils;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class GetSugMatchWordsResponseMessage extends JsonHttpResponsedMessage {
    private List<String> mData;

    public GetSugMatchWordsResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.mData = parseSugMatchWordsData(optJSONObject.optJSONArray("sug_keywords"));
        }
    }

    private List<String> parseSugMatchWordsData(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                if (!TextUtils.isEmpty(jSONArray.optString(i))) {
                    arrayList.add(jSONArray.optString(i));
                }
            }
        }
        return arrayList;
    }

    public List<String> getData() {
        return this.mData;
    }
}
