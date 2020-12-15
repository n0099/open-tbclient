package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class e {
    public String logoUrl;
    public String nfj;
    public String nfk;
    public String nfl;
    public ArrayList<e> nhp;

    public void parserJson(JSONObject jSONObject) throws JSONException {
        this.nfk = jSONObject.optString(ForumListActivityConfig.KEY_MENU_TYPE);
        this.nfj = jSONObject.optString("menu_name");
        this.nfl = jSONObject.optString("menu_id");
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
            this.nhp = arrayList;
        }
    }
}
