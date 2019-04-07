package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject ilT;
    private String ilV;
    private JSONObject ilW;
    private int ilX;
    private String ilY;
    private int ilZ;
    private int ima;
    private int imb;
    private int imc;
    private int imd;
    private int ime;
    private String imf;
    private String imh;
    private String imi;
    private String imj;
    private String imk;
    private String iml;
    private String placeId;
    private int Uo = -1;
    private int Uq = -1;
    private int pageNumber = -1;
    private long ilU = System.currentTimeMillis() / 1000;

    public void BI(String str) {
        this.extInfo = str;
    }

    public void xS(int i) {
        this.Uo = i;
        if (this.ilW != null) {
            try {
                this.ilW.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void xT(int i) {
        this.Uq = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void BJ(String str) {
        this.placeId = str;
    }

    public void BK(String str) {
        this.ilV = str;
    }

    public void BL(String str) {
    }

    public void xU(int i) {
        this.ima = i;
    }

    public void xV(int i) {
        this.imb = i;
    }

    public void xW(int i) {
        this.imc = i;
    }

    public void xX(int i) {
        this.imd = i;
    }

    public void xY(int i) {
        this.ime = i;
    }

    public void BM(String str) {
        this.imf = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Uq = com.baidu.adp.lib.g.b.l(downloadStaticsData.getAdPosition(), 0);
            this.ilV = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void dL(String str, String str2) {
        if (this.ilT == null) {
            this.ilT = new JSONObject();
        }
        try {
            this.ilT.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bXz() {
        if (this.ilW != null) {
            return this.ilW;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Uq != -1) {
                jSONObject.put("da_locate", this.Uq);
            }
            if (this.Uo != -1) {
                jSONObject.put("da_type", this.Uo);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.ilU);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.ilV);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.ilX);
            jSONObject.put("ext3", this.ilZ);
            jSONObject.put("ext2", this.ilY);
            jSONObject.put("da_ext1", this.ima);
            jSONObject.put("da_ext2", this.imb);
            jSONObject.put("da_ext3", this.imc);
            jSONObject.put("da_ext4", this.imd);
            jSONObject.put("da_ext5", this.ime);
            jSONObject.put("da_menu1", this.imh);
            jSONObject.put("da_menu2", this.imi);
            jSONObject.put("da_menu3", this.imj);
            jSONObject.put("da_page", this.imk);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.imf);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.iml);
        } catch (JSONException e) {
        }
        if (this.ilT != null) {
            try {
                jSONObject.put("ext", this.ilT);
            } catch (Exception e2) {
            }
        }
        this.ilW = jSONObject;
        return jSONObject;
    }

    public void BN(String str) {
        this.imh = str;
    }

    public void BO(String str) {
        this.imi = str;
    }

    public void BP(String str) {
        this.imj = str;
    }

    public void BQ(String str) {
        this.imk = str;
    }

    public void BR(String str) {
        this.iml = str;
    }
}
