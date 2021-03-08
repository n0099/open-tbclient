package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject mZG;
    private String mZI;
    private int mZJ;
    private String mZK;
    private int mZL;
    private String mZM;
    private String mZN;
    private String mZO;
    private String mZP;
    private String mZQ;
    private String mZR;
    private String mZS;
    private String mZT;
    private String mZU;
    private String mZV;
    private String mZW;
    private String placeId;
    private int acO = -1;
    private int acQ = -1;
    private int pageNumber = -1;
    private long mZH = System.currentTimeMillis() / 1000;

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void Ia(int i) {
        this.acO = i;
    }

    public void Ib(int i) {
        this.acQ = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void Sa(String str) {
        this.placeId = str;
    }

    public void Sb(String str) {
        this.mZI = str;
    }

    public void Sc(String str) {
    }

    public void Ic(int i) {
        this.mZM = String.valueOf(i);
    }

    public void Id(int i) {
        this.mZN = String.valueOf(i);
    }

    public void Ie(int i) {
        this.mZO = String.valueOf(i);
    }

    public void If(int i) {
        this.mZP = String.valueOf(i);
    }

    public void Ig(int i) {
        this.mZQ = String.valueOf(i);
    }

    public void Sd(String str) {
        this.mZQ = str;
    }

    public void Se(String str) {
        this.mZR = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.acQ = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.mZI = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void gm(String str, String str2) {
        if (this.mZG == null) {
            this.mZG = new JSONObject();
        }
        try {
            this.mZG.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject makeJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.acQ != -1) {
                jSONObject.put("da_locate", this.acQ);
            }
            if (this.acO != -1) {
                jSONObject.put("da_type", this.acO);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.mZH);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.mZI);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.mZJ);
            jSONObject.put("ext3", this.mZL);
            jSONObject.put("ext2", this.mZK);
            jSONObject.put("da_ext1", this.mZM);
            jSONObject.put("da_ext2", this.mZN);
            jSONObject.put("da_ext3", this.mZO);
            jSONObject.put("da_ext4", this.mZP);
            jSONObject.put("da_ext5", this.mZQ);
            jSONObject.put("da_menu1", this.mZS);
            jSONObject.put("da_menu2", this.mZT);
            jSONObject.put("da_menu3", this.mZU);
            jSONObject.put("da_page", this.mZV);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.mZR);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.mZW);
        } catch (JSONException e) {
        }
        if (this.mZG != null) {
            try {
                jSONObject.put("ext", this.mZG);
            } catch (Exception e2) {
            }
        }
        return jSONObject;
    }

    public void Sf(String str) {
        this.mZS = str;
    }

    public void Sg(String str) {
        this.mZT = str;
    }

    public void Sh(String str) {
        this.mZU = str;
    }

    public void Si(String str) {
        this.mZV = str;
    }

    public void Sj(String str) {
        this.mZW = str;
    }
}
