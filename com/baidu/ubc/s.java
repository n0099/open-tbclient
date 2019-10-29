package com.baidu.ubc;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class s {
    private boolean bQu = false;
    private JSONArray bcc = new JSONArray();
    private SparseArray<Integer> bQq = new SparseArray<>();
    private ArrayList<String> bQr = new ArrayList<>();
    private long bQs = 0;
    private long bQt = 0;
    private String bPs = "0";

    public final void bs(JSONObject jSONObject) {
        this.bcc.put(jSONObject);
    }

    public final SparseArray<Integer> adk() {
        return this.bQq;
    }

    public final void W(int i, int i2) {
        this.bQq.put(i, Integer.valueOf(i2));
    }

    public final ArrayList adl() {
        return this.bQr;
    }

    public final void lF(String str) {
        if (!this.bQr.contains(str)) {
            this.bQr.add(str);
        }
    }

    public final void m(long j, long j2) {
        if ((j < this.bQs || this.bQs == 0) && j != 0) {
            this.bQs = j;
        }
        if (j2 > this.bQt) {
            this.bQt = j2;
        }
    }

    public boolean ha(int i) {
        return this.bcc.toString().getBytes().length >= i;
    }

    public boolean isEmpty() {
        return this.bcc.length() == 0;
    }

    public JSONObject cAY() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.bcc);
            if (this.bQs == 0 || this.bQt == 0) {
                this.bQs = this.bQt;
            }
            jSONObject2.put("mintime", Long.toString(this.bQs));
            jSONObject2.put("maxtime", Long.toString(this.bQt));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("md5", com.baidu.f.c.toMd5(this.bcc.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.bPs);
            jSONObject.put("isreal", this.bQu ? "1" : "0");
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void clearData() {
        this.bQq.clear();
        this.bQr.clear();
        this.bcc = null;
    }

    public void lG(String str) {
        this.bPs = str;
    }

    public String adn() {
        return this.bPs;
    }

    public long ado() {
        return this.bQs;
    }

    public long getMaxTime() {
        return this.bQt;
    }

    public JSONArray adp() {
        return this.bcc;
    }

    public boolean adq() {
        return this.bQu;
    }

    public void dJ(boolean z) {
        this.bQu = z;
    }
}
