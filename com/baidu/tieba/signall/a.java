package com.baidu.tieba.signall;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;
    private String i;
    private int j;
    private ArrayList<b> k = new ArrayList<>();
    private ArrayList<b> l = new ArrayList<>();
    private ArrayList<b> m = new ArrayList<>();
    private HashMap<String, b> n = new HashMap<>();
    private com.baidu.tieba.home.q o = new com.baidu.tieba.home.q();
    private int p;

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.f;
    }

    public final String f() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }

    public final String h() {
        return this.i;
    }

    public final int i() {
        return this.j;
    }

    public final ArrayList<b> j() {
        return this.k;
    }

    public final com.baidu.tieba.home.q k() {
        return this.o;
    }

    public final ArrayList<b> l() {
        return this.l;
    }

    public final ArrayList<b> m() {
        return this.m;
    }

    public final void a(p pVar) {
        ArrayList<q> d = pVar.d();
        int size = d.size();
        for (int i = 0; i < size; i++) {
            q qVar = d.get(i);
            String sb = new StringBuilder(String.valueOf(qVar.a())).toString();
            b bVar = this.n.get(sb);
            if (bVar != null) {
                if (qVar.b() != 0) {
                    this.n.remove(sb);
                    this.m.remove(bVar);
                    bVar.a(1);
                    bVar.b(qVar.c());
                    bVar.d(qVar.d());
                    bVar.a(true);
                    bVar.b(false);
                    bVar.c(false);
                    if (bVar.g() + bVar.m() >= bVar.h()) {
                        bVar.c(bVar.f() + 1);
                        bVar.e(true);
                    }
                    this.l.add(bVar);
                    com.baidu.tieba.p.c().a(bVar.b(), bVar.m(), -1);
                } else {
                    bVar.a(false);
                    bVar.b(true);
                    bVar.c(false);
                    bVar.a(qVar.e().b());
                }
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.o.a(jSONObject.optJSONObject("error"));
                this.a = jSONObject.optInt("level");
                this.b = jSONObject.optString("title");
                this.c = jSONObject.optString("text_pre");
                this.d = jSONObject.optString("text_color");
                this.e = jSONObject.optString("text_mid");
                this.f = jSONObject.optString("text_suf");
                this.g = jSONObject.optString("num_notice");
                this.h = jSONObject.optInt("show_dialog");
                this.i = jSONObject.optString("sign_notice");
                this.j = jSONObject.optInt("valid");
                this.p = jSONObject.optInt("sign_max_num");
                y.a = this.p;
                JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
                if (optJSONArray != null) {
                    int min = Math.min(optJSONArray.length(), y.a);
                    for (int i = 0; i < min; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            b bVar = new b();
                            bVar.a(jSONObject2);
                            if (bVar.d() == 0) {
                                if (this.j == 0) {
                                    bVar.b(true);
                                }
                                this.m.add(bVar);
                                this.n.put(new StringBuilder(String.valueOf(bVar.a())).toString(), bVar);
                            } else {
                                this.l.add(bVar);
                                com.baidu.tieba.p.c().a(bVar.b(), bVar.m(), -1);
                            }
                            this.k.add(bVar);
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
