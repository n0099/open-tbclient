package com.baidu.ubc;

import android.util.SparseArray;
import com.baidu.ar.parser.ARResourceKey;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class t {
    private boolean hTp = false;
    private JSONArray mDataArray = new JSONArray();
    private SparseArray<Integer> hTm = new SparseArray<>();
    private ArrayList<String> hTn = new ArrayList<>();
    private long hTo = 0;
    private long cXH = 0;
    private String hSP = "0";

    public final void ay(JSONObject jSONObject) {
        this.mDataArray.put(jSONObject);
    }

    public final SparseArray<Integer> bPS() {
        return this.hTm;
    }

    public final void ca(int i, int i2) {
        this.hTm.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bPT() {
        return this.hTn;
    }

    public final void xF(String str) {
        if (!this.hTn.contains(str)) {
            this.hTn.add(str);
        }
    }

    public final void o(long j, long j2) {
        if ((j < this.hTo || this.hTo == 0) && j != 0) {
            this.hTo = j;
        }
        if (j2 > this.cXH) {
            this.cXH = j2;
        }
    }

    public boolean wS(int i) {
        return this.mDataArray.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.mDataArray.length() == 0;
    }

    public JSONObject bPU() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.mDataArray);
            if (this.hTo == 0 || this.cXH == 0) {
                this.hTo = this.cXH;
            }
            jSONObject2.put("mintime", Long.toString(this.hTo));
            jSONObject2.put("maxtime", Long.toString(this.cXH));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(ARResourceKey.HTTP_AR_MD5, com.baidu.g.c.toMd5(this.mDataArray.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.hSP);
            jSONObject.put("isreal", this.hTp ? "1" : "0");
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void clearData() {
        this.hTm.clear();
        this.hTn.clear();
        this.mDataArray = null;
    }

    public void xG(String str) {
        this.hSP = str;
    }

    public String bPV() {
        return this.hSP;
    }

    public long bPW() {
        return this.hTo;
    }

    public long bPX() {
        return this.cXH;
    }

    public JSONArray bPY() {
        return this.mDataArray;
    }

    public boolean bPZ() {
        return this.hTp;
    }

    public void ow(boolean z) {
        this.hTp = z;
    }
}
