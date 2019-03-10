package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private int imA;
    private String imB;
    private String imC;
    private String imD;
    private String imE;
    private String imF;
    private String imG;
    private JSONObject imp;
    private String imr;
    private JSONObject ims;
    private int imt;
    private String imu;
    private int imv;
    private int imw;
    private int imx;
    private int imy;
    private int imz;
    private String placeId;
    private int Un = -1;
    private int Up = -1;
    private int pageNumber = -1;
    private long imq = System.currentTimeMillis() / 1000;

    public void BL(String str) {
        this.extInfo = str;
    }

    public void xW(int i) {
        this.Un = i;
        if (this.ims != null) {
            try {
                this.ims.put("da_type", i);
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

    public void BM(String str) {
        this.placeId = str;
    }

    public void BN(String str) {
        this.imr = str;
    }

    public void BO(String str) {
    }

    public void xY(int i) {
        this.imw = i;
    }

    public void xZ(int i) {
        this.imx = i;
    }

    public void ya(int i) {
        this.imy = i;
    }

    public void yb(int i) {
        this.imz = i;
    }

    public void yc(int i) {
        this.imA = i;
    }

    public void BP(String str) {
        this.imB = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Up = com.baidu.adp.lib.g.b.l(downloadStaticsData.getAdPosition(), 0);
            this.imr = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void dL(String str, String str2) {
        if (this.imp == null) {
            this.imp = new JSONObject();
        }
        try {
            this.imp.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bXB() {
        if (this.ims != null) {
            return this.ims;
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
            jSONObject.put("origin_time", this.imq);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.imr);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.imt);
            jSONObject.put("ext3", this.imv);
            jSONObject.put("ext2", this.imu);
            jSONObject.put("da_ext1", this.imw);
            jSONObject.put("da_ext2", this.imx);
            jSONObject.put("da_ext3", this.imy);
            jSONObject.put("da_ext4", this.imz);
            jSONObject.put("da_ext5", this.imA);
            jSONObject.put("da_menu1", this.imC);
            jSONObject.put("da_menu2", this.imD);
            jSONObject.put("da_menu3", this.imE);
            jSONObject.put("da_page", this.imF);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.imB);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.imG);
        } catch (JSONException e) {
        }
        if (this.imp != null) {
            try {
                jSONObject.put("ext", this.imp);
            } catch (Exception e2) {
            }
        }
        this.ims = jSONObject;
        return jSONObject;
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

    public void BU(String str) {
        this.imG = str;
    }
}
