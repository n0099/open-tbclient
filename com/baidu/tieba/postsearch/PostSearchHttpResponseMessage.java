package com.baidu.tieba.postsearch;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PostSearchHttpResponseMessage extends JsonHttpResponsedMessage {
    private j mSearchData;

    public PostSearchHttpResponseMessage(int i) {
        super(i);
    }

    public j getSearchData() {
        return this.mSearchData;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        this.mSearchData = new j();
        this.mSearchData.parseJson(jSONObject);
    }
}
