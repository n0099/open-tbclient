package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject mNf;
    private String mNh;
    private JSONObject mNi;
    private int mNj;
    private String mNk;
    private int mNl;
    private int mNm;
    private int mNn;
    private int mNo;
    private int mNp;
    private int mNq;
    private String mNr;
    private String mNs;
    private String mNt;
    private String mNu;
    private String mNv;
    private String mNw;
    private String placeId;
    private int aaN = -1;
    private int aaP = -1;
    private int pageNumber = -1;
    private long mNg = System.currentTimeMillis() / 1000;

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void Jq(int i) {
        this.aaN = i;
        if (this.mNi != null) {
            try {
                this.mNi.put("da_type", i);
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
        this.mNh = str;
    }

    public void Sr(String str) {
    }

    public void Js(int i) {
        this.mNm = i;
    }

    public void Jt(int i) {
        this.mNn = i;
    }

    public void Ju(int i) {
        this.mNo = i;
    }

    public void Jv(int i) {
        this.mNp = i;
    }

    public void Jw(int i) {
        this.mNq = i;
    }

    public void Ss(String str) {
        this.mNr = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.aaP = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.mNh = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void gj(String str, String str2) {
        if (this.mNf == null) {
            this.mNf = new JSONObject();
        }
        try {
            this.mNf.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject makeJSONObject() {
        if (this.mNi != null) {
            return this.mNi;
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
            jSONObject.put("origin_time", this.mNg);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.mNh);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.mNj);
            jSONObject.put("ext3", this.mNl);
            jSONObject.put("ext2", this.mNk);
            jSONObject.put("da_ext1", this.mNm);
            jSONObject.put("da_ext2", this.mNn);
            jSONObject.put("da_ext3", this.mNo);
            jSONObject.put("da_ext4", this.mNp);
            jSONObject.put("da_ext5", this.mNq);
            jSONObject.put("da_menu1", this.mNs);
            jSONObject.put("da_menu2", this.mNt);
            jSONObject.put("da_menu3", this.mNu);
            jSONObject.put("da_page", this.mNv);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.mNr);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.mNw);
        } catch (JSONException e) {
        }
        if (this.mNf != null) {
            try {
                jSONObject.put("ext", this.mNf);
            } catch (Exception e2) {
            }
        }
        this.mNi = jSONObject;
        return jSONObject;
    }

    public void St(String str) {
        this.mNs = str;
    }

    public void Su(String str) {
        this.mNt = str;
    }

    public void Sv(String str) {
        this.mNu = str;
    }

    public void Sw(String str) {
        this.mNv = str;
    }

    public void Sx(String str) {
        this.mNw = str;
    }
}
