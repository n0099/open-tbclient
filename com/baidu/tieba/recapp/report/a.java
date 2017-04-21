package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject ffP;
    private int ffQ;
    private int ffR;
    private long ffS = System.currentTimeMillis() / 1000;
    private String ffT;
    private JSONObject ffU;
    private int ffV;
    private int ffW;
    private int ffX;
    private int ffY;
    private int ffZ;
    private int fga;
    private String fgb;
    private String fgc;
    private String fgd;
    private String fge;
    private String fgf;
    private int pageNumber;
    private String placeId;

    public void pu(String str) {
        this.extInfo = str;
    }

    public void qU(int i) {
        this.ffQ = i;
    }

    public void qV(int i) {
        this.ffR = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void pv(String str) {
        this.placeId = str;
    }

    public void pw(String str) {
        this.ffT = str;
    }

    public void qW(int i) {
        this.ffY = i;
    }

    public void qX(int i) {
        this.ffZ = i;
    }

    public void qY(int i) {
        this.fga = i;
    }

    public void px(String str) {
        this.fgb = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.ffR = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.ffT = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bT(String str, String str2) {
        if (this.ffP == null) {
            this.ffP = new JSONObject();
        }
        try {
            this.ffP.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bbz() {
        if (this.ffU != null) {
            return this.ffU;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.ffR);
            jSONObject.put("da_type", this.ffQ);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.ffS);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.ffT);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.ffV);
            jSONObject.put("ext3", this.ffX);
            jSONObject.put("ext2", this.ffW);
            jSONObject.put("da_ext1", this.ffY);
            jSONObject.put("da_ext2", this.ffZ);
            jSONObject.put("da_ext3", this.fga);
            jSONObject.put("da_menu1", this.fgc);
            jSONObject.put("da_menu2", this.fgd);
            jSONObject.put("da_menu3", this.fge);
            jSONObject.put("da_page", this.fgf);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.fgb);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
        } catch (JSONException e) {
        }
        if (this.ffP != null) {
            try {
                jSONObject.put("ext", this.ffP);
            } catch (Exception e2) {
            }
        }
        this.ffU = jSONObject;
        return jSONObject;
    }

    public void py(String str) {
        this.fgc = str;
    }

    public void pz(String str) {
        this.fgd = str;
    }

    public void pA(String str) {
        this.fge = str;
    }

    public void pB(String str) {
        this.fgf = str;
    }
}
