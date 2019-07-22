package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends com.baidu.tieba.square.data.a {
    private d jaM;

    public d cnZ() {
        return this.jaM;
    }

    public void b(d dVar) {
        this.jaM = dVar;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void bQ(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            d dVar = new d();
            dVar.parserJson(optJSONObject);
            b(dVar);
        }
    }
}
