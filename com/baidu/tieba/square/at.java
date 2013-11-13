package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class at extends com.baidu.tieba.data.a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<as> f2389a = new ArrayList<>();
    private String b;

    public at() {
        this.b = null;
        this.b = "";
    }

    public ArrayList<as> d() {
        return this.f2389a;
    }

    public void a(ArrayList<as> arrayList) {
        this.f2389a = arrayList;
        a((String) null);
    }

    public String e() {
        return this.b;
    }

    @Override // com.baidu.tieba.data.a
    protected void a(JSONObject jSONObject) {
        ArrayList<as> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_browse");
        this.b = jSONObject.optString("forum_browse_title");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                as asVar = new as();
                asVar.a(optJSONArray.getJSONObject(i));
                arrayList.add(asVar);
            }
        }
        a(arrayList);
    }
}
