package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String dnB;
    private JSONObject dnw;
    private String dnx;
    private int dny;
    private String extInfo;
    private JSONObject jsonObject;
    private int pageNumber;
    private long dnA = System.currentTimeMillis() / 1000;
    private int dnz = i.iW();

    public void lQ(String str) {
        this.extInfo = str;
    }

    public void lR(String str) {
        this.dnx = str;
    }

    public void mk(int i) {
        this.dny = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void lS(String str) {
        this.dnB = str;
    }

    public void aZ(String str, String str2) {
        if (this.dnw == null) {
            this.dnw = new JSONObject();
        }
        try {
            this.dnw.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject axM() {
        if (this.jsonObject != null) {
            return this.jsonObject;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.dny);
            jSONObject.put("da_type", this.dnx);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.dnA);
            jSONObject.put("net_type", this.dnz);
            jSONObject.put("page_num", this.pageNumber);
            jSONObject.put("da_price", this.dnB);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
        } catch (JSONException e) {
        }
        if (this.dnw != null) {
            try {
                jSONObject.put("ext", this.dnw);
            } catch (Exception e2) {
            }
        }
        this.jsonObject = jSONObject;
        return jSONObject;
    }
}
