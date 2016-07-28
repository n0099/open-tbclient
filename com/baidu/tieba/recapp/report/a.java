package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONObject eTG;
    private String eTH;
    private int eTI;
    private String eTL;
    private JSONObject eTM;
    private String extInfo;
    private int pageNumber;
    private long eTK = System.currentTimeMillis() / 1000;
    private int eTJ = i.fw();

    public void pI(String str) {
        this.extInfo = str;
    }

    public void pJ(String str) {
        this.eTH = str;
    }

    public void qf(int i) {
        this.eTI = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void pK(String str) {
        this.eTL = str;
    }

    public void bL(String str, String str2) {
        if (this.eTG == null) {
            this.eTG = new JSONObject();
        }
        try {
            this.eTG.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject aYb() {
        if (this.eTM != null) {
            return this.eTM;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.eTI);
            jSONObject.put("da_type", this.eTH);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.eTK);
            jSONObject.put("net_type", this.eTJ);
            jSONObject.put("page_num", this.pageNumber);
            jSONObject.put("da_price", this.eTL);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
        } catch (JSONException e) {
        }
        if (this.eTG != null) {
            try {
                jSONObject.put("ext", this.eTG);
            } catch (Exception e2) {
            }
        }
        this.eTM = jSONObject;
        return jSONObject;
    }
}
