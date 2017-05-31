package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject fjM;
    private int fjN;
    private int fjO;
    private long fjP = System.currentTimeMillis() / 1000;
    private String fjQ;
    private JSONObject fjR;
    private int fjS;
    private int fjT;
    private int fjU;
    private int fjV;
    private int fjW;
    private int fjX;
    private String fjY;
    private String fjZ;
    private String fka;
    private String fkb;
    private String fkc;
    private int pageNumber;
    private String placeId;

    public void pH(String str) {
        this.extInfo = str;
    }

    public void rj(int i) {
        this.fjN = i;
    }

    public void rk(int i) {
        this.fjO = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void pI(String str) {
        this.placeId = str;
    }

    public void pJ(String str) {
        this.fjQ = str;
    }

    public void rl(int i) {
        this.fjV = i;
    }

    public void rm(int i) {
        this.fjW = i;
    }

    public void rn(int i) {
        this.fjX = i;
    }

    public void pK(String str) {
        this.fjY = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fjO = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fjQ = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bT(String str, String str2) {
        if (this.fjM == null) {
            this.fjM = new JSONObject();
        }
        try {
            this.fjM.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bar() {
        if (this.fjR != null) {
            return this.fjR;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fjO);
            jSONObject.put("da_type", this.fjN);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fjP);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fjQ);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fjS);
            jSONObject.put("ext3", this.fjU);
            jSONObject.put("ext2", this.fjT);
            jSONObject.put("da_ext1", this.fjV);
            jSONObject.put("da_ext2", this.fjW);
            jSONObject.put("da_ext3", this.fjX);
            jSONObject.put("da_menu1", this.fjZ);
            jSONObject.put("da_menu2", this.fka);
            jSONObject.put("da_menu3", this.fkb);
            jSONObject.put("da_page", this.fkc);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fjY);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
        } catch (JSONException e) {
        }
        if (this.fjM != null) {
            try {
                jSONObject.put("ext", this.fjM);
            } catch (Exception e2) {
            }
        }
        this.fjR = jSONObject;
        return jSONObject;
    }

    public void pL(String str) {
        this.fjZ = str;
    }

    public void pM(String str) {
        this.fka = str;
    }

    public void pN(String str) {
        this.fkb = str;
    }

    public void pO(String str) {
        this.fkc = str;
    }
}
