package com.baidu.tieba.square;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class t extends com.baidu.tieba.data.a {
    private ab a;

    public final ab d() {
        return this.a;
    }

    @Override // com.baidu.tieba.data.a
    protected final void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            ab abVar = new ab();
            abVar.a(optJSONObject);
            this.a = abVar;
            a((String) null);
        }
    }
}
