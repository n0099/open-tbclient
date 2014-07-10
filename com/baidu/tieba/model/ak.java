package com.baidu.tieba.model;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ak {
    private com.baidu.tieba.data.ad c = new com.baidu.tieba.data.ad();
    private ArrayList<com.baidu.tieba.data.p> a = new ArrayList<>();
    private com.baidu.tbadk.core.data.k b = new com.baidu.tbadk.core.data.k();
    private boolean d = true;

    public boolean a() {
        return this.d;
    }

    public void a(ArrayList<com.baidu.tieba.data.p> arrayList) {
        this.a = arrayList;
    }

    public ArrayList<com.baidu.tieba.data.p> b() {
        return this.a;
    }

    public com.baidu.tbadk.core.data.k c() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.d = false;
            BdLog.e(e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    com.baidu.tieba.data.p pVar = new com.baidu.tieba.data.p();
                    pVar.a(optJSONArray2.optJSONObject(i));
                    this.a.add(pVar);
                }
            }
            this.c.a(jSONObject.optJSONObject("message"));
            this.b.a(jSONObject.optJSONObject("page"));
        } catch (Exception e) {
            this.d = false;
            BdLog.e(e.getMessage());
        }
    }
}
