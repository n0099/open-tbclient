package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class at {
    private UserData a = new UserData();
    private AntiData b = new AntiData();
    private ArrayList<String> c;
    private int d;

    public at() {
        this.c = null;
        this.d = 0;
        this.c = new ArrayList<>();
        this.d = 0;
    }

    public final UserData a() {
        return this.a;
    }

    public final AntiData b() {
        return this.b;
    }

    public final void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("LoginData", "parserJson", "error = " + e.getMessage());
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            this.a.parserJson(jSONObject.optJSONObject("user"));
            this.b.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.c.add(optJSONArray.optString(i, null));
                }
            }
            this.d = jSONObject.optInt("retrytime");
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("LoginData", "parserJson", "error = " + e.getMessage());
        }
    }

    public final ArrayList<String> c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }
}
