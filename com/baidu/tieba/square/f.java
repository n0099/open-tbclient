package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.data.a {
    private ArrayList<q> bMc = new ArrayList<>();

    public ArrayList<q> adl() {
        return this.bMc;
    }

    public void I(ArrayList<q> arrayList) {
        this.bMc = arrayList;
        setErrorMsg(null);
    }

    @Override // com.baidu.tieba.data.a
    protected void e(JSONObject jSONObject) {
        ArrayList<q> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_dir");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                q qVar = new q();
                qVar.parserJson(optJSONArray.getJSONObject(i));
                arrayList.add(qVar);
            }
        }
        I(arrayList);
    }
}
