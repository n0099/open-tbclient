package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes23.dex */
public class d extends com.baidu.tieba.square.data.a {
    private e mzH;

    public e dCX() {
        return this.mzH;
    }

    public void b(e eVar) {
        this.mzH = eVar;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void en(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            e eVar = new e();
            eVar.parserJson(optJSONObject);
            b(eVar);
        }
    }
}
