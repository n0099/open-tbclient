package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.data.a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<s> f1841a = new ArrayList<>();

    public ArrayList<s> d() {
        return this.f1841a;
    }

    public void a(ArrayList<s> arrayList) {
        this.f1841a = arrayList;
        a((String) null);
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        ArrayList<s> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_dir");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                s sVar = new s();
                sVar.a(optJSONArray.getJSONObject(i));
                arrayList.add(sVar);
            }
        }
        a(arrayList);
    }
}
