package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject imi;
    private String imk;
    private JSONObject iml;
    private int imm;
    private String imn;
    private int imo;
    private int imp;
    private int imq;
    private int imr;
    private int ims;
    private int imt;
    private String imu;
    private String imv;
    private String imw;
    private String imx;
    private String imy;
    private String imz;
    private String placeId;
    private int Uo = -1;
    private int Uq = -1;
    private int pageNumber = -1;
    private long imj = System.currentTimeMillis() / 1000;

    public void BJ(String str) {
        this.extInfo = str;
    }

    public void xW(int i) {
        this.Uo = i;
        if (this.iml != null) {
            try {
                this.iml.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void xX(int i) {
        this.Uq = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void BK(String str) {
        this.placeId = str;
    }

    public void BL(String str) {
        this.imk = str;
    }

    public void BM(String str) {
    }

    public void xY(int i) {
        this.imp = i;
    }

    public void xZ(int i) {
        this.imq = i;
    }

    public void ya(int i) {
        this.imr = i;
    }

    public void yb(int i) {
        this.ims = i;
    }

    public void yc(int i) {
        this.imt = i;
    }

    public void BN(String str) {
        this.imu = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Uq = com.baidu.adp.lib.g.b.l(downloadStaticsData.getAdPosition(), 0);
            this.imk = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void dK(String str, String str2) {
        if (this.imi == null) {
            this.imi = new JSONObject();
        }
        try {
            this.imi.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bXD() {
        if (this.iml != null) {
            return this.iml;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Uq != -1) {
                jSONObject.put("da_locate", this.Uq);
            }
            if (this.Uo != -1) {
                jSONObject.put("da_type", this.Uo);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.imj);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.imk);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.imm);
            jSONObject.put("ext3", this.imo);
            jSONObject.put("ext2", this.imn);
            jSONObject.put("da_ext1", this.imp);
            jSONObject.put("da_ext2", this.imq);
            jSONObject.put("da_ext3", this.imr);
            jSONObject.put("da_ext4", this.ims);
            jSONObject.put("da_ext5", this.imt);
            jSONObject.put("da_menu1", this.imv);
            jSONObject.put("da_menu2", this.imw);
            jSONObject.put("da_menu3", this.imx);
            jSONObject.put("da_page", this.imy);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.imu);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.imz);
        } catch (JSONException e) {
        }
        if (this.imi != null) {
            try {
                jSONObject.put("ext", this.imi);
            } catch (Exception e2) {
            }
        }
        this.iml = jSONObject;
        return jSONObject;
    }

    public void BO(String str) {
        this.imv = str;
    }

    public void BP(String str) {
        this.imw = str;
    }

    public void BQ(String str) {
        this.imx = str;
    }

    public void BR(String str) {
        this.imy = str;
    }

    public void BS(String str) {
        this.imz = str;
    }
}
