package com.baidu.ubc;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n {
    private String axC;
    private int bvV;
    private JSONObject bvW;
    private List<h> bvX = new ArrayList();
    private int mThreshold;

    public n(String str, JSONObject jSONObject) {
        this.axC = str;
        this.bvW = jSONObject;
    }

    public String getSign() {
        return this.axC;
    }

    public int getThreshold() {
        return this.mThreshold;
    }

    public int Xk() {
        return this.bvV;
    }

    public List<h> Xl() {
        return this.bvX;
    }

    public boolean Xm() {
        try {
            JSONObject jSONObject = this.bvW;
            this.mThreshold = jSONObject.getInt("threshold");
            this.bvV = jSONObject.getInt("timeup");
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
                        hVar.fU(jSONObject2.getInt("rate"));
                    }
                    if (jSONObject2.has("c")) {
                        hVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        hVar.fV(jSONObject2.getInt("limitUnit"));
                    }
                    if (jSONObject2.has("limitCnt")) {
                        hVar.fW(jSONObject2.getInt("limitCnt"));
                    }
                    if (jSONObject2.has("idtype")) {
                        hVar.kM(jSONObject2.getString("idtype"));
                    }
                    this.bvX.add(hVar);
                }
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
