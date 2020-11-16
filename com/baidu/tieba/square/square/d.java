package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.square.data.a {
    private e mTm;

    public e dIy() {
        return this.mTm;
    }

    public void b(e eVar) {
        this.mTm = eVar;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void et(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            e eVar = new e();
            eVar.parserJson(optJSONObject);
            b(eVar);
        }
    }
}
