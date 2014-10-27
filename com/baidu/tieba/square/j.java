package com.baidu.tieba.square;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.data.a {
    private q bMh;

    public q ado() {
        return this.bMh;
    }

    public void b(q qVar) {
        this.bMh = qVar;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.data.a
    protected void e(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            q qVar = new q();
            qVar.parserJson(optJSONObject);
            b(qVar);
        }
    }
}
