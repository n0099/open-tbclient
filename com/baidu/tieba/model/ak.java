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
    private ForumData a;
    private ArrayList<com.baidu.tieba.data.bb> b;
    private AntiData c;
    private com.baidu.tieba.data.an d;
    private com.baidu.tieba.data.z e;
    private boolean f;
    private UserData g;
    private com.baidu.tieba.data.c h;
    private int i = 0;
    private com.baidu.tieba.frs.ab j = null;
    private com.baidu.tieba.frs.aa k = null;
    private boolean l = false;
    private ao m = null;
    private al n = null;
    private boolean o = false;

    public boolean a() {
        return this.f;
    }

    public ak() {
        l();
    }

    private void l() {
        this.a = new ForumData();
        this.b = new ArrayList<>();
        this.d = new com.baidu.tieba.data.an();
        this.e = new com.baidu.tieba.data.z();
        this.g = new UserData();
        a(new AntiData());
        a(new com.baidu.tieba.data.c());
    }

    public void a(com.baidu.tieba.data.ag agVar) {
        this.a.setCurScore(agVar.d());
        this.a.setLevelupScore(agVar.e());
        this.a.setLike(agVar.b());
        this.a.setUser_level(agVar.a());
        this.a.setLevelName(agVar.c());
    }

    public void a(SignData signData) {
        this.a.setSignData(signData);
    }

    public ForumData b() {
        return this.a;
    }

    public ArrayList<com.baidu.tieba.data.bb> c() {
        return this.b;
    }

    public UserData d() {
        return this.g;
    }

    public void a(AntiData antiData) {
        this.c = antiData;
    }

    public AntiData e() {
        return this.c;
    }

    public com.baidu.tieba.data.an f() {
        return this.d;
    }

    public com.baidu.tieba.data.z g() {
        return this.e;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public boolean h() {
        return this.l;
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
            this.f = jSONObject.optInt("fortune_bag", 0) == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("forum");
            l();
            this.a.parserJson(optJSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.data.bb bbVar = new com.baidu.tieba.data.bb();
                    bbVar.a(optJSONArray.optJSONObject(i));
                    bbVar.t();
                    this.b.add(bbVar);
                }
            }
            this.c.parserJson(jSONObject.optJSONObject("anti"));
            this.h.a(jSONObject.optJSONObject("group"));
            this.d.a(jSONObject.optJSONObject("page"));
            this.e.a(jSONObject.optJSONObject("frs_star"));
            this.e.j().a(optJSONObject.optJSONObject("superboy"));
            this.g.parserJson(jSONObject.optJSONObject("user"));
        } catch (Exception e) {
        }
    }

    public void a(String str, ArrayList<BasicNameValuePair> arrayList, int i, boolean z, String str2) {
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
        this.o = z;
        this.m = new ao(this, str, arrayList, i, str2);
        this.m.setPriority(3);
        this.m.execute(str, arrayList);
    }

    public void b(String str) {
        if (this.n != null) {
            this.n.cancel();
            this.n = null;
        }
        ForumData b = b();
        this.n = new al(this, b.getId(), b.getName(), str);
        this.n.setPriority(2);
        this.n.execute(com.baidu.tieba.data.h.a + "c/c/user/fansno");
    }

    public void i() {
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
        if (this.n != null) {
            this.n.cancel();
            this.n = null;
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

    public void a(com.baidu.tieba.frs.ab abVar) {
        this.j = abVar;
    }

    public void a(com.baidu.tieba.frs.aa aaVar) {
        this.k = aaVar;
    }

    public int j() {
        return this.i;
    }

    public void a(int i) {
        this.i = i;
    }

    public com.baidu.tieba.data.c k() {
        return this.h;
    }

    public void a(com.baidu.tieba.data.c cVar) {
        this.h = cVar;
    }
}
