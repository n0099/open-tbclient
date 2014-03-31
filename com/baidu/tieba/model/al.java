package com.baidu.tieba.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class al {
    private com.baidu.tieba.data.ab c = new com.baidu.tieba.data.ab();
    private ArrayList<com.baidu.tieba.data.o> a = new ArrayList<>();
    private com.baidu.tbadk.core.data.l b = new com.baidu.tbadk.core.data.l();
    private boolean d = true;

    public final boolean a() {
        return this.d;
    }

    public final void a(ArrayList<com.baidu.tieba.data.o> arrayList) {
        this.a = arrayList;
    }

    public final ArrayList<com.baidu.tieba.data.o> b() {
        return this.a;
    }

    public final com.baidu.tbadk.core.data.l c() {
        return this.b;
    }

    public final void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.d = false;
            com.baidu.adp.lib.util.f.b("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    com.baidu.tieba.data.o oVar = new com.baidu.tieba.data.o();
                    oVar.a(optJSONArray2.optJSONObject(i));
                    this.a.add(oVar);
                }
            }
            this.c.a(jSONObject.optJSONObject("message"));
            this.b.a(jSONObject.optJSONObject("page"));
        } catch (Exception e) {
            this.d = false;
            com.baidu.adp.lib.util.f.b("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
