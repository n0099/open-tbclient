package com.baidu.ubc;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class ah {
    private static final boolean DEBUG = AppConfig.isDebug();
    private boolean dKB = false;
    private JSONArray cKC = new JSONArray();
    private SparseArray<Integer> dKx = new SparseArray<>();
    private ArrayList<String> dKy = new ArrayList<>();
    private long dKz = 0;
    private long dKA = 0;
    private String dJB = "0";

    public final void cQ(JSONObject jSONObject) {
        this.cKC.put(jSONObject);
    }

    public final SparseArray<Integer> aWp() {
        return this.dKx;
    }

    public final void aF(int i, int i2) {
        this.dKx.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aWq() {
        return this.dKy;
    }

    public final void xq(String str) {
        if (!this.dKy.contains(str)) {
            this.dKy.add(str);
        }
    }

    public final void u(long j, long j2) {
        if ((j < this.dKz || this.dKz == 0) && j != 0) {
            this.dKz = j;
        }
        if (j2 > this.dKA) {
            this.dKA = j2;
        }
    }

    public boolean mm(int i) {
        return this.cKC.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.cKC.length() == 0;
    }

    public JSONObject dMf() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.cKC);
            if (this.dKz == 0 || this.dKA == 0) {
                this.dKz = this.dKA;
            }
            jSONObject2.put("mintime", Long.toString(this.dKz));
            jSONObject2.put("maxtime", Long.toString(this.dKA));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", af.toMd5(this.cKC.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.dJB);
            jSONObject.put("isreal", this.dKB ? "1" : "0");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public void clearData() {
        this.dKx.clear();
        this.dKy.clear();
        this.cKC = null;
    }

    public void xr(String str) {
        this.dJB = str;
    }

    public String aWs() {
        return this.dJB;
    }

    public long aWt() {
        return this.dKz;
    }

    public long getMaxTime() {
        return this.dKA;
    }

    public JSONArray aWu() {
        return this.cKC;
    }

    public boolean aWv() {
        return this.dKB;
    }

    public void hj(boolean z) {
        this.dKB = z;
    }
}
