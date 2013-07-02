package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.data.a {
    private ArrayList b = new ArrayList();

    public ArrayList c() {
        return this.b;
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
        a((String) null);
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_dir");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                q qVar = new q();
                qVar.a(optJSONArray.getJSONObject(i));
                arrayList.add(qVar);
            }
        }
        a(arrayList);
    }
}
