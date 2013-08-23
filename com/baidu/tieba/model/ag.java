package com.baidu.tieba.model;

import com.baidu.tieba.data.AntiData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.v f1359a = new com.baidu.tieba.data.v();
    private ArrayList b = new ArrayList();
    private ArrayList c = new ArrayList();
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private AntiData g = new AntiData();
    private com.baidu.tieba.data.al h = new com.baidu.tieba.data.al();

    public ArrayList a() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1359a.a(jSONObject.optJSONObject("forum"));
                this.h.a(jSONObject.optJSONObject("user"));
                this.g.parserJson(jSONObject.optJSONObject("anti"));
                JSONObject optJSONObject = jSONObject.optJSONObject("photo_data");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("thread_list");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            com.baidu.tieba.data.bi biVar = new com.baidu.tieba.data.bi();
                            biVar.a(optJSONArray.optJSONObject(i));
                            this.b.add(biVar);
                        }
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("alb_id_list");
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            this.c.add(optJSONArray2.optString(i2));
                        }
                    }
                    this.d = optJSONObject.optInt("has_more", 0);
                    this.e = optJSONObject.optInt("amount", 0);
                    this.f = optJSONObject.optInt("current_count", 0);
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
