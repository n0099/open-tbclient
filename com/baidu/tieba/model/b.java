package com.baidu.tieba.model;

import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private ArrayList a = new ArrayList();
    private com.baidu.tieba.data.ai b = new com.baidu.tieba.data.ai();
    private Date c = null;
    private boolean d = true;

    public ArrayList a() {
        return this.a;
    }

    public void a(ArrayList arrayList) {
        this.a = arrayList;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.d = false;
            com.baidu.tieba.util.z.b("BarlistModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
                    rVar.a(optJSONArray.getJSONObject(i));
                    this.a.add(rVar);
                }
            }
            this.b.a(jSONObject.optJSONObject("page"));
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.c = new Date(optLong);
            } else {
                this.c = new Date();
            }
        } catch (Exception e) {
            this.d = false;
            com.baidu.tieba.util.z.b("BarlistModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
