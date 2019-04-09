package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends com.baidu.tieba.square.data.a {
    private d iBC;

    public d cda() {
        return this.iBC;
    }

    public void b(d dVar) {
        this.iBC = dVar;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void bE(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            d dVar = new d();
            dVar.parserJson(optJSONObject);
            b(dVar);
        }
    }
}
