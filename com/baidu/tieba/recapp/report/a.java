package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private int fdA;
    private long fdB = System.currentTimeMillis() / 1000;
    private String fdC;
    private JSONObject fdD;
    private int fdE;
    private int fdF;
    private int fdG;
    private int fdH;
    private int fdI;
    private int fdJ;
    private String fdK;
    private String fdL;
    private String fdM;
    private String fdN;
    private String fdO;
    private JSONObject fdy;
    private int fdz;
    private int pageNumber;
    private String placeId;

    public void pt(String str) {
        this.extInfo = str;
    }

    public void qO(int i) {
        this.fdz = i;
    }

    public void qP(int i) {
        this.fdA = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void pu(String str) {
        this.placeId = str;
    }

    public void pv(String str) {
        this.fdC = str;
    }

    public void qQ(int i) {
        this.fdH = i;
    }

    public void qR(int i) {
        this.fdI = i;
    }

    public void qS(int i) {
        this.fdJ = i;
    }

    public void pw(String str) {
        this.fdK = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.fdA = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.fdC = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bU(String str, String str2) {
        if (this.fdy == null) {
            this.fdy = new JSONObject();
        }
        try {
            this.fdy.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bay() {
        if (this.fdD != null) {
            return this.fdD;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.fdA);
            jSONObject.put("da_type", this.fdz);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.fdB);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.fdC);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.fdE);
            jSONObject.put("ext3", this.fdG);
            jSONObject.put("ext2", this.fdF);
            jSONObject.put("da_ext1", this.fdH);
            jSONObject.put("da_ext2", this.fdI);
            jSONObject.put("da_ext3", this.fdJ);
            jSONObject.put("da_menu1", this.fdL);
            jSONObject.put("da_menu2", this.fdM);
            jSONObject.put("da_menu3", this.fdN);
            jSONObject.put("da_page", this.fdO);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fdK);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
        } catch (JSONException e) {
        }
        if (this.fdy != null) {
            try {
                jSONObject.put("ext", this.fdy);
            } catch (Exception e2) {
            }
        }
        this.fdD = jSONObject;
        return jSONObject;
    }

    public void px(String str) {
        this.fdL = str;
    }

    public void py(String str) {
        this.fdM = str;
    }

    public void pz(String str) {
        this.fdN = str;
    }

    public void pA(String str) {
        this.fdO = str;
    }
}
