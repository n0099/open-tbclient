package com.baidu.tieba.square.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.tieba.square.data.a {
    private ArrayList<e> kba = new ArrayList<>();

    public ArrayList<e> cIb() {
        return this.kba;
    }

    public void aR(ArrayList<e> arrayList) {
        this.kba = arrayList;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void dg(JSONObject jSONObject) throws Exception {
        ArrayList<e> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_dir");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                e eVar = new e();
                eVar.parserJson(optJSONArray.getJSONObject(i));
                arrayList.add(eVar);
            }
        }
        aR(arrayList);
    }
}
