package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends com.baidu.tieba.square.data.a {
    private e kNT;

    public e cUZ() {
        return this.kNT;
    }

    public void b(e eVar) {
        this.kNT = eVar;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void ds(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            e eVar = new e();
            eVar.parserJson(optJSONObject);
            b(eVar);
        }
    }
}
