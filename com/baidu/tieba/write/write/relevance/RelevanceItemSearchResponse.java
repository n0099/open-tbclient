package com.baidu.tieba.write.write.relevance;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class RelevanceItemSearchResponse extends JsonHttpResponsedMessage {
    private static final String TAG = "RelevanceItemSearchResp";
    private RelevanceItemSearchData mRelevanceItemSearchData;

    public RelevanceItemSearchResponse(int i) {
        super(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.mRelevanceItemSearchData = new RelevanceItemSearchData();
            this.mRelevanceItemSearchData.parseJson(jSONObject.toString());
        }
    }

    public RelevanceItemSearchData getResponseData() {
        return this.mRelevanceItemSearchData;
    }
}
