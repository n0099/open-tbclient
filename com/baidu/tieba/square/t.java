package com.baidu.tieba.square;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.data.a {
    private ab a;

    public ab d() {
        return this.a;
    }

    public void a(ab abVar) {
        this.a = abVar;
        a((String) null);
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            ab abVar = new ab();
            abVar.a(optJSONObject);
            a(abVar);
        }
    }
}
