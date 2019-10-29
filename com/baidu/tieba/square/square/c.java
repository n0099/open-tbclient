package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends com.baidu.tieba.square.data.a {
    private d jec;

    public d cmU() {
        return this.jec;
    }

    public void b(d dVar) {
        this.jec = dVar;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void cp(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            d dVar = new d();
            dVar.parserJson(optJSONObject);
            b(dVar);
        }
    }
}
