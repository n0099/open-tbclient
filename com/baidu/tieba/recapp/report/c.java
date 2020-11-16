package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject myS;
    private String myU;
    private JSONObject myV;
    private int myW;
    private String myX;
    private int myY;
    private int myZ;
    private int mza;
    private int mzb;
    private int mzc;
    private int mzd;
    private String mze;
    private String mzf;
    private String mzg;
    private String mzh;
    private String mzi;
    private String mzj;
    private String placeId;
    private int ZR = -1;
    private int ZT = -1;
    private int pageNumber = -1;
    private long myT = System.currentTimeMillis() / 1000;

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void Iz(int i) {
        this.ZR = i;
        if (this.myV != null) {
            try {
                this.myV.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void IA(int i) {
        this.ZT = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void Rd(String str) {
        this.placeId = str;
    }

    public void Re(String str) {
        this.myU = str;
    }

    public void Rf(String str) {
    }

    public void IB(int i) {
        this.myZ = i;
    }

    public void IC(int i) {
        this.mza = i;
    }

    public void ID(int i) {
        this.mzb = i;
    }

    public void IE(int i) {
        this.mzc = i;
    }

    public void IF(int i) {
        this.mzd = i;
    }

    public void Rg(String str) {
        this.mze = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.ZT = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.myU = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void ge(String str, String str2) {
        if (this.myS == null) {
            this.myS = new JSONObject();
        }
        try {
            this.myS.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject dAS() {
        if (this.myV != null) {
            return this.myV;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.ZT != -1) {
                jSONObject.put("da_locate", this.ZT);
            }
            if (this.ZR != -1) {
                jSONObject.put("da_type", this.ZR);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.myT);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.myU);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.myW);
            jSONObject.put("ext3", this.myY);
            jSONObject.put("ext2", this.myX);
            jSONObject.put("da_ext1", this.myZ);
            jSONObject.put("da_ext2", this.mza);
            jSONObject.put("da_ext3", this.mzb);
            jSONObject.put("da_ext4", this.mzc);
            jSONObject.put("da_ext5", this.mzd);
            jSONObject.put("da_menu1", this.mzf);
            jSONObject.put("da_menu2", this.mzg);
            jSONObject.put("da_menu3", this.mzh);
            jSONObject.put("da_page", this.mzi);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.mze);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.mzj);
        } catch (JSONException e) {
        }
        if (this.myS != null) {
            try {
                jSONObject.put("ext", this.myS);
            } catch (Exception e2) {
            }
        }
        this.myV = jSONObject;
        return jSONObject;
    }

    public void Rh(String str) {
        this.mzf = str;
    }

    public void Ri(String str) {
        this.mzg = str;
    }

    public void Rj(String str) {
        this.mzh = str;
    }

    public void Rk(String str) {
        this.mzi = str;
    }

    public void Rl(String str) {
        this.mzj = str;
    }
}
