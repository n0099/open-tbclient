package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONObject eGE;
    private String eGF;
    private int eGG;
    private String eGJ;
    private JSONObject eGK;
    private String extInfo;
    private int pageNumber;
    private long eGI = System.currentTimeMillis() / 1000;
    private int eGH = i.fx();

    public void oX(String str) {
        this.extInfo = str;
    }

    public void oY(String str) {
        this.eGF = str;
    }

    public void pN(int i) {
        this.eGG = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void oZ(String str) {
        this.eGJ = str;
    }

    public void bG(String str, String str2) {
        if (this.eGE == null) {
            this.eGE = new JSONObject();
        }
        try {
            this.eGE.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject aUN() {
        if (this.eGK != null) {
            return this.eGK;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.eGG);
            jSONObject.put("da_type", this.eGF);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.eGI);
            jSONObject.put("net_type", this.eGH);
            jSONObject.put("page_num", this.pageNumber);
            jSONObject.put("da_price", this.eGJ);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
        } catch (JSONException e) {
        }
        if (this.eGE != null) {
            try {
                jSONObject.put("ext", this.eGE);
            } catch (Exception e2) {
            }
        }
        this.eGK = jSONObject;
        return jSONObject;
    }
}
