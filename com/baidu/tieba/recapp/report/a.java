package com.baidu.tieba.recapp.report;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private JSONObject eXY;
    private int eXZ;
    private int eYa;
    private long eYb = System.currentTimeMillis() / 1000;
    private String eYc;
    private JSONObject eYd;
    private int eYe;
    private int eYf;
    private int eYg;
    private String eYh;
    private String eYi;
    private String eYj;
    private String eYk;
    private String eYl;
    private String extInfo;
    private int pageNumber;

    public void pV(String str) {
        this.extInfo = str;
    }

    public void qT(int i) {
        this.eXZ = i;
    }

    public void qU(int i) {
        this.eYa = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void pW(String str) {
        this.eYc = str;
    }

    public void qV(int i) {
        this.eYe = i;
    }

    public void qW(int i) {
        this.eYg = i;
    }

    public void qX(int i) {
        this.eYf = i;
    }

    public void pX(String str) {
        this.eYh = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.eYa = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.eYc = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void cb(String str, String str2) {
        if (this.eXY == null) {
            this.eXY = new JSONObject();
        }
        try {
            this.eXY.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bah() {
        if (this.eYd != null) {
            return this.eYd;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.eYa);
            jSONObject.put("da_type", this.eXZ);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.eYb);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.eYc);
            jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.eYe);
            jSONObject.put("ext3", this.eYg);
            jSONObject.put("ext2", this.eYf);
            jSONObject.put("da_menu1", this.eYi);
            jSONObject.put("da_menu2", this.eYj);
            jSONObject.put("da_menu3", this.eYk);
            jSONObject.put("da_page", this.eYl);
            jSONObject.put("lego_extra", this.eYh);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
        } catch (JSONException e) {
        }
        if (this.eXY != null) {
            try {
                jSONObject.put("ext", this.eXY);
            } catch (Exception e2) {
            }
        }
        this.eYd = jSONObject;
        return jSONObject;
    }

    public void pY(String str) {
        this.eYi = str;
    }

    public void pZ(String str) {
        this.eYj = str;
    }

    public void qa(String str) {
        this.eYk = str;
    }

    public void qb(String str) {
        this.eYl = str;
    }
}
