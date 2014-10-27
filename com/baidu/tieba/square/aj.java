package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aj extends com.baidu.tieba.data.a {
    private String bMY;
    private ArrayList<ai> bMc = new ArrayList<>();

    public aj() {
        this.bMY = null;
        this.bMY = "";
    }

    public ArrayList<ai> adl() {
        return this.bMc;
    }

    public void I(ArrayList<ai> arrayList) {
        this.bMc = arrayList;
        setErrorMsg(null);
    }

    public String adw() {
        return this.bMY;
    }

    @Override // com.baidu.tieba.data.a
    protected void e(JSONObject jSONObject) {
        ArrayList<ai> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_browse");
        this.bMY = jSONObject.optString("forum_browse_title");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                ai aiVar = new ai();
                aiVar.parserJson(optJSONArray.getJSONObject(i));
                arrayList.add(aiVar);
            }
        }
        I(arrayList);
    }
}
