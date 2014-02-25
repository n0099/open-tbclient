package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.data.a {
    private ArrayList<ab> a = new ArrayList<>();

    public ArrayList<ab> d() {
        return this.a;
    }

    public void a(ArrayList<ab> arrayList) {
        this.a = arrayList;
        a((String) null);
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        ArrayList<ab> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_dir");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                ab abVar = new ab();
                abVar.a(optJSONArray.getJSONObject(i));
                arrayList.add(abVar);
            }
        }
        a(arrayList);
    }
}
