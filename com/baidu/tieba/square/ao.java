package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ao extends com.baidu.tieba.data.a {
    private ArrayList<an> a = new ArrayList<>();
    private String b;

    public ao() {
        this.b = null;
        this.b = "";
    }

    public ArrayList<an> d() {
        return this.a;
    }

    public void a(ArrayList<an> arrayList) {
        this.a = arrayList;
        a((String) null);
    }

    public String e() {
        return this.b;
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        ArrayList<an> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_browse");
        this.b = jSONObject.optString("forum_browse_title");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                an anVar = new an();
                anVar.a(optJSONArray.getJSONObject(i));
                arrayList.add(anVar);
            }
        }
        a(arrayList);
    }
}
