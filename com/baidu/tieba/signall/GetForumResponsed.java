package com.baidu.tieba.signall;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetForumResponsed extends JsonHttpResponsedMessage {
    public a a;

    public GetForumResponsed(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public final void a(JSONObject jSONObject) {
        if (e() == 0) {
            this.a = new a();
            this.a.a(jSONObject);
        }
    }
}
