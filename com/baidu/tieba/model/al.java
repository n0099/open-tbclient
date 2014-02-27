package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ForumData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class al {
    private ForumData a;
    private ArrayList<com.baidu.tieba.data.ba> b;
    private ArrayList<String> c;
    private int d;
    private int e;
    private int f;
    private AntiData g;
    private com.baidu.tieba.data.aj h;
    private String i = null;
    private String j = null;
    private am k = null;
    private ao l = null;
    private com.baidu.tieba.frs.bo m = null;
    private com.baidu.tieba.frs.bo n = null;

    public al() {
        h();
    }

    private void h() {
        this.a = new ForumData();
        this.b = new ArrayList<>();
        this.c = new ArrayList<>();
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = new AntiData();
        this.h = new com.baidu.tieba.data.aj();
    }

    public final com.baidu.tieba.data.aj a() {
        return this.h;
    }

    public final ForumData b() {
        return this.a;
    }

    public final ArrayList<com.baidu.tieba.data.ba> c() {
        return this.b;
    }

    public final ArrayList<String> d() {
        return this.c;
    }

    public final int e() {
        return this.d;
    }

    public final AntiData f() {
        return this.g;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                h();
                this.a.parserJson(jSONObject.optJSONObject("forum"));
                this.h.a(jSONObject.optJSONObject("user"));
                this.g.parserJson(jSONObject.optJSONObject("anti"));
                JSONObject optJSONObject = jSONObject.optJSONObject("photo_data");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("thread_list");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            com.baidu.tieba.data.ba baVar = new com.baidu.tieba.data.ba();
                            baVar.a(optJSONArray.optJSONObject(i));
                            this.b.add(baVar);
                        }
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("alb_id_list");
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            this.c.add(optJSONArray2.optString(i2));
                        }
                    }
                    this.d = optJSONObject.optInt("has_more", 0);
                    this.e = optJSONObject.optInt("amount", 0);
                    this.f = optJSONObject.optInt("current_count", 0);
                }
            } catch (Exception e) {
            }
        }
    }

    public final void a(int i) {
        if (this.k != null) {
            this.k.cancel();
        }
        this.k = new am(this, i);
        this.k.setPriority(3);
        this.k.execute(new Object[0]);
    }

    public final void b(int i) {
        if (this.k == null && this.l == null) {
            this.l = new ao(this, i);
            this.l.setPriority(3);
            this.l.execute(new Object[0]);
        }
    }

    public final void g() {
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        if (this.l != null) {
            this.l.cancel();
            this.l = null;
        }
    }

    public final void a(String str, String str2) {
        this.i = str;
        this.j = str2;
    }

    public final void a(com.baidu.tieba.frs.bo boVar) {
        this.m = boVar;
    }

    public final void b(com.baidu.tieba.frs.bo boVar) {
        this.n = boVar;
    }
}
