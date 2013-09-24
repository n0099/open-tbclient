package com.baidu.tieba.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bb {
    private int b = 0;
    private boolean c = false;
    private String d = null;
    private boolean e = false;
    private int f = 0;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<bc> f1414a = new ArrayList<>();

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

    public ArrayList<bc> d() {
        return this.f1414a;
    }

    public void e() {
        this.f1414a.clear();
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
            com.baidu.tieba.util.av.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            if (this.d != null) {
                this.e = jSONObject.optInt("hide_post", 0) == 0;
            }
            bc bcVar = null;
            int size = this.f1414a.size();
            if (size > 0) {
                bcVar = this.f1414a.get(size - 1);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                bc bcVar2 = bcVar;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    bc bcVar3 = new bc(this);
                    bcVar3.b = optJSONObject.optString("time_shaft");
                    bcVar3.f1415a = optJSONObject.optInt("type", 0);
                    bcVar3.c = optJSONObject.optString("title");
                    bcVar3.d = optJSONObject.optString("reply_num");
                    bcVar3.e = optJSONObject.optString("reply_time");
                    bcVar3.f = optJSONObject.optString("fname");
                    bcVar3.g = optJSONObject.optString("tid");
                    bcVar3.h = optJSONObject.optString("pid");
                    bcVar3.i = optJSONObject.optInt("is_floor", 0) == 1;
                    if (bcVar2 != null && bcVar3.b.equals(bcVar2.b)) {
                        this.f1414a.add(bcVar3);
                    } else {
                        bc bcVar4 = new bc(this);
                        bcVar4.b = bcVar3.b;
                        bcVar4.f1415a = 0;
                        this.f1414a.add(bcVar4);
                        this.f1414a.add(bcVar3);
                    }
                    i++;
                    bcVar2 = bcVar3;
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
            com.baidu.tieba.util.av.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
