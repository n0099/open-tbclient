package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONObject cOc;
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gHd;
    private int gHe;
    private int gHf;
    private long gHg = System.currentTimeMillis() / 1000;
    private String gHh;
    private int gHi;
    private int gHj;
    private int gHk;
    private int gHl;
    private int gHm;
    private int gHn;
    private int gHo;
    private String gHp;
    private String gHq;
    private String gHr;
    private String gHs;
    private String gHt;
    private String gHu;
    private int pageNumber;
    private String placeId;

    public void rW(String str) {
        this.extInfo = str;
    }

    public void us(int i) {
        this.gHe = i;
        if (this.cOc != null) {
            try {
                this.cOc.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void ut(int i) {
        this.gHf = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void rX(String str) {
        this.placeId = str;
    }

    public void rY(String str) {
        this.gHh = str;
    }

    public void uu(int i) {
        this.gHl = i;
    }

    public void uv(int i) {
        this.gHm = i;
    }

    public void uw(int i) {
        this.gHn = i;
    }

    public void ux(int i) {
        this.gHo = i;
    }

    public void rZ(String str) {
        this.gHp = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gHf = com.baidu.adp.lib.g.b.h(downloadStaticsData.getAdPosition(), 0);
            this.gHh = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bS(String str, String str2) {
        if (this.gHd == null) {
            this.gHd = new JSONObject();
        }
        try {
            this.gHd.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject boW() {
        if (this.cOc != null) {
            return this.cOc;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.gHf);
            jSONObject.put("da_type", this.gHe);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gHg);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.gHh);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gHi);
            jSONObject.put("ext3", this.gHk);
            jSONObject.put("ext2", this.gHj);
            jSONObject.put("da_ext1", this.gHl);
            jSONObject.put("da_ext2", this.gHm);
            jSONObject.put("da_ext3", this.gHn);
            jSONObject.put("da_ext4", this.gHo);
            jSONObject.put("da_menu1", this.gHq);
            jSONObject.put("da_menu2", this.gHr);
            jSONObject.put("da_menu3", this.gHs);
            jSONObject.put("da_page", this.gHt);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gHp);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gHu);
        } catch (JSONException e) {
        }
        if (this.gHd != null) {
            try {
                jSONObject.put("ext", this.gHd);
            } catch (Exception e2) {
            }
        }
        this.cOc = jSONObject;
        return jSONObject;
    }

    public void sa(String str) {
        this.gHq = str;
    }

    public void sb(String str) {
        this.gHr = str;
    }

    public void sc(String str) {
        this.gHs = str;
    }

    public void sd(String str) {
        this.gHt = str;
    }

    public void se(String str) {
        this.gHu = str;
    }
}
