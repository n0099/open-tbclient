package com.baidu.tieba.square;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.data.a {

    /* renamed from: a  reason: collision with root package name */
    private r f1733a;

    public r c() {
        return this.f1733a;
    }

    public void a(r rVar) {
        this.f1733a = rVar;
        a((String) null);
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            r rVar = new r();
            rVar.a(optJSONObject);
            a(rVar);
        }
    }
}
