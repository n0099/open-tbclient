package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class be {
    private ArrayList<String> c;
    private int d = 0;
    private UserData a = new UserData();
    private AntiData b = new AntiData();

    public be() {
        this.c = null;
        this.c = new ArrayList<>();
        a(0);
    }

    public UserData a() {
        return this.a;
    }

    public AntiData b() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("LoginData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.a.parserJson(jSONObject.optJSONObject("user"));
            this.b.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.c.add(optJSONArray.optString(i, null));
                }
            }
            a(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("LoginData", "parserJson", "error = " + e.getMessage());
        }
    }

    public ArrayList<String> c() {
        return this.c;
    }

    public void a(int i) {
        this.d = i;
    }

    public int d() {
        return this.d;
    }
}
