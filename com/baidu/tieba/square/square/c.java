package com.baidu.tieba.square.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.tieba.square.data.a {
    private ArrayList<e> nmT = new ArrayList<>();

    public ArrayList<e> dNF() {
        return this.nmT;
    }

    public void bj(ArrayList<e> arrayList) {
        this.nmT = arrayList;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.square.data.a
    protected void eJ(JSONObject jSONObject) throws Exception {
        ArrayList<e> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_dir");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                e eVar = new e();
                eVar.parserJson(optJSONArray.getJSONObject(i));
                arrayList.add(eVar);
            }
        }
        bj(arrayList);
    }
}
