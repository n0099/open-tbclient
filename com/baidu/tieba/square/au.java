package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au extends com.baidu.tieba.data.a {
    private ArrayList<at> a = new ArrayList<>();
    private String b;

    public au() {
        this.b = null;
        this.b = "";
    }

    public ArrayList<at> d() {
        return this.a;
    }

    public void a(ArrayList<at> arrayList) {
        this.a = arrayList;
        a((String) null);
    }

    public String e() {
        return this.b;
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        ArrayList<at> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_browse");
        this.b = jSONObject.optString("forum_browse_title");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                at atVar = new at();
                atVar.a(optJSONArray.getJSONObject(i));
                arrayList.add(atVar);
            }
        }
        a(arrayList);
    }
}
