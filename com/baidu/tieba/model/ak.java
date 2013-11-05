package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.data.SignData;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    private ForumData f1895a;
    private ArrayList<com.baidu.tieba.data.bf> b;
    private AntiData c;
    private com.baidu.tieba.data.an d;
    private com.baidu.tieba.data.z e;
    private com.baidu.tieba.data.c f;
    private int g = 0;
    private com.baidu.tieba.frs.ac h = null;
    private com.baidu.tieba.frs.ab i = null;
    private boolean j = false;
    private ao k = null;
    private al l = null;
    private boolean m = false;

    public ak() {
        j();
    }

    private void j() {
        this.f1895a = new ForumData();
        this.b = new ArrayList<>();
        this.d = new com.baidu.tieba.data.an();
        this.e = new com.baidu.tieba.data.z();
        a(new AntiData());
        a(new com.baidu.tieba.data.c());
    }

    public void a(com.baidu.tieba.data.ag agVar) {
        this.f1895a.setCurScore(agVar.d());
        this.f1895a.setLevelupScore(agVar.e());
        this.f1895a.setLike(agVar.b());
        this.f1895a.setUser_level(agVar.a());
        this.f1895a.setLevelName(agVar.c());
    }

    public void a(SignData signData) {
        this.f1895a.setSignData(signData);
    }

    public ForumData a() {
        return this.f1895a;
    }

    public ArrayList<com.baidu.tieba.data.bf> b() {
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
        this.j = z;
    }

    public boolean f() {
        return this.j;
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
            j();
            this.f1895a.parserJson(optJSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.data.bf bfVar = new com.baidu.tieba.data.bf();
                    bfVar.a(optJSONArray.optJSONObject(i));
                    bfVar.p();
                    this.b.add(bfVar);
                }
            }
            this.c.parserJson(jSONObject.optJSONObject("anti"));
            this.f.a(jSONObject.optJSONObject("group"));
            this.d.a(jSONObject.optJSONObject("page"));
            this.e.a(jSONObject.optJSONObject("frs_star"));
            this.e.l().a(optJSONObject.optJSONObject("superboy"));
        } catch (Exception e) {
        }
    }

    public void a(String str, ArrayList<BasicNameValuePair> arrayList, int i, boolean z, String str2) {
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        this.m = z;
        this.k = new ao(this, str, arrayList, i, str2);
        this.k.setPriority(3);
        this.k.execute(str, arrayList);
    }

    public void b(String str) {
        if (this.l != null) {
            this.l.cancel();
            this.l = null;
        }
        ForumData a2 = a();
        this.l = new al(this, a2.getId(), a2.getName(), str);
        this.l.setPriority(2);
        this.l.execute(com.baidu.tieba.data.h.f1165a + "c/c/user/fansno");
    }

    public void g() {
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        if (this.l != null) {
            this.l.cancel();
            this.l = null;
        }
    }

    public void a(am amVar) {
        com.baidu.tieba.data.ag agVar = new com.baidu.tieba.data.ag();
        agVar.b(1);
        agVar.a(amVar.d);
        agVar.b(amVar.e);
        agVar.e(amVar.f);
        agVar.f(amVar.g);
        a(agVar);
    }

    public void a(com.baidu.tieba.frs.ac acVar) {
        this.h = acVar;
    }

    public void a(com.baidu.tieba.frs.ab abVar) {
        this.i = abVar;
    }

    public int h() {
        return this.g;
    }

    public void a(int i) {
        this.g = i;
    }

    public com.baidu.tieba.data.c i() {
        return this.f;
    }

    public void a(com.baidu.tieba.data.c cVar) {
        this.f = cVar;
    }
}
