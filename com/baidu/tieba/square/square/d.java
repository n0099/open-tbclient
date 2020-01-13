package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends com.baidu.tieba.square.data.a {
    private e kbb;

    public e cIc() {
        return this.kbb;
    }

    public void b(e eVar) {
        this.kbb = eVar;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void dg(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            e eVar = new e();
            eVar.parserJson(optJSONObject);
            b(eVar);
        }
    }
}
