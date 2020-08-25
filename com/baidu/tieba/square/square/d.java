package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes17.dex */
public class d extends com.baidu.tieba.square.data.a {
    private e mao;

    public e dvo() {
        return this.mao;
    }

    public void b(e eVar) {
        this.mao = eVar;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void eb(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            e eVar = new e();
            eVar.parserJson(optJSONObject);
            b(eVar);
        }
    }
}
