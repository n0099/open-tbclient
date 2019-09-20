package com.baidu.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class s {
    private boolean bxO = false;
    private JSONArray aIO = new JSONArray();
    private SparseArray<Integer> bxK = new SparseArray<>();
    private ArrayList<String> bxL = new ArrayList<>();
    private long bxM = 0;
    private long bxN = 0;
    private String bwL = "0";

    public final void aU(JSONObject jSONObject) {
        this.aIO.put(jSONObject);
    }

    public final SparseArray<Integer> Yu() {
        return this.bxK;
    }

    public final void Q(int i, int i2) {
        this.bxK.put(i, Integer.valueOf(i2));
    }

    public final ArrayList Yv() {
        return this.bxL;
    }

    public final void ld(String str) {
        if (!this.bxL.contains(str)) {
            this.bxL.add(str);
        }
    }

    public final void g(long j, long j2) {
        if ((j < this.bxM || this.bxM == 0) && j != 0) {
            this.bxM = j;
        }
        if (j2 > this.bxN) {
            this.bxN = j2;
        }
    }

    public boolean gf(int i) {
        return this.aIO.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.aIO.length() == 0;
    }

    public JSONObject cEo() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.aIO);
            if (this.bxM == 0 || this.bxN == 0) {
                this.bxM = this.bxN;
            }
            jSONObject2.put("mintime", Long.toString(this.bxM));
            jSONObject2.put("maxtime", Long.toString(this.bxN));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", com.baidu.f.c.toMd5(this.aIO.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.bwL);
            jSONObject.put("isreal", this.bxO ? "1" : "0");
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void clearData() {
        this.bxK.clear();
        this.bxL.clear();
        this.aIO = null;
    }

    public void le(String str) {
        this.bwL = str;
    }

    public String Yx() {
        return this.bwL;
    }

    public long Yy() {
        return this.bxM;
    }

    public long Yz() {
        return this.bxN;
    }

    public JSONArray YA() {
        return this.aIO;
    }

    public boolean YB() {
        return this.bxO;
    }

    public void ds(boolean z) {
        this.bxO = z;
    }
}
