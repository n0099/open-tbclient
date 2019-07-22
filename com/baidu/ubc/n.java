package com.baidu.ubc;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n {
    private String ayj;
    private int bwL;
    private JSONObject bwM;
    private List<h> bwN = new ArrayList();
    private int mThreshold;

    public n(String str, JSONObject jSONObject) {
        this.ayj = str;
        this.bwM = jSONObject;
    }

    public String getSign() {
        return this.ayj;
    }

    public int Yf() {
        return this.mThreshold;
    }

    public int Yg() {
        return this.bwL;
    }

    public List<h> Yh() {
        return this.bwN;
    }

    public boolean Yi() {
        try {
            JSONObject jSONObject = this.bwM;
            this.mThreshold = jSONObject.getInt("threshold");
            this.bwL = jSONObject.getInt("timeup");
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
                        hVar.fY(jSONObject2.getInt("rate"));
                    }
                    if (jSONObject2.has("c")) {
                        hVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        hVar.fZ(jSONObject2.getInt("limitUnit"));
                    }
                    if (jSONObject2.has("limitCnt")) {
                        hVar.ga(jSONObject2.getInt("limitCnt"));
                    }
                    if (jSONObject2.has("idtype")) {
                        hVar.kU(jSONObject2.getString("idtype"));
                    }
                    this.bwN.add(hVar);
                }
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
