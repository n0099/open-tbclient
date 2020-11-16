package com.baidu.ubc;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class ah {
    private static final boolean DEBUG = AppConfig.isDebug();
    private boolean elq = false;
    private JSONArray dly = new JSONArray();
    private SparseArray<Integer> elm = new SparseArray<>();
    private ArrayList<String> eln = new ArrayList<>();
    private long elo = 0;
    private long elp = 0;
    private String ekr = "0";

    public final void dd(JSONObject jSONObject) {
        this.dly.put(jSONObject);
    }

    public final SparseArray<Integer> bdv() {
        return this.elm;
    }

    public final void aF(int i, int i2) {
        this.elm.put(i, Integer.valueOf(i2));
    }

    public final ArrayList bdw() {
        return this.eln;
    }

    public final void yY(String str) {
        if (!this.eln.contains(str)) {
            this.eln.add(str);
        }
    }

    public final void r(long j, long j2) {
        if ((j < this.elo || this.elo == 0) && j != 0) {
            this.elo = j;
        }
        if (j2 > this.elp) {
            this.elp = j2;
        }
    }

    public boolean nl(int i) {
        return this.dly.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.dly.length() == 0;
    }

    public JSONObject edw() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.dly);
            if (this.elo == 0 || this.elp == 0) {
                this.elo = this.elp;
            }
            jSONObject2.put("mintime", Long.toString(this.elo));
            jSONObject2.put("maxtime", Long.toString(this.elp));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", af.toMd5(this.dly.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.ekr);
            jSONObject.put("isreal", this.elq ? "1" : "0");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public void clearData() {
        this.elm.clear();
        this.eln.clear();
        this.dly = null;
    }

    public void yZ(String str) {
        this.ekr = str;
    }

    public String bdy() {
        return this.ekr;
    }

    public long bdz() {
        return this.elo;
    }

    public long getMaxTime() {
        return this.elp;
    }

    public JSONArray bdA() {
        return this.dly;
    }

    public boolean bdB() {
        return this.elq;
    }

    public void id(boolean z) {
        this.elq = z;
    }
}
