package com.baidu.ubc;

import android.util.SparseArray;
import com.baidu.ar.parser.ARResourceKey;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class t {
    private boolean ick = false;
    private JSONArray mDataArray = new JSONArray();
    private SparseArray<Integer> ich = new SparseArray<>();
    private ArrayList<String> ici = new ArrayList<>();
    private long icj = 0;
    private long dfz = 0;
    private String ibK = "0";

    public final void aA(JSONObject jSONObject) {
        this.mDataArray.put(jSONObject);
    }

    public final SparseArray<Integer> bRw() {
        return this.ich;
    }

    public final void cc(int i, int i2) {
        this.ich.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bRx() {
        return this.ici;
    }

    public final void yn(String str) {
        if (!this.ici.contains(str)) {
            this.ici.add(str);
        }
    }

    public final void n(long j, long j2) {
        if ((j < this.icj || this.icj == 0) && j != 0) {
            this.icj = j;
        }
        if (j2 > this.dfz) {
            this.dfz = j2;
        }
    }

    public boolean xI(int i) {
        return this.mDataArray.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.mDataArray.length() == 0;
    }

    public JSONObject bRy() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.mDataArray);
            if (this.icj == 0 || this.dfz == 0) {
                this.icj = this.dfz;
            }
            jSONObject2.put("mintime", Long.toString(this.icj));
            jSONObject2.put("maxtime", Long.toString(this.dfz));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(ARResourceKey.HTTP_AR_MD5, com.baidu.g.c.toMd5(this.mDataArray.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.ibK);
            jSONObject.put("isreal", this.ick ? "1" : "0");
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void clearData() {
        this.ich.clear();
        this.ici.clear();
        this.mDataArray = null;
    }

    public void yo(String str) {
        this.ibK = str;
    }

    public String bRz() {
        return this.ibK;
    }

    public long bRA() {
        return this.icj;
    }

    public long bRB() {
        return this.dfz;
    }

    public JSONArray bRC() {
        return this.mDataArray;
    }

    public boolean bRD() {
        return this.ick;
    }

    public void oM(boolean z) {
        this.ick = z;
    }
}
