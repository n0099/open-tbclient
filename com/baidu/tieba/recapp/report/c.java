package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject kOB;
    private String kOD;
    private JSONObject kOE;
    private int kOF;
    private String kOG;
    private int kOH;
    private int kOI;
    private int kOJ;
    private int kOK;
    private int kOL;
    private int kOM;
    private String kON;
    private String kOO;
    private String kOP;
    private String kOQ;
    private String kOR;
    private String kOS;
    private String placeId;
    private int Ya = -1;
    private int Yc = -1;
    private int pageNumber = -1;
    private long kOC = System.currentTimeMillis() / 1000;

    public void Lu(String str) {
        this.extInfo = str;
    }

    public void Cq(int i) {
        this.Ya = i;
        if (this.kOE != null) {
            try {
                this.kOE.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void Cr(int i) {
        this.Yc = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void Lv(String str) {
        this.placeId = str;
    }

    public void Lw(String str) {
        this.kOD = str;
    }

    public void Lx(String str) {
    }

    public void Cs(int i) {
        this.kOI = i;
    }

    public void Ct(int i) {
        this.kOJ = i;
    }

    public void Cu(int i) {
        this.kOK = i;
    }

    public void Cv(int i) {
        this.kOL = i;
    }

    public void Cw(int i) {
        this.kOM = i;
    }

    public void Ly(String str) {
        this.kON = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Yc = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.kOD = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void ff(String str, String str2) {
        if (this.kOB == null) {
            this.kOB = new JSONObject();
        }
        try {
            this.kOB.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cVj() {
        if (this.kOE != null) {
            return this.kOE;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Yc != -1) {
                jSONObject.put("da_locate", this.Yc);
            }
            if (this.Ya != -1) {
                jSONObject.put("da_type", this.Ya);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.kOC);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.kOD);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.kOF);
            jSONObject.put("ext3", this.kOH);
            jSONObject.put("ext2", this.kOG);
            jSONObject.put("da_ext1", this.kOI);
            jSONObject.put("da_ext2", this.kOJ);
            jSONObject.put("da_ext3", this.kOK);
            jSONObject.put("da_ext4", this.kOL);
            jSONObject.put("da_ext5", this.kOM);
            jSONObject.put("da_menu1", this.kOO);
            jSONObject.put("da_menu2", this.kOP);
            jSONObject.put("da_menu3", this.kOQ);
            jSONObject.put("da_page", this.kOR);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.kON);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.kOS);
        } catch (JSONException e) {
        }
        if (this.kOB != null) {
            try {
                jSONObject.put("ext", this.kOB);
            } catch (Exception e2) {
            }
        }
        this.kOE = jSONObject;
        return jSONObject;
    }

    public void Lz(String str) {
        this.kOO = str;
    }

    public void LA(String str) {
        this.kOP = str;
    }

    public void LB(String str) {
        this.kOQ = str;
    }

    public void LC(String str) {
        this.kOR = str;
    }

    public void LD(String str) {
        this.kOS = str;
    }
}
