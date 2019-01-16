package com.baidu.ubc;

import android.util.SparseArray;
import com.baidu.ar.parser.ARResourceKey;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class t {
    private boolean igE = false;
    private JSONArray mDataArray = new JSONArray();
    private SparseArray<Integer> igB = new SparseArray<>();
    private ArrayList<String> igC = new ArrayList<>();
    private long igD = 0;
    private long djb = 0;
    private String ige = "0";

    public final void aA(JSONObject jSONObject) {
        this.mDataArray.put(jSONObject);
    }

    public final SparseArray<Integer> bSV() {
        return this.igB;
    }

    public final void cd(int i, int i2) {
        this.igB.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bSW() {
        return this.igC;
    }

    public final void yG(String str) {
        if (!this.igC.contains(str)) {
            this.igC.add(str);
        }
    }

    public final void n(long j, long j2) {
        if ((j < this.igD || this.igD == 0) && j != 0) {
            this.igD = j;
        }
        if (j2 > this.djb) {
            this.djb = j2;
        }
    }

    public boolean xX(int i) {
        return this.mDataArray.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.mDataArray.length() == 0;
    }

    public JSONObject bSX() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.mDataArray);
            if (this.igD == 0 || this.djb == 0) {
                this.igD = this.djb;
            }
            jSONObject2.put("mintime", Long.toString(this.igD));
            jSONObject2.put("maxtime", Long.toString(this.djb));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(ARResourceKey.HTTP_AR_MD5, com.baidu.g.c.toMd5(this.mDataArray.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.ige);
            jSONObject.put("isreal", this.igE ? "1" : "0");
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void clearData() {
        this.igB.clear();
        this.igC.clear();
        this.mDataArray = null;
    }

    public void yH(String str) {
        this.ige = str;
    }

    public String bSY() {
        return this.ige;
    }

    public long bSZ() {
        return this.igD;
    }

    public long bTa() {
        return this.djb;
    }

    public JSONArray bTb() {
        return this.mDataArray;
    }

    public boolean bTc() {
        return this.igE;
    }

    public void oQ(boolean z) {
        this.igE = z;
    }
}
