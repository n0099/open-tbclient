package com.baidu.ubc;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
class aj {
    private static final boolean DEBUG = AppConfig.isDebug();
    private boolean ess = false;
    private int oHF = 0;
    private int oHG = 614400;
    private JSONArray dsz = new JSONArray();
    private SparseArray<Integer> eso = new SparseArray<>();
    private ArrayList<String> esp = new ArrayList<>();
    private long esq = 0;
    private long esr = 0;
    private String eru = "0";

    public final void df(JSONObject jSONObject) {
        this.dsz.put(jSONObject);
    }

    public final SparseArray<Integer> bgA() {
        return this.eso;
    }

    public final void aH(int i, int i2) {
        this.eso.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bgB() {
        return this.esp;
    }

    public final void zF(String str) {
        if (!this.esp.contains(str)) {
            this.esp.add(str);
        }
    }

    public final void r(long j, long j2) {
        if ((j < this.esq || this.esq == 0) && j != 0) {
            this.esq = j;
        }
        if (j2 > this.esr) {
            this.esr = j2;
        }
    }

    public void OI(int i) {
        if (i >= 0) {
            this.oHG = i;
        }
    }

    public void OJ(int i) {
        if (i > 0) {
            this.oHF += i;
        }
    }

    public boolean ejj() {
        return this.oHF >= this.oHG;
    }

    public boolean nJ(int i) {
        return this.dsz.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.dsz.length() == 0;
    }

    public JSONObject ejk() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.dsz);
            if (this.esq == 0 || this.esr == 0) {
                this.esq = this.esr;
            }
            jSONObject2.put("mintime", Long.toString(this.esq));
            jSONObject2.put("maxtime", Long.toString(this.esr));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", ah.toMd5(this.dsz.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.eru);
            jSONObject.put("isreal", this.ess ? "1" : "0");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public void clearData() {
        this.eso.clear();
        this.esp.clear();
        this.dsz = null;
    }

    public void zG(String str) {
        this.eru = str;
    }

    public long bgE() {
        return this.esq;
    }

    public long getMaxTime() {
        return this.esr;
    }

    public JSONArray bgF() {
        return this.dsz;
    }

    public boolean bgG() {
        return this.ess;
    }

    public void is(boolean z) {
        this.ess = z;
    }
}
