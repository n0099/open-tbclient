package com.baidu.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class s {
    private boolean bqf = false;
    private JSONArray aFK = new JSONArray();
    private SparseArray<Integer> bqa = new SparseArray<>();
    private ArrayList<String> bqb = new ArrayList<>();
    private long bqc = 0;
    private long bqd = 0;
    private String bqe = "0";

    public final void aI(JSONObject jSONObject) {
        this.aFK.put(jSONObject);
    }

    public final SparseArray<Integer> Tv() {
        return this.bqa;
    }

    public final void P(int i, int i2) {
        this.bqa.put(i, Integer.valueOf(i2));
    }

    public final ArrayList Tw() {
        return this.bqb;
    }

    public final void jU(String str) {
        if (!this.bqb.contains(str)) {
            this.bqb.add(str);
        }
    }

    public final void g(long j, long j2) {
        if ((j < this.bqc || this.bqc == 0) && j != 0) {
            this.bqc = j;
        }
        if (j2 > this.bqd) {
            this.bqd = j2;
        }
    }

    public boolean fs(int i) {
        return this.aFK.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.aFK.length() == 0;
    }

    public JSONObject csi() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.aFK);
            if (this.bqc == 0 || this.bqd == 0) {
                this.bqc = this.bqd;
            }
            jSONObject2.put("mintime", Long.toString(this.bqc));
            jSONObject2.put("maxtime", Long.toString(this.bqd));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", com.baidu.f.c.toMd5(this.aFK.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.bqe);
            jSONObject.put("isreal", this.bqf ? "1" : "0");
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void clearData() {
        this.bqa.clear();
        this.bqb.clear();
        this.aFK = null;
    }

    public void jV(String str) {
        this.bqe = str;
    }

    public String Ty() {
        return this.bqe;
    }

    public long Tz() {
        return this.bqc;
    }

    public long TA() {
        return this.bqd;
    }

    public JSONArray TB() {
        return this.aFK;
    }

    public boolean TC() {
        return this.bqf;
    }

    public void cW(boolean z) {
        this.bqf = z;
    }
}
