package com.baidu.tieba.model;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {
    private int adU;
    private int adV;
    private int adW;
    private int boW;
    private int boX;
    private int boY;
    private int[] boZ;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.boW = jSONObject.optInt("conn_conf");
            this.boX = jSONObject.optInt("continuous_fail_count");
            this.boY = jSONObject.optInt("restart_time_interval");
            this.adU = jSONObject.optInt("lcs_timeout_2G");
            this.adV = jSONObject.optInt("lcs_timeout_3G");
            this.adW = jSONObject.optInt("lcs_timeout_wifi");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.boZ = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.boZ[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.boZ = new int[0];
        }
    }

    public int Ty() {
        return this.boW;
    }

    public int Tz() {
        return this.boX;
    }

    public int TA() {
        return this.boY;
    }

    public int[] TB() {
        return this.boZ;
    }

    public int TC() {
        return this.adU;
    }

    public int TD() {
        return this.adV;
    }

    public int TE() {
        return this.adW;
    }
}
