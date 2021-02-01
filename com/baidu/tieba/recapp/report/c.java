package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject mWW;
    private String mWY;
    private int mWZ;
    private String mXa;
    private int mXb;
    private String mXc;
    private String mXd;
    private String mXe;
    private String mXf;
    private String mXg;
    private String mXh;
    private String mXi;
    private String mXj;
    private String mXk;
    private String mXl;
    private String mXm;
    private String placeId;
    private int abr = -1;
    private int abu = -1;
    private int pageNumber = -1;
    private long mWX = System.currentTimeMillis() / 1000;

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

    public void RI(String str) {
        this.placeId = str;
    }

    public void RJ(String str) {
        this.mWY = str;
    }

    public void RK(String str) {
    }

    public void HY(int i) {
        this.mXc = String.valueOf(i);
    }

    public void HZ(int i) {
        this.mXd = String.valueOf(i);
    }

    public void Ia(int i) {
        this.mXe = String.valueOf(i);
    }

    public void Ib(int i) {
        this.mXf = String.valueOf(i);
    }

    public void Ic(int i) {
        this.mXg = String.valueOf(i);
    }

    public void RL(String str) {
        this.mXg = str;
    }

    public void RM(String str) {
        this.mXh = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.abu = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.mWY = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void gk(String str, String str2) {
        if (this.mWW == null) {
            this.mWW = new JSONObject();
        }
        try {
            this.mWW.put(str, str2);
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
            jSONObject.put("origin_time", this.mWX);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.mWY);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.mWZ);
            jSONObject.put("ext3", this.mXb);
            jSONObject.put("ext2", this.mXa);
            jSONObject.put("da_ext1", this.mXc);
            jSONObject.put("da_ext2", this.mXd);
            jSONObject.put("da_ext3", this.mXe);
            jSONObject.put("da_ext4", this.mXf);
            jSONObject.put("da_ext5", this.mXg);
            jSONObject.put("da_menu1", this.mXi);
            jSONObject.put("da_menu2", this.mXj);
            jSONObject.put("da_menu3", this.mXk);
            jSONObject.put("da_page", this.mXl);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.mXh);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.mXm);
        } catch (JSONException e) {
        }
        if (this.mWW != null) {
            try {
                jSONObject.put("ext", this.mWW);
            } catch (Exception e2) {
            }
        }
        return jSONObject;
    }

    public void RN(String str) {
        this.mXi = str;
    }

    public void RO(String str) {
        this.mXj = str;
    }

    public void RP(String str) {
        this.mXk = str;
    }

    public void RQ(String str) {
        this.mXl = str;
    }

    public void RR(String str) {
        this.mXm = str;
    }
}
