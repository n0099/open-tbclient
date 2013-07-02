package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    public String a;
    public String b;
    public String c;
    public String d;
    public ArrayList e;

    public void a(JSONObject jSONObject) {
        this.a = jSONObject.optString("menu_type");
        this.b = jSONObject.optString("menu_name");
        this.c = jSONObject.optString("menu_id");
        this.d = jSONObject.optString("default_logo_url", null);
        if (jSONObject.has("child_menu_list")) {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                q qVar = new q();
                qVar.a(optJSONArray.getJSONObject(i));
                arrayList.add(qVar);
            }
            this.e = arrayList;
        }
    }
}
