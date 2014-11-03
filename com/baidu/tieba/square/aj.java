package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aj extends com.baidu.tieba.data.a {
    private ArrayList<ai> bMr = new ArrayList<>();
    private String bNn;

    public aj() {
        this.bNn = null;
        this.bNn = "";
    }

    public ArrayList<ai> ado() {
        return this.bMr;
    }

    public void J(ArrayList<ai> arrayList) {
        this.bMr = arrayList;
        setErrorMsg(null);
    }

    public String adz() {
        return this.bNn;
    }

    @Override // com.baidu.tieba.data.a
    protected void e(JSONObject jSONObject) {
        ArrayList<ai> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_browse");
        this.bNn = jSONObject.optString("forum_browse_title");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                ai aiVar = new ai();
                aiVar.parserJson(optJSONArray.getJSONObject(i));
                arrayList.add(aiVar);
            }
        }
        J(arrayList);
    }
}
