package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject lQA;
    private String lQC;
    private JSONObject lQD;
    private int lQE;
    private String lQF;
    private int lQG;
    private int lQH;
    private int lQI;
    private int lQJ;
    private int lQK;
    private int lQL;
    private String lQM;
    private String lQN;
    private String lQO;
    private String lQP;
    private String lQQ;
    private String lQR;
    private String placeId;
    private int Zv = -1;
    private int Zx = -1;
    private int pageNumber = -1;
    private long lQB = System.currentTimeMillis() / 1000;

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void GM(int i) {
        this.Zv = i;
        if (this.lQD != null) {
            try {
                this.lQD.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void GN(int i) {
        this.Zx = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void Qc(String str) {
        this.placeId = str;
    }

    public void Qd(String str) {
        this.lQC = str;
    }

    public void Qe(String str) {
    }

    public void GO(int i) {
        this.lQH = i;
    }

    public void GP(int i) {
        this.lQI = i;
    }

    public void GQ(int i) {
        this.lQJ = i;
    }

    public void GR(int i) {
        this.lQK = i;
    }

    public void GS(int i) {
        this.lQL = i;
    }

    public void Qf(String str) {
        this.lQM = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Zx = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.lQC = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void fS(String str, String str2) {
        if (this.lQA == null) {
            this.lQA = new JSONObject();
        }
        try {
            this.lQA.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject drU() {
        if (this.lQD != null) {
            return this.lQD;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Zx != -1) {
                jSONObject.put("da_locate", this.Zx);
            }
            if (this.Zv != -1) {
                jSONObject.put("da_type", this.Zv);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.lQB);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.lQC);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.lQE);
            jSONObject.put("ext3", this.lQG);
            jSONObject.put("ext2", this.lQF);
            jSONObject.put("da_ext1", this.lQH);
            jSONObject.put("da_ext2", this.lQI);
            jSONObject.put("da_ext3", this.lQJ);
            jSONObject.put("da_ext4", this.lQK);
            jSONObject.put("da_ext5", this.lQL);
            jSONObject.put("da_menu1", this.lQN);
            jSONObject.put("da_menu2", this.lQO);
            jSONObject.put("da_menu3", this.lQP);
            jSONObject.put("da_page", this.lQQ);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.lQM);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.lQR);
        } catch (JSONException e) {
        }
        if (this.lQA != null) {
            try {
                jSONObject.put("ext", this.lQA);
            } catch (Exception e2) {
            }
        }
        this.lQD = jSONObject;
        return jSONObject;
    }

    public void Qg(String str) {
        this.lQN = str;
    }

    public void Qh(String str) {
        this.lQO = str;
    }

    public void Qi(String str) {
        this.lQP = str;
    }

    public void Qj(String str) {
        this.lQQ = str;
    }

    public void Qk(String str) {
        this.lQR = str;
    }
}
