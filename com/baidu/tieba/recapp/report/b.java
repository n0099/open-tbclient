package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private int jKA;
    private int jKB;
    private int jKC;
    private int jKD;
    private int jKE;
    private String jKF;
    private String jKG;
    private String jKH;
    private String jKI;
    private String jKJ;
    private String jKK;
    private JSONObject jKt;
    private String jKv;
    private JSONObject jKw;
    private int jKx;
    private String jKy;
    private int jKz;
    private String placeId;
    private int DY = -1;
    private int Ea = -1;
    private int pageNumber = -1;
    private long jKu = System.currentTimeMillis() / 1000;

    public void HM(String str) {
        this.extInfo = str;
    }

    public void AP(int i) {
        this.DY = i;
        if (this.jKw != null) {
            try {
                this.jKw.put("da_type", i);
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
        this.jKv = str;
    }

    public void HP(String str) {
    }

    public void AR(int i) {
        this.jKA = i;
    }

    public void AS(int i) {
        this.jKB = i;
    }

    public void AT(int i) {
        this.jKC = i;
    }

    public void AU(int i) {
        this.jKD = i;
    }

    public void AV(int i) {
        this.jKE = i;
    }

    public void HQ(String str) {
        this.jKF = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Ea = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.jKv = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void ei(String str, String str2) {
        if (this.jKt == null) {
            this.jKt = new JSONObject();
        }
        try {
            this.jKt.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cBO() {
        if (this.jKw != null) {
            return this.jKw;
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
            jSONObject.put("origin_time", this.jKu);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.jKv);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.jKx);
            jSONObject.put("ext3", this.jKz);
            jSONObject.put("ext2", this.jKy);
            jSONObject.put("da_ext1", this.jKA);
            jSONObject.put("da_ext2", this.jKB);
            jSONObject.put("da_ext3", this.jKC);
            jSONObject.put("da_ext4", this.jKD);
            jSONObject.put("da_ext5", this.jKE);
            jSONObject.put("da_menu1", this.jKG);
            jSONObject.put("da_menu2", this.jKH);
            jSONObject.put("da_menu3", this.jKI);
            jSONObject.put("da_page", this.jKJ);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.jKF);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.jKK);
        } catch (JSONException e) {
        }
        if (this.jKt != null) {
            try {
                jSONObject.put("ext", this.jKt);
            } catch (Exception e2) {
            }
        }
        this.jKw = jSONObject;
        return jSONObject;
    }

    public void HR(String str) {
        this.jKG = str;
    }

    public void HS(String str) {
        this.jKH = str;
    }

    public void HT(String str) {
        this.jKI = str;
    }

    public void HU(String str) {
        this.jKJ = str;
    }

    public void HV(String str) {
        this.jKK = str;
    }
}
