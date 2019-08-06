package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {
    public String iZE;
    public String iZF;
    public String iZG;
    public ArrayList<d> jbR;
    public String logoUrl;

    public void parserJson(JSONObject jSONObject) throws JSONException {
        this.iZF = jSONObject.optString(ForumListActivityConfig.KEY_MENU_TYPE);
        this.iZE = jSONObject.optString("menu_name");
        this.iZG = jSONObject.optString("menu_id");
        this.logoUrl = jSONObject.optString("default_logo_url", null);
        this.logoUrl = this.logoUrl != null ? this.logoUrl + "?v=2" : null;
        if (jSONObject.has("child_menu_list")) {
            ArrayList<d> arrayList = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parserJson(optJSONArray.getJSONObject(i));
                arrayList.add(dVar);
            }
            this.jbR = arrayList;
        }
    }
}
