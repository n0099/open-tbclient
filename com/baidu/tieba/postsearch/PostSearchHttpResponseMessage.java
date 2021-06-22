package com.baidu.tieba.postsearch;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.o0.o2.b;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class PostSearchHttpResponseMessage extends JsonHttpResponsedMessage {
    public b mSearchData;

    public PostSearchHttpResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) {
        b bVar = new b();
        this.mSearchData = bVar;
        bVar.c(jSONObject);
    }

    public b getSearchData() {
        return this.mSearchData;
    }
}
