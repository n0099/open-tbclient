package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject kwI;
    private String kwK;
    private JSONObject kwL;
    private int kwM;
    private String kwN;
    private int kwO;
    private int kwP;
    private int kwQ;
    private int kwR;
    private int kwS;
    private int kwT;
    private String kwU;
    private String kwV;
    private String kwW;
    private String kwX;
    private String kwY;
    private String kwZ;
    private String placeId;
    private int XL = -1;
    private int XN = -1;
    private int pageNumber = -1;
    private long kwJ = System.currentTimeMillis() / 1000;

    public void JI(String str) {
        this.extInfo = str;
    }

    public void BG(int i) {
        this.XL = i;
        if (this.kwL != null) {
            try {
                this.kwL.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void BH(int i) {
        this.XN = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void JJ(String str) {
        this.placeId = str;
    }

    public void JK(String str) {
        this.kwK = str;
    }

    public void JL(String str) {
    }

    public void BI(int i) {
        this.kwP = i;
    }

    public void BJ(int i) {
        this.kwQ = i;
    }

    public void BK(int i) {
        this.kwR = i;
    }

    public void BL(int i) {
        this.kwS = i;
    }

    public void BM(int i) {
        this.kwT = i;
    }

    public void JM(String str) {
        this.kwU = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.XN = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.kwK = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void eE(String str, String str2) {
        if (this.kwI == null) {
            this.kwI = new JSONObject();
        }
        try {
            this.kwI.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cOh() {
        if (this.kwL != null) {
            return this.kwL;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.XN != -1) {
                jSONObject.put("da_locate", this.XN);
            }
            if (this.XL != -1) {
                jSONObject.put("da_type", this.XL);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.kwJ);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.kwK);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.kwM);
            jSONObject.put("ext3", this.kwO);
            jSONObject.put("ext2", this.kwN);
            jSONObject.put("da_ext1", this.kwP);
            jSONObject.put("da_ext2", this.kwQ);
            jSONObject.put("da_ext3", this.kwR);
            jSONObject.put("da_ext4", this.kwS);
            jSONObject.put("da_ext5", this.kwT);
            jSONObject.put("da_menu1", this.kwV);
            jSONObject.put("da_menu2", this.kwW);
            jSONObject.put("da_menu3", this.kwX);
            jSONObject.put("da_page", this.kwY);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.kwU);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.kwZ);
        } catch (JSONException e) {
        }
        if (this.kwI != null) {
            try {
                jSONObject.put("ext", this.kwI);
            } catch (Exception e2) {
            }
        }
        this.kwL = jSONObject;
        return jSONObject;
    }

    public void JN(String str) {
        this.kwV = str;
    }

    public void JO(String str) {
        this.kwW = str;
    }

    public void JP(String str) {
        this.kwX = str;
    }

    public void JQ(String str) {
        this.kwY = str;
    }

    public void JR(String str) {
        this.kwZ = str;
    }
}
