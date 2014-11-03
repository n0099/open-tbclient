package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    public String avi;
    public String avj;
    public String avk;
    public String bMI;
    public ArrayList<q> bMJ;

    public void parserJson(JSONObject jSONObject) {
        this.avj = jSONObject.optString("menu_type");
        this.avi = jSONObject.optString("menu_name");
        this.avk = jSONObject.optString("menu_id");
        this.bMI = jSONObject.optString("default_logo_url", null);
        this.bMI = this.bMI != null ? String.valueOf(this.bMI) + "?v=2" : null;
        if (jSONObject.has("child_menu_list")) {
            ArrayList<q> arrayList = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                q qVar = new q();
                qVar.parserJson(optJSONArray.getJSONObject(i));
                arrayList.add(qVar);
            }
            this.bMJ = arrayList;
        }
    }
}
