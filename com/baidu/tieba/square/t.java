package com.baidu.tieba.square;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.data.a {
    private z a;

    public z d() {
        return this.a;
    }

    public void a(z zVar) {
        this.a = zVar;
        a((String) null);
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            z zVar = new z();
            zVar.a(optJSONObject);
            a(zVar);
        }
    }
}
