package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private AntiData c;
    private com.baidu.tieba.frs.ac f = null;
    private com.baidu.tieba.frs.ab g = null;
    private boolean h = false;
    private z i = null;
    private w j = null;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.r f1066a = new com.baidu.tieba.data.r();
    private ArrayList b = new ArrayList();
    private com.baidu.tieba.data.ai d = new com.baidu.tieba.data.ai();
    private com.baidu.tieba.data.t e = new com.baidu.tieba.data.t();

    public v() {
        a(new AntiData());
    }

    public void a(com.baidu.tieba.data.ac acVar) {
        this.f1066a.d(acVar.d());
        this.f1066a.e(acVar.e());
        this.f1066a.a(acVar.b());
        this.f1066a.b(acVar.a());
        this.f1066a.a(acVar.c());
    }

    public void a(com.baidu.tieba.data.av avVar) {
        this.f1066a.a(avVar);
    }

    public com.baidu.tieba.data.r a() {
        return this.f1066a;
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

    public com.baidu.tieba.data.ai d() {
        return this.d;
    }

    public com.baidu.tieba.data.t e() {
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
            this.f1066a.a(jSONObject.optJSONObject("forum"));
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.data.ba baVar = new com.baidu.tieba.data.ba();
                    baVar.a(optJSONArray.optJSONObject(i));
                    baVar.o();
                    this.b.add(baVar);
                }
            }
            this.c.parserJson(jSONObject.optJSONObject("anti"));
            this.d.a(jSONObject.optJSONObject("page"));
            this.e.a(jSONObject.optJSONObject("frs_star"));
        } catch (Exception e) {
        }
    }

    public void a(String str, ArrayList arrayList, int i) {
        if (this.i != null) {
            this.i.cancel();
            this.i = null;
        }
        this.i = new z(this, str, arrayList, i);
        this.i.setPriority(3);
        this.i.execute(str, arrayList);
    }

    public void b(String str) {
        if (this.j != null) {
            this.j.cancel();
            this.j = null;
        }
        com.baidu.tieba.data.r a2 = a();
        this.j = new w(this, a2.a(), a2.b(), str);
        this.j.setPriority(2);
        this.j.execute(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/c/user/fansno");
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

    public void a(x xVar) {
        com.baidu.tieba.data.ac acVar = new com.baidu.tieba.data.ac();
        acVar.b(1);
        acVar.a(xVar.d);
        acVar.b(xVar.e);
        acVar.e(xVar.f);
        acVar.f(xVar.g);
        a(acVar);
    }

    public void a(com.baidu.tieba.frs.ac acVar) {
        this.f = acVar;
    }

    public void a(com.baidu.tieba.frs.ab abVar) {
        this.g = abVar;
    }
}
