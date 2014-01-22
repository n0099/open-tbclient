package com.baidu.tieba.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class cg {
    private ArrayList<String> a = new ArrayList<>();

    public ArrayList<String> a() {
        return this.a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("BarlistModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("fname");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.a.add(optJSONArray.getString(i));
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("BarlistModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
