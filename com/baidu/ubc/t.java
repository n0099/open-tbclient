package com.baidu.ubc;

import android.util.SparseArray;
import com.baidu.ar.parser.ARResourceKey;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class t {
    private boolean hTq = false;
    private JSONArray mDataArray = new JSONArray();
    private SparseArray<Integer> hTn = new SparseArray<>();
    private ArrayList<String> hTo = new ArrayList<>();
    private long hTp = 0;
    private long cXH = 0;
    private String hSQ = "0";

    public final void ay(JSONObject jSONObject) {
        this.mDataArray.put(jSONObject);
    }

    public final SparseArray<Integer> bPS() {
        return this.hTn;
    }

    public final void ca(int i, int i2) {
        this.hTn.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bPT() {
        return this.hTo;
    }

    public final void xF(String str) {
        if (!this.hTo.contains(str)) {
            this.hTo.add(str);
        }
    }

    public final void o(long j, long j2) {
        if ((j < this.hTp || this.hTp == 0) && j != 0) {
            this.hTp = j;
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
            if (this.hTp == 0 || this.cXH == 0) {
                this.hTp = this.cXH;
            }
            jSONObject2.put("mintime", Long.toString(this.hTp));
            jSONObject2.put("maxtime", Long.toString(this.cXH));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(ARResourceKey.HTTP_AR_MD5, com.baidu.g.c.toMd5(this.mDataArray.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.hSQ);
            jSONObject.put("isreal", this.hTq ? "1" : "0");
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void clearData() {
        this.hTn.clear();
        this.hTo.clear();
        this.mDataArray = null;
    }

    public void xG(String str) {
        this.hSQ = str;
    }

    public String bPV() {
        return this.hSQ;
    }

    public long bPW() {
        return this.hTp;
    }

    public long bPX() {
        return this.cXH;
    }

    public JSONArray bPY() {
        return this.mDataArray;
    }

    public boolean bPZ() {
        return this.hTq;
    }

    public void ow(boolean z) {
        this.hTq = z;
    }
}
