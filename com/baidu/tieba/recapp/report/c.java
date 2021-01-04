package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject hUL;
    private String mSA;
    private String mSB;
    private String mSC;
    private String mSD;
    private String mSE;
    private String mSF;
    private JSONObject mSo;
    private String mSr;
    private int mSs;
    private String mSt;
    private int mSu;
    private int mSv;
    private int mSw;
    private int mSx;
    private int mSy;
    private int mSz;
    private String placeId;
    private int aby = -1;
    private int abA = -1;
    private int pageNumber = -1;
    private long mSq = System.currentTimeMillis() / 1000;

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void Jk(int i) {
        this.aby = i;
        if (this.hUL != null) {
            try {
                this.hUL.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void Jl(int i) {
        this.abA = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void RX(String str) {
        this.placeId = str;
    }

    public void RY(String str) {
        this.mSr = str;
    }

    public void RZ(String str) {
    }

    public void Jm(int i) {
        this.mSv = i;
    }

    public void Jn(int i) {
        this.mSw = i;
    }

    public void Jo(int i) {
        this.mSx = i;
    }

    public void Jp(int i) {
        this.mSy = i;
    }

    public void Jq(int i) {
        this.mSz = i;
    }

    public void Sa(String str) {
        this.mSA = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.abA = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.mSr = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void gg(String str, String str2) {
        if (this.mSo == null) {
            this.mSo = new JSONObject();
        }
        try {
            this.mSo.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject makeJSONObject() {
        if (this.hUL != null) {
            return this.hUL;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.abA != -1) {
                jSONObject.put("da_locate", this.abA);
            }
            if (this.aby != -1) {
                jSONObject.put("da_type", this.aby);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.mSq);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.mSr);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.mSs);
            jSONObject.put("ext3", this.mSu);
            jSONObject.put("ext2", this.mSt);
            jSONObject.put("da_ext1", this.mSv);
            jSONObject.put("da_ext2", this.mSw);
            jSONObject.put("da_ext3", this.mSx);
            jSONObject.put("da_ext4", this.mSy);
            jSONObject.put("da_ext5", this.mSz);
            jSONObject.put("da_menu1", this.mSB);
            jSONObject.put("da_menu2", this.mSC);
            jSONObject.put("da_menu3", this.mSD);
            jSONObject.put("da_page", this.mSE);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.mSA);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.mSF);
        } catch (JSONException e) {
        }
        if (this.mSo != null) {
            try {
                jSONObject.put("ext", this.mSo);
            } catch (Exception e2) {
            }
        }
        this.hUL = jSONObject;
        return jSONObject;
    }

    public void Sb(String str) {
        this.mSB = str;
    }

    public void Sc(String str) {
        this.mSC = str;
    }

    public void Sd(String str) {
        this.mSD = str;
    }

    public void Se(String str) {
        this.mSE = str;
    }

    public void Sf(String str) {
        this.mSF = str;
    }
}
