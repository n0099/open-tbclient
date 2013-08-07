package com.baidu.tieba.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ba {
    private int b = 0;
    private boolean c = false;
    private String d = null;
    private boolean e = false;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f1343a = new ArrayList();

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
        return this.f1343a;
    }

    public void d() {
        this.f1343a.clear();
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
            com.baidu.tieba.util.aj.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            if (this.d != null) {
                this.e = jSONObject.optInt("hide_post", 0) == 0;
            }
            bb bbVar = null;
            int size = this.f1343a.size();
            if (size > 0) {
                bbVar = (bb) this.f1343a.get(size - 1);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                bb bbVar2 = bbVar;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    bb bbVar3 = new bb(this);
                    bbVar3.b = optJSONObject.optString("time_shaft");
                    bbVar3.f1344a = optJSONObject.optInt("type", 0);
                    bbVar3.c = optJSONObject.optString("title");
                    bbVar3.d = optJSONObject.optString("reply_num");
                    bbVar3.e = optJSONObject.optString("reply_time");
                    bbVar3.f = optJSONObject.optString("fname");
                    bbVar3.g = optJSONObject.optString("tid");
                    bbVar3.h = optJSONObject.optString("pid");
                    bbVar3.i = optJSONObject.optInt("is_floor", 0) == 1;
                    if (bbVar2 != null && bbVar3.b.equals(bbVar2.b)) {
                        this.f1343a.add(bbVar3);
                    } else {
                        bb bbVar4 = new bb(this);
                        bbVar4.b = bbVar3.b;
                        bbVar4.f1344a = 0;
                        this.f1343a.add(bbVar4);
                        this.f1343a.add(bbVar3);
                    }
                    i++;
                    bbVar2 = bbVar3;
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
            com.baidu.tieba.util.aj.b("MyPostModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
