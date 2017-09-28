package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject fFN;
    private int fFO;
    private int fFP;
    private long fFQ = System.currentTimeMillis() / 1000;
    private String fFR;
    private JSONObject fFS;
    private int fFT;
    private int fFU;
    private int fFV;
    private int fFW;
    private int fFX;
    private int fFY;
    private String fFZ;
    private String fGa;
    private String fGb;
    private String fGc;
    private String fGd;
    private String fGe;
    private int pageNumber;
    private String placeId;

    public void qP(String str) {
        this.extInfo = str;
    }

    public void se(int i) {
        this.fFO = i;
    }

    public void sf(int i) {
        this.fFP = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void qQ(String str) {
        this.placeId = str;
    }

    public void qR(String str) {
        this.fFR = str;
    }

    public void sg(int i) {
        this.fFW = i;
    }

    public void sh(int i) {
        this.fFX = i;
    }

    public void si(int i) {
        this.fFY = i;
    }

    public void qS(String str) {
        this.fFZ = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fFP = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fFR = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bU(String str, String str2) {
        if (this.fFN == null) {
            this.fFN = new JSONObject();
        }
        try {
            this.fFN.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bgD() {
        if (this.fFS != null) {
            return this.fFS;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fFP);
            jSONObject.put("da_type", this.fFO);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fFQ);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fFR);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fFT);
            jSONObject.put("ext3", this.fFV);
            jSONObject.put("ext2", this.fFU);
            jSONObject.put("da_ext1", this.fFW);
            jSONObject.put("da_ext2", this.fFX);
            jSONObject.put("da_ext3", this.fFY);
            jSONObject.put("da_menu1", this.fGa);
            jSONObject.put("da_menu2", this.fGb);
            jSONObject.put("da_menu3", this.fGc);
            jSONObject.put("da_page", this.fGd);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fFZ);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.fGe);
        } catch (JSONException e) {
        }
        if (this.fFN != null) {
            try {
                jSONObject.put("ext", this.fFN);
            } catch (Exception e2) {
            }
        }
        this.fFS = jSONObject;
        return jSONObject;
    }

    public void qT(String str) {
        this.fGa = str;
    }

    public void qU(String str) {
        this.fGb = str;
    }

    public void qV(String str) {
        this.fGc = str;
    }

    public void qW(String str) {
        this.fGd = str;
    }

    public void qX(String str) {
        this.fGe = str;
    }
}
