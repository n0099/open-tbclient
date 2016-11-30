package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject fkY;
    private int fkZ;
    private int fla;
    private long flb = System.currentTimeMillis() / 1000;
    private String flc;
    private JSONObject fld;
    private int fle;
    private int flf;
    private int flg;
    private String flh;
    private String fli;
    private String flj;
    private String flk;
    private String fll;
    private int pageNumber;

    public void qX(String str) {
        this.extInfo = str;
    }

    public void ri(int i) {
        this.fkZ = i;
    }

    public void rj(int i) {
        this.fla = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void qY(String str) {
        this.flc = str;
    }

    public void rk(int i) {
        this.fle = i;
    }

    public void rl(int i) {
        this.flg = i;
    }

    public void rm(int i) {
        this.flf = i;
    }

    public void qZ(String str) {
        this.flh = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fla = com.baidu.adp.lib.h.b.g(downloadStaticsData.getAdPosition(), 0);
            this.flc = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bP(String str, String str2) {
        if (this.fkY == null) {
            this.fkY = new JSONObject();
        }
        try {
            this.fkY.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject beE() {
        if (this.fld != null) {
            return this.fld;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fla);
            jSONObject.put("da_type", this.fkZ);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.flb);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.flc);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fle);
            jSONObject.put("ext3", this.flg);
            jSONObject.put("ext2", this.flf);
            jSONObject.put("da_menu1", this.fli);
            jSONObject.put("da_menu2", this.flj);
            jSONObject.put("da_menu3", this.flk);
            jSONObject.put("da_page", this.fll);
            jSONObject.put("lego_extra", this.flh);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
        } catch (JSONException e) {
        }
        if (this.fkY != null) {
            try {
                jSONObject.put("ext", this.fkY);
            } catch (Exception e2) {
            }
        }
        this.fld = jSONObject;
        return jSONObject;
    }

    public void ra(String str) {
        this.fli = str;
    }

    public void rb(String str) {
        this.flj = str;
    }

    public void rc(String str) {
        this.flk = str;
    }

    public void rd(String str) {
        this.fll = str;
    }
}
