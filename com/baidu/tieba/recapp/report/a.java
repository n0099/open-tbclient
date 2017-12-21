package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private int gbA;
    private int gbB;
    private String gbC;
    private String gbD;
    private String gbE;
    private String gbF;
    private String gbG;
    private String gbH;
    private JSONObject gbp;
    private int gbq;
    private int gbr;
    private long gbs = System.currentTimeMillis() / 1000;
    private String gbt;
    private JSONObject gbu;
    private int gbv;
    private int gbw;
    private int gbx;
    private int gby;
    private int gbz;
    private int pageNumber;
    private String placeId;

    public void sb(String str) {
        this.extInfo = str;
    }

    public void sU(int i) {
        this.gbq = i;
    }

    public void sV(int i) {
        this.gbr = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void sc(String str) {
        this.placeId = str;
    }

    public void sd(String str) {
        this.gbt = str;
    }

    public void sW(int i) {
        this.gby = i;
    }

    public void sX(int i) {
        this.gbz = i;
    }

    public void sY(int i) {
        this.gbA = i;
    }

    public void sZ(int i) {
        this.gbB = i;
    }

    public void se(String str) {
        this.gbC = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gbr = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.gbt = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bW(String str, String str2) {
        if (this.gbp == null) {
            this.gbp = new JSONObject();
        }
        try {
            this.gbp.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bmA() {
        if (this.gbu != null) {
            return this.gbu;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.gbr);
            jSONObject.put("da_type", this.gbq);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gbs);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.gbt);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gbv);
            jSONObject.put("ext3", this.gbx);
            jSONObject.put("ext2", this.gbw);
            jSONObject.put("da_ext1", this.gby);
            jSONObject.put("da_ext2", this.gbz);
            jSONObject.put("da_ext3", this.gbA);
            jSONObject.put("da_ext4", this.gbB);
            jSONObject.put("da_menu1", this.gbD);
            jSONObject.put("da_menu2", this.gbE);
            jSONObject.put("da_menu3", this.gbF);
            jSONObject.put("da_page", this.gbG);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gbC);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gbH);
        } catch (JSONException e) {
        }
        if (this.gbp != null) {
            try {
                jSONObject.put("ext", this.gbp);
            } catch (Exception e2) {
            }
        }
        this.gbu = jSONObject;
        return jSONObject;
    }

    public void sf(String str) {
        this.gbD = str;
    }

    public void sg(String str) {
        this.gbE = str;
    }

    public void sh(String str) {
        this.gbF = str;
    }

    public void si(String str) {
        this.gbG = str;
    }

    public void sj(String str) {
        this.gbH = str;
    }
}
