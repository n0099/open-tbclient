package com.baidu.ubc;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class aj {
    private static final boolean DEBUG = AppConfig.isDebug();
    private boolean eCc = false;
    private int oNQ = 0;
    private int oNR = 614400;
    private JSONArray dxx = new JSONArray();
    private SparseArray<Integer> eBY = new SparseArray<>();
    private ArrayList<String> eBZ = new ArrayList<>();
    private long eCa = 0;
    private long eCb = 0;
    private String eBe = "0";

    public final void dn(JSONObject jSONObject) {
        this.dxx.put(jSONObject);
    }

    public final SparseArray<Integer> biX() {
        return this.eBY;
    }

    public final void aE(int i, int i2) {
        this.eBY.put(i, Integer.valueOf(i2));
    }

    public final ArrayList biY() {
        return this.eBZ;
    }

    public final void zE(String str) {
        if (!this.eBZ.contains(str)) {
            this.eBZ.add(str);
        }
    }

    public final void u(long j, long j2) {
        if ((j < this.eCa || this.eCa == 0) && j != 0) {
            this.eCa = j;
        }
        if (j2 > this.eCb) {
            this.eCb = j2;
        }
    }

    public void Ox(int i) {
        if (i >= 0) {
            this.oNR = i;
        }
    }

    public void Oy(int i) {
        if (i > 0) {
            this.oNQ += i;
        }
    }

    public boolean eju() {
        return this.oNQ >= this.oNR;
    }

    public boolean nS(int i) {
        return this.dxx.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.dxx.length() == 0;
    }

    public JSONObject ejv() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.dxx);
            if (this.eCa == 0 || this.eCb == 0) {
                this.eCa = this.eCb;
            }
            jSONObject2.put("mintime", Long.toString(this.eCa));
            jSONObject2.put("maxtime", Long.toString(this.eCb));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", ah.toMd5(this.dxx.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.eBe);
            jSONObject.put("isreal", this.eCc ? "1" : "0");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public void clearData() {
        this.eBY.clear();
        this.eBZ.clear();
        this.dxx = null;
    }

    public void zF(String str) {
        this.eBe = str;
    }

    public long bjb() {
        return this.eCa;
    }

    public long getMaxTime() {
        return this.eCb;
    }

    public JSONArray bjc() {
        return this.dxx;
    }

    public boolean bjd() {
        return this.eCc;
    }

    public void iN(boolean z) {
        this.eCc = z;
    }
}
