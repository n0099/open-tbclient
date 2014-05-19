package com.baidu.tieba.model;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class al {
    private com.baidu.tieba.data.ab c = new com.baidu.tieba.data.ab();
    private ArrayList<com.baidu.tieba.data.o> a = new ArrayList<>();
    private com.baidu.tbadk.core.data.m b = new com.baidu.tbadk.core.data.m();
    private boolean d = true;

    public boolean a() {
        return this.d;
    }

    public void a(ArrayList<com.baidu.tieba.data.o> arrayList) {
        this.a = arrayList;
    }

    public ArrayList<com.baidu.tieba.data.o> b() {
        return this.a;
    }

    public com.baidu.tbadk.core.data.m c() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.d = false;
            BdLog.e("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
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
            BdLog.e("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
