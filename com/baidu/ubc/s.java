package com.baidu.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class s {
    private boolean bwz = false;
    private JSONArray aHI = new JSONArray();
    private SparseArray<Integer> bwv = new SparseArray<>();
    private ArrayList<String> bww = new ArrayList<>();
    private long bwx = 0;
    private long bwy = 0;
    private String bvx = "0";

    public final void aU(JSONObject jSONObject) {
        this.aHI.put(jSONObject);
    }

    public final SparseArray<Integer> Xu() {
        return this.bwv;
    }

    public final void N(int i, int i2) {
        this.bwv.put(i, Integer.valueOf(i2));
    }

    public final ArrayList Xv() {
        return this.bww;
    }

    public final void kU(String str) {
        if (!this.bww.contains(str)) {
            this.bww.add(str);
        }
    }

    public final void g(long j, long j2) {
        if ((j < this.bwx || this.bwx == 0) && j != 0) {
            this.bwx = j;
        }
        if (j2 > this.bwy) {
            this.bwy = j2;
        }
    }

    public boolean ga(int i) {
        return this.aHI.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.aHI.length() == 0;
    }

    public JSONObject cAi() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.aHI);
            if (this.bwx == 0 || this.bwy == 0) {
                this.bwx = this.bwy;
            }
            jSONObject2.put("mintime", Long.toString(this.bwx));
            jSONObject2.put("maxtime", Long.toString(this.bwy));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", com.baidu.f.c.toMd5(this.aHI.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.bvx);
            jSONObject.put("isreal", this.bwz ? "1" : "0");
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void clearData() {
        this.bwv.clear();
        this.bww.clear();
        this.aHI = null;
    }

    public void kV(String str) {
        this.bvx = str;
    }

    public String Xx() {
        return this.bvx;
    }

    public long Xy() {
        return this.bwx;
    }

    public long Xz() {
        return this.bwy;
    }

    public JSONArray XA() {
        return this.aHI;
    }

    public boolean XB() {
        return this.bwz;
    }

    public void dn(boolean z) {
        this.bwz = z;
    }
}
