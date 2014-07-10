package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.data.a {
    private ArrayList<w> a = new ArrayList<>();

    public ArrayList<w> d() {
        return this.a;
    }

    public void a(ArrayList<w> arrayList) {
        this.a = arrayList;
        a((String) null);
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        ArrayList<w> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_dir");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                w wVar = new w();
                wVar.a(optJSONArray.getJSONObject(i));
                arrayList.add(wVar);
            }
        }
        a(arrayList);
    }
}
