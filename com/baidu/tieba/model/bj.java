package com.baidu.tieba.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bj {
    private int b = 0;
    private boolean c = false;
    private String d = null;
    private boolean e = false;
    private int f = 0;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<bk> f1917a = new ArrayList<>();

    public void a(String str) {
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    public int b() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public boolean c() {
        return this.e;
    }

    public ArrayList<bk> d() {
        return this.f1917a;
    }

    public void e() {
        this.f1917a.clear();
        this.b = 0;
        this.c = false;
    }

    public int f() {
        return this.b;
    }

    public boolean g() {
        return this.c;
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            if (this.d != null) {
                this.e = jSONObject.optInt("hide_post", 0) == 0;
            }
            bk bkVar = null;
            int size = this.f1917a.size();
            if (size > 0) {
                bkVar = this.f1917a.get(size - 1);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                bk bkVar2 = bkVar;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    bk bkVar3 = new bk(this);
                    bkVar3.b = optJSONObject.optString("time_shaft");
                    bkVar3.f1918a = optJSONObject.optInt("type", 0);
                    bkVar3.c = optJSONObject.optString("title");
                    bkVar3.d = optJSONObject.optString("reply_num");
                    bkVar3.e = optJSONObject.optString("reply_time");
                    bkVar3.f = optJSONObject.optString("fname");
                    bkVar3.g = optJSONObject.optString("tid");
                    bkVar3.h = optJSONObject.optString("pid");
                    bkVar3.i = optJSONObject.optInt("is_floor", 0) == 1;
                    if (bkVar2 != null && bkVar3.b.equals(bkVar2.b)) {
                        this.f1917a.add(bkVar3);
                    } else {
                        bk bkVar4 = new bk(this);
                        bkVar4.b = bkVar3.b;
                        bkVar4.f1918a = 0;
                        this.f1917a.add(bkVar4);
                        this.f1917a.add(bkVar3);
                    }
                    i++;
                    bkVar2 = bkVar3;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("page");
                int optInt = jSONObject2.optInt("current_page", 0);
                if (optInt > this.b) {
                    this.b = optInt;
                    this.c = jSONObject2.optInt("has_more", 0) == 1;
                    return;
                }
                return;
            }
            this.c = false;
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
