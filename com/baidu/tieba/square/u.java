package com.baidu.tieba.square;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private String title = null;
    private String link = null;
    private String Wy = "";
    private ArrayList<u> bhS = null;

    public String getTitle() {
        return this.title;
    }

    public String getLink() {
        return this.link;
    }

    public String adq() {
        return this.Wy;
    }

    public void hs(String str) {
        this.Wy = str;
    }

    public ArrayList<u> sE() {
        return this.bhS;
    }

    public void b(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    this.bhS = new ArrayList<>();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        u uVar = new u();
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        uVar.title = jSONObject.optString("title", "");
                        uVar.link = jSONObject.optString("link", "");
                        this.bhS.add(uVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
