package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public String logoUrl;
    public String nqs;
    public String nqt;
    public String nqu;
    public ArrayList<e> nsy;

    public void parserJson(JSONObject jSONObject) throws JSONException {
        this.nqt = jSONObject.optString(ForumListActivityConfig.KEY_MENU_TYPE);
        this.nqs = jSONObject.optString("menu_name");
        this.nqu = jSONObject.optString("menu_id");
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
            this.nsy = arrayList;
        }
    }
}
