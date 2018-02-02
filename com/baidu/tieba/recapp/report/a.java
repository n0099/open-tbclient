package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONObject cKn;
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gEL;
    private int gEM;
    private int gEN;
    private long gEO = System.currentTimeMillis() / 1000;
    private String gEP;
    private int gEQ;
    private int gER;
    private int gES;
    private int gET;
    private int gEU;
    private int gEV;
    private int gEW;
    private String gEX;
    private String gEY;
    private String gEZ;
    private String gFa;
    private String gFb;
    private String gFc;
    private int pageNumber;
    private String placeId;

    public void rP(String str) {
        this.extInfo = str;
    }

    public void us(int i) {
        this.gEM = i;
    }

    public void ut(int i) {
        this.gEN = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void rQ(String str) {
        this.placeId = str;
    }

    public void rR(String str) {
        this.gEP = str;
    }

    public void uu(int i) {
        this.gET = i;
    }

    public void uv(int i) {
        this.gEU = i;
    }

    public void uw(int i) {
        this.gEV = i;
    }

    public void ux(int i) {
        this.gEW = i;
    }

    public void rS(String str) {
        this.gEX = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gEN = com.baidu.adp.lib.g.b.h(downloadStaticsData.getAdPosition(), 0);
            this.gEP = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bS(String str, String str2) {
        if (this.gEL == null) {
            this.gEL = new JSONObject();
        }
        try {
            this.gEL.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bnB() {
        if (this.cKn != null) {
            return this.cKn;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.gEN);
            jSONObject.put("da_type", this.gEM);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gEO);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.gEP);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gEQ);
            jSONObject.put("ext3", this.gES);
            jSONObject.put("ext2", this.gER);
            jSONObject.put("da_ext1", this.gET);
            jSONObject.put("da_ext2", this.gEU);
            jSONObject.put("da_ext3", this.gEV);
            jSONObject.put("da_ext4", this.gEW);
            jSONObject.put("da_menu1", this.gEY);
            jSONObject.put("da_menu2", this.gEZ);
            jSONObject.put("da_menu3", this.gFa);
            jSONObject.put("da_page", this.gFb);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gEX);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gFc);
        } catch (JSONException e) {
        }
        if (this.gEL != null) {
            try {
                jSONObject.put("ext", this.gEL);
            } catch (Exception e2) {
            }
        }
        this.cKn = jSONObject;
        return jSONObject;
    }

    public void rT(String str) {
        this.gEY = str;
    }

    public void rU(String str) {
        this.gEZ = str;
    }

    public void rV(String str) {
        this.gFa = str;
    }

    public void rW(String str) {
        this.gFb = str;
    }

    public void rX(String str) {
        this.gFc = str;
    }
}
