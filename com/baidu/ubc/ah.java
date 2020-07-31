package com.baidu.ubc;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class ah {
    private static final boolean DEBUG = AppConfig.isDebug();
    private boolean dBq = false;
    private JSONArray cCo = new JSONArray();
    private SparseArray<Integer> dBm = new SparseArray<>();
    private ArrayList<String> dBn = new ArrayList<>();
    private long dBo = 0;
    private long dBp = 0;
    private String dAs = "0";

    public final void cK(JSONObject jSONObject) {
        this.cCo.put(jSONObject);
    }

    public final SparseArray<Integer> aNP() {
        return this.dBm;
    }

    public final void ay(int i, int i2) {
        this.dBm.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aNQ() {
        return this.dBn;
    }

    public final void vf(String str) {
        if (!this.dBn.contains(str)) {
            this.dBn.add(str);
        }
    }

    public final void t(long j, long j2) {
        if ((j < this.dBo || this.dBo == 0) && j != 0) {
            this.dBo = j;
        }
        if (j2 > this.dBp) {
            this.dBp = j2;
        }
    }

    public boolean kg(int i) {
        return this.cCo.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.cCo.length() == 0;
    }

    public JSONObject dAr() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.cCo);
            if (this.dBo == 0 || this.dBp == 0) {
                this.dBo = this.dBp;
            }
            jSONObject2.put("mintime", Long.toString(this.dBo));
            jSONObject2.put("maxtime", Long.toString(this.dBp));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", af.toMd5(this.cCo.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.dAs);
            jSONObject.put("isreal", this.dBq ? "1" : "0");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public void clearData() {
        this.dBm.clear();
        this.dBn.clear();
        this.cCo = null;
    }

    public void vg(String str) {
        this.dAs = str;
    }

    public String aNS() {
        return this.dAs;
    }

    public long aNT() {
        return this.dBo;
    }

    public long getMaxTime() {
        return this.dBp;
    }

    public JSONArray aNU() {
        return this.cCo;
    }

    public boolean aNV() {
        return this.dBq;
    }

    public void gP(boolean z) {
        this.dBq = z;
    }
}
