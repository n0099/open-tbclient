package com.baidu.tieba.model;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {
    private int aea;
    private int aeb;
    private int aec;
    private int bpk;
    private int bpl;
    private int bpm;
    private int[] bpn;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.bpk = jSONObject.optInt("conn_conf");
            this.bpl = jSONObject.optInt("continuous_fail_count");
            this.bpm = jSONObject.optInt("restart_time_interval");
            this.aea = jSONObject.optInt("lcs_timeout_2G");
            this.aeb = jSONObject.optInt("lcs_timeout_3G");
            this.aec = jSONObject.optInt("lcs_timeout_wifi");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.bpn = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.bpn[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.bpn = new int[0];
        }
    }

    public int TB() {
        return this.bpk;
    }

    public int TC() {
        return this.bpl;
    }

    public int TD() {
        return this.bpm;
    }

    public int[] TE() {
        return this.bpn;
    }

    public int TF() {
        return this.aea;
    }

    public int TG() {
        return this.aeb;
    }

    public int TH() {
        return this.aec;
    }
}
