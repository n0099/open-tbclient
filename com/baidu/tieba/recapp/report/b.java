package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private String jKA;
    private JSONObject jKB;
    private int jKC;
    private String jKD;
    private int jKE;
    private int jKF;
    private int jKG;
    private int jKH;
    private int jKI;
    private int jKJ;
    private String jKK;
    private String jKL;
    private String jKM;
    private String jKN;
    private String jKO;
    private String jKP;
    private JSONObject jKy;
    private String placeId;
    private int DY = -1;
    private int Ea = -1;
    private int pageNumber = -1;
    private long jKz = System.currentTimeMillis() / 1000;

    public void HM(String str) {
        this.extInfo = str;
    }

    public void AP(int i) {
        this.DY = i;
        if (this.jKB != null) {
            try {
                this.jKB.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void AQ(int i) {
        this.Ea = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void HN(String str) {
        this.placeId = str;
    }

    public void HO(String str) {
        this.jKA = str;
    }

    public void HP(String str) {
    }

    public void AR(int i) {
        this.jKF = i;
    }

    public void AS(int i) {
        this.jKG = i;
    }

    public void AT(int i) {
        this.jKH = i;
    }

    public void AU(int i) {
        this.jKI = i;
    }

    public void AV(int i) {
        this.jKJ = i;
    }

    public void HQ(String str) {
        this.jKK = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Ea = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.jKA = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void ei(String str, String str2) {
        if (this.jKy == null) {
            this.jKy = new JSONObject();
        }
        try {
            this.jKy.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cBQ() {
        if (this.jKB != null) {
            return this.jKB;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Ea != -1) {
                jSONObject.put("da_locate", this.Ea);
            }
            if (this.DY != -1) {
                jSONObject.put("da_type", this.DY);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.jKz);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.jKA);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.jKC);
            jSONObject.put("ext3", this.jKE);
            jSONObject.put("ext2", this.jKD);
            jSONObject.put("da_ext1", this.jKF);
            jSONObject.put("da_ext2", this.jKG);
            jSONObject.put("da_ext3", this.jKH);
            jSONObject.put("da_ext4", this.jKI);
            jSONObject.put("da_ext5", this.jKJ);
            jSONObject.put("da_menu1", this.jKL);
            jSONObject.put("da_menu2", this.jKM);
            jSONObject.put("da_menu3", this.jKN);
            jSONObject.put("da_page", this.jKO);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.jKK);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.jKP);
        } catch (JSONException e) {
        }
        if (this.jKy != null) {
            try {
                jSONObject.put("ext", this.jKy);
            } catch (Exception e2) {
            }
        }
        this.jKB = jSONObject;
        return jSONObject;
    }

    public void HR(String str) {
        this.jKL = str;
    }

    public void HS(String str) {
        this.jKM = str;
    }

    public void HT(String str) {
        this.jKN = str;
    }

    public void HU(String str) {
        this.jKO = str;
    }

    public void HV(String str) {
        this.jKP = str;
    }
}
