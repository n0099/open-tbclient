package com.baidu.ubc;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes13.dex */
public class ah {
    private static final boolean DEBUG = AppConfig.isDebug();
    private boolean deQ = false;
    private JSONArray cjj = new JSONArray();
    private SparseArray<Integer> deM = new SparseArray<>();
    private ArrayList<String> deN = new ArrayList<>();
    private long deO = 0;
    private long deP = 0;
    private String ddT = "0";

    public final void cr(JSONObject jSONObject) {
        this.cjj.put(jSONObject);
    }

    public final SparseArray<Integer> aEk() {
        return this.deM;
    }

    public final void aw(int i, int i2) {
        this.deM.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aEl() {
        return this.deN;
    }

    public final void sp(String str) {
        if (!this.deN.contains(str)) {
            this.deN.add(str);
        }
    }

    public final void r(long j, long j2) {
        if ((j < this.deO || this.deO == 0) && j != 0) {
            this.deO = j;
        }
        if (j2 > this.deP) {
            this.deP = j2;
        }
    }

    public boolean jh(int i) {
        return this.cjj.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.cjj.length() == 0;
    }

    public JSONObject dkT() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.cjj);
            if (this.deO == 0 || this.deP == 0) {
                this.deO = this.deP;
            }
            jSONObject2.put("mintime", Long.toString(this.deO));
            jSONObject2.put("maxtime", Long.toString(this.deP));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", af.toMd5(this.cjj.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.ddT);
            jSONObject.put("isreal", this.deQ ? "1" : "0");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public void clearData() {
        this.deM.clear();
        this.deN.clear();
        this.cjj = null;
    }

    public void sq(String str) {
        this.ddT = str;
    }

    public String aEn() {
        return this.ddT;
    }

    public long aEo() {
        return this.deO;
    }

    public long getMaxTime() {
        return this.deP;
    }

    public JSONArray aEp() {
        return this.cjj;
    }

    public boolean aEq() {
        return this.deQ;
    }

    public void ge(boolean z) {
        this.deQ = z;
    }
}
