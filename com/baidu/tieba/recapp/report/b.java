package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private DownloadStaticsData downloadStaticsData;
    private String extInfo;
    private JSONObject iEJ;
    private String iEL;
    private JSONObject iEM;
    private int iEN;
    private String iEO;
    private int iEP;
    private int iEQ;
    private int iER;
    private int iES;
    private int iET;
    private int iEU;
    private String iEV;
    private String iEW;
    private String iEX;
    private String iEY;
    private String iEZ;
    private String iFa;
    private String placeId;
    private int Sa = -1;
    private int Sc = -1;
    private int pageNumber = -1;
    private long iEK = System.currentTimeMillis() / 1000;

    public void Dg(String str) {
        this.extInfo = str;
    }

    public void yZ(int i) {
        this.Sa = i;
        if (this.iEM != null) {
            try {
                this.iEM.put("da_type", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void za(int i) {
        this.Sc = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void Dh(String str) {
        this.placeId = str;
    }

    public void Di(String str) {
        this.iEL = str;
    }

    public void Dj(String str) {
    }

    public void zb(int i) {
        this.iEQ = i;
    }

    public void zc(int i) {
        this.iER = i;
    }

    public void zd(int i) {
        this.iES = i;
    }

    public void ze(int i) {
        this.iET = i;
    }

    public void zf(int i) {
        this.iEU = i;
    }

    public void Dk(String str) {
        this.iEV = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.Sc = com.baidu.adp.lib.g.b.f(downloadStaticsData.getAdPosition(), 0);
            this.iEL = downloadStaticsData.getPrice();
            this.extInfo = downloadStaticsData.getExtensionInfo();
        }
    }

    public void dZ(String str, String str2) {
        if (this.iEJ == null) {
            this.iEJ = new JSONObject();
        }
        try {
            this.iEJ.put(str, str2);
        } catch (Exception e) {
        }
    }

    public JSONObject cfG() {
        if (this.iEM != null) {
            return this.iEM;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.Sc != -1) {
                jSONObject.put("da_locate", this.Sc);
            }
            if (this.Sa != -1) {
                jSONObject.put("da_type", this.Sa);
            }
            jSONObject.put("extra_param", this.extInfo);
            jSONObject.put("origin_time", this.iEK);
            if (this.pageNumber != -1) {
                jSONObject.put("da_page_num", this.pageNumber);
            }
            jSONObject.put("da_price", this.iEL);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.iEN);
            jSONObject.put("ext3", this.iEP);
            jSONObject.put("ext2", this.iEO);
            jSONObject.put("da_ext1", this.iEQ);
            jSONObject.put("da_ext2", this.iER);
            jSONObject.put("da_ext3", this.iES);
            jSONObject.put("da_ext4", this.iET);
            jSONObject.put("da_ext5", this.iEU);
            jSONObject.put("da_menu1", this.iEW);
            jSONObject.put("da_menu2", this.iEX);
            jSONObject.put("da_menu3", this.iEY);
            jSONObject.put("da_page", this.iEZ);
            jSONObject.put("place_id", this.placeId);
            jSONObject.put("lego_extra", this.iEV);
            if (this.downloadStaticsData != null) {
                jSONObject.put("da_range", this.downloadStaticsData.getDa_range());
                jSONObject.put("da_range_nt", this.downloadStaticsData.getDa_range_nt());
                jSONObject.put("da_page", this.downloadStaticsData.getDa_page());
                jSONObject.put("da_menu3", this.downloadStaticsData.getFid());
                jSONObject.put("apk_name", this.downloadStaticsData.getApk_name());
            }
            jSONObject.put("da_area", this.iFa);
        } catch (JSONException e) {
        }
        if (this.iEJ != null) {
            try {
                jSONObject.put("ext", this.iEJ);
            } catch (Exception e2) {
            }
        }
        this.iEM = jSONObject;
        return jSONObject;
    }

    public void Dl(String str) {
        this.iEW = str;
    }

    public void Dm(String str) {
        this.iEX = str;
    }

    public void Dn(String str) {
        this.iEY = str;
    }

    public void Do(String str) {
        this.iEZ = str;
    }

    public void Dp(String str) {
        this.iFa = str;
    }
}
