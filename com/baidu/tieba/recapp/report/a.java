package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONObject dUr;
    private String dUs;
    private int dUt;
    private String dUw;
    private JSONObject dUx;
    private String extInfo;
    private int pageNumber;
    private long dUv = System.currentTimeMillis() / 1000;
    private int dUu = i.jl();

    public void nq(String str) {
        this.extInfo = str;
    }

    public void nr(String str) {
        this.dUs = str;
    }

    public void or(int i) {
        this.dUt = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void ns(String str) {
        this.dUw = str;
    }

    public void bz(String str, String str2) {
        if (this.dUr == null) {
            this.dUr = new JSONObject();
        }
        try {
            this.dUr.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject aLB() {
        if (this.dUx != null) {
            return this.dUx;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.dUt);
            jSONObject.put("da_type", this.dUs);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.dUv);
            jSONObject.put("net_type", this.dUu);
            jSONObject.put("page_num", this.pageNumber);
            jSONObject.put("da_price", this.dUw);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
        } catch (JSONException e) {
        }
        if (this.dUr != null) {
            try {
                jSONObject.put("ext", this.dUr);
            } catch (Exception e2) {
            }
        }
        this.dUx = jSONObject;
        return jSONObject;
    }
}
