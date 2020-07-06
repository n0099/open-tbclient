package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends com.baidu.tieba.square.data.a {
    private e lBq;

    public e dgI() {
        return this.lBq;
    }

    public void b(e eVar) {
        this.lBq = eVar;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void dJ(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            e eVar = new e();
            eVar.parserJson(optJSONObject);
            b(eVar);
        }
    }
}
