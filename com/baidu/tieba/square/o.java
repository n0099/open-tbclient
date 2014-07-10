package com.baidu.tieba.square;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.data.a {
    private w a;

    public w d() {
        return this.a;
    }

    public void a(w wVar) {
        this.a = wVar;
        a((String) null);
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            w wVar = new w();
            wVar.a(optJSONObject);
            a(wVar);
        }
    }
}
