package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private int fFA;
    private long fFB = System.currentTimeMillis() / 1000;
    private String fFC;
    private JSONObject fFD;
    private int fFE;
    private int fFF;
    private int fFG;
    private int fFH;
    private int fFI;
    private int fFJ;
    private String fFK;
    private String fFL;
    private String fFM;
    private String fFN;
    private String fFO;
    private String fFP;
    private JSONObject fFy;
    private int fFz;
    private int pageNumber;
    private String placeId;

    public void qO(String str) {
        this.extInfo = str;
    }

    public void sd(int i) {
        this.fFz = i;
    }

    public void se(int i) {
        this.fFA = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void qP(String str) {
        this.placeId = str;
    }

    public void qQ(String str) {
        this.fFC = str;
    }

    public void sf(int i) {
        this.fFH = i;
    }

    public void sg(int i) {
        this.fFI = i;
    }

    public void sh(int i) {
        this.fFJ = i;
    }

    public void qR(String str) {
        this.fFK = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fFA = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fFC = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bT(String str, String str2) {
        if (this.fFy == null) {
            this.fFy = new JSONObject();
        }
        try {
            this.fFy.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bgx() {
        if (this.fFD != null) {
            return this.fFD;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fFA);
            jSONObject.put("da_type", this.fFz);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fFB);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fFC);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fFE);
            jSONObject.put("ext3", this.fFG);
            jSONObject.put("ext2", this.fFF);
            jSONObject.put("da_ext1", this.fFH);
            jSONObject.put("da_ext2", this.fFI);
            jSONObject.put("da_ext3", this.fFJ);
            jSONObject.put("da_menu1", this.fFL);
            jSONObject.put("da_menu2", this.fFM);
            jSONObject.put("da_menu3", this.fFN);
            jSONObject.put("da_page", this.fFO);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fFK);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.fFP);
        } catch (JSONException e) {
        }
        if (this.fFy != null) {
            try {
                jSONObject.put("ext", this.fFy);
            } catch (Exception e2) {
            }
        }
        this.fFD = jSONObject;
        return jSONObject;
    }

    public void qS(String str) {
        this.fFL = str;
    }

    public void qT(String str) {
        this.fFM = str;
    }

    public void qU(String str) {
        this.fFN = str;
    }

    public void qV(String str) {
        this.fFO = str;
    }

    public void qW(String str) {
        this.fFP = str;
    }
}
