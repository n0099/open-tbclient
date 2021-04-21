package com.baidu.tieba.majorsearch.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.j0.p1.c.a;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SearchMajorHttpResponsedMessage extends JsonHttpResponsedMessage {
    public a mSearchMajorResultData;

    public SearchMajorHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_SEARCH_MAJOR);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("major_list");
            a aVar = new a();
            this.mSearchMajorResultData = aVar;
            aVar.a(optJSONArray);
        }
    }

    public a getData() {
        return this.mSearchMajorResultData;
    }
}
