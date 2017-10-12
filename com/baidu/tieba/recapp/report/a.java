package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject fFM;
    private int fFN;
    private int fFO;
    private long fFP = System.currentTimeMillis() / 1000;
    private String fFQ;
    private JSONObject fFR;
    private int fFS;
    private int fFT;
    private int fFU;
    private int fFV;
    private int fFW;
    private int fFX;
    private String fFY;
    private String fFZ;
    private String fGa;
    private String fGb;
    private String fGc;
    private String fGd;
    private int pageNumber;
    private String placeId;

    public void qP(String str) {
        this.extInfo = str;
    }

    public void se(int i) {
        this.fFN = i;
    }

    public void sf(int i) {
        this.fFO = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void qQ(String str) {
        this.placeId = str;
    }

    public void qR(String str) {
        this.fFQ = str;
    }

    public void sg(int i) {
        this.fFV = i;
    }

    public void sh(int i) {
        this.fFW = i;
    }

    public void si(int i) {
        this.fFX = i;
    }

    public void qS(String str) {
        this.fFY = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fFO = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fFQ = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bU(String str, String str2) {
        if (this.fFM == null) {
            this.fFM = new JSONObject();
        }
        try {
            this.fFM.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bgC() {
        if (this.fFR != null) {
            return this.fFR;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fFO);
            jSONObject.put("da_type", this.fFN);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fFP);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fFQ);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fFS);
            jSONObject.put("ext3", this.fFU);
            jSONObject.put("ext2", this.fFT);
            jSONObject.put("da_ext1", this.fFV);
            jSONObject.put("da_ext2", this.fFW);
            jSONObject.put("da_ext3", this.fFX);
            jSONObject.put("da_menu1", this.fFZ);
            jSONObject.put("da_menu2", this.fGa);
            jSONObject.put("da_menu3", this.fGb);
            jSONObject.put("da_page", this.fGc);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fFY);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.fGd);
        } catch (JSONException e) {
        }
        if (this.fFM != null) {
            try {
                jSONObject.put("ext", this.fFM);
            } catch (Exception e2) {
            }
        }
        this.fFR = jSONObject;
        return jSONObject;
    }

    public void qT(String str) {
        this.fFZ = str;
    }

    public void qU(String str) {
        this.fGa = str;
    }

    public void qV(String str) {
        this.fGb = str;
    }

    public void qW(String str) {
        this.fGc = str;
    }

    public void qX(String str) {
        this.fGd = str;
    }
}
