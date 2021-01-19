package com.baidu.ubc;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
class aj {
    private static final boolean DEBUG = AppConfig.isDebug();
    private boolean exn = false;
    private int oJm = 0;
    private int oJn = 614400;
    private JSONArray dsK = new JSONArray();
    private SparseArray<Integer> exj = new SparseArray<>();
    private ArrayList<String> exk = new ArrayList<>();
    private long exl = 0;
    private long exm = 0;
    private String ewp = "0";

    public final void dn(JSONObject jSONObject) {
        this.dsK.put(jSONObject);
    }

    public final SparseArray<Integer> bfe() {
        return this.exj;
    }

    public final void aE(int i, int i2) {
        this.exj.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bff() {
        return this.exk;
    }

    public final void yt(String str) {
        if (!this.exk.contains(str)) {
            this.exk.add(str);
        }
    }

    public final void u(long j, long j2) {
        if ((j < this.exl || this.exl == 0) && j != 0) {
            this.exl = j;
        }
        if (j2 > this.exm) {
            this.exm = j2;
        }
    }

    public void MQ(int i) {
        if (i >= 0) {
            this.oJn = i;
        }
    }

    public void MR(int i) {
        if (i > 0) {
            this.oJm += i;
        }
    }

    public boolean efD() {
        return this.oJm >= this.oJn;
    }

    public boolean mm(int i) {
        return this.dsK.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.dsK.length() == 0;
    }

    public JSONObject efE() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.dsK);
            if (this.exl == 0 || this.exm == 0) {
                this.exl = this.exm;
            }
            jSONObject2.put("mintime", Long.toString(this.exl));
            jSONObject2.put("maxtime", Long.toString(this.exm));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", ah.toMd5(this.dsK.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.ewp);
            jSONObject.put("isreal", this.exn ? "1" : "0");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public void clearData() {
        this.exj.clear();
        this.exk.clear();
        this.dsK = null;
    }

    public void yu(String str) {
        this.ewp = str;
    }

    public long bfi() {
        return this.exl;
    }

    public long getMaxTime() {
        return this.exm;
    }

    public JSONArray bfj() {
        return this.dsK;
    }

    public boolean bfk() {
        return this.exn;
    }

    public void iJ(boolean z) {
        this.exn = z;
    }
}
