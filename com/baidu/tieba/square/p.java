package com.baidu.tieba.square;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.data.a {
    private q b;

    public q c() {
        return this.b;
    }

    public void a(q qVar) {
        this.b = qVar;
        a((String) null);
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            q qVar = new q();
            qVar.a(optJSONObject);
            a(qVar);
        }
    }
}
