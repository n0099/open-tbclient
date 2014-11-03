package com.baidu.tieba.square;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private String title = null;
    private String link = null;
    private String WC = "";
    private ArrayList<u> bii = null;

    public String getTitle() {
        return this.title;
    }

    public String getLink() {
        return this.link;
    }

    public String adt() {
        return this.WC;
    }

    public void hs(String str) {
        this.WC = str;
    }

    public ArrayList<u> sG() {
        return this.bii;
    }

    public void b(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    this.bii = new ArrayList<>();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        u uVar = new u();
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        uVar.title = jSONObject.optString("title", "");
                        uVar.link = jSONObject.optString("link", "");
                        this.bii.add(uVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
