package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject jGR;
    private String jGT;
    private JSONObject jGU;
    private int jGV;
    private String jGW;
    private int jGX;
    private int jGY;
    private int jGZ;
    private int jHa;
    private int jHb;
    private int jHc;
    private String jHd;
    private String jHe;
    private String jHf;
    private String jHg;
    private String jHh;
    private String jHi;
    private String placeId;
    private int DT = -1;
    private int DV = -1;
    private int pageNumber = -1;
    private long jGS = System.currentTimeMillis() / 1000;

    public void HC(String str) {
        this.extInfo = str;
    }

    public void AK(int i) {
        this.DT = i;
        if (this.jGU != null) {
            try {
                this.jGU.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void AL(int i) {
        this.DV = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void HD(String str) {
        this.placeId = str;
    }

    public void HE(String str) {
        this.jGT = str;
    }

    public void HF(String str) {
    }

    public void AM(int i) {
        this.jGY = i;
    }

    public void AN(int i) {
        this.jGZ = i;
    }

    public void AO(int i) {
        this.jHa = i;
    }

    public void AP(int i) {
        this.jHb = i;
    }

    public void AQ(int i) {
        this.jHc = i;
    }

    public void HG(String str) {
        this.jHd = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.DV = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.jGT = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void eg(String str, String str2) {
        if (this.jGR == null) {
            this.jGR = new JSONObject();
        }
        try {
            this.jGR.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cAI() {
        if (this.jGU != null) {
            return this.jGU;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.DV != -1) {
                jSONObject.put("da_locate", this.DV);
            }
            if (this.DT != -1) {
                jSONObject.put("da_type", this.DT);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.jGS);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.jGT);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.jGV);
            jSONObject.put("ext3", this.jGX);
            jSONObject.put("ext2", this.jGW);
            jSONObject.put("da_ext1", this.jGY);
            jSONObject.put("da_ext2", this.jGZ);
            jSONObject.put("da_ext3", this.jHa);
            jSONObject.put("da_ext4", this.jHb);
            jSONObject.put("da_ext5", this.jHc);
            jSONObject.put("da_menu1", this.jHe);
            jSONObject.put("da_menu2", this.jHf);
            jSONObject.put("da_menu3", this.jHg);
            jSONObject.put("da_page", this.jHh);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.jHd);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.jHi);
        } catch (JSONException e) {
        }
        if (this.jGR != null) {
            try {
                jSONObject.put("ext", this.jGR);
            } catch (Exception e2) {
            }
        }
        this.jGU = jSONObject;
        return jSONObject;
    }

    public void HH(String str) {
        this.jHe = str;
    }

    public void HI(String str) {
        this.jHf = str;
    }

    public void HJ(String str) {
        this.jHg = str;
    }

    public void HK(String str) {
        this.jHh = str;
    }

    public void HL(String str) {
        this.jHi = str;
    }
}
