package com.baidu.tieba.square;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.data.a {

    /* renamed from: a  reason: collision with root package name */
    private s f1852a;

    public s d() {
        return this.f1852a;
    }

    public void a(s sVar) {
        this.f1852a = sVar;
        a((String) null);
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            s sVar = new s();
            sVar.a(optJSONObject);
            a(sVar);
        }
    }
}
