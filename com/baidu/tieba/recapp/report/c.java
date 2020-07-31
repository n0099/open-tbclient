package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject lqW;
    private String lqY;
    private JSONObject lqZ;
    private int lra;
    private String lrb;
    private int lrc;
    private int lrd;
    private int lre;
    private int lrf;
    private int lrg;
    private int lrh;
    private String lri;
    private String lrj;
    private String lrk;
    private String lrl;
    private String lrm;
    private String lrn;
    private String placeId;
    private int Yv = -1;
    private int Yx = -1;
    private int pageNumber = -1;
    private long lqX = System.currentTimeMillis() / 1000;

    public void ME(String str) {
        this.extInfo = str;
    }

    public void DQ(int i) {
        this.Yv = i;
        if (this.lqZ != null) {
            try {
                this.lqZ.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void DR(int i) {
        this.Yx = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void MF(String str) {
        this.placeId = str;
    }

    public void MG(String str) {
        this.lqY = str;
    }

    public void MH(String str) {
    }

    public void DS(int i) {
        this.lrd = i;
    }

    public void DT(int i) {
        this.lre = i;
    }

    public void DU(int i) {
        this.lrf = i;
    }

    public void DV(int i) {
        this.lrg = i;
    }

    public void DW(int i) {
        this.lrh = i;
    }

    public void MI(String str) {
        this.lri = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Yx = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.lqY = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void fo(String str, String str2) {
        if (this.lqW == null) {
            this.lqW = new JSONObject();
        }
        try {
            this.lqW.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject dcX() {
        if (this.lqZ != null) {
            return this.lqZ;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Yx != -1) {
                jSONObject.put("da_locate", this.Yx);
            }
            if (this.Yv != -1) {
                jSONObject.put("da_type", this.Yv);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.lqX);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.lqY);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.lra);
            jSONObject.put("ext3", this.lrc);
            jSONObject.put("ext2", this.lrb);
            jSONObject.put("da_ext1", this.lrd);
            jSONObject.put("da_ext2", this.lre);
            jSONObject.put("da_ext3", this.lrf);
            jSONObject.put("da_ext4", this.lrg);
            jSONObject.put("da_ext5", this.lrh);
            jSONObject.put("da_menu1", this.lrj);
            jSONObject.put("da_menu2", this.lrk);
            jSONObject.put("da_menu3", this.lrl);
            jSONObject.put("da_page", this.lrm);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.lri);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.lrn);
        } catch (JSONException e) {
        }
        if (this.lqW != null) {
            try {
                jSONObject.put("ext", this.lqW);
            } catch (Exception e2) {
            }
        }
        this.lqZ = jSONObject;
        return jSONObject;
    }

    public void MJ(String str) {
        this.lrj = str;
    }

    public void MK(String str) {
        this.lrk = str;
    }

    public void ML(String str) {
        this.lrl = str;
    }

    public void MM(String str) {
        this.lrm = str;
    }

    public void MN(String str) {
        this.lrn = str;
    }
}
