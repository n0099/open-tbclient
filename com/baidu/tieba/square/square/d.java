package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes17.dex */
public class d extends com.baidu.tieba.square.data.a {
    private e maF;

    public e dvt() {
        return this.maF;
    }

    public void b(e eVar) {
        this.maF = eVar;
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
