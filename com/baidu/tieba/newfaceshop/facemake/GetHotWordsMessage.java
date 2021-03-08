package com.baidu.tieba.newfaceshop.facemake;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class GetHotWordsMessage extends JsonHttpResponsedMessage {
    private List<String> mData;

    public GetHotWordsMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error >= 0 && jSONObject != null) {
            this.mData = parseHotWordsData(jSONObject.optJSONObject("data"));
        }
    }

    private List<String> parseHotWordsData(JSONObject jSONObject) {
        String[] split;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("hotwords");
        if (TextUtils.isEmpty(optString) || (split = optString.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) == null) {
            return null;
        }
        return Arrays.asList(split);
    }

    public List<String> getData() {
        return this.mData;
    }
}
