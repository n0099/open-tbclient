package com.baidu.tieba.majorsearch.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.majorsearch.c.a;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class SearchMajorHttpResponsedMessage extends JsonHttpResponsedMessage {
    private a mSearchMajorResultData;

    public SearchMajorHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_SEARCH_MAJOR);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("major_list");
            this.mSearchMajorResultData = new a();
            this.mSearchMajorResultData.parseJson(optJSONArray);
        }
    }

    public a getData() {
        return this.mSearchMajorResultData;
    }
}
