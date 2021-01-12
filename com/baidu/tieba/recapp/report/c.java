package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject hQe;
    private JSONObject mNH;
    private String mNJ;
    private int mNK;
    private String mNL;
    private int mNM;
    private int mNN;
    private int mNO;
    private int mNP;
    private int mNQ;
    private int mNR;
    private String mNS;
    private String mNT;
    private String mNU;
    private String mNV;
    private String mNW;
    private String mNX;
    private String placeId;
    private int abw = -1;
    private int aby = -1;
    private int pageNumber = -1;
    private long mNI = System.currentTimeMillis() / 1000;

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void HD(int i) {
        this.abw = i;
        if (this.hQe != null) {
            try {
                this.hQe.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void HE(int i) {
        this.aby = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void QO(String str) {
        this.placeId = str;
    }

    public void QP(String str) {
        this.mNJ = str;
    }

    public void QQ(String str) {
    }

    public void HF(int i) {
        this.mNN = i;
    }

    public void HG(int i) {
        this.mNO = i;
    }

    public void HH(int i) {
        this.mNP = i;
    }

    public void HI(int i) {
        this.mNQ = i;
    }

    public void HJ(int i) {
        this.mNR = i;
    }

    public void QR(String str) {
        this.mNS = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.aby = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.mNJ = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void gf(String str, String str2) {
        if (this.mNH == null) {
            this.mNH = new JSONObject();
        }
        try {
            this.mNH.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject makeJSONObject() {
        if (this.hQe != null) {
            return this.hQe;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.aby != -1) {
                jSONObject.put("da_locate", this.aby);
            }
            if (this.abw != -1) {
                jSONObject.put("da_type", this.abw);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.mNI);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.mNJ);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.mNK);
            jSONObject.put("ext3", this.mNM);
            jSONObject.put("ext2", this.mNL);
            jSONObject.put("da_ext1", this.mNN);
            jSONObject.put("da_ext2", this.mNO);
            jSONObject.put("da_ext3", this.mNP);
            jSONObject.put("da_ext4", this.mNQ);
            jSONObject.put("da_ext5", this.mNR);
            jSONObject.put("da_menu1", this.mNT);
            jSONObject.put("da_menu2", this.mNU);
            jSONObject.put("da_menu3", this.mNV);
            jSONObject.put("da_page", this.mNW);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.mNS);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.mNX);
        } catch (JSONException e) {
        }
        if (this.mNH != null) {
            try {
                jSONObject.put("ext", this.mNH);
            } catch (Exception e2) {
            }
        }
        this.hQe = jSONObject;
        return jSONObject;
    }

    public void QS(String str) {
        this.mNT = str;
    }

    public void QT(String str) {
        this.mNU = str;
    }

    public void QU(String str) {
        this.mNV = str;
    }

    public void QV(String str) {
        this.mNW = str;
    }

    public void QW(String str) {
        this.mNX = str;
    }
}
