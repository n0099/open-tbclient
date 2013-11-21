package com.baidu.tieba.square;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.data.a {

    /* renamed from: a  reason: collision with root package name */
    private z f2418a;

    public z d() {
        return this.f2418a;
    }

    public void a(z zVar) {
        this.f2418a = zVar;
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
