package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends com.baidu.tieba.square.data.a {
    private d iUs;

    public d clg() {
        return this.iUs;
    }

    public void b(d dVar) {
        this.iUs = dVar;
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
