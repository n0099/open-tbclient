package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends com.baidu.tieba.square.data.a {
    private e nrX;

    public e dMb() {
        return this.nrX;
    }

    public void b(e eVar) {
        this.nrX = eVar;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void eK(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            e eVar = new e();
            eVar.parserJson(optJSONObject);
            b(eVar);
        }
    }
}
