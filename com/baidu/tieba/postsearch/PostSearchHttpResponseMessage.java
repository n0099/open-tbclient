package com.baidu.tieba.postsearch;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.j0.n2.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PostSearchHttpResponseMessage extends JsonHttpResponsedMessage {
    public b mSearchData;

    public PostSearchHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        b bVar = new b();
        this.mSearchData = bVar;
        bVar.c(jSONObject);
    }

    public b getSearchData() {
        return this.mSearchData;
    }
}
