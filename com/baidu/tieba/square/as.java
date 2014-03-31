package com.baidu.tieba.square;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class as extends com.baidu.tieba.data.a {
    private ArrayList<ar> a = new ArrayList<>();
    private String b;

    public as() {
        this.b = null;
        this.b = "";
    }

    public final ArrayList<ar> d() {
        return this.a;
    }

    public final String e() {
        return this.b;
    }

    @Override // com.baidu.tieba.data.a
    protected final void a(JSONObject jSONObject) {
        ArrayList<ar> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_browse");
        this.b = jSONObject.optString("forum_browse_title");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                ar arVar = new ar();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                arVar.b = jSONObject2.optString("title");
                arVar.c = jSONObject2.optString("sub_title");
                arVar.d = jSONObject2.optString("link");
                arVar.f = jSONObject2.optString("is_all", "0");
                arVar.e = jSONObject2.optString("pic_url", null);
                arVar.e = arVar.e != null ? String.valueOf(arVar.e) + "?v=2" : null;
                arrayList.add(arVar);
            }
        }
        this.a = arrayList;
        a((String) null);
    }
}
