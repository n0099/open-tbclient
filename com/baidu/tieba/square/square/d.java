package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends com.baidu.tieba.square.data.a {
    private e nsx;

    public e dMj() {
        return this.nsx;
    }

    public void b(e eVar) {
        this.nsx = eVar;
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
