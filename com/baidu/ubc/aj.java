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
    private boolean eAX = false;
    private int oVZ = 0;
    private int oWa = 614400;
    private JSONArray dww = new JSONArray();
    private SparseArray<Integer> eAT = new SparseArray<>();
    private ArrayList<String> eAU = new ArrayList<>();
    private long eAV = 0;
    private long eAW = 0;
    private String ezZ = "0";

    public final void dm(JSONObject jSONObject) {
        this.dww.put(jSONObject);
    }

    public final SparseArray<Integer> bft() {
        return this.eAT;
    }

    public final void aB(int i, int i2) {
        this.eAT.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bfu() {
        return this.eAU;
    }

    public final void yT(String str) {
        if (!this.eAU.contains(str)) {
            this.eAU.add(str);
        }
    }

    public final void y(long j, long j2) {
        if ((j < this.eAV || this.eAV == 0) && j != 0) {
            this.eAV = j;
        }
        if (j2 > this.eAW) {
            this.eAW = j2;
        }
    }

    public void Nr(int i) {
        if (i >= 0) {
            this.oWa = i;
        }
    }

    public void Ns(int i) {
        if (i > 0) {
            this.oVZ += i;
        }
    }

    public boolean eil() {
        return this.oVZ >= this.oWa;
    }

    public boolean mq(int i) {
        return this.dww.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.dww.length() == 0;
    }

    public JSONObject eim() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.dww);
            if (this.eAV == 0 || this.eAW == 0) {
                this.eAV = this.eAW;
            }
            jSONObject2.put("mintime", Long.toString(this.eAV));
            jSONObject2.put("maxtime", Long.toString(this.eAW));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", ah.toMd5(this.dww.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.ezZ);
            jSONObject.put("isreal", this.eAX ? "1" : "0");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public void clearData() {
        this.eAT.clear();
        this.eAU.clear();
        this.dww = null;
    }

    public void yU(String str) {
        this.ezZ = str;
    }

    public long bfx() {
        return this.eAV;
    }

    public long getMaxTime() {
        return this.eAW;
    }

    public JSONArray bfy() {
        return this.dww;
    }

    public boolean bfz() {
        return this.eAX;
    }

    public void iL(boolean z) {
        this.eAX = z;
    }
}
