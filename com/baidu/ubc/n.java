package com.baidu.ubc;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n {
    private int jwh;
    private String jwi;
    private JSONObject jwj;
    private List<h> jwk = new ArrayList();
    private int mThreshold;

    public n(String str, JSONObject jSONObject) {
        this.jwi = str;
        this.jwj = jSONObject;
    }

    public String csd() {
        return this.jwi;
    }

    public int getThreshold() {
        return this.mThreshold;
    }

    public int cse() {
        return this.jwh;
    }

    public List<h> csf() {
        return this.jwk;
    }

    public boolean csg() {
        try {
            JSONObject jSONObject = this.jwj;
            this.mThreshold = jSONObject.getInt("threshold");
            this.jwh = jSONObject.getInt("timeup");
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
                        hVar.BC(jSONObject2.getInt("rate"));
                    }
                    if (jSONObject2.has("c")) {
                        hVar.setCategory(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        hVar.BD(jSONObject2.getInt("limitUnit"));
                    }
                    if (jSONObject2.has("limitCnt")) {
                        hVar.BE(jSONObject2.getInt("limitCnt"));
                    }
                    if (jSONObject2.has("idtype")) {
                        hVar.EJ(jSONObject2.getString("idtype"));
                    }
                    this.jwk.add(hVar);
                }
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
