package com.baidu.ubc;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class ah {
    private static final boolean DEBUG = AppConfig.isDebug();
    private boolean dYJ = false;
    private JSONArray cYJ = new JSONArray();
    private SparseArray<Integer> dYF = new SparseArray<>();
    private ArrayList<String> dYG = new ArrayList<>();
    private long dYH = 0;
    private long dYI = 0;
    private String dXK = "0";

    public final void da(JSONObject jSONObject) {
        this.cYJ.put(jSONObject);
    }

    public final SparseArray<Integer> aZJ() {
        return this.dYF;
    }

    public final void aE(int i, int i2) {
        this.dYF.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aZK() {
        return this.dYG;
    }

    public final void yw(String str) {
        if (!this.dYG.contains(str)) {
            this.dYG.add(str);
        }
    }

    public final void q(long j, long j2) {
        if ((j < this.dYH || this.dYH == 0) && j != 0) {
            this.dYH = j;
        }
        if (j2 > this.dYI) {
            this.dYI = j2;
        }
    }

    public boolean mU(int i) {
        return this.cYJ.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.cYJ.length() == 0;
    }

    public JSONObject dTX() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.cYJ);
            if (this.dYH == 0 || this.dYI == 0) {
                this.dYH = this.dYI;
            }
            jSONObject2.put("mintime", Long.toString(this.dYH));
            jSONObject2.put("maxtime", Long.toString(this.dYI));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", af.toMd5(this.cYJ.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.dXK);
            jSONObject.put("isreal", this.dYJ ? "1" : "0");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public void clearData() {
        this.dYF.clear();
        this.dYG.clear();
        this.cYJ = null;
    }

    public void yx(String str) {
        this.dXK = str;
    }

    public String aZM() {
        return this.dXK;
    }

    public long aZN() {
        return this.dYH;
    }

    public long getMaxTime() {
        return this.dYI;
    }

    public JSONArray aZO() {
        return this.cYJ;
    }

    public boolean aZP() {
        return this.dYJ;
    }

    public void hE(boolean z) {
        this.dYJ = z;
    }
}
