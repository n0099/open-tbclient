package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject kPK;
    private String kPM;
    private JSONObject kPN;
    private int kPO;
    private String kPP;
    private int kPQ;
    private int kPR;
    private int kPS;
    private int kPT;
    private int kPU;
    private int kPV;
    private String kPW;
    private String kPX;
    private String kPY;
    private String kPZ;
    private String kQa;
    private String kQb;
    private String placeId;
    private int Ya = -1;
    private int Yc = -1;
    private int pageNumber = -1;
    private long kPL = System.currentTimeMillis() / 1000;

    public void Lv(String str) {
        this.extInfo = str;
    }

    public void Cs(int i) {
        this.Ya = i;
        if (this.kPN != null) {
            try {
                this.kPN.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void Ct(int i) {
        this.Yc = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void Lw(String str) {
        this.placeId = str;
    }

    public void Lx(String str) {
        this.kPM = str;
    }

    public void Ly(String str) {
    }

    public void Cu(int i) {
        this.kPR = i;
    }

    public void Cv(int i) {
        this.kPS = i;
    }

    public void Cw(int i) {
        this.kPT = i;
    }

    public void Cx(int i) {
        this.kPU = i;
    }

    public void Cy(int i) {
        this.kPV = i;
    }

    public void Lz(String str) {
        this.kPW = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Yc = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.kPM = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void ff(String str, String str2) {
        if (this.kPK == null) {
            this.kPK = new JSONObject();
        }
        try {
            this.kPK.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cVz() {
        if (this.kPN != null) {
            return this.kPN;
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
            jSONObject.put("origin_time", this.kPL);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.kPM);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.kPO);
            jSONObject.put("ext3", this.kPQ);
            jSONObject.put("ext2", this.kPP);
            jSONObject.put("da_ext1", this.kPR);
            jSONObject.put("da_ext2", this.kPS);
            jSONObject.put("da_ext3", this.kPT);
            jSONObject.put("da_ext4", this.kPU);
            jSONObject.put("da_ext5", this.kPV);
            jSONObject.put("da_menu1", this.kPX);
            jSONObject.put("da_menu2", this.kPY);
            jSONObject.put("da_menu3", this.kPZ);
            jSONObject.put("da_page", this.kQa);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.kPW);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.kQb);
        } catch (JSONException e) {
        }
        if (this.kPK != null) {
            try {
                jSONObject.put("ext", this.kPK);
            } catch (Exception e2) {
            }
        }
        this.kPN = jSONObject;
        return jSONObject;
    }

    public void LA(String str) {
        this.kPX = str;
    }

    public void LB(String str) {
        this.kPY = str;
    }

    public void LC(String str) {
        this.kPZ = str;
    }

    public void LD(String str) {
        this.kQa = str;
    }

    public void LE(String str) {
        this.kQb = str;
    }
}
