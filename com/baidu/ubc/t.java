package com.baidu.ubc;

import android.util.SparseArray;
import com.baidu.ar.parser.ARResourceKey;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class t {
    private boolean ifx = false;
    private JSONArray mDataArray = new JSONArray();
    private SparseArray<Integer> ifu = new SparseArray<>();
    private ArrayList<String> ifv = new ArrayList<>();
    private long ifw = 0;
    private long dip = 0;
    private String ieX = "0";

    public final void aA(JSONObject jSONObject) {
        this.mDataArray.put(jSONObject);
    }

    public final SparseArray<Integer> bSn() {
        return this.ifu;
    }

    public final void cd(int i, int i2) {
        this.ifu.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bSo() {
        return this.ifv;
    }

    public final void yq(String str) {
        if (!this.ifv.contains(str)) {
            this.ifv.add(str);
        }
    }

    public final void n(long j, long j2) {
        if ((j < this.ifw || this.ifw == 0) && j != 0) {
            this.ifw = j;
        }
        if (j2 > this.dip) {
            this.dip = j2;
        }
    }

    public boolean xV(int i) {
        return this.mDataArray.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.mDataArray.length() == 0;
    }

    public JSONObject bSp() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.mDataArray);
            if (this.ifw == 0 || this.dip == 0) {
                this.ifw = this.dip;
            }
            jSONObject2.put("mintime", Long.toString(this.ifw));
            jSONObject2.put("maxtime", Long.toString(this.dip));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(ARResourceKey.HTTP_AR_MD5, com.baidu.g.c.toMd5(this.mDataArray.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.ieX);
            jSONObject.put("isreal", this.ifx ? "1" : "0");
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void clearData() {
        this.ifu.clear();
        this.ifv.clear();
        this.mDataArray = null;
    }

    public void yr(String str) {
        this.ieX = str;
    }

    public String bSq() {
        return this.ieX;
    }

    public long bSr() {
        return this.ifw;
    }

    public long bSs() {
        return this.dip;
    }

    public JSONArray bSt() {
        return this.mDataArray;
    }

    public boolean bSu() {
        return this.ifx;
    }

    public void oP(boolean z) {
        this.ifx = z;
    }
}
