package com.baidu.ubc;

import android.util.SparseArray;
import com.baidu.ar.parser.ARResourceKey;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class t {
    private boolean igF = false;
    private JSONArray mDataArray = new JSONArray();
    private SparseArray<Integer> igC = new SparseArray<>();
    private ArrayList<String> igD = new ArrayList<>();
    private long igE = 0;
    private long djc = 0;
    private String igf = "0";

    public final void aA(JSONObject jSONObject) {
        this.mDataArray.put(jSONObject);
    }

    public final SparseArray<Integer> bSV() {
        return this.igC;
    }

    public final void cd(int i, int i2) {
        this.igC.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bSW() {
        return this.igD;
    }

    public final void yG(String str) {
        if (!this.igD.contains(str)) {
            this.igD.add(str);
        }
    }

    public final void n(long j, long j2) {
        if ((j < this.igE || this.igE == 0) && j != 0) {
            this.igE = j;
        }
        if (j2 > this.djc) {
            this.djc = j2;
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
            if (this.igE == 0 || this.djc == 0) {
                this.igE = this.djc;
            }
            jSONObject2.put("mintime", Long.toString(this.igE));
            jSONObject2.put("maxtime", Long.toString(this.djc));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(ARResourceKey.HTTP_AR_MD5, com.baidu.g.c.toMd5(this.mDataArray.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.igf);
            jSONObject.put("isreal", this.igF ? "1" : "0");
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void clearData() {
        this.igC.clear();
        this.igD.clear();
        this.mDataArray = null;
    }

    public void yH(String str) {
        this.igf = str;
    }

    public String bSY() {
        return this.igf;
    }

    public long bSZ() {
        return this.igE;
    }

    public long bTa() {
        return this.djc;
    }

    public JSONArray bTb() {
        return this.mDataArray;
    }

    public boolean bTc() {
        return this.igF;
    }

    public void oQ(boolean z) {
        this.igF = z;
    }
}
