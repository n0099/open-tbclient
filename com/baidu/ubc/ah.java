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
    private boolean dvA = false;
    private JSONArray czE = new JSONArray();
    private SparseArray<Integer> dvw = new SparseArray<>();
    private ArrayList<String> dvx = new ArrayList<>();
    private long dvy = 0;
    private long dvz = 0;
    private String duD = "0";

    public final void cE(JSONObject jSONObject) {
        this.czE.put(jSONObject);
    }

    public final SparseArray<Integer> aJY() {
        return this.dvw;
    }

    public final void ay(int i, int i2) {
        this.dvw.put(i, Integer.valueOf(i2));
    }

    public final ArrayList aJZ() {
        return this.dvx;
    }

    public final void uc(String str) {
        if (!this.dvx.contains(str)) {
            this.dvx.add(str);
        }
    }

    public final void s(long j, long j2) {
        if ((j < this.dvy || this.dvy == 0) && j != 0) {
            this.dvy = j;
        }
        if (j2 > this.dvz) {
            this.dvz = j2;
        }
    }

    public boolean jN(int i) {
        return this.czE.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.czE.length() == 0;
    }

    public JSONObject dxe() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.czE);
            if (this.dvy == 0 || this.dvz == 0) {
                this.dvy = this.dvz;
            }
            jSONObject2.put("mintime", Long.toString(this.dvy));
            jSONObject2.put("maxtime", Long.toString(this.dvz));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", af.toMd5(this.czE.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.duD);
            jSONObject.put("isreal", this.dvA ? "1" : "0");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public void clearData() {
        this.dvw.clear();
        this.dvx.clear();
        this.czE = null;
    }

    public void ud(String str) {
        this.duD = str;
    }

    public String aKb() {
        return this.duD;
    }

    public long aKc() {
        return this.dvy;
    }

    public long getMaxTime() {
        return this.dvz;
    }

    public JSONArray aKd() {
        return this.czE;
    }

    public boolean aKe() {
        return this.dvA;
    }

    public void gu(boolean z) {
        this.dvA = z;
    }
}
