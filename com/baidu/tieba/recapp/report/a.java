package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private String gbA;
    private String gbB;
    private String gbC;
    private JSONObject gbk;
    private int gbl;
    private int gbm;
    private long gbn = System.currentTimeMillis() / 1000;
    private String gbo;
    private JSONObject gbp;
    private int gbq;
    private int gbr;
    private int gbs;
    private int gbt;
    private int gbu;
    private int gbv;
    private int gbw;
    private String gbx;
    private String gby;
    private String gbz;
    private int pageNumber;
    private String placeId;

    public void sb(String str) {
        this.extInfo = str;
    }

    public void sU(int i) {
        this.gbl = i;
    }

    public void sV(int i) {
        this.gbm = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void sc(String str) {
        this.placeId = str;
    }

    public void sd(String str) {
        this.gbo = str;
    }

    public void sW(int i) {
        this.gbt = i;
    }

    public void sX(int i) {
        this.gbu = i;
    }

    public void sY(int i) {
        this.gbv = i;
    }

    public void sZ(int i) {
        this.gbw = i;
    }

    public void se(String str) {
        this.gbx = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gbm = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.gbo = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bW(String str, String str2) {
        if (this.gbk == null) {
            this.gbk = new JSONObject();
        }
        try {
            this.gbk.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bmA() {
        if (this.gbp != null) {
            return this.gbp;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.gbm);
            jSONObject.put("da_type", this.gbl);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gbn);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.gbo);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gbq);
            jSONObject.put("ext3", this.gbs);
            jSONObject.put("ext2", this.gbr);
            jSONObject.put("da_ext1", this.gbt);
            jSONObject.put("da_ext2", this.gbu);
            jSONObject.put("da_ext3", this.gbv);
            jSONObject.put("da_ext4", this.gbw);
            jSONObject.put("da_menu1", this.gby);
            jSONObject.put("da_menu2", this.gbz);
            jSONObject.put("da_menu3", this.gbA);
            jSONObject.put("da_page", this.gbB);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gbx);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gbC);
        } catch (JSONException e) {
        }
        if (this.gbk != null) {
            try {
                jSONObject.put("ext", this.gbk);
            } catch (Exception e2) {
            }
        }
        this.gbp = jSONObject;
        return jSONObject;
    }

    public void sf(String str) {
        this.gby = str;
    }

    public void sg(String str) {
        this.gbz = str;
    }

    public void sh(String str) {
        this.gbA = str;
    }

    public void si(String str) {
        this.gbB = str;
    }

    public void sj(String str) {
        this.gbC = str;
    }
}
