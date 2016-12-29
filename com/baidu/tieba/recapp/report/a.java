package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private JSONObject eOA;
    private int eOB;
    private int eOC;
    private int eOD;
    private String eOE;
    private String eOF;
    private String eOG;
    private String eOH;
    private String eOI;
    private JSONObject eOv;
    private int eOw;
    private int eOx;
    private long eOy = System.currentTimeMillis() / 1000;
    private String eOz;
    private String extInfo;
    private int pageNumber;

    public void pB(String str) {
        this.extInfo = str;
    }

    public void qj(int i) {
        this.eOw = i;
    }

    public void qk(int i) {
        this.eOx = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void pC(String str) {
        this.eOz = str;
    }

    public void ql(int i) {
        this.eOB = i;
    }

    public void qm(int i) {
        this.eOD = i;
    }

    public void qn(int i) {
        this.eOC = i;
    }

    public void pD(String str) {
        this.eOE = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.eOx = com.baidu.adp.lib.h.b.g(downloadStaticsData.getAdPosition(), 0);
            this.eOz = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bS(String str, String str2) {
        if (this.eOv == null) {
            this.eOv = new JSONObject();
        }
        try {
            this.eOv.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject aYr() {
        if (this.eOA != null) {
            return this.eOA;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.eOx);
            jSONObject.put("da_type", this.eOw);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.eOy);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.eOz);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.eOB);
            jSONObject.put("ext3", this.eOD);
            jSONObject.put("ext2", this.eOC);
            jSONObject.put("da_menu1", this.eOF);
            jSONObject.put("da_menu2", this.eOG);
            jSONObject.put("da_menu3", this.eOH);
            jSONObject.put("da_page", this.eOI);
            jSONObject.put("lego_extra", this.eOE);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
        } catch (JSONException e) {
        }
        if (this.eOv != null) {
            try {
                jSONObject.put("ext", this.eOv);
            } catch (Exception e2) {
            }
        }
        this.eOA = jSONObject;
        return jSONObject;
    }

    public void pE(String str) {
        this.eOF = str;
    }

    public void pF(String str) {
        this.eOG = str;
    }

    public void pG(String str) {
        this.eOH = str;
    }

    public void pH(String str) {
        this.eOI = str;
    }
}
