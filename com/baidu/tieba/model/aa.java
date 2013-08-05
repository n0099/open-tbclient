package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {
    private AntiData c;
    private com.baidu.tieba.frs.ac f = null;
    private com.baidu.tieba.frs.ab g = null;
    private boolean h = false;
    private ae i = null;
    private ab j = null;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.v f1320a = new com.baidu.tieba.data.v();
    private ArrayList b = new ArrayList();
    private com.baidu.tieba.data.ar d = new com.baidu.tieba.data.ar();
    private com.baidu.tieba.data.x e = new com.baidu.tieba.data.x();

    public aa() {
        a(new AntiData());
    }

    public void a(com.baidu.tieba.data.ak akVar) {
        this.f1320a.d(akVar.d());
        this.f1320a.e(akVar.e());
        this.f1320a.a(akVar.b());
        this.f1320a.b(akVar.a());
        this.f1320a.a(akVar.c());
    }

    public void a(com.baidu.tieba.data.bg bgVar) {
        this.f1320a.a(bgVar);
    }

    public com.baidu.tieba.data.v a() {
        return this.f1320a;
    }

    public ArrayList b() {
        return this.b;
    }

    public void a(AntiData antiData) {
        this.c = antiData;
    }

    public AntiData c() {
        return this.c;
    }

    public com.baidu.tieba.data.ar d() {
        return this.d;
    }

    public com.baidu.tieba.data.x e() {
        return this.e;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public boolean f() {
        return this.h;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("forum");
            this.f1320a.a(optJSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.data.bm bmVar = new com.baidu.tieba.data.bm();
                    bmVar.a(optJSONArray.optJSONObject(i));
                    bmVar.o();
                    this.b.add(bmVar);
                }
            }
            this.c.parserJson(jSONObject.optJSONObject("anti"));
            this.d.a(jSONObject.optJSONObject("page"));
            this.e.a(jSONObject.optJSONObject("frs_star"));
            this.e.l().a(optJSONObject.optJSONObject("superboy"));
        } catch (Exception e) {
        }
    }

    public void a(String str, ArrayList arrayList, int i) {
        if (this.i != null) {
            this.i.cancel();
            this.i = null;
        }
        this.i = new ae(this, str, arrayList, i);
        this.i.setPriority(3);
        this.i.execute(str, arrayList);
    }

    public void b(String str) {
        if (this.j != null) {
            this.j.cancel();
            this.j = null;
        }
        com.baidu.tieba.data.v a2 = a();
        this.j = new ab(this, a2.a(), a2.b(), str);
        this.j.setPriority(2);
        this.j.execute(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/c/user/fansno");
    }

    public void g() {
        if (this.i != null) {
            this.i.cancel();
            this.i = null;
        }
        if (this.j != null) {
            this.j.cancel();
            this.j = null;
        }
    }

    public void a(ac acVar) {
        com.baidu.tieba.data.ak akVar = new com.baidu.tieba.data.ak();
        akVar.b(1);
        akVar.a(acVar.d);
        akVar.b(acVar.e);
        akVar.e(acVar.f);
        akVar.f(acVar.g);
        a(akVar);
    }

    public void a(com.baidu.tieba.frs.ac acVar) {
        this.f = acVar;
    }

    public void a(com.baidu.tieba.frs.ab abVar) {
        this.g = abVar;
    }
}
