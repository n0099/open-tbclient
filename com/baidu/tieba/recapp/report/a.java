package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONObject cNZ;
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gGN;
    private int gGO;
    private int gGP;
    private long gGQ = System.currentTimeMillis() / 1000;
    private String gGR;
    private int gGS;
    private int gGT;
    private int gGU;
    private int gGV;
    private int gGW;
    private int gGX;
    private int gGY;
    private String gGZ;
    private String gHa;
    private String gHb;
    private String gHc;
    private String gHd;
    private String gHe;
    private int pageNumber;
    private String placeId;

    public void rW(String str) {
        this.extInfo = str;
    }

    public void us(int i) {
        this.gGO = i;
        if (this.cNZ != null) {
            try {
                this.cNZ.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void ut(int i) {
        this.gGP = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void rX(String str) {
        this.placeId = str;
    }

    public void rY(String str) {
        this.gGR = str;
    }

    public void uu(int i) {
        this.gGV = i;
    }

    public void uv(int i) {
        this.gGW = i;
    }

    public void uw(int i) {
        this.gGX = i;
    }

    public void ux(int i) {
        this.gGY = i;
    }

    public void rZ(String str) {
        this.gGZ = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gGP = com.baidu.adp.lib.g.b.h(downloadStaticsData.getAdPosition(), 0);
            this.gGR = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bS(String str, String str2) {
        if (this.gGN == null) {
            this.gGN = new JSONObject();
        }
        try {
            this.gGN.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject boV() {
        if (this.cNZ != null) {
            return this.cNZ;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.gGP);
            jSONObject.put("da_type", this.gGO);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gGQ);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.gGR);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gGS);
            jSONObject.put("ext3", this.gGU);
            jSONObject.put("ext2", this.gGT);
            jSONObject.put("da_ext1", this.gGV);
            jSONObject.put("da_ext2", this.gGW);
            jSONObject.put("da_ext3", this.gGX);
            jSONObject.put("da_ext4", this.gGY);
            jSONObject.put("da_menu1", this.gHa);
            jSONObject.put("da_menu2", this.gHb);
            jSONObject.put("da_menu3", this.gHc);
            jSONObject.put("da_page", this.gHd);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gGZ);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gHe);
        } catch (JSONException e) {
        }
        if (this.gGN != null) {
            try {
                jSONObject.put("ext", this.gGN);
            } catch (Exception e2) {
            }
        }
        this.cNZ = jSONObject;
        return jSONObject;
    }

    public void sa(String str) {
        this.gHa = str;
    }

    public void sb(String str) {
        this.gHb = str;
    }

    public void sc(String str) {
        this.gHc = str;
    }

    public void sd(String str) {
        this.gHd = str;
    }

    public void se(String str) {
        this.gHe = str;
    }
}
