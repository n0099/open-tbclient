package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.data.a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<z> f2406a = new ArrayList<>();

    public ArrayList<z> d() {
        return this.f2406a;
    }

    public void a(ArrayList<z> arrayList) {
        this.f2406a = arrayList;
        a((String) null);
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        ArrayList<z> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_dir");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                z zVar = new z();
                zVar.a(optJSONArray.getJSONObject(i));
                arrayList.add(zVar);
            }
        }
        a(arrayList);
    }
}
