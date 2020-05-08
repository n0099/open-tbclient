package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    public String kLN;
    public String kLO;
    public String kLP;
    public ArrayList<e> kNU;
    public String logoUrl;

    public void parserJson(JSONObject jSONObject) throws JSONException {
        this.kLO = jSONObject.optString(ForumListActivityConfig.KEY_MENU_TYPE);
        this.kLN = jSONObject.optString("menu_name");
        this.kLP = jSONObject.optString("menu_id");
        this.logoUrl = jSONObject.optString("default_logo_url", null);
        this.logoUrl = this.logoUrl != null ? this.logoUrl + "?v=2" : null;
        if (jSONObject.has("child_menu_list")) {
            ArrayList<e> arrayList = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                e eVar = new e();
                eVar.parserJson(optJSONArray.getJSONObject(i));
                arrayList.add(eVar);
            }
            this.kNU = arrayList;
        }
    }
}
