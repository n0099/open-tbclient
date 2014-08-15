package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private int a;
    private String b;
    private int c;
    private String d;
    private com.baidu.tieba.home.r e = new com.baidu.tieba.home.r();
    private ArrayList<s> f = new ArrayList<>();

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public com.baidu.tieba.home.r c() {
        return this.e;
    }

    public ArrayList<s> d() {
        return this.f;
    }

    public int e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }

    public void a(String str) {
        if (str != null) {
            try {
                a(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.e.a(jSONObject.optJSONObject("error"));
                this.a = jSONObject.optInt("show_dialog");
                this.b = jSONObject.optString("sign_notice");
                this.c = jSONObject.optInt("is_timeout");
                this.d = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        s sVar = new s();
                        sVar.a(jSONObject2);
                        this.f.add(sVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
