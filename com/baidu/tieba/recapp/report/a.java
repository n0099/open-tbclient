package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONObject cOl;
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gHc;
    private int gHd;
    private int gHe;
    private long gHf = System.currentTimeMillis() / 1000;
    private String gHg;
    private int gHh;
    private int gHi;
    private int gHj;
    private int gHk;
    private int gHl;
    private int gHm;
    private int gHn;
    private String gHo;
    private String gHp;
    private String gHq;
    private String gHr;
    private String gHs;
    private String gHt;
    private int pageNumber;
    private String placeId;

    public void rW(String str) {
        this.extInfo = str;
    }

    public void ur(int i) {
        this.gHd = i;
        if (this.cOl != null) {
            try {
                this.cOl.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void us(int i) {
        this.gHe = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void rX(String str) {
        this.placeId = str;
    }

    public void rY(String str) {
        this.gHg = str;
    }

    public void ut(int i) {
        this.gHk = i;
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

    public void rZ(String str) {
        this.gHo = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gHe = com.baidu.adp.lib.g.b.h(downloadStaticsData.getAdPosition(), 0);
            this.gHg = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bS(String str, String str2) {
        if (this.gHc == null) {
            this.gHc = new JSONObject();
        }
        try {
            this.gHc.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject boW() {
        if (this.cOl != null) {
            return this.cOl;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.gHe);
            jSONObject.put("da_type", this.gHd);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gHf);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.gHg);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gHh);
            jSONObject.put("ext3", this.gHj);
            jSONObject.put("ext2", this.gHi);
            jSONObject.put("da_ext1", this.gHk);
            jSONObject.put("da_ext2", this.gHl);
            jSONObject.put("da_ext3", this.gHm);
            jSONObject.put("da_ext4", this.gHn);
            jSONObject.put("da_menu1", this.gHp);
            jSONObject.put("da_menu2", this.gHq);
            jSONObject.put("da_menu3", this.gHr);
            jSONObject.put("da_page", this.gHs);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gHo);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gHt);
        } catch (JSONException e) {
        }
        if (this.gHc != null) {
            try {
                jSONObject.put("ext", this.gHc);
            } catch (Exception e2) {
            }
        }
        this.cOl = jSONObject;
        return jSONObject;
    }

    public void sa(String str) {
        this.gHp = str;
    }

    public void sb(String str) {
        this.gHq = str;
    }

    public void sc(String str) {
        this.gHr = str;
    }

    public void sd(String str) {
        this.gHs = str;
    }

    public void se(String str) {
        this.gHt = str;
    }
}
