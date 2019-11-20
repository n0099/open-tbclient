package com.baidu.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class s {
    private boolean bPD = false;
    private JSONArray bbK = new JSONArray();
    private SparseArray<Integer> bPz = new SparseArray<>();
    private ArrayList<String> bPA = new ArrayList<>();
    private long bPB = 0;
    private long bPC = 0;
    private String bOB = "0";

    public final void bt(JSONObject jSONObject) {
        this.bbK.put(jSONObject);
    }

    public final SparseArray<Integer> adi() {
        return this.bPz;
    }

    public final void U(int i, int i2) {
        this.bPz.put(i, Integer.valueOf(i2));
    }

    public final ArrayList adj() {
        return this.bPA;
    }

    public final void lF(String str) {
        if (!this.bPA.contains(str)) {
            this.bPA.add(str);
        }
    }

    public final void m(long j, long j2) {
        if ((j < this.bPB || this.bPB == 0) && j != 0) {
            this.bPB = j;
        }
        if (j2 > this.bPC) {
            this.bPC = j2;
        }
    }

    public boolean gZ(int i) {
        return this.bbK.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.bbK.length() == 0;
    }

    public JSONObject cAW() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.bbK);
            if (this.bPB == 0 || this.bPC == 0) {
                this.bPB = this.bPC;
            }
            jSONObject2.put("mintime", Long.toString(this.bPB));
            jSONObject2.put("maxtime", Long.toString(this.bPC));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", com.baidu.f.c.toMd5(this.bbK.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.bOB);
            jSONObject.put("isreal", this.bPD ? "1" : "0");
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void clearData() {
        this.bPz.clear();
        this.bPA.clear();
        this.bbK = null;
    }

    public void lG(String str) {
        this.bOB = str;
    }

    public String adl() {
        return this.bOB;
    }

    public long adm() {
        return this.bPB;
    }

    public long getMaxTime() {
        return this.bPC;
    }

    public JSONArray adn() {
        return this.bbK;
    }

    public boolean ado() {
        return this.bPD;
    }

    public void dJ(boolean z) {
        this.bPD = z;
    }
}
