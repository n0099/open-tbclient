package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONObject cff;
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gdd;
    private int gde;
    private int gdf;
    private long gdg = System.currentTimeMillis() / 1000;
    private String gdh;
    private int gdi;
    private int gdj;
    private int gdk;
    private int gdl;
    private int gdm;
    private int gdn;
    private int gdo;
    private String gdp;
    private String gdq;
    private String gdr;
    private String gds;
    private String gdt;
    private String gdu;
    private int pageNumber;
    private String placeId;

    public void sg(String str) {
        this.extInfo = str;
    }

    public void rR(int i) {
        this.gde = i;
        if (this.cff != null) {
            try {
                this.cff.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void rS(int i) {
        this.gdf = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void sh(String str) {
        this.placeId = str;
    }

    public void si(String str) {
        this.gdh = str;
    }

    public void rT(int i) {
        this.gdl = i;
    }

    public void rU(int i) {
        this.gdm = i;
    }

    public void rV(int i) {
        this.gdn = i;
    }

    public void rW(int i) {
        this.gdo = i;
    }

    public void sj(String str) {
        this.gdp = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gdf = com.baidu.adp.lib.g.b.g(downloadStaticsData.getAdPosition(), 0);
            this.gdh = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bR(String str, String str2) {
        if (this.gdd == null) {
            this.gdd = new JSONObject();
        }
        try {
            this.gdd.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bkc() {
        if (this.cff != null) {
            return this.cff;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.gdf);
            jSONObject.put("da_type", this.gde);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gdg);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.gdh);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gdi);
            jSONObject.put("ext3", this.gdk);
            jSONObject.put("ext2", this.gdj);
            jSONObject.put("da_ext1", this.gdl);
            jSONObject.put("da_ext2", this.gdm);
            jSONObject.put("da_ext3", this.gdn);
            jSONObject.put("da_ext4", this.gdo);
            jSONObject.put("da_menu1", this.gdq);
            jSONObject.put("da_menu2", this.gdr);
            jSONObject.put("da_menu3", this.gds);
            jSONObject.put("da_page", this.gdt);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gdp);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gdu);
        } catch (JSONException e) {
        }
        if (this.gdd != null) {
            try {
                jSONObject.put("ext", this.gdd);
            } catch (Exception e2) {
            }
        }
        this.cff = jSONObject;
        return jSONObject;
    }

    public void sk(String str) {
        this.gdq = str;
    }

    public void sl(String str) {
        this.gdr = str;
    }

    public void sm(String str) {
        this.gds = str;
    }

    public void sn(String str) {
        this.gdt = str;
    }

    public void so(String str) {
        this.gdu = str;
    }
}
