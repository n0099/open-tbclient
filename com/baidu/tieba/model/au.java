package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ForumData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {

    /* renamed from: a  reason: collision with root package name */
    private ForumData f1904a;
    private ArrayList<com.baidu.tieba.data.bg> b;
    private ArrayList<String> c;
    private int d;
    private int e;
    private int f;
    private AntiData g;
    private com.baidu.tieba.data.al h;
    private String i = null;
    private String j = null;
    private av k = null;
    private ax l = null;
    private com.baidu.tieba.frs.ax m = null;
    private com.baidu.tieba.frs.ax n = null;

    public au() {
        g();
    }

    private void g() {
        this.f1904a = new ForumData();
        this.b = new ArrayList<>();
        this.c = new ArrayList<>();
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = new AntiData();
        this.h = new com.baidu.tieba.data.al();
    }

    public ForumData a() {
        return this.f1904a;
    }

    public ArrayList<com.baidu.tieba.data.bg> b() {
        return this.b;
    }

    public ArrayList<String> c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public AntiData e() {
        return this.g;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                g();
                this.f1904a.parserJson(jSONObject.optJSONObject("forum"));
                this.h.a(jSONObject.optJSONObject("user"));
                this.g.parserJson(jSONObject.optJSONObject("anti"));
                JSONObject optJSONObject = jSONObject.optJSONObject("photo_data");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("thread_list");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            com.baidu.tieba.data.bg bgVar = new com.baidu.tieba.data.bg();
                            bgVar.a(optJSONArray.optJSONObject(i));
                            this.b.add(bgVar);
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

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
        }
    }

    public void a(int i) {
        if (this.k != null) {
            this.k.cancel();
        }
        this.k = new av(this, i);
        this.k.setPriority(3);
        this.k.execute(new Object[0]);
    }

    public void b(int i) {
        if (this.k == null && this.l == null) {
            this.l = new ax(this, i);
            this.l.setPriority(3);
            this.l.execute(new Object[0]);
        }
    }

    public void f() {
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        if (this.l != null) {
            this.l.cancel();
            this.l = null;
        }
    }

    public void a(String str, String str2) {
        this.i = str;
        this.j = str2;
    }

    public void a(com.baidu.tieba.frs.ax axVar) {
        this.m = axVar;
    }

    public void b(com.baidu.tieba.frs.ax axVar) {
        this.n = axVar;
    }
}
