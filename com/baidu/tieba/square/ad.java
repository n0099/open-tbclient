package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ad {

    /* renamed from: a  reason: collision with root package name */
    private String f2357a = null;
    private String b = null;
    private String c = "";
    private ArrayList<ad> d = null;

    public String a() {
        return this.f2357a;
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

    public ArrayList<ad> d() {
        return this.d;
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    this.d = new ArrayList<>();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        ad adVar = new ad();
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        adVar.f2357a = jSONObject.optString("title", "");
                        adVar.b = jSONObject.optString("link", "");
                        this.d.add(adVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.bg.b(getClass().getName(), "parseForumListRecommendData", e.toString());
            }
        }
    }
}
