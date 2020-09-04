package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject lHG;
    private String lHI;
    private JSONObject lHJ;
    private int lHK;
    private String lHL;
    private int lHM;
    private int lHN;
    private int lHO;
    private int lHP;
    private int lHQ;
    private int lHR;
    private String lHS;
    private String lHT;
    private String lHU;
    private String lHV;
    private String lHW;
    private String lHX;
    private String placeId;
    private int Zc = -1;
    private int Zf = -1;
    private int pageNumber = -1;
    private long lHH = System.currentTimeMillis() / 1000;

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void Gl(int i) {
        this.Zc = i;
        if (this.lHJ != null) {
            try {
                this.lHJ.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void Gm(int i) {
        this.Zf = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void PC(String str) {
        this.placeId = str;
    }

    public void PD(String str) {
        this.lHI = str;
    }

    public void PE(String str) {
    }

    public void Gn(int i) {
        this.lHN = i;
    }

    public void Go(int i) {
        this.lHO = i;
    }

    public void Gp(int i) {
        this.lHP = i;
    }

    public void Gq(int i) {
        this.lHQ = i;
    }

    public void Gr(int i) {
        this.lHR = i;
    }

    public void PF(String str) {
        this.lHS = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Zf = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.lHI = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void fG(String str, String str2) {
        if (this.lHG == null) {
            this.lHG = new JSONObject();
        }
        try {
            this.lHG.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject dok() {
        if (this.lHJ != null) {
            return this.lHJ;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Zf != -1) {
                jSONObject.put("da_locate", this.Zf);
            }
            if (this.Zc != -1) {
                jSONObject.put("da_type", this.Zc);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.lHH);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.lHI);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.lHK);
            jSONObject.put("ext3", this.lHM);
            jSONObject.put("ext2", this.lHL);
            jSONObject.put("da_ext1", this.lHN);
            jSONObject.put("da_ext2", this.lHO);
            jSONObject.put("da_ext3", this.lHP);
            jSONObject.put("da_ext4", this.lHQ);
            jSONObject.put("da_ext5", this.lHR);
            jSONObject.put("da_menu1", this.lHT);
            jSONObject.put("da_menu2", this.lHU);
            jSONObject.put("da_menu3", this.lHV);
            jSONObject.put("da_page", this.lHW);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.lHS);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.lHX);
        } catch (JSONException e) {
        }
        if (this.lHG != null) {
            try {
                jSONObject.put("ext", this.lHG);
            } catch (Exception e2) {
            }
        }
        this.lHJ = jSONObject;
        return jSONObject;
    }

    public void PG(String str) {
        this.lHT = str;
    }

    public void PH(String str) {
        this.lHU = str;
    }

    public void PI(String str) {
        this.lHV = str;
    }

    public void PJ(String str) {
        this.lHW = str;
    }

    public void PK(String str) {
        this.lHX = str;
    }
}
