package com.baidu.ubc;

import android.util.SparseArray;
import com.baidu.ar.parser.ARResourceKey;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class t {
    private boolean hVa = false;
    private JSONArray mDataArray = new JSONArray();
    private SparseArray<Integer> hUX = new SparseArray<>();
    private ArrayList<String> hUY = new ArrayList<>();
    private long hUZ = 0;
    private long cYN = 0;
    private String hUA = "0";

    public final void ay(JSONObject jSONObject) {
        this.mDataArray.put(jSONObject);
    }

    public final SparseArray<Integer> bPr() {
        return this.hUX;
    }

    public final void ce(int i, int i2) {
        this.hUX.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bPs() {
        return this.hUY;
    }

    public final void xK(String str) {
        if (!this.hUY.contains(str)) {
            this.hUY.add(str);
        }
    }

    public final void n(long j, long j2) {
        if ((j < this.hUZ || this.hUZ == 0) && j != 0) {
            this.hUZ = j;
        }
        if (j2 > this.cYN) {
            this.cYN = j2;
        }
    }

    public boolean xl(int i) {
        return this.mDataArray.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.mDataArray.length() == 0;
    }

    public JSONObject bPt() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.mDataArray);
            if (this.hUZ == 0 || this.cYN == 0) {
                this.hUZ = this.cYN;
            }
            jSONObject2.put("mintime", Long.toString(this.hUZ));
            jSONObject2.put("maxtime", Long.toString(this.cYN));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(ARResourceKey.HTTP_AR_MD5, com.baidu.g.c.toMd5(this.mDataArray.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.hUA);
            jSONObject.put("isreal", this.hVa ? "1" : "0");
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void clearData() {
        this.hUX.clear();
        this.hUY.clear();
        this.mDataArray = null;
    }

    public void xL(String str) {
        this.hUA = str;
    }

    public String bPu() {
        return this.hUA;
    }

    public long bPv() {
        return this.hUZ;
    }

    public long bPw() {
        return this.cYN;
    }

    public JSONArray bPx() {
        return this.mDataArray;
    }

    public boolean bPy() {
        return this.hVa;
    }

    public void oK(boolean z) {
        this.hVa = z;
    }
}
