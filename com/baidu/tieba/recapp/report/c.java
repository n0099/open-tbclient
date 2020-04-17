package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject kwE;
    private String kwG;
    private JSONObject kwH;
    private int kwI;
    private String kwJ;
    private int kwK;
    private int kwL;
    private int kwM;
    private int kwN;
    private int kwO;
    private int kwP;
    private String kwQ;
    private String kwR;
    private String kwS;
    private String kwT;
    private String kwU;
    private String kwV;
    private String placeId;
    private int XI = -1;
    private int XK = -1;
    private int pageNumber = -1;
    private long kwF = System.currentTimeMillis() / 1000;

    public void JF(String str) {
        this.extInfo = str;
    }

    public void BG(int i) {
        this.XI = i;
        if (this.kwH != null) {
            try {
                this.kwH.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void BH(int i) {
        this.XK = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void JG(String str) {
        this.placeId = str;
    }

    public void JH(String str) {
        this.kwG = str;
    }

    public void JI(String str) {
    }

    public void BI(int i) {
        this.kwL = i;
    }

    public void BJ(int i) {
        this.kwM = i;
    }

    public void BK(int i) {
        this.kwN = i;
    }

    public void BL(int i) {
        this.kwO = i;
    }

    public void BM(int i) {
        this.kwP = i;
    }

    public void JJ(String str) {
        this.kwQ = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.XK = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.kwG = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void eE(String str, String str2) {
        if (this.kwE == null) {
            this.kwE = new JSONObject();
        }
        try {
            this.kwE.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cOk() {
        if (this.kwH != null) {
            return this.kwH;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.XK != -1) {
                jSONObject.put("da_locate", this.XK);
            }
            if (this.XI != -1) {
                jSONObject.put("da_type", this.XI);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.kwF);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.kwG);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.kwI);
            jSONObject.put("ext3", this.kwK);
            jSONObject.put("ext2", this.kwJ);
            jSONObject.put("da_ext1", this.kwL);
            jSONObject.put("da_ext2", this.kwM);
            jSONObject.put("da_ext3", this.kwN);
            jSONObject.put("da_ext4", this.kwO);
            jSONObject.put("da_ext5", this.kwP);
            jSONObject.put("da_menu1", this.kwR);
            jSONObject.put("da_menu2", this.kwS);
            jSONObject.put("da_menu3", this.kwT);
            jSONObject.put("da_page", this.kwU);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.kwQ);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.kwV);
        } catch (JSONException e) {
        }
        if (this.kwE != null) {
            try {
                jSONObject.put("ext", this.kwE);
            } catch (Exception e2) {
            }
        }
        this.kwH = jSONObject;
        return jSONObject;
    }

    public void JK(String str) {
        this.kwR = str;
    }

    public void JL(String str) {
        this.kwS = str;
    }

    public void JM(String str) {
        this.kwT = str;
    }

    public void JN(String str) {
        this.kwU = str;
    }

    public void JO(String str) {
        this.kwV = str;
    }
}
