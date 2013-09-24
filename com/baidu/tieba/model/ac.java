package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.v f1390a;
    private ArrayList<com.baidu.tieba.data.bh> b;
    private AntiData c;
    private com.baidu.tieba.data.an d;
    private com.baidu.tieba.data.z e;
    private int f = 0;
    private com.baidu.tieba.frs.ad g = null;
    private com.baidu.tieba.frs.ac h = null;
    private boolean i = false;
    private ag j = null;
    private ad k = null;
    private boolean l = false;

    public ac() {
        i();
    }

    private void i() {
        this.f1390a = new com.baidu.tieba.data.v();
        this.b = new ArrayList<>();
        this.d = new com.baidu.tieba.data.an();
        this.e = new com.baidu.tieba.data.z();
        a(new AntiData());
    }

    public void a(com.baidu.tieba.data.ag agVar) {
        this.f1390a.d(agVar.d());
        this.f1390a.e(agVar.e());
        this.f1390a.a(agVar.b());
        this.f1390a.b(agVar.a());
        this.f1390a.a(agVar.c());
    }

    public void a(com.baidu.tieba.data.bb bbVar) {
        this.f1390a.a(bbVar);
    }

    public com.baidu.tieba.data.v a() {
        return this.f1390a;
    }

    public ArrayList<com.baidu.tieba.data.bh> b() {
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
        this.i = z;
    }

    public boolean f() {
        return this.i;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            a(jSONObject.optInt("is_new_url", 0));
            JSONObject optJSONObject = jSONObject.optJSONObject("forum");
            i();
            this.f1390a.a(optJSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.data.bh bhVar = new com.baidu.tieba.data.bh();
                    bhVar.a(optJSONArray.optJSONObject(i));
                    bhVar.r();
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

    public void a(String str, ArrayList<BasicNameValuePair> arrayList, int i, boolean z, String str2) {
        if (this.j != null) {
            this.j.cancel();
            this.j = null;
        }
        this.l = z;
        this.j = new ag(this, str, arrayList, i, str2);
        this.j.setPriority(3);
        this.j.execute(str, arrayList);
    }

    public void b(String str) {
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        com.baidu.tieba.data.v a2 = a();
        this.k = new ad(this, a2.a(), a2.b(), str);
        this.k.setPriority(2);
        this.k.execute(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/user/fansno");
    }

    public void g() {
        if (this.j != null) {
            this.j.cancel();
            this.j = null;
        }
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
    }

    public void a(ae aeVar) {
        com.baidu.tieba.data.ag agVar = new com.baidu.tieba.data.ag();
        agVar.b(1);
        agVar.a(aeVar.d);
        agVar.b(aeVar.e);
        agVar.e(aeVar.f);
        agVar.f(aeVar.g);
        a(agVar);
    }

    public void a(com.baidu.tieba.frs.ad adVar) {
        this.g = adVar;
    }

    public void a(com.baidu.tieba.frs.ac acVar) {
        this.h = acVar;
    }

    public int h() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }
}
