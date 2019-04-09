package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject ilU;
    private String ilW;
    private JSONObject ilX;
    private int ilY;
    private String ilZ;
    private int ima;
    private int imb;
    private int imc;
    private int imd;
    private int ime;
    private int imf;
    private String imh;
    private String imi;
    private String imj;
    private String imk;
    private String iml;
    private String imm;
    private String placeId;
    private int Up = -1;
    private int Ur = -1;
    private int pageNumber = -1;
    private long ilV = System.currentTimeMillis() / 1000;

    public void BI(String str) {
        this.extInfo = str;
    }

    public void xS(int i) {
        this.Up = i;
        if (this.ilX != null) {
            try {
                this.ilX.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void xT(int i) {
        this.Ur = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void BJ(String str) {
        this.placeId = str;
    }

    public void BK(String str) {
        this.ilW = str;
    }

    public void BL(String str) {
    }

    public void xU(int i) {
        this.imb = i;
    }

    public void xV(int i) {
        this.imc = i;
    }

    public void xW(int i) {
        this.imd = i;
    }

    public void xX(int i) {
        this.ime = i;
    }

    public void xY(int i) {
        this.imf = i;
    }

    public void BM(String str) {
        this.imh = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Ur = com.baidu.adp.lib.g.b.l(downloadStaticsData.getAdPosition(), 0);
            this.ilW = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void dL(String str, String str2) {
        if (this.ilU == null) {
            this.ilU = new JSONObject();
        }
        try {
            this.ilU.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject bXz() {
        if (this.ilX != null) {
            return this.ilX;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Ur != -1) {
                jSONObject.put("da_locate", this.Ur);
            }
            if (this.Up != -1) {
                jSONObject.put("da_type", this.Up);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.ilV);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.ilW);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.ilY);
            jSONObject.put("ext3", this.ima);
            jSONObject.put("ext2", this.ilZ);
            jSONObject.put("da_ext1", this.imb);
            jSONObject.put("da_ext2", this.imc);
            jSONObject.put("da_ext3", this.imd);
            jSONObject.put("da_ext4", this.ime);
            jSONObject.put("da_ext5", this.imf);
            jSONObject.put("da_menu1", this.imi);
            jSONObject.put("da_menu2", this.imj);
            jSONObject.put("da_menu3", this.imk);
            jSONObject.put("da_page", this.iml);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.imh);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.imm);
        } catch (JSONException e) {
        }
        if (this.ilU != null) {
            try {
                jSONObject.put("ext", this.ilU);
            } catch (Exception e2) {
            }
        }
        this.ilX = jSONObject;
        return jSONObject;
    }

    public void BN(String str) {
        this.imi = str;
    }

    public void BO(String str) {
        this.imj = str;
    }

    public void BP(String str) {
        this.imk = str;
    }

    public void BQ(String str) {
        this.iml = str;
    }

    public void BR(String str) {
        this.imm = str;
    }
}
