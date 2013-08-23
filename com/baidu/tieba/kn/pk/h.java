package com.baidu.tieba.kn.pk;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.data.a {

    /* renamed from: a  reason: collision with root package name */
    public String f1246a;
    public x b;
    public x c;

    public LinkedList d() {
        return this.b.m;
    }

    public LinkedList e() {
        return this.c.m;
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        this.f1246a = jSONObject.optString("pk_id");
        this.b = new x().a(jSONObject.optJSONObject("vote1"));
        this.c = new x().a(jSONObject.optJSONObject("vote2"));
        a((String) null);
    }

    public void a(long j) {
        Iterator it = this.b.m.iterator();
        while (it.hasNext()) {
            y yVar = (y) it.next();
            yVar.d = j - yVar.c;
        }
        Iterator it2 = this.c.m.iterator();
        while (it2.hasNext()) {
            y yVar2 = (y) it2.next();
            yVar2.d = j - yVar2.c;
        }
    }
}
