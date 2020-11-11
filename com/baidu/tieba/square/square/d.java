package com.baidu.tieba.square.square;

import org.json.JSONObject;
/* loaded from: classes23.dex */
public class d extends com.baidu.tieba.square.data.a {
    private e mSq;

    public e dIH() {
        return this.mSq;
    }

    public void b(e eVar) {
        this.mSq = eVar;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void ez(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            e eVar = new e();
            eVar.parserJson(optJSONObject);
            b(eVar);
        }
    }
}
