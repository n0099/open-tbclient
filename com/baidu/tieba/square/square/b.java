package com.baidu.tieba.square.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends com.baidu.tieba.square.data.a {
    private ArrayList<d> iBB = new ArrayList<>();

    public ArrayList<d> ccY() {
        return this.iBB;
    }

    public void az(ArrayList<d> arrayList) {
        this.iBB = arrayList;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void bE(JSONObject jSONObject) throws Exception {
        ArrayList<d> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_dir");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.parserJson(optJSONArray.getJSONObject(i));
                arrayList.add(dVar);
            }
        }
        az(arrayList);
    }
}
