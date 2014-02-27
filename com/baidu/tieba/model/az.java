package com.baidu.tieba.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class az {
    private int b = 0;
    private boolean c = false;
    private String d = null;
    private boolean e = false;
    private int f = 0;
    private ArrayList<ba> a = new ArrayList<>();

    public final void a(String str) {
        this.d = str;
    }

    public final String a() {
        return this.d;
    }

    public final int b() {
        return this.f;
    }

    public final void a(int i) {
        this.f = i;
    }

    public final boolean c() {
        return this.e;
    }

    public final ArrayList<ba> d() {
        return this.a;
    }

    public final void e() {
        this.a.clear();
        this.b = 0;
        this.c = false;
    }

    public final int f() {
        return this.b;
    }

    public final boolean g() {
        return this.c;
    }

    public final void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            if (this.d != null) {
                this.e = jSONObject.optInt("hide_post", 0) == 0;
            }
            ba baVar = null;
            int size = this.a.size();
            if (size > 0) {
                baVar = this.a.get(size - 1);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                ba baVar2 = baVar;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    ba baVar3 = new ba(this);
                    baVar3.b = optJSONObject.optString("time_shaft");
                    baVar3.a = optJSONObject.optInt("type", 0);
                    baVar3.c = optJSONObject.optString("title");
                    baVar3.d = optJSONObject.optString("reply_num");
                    baVar3.e = optJSONObject.optString("reply_time");
                    baVar3.f = optJSONObject.optString("fname");
                    baVar3.g = optJSONObject.optString("tid");
                    baVar3.h = optJSONObject.optString("pid");
                    baVar3.i = optJSONObject.optInt("is_floor", 0) == 1;
                    if (baVar2 != null && baVar3.b.equals(baVar2.b)) {
                        this.a.add(baVar3);
                    } else {
                        ba baVar4 = new ba(this);
                        baVar4.b = baVar3.b;
                        baVar4.a = 0;
                        this.a.add(baVar4);
                        this.a.add(baVar3);
                    }
                    i++;
                    baVar2 = baVar3;
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
            com.baidu.adp.lib.util.e.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
