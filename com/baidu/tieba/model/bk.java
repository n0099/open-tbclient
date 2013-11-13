package com.baidu.tieba.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bk {
    private int b = 0;
    private boolean c = false;
    private String d = null;
    private boolean e = false;
    private int f = 0;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<bl> f1913a = new ArrayList<>();

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

    public ArrayList<bl> d() {
        return this.f1913a;
    }

    public void e() {
        this.f1913a.clear();
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
            com.baidu.tieba.util.bg.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            if (this.d != null) {
                this.e = jSONObject.optInt("hide_post", 0) == 0;
            }
            bl blVar = null;
            int size = this.f1913a.size();
            if (size > 0) {
                blVar = this.f1913a.get(size - 1);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                bl blVar2 = blVar;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    bl blVar3 = new bl(this);
                    blVar3.b = optJSONObject.optString("time_shaft");
                    blVar3.f1914a = optJSONObject.optInt("type", 0);
                    blVar3.c = optJSONObject.optString("title");
                    blVar3.d = optJSONObject.optString("reply_num");
                    blVar3.e = optJSONObject.optString("reply_time");
                    blVar3.f = optJSONObject.optString("fname");
                    blVar3.g = optJSONObject.optString("tid");
                    blVar3.h = optJSONObject.optString("pid");
                    blVar3.i = optJSONObject.optInt("is_floor", 0) == 1;
                    if (blVar2 != null && blVar3.b.equals(blVar2.b)) {
                        this.f1913a.add(blVar3);
                    } else {
                        bl blVar4 = new bl(this);
                        blVar4.b = blVar3.b;
                        blVar4.f1914a = 0;
                        this.f1913a.add(blVar4);
                        this.f1913a.add(blVar3);
                    }
                    i++;
                    blVar2 = blVar3;
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
            com.baidu.tieba.util.bg.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
