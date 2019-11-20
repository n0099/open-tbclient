package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject iMC;
    private String iME;
    private JSONObject iMF;
    private int iMG;
    private String iMH;
    private int iMI;
    private int iMJ;
    private int iMK;
    private int iML;
    private int iMM;
    private int iMN;
    private String iMO;
    private String iMP;
    private String iMQ;
    private String iMR;
    private String iMS;
    private String iMT;
    private String placeId;
    private int Bm = -1;
    private int Bo = -1;
    private int pageNumber = -1;
    private long iMD = System.currentTimeMillis() / 1000;

    public void CP(String str) {
        this.extInfo = str;
    }

    public void yo(int i) {
        this.Bm = i;
        if (this.iMF != null) {
            try {
                this.iMF.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void yp(int i) {
        this.Bo = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void CQ(String str) {
        this.placeId = str;
    }

    public void CR(String str) {
        this.iME = str;
    }

    public void CS(String str) {
    }

    public void yq(int i) {
        this.iMJ = i;
    }

    public void yr(int i) {
        this.iMK = i;
    }

    public void ys(int i) {
        this.iML = i;
    }

    public void yt(int i) {
        this.iMM = i;
    }

    public void yu(int i) {
        this.iMN = i;
    }

    public void CT(String str) {
        this.iMO = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Bo = com.baidu.adp.lib.g.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.iME = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void dN(String str, String str2) {
        if (this.iMC == null) {
            this.iMC = new JSONObject();
        }
        try {
            this.iMC.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cgF() {
        if (this.iMF != null) {
            return this.iMF;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Bo != -1) {
                jSONObject.put("da_locate", this.Bo);
            }
            if (this.Bm != -1) {
                jSONObject.put("da_type", this.Bm);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.iMD);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.iME);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.iMG);
            jSONObject.put("ext3", this.iMI);
            jSONObject.put("ext2", this.iMH);
            jSONObject.put("da_ext1", this.iMJ);
            jSONObject.put("da_ext2", this.iMK);
            jSONObject.put("da_ext3", this.iML);
            jSONObject.put("da_ext4", this.iMM);
            jSONObject.put("da_ext5", this.iMN);
            jSONObject.put("da_menu1", this.iMP);
            jSONObject.put("da_menu2", this.iMQ);
            jSONObject.put("da_menu3", this.iMR);
            jSONObject.put("da_page", this.iMS);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.iMO);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.iMT);
        } catch (JSONException e) {
        }
        if (this.iMC != null) {
            try {
                jSONObject.put("ext", this.iMC);
            } catch (Exception e2) {
            }
        }
        this.iMF = jSONObject;
        return jSONObject;
    }

    public void CU(String str) {
        this.iMP = str;
    }

    public void CV(String str) {
        this.iMQ = str;
    }

    public void CW(String str) {
        this.iMR = str;
    }

    public void CX(String str) {
        this.iMS = str;
    }

    public void CY(String str) {
        this.iMT = str;
    }
}
