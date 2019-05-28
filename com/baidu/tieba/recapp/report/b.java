package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject iEI;
    private String iEK;
    private JSONObject iEL;
    private int iEM;
    private String iEN;
    private int iEO;
    private int iEP;
    private int iEQ;
    private int iER;
    private int iES;
    private int iET;
    private String iEU;
    private String iEV;
    private String iEW;
    private String iEX;
    private String iEY;
    private String iEZ;
    private String placeId;
    private int Sb = -1;
    private int Sd = -1;
    private int pageNumber = -1;
    private long iEJ = System.currentTimeMillis() / 1000;

    public void De(String str) {
        this.extInfo = str;
    }

    public void yZ(int i) {
        this.Sb = i;
        if (this.iEL != null) {
            try {
                this.iEL.put("da_type", i);
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
        this.iEK = str;
    }

    public void Dh(String str) {
    }

    public void zb(int i) {
        this.iEP = i;
    }

    public void zc(int i) {
        this.iEQ = i;
    }

    public void zd(int i) {
        this.iER = i;
    }

    public void ze(int i) {
        this.iES = i;
    }

    public void zf(int i) {
        this.iET = i;
    }

    public void Di(String str) {
        this.iEU = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Sd = com.baidu.adp.lib.g.b.f(downloadStaticsData.getAdPosition(), 0);
            this.iEK = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void dZ(String str, String str2) {
        if (this.iEI == null) {
            this.iEI = new JSONObject();
        }
        try {
            this.iEI.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cfF() {
        if (this.iEL != null) {
            return this.iEL;
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
            jSONObject.put("origin_time", this.iEJ);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.iEK);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.iEM);
            jSONObject.put("ext3", this.iEO);
            jSONObject.put("ext2", this.iEN);
            jSONObject.put("da_ext1", this.iEP);
            jSONObject.put("da_ext2", this.iEQ);
            jSONObject.put("da_ext3", this.iER);
            jSONObject.put("da_ext4", this.iES);
            jSONObject.put("da_ext5", this.iET);
            jSONObject.put("da_menu1", this.iEV);
            jSONObject.put("da_menu2", this.iEW);
            jSONObject.put("da_menu3", this.iEX);
            jSONObject.put("da_page", this.iEY);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.iEU);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.iEZ);
        } catch (JSONException e) {
        }
        if (this.iEI != null) {
            try {
                jSONObject.put("ext", this.iEI);
            } catch (Exception e2) {
            }
        }
        this.iEL = jSONObject;
        return jSONObject;
    }

    public void Dj(String str) {
        this.iEV = str;
    }

    public void Dk(String str) {
        this.iEW = str;
    }

    public void Dl(String str) {
        this.iEX = str;
    }

    public void Dm(String str) {
        this.iEY = str;
    }

    public void Dn(String str) {
        this.iEZ = str;
    }
}
