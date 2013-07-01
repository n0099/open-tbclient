package com.baidu.tieba.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bq {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f1046a = new ArrayList();

    public ArrayList a() {
        return this.f1046a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("BarlistModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("fname");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.f1046a.add(optJSONArray.getString(i));
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("BarlistModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
