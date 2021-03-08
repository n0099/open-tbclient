package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends com.baidu.tieba.square.data.a {
    private e nuC;

    public e dMr() {
        return this.nuC;
    }

    public void b(e eVar) {
        this.nuC = eVar;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void eN(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            e eVar = new e();
            eVar.parserJson(optJSONObject);
            b(eVar);
        }
    }
}
