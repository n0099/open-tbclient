package com.baidu.tieba.square;

import com.baidu.cloudsdk.social.core.SocialConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class au extends com.baidu.tieba.data.a {
    private ArrayList<at> a = new ArrayList<>();
    private String b;

    public au() {
        this.b = null;
        this.b = "";
    }

    public final ArrayList<at> d() {
        return this.a;
    }

    public final String e() {
        return this.b;
    }

    @Override // com.baidu.tieba.data.a
    protected final void a(JSONObject jSONObject) {
        ArrayList<at> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_browse");
        this.b = jSONObject.optString("forum_browse_title");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                at atVar = new at();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                atVar.b = jSONObject2.optString("title");
                atVar.c = jSONObject2.optString("sub_title");
                atVar.d = jSONObject2.optString("link");
                atVar.f = jSONObject2.optString("is_all", SocialConstants.FALSE);
                atVar.e = jSONObject2.optString("pic_url", null);
                atVar.e = atVar.e != null ? String.valueOf(atVar.e) + "?v=2" : null;
                arrayList.add(atVar);
            }
        }
        this.a = arrayList;
        a((String) null);
    }
}
