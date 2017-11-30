package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject fYE;
    private int fYF;
    private int fYG;
    private long fYH = System.currentTimeMillis() / 1000;
    private String fYI;
    private JSONObject fYJ;
    private int fYK;
    private int fYL;
    private int fYM;
    private int fYN;
    private int fYO;
    private int fYP;
    private int fYQ;
    private String fYR;
    private String fYS;
    private String fYT;
    private String fYU;
    private String fYV;
    private String fYW;
    private int pageNumber;
    private String placeId;

    public void rX(String str) {
        this.extInfo = str;
    }

    public void sJ(int i) {
        this.fYF = i;
    }

    public void sK(int i) {
        this.fYG = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void rY(String str) {
        this.placeId = str;
    }

    public void rZ(String str) {
        this.fYI = str;
    }

    public void sL(int i) {
        this.fYN = i;
    }

    public void sM(int i) {
        this.fYO = i;
    }

    public void sN(int i) {
        this.fYP = i;
    }

    public void sO(int i) {
        this.fYQ = i;
    }

    public void sa(String str) {
        this.fYR = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fYG = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fYI = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bV(String str, String str2) {
        if (this.fYE == null) {
            this.fYE = new JSONObject();
        }
        try {
            this.fYE.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject blU() {
        if (this.fYJ != null) {
            return this.fYJ;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fYG);
            jSONObject.put("da_type", this.fYF);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fYH);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fYI);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fYK);
            jSONObject.put("ext3", this.fYM);
            jSONObject.put("ext2", this.fYL);
            jSONObject.put("da_ext1", this.fYN);
            jSONObject.put("da_ext2", this.fYO);
            jSONObject.put("da_ext3", this.fYP);
            jSONObject.put("da_ext4", this.fYQ);
            jSONObject.put("da_menu1", this.fYS);
            jSONObject.put("da_menu2", this.fYT);
            jSONObject.put("da_menu3", this.fYU);
            jSONObject.put("da_page", this.fYV);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fYR);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.fYW);
        } catch (JSONException e) {
        }
        if (this.fYE != null) {
            try {
                jSONObject.put("ext", this.fYE);
            } catch (Exception e2) {
            }
        }
        this.fYJ = jSONObject;
        return jSONObject;
    }

    public void sb(String str) {
        this.fYS = str;
    }

    public void sc(String str) {
        this.fYT = str;
    }

    public void sd(String str) {
        this.fYU = str;
    }

    public void se(String str) {
        this.fYV = str;
    }

    public void sf(String str) {
        this.fYW = str;
    }
}
