package com.baidu.tieba.recapp.report;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String cJh;
    private int cJi;
    private int cJj;
    private String cJm;
    private String extInfo;
    private JSONObject jsonObject;
    private long cJl = System.currentTimeMillis() / 1000;
    private int cJk = i.iT();

    public void kW(String str) {
        this.extInfo = str;
    }

    public void kX(String str) {
        this.cJh = str;
    }

    public void kA(int i) {
        this.cJi = i;
    }

    public void kB(int i) {
        this.cJj = i;
    }

    public void kY(String str) {
        this.cJm = str;
    }

    public JSONObject aqh() {
        if (this.jsonObject != null) {
            return this.jsonObject;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.cJi);
            jSONObject.put("da_type", this.cJh);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.cJl);
            jSONObject.put("net_type", this.cJk);
            jSONObject.put("page_num", this.cJj);
            jSONObject.put("da_price", this.cJm);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.jsonObject = jSONObject;
        return jSONObject;
    }
}
