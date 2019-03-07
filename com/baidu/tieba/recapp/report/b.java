package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private String imA;
    private String imB;
    private String imC;
    private String imD;
    private String imE;
    private String imF;
    private JSONObject imo;
    private String imq;
    private JSONObject imr;
    private int ims;
    private String imt;
    private int imu;
    private int imv;
    private int imw;
    private int imx;
    private int imy;
    private int imz;
    private String placeId;
    private int Un = -1;
    private int Up = -1;
    private int pageNumber = -1;
    private long imp = System.currentTimeMillis() / 1000;

    public void BK(String str) {
        this.extInfo = str;
    }

    public void xW(int i) {
        this.Un = i;
        if (this.imr != null) {
            try {
                this.imr.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void xX(int i) {
        this.Up = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void BL(String str) {
        this.placeId = str;
    }

    public void BM(String str) {
        this.imq = str;
    }

    public void BN(String str) {
    }

    public void xY(int i) {
        this.imv = i;
    }

    public void xZ(int i) {
        this.imw = i;
    }

    public void ya(int i) {
        this.imx = i;
    }

    public void yb(int i) {
        this.imy = i;
    }

    public void yc(int i) {
        this.imz = i;
    }

    public void BO(String str) {
        this.imA = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Up = com.baidu.adp.lib.g.b.l(downloadStaticsData.getAdPosition(), 0);
            this.imq = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void dL(String str, String str2) {
        if (this.imo == null) {
            this.imo = new JSONObject();
        }
        try {
            this.imo.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bXA() {
        if (this.imr != null) {
            return this.imr;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Up != -1) {
                jSONObject.put("da_locate", this.Up);
            }
            if (this.Un != -1) {
                jSONObject.put("da_type", this.Un);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.imp);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.imq);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.ims);
            jSONObject.put("ext3", this.imu);
            jSONObject.put("ext2", this.imt);
            jSONObject.put("da_ext1", this.imv);
            jSONObject.put("da_ext2", this.imw);
            jSONObject.put("da_ext3", this.imx);
            jSONObject.put("da_ext4", this.imy);
            jSONObject.put("da_ext5", this.imz);
            jSONObject.put("da_menu1", this.imB);
            jSONObject.put("da_menu2", this.imC);
            jSONObject.put("da_menu3", this.imD);
            jSONObject.put("da_page", this.imE);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.imA);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.imF);
        } catch (JSONException e) {
        }
        if (this.imo != null) {
            try {
                jSONObject.put("ext", this.imo);
            } catch (Exception e2) {
            }
        }
        this.imr = jSONObject;
        return jSONObject;
    }

    public void BP(String str) {
        this.imB = str;
    }

    public void BQ(String str) {
        this.imC = str;
    }

    public void BR(String str) {
        this.imD = str;
    }

    public void BS(String str) {
        this.imE = str;
    }

    public void BT(String str) {
        this.imF = str;
    }
}
