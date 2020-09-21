package com.baidu.ubc;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class ah {
    private static final boolean DEBUG = AppConfig.isDebug();
    private boolean dMI = false;
    private JSONArray cMG = new JSONArray();
    private SparseArray<Integer> dME = new SparseArray<>();
    private ArrayList<String> dMF = new ArrayList<>();
    private long dMG = 0;
    private long dMH = 0;
    private String dLJ = "0";

    public final void cT(JSONObject jSONObject) {
        this.cMG.put(jSONObject);
    }

    public final SparseArray<Integer> aXb() {
        return this.dME;
    }

    public final void aF(int i, int i2) {
        this.dME.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aXc() {
        return this.dMF;
    }

    public final void xK(String str) {
        if (!this.dMF.contains(str)) {
            this.dMF.add(str);
        }
    }

    public final void q(long j, long j2) {
        if ((j < this.dMG || this.dMG == 0) && j != 0) {
            this.dMG = j;
        }
        if (j2 > this.dMH) {
            this.dMH = j2;
        }
    }

    public boolean mx(int i) {
        return this.cMG.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.cMG.length() == 0;
    }

    public JSONObject dQm() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.cMG);
            if (this.dMG == 0 || this.dMH == 0) {
                this.dMG = this.dMH;
            }
            jSONObject2.put("mintime", Long.toString(this.dMG));
            jSONObject2.put("maxtime", Long.toString(this.dMH));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", af.toMd5(this.cMG.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.dLJ);
            jSONObject.put("isreal", this.dMI ? "1" : "0");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public void clearData() {
        this.dME.clear();
        this.dMF.clear();
        this.cMG = null;
    }

    public void xL(String str) {
        this.dLJ = str;
    }

    public String aXe() {
        return this.dLJ;
    }

    public long aXf() {
        return this.dMG;
    }

    public long getMaxTime() {
        return this.dMH;
    }

    public JSONArray aXg() {
        return this.cMG;
    }

    public boolean aXh() {
        return this.dMI;
    }

    public void hi(boolean z) {
        this.dMI = z;
    }
}
