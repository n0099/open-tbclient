package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private int lHA;
    private int lHB;
    private int lHC;
    private int lHD;
    private int lHE;
    private String lHF;
    private String lHG;
    private String lHH;
    private String lHI;
    private String lHJ;
    private String lHK;
    private JSONObject lHt;
    private String lHv;
    private JSONObject lHw;
    private int lHx;
    private String lHy;
    private int lHz;
    private String placeId;
    private int Za = -1;
    private int Zc = -1;
    private int pageNumber = -1;
    private long lHu = System.currentTimeMillis() / 1000;

    public void PB(String str) {
        this.extInfo = str;
    }

    public void Gl(int i) {
        this.Za = i;
        if (this.lHw != null) {
            try {
                this.lHw.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void Gm(int i) {
        this.Zc = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void PC(String str) {
        this.placeId = str;
    }

    public void PD(String str) {
        this.lHv = str;
    }

    public void PE(String str) {
    }

    public void Gn(int i) {
        this.lHA = i;
    }

    public void Go(int i) {
        this.lHB = i;
    }

    public void Gp(int i) {
        this.lHC = i;
    }

    public void Gq(int i) {
        this.lHD = i;
    }

    public void Gr(int i) {
        this.lHE = i;
    }

    public void PF(String str) {
        this.lHF = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Zc = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.lHv = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void fF(String str, String str2) {
        if (this.lHt == null) {
            this.lHt = new JSONObject();
        }
        try {
            this.lHt.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject doh() {
        if (this.lHw != null) {
            return this.lHw;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Zc != -1) {
                jSONObject.put("da_locate", this.Zc);
            }
            if (this.Za != -1) {
                jSONObject.put("da_type", this.Za);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.lHu);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.lHv);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.lHx);
            jSONObject.put("ext3", this.lHz);
            jSONObject.put("ext2", this.lHy);
            jSONObject.put("da_ext1", this.lHA);
            jSONObject.put("da_ext2", this.lHB);
            jSONObject.put("da_ext3", this.lHC);
            jSONObject.put("da_ext4", this.lHD);
            jSONObject.put("da_ext5", this.lHE);
            jSONObject.put("da_menu1", this.lHG);
            jSONObject.put("da_menu2", this.lHH);
            jSONObject.put("da_menu3", this.lHI);
            jSONObject.put("da_page", this.lHJ);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.lHF);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.lHK);
        } catch (JSONException e) {
        }
        if (this.lHt != null) {
            try {
                jSONObject.put("ext", this.lHt);
            } catch (Exception e2) {
            }
        }
        this.lHw = jSONObject;
        return jSONObject;
    }

    public void PG(String str) {
        this.lHG = str;
    }

    public void PH(String str) {
        this.lHH = str;
    }

    public void PI(String str) {
        this.lHI = str;
    }

    public void PJ(String str) {
        this.lHJ = str;
    }

    public void PK(String str) {
        this.lHK = str;
    }
}
