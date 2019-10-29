package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private int iNA;
    private int iNB;
    private int iNC;
    private int iND;
    private int iNE;
    private String iNF;
    private String iNG;
    private String iNH;
    private String iNI;
    private String iNJ;
    private String iNK;
    private JSONObject iNt;
    private String iNv;
    private JSONObject iNw;
    private int iNx;
    private String iNy;
    private int iNz;
    private String placeId;
    private int BM = -1;
    private int BO = -1;
    private int pageNumber = -1;
    private long iNu = System.currentTimeMillis() / 1000;

    public void CP(String str) {
        this.extInfo = str;
    }

    public void yp(int i) {
        this.BM = i;
        if (this.iNw != null) {
            try {
                this.iNw.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void yq(int i) {
        this.BO = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void CQ(String str) {
        this.placeId = str;
    }

    public void CR(String str) {
        this.iNv = str;
    }

    public void CS(String str) {
    }

    public void yr(int i) {
        this.iNA = i;
    }

    public void ys(int i) {
        this.iNB = i;
    }

    public void yt(int i) {
        this.iNC = i;
    }

    public void yu(int i) {
        this.iND = i;
    }

    public void yv(int i) {
        this.iNE = i;
    }

    public void CT(String str) {
        this.iNF = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.BO = com.baidu.adp.lib.g.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.iNv = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void dN(String str, String str2) {
        if (this.iNt == null) {
            this.iNt = new JSONObject();
        }
        try {
            this.iNt.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cgH() {
        if (this.iNw != null) {
            return this.iNw;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.BO != -1) {
                jSONObject.put("da_locate", this.BO);
            }
            if (this.BM != -1) {
                jSONObject.put("da_type", this.BM);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.iNu);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.iNv);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.iNx);
            jSONObject.put("ext3", this.iNz);
            jSONObject.put("ext2", this.iNy);
            jSONObject.put("da_ext1", this.iNA);
            jSONObject.put("da_ext2", this.iNB);
            jSONObject.put("da_ext3", this.iNC);
            jSONObject.put("da_ext4", this.iND);
            jSONObject.put("da_ext5", this.iNE);
            jSONObject.put("da_menu1", this.iNG);
            jSONObject.put("da_menu2", this.iNH);
            jSONObject.put("da_menu3", this.iNI);
            jSONObject.put("da_page", this.iNJ);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.iNF);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.iNK);
        } catch (JSONException e) {
        }
        if (this.iNt != null) {
            try {
                jSONObject.put("ext", this.iNt);
            } catch (Exception e2) {
            }
        }
        this.iNw = jSONObject;
        return jSONObject;
    }

    public void CU(String str) {
        this.iNG = str;
    }

    public void CV(String str) {
        this.iNH = str;
    }

    public void CW(String str) {
        this.iNI = str;
    }

    public void CX(String str) {
        this.iNJ = str;
    }

    public void CY(String str) {
        this.iNK = str;
    }
}
