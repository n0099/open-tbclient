package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    public String auZ;
    public String ava;
    public String avb;
    public String bMt;
    public ArrayList<q> bMu;

    public void parserJson(JSONObject jSONObject) {
        this.ava = jSONObject.optString("menu_type");
        this.auZ = jSONObject.optString("menu_name");
        this.avb = jSONObject.optString("menu_id");
        this.bMt = jSONObject.optString("default_logo_url", null);
        this.bMt = this.bMt != null ? String.valueOf(this.bMt) + "?v=2" : null;
        if (jSONObject.has("child_menu_list")) {
            ArrayList<q> arrayList = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                q qVar = new q();
                qVar.parserJson(optJSONArray.getJSONObject(i));
                arrayList.add(qVar);
            }
            this.bMu = arrayList;
        }
    }
}
