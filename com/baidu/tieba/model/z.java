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
public class z {
    private ForumData a;
    private ArrayList<com.baidu.tieba.data.az> b;
    private AntiData c;
    private com.baidu.tieba.data.al d;
    private com.baidu.tieba.data.y e;
    private boolean f;
    private UserData g;
    private com.baidu.tieba.data.d h;
    private int i = 0;
    private com.baidu.tieba.frs.by j = null;
    private com.baidu.tieba.frs.bx k = null;
    private boolean l = false;
    private ad m = null;
    private aa n = null;
    private boolean o = false;

    public boolean a() {
        return this.f;
    }

    public z() {
        l();
    }

    private void l() {
        this.a = new ForumData();
        this.b = new ArrayList<>();
        this.d = new com.baidu.tieba.data.al();
        this.e = new com.baidu.tieba.data.y();
        this.g = new UserData();
        a(new AntiData());
        a(new com.baidu.tieba.data.d());
    }

    public void a(com.baidu.tieba.data.af afVar) {
        this.a.setCurScore(afVar.e());
        this.a.setLevelupScore(afVar.f());
        this.a.setLike(afVar.c());
        this.a.setUser_level(afVar.b());
        this.a.setLevelName(afVar.d());
    }

    public void a(SignData signData) {
        this.a.setSignData(signData);
    }

    public ForumData b() {
        return this.a;
    }

    public ArrayList<com.baidu.tieba.data.az> c() {
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

    public com.baidu.tieba.data.al f() {
        return this.d;
    }

    public com.baidu.tieba.data.y g() {
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
                    com.baidu.tieba.data.az azVar = new com.baidu.tieba.data.az();
                    azVar.a(optJSONArray.optJSONObject(i));
                    azVar.t();
                    this.b.add(azVar);
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
        this.m = new ad(this, str, arrayList, i, str2);
        this.m.setPriority(3);
        this.m.execute(str, arrayList);
    }

    public void b(String str) {
        if (this.n != null) {
            this.n.cancel();
            this.n = null;
        }
        ForumData b = b();
        this.n = new aa(this, b.getId(), b.getName(), str);
        this.n.setPriority(2);
        this.n.execute(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/user/fansno");
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

    public void a(ab abVar) {
        com.baidu.tieba.data.af afVar = new com.baidu.tieba.data.af();
        afVar.b(1);
        afVar.a(abVar.d);
        afVar.c(abVar.e);
        afVar.e(abVar.f);
        afVar.f(abVar.g);
        a(afVar);
    }

    public void a(com.baidu.tieba.frs.by byVar) {
        this.j = byVar;
    }

    public void a(com.baidu.tieba.frs.bx bxVar) {
        this.k = bxVar;
    }

    public int j() {
        return this.i;
    }

    public void a(int i) {
        this.i = i;
    }

    public com.baidu.tieba.data.d k() {
        return this.h;
    }

    public void a(com.baidu.tieba.data.d dVar) {
        this.h = dVar;
    }
}
