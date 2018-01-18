package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONObject cKa;
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private int gEA;
    private int gEB;
    private String gEC;
    private String gED;
    private String gEE;
    private String gEF;
    private String gEG;
    private String gEH;
    private JSONObject gEq;
    private int gEr;
    private int gEs;
    private long gEt = System.currentTimeMillis() / 1000;
    private String gEu;
    private int gEv;
    private int gEw;
    private int gEx;
    private int gEy;
    private int gEz;
    private int pageNumber;
    private String placeId;

    public void rH(String str) {
        this.extInfo = str;
    }

    public void us(int i) {
        this.gEr = i;
    }

    public void ut(int i) {
        this.gEs = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void rI(String str) {
        this.placeId = str;
    }

    public void rJ(String str) {
        this.gEu = str;
    }

    public void uu(int i) {
        this.gEy = i;
    }

    public void uv(int i) {
        this.gEz = i;
    }

    public void uw(int i) {
        this.gEA = i;
    }

    public void ux(int i) {
        this.gEB = i;
    }

    public void rK(String str) {
        this.gEC = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gEs = com.baidu.adp.lib.g.b.h(downloadStaticsData.getAdPosition(), 0);
            this.gEu = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bT(String str, String str2) {
        if (this.gEq == null) {
            this.gEq = new JSONObject();
        }
        try {
            this.gEq.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bnA() {
        if (this.cKa != null) {
            return this.cKa;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.gEs);
            jSONObject.put("da_type", this.gEr);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gEt);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.gEu);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gEv);
            jSONObject.put("ext3", this.gEx);
            jSONObject.put("ext2", this.gEw);
            jSONObject.put("da_ext1", this.gEy);
            jSONObject.put("da_ext2", this.gEz);
            jSONObject.put("da_ext3", this.gEA);
            jSONObject.put("da_ext4", this.gEB);
            jSONObject.put("da_menu1", this.gED);
            jSONObject.put("da_menu2", this.gEE);
            jSONObject.put("da_menu3", this.gEF);
            jSONObject.put("da_page", this.gEG);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gEC);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gEH);
        } catch (JSONException e) {
        }
        if (this.gEq != null) {
            try {
                jSONObject.put("ext", this.gEq);
            } catch (Exception e2) {
            }
        }
        this.cKa = jSONObject;
        return jSONObject;
    }

    public void rL(String str) {
        this.gED = str;
    }

    public void rM(String str) {
        this.gEE = str;
    }

    public void rN(String str) {
        this.gEF = str;
    }

    public void rO(String str) {
        this.gEG = str;
    }

    public void rP(String str) {
        this.gEH = str;
    }
}
