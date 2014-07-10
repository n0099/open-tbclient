package com.baidu.tieba.square;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {
    private String a = null;
    private String b = null;
    private String c = "";
    private ArrayList<aa> d = null;

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public ArrayList<aa> d() {
        return this.d;
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    this.d = new ArrayList<>();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        aa aaVar = new aa();
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        aaVar.a = jSONObject.optString("title", "");
                        aaVar.b = jSONObject.optString("link", "");
                        this.d.add(aaVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
