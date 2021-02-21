package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private String mXA;
    private int mXB;
    private String mXC;
    private String mXD;
    private String mXE;
    private String mXF;
    private String mXG;
    private String mXH;
    private String mXI;
    private String mXJ;
    private String mXK;
    private String mXL;
    private String mXM;
    private JSONObject mXw;
    private String mXy;
    private int mXz;
    private String placeId;
    private int abr = -1;
    private int abu = -1;
    private int pageNumber = -1;
    private long mXx = System.currentTimeMillis() / 1000;

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void HW(int i) {
        this.abr = i;
    }

    public void HX(int i) {
        this.abu = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void RU(String str) {
        this.placeId = str;
    }

    public void RV(String str) {
        this.mXy = str;
    }

    public void RW(String str) {
    }

    public void HY(int i) {
        this.mXC = String.valueOf(i);
    }

    public void HZ(int i) {
        this.mXD = String.valueOf(i);
    }

    public void Ia(int i) {
        this.mXE = String.valueOf(i);
    }

    public void Ib(int i) {
        this.mXF = String.valueOf(i);
    }

    public void Ic(int i) {
        this.mXG = String.valueOf(i);
    }

    public void RX(String str) {
        this.mXG = str;
    }

    public void RY(String str) {
        this.mXH = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.abu = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.mXy = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void gm(String str, String str2) {
        if (this.mXw == null) {
            this.mXw = new JSONObject();
        }
        try {
            this.mXw.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject makeJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.abu != -1) {
                jSONObject.put("da_locate", this.abu);
            }
            if (this.abr != -1) {
                jSONObject.put("da_type", this.abr);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.mXx);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.mXy);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.mXz);
            jSONObject.put("ext3", this.mXB);
            jSONObject.put("ext2", this.mXA);
            jSONObject.put("da_ext1", this.mXC);
            jSONObject.put("da_ext2", this.mXD);
            jSONObject.put("da_ext3", this.mXE);
            jSONObject.put("da_ext4", this.mXF);
            jSONObject.put("da_ext5", this.mXG);
            jSONObject.put("da_menu1", this.mXI);
            jSONObject.put("da_menu2", this.mXJ);
            jSONObject.put("da_menu3", this.mXK);
            jSONObject.put("da_page", this.mXL);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.mXH);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.mXM);
        } catch (JSONException e) {
        }
        if (this.mXw != null) {
            try {
                jSONObject.put("ext", this.mXw);
            } catch (Exception e2) {
            }
        }
        return jSONObject;
    }

    public void RZ(String str) {
        this.mXI = str;
    }

    public void Sa(String str) {
        this.mXJ = str;
    }

    public void Sb(String str) {
        this.mXK = str;
    }

    public void Sc(String str) {
        this.mXL = str;
    }

    public void Sd(String str) {
        this.mXM = str;
    }
}
