package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class at {
    private ArrayList c;
    private int d = 0;

    /* renamed from: a  reason: collision with root package name */
    private UserData f1336a = new UserData();
    private AntiData b = new AntiData();

    public at() {
        this.c = null;
        this.c = new ArrayList();
        a(0);
    }

    public UserData a() {
        return this.f1336a;
    }

    public AntiData b() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b("LoginModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.f1336a.parserJson(jSONObject.optJSONObject("user"));
            this.b.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.c.add(optJSONArray.optString(i, null));
                }
            }
            a(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b("LoginModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public ArrayList c() {
        return this.c;
    }

    public void a(int i) {
        this.d = i;
    }

    public int d() {
        return this.d;
    }
}
