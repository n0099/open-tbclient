package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.v f1353a;
    private ArrayList b;
    private AntiData c;
    private com.baidu.tieba.data.an d;
    private com.baidu.tieba.data.z e;
    private com.baidu.tieba.frs.ae f = null;
    private com.baidu.tieba.frs.ad g = null;
    private boolean h = false;
    private ae i = null;
    private ab j = null;
    private boolean k = false;

    public aa() {
        h();
    }

    private void h() {
        this.f1353a = new com.baidu.tieba.data.v();
        this.b = new ArrayList();
        this.d = new com.baidu.tieba.data.an();
        this.e = new com.baidu.tieba.data.z();
        a(new AntiData());
    }

    public void a(com.baidu.tieba.data.ag agVar) {
        this.f1353a.d(agVar.d());
        this.f1353a.e(agVar.e());
        this.f1353a.a(agVar.b());
        this.f1353a.b(agVar.a());
        this.f1353a.a(agVar.c());
    }

    public void a(com.baidu.tieba.data.bb bbVar) {
        this.f1353a.a(bbVar);
    }

    public com.baidu.tieba.data.v a() {
        return this.f1353a;
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

    public com.baidu.tieba.data.an d() {
        return this.d;
    }

    public com.baidu.tieba.data.z e() {
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
            h();
            this.f1353a.a(optJSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.data.bh bhVar = new com.baidu.tieba.data.bh();
                    bhVar.a(optJSONArray.optJSONObject(i));
                    bhVar.o();
                    this.b.add(bhVar);
                }
            }
            this.c.parserJson(jSONObject.optJSONObject("anti"));
            this.d.a(jSONObject.optJSONObject("page"));
            this.e.a(jSONObject.optJSONObject("frs_star"));
            this.e.l().a(optJSONObject.optJSONObject("superboy"));
        } catch (Exception e) {
        }
    }

    public void a(String str, ArrayList arrayList, int i, boolean z, String str2) {
        if (this.i != null) {
            this.i.cancel();
            this.i = null;
        }
        this.k = z;
        this.i = new ae(this, str, arrayList, i, str2);
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
        this.j.execute(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/user/fansno");
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
        com.baidu.tieba.data.ag agVar = new com.baidu.tieba.data.ag();
        agVar.b(1);
        agVar.a(acVar.d);
        agVar.b(acVar.e);
        agVar.e(acVar.f);
        agVar.f(acVar.g);
        a(agVar);
    }

    public void a(com.baidu.tieba.frs.ae aeVar) {
        this.f = aeVar;
    }

    public void a(com.baidu.tieba.frs.ad adVar) {
        this.g = adVar;
    }
}
