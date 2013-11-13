package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.data.SignData;
import com.baidu.tieba.data.UserData;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    private ForumData f1891a;
    private ArrayList<com.baidu.tieba.data.ba> b;
    private AntiData c;
    private com.baidu.tieba.data.an d;
    private com.baidu.tieba.data.y e;
    private UserData f;
    private com.baidu.tieba.data.c g;
    private int h = 0;
    private com.baidu.tieba.frs.ag i = null;
    private com.baidu.tieba.frs.af j = null;
    private boolean k = false;
    private ao l = null;
    private al m = null;
    private boolean n = false;

    public ak() {
        k();
    }

    private void k() {
        this.f1891a = new ForumData();
        this.b = new ArrayList<>();
        this.d = new com.baidu.tieba.data.an();
        this.e = new com.baidu.tieba.data.y();
        this.f = new UserData();
        a(new AntiData());
        a(new com.baidu.tieba.data.c());
    }

    public void a(com.baidu.tieba.data.ag agVar) {
        this.f1891a.setCurScore(agVar.d());
        this.f1891a.setLevelupScore(agVar.e());
        this.f1891a.setLike(agVar.b());
        this.f1891a.setUser_level(agVar.a());
        this.f1891a.setLevelName(agVar.c());
    }

    public void a(SignData signData) {
        this.f1891a.setSignData(signData);
    }

    public ForumData a() {
        return this.f1891a;
    }

    public ArrayList<com.baidu.tieba.data.ba> b() {
        return this.b;
    }

    public UserData c() {
        return this.f;
    }

    public void a(AntiData antiData) {
        this.c = antiData;
    }

    public AntiData d() {
        return this.c;
    }

    public com.baidu.tieba.data.an e() {
        return this.d;
    }

    public com.baidu.tieba.data.y f() {
        return this.e;
    }

    public void a(boolean z) {
        this.k = z;
    }

    public boolean g() {
        return this.k;
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
            k();
            this.f1891a.parserJson(optJSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.data.ba baVar = new com.baidu.tieba.data.ba();
                    baVar.a(optJSONArray.optJSONObject(i));
                    baVar.t();
                    this.b.add(baVar);
                }
            }
            this.c.parserJson(jSONObject.optJSONObject("anti"));
            this.g.a(jSONObject.optJSONObject("group"));
            this.d.a(jSONObject.optJSONObject("page"));
            this.e.a(jSONObject.optJSONObject("frs_star"));
            this.e.j().a(optJSONObject.optJSONObject("superboy"));
            this.f.parserJson(jSONObject.optJSONObject("user"));
        } catch (Exception e) {
        }
    }

    public void a(String str, ArrayList<BasicNameValuePair> arrayList, int i, boolean z, String str2) {
        if (this.l != null) {
            this.l.cancel();
            this.l = null;
        }
        this.n = z;
        this.l = new ao(this, str, arrayList, i, str2);
        this.l.setPriority(3);
        this.l.execute(str, arrayList);
    }

    public void b(String str) {
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
        ForumData a2 = a();
        this.m = new al(this, a2.getId(), a2.getName(), str);
        this.m.setPriority(2);
        this.m.execute(com.baidu.tieba.data.h.f1196a + "c/c/user/fansno");
    }

    public void h() {
        if (this.l != null) {
            this.l.cancel();
            this.l = null;
        }
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
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

    public void a(com.baidu.tieba.frs.ag agVar) {
        this.i = agVar;
    }

    public void a(com.baidu.tieba.frs.af afVar) {
        this.j = afVar;
    }

    public int i() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    public com.baidu.tieba.data.c j() {
        return this.g;
    }

    public void a(com.baidu.tieba.data.c cVar) {
        this.g = cVar;
    }
}
