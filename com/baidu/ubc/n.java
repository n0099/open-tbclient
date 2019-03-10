package com.baidu.ubc;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n {
    private String jwA;
    private JSONObject jwB;
    private List<h> jwC = new ArrayList();
    private int jwz;
    private int mThreshold;

    public n(String str, JSONObject jSONObject) {
        this.jwA = str;
        this.jwB = jSONObject;
    }

    public String csc() {
        return this.jwA;
    }

    public int getThreshold() {
        return this.mThreshold;
    }

    public int csd() {
        return this.jwz;
    }

    public List<h> cse() {
        return this.jwC;
    }

    public boolean csf() {
        try {
            JSONObject jSONObject = this.jwB;
            this.mThreshold = jSONObject.getInt("threshold");
            this.jwz = jSONObject.getInt("timeup");
            JSONArray jSONArray = new JSONArray(jSONObject.getString("item"));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("id");
                String string2 = jSONObject2.getString("switch");
                String string3 = jSONObject2.getString("isreal");
                String string4 = jSONObject2.getString("isAbtest");
                int i2 = jSONObject2.getInt("timeout");
                String string5 = jSONObject2.getString("type");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string5)) {
                    h hVar = new h(string, string2, string3, i2, string5, string4);
                    if (jSONObject2.has("rate")) {
                        hVar.BG(jSONObject2.getInt("rate"));
                    }
                    if (jSONObject2.has("c")) {
                        hVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        hVar.BH(jSONObject2.getInt("limitUnit"));
                    }
                    if (jSONObject2.has("limitCnt")) {
                        hVar.BI(jSONObject2.getInt("limitCnt"));
                    }
                    if (jSONObject2.has("idtype")) {
                        hVar.EM(jSONObject2.getString("idtype"));
                    }
                    this.jwC.add(hVar);
                }
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
