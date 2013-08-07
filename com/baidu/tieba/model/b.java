package com.baidu.tieba.model;

import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f1342a = new ArrayList();
    private com.baidu.tieba.data.ar b = new com.baidu.tieba.data.ar();
    private Date c = null;
    private boolean d = true;

    public ArrayList a() {
        return this.f1342a;
    }

    public void a(ArrayList arrayList) {
        this.f1342a = arrayList;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.d = false;
            com.baidu.tieba.util.aj.b("BarlistModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.data.v vVar = new com.baidu.tieba.data.v();
                    vVar.a(optJSONArray.getJSONObject(i));
                    this.f1342a.add(vVar);
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
            com.baidu.tieba.util.aj.b("BarlistModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
