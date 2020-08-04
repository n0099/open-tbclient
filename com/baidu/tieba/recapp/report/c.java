package com.baidu.tieba.recapp.report;

import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject lqY;
    private String lra;
    private JSONObject lrb;
    private int lrc;
    private String lrd;
    private int lre;
    private int lrf;
    private int lrg;
    private int lrh;
    private int lri;
    private int lrj;
    private String lrk;
    private String lrl;
    private String lrm;
    private String lrn;
    private String lro;
    private String lrp;
    private String placeId;
    private int Yv = -1;
    private int Yx = -1;
    private int pageNumber = -1;
    private long lqZ = System.currentTimeMillis() / 1000;

    public void ME(String str) {
        this.extInfo = str;
    }

    public void DQ(int i) {
        this.Yv = i;
        if (this.lrb != null) {
            try {
                this.lrb.put("da_type", i);
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
        this.lra = str;
    }

    public void MH(String str) {
    }

    public void DS(int i) {
        this.lrf = i;
    }

    public void DT(int i) {
        this.lrg = i;
    }

    public void DU(int i) {
        this.lrh = i;
    }

    public void DV(int i) {
        this.lri = i;
    }

    public void DW(int i) {
        this.lrj = i;
    }

    public void MI(String str) {
        this.lrk = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Yx = com.baidu.adp.lib.f.b.toInt(downloadStaticsData.getAdPosition(), 0);
            this.lra = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void fo(String str, String str2) {
        if (this.lqY == null) {
            this.lqY = new JSONObject();
        }
        try {
            this.lqY.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject dcX() {
        if (this.lrb != null) {
            return this.lrb;
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
            jSONObject.put("origin_time", this.lqZ);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.lra);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.lrc);
            jSONObject.put("ext3", this.lre);
            jSONObject.put("ext2", this.lrd);
            jSONObject.put("da_ext1", this.lrf);
            jSONObject.put("da_ext2", this.lrg);
            jSONObject.put("da_ext3", this.lrh);
            jSONObject.put("da_ext4", this.lri);
            jSONObject.put("da_ext5", this.lrj);
            jSONObject.put("da_menu1", this.lrl);
            jSONObject.put("da_menu2", this.lrm);
            jSONObject.put("da_menu3", this.lrn);
            jSONObject.put("da_page", this.lro);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.lrk);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.lrp);
        } catch (JSONException e) {
        }
        if (this.lqY != null) {
            try {
                jSONObject.put("ext", this.lqY);
            } catch (Exception e2) {
            }
        }
        this.lrb = jSONObject;
        return jSONObject;
    }

    public void MJ(String str) {
        this.lrl = str;
    }

    public void MK(String str) {
        this.lrm = str;
    }

    public void ML(String str) {
        this.lrn = str;
    }

    public void MM(String str) {
        this.lro = str;
    }

    public void MN(String str) {
        this.lrp = str;
    }
}
