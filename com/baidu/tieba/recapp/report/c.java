package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private int msA;
    private int msB;
    private int msC;
    private String msD;
    private String msE;
    private String msF;
    private String msG;
    private String msH;
    private String msI;
    private JSONObject msr;
    private String mst;
    private JSONObject msu;
    private int msv;
    private String msw;
    private int msx;
    private int msy;
    private int msz;
    private String placeId;
    private int ZM = -1;
    private int ZO = -1;
    private int pageNumber = -1;
    private long mss = System.currentTimeMillis() / 1000;

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void HL(int i) {
        this.ZM = i;
        if (this.msu != null) {
            try {
                this.msu.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void HM(int i) {
        this.ZO = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void Ro(String str) {
        this.placeId = str;
    }

    public void Rp(String str) {
        this.mst = str;
    }

    public void Rq(String str) {
    }

    public void HN(int i) {
        this.msy = i;
    }

    public void HO(int i) {
        this.msz = i;
    }

    public void HP(int i) {
        this.msA = i;
    }

    public void HQ(int i) {
        this.msB = i;
    }

    public void HR(int i) {
        this.msC = i;
    }

    public void Rr(String str) {
        this.msD = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.ZO = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.mst = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void ge(String str, String str2) {
        if (this.msr == null) {
            this.msr = new JSONObject();
        }
        try {
            this.msr.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject dyM() {
        if (this.msu != null) {
            return this.msu;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.ZO != -1) {
                jSONObject.put("da_locate", this.ZO);
            }
            if (this.ZM != -1) {
                jSONObject.put("da_type", this.ZM);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.mss);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.mst);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.msv);
            jSONObject.put("ext3", this.msx);
            jSONObject.put("ext2", this.msw);
            jSONObject.put("da_ext1", this.msy);
            jSONObject.put("da_ext2", this.msz);
            jSONObject.put("da_ext3", this.msA);
            jSONObject.put("da_ext4", this.msB);
            jSONObject.put("da_ext5", this.msC);
            jSONObject.put("da_menu1", this.msE);
            jSONObject.put("da_menu2", this.msF);
            jSONObject.put("da_menu3", this.msG);
            jSONObject.put("da_page", this.msH);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.msD);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.msI);
        } catch (JSONException e) {
        }
        if (this.msr != null) {
            try {
                jSONObject.put("ext", this.msr);
            } catch (Exception e2) {
            }
        }
        this.msu = jSONObject;
        return jSONObject;
    }

    public void Rs(String str) {
        this.msE = str;
    }

    public void Rt(String str) {
        this.msF = str;
    }

    public void Ru(String str) {
        this.msG = str;
    }

    public void Rv(String str) {
        this.msH = str;
    }

    public void Rw(String str) {
        this.msI = str;
    }
}
