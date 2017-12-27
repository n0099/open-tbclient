package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject gPh;
    private int gPi;
    private int gPj;
    private long gPk = System.currentTimeMillis() / 1000;
    private String gPl;
    private JSONObject gPm;
    private int gPn;
    private int gPo;
    private int gPp;
    private int gPq;
    private int gPr;
    private int gPs;
    private int gPt;
    private String gPu;
    private String gPv;
    private String gPw;
    private String gPx;
    private String gPy;
    private String gPz;
    private int pageNumber;
    private String placeId;

    public void sn(String str) {
        this.extInfo = str;
    }

    public void vR(int i) {
        this.gPi = i;
    }

    public void vS(int i) {
        this.gPj = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void so(String str) {
        this.placeId = str;
    }

    public void sp(String str) {
        this.gPl = str;
    }

    public void vT(int i) {
        this.gPq = i;
    }

    public void vU(int i) {
        this.gPr = i;
    }

    public void vV(int i) {
        this.gPs = i;
    }

    public void vW(int i) {
        this.gPt = i;
    }

    public void sq(String str) {
        this.gPu = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.gPj = com.baidu.adp.lib.g.b.h(downloadStaticsData.getAdPosition(), 0);
            this.gPl = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void bX(String str, String str2) {
        if (this.gPh == null) {
            this.gPh = new JSONObject();
        }
        try {
            this.gPh.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject buh() {
        if (this.gPm != null) {
            return this.gPm;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da_locate", this.gPj);
            jSONObject.put("da_type", this.gPi);
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.gPk);
            jSONObject.put("da_page_num", this.pageNumber);
            jSONObject.put("da_price", this.gPl);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.gPn);
            jSONObject.put("ext3", this.gPp);
            jSONObject.put("ext2", this.gPo);
            jSONObject.put("da_ext1", this.gPq);
            jSONObject.put("da_ext2", this.gPr);
            jSONObject.put("da_ext3", this.gPs);
            jSONObject.put("da_ext4", this.gPt);
            jSONObject.put("da_menu1", this.gPv);
            jSONObject.put("da_menu2", this.gPw);
            jSONObject.put("da_menu3", this.gPx);
            jSONObject.put("da_page", this.gPy);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.gPu);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.gPz);
        } catch (JSONException e) {
        }
        if (this.gPh != null) {
            try {
                jSONObject.put("ext", this.gPh);
            } catch (Exception e2) {
            }
        }
        this.gPm = jSONObject;
        return jSONObject;
    }

    public void ss(String str) {
        this.gPv = str;
    }

    public void st(String str) {
        this.gPw = str;
    }

    public void su(String str) {
        this.gPx = str;
    }

    public void sv(String str) {
        this.gPy = str;
    }

    public void sw(String str) {
        this.gPz = str;
    }
}
