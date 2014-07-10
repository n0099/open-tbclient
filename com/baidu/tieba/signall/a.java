package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.ai;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
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
    private com.baidu.tieba.home.r o = new com.baidu.tieba.home.r();
    private int p;

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public String h() {
        return this.i;
    }

    public int i() {
        return this.j;
    }

    public ArrayList<b> j() {
        return this.k;
    }

    public com.baidu.tieba.home.r k() {
        return this.o;
    }

    public ArrayList<b> l() {
        return this.l;
    }

    public ArrayList<b> m() {
        return this.m;
    }

    public void a(o oVar) {
        ArrayList<p> d = oVar.d();
        int size = d.size();
        for (int i = 0; i < size; i++) {
            p pVar = d.get(i);
            String sb = new StringBuilder(String.valueOf(pVar.a())).toString();
            b bVar = this.n.get(sb);
            if (bVar != null) {
                if (pVar.b() != 0) {
                    this.n.remove(sb);
                    this.m.remove(bVar);
                    bVar.a(1);
                    bVar.b(pVar.c());
                    bVar.d(pVar.d());
                    bVar.a(true);
                    bVar.b(false);
                    bVar.c(false);
                    if (bVar.g() + bVar.m() >= bVar.h()) {
                        bVar.c(bVar.f() + 1);
                        bVar.e(true);
                    }
                    this.l.add(bVar);
                    ai.c().a(bVar.b(), bVar.m(), -1);
                } else {
                    bVar.a(false);
                    bVar.b(true);
                    bVar.c(false);
                    bVar.a(pVar.e().b());
                }
            }
        }
    }

    public void a(JSONObject jSONObject) {
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
                x.a = this.p;
                JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
                if (optJSONArray != null) {
                    int min = Math.min(optJSONArray.length(), x.a);
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
                                ai.c().a(bVar.b(), bVar.m(), -1);
                            }
                            this.k.add(bVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
