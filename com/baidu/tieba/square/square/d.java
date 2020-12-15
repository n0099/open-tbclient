package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes23.dex */
public class d extends com.baidu.tieba.square.data.a {
    private e nho;

    public e dNP() {
        return this.nho;
    }

    public void b(e eVar) {
        this.nho = eVar;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void ev(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            e eVar = new e();
            eVar.parserJson(optJSONObject);
            b(eVar);
        }
    }
}
