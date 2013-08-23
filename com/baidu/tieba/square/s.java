package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public String f1754a;
    public String b;
    public String c;
    public String d;
    public ArrayList e;

    public void a(JSONObject jSONObject) {
        this.f1754a = jSONObject.optString("menu_type");
        this.b = jSONObject.optString("menu_name");
        this.c = jSONObject.optString("menu_id");
        this.d = jSONObject.optString("default_logo_url", null);
        this.d = this.d != null ? String.valueOf(this.d) + "?v=2" : null;
        if (jSONObject.has("child_menu_list")) {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                s sVar = new s();
                sVar.a(optJSONArray.getJSONObject(i));
                arrayList.add(sVar);
            }
            this.e = arrayList;
        }
    }
}
