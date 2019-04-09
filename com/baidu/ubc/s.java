package com.baidu.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class s {
    private boolean bqk = false;
    private JSONArray aFP = new JSONArray();
    private SparseArray<Integer> bqf = new SparseArray<>();
    private ArrayList<String> bqg = new ArrayList<>();
    private long bqh = 0;
    private long bqi = 0;
    private String bqj = "0";

    public final void aI(JSONObject jSONObject) {
        this.aFP.put(jSONObject);
    }

    public final SparseArray<Integer> Tt() {
        return this.bqf;
    }

    public final void P(int i, int i2) {
        this.bqf.put(i, Integer.valueOf(i2));
    }

    public final ArrayList Tu() {
        return this.bqg;
    }

    public final void jV(String str) {
        if (!this.bqg.contains(str)) {
            this.bqg.add(str);
        }
    }

    public final void g(long j, long j2) {
        if ((j < this.bqh || this.bqh == 0) && j != 0) {
            this.bqh = j;
        }
        if (j2 > this.bqi) {
            this.bqi = j2;
        }
    }

    public boolean fr(int i) {
        return this.aFP.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.aFP.length() == 0;
    }

    public JSONObject csj() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.aFP);
            if (this.bqh == 0 || this.bqi == 0) {
                this.bqh = this.bqi;
            }
            jSONObject2.put("mintime", Long.toString(this.bqh));
            jSONObject2.put("maxtime", Long.toString(this.bqi));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", com.baidu.f.c.toMd5(this.aFP.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.bqj);
            jSONObject.put("isreal", this.bqk ? "1" : "0");
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void clearData() {
        this.bqf.clear();
        this.bqg.clear();
        this.aFP = null;
    }

    public void jW(String str) {
        this.bqj = str;
    }

    public String Tw() {
        return this.bqj;
    }

    public long Tx() {
        return this.bqh;
    }

    public long Ty() {
        return this.bqi;
    }

    public JSONArray Tz() {
        return this.aFP;
    }

    public boolean TA() {
        return this.bqk;
    }

    public void cW(boolean z) {
        this.bqk = z;
    }
}
