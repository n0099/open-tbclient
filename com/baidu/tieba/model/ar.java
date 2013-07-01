package com.baidu.tieba.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ar {
    private int b = 0;
    private boolean c = false;
    private String d = null;
    private boolean e = false;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f1023a = new ArrayList();

    public void a(String str) {
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    public boolean b() {
        return this.e;
    }

    public ArrayList c() {
        return this.f1023a;
    }

    public void d() {
        this.f1023a.clear();
        this.b = 0;
        this.c = false;
    }

    public int e() {
        return this.b;
    }

    public boolean f() {
        return this.c;
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            if (this.d != null) {
                this.e = jSONObject.optInt("hide_post", 0) == 0;
            }
            as asVar = null;
            int size = this.f1023a.size();
            if (size > 0) {
                asVar = (as) this.f1023a.get(size - 1);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                as asVar2 = asVar;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    as asVar3 = new as(this);
                    asVar3.b = optJSONObject.optString("time_shaft");
                    asVar3.f1024a = optJSONObject.optInt("type", 0);
                    asVar3.c = optJSONObject.optString("title");
                    asVar3.d = optJSONObject.optString("reply_num");
                    asVar3.e = optJSONObject.optString("reply_time");
                    asVar3.f = optJSONObject.optString("fname");
                    asVar3.g = optJSONObject.optString("tid");
                    asVar3.h = optJSONObject.optString("pid");
                    asVar3.i = optJSONObject.optInt("is_floor", 0) == 1;
                    if (asVar2 != null && asVar3.b.equals(asVar2.b)) {
                        this.f1023a.add(asVar3);
                    } else {
                        as asVar4 = new as(this);
                        asVar4.b = asVar3.b;
                        asVar4.f1024a = 0;
                        this.f1023a.add(asVar4);
                        this.f1023a.add(asVar3);
                    }
                    i++;
                    asVar2 = asVar3;
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
            com.baidu.tieba.util.z.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
