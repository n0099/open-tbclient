package com.baidu.tieba.newfaceshop.facemake;

import android.text.TextUtils;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetHotWordsMessage extends JsonHttpResponsedMessage {
    public List<String> mData;

    public GetHotWordsMessage(int i) {
        super(i);
    }

    private List<String> parseHotWordsData(JSONObject jSONObject) {
        String[] split;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("hotwords");
        if (TextUtils.isEmpty(optString) || (split = optString.split("_")) == null) {
            return null;
        }
        return Arrays.asList(split);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode != 200 || error < 0 || jSONObject == null) {
            return;
        }
        this.mData = parseHotWordsData(jSONObject.optJSONObject("data"));
    }

    public List<String> getData() {
        return this.mData;
    }
}
