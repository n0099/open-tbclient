package com.baidu.tieba.kn.pk;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.data.a {

    /* renamed from: a  reason: collision with root package name */
    public String f1280a;
    public x b;
    public x c;

    public LinkedList<y> d() {
        return this.b.m;
    }

    public LinkedList<y> e() {
        return this.c.m;
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        this.f1280a = jSONObject.optString("pk_id");
        this.b = new x().a(jSONObject.optJSONObject("vote1"));
        this.c = new x().a(jSONObject.optJSONObject("vote2"));
        a((String) null);
    }

    public void a(long j) {
        Iterator<y> it = this.b.m.iterator();
        while (it.hasNext()) {
            y next = it.next();
            next.d = j - next.c;
        }
        Iterator<y> it2 = this.c.m.iterator();
        while (it2.hasNext()) {
            y next2 = it2.next();
            next2.d = j - next2.c;
        }
    }
}
