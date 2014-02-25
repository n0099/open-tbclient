package com.baidu.tieba.model;

import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ay {
    private com.baidu.tieba.data.ai c = new com.baidu.tieba.data.ai();
    private ArrayList<com.baidu.tieba.data.t> a = new ArrayList<>();
    private com.baidu.tieba.data.al b = new com.baidu.tieba.data.al();
    private boolean d = true;

    public boolean a() {
        return this.d;
    }

    public void a(ArrayList<com.baidu.tieba.data.t> arrayList) {
        this.a = arrayList;
    }

    public ArrayList<com.baidu.tieba.data.t> b() {
        return this.a;
    }

    public com.baidu.tieba.data.al c() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.d = false;
            com.baidu.adp.lib.util.f.b("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    com.baidu.tieba.data.t tVar = new com.baidu.tieba.data.t();
                    tVar.a(optJSONArray2.optJSONObject(i));
                    this.a.add(tVar);
                }
            }
            this.c.a(jSONObject.optJSONObject(PushConstants.EXTRA_PUSH_MESSAGE));
            this.b.a(jSONObject.optJSONObject("page"));
        } catch (Exception e) {
            this.d = false;
            com.baidu.adp.lib.util.f.b("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
