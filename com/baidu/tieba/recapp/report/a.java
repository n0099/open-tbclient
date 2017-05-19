package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject fbI;
    private int fbJ;
    private int fbK;
    private long fbL = System.currentTimeMillis() / 1000;
    private String fbM;
    private JSONObject fbN;
    private int fbO;
    private int fbP;
    private int fbQ;
    private int fbR;
    private int fbS;
    private int fbT;
    private String fbU;
    private String fbV;
    private String fbW;
    private String fbX;
    private String fbY;
    private int pageNumber;
    private String placeId;

    public void ps(String str) {
        this.extInfo = str;
    }

    public void qM(int i) {
        this.fbJ = i;
    }

    public void qN(int i) {
        this.fbK = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void pt(String str) {
        this.placeId = str;
    }

    public void pu(String str) {
        this.fbM = str;
    }

    public void qO(int i) {
        this.fbR = i;
    }

    public void qP(int i) {
        this.fbS = i;
    }

    public void qQ(int i) {
        this.fbT = i;
    }

    public void pv(String str) {
        this.fbU = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fbK = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fbM = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bT(String str, String str2) {
        if (this.fbI == null) {
            this.fbI = new JSONObject();
        }
        try {
            this.fbI.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject aYY() {
        if (this.fbN != null) {
            return this.fbN;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fbK);
            jSONObject.put("da_type", this.fbJ);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fbL);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fbM);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fbO);
            jSONObject.put("ext3", this.fbQ);
            jSONObject.put("ext2", this.fbP);
            jSONObject.put("da_ext1", this.fbR);
            jSONObject.put("da_ext2", this.fbS);
            jSONObject.put("da_ext3", this.fbT);
            jSONObject.put("da_menu1", this.fbV);
            jSONObject.put("da_menu2", this.fbW);
            jSONObject.put("da_menu3", this.fbX);
            jSONObject.put("da_page", this.fbY);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fbU);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
        } catch (JSONException e) {
        }
        if (this.fbI != null) {
            try {
                jSONObject.put("ext", this.fbI);
            } catch (Exception e2) {
            }
        }
        this.fbN = jSONObject;
        return jSONObject;
    }

    public void pw(String str) {
        this.fbV = str;
    }

    public void px(String str) {
        this.fbW = str;
    }

    public void py(String str) {
        this.fbX = str;
    }

    public void pz(String str) {
        this.fbY = str;
    }
}
