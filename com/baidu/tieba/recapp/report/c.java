package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private String myA;
    private String myB;
    private String myC;
    private String myD;
    private String myE;
    private JSONObject myn;
    private String myp;
    private JSONObject myq;
    private int myr;
    private String mys;
    private int myt;
    private int myu;
    private int myv;
    private int myw;
    private int myx;
    private int myy;
    private String myz;
    private String placeId;
    private int ZM = -1;
    private int ZO = -1;
    private int pageNumber = -1;
    private long myo = System.currentTimeMillis() / 1000;

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void HY(int i) {
        this.ZM = i;
        if (this.myq != null) {
            try {
                this.myq.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void HZ(int i) {
        this.ZO = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void RF(String str) {
        this.placeId = str;
    }

    public void RG(String str) {
        this.myp = str;
    }

    public void RH(String str) {
    }

    public void Ia(int i) {
        this.myu = i;
    }

    public void Ib(int i) {
        this.myv = i;
    }

    public void Ic(int i) {
        this.myw = i;
    }

    public void Id(int i) {
        this.myx = i;
    }

    public void Ie(int i) {
        this.myy = i;
    }

    public void RI(String str) {
        this.myz = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.ZO = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.myp = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void ge(String str, String str2) {
        if (this.myn == null) {
            this.myn = new JSONObject();
        }
        try {
            this.myn.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject dBo() {
        if (this.myq != null) {
            return this.myq;
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
            jSONObject.put("origin_time", this.myo);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.myp);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.myr);
            jSONObject.put("ext3", this.myt);
            jSONObject.put("ext2", this.mys);
            jSONObject.put("da_ext1", this.myu);
            jSONObject.put("da_ext2", this.myv);
            jSONObject.put("da_ext3", this.myw);
            jSONObject.put("da_ext4", this.myx);
            jSONObject.put("da_ext5", this.myy);
            jSONObject.put("da_menu1", this.myA);
            jSONObject.put("da_menu2", this.myB);
            jSONObject.put("da_menu3", this.myC);
            jSONObject.put("da_page", this.myD);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.myz);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.myE);
        } catch (JSONException e) {
        }
        if (this.myn != null) {
            try {
                jSONObject.put("ext", this.myn);
            } catch (Exception e2) {
            }
        }
        this.myq = jSONObject;
        return jSONObject;
    }

    public void RJ(String str) {
        this.myA = str;
    }

    public void RK(String str) {
        this.myB = str;
    }

    public void RL(String str) {
        this.myC = str;
    }

    public void RM(String str) {
        this.myD = str;
    }

    public void RN(String str) {
        this.myE = str;
    }
}
