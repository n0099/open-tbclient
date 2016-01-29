package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String dCA;
    private int dCB;
    private String dCE;
    private JSONObject dCF;
    private JSONObject dCz;
    private String extInfo;
    private int pageNumber;
    private long dCD = System.currentTimeMillis() / 1000;
    private int dCC = i.jf();

    public void mh(String str) {
        this.extInfo = str;
    }

    public void mi(String str) {
        this.dCA = str;
    }

    public void no(int i) {
        this.dCB = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void mj(String str) {
        this.dCE = str;
    }

    public void bj(String str, String str2) {
        if (this.dCz == null) {
            this.dCz = new JSONObject();
        }
        try {
            this.dCz.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject aEJ() {
        if (this.dCF != null) {
            return this.dCF;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.dCB);
            jSONObject.put("da_type", this.dCA);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.dCD);
            jSONObject.put("net_type", this.dCC);
            jSONObject.put("page_num", this.pageNumber);
            jSONObject.put("da_price", this.dCE);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
        } catch (JSONException e) {
        }
        if (this.dCz != null) {
            try {
                jSONObject.put("ext", this.dCz);
            } catch (Exception e2) {
            }
        }
        this.dCF = jSONObject;
        return jSONObject;
    }
}
