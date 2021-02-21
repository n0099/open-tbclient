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
    private boolean ezw = false;
    private int oTU = 0;
    private int oTV = 614400;
    private JSONArray duV = new JSONArray();
    private SparseArray<Integer> ezs = new SparseArray<>();
    private ArrayList<String> ezt = new ArrayList<>();
    private long ezu = 0;
    private long ezv = 0;
    private String eyy = "0";

    public final void dk(JSONObject jSONObject) {
        this.duV.put(jSONObject);
    }

    public final SparseArray<Integer> bfr() {
        return this.ezs;
    }

    public final void aB(int i, int i2) {
        this.ezs.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bfs() {
        return this.ezt;
    }

    public final void yM(String str) {
        if (!this.ezt.contains(str)) {
            this.ezt.add(str);
        }
    }

    public final void y(long j, long j2) {
        if ((j < this.ezu || this.ezu == 0) && j != 0) {
            this.ezu = j;
        }
        if (j2 > this.ezv) {
            this.ezv = j2;
        }
    }

    public void Nn(int i) {
        if (i >= 0) {
            this.oTV = i;
        }
    }

    public void No(int i) {
        if (i > 0) {
            this.oTU += i;
        }
    }

    public boolean eid() {
        return this.oTU >= this.oTV;
    }

    public boolean mp(int i) {
        return this.duV.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.duV.length() == 0;
    }

    public JSONObject eie() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.duV);
            if (this.ezu == 0 || this.ezv == 0) {
                this.ezu = this.ezv;
            }
            jSONObject2.put("mintime", Long.toString(this.ezu));
            jSONObject2.put("maxtime", Long.toString(this.ezv));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", ah.toMd5(this.duV.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.eyy);
            jSONObject.put("isreal", this.ezw ? "1" : "0");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public void clearData() {
        this.ezs.clear();
        this.ezt.clear();
        this.duV = null;
    }

    public void yN(String str) {
        this.eyy = str;
    }

    public long bfv() {
        return this.ezu;
    }

    public long getMaxTime() {
        return this.ezv;
    }

    public JSONArray bfw() {
        return this.duV;
    }

    public boolean bfx() {
        return this.ezw;
    }

    public void iL(boolean z) {
        this.ezw = z;
    }
}
