package com.baidu.tieba.postsearch;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class PostSearchHttpResponseMessage extends JsonHttpResponsedMessage {
    private b mSearchData;

    public PostSearchHttpResponseMessage(int i) {
        super(i);
    }

    public b getSearchData() {
        return this.mSearchData;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        this.mSearchData = new b();
        this.mSearchData.parseJson(jSONObject);
    }
}
