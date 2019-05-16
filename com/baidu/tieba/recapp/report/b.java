package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject iEG;
    private String iEI;
    private JSONObject iEJ;
    private int iEK;
    private String iEL;
    private int iEM;
    private int iEN;
    private int iEO;
    private int iEP;
    private int iEQ;
    private int iER;
    private String iES;
    private String iET;
    private String iEU;
    private String iEV;
    private String iEW;
    private String iEX;
    private String placeId;
    private int Sb = -1;
    private int Sd = -1;
    private int pageNumber = -1;
    private long iEH = System.currentTimeMillis() / 1000;

    public void De(String str) {
        this.extInfo = str;
    }

    public void yZ(int i) {
        this.Sb = i;
        if (this.iEJ != null) {
            try {
                this.iEJ.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void za(int i) {
        this.Sd = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void Df(String str) {
        this.placeId = str;
    }

    public void Dg(String str) {
        this.iEI = str;
    }

    public void Dh(String str) {
    }

    public void zb(int i) {
        this.iEN = i;
    }

    public void zc(int i) {
        this.iEO = i;
    }

    public void zd(int i) {
        this.iEP = i;
    }

    public void ze(int i) {
        this.iEQ = i;
    }

    public void zf(int i) {
        this.iER = i;
    }

    public void Di(String str) {
        this.iES = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Sd = com.baidu.adp.lib.g.b.f(downloadStaticsData.getAdPosition(), 0);
            this.iEI = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void dZ(String str, String str2) {
        if (this.iEG == null) {
            this.iEG = new JSONObject();
        }
        try {
            this.iEG.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cfD() {
        if (this.iEJ != null) {
            return this.iEJ;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Sd != -1) {
                jSONObject.put("da_locate", this.Sd);
            }
            if (this.Sb != -1) {
                jSONObject.put("da_type", this.Sb);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.iEH);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.iEI);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.iEK);
            jSONObject.put("ext3", this.iEM);
            jSONObject.put("ext2", this.iEL);
            jSONObject.put("da_ext1", this.iEN);
            jSONObject.put("da_ext2", this.iEO);
            jSONObject.put("da_ext3", this.iEP);
            jSONObject.put("da_ext4", this.iEQ);
            jSONObject.put("da_ext5", this.iER);
            jSONObject.put("da_menu1", this.iET);
            jSONObject.put("da_menu2", this.iEU);
            jSONObject.put("da_menu3", this.iEV);
            jSONObject.put("da_page", this.iEW);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.iES);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.iEX);
        } catch (JSONException e) {
        }
        if (this.iEG != null) {
            try {
                jSONObject.put("ext", this.iEG);
            } catch (Exception e2) {
            }
        }
        this.iEJ = jSONObject;
        return jSONObject;
    }

    public void Dj(String str) {
        this.iET = str;
    }

    public void Dk(String str) {
        this.iEU = str;
    }

    public void Dl(String str) {
        this.iEV = str;
    }

    public void Dm(String str) {
        this.iEW = str;
    }

    public void Dn(String str) {
        this.iEX = str;
    }
}
