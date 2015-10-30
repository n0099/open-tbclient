package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String cHL;
    private int cHM;
    private int cHN;
    private String cHQ;
    private String extInfo;
    private JSONObject jsonObject;
    private long cHP = System.currentTimeMillis() / 1000;
    private int cHO = i.iS();

    public void kS(String str) {
        this.extInfo = str;
    }

    public void kT(String str) {
        this.cHL = str;
    }

    public void km(int i) {
        this.cHM = i;
    }

    public void kn(int i) {
        this.cHN = i;
    }

    public void kU(String str) {
        this.cHQ = str;
    }

    public JSONObject apB() {
        if (this.jsonObject != null) {
            return this.jsonObject;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.cHM);
            jSONObject.put("da_type", this.cHL);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.cHP);
            jSONObject.put("net_type", this.cHO);
            jSONObject.put("page_num", this.cHN);
            jSONObject.put("da_price", this.cHQ);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.jsonObject = jSONObject;
        return jSONObject;
    }
}
