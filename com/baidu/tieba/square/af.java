package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {
    private String a = null;
    private String b = null;
    private String c = "";
    private ArrayList<af> d = null;

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public ArrayList<af> d() {
        return this.d;
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    this.d = new ArrayList<>();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        af afVar = new af();
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        afVar.a = jSONObject.optString("title", "");
                        afVar.b = jSONObject.optString("link", "");
                        this.d.add(afVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parseForumListRecommendData", e.toString());
            }
        }
    }
}
