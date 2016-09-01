package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String extInfo;
    private JSONObject faS;
    private String faT;
    private int faU;
    private String faX;
    private JSONObject faY;
    private int faZ;
    private int fba;
    private int fbb;
    private int pageNumber;
    private long faW = System.currentTimeMillis() / 1000;
    private int faV = i.gs();

    public void qs(String str) {
        this.extInfo = str;
    }

    public void qt(String str) {
        this.faT = str;
    }

    public void qD(int i) {
        this.faU = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void qu(String str) {
        this.faX = str;
    }

    public void qE(int i) {
        this.faZ = i;
    }

    public void qF(int i) {
        this.fba = i;
    }

    public void qG(int i) {
        this.fbb = i;
    }

    public void bM(String str, String str2) {
        if (this.faS == null) {
            this.faS = new JSONObject();
        }
        try {
            this.faS.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bbt() {
        if (this.faY != null) {
            return this.faY;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.faU);
            jSONObject.put("da_type", this.faT);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.faW);
            jSONObject.put("net_type", this.faV);
            jSONObject.put("page_num", this.pageNumber);
            jSONObject.put("da_price", this.faX);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("action_type", this.faZ);
            jSONObject.put("total_dur", this.fba);
            jSONObject.put("play_dur", this.fbb);
        } catch (JSONException e) {
        }
        if (this.faS != null) {
            try {
                jSONObject.put("ext", this.faS);
            } catch (Exception e2) {
            }
        }
        this.faY = jSONObject;
        return jSONObject;
    }
}
