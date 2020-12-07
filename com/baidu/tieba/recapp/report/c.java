package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject mNd;
    private String mNf;
    private JSONObject mNg;
    private int mNh;
    private String mNi;
    private int mNj;
    private int mNk;
    private int mNl;
    private int mNm;
    private int mNn;
    private int mNo;
    private String mNp;
    private String mNq;
    private String mNr;
    private String mNs;
    private String mNt;
    private String mNu;
    private String placeId;
    private int aaN = -1;
    private int aaP = -1;
    private int pageNumber = -1;
    private long mNe = System.currentTimeMillis() / 1000;

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void Jq(int i) {
        this.aaN = i;
        if (this.mNg != null) {
            try {
                this.mNg.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void Jr(int i) {
        this.aaP = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void Sp(String str) {
        this.placeId = str;
    }

    public void Sq(String str) {
        this.mNf = str;
    }

    public void Sr(String str) {
    }

    public void Js(int i) {
        this.mNk = i;
    }

    public void Jt(int i) {
        this.mNl = i;
    }

    public void Ju(int i) {
        this.mNm = i;
    }

    public void Jv(int i) {
        this.mNn = i;
    }

    public void Jw(int i) {
        this.mNo = i;
    }

    public void Ss(String str) {
        this.mNp = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.aaP = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.mNf = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void gj(String str, String str2) {
        if (this.mNd == null) {
            this.mNd = new JSONObject();
        }
        try {
            this.mNd.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject makeJSONObject() {
        if (this.mNg != null) {
            return this.mNg;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.aaP != -1) {
                jSONObject.put("da_locate", this.aaP);
            }
            if (this.aaN != -1) {
                jSONObject.put("da_type", this.aaN);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.mNe);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.mNf);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.mNh);
            jSONObject.put("ext3", this.mNj);
            jSONObject.put("ext2", this.mNi);
            jSONObject.put("da_ext1", this.mNk);
            jSONObject.put("da_ext2", this.mNl);
            jSONObject.put("da_ext3", this.mNm);
            jSONObject.put("da_ext4", this.mNn);
            jSONObject.put("da_ext5", this.mNo);
            jSONObject.put("da_menu1", this.mNq);
            jSONObject.put("da_menu2", this.mNr);
            jSONObject.put("da_menu3", this.mNs);
            jSONObject.put("da_page", this.mNt);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.mNp);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.mNu);
        } catch (JSONException e) {
        }
        if (this.mNd != null) {
            try {
                jSONObject.put("ext", this.mNd);
            } catch (Exception e2) {
            }
        }
        this.mNg = jSONObject;
        return jSONObject;
    }

    public void St(String str) {
        this.mNq = str;
    }

    public void Su(String str) {
        this.mNr = str;
    }

    public void Sv(String str) {
        this.mNs = str;
    }

    public void Sw(String str) {
        this.mNt = str;
    }

    public void Sx(String str) {
        this.mNu = str;
    }
}
