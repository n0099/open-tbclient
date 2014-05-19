package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class as extends com.baidu.tieba.data.a {
    private ArrayList<ar> a = new ArrayList<>();
    private String b;

    public as() {
        this.b = null;
        this.b = "";
    }

    public ArrayList<ar> d() {
        return this.a;
    }

    public void a(ArrayList<ar> arrayList) {
        this.a = arrayList;
        a((String) null);
    }

    public String e() {
        return this.b;
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        ArrayList<ar> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_browse");
        this.b = jSONObject.optString("forum_browse_title");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                ar arVar = new ar();
                arVar.a(optJSONArray.getJSONObject(i));
                arrayList.add(arVar);
            }
        }
        a(arrayList);
    }
}
