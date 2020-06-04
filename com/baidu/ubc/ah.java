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
    private boolean dqO = false;
    private JSONArray cuT = new JSONArray();
    private SparseArray<Integer> dqK = new SparseArray<>();
    private ArrayList<String> dqL = new ArrayList<>();
    private long dqM = 0;
    private long dqN = 0;
    private String dpR = "0";

    public final void cx(JSONObject jSONObject) {
        this.cuT.put(jSONObject);
    }

    public final SparseArray<Integer> aIS() {
        return this.dqK;
    }

    public final void aw(int i, int i2) {
        this.dqK.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aIT() {
        return this.dqL;
    }

    public final void tU(String str) {
        if (!this.dqL.contains(str)) {
            this.dqL.add(str);
        }
    }

    public final void s(long j, long j2) {
        if ((j < this.dqM || this.dqM == 0) && j != 0) {
            this.dqM = j;
        }
        if (j2 > this.dqN) {
            this.dqN = j2;
        }
    }

    public boolean jC(int i) {
        return this.cuT.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.cuT.length() == 0;
    }

    public JSONObject dsv() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.cuT);
            if (this.dqM == 0 || this.dqN == 0) {
                this.dqM = this.dqN;
            }
            jSONObject2.put("mintime", Long.toString(this.dqM));
            jSONObject2.put("maxtime", Long.toString(this.dqN));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", af.toMd5(this.cuT.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.dpR);
            jSONObject.put("isreal", this.dqO ? "1" : "0");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public void clearData() {
        this.dqK.clear();
        this.dqL.clear();
        this.cuT = null;
    }

    public void tV(String str) {
        this.dpR = str;
    }

    public String aIV() {
        return this.dpR;
    }

    public long aIW() {
        return this.dqM;
    }

    public long getMaxTime() {
        return this.dqN;
    }

    public JSONArray aIX() {
        return this.cuT;
    }

    public boolean aIY() {
        return this.dqO;
    }

    public void gp(boolean z) {
        this.dqO = z;
    }
}
