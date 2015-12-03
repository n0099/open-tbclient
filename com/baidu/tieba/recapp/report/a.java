package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String dhQ;
    private int dhR;
    private String dhU;
    private String extInfo;
    private JSONObject jsonObject;
    private int pageNumber;
    private long dhT = System.currentTimeMillis() / 1000;
    private int dhS = i.iV();

    public void lT(String str) {
        this.extInfo = str;
    }

    public void lU(String str) {
        this.dhQ = str;
    }

    public void lL(int i) {
        this.dhR = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void lV(String str) {
        this.dhU = str;
    }

    public JSONObject avT() {
        if (this.jsonObject != null) {
            return this.jsonObject;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.dhR);
            jSONObject.put("da_type", this.dhQ);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.dhT);
            jSONObject.put("net_type", this.dhS);
            jSONObject.put("page_num", this.pageNumber);
            jSONObject.put("da_price", this.dhU);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.jsonObject = jSONObject;
        return jSONObject;
    }
}
