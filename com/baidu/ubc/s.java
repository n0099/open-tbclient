package com.baidu.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class s {
    private boolean bxq = false;
    private JSONArray aIq = new JSONArray();
    private SparseArray<Integer> bxm = new SparseArray<>();
    private ArrayList<String> bxn = new ArrayList<>();
    private long bxo = 0;
    private long bxp = 0;
    private String bwn = "0";

    public final void aU(JSONObject jSONObject) {
        this.aIq.put(jSONObject);
    }

    public final SparseArray<Integer> Yq() {
        return this.bxm;
    }

    public final void Q(int i, int i2) {
        this.bxm.put(i, Integer.valueOf(i2));
    }

    public final ArrayList Yr() {
        return this.bxn;
    }

    public final void lb(String str) {
        if (!this.bxn.contains(str)) {
            this.bxn.add(str);
        }
    }

    public final void g(long j, long j2) {
        if ((j < this.bxo || this.bxo == 0) && j != 0) {
            this.bxo = j;
        }
        if (j2 > this.bxp) {
            this.bxp = j2;
        }
    }

    public boolean ge(int i) {
        return this.aIq.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.aIq.length() == 0;
    }

    public JSONObject cDf() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.aIq);
            if (this.bxo == 0 || this.bxp == 0) {
                this.bxo = this.bxp;
            }
            jSONObject2.put("mintime", Long.toString(this.bxo));
            jSONObject2.put("maxtime", Long.toString(this.bxp));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", com.baidu.f.c.toMd5(this.aIq.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.bwn);
            jSONObject.put("isreal", this.bxq ? "1" : "0");
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void clearData() {
        this.bxm.clear();
        this.bxn.clear();
        this.aIq = null;
    }

    public void lc(String str) {
        this.bwn = str;
    }

    public String Yt() {
        return this.bwn;
    }

    public long Yu() {
        return this.bxo;
    }

    public long Yv() {
        return this.bxp;
    }

    public JSONArray Yw() {
        return this.aIq;
    }

    public boolean Yx() {
        return this.bxq;
    }

    public void ds(boolean z) {
        this.bxq = z;
    }
}
