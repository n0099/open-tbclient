package com.baidu.ubc;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class ah {
    private static final boolean DEBUG = AppConfig.isDebug();
    private boolean ehg = false;
    private JSONArray dhk = new JSONArray();
    private SparseArray<Integer> ehc = new SparseArray<>();
    private ArrayList<String> ehd = new ArrayList<>();
    private long ehe = 0;
    private long ehf = 0;
    private String egg = "0";

    public final void dd(JSONObject jSONObject) {
        this.dhk.put(jSONObject);
    }

    public final SparseArray<Integer> bbC() {
        return this.ehc;
    }

    public final void aF(int i, int i2) {
        this.ehc.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bbD() {
        return this.ehd;
    }

    public final void yP(String str) {
        if (!this.ehd.contains(str)) {
            this.ehd.add(str);
        }
    }

    public final void q(long j, long j2) {
        if ((j < this.ehe || this.ehe == 0) && j != 0) {
            this.ehe = j;
        }
        if (j2 > this.ehf) {
            this.ehf = j2;
        }
    }

    public boolean nf(int i) {
        return this.dhk.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.dhk.length() == 0;
    }

    public JSONObject dZP() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.dhk);
            if (this.ehe == 0 || this.ehf == 0) {
                this.ehe = this.ehf;
            }
            jSONObject2.put("mintime", Long.toString(this.ehe));
            jSONObject2.put("maxtime", Long.toString(this.ehf));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", af.toMd5(this.dhk.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.egg);
            jSONObject.put("isreal", this.ehg ? "1" : "0");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public void clearData() {
        this.ehc.clear();
        this.ehd.clear();
        this.dhk = null;
    }

    public void yQ(String str) {
        this.egg = str;
    }

    public String bbF() {
        return this.egg;
    }

    public long bbG() {
        return this.ehe;
    }

    public long getMaxTime() {
        return this.ehf;
    }

    public JSONArray bbH() {
        return this.dhk;
    }

    public boolean bbI() {
        return this.ehg;
    }

    public void hR(boolean z) {
        this.ehg = z;
    }
}
