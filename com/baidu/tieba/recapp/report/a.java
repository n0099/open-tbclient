package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONObject dXj;
    private String dXk;
    private int dXl;
    private String dXo;
    private JSONObject dXp;
    private String extInfo;
    private int pageNumber;
    private long dXn = System.currentTimeMillis() / 1000;
    private int dXm = i.fw();

    public void np(String str) {
        this.extInfo = str;
    }

    public void nq(String str) {
        this.dXk = str;
    }

    public void og(int i) {
        this.dXl = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void nr(String str) {
        this.dXo = str;
    }

    public void bE(String str, String str2) {
        if (this.dXj == null) {
            this.dXj = new JSONObject();
        }
        try {
            this.dXj.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject aLI() {
        if (this.dXp != null) {
            return this.dXp;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.dXl);
            jSONObject.put("da_type", this.dXk);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.dXn);
            jSONObject.put("net_type", this.dXm);
            jSONObject.put("page_num", this.pageNumber);
            jSONObject.put("da_price", this.dXo);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
        } catch (JSONException e) {
        }
        if (this.dXj != null) {
            try {
                jSONObject.put("ext", this.dXj);
            } catch (Exception e2) {
            }
        }
        this.dXp = jSONObject;
        return jSONObject;
    }
}
