package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject iLb;
    private String iLd;
    private JSONObject iLe;
    private int iLf;
    private String iLg;
    private int iLh;
    private int iLi;
    private int iLj;
    private int iLk;
    private int iLl;
    private int iLm;
    private String iLn;
    private String iLo;
    private String iLp;
    private String iLq;
    private String iLr;
    private String iLs;
    private String placeId;
    private int Ss = -1;
    private int Su = -1;
    private int pageNumber = -1;
    private long iLc = System.currentTimeMillis() / 1000;

    public void DT(String str) {
        this.extInfo = str;
    }

    public void zE(int i) {
        this.Ss = i;
        if (this.iLe != null) {
            try {
                this.iLe.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void zF(int i) {
        this.Su = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void DU(String str) {
        this.placeId = str;
    }

    public void DV(String str) {
        this.iLd = str;
    }

    public void DW(String str) {
    }

    public void zG(int i) {
        this.iLi = i;
    }

    public void zH(int i) {
        this.iLj = i;
    }

    public void zI(int i) {
        this.iLk = i;
    }

    public void zJ(int i) {
        this.iLl = i;
    }

    public void zK(int i) {
        this.iLm = i;
    }

    public void DX(String str) {
        this.iLn = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Su = com.baidu.adp.lib.g.b.f(downloadStaticsData.getAdPosition(), 0);
            this.iLd = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void ea(String str, String str2) {
        if (this.iLb == null) {
            this.iLb = new JSONObject();
        }
        try {
            this.iLb.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cix() {
        if (this.iLe != null) {
            return this.iLe;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Su != -1) {
                jSONObject.put("da_locate", this.Su);
            }
            if (this.Ss != -1) {
                jSONObject.put("da_type", this.Ss);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.iLc);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.iLd);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.iLf);
            jSONObject.put("ext3", this.iLh);
            jSONObject.put("ext2", this.iLg);
            jSONObject.put("da_ext1", this.iLi);
            jSONObject.put("da_ext2", this.iLj);
            jSONObject.put("da_ext3", this.iLk);
            jSONObject.put("da_ext4", this.iLl);
            jSONObject.put("da_ext5", this.iLm);
            jSONObject.put("da_menu1", this.iLo);
            jSONObject.put("da_menu2", this.iLp);
            jSONObject.put("da_menu3", this.iLq);
            jSONObject.put("da_page", this.iLr);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.iLn);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.iLs);
        } catch (JSONException e) {
        }
        if (this.iLb != null) {
            try {
                jSONObject.put("ext", this.iLb);
            } catch (Exception e2) {
            }
        }
        this.iLe = jSONObject;
        return jSONObject;
    }

    public void DY(String str) {
        this.iLo = str;
    }

    public void DZ(String str) {
        this.iLp = str;
    }

    public void Ea(String str) {
        this.iLq = str;
    }

    public void Eb(String str) {
        this.iLr = str;
    }

    public void Ec(String str) {
        this.iLs = str;
    }
}
